//package com.kit.extend.weibo;
//
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.widget.Toast;
//
//import com.sina.weibo.sdk.auth.Oauth2AccessToken;
//import com.sina.weibo.sdk.auth.WeiboAuthListener;
//import com.sina.weibo.sdk.exception.WeiboException;
//
//import java.text.SimpleDateFormat;
//
///**
// * 微博认证授权回调类。
// * 1. SSO 授权时，需要在 {@link #onActivityResult} 中调用 {@link SsoHandler#authorizeCallBack} 后，
// * 该回调才会被执行。
// * 2. 非 SSO 授权时，当授权结束后，该回调就会被执行。
// * 当授权成功后，请保存该 access_token、expires_in、uid 等信息到 SharedPreferences 中。
// */
//public class AuthListener implements WeiboAuthListener {
//
//    /**
//     * 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能
//     */
//    private Oauth2AccessToken mAccessToken;
//
//    @Override
//    public void onComplete(Bundle values) {
//        // 从 Bundle 中解析 Token
//        mAccessToken = Oauth2AccessToken.parseAccessToken(values);
//        if (mAccessToken.isSessionValid()) {
//            // 显示 Token
//            updateTokenView(false);
//
//            // 保存 Token 到 SharedPreferences
//            AccessTokenKeeper.writeAccessToken(WBAuthActivity.this, mAccessToken);
//            Toast.makeText(WBAuthActivity.this,
//                    R.string.weibosdk_demo_toast_auth_success, Toast.LENGTH_SHORT).show();
//        } else {
//            // 以下几种情况，您会收到 Code：
//            // 1. 当您未在平台上注册的应用程序的包名与签名时；
//            // 2. 当您注册的应用程序包名与签名不正确时；
//            // 3. 当您在平台上注册的包名和签名与您当前测试的应用的包名和签名不匹配时。
//            String code = values.getString("code");
//            String message = getString(R.string.weibosdk_demo_toast_auth_failed);
//            if (!TextUtils.isEmpty(code)) {
//                message = message + "\nObtained the code: " + code;
//            }
//            Toast.makeText(WBAuthActivity.this, message, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onCancel() {
//        Toast.makeText(WBAuthActivity.this,
//                R.string.weibosdk_demo_toast_auth_canceled, Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onWeiboException(WeiboException e) {
//        Toast.makeText(WBAuthActivity.this,
//                "Auth exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
//    }
//
//
//    /**
//     * 显示当前 Token 信息。
//     *
//     * @param hasExisted 配置文件中是否已存在 token 信息并且合法
//     */
//    private void updateTokenView(boolean hasExisted) {
//        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(
//                new java.util.Date(mAccessToken.getExpiresTime()));
//        String format = getString(R.string.weibosdk_demo_token_to_string_format_1);
//        mTokenText.setText(String.format(format, mAccessToken.getToken(), date));
//
//        String message = String.format(format, mAccessToken.getToken(), date);
//        if (hasExisted) {
//            message = getString(R.string.weibosdk_demo_token_has_existed) + "\n" + message;
//        }
//        mTokenText.setText(message);
//    }
//}