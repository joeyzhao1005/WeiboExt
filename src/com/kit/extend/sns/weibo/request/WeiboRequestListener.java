package com.kit.extend.sns.weibo.request;

import android.content.Context;
import android.util.Log;

import com.kit.extend.sns.utils.StringUtils;
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
    public OnDoneListener onDoneListener;
    public ErrorInfo errorInfo;

    //    public boolean isShowTips;
//    public String type;
//    public WeiboRequestListener() {
//    }

    public WeiboRequestListener(Context context) {
        this.context = context;
    }

    public WeiboRequestListener(Context context,
                                OnDoneListener onDoneListener) {
        this.context = context;
        this.onDoneListener = onDoneListener;
//        this.type = onCompleteListener.type;
//        this.isShowTips = onCompleteListener.isShowTips;


    }

    @Override
    public void onComplete(String response) {
//        LogUtils.i(WeiboRequestListener.class, "response:" + response);
        if (onDoneListener != null)
            onDoneListener.onComplete(response);

    }

    @Override
    public void onWeiboException(WeiboException e) {
        Log.i("Zhao_APP", e.getMessage());
        errorInfo = ErrorInfo.parse(e.getMessage());

        if (errorInfo != null && !StringUtils.isEmptyOrNullStr(errorInfo.error)) {

//            switch (errorInfo.error_code){
//                case "20206":
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.weibo_error_20206));
//
//                    break;
//            }
            Log.i("Zhao_APP", "WeiboException:" + errorInfo.toString());
//            Toast.makeText(context, info.toString(), Toast.LENGTH_LONG).show();
        } else {
            Log.i("Zhao_APP", "context:" + context);

            if (context != null) {
                errorInfo = new ErrorInfo();
                errorInfo.error_code = "10010";
//                errorInfo.error = context.getString(R.string.fmt_iap_err);
            }
        }

        if (onDoneListener != null)
            onDoneListener.onException(e);

    }


}
