package com.kit.extend.sns.weibo.request;

import android.content.Context;
import android.util.Log;

import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.openapi.models.ErrorInfo;

public class OnDoneListener {
    /**
     * 是否显示异常提示
     */
    public boolean isShowExceptionTips;

    /**
     * 是否显示完成提示
     */
    public boolean isShowCompleteTips;
    public String type;


    public Context context;

    public ErrorInfo errorInfo;


    public OnDoneListener() {
    }

    public OnDoneListener(Context context) {
        this.context = context;
    }

    public OnDoneListener(Context context, String type, boolean isShowCompleteTips, boolean isShowExceptionTips) {
        this.context = context;
        this.type = type;
        this.isShowCompleteTips = isShowCompleteTips;
        this.isShowExceptionTips = isShowExceptionTips;
    }

    public void onComplete(String response) {

//        Log.i("Zhao_APP","response:" + response);
//
//        Log.i("Zhao_APP","onComplete type:" + type
//                + " isShowCompleteTips:" + isShowCompleteTips);
//
//        switch (type) {
//
//            case RequestType.STATUS_DESTORY:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.status_destory_ok));
//                break;
//            case RequestType.COMMENT_32_LIKE_CREATE:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.comment_32_like_create));
//                break;
//            case RequestType.COMMENT_32_LIKE_DESTORY:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.comment_32_like_destory));
//                break;
//            case RequestType.COMMENT_DESTROY:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.comment_destroy_ok));
//                break;
//            case RequestType.COMMENT_REPLY:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.comment_reply_ok));
//                break;
//            case RequestType.REPOST_CREATE:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.repost_ok));
//                break;
//            case RequestType.COMMENTS_CREATE:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.comment_ok));
//                break;
//            case RequestType.FAVORITES_CREATE:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.favorite_ok));
//                break;
//            case RequestType.FAVORITES_DESTORY:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.unfavorite_ok));
//                break;
//            case RequestType.STATUS_SHOW:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.status_show_ok));
//                break;
//
//            case RequestType.STATUS_CREATE:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.status_create_ok));
//                break;
//            case RequestType.FRIENDS_TIME_LINE:
//                if (isShowCompleteTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.friends_time_line_ok));
//                break;
//        }
    }

    public void onException(WeiboException e) {
        errorInfo = ErrorInfo.parse(e.getMessage());


        Log.i("Zhao_APP",
                "WeiboException type:" + type +
                        " isShowExceptionTips:" + isShowExceptionTips);


//        switch (type) {
//            case RequestType.STATUS_DESTORY:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.status_destory_fail));
//                break;
//            case RequestType.COMMENT_DESTROY:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.comment_destroy_fail));
//                break;
//            case RequestType.COMMENT_REPLY:
//                if (isShowExceptionTips) {
//                    if (errorInfo.error_code.equals("20206"))
//                        ToastUtils.mkLongTimeToast( context.getString(R.string.weibo_error_20206));
//                    else
//                        ToastUtils.mkLongTimeToast( context.getString(R.string.comment_reply_fail));
//                }
//                break;
//            case RequestType.REPOST_CREATE:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.repost_fail));
//                break;
//            case RequestType.COMMENTS_CREATE:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.comment_fail));
//                break;
//            case RequestType.FAVORITES_CREATE:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.favorite_fail));
//                break;
//            case RequestType.FAVORITES_DESTORY:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.unfavorite_fail));
//                break;
//            case RequestType.STATUS_SHOW:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.status_show_fail));
//                break;
//
//            case RequestType.STATUS_CREATE:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.status_create_fail));
//                break;
//            case RequestType.FRIENDS_TIME_LINE:
//                if (isShowExceptionTips)
//                    ToastUtils.mkLongTimeToast( context.getString(R.string.friends_time_line_fail));
//                break;
//        }
    }
}