package com.kit.extend.sns.weibo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.kit.utils.ListUtils;
import com.kit.utils.StringUtils;
import com.kit.utils.log.ZogUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.models.ErrorInfo;
import com.sina.weibo.sdk.openapi.models.Status;
import com.sina.weibo.sdk.openapi.models.StatusList;
import com.sina.weibo.sdk.openapi.models.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhao on 14-8-17.
 */
public class WeiboKit {

    public static RequestListener getRequestListener(final Context mContext) {

        /**
         * 微博 OpenAPI 回调接口。
         */
        RequestListener mListener = new RequestListener() {
            @Override
            public void onComplete(String response) {
                Log.i(WeiboConstant.LOG_TAG_SINA_WEIBO, response.toString());
                if (!TextUtils.isEmpty(response)) {
                    // LogUtils.i(getClass(), response.toString());
                    if (response.startsWith("{\"statuses\"")) {
                        // 调用 StatusList#parse 解析字符串成微博列表对象
                        StatusList statuses = StatusList.parse(response);
                        if (statuses != null && statuses.total_number > 0) {

                            ZogUtils.i(
                                    "获取微博信息流成功, 条数: " + statuses.statusList.size());

                        }
                    } else if (response.startsWith("{\"created_at\"")) {
                        // 调用 Status#parse 解析字符串成微博对象
                        Status status = Status.parse(response);
                        ZogUtils.i(
                                "发送一送微博成功, id = " + status.id);
                        Toast.makeText(mContext,
                                "发送微博成功",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(mContext, response, Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                //LogUtils.showException(e);
                ErrorInfo info = ErrorInfo.parse(e.getMessage());
                Toast.makeText(mContext, info.toString(), Toast.LENGTH_LONG).show();
            }
        };
        return mListener;
    }


    /**
     * 把@人的微博昵称置换为屏显名字，微博只认屏显名
     *
     * @param users
     * @param str
     * @return
     */
    public static String getScreenContent(ArrayList<User> users, String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return "";
        }

        Pattern pattern = Pattern.compile(WeiboConfig.patternUserStr);
        Matcher m = pattern.matcher(str);

        int start = 0;
        int end = 0;
        String findText;
        ArrayList<String> strs = new ArrayList<String>();

        while (m.find()) {
            start = m.start();
            end = m.end();

            findText = str.substring(start + 1, end);
            strs.add(findText);
//            LogUtils.i(WeiboKit.class, "start:" + start + " end:" + end + "findText:" + findText);

        }

        strs = (ArrayList<String>) ListUtils.removeDuplicate(strs, null);
        if (!ListUtils.isNullOrContainEmpty(strs)) {
            for (String string : strs) {

                String s = replaceScreenShow(users, string);
                str = str.replaceAll(string, s);
                //  tempStrs.add(s);
            }
        }
        return str;
    }


    /**
     * 把@人的微博昵称置换为屏显名字，微博只认屏显名
     *
     * @param users
     * @param remark
     * @return
     */
    private static String replaceScreenShow(ArrayList<User> users, String remark) {
        ZogUtils.i("remark:" + remark);

        for (User u : users) {
            if (u.remark.equals(remark)) {
                return u.screen_name;
            }
        }

        return remark;
    }
}
