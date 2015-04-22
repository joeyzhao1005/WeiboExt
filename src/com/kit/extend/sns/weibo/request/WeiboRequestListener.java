package com.kit.extend.sns.weibo.request;

import android.content.Context;

import com.kit.extend.sns.weibo.request.OnCompleteListener;
import com.kit.extend.weibo.R;
import com.kit.utils.StringUtils;
import com.kit.utils.ZogUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.models.ErrorInfo;

/**
 * Created by Zhao on 14-10-4.
 */
public class WeiboRequestListener implements RequestListener {

    /**
     * 是否显示提示语等
     */

    public Context context;
    public OnCompleteListener onCompleteListener;
    public ErrorInfo errorInfo;

    //    public boolean isShowTips;
//    public String type;
    public WeiboRequestListener() {
    }

    public WeiboRequestListener(Context context) {
        this.context = context;
    }

    public WeiboRequestListener(Context context,
                                OnCompleteListener onCompleteListener) {
        this.context = context;
        this.onCompleteListener = onCompleteListener;
//        this.type = onCompleteListener.type;
//        this.isShowTips = onCompleteListener.isShowTips;


    }

    @Override
    public void onComplete(String response) {
//        LogUtils.printLog(WeiboRequestListener.class, "response:" + response);
        if (onCompleteListener != null)
            onCompleteListener.onComplete(response);

    }

    @Override
    public void onWeiboException(WeiboException e) {
        ZogUtils.printLog(WeiboRequestListener.class, e.getMessage());
        errorInfo = ErrorInfo.parse(e.getMessage());

        if (errorInfo != null && !StringUtils.isEmptyOrNullOrNullStr(errorInfo.error)) {
            ZogUtils.printLog(WeiboRequestListener.class, "WeiboException:" + errorInfo.toString());
//            Toast.makeText(context, info.toString(), Toast.LENGTH_LONG).show();
        } else {
            ZogUtils.printLog(WeiboRequestListener.class, "context:" + context);

            if (context != null) {
                errorInfo = new ErrorInfo();
                errorInfo.error = context.getString(R.string.fmt_iap_err);
            }
        }

        if (onCompleteListener != null)
            onCompleteListener.onException(e);

    }


}
