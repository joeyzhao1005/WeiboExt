package com.kit.extend.sns.record.weibo.db;

import android.content.Context;

import com.sina.weibo.sdk.openapi.models.StatusList;
import com.sina.weibo.sdk.openapi.models.User;


public class DoDBUser {

    public static User getDataFromLocalById(Context context, String userId) {

        DBUser dbUser = new DBUser(context);

        User user = dbUser.selectByIdReturnUser(userId);

        return user;
    }

    @SuppressWarnings("unused")
    public static int initDataToLocal(Context context, StatusList statusList) {


        DBUser dbUser = new DBUser(context.getApplicationContext());
        dbUser.open();
        dbUser.clean();

        boolean isDone = false;
//		isDone = dbStatus.insert(statusWapper);
//		dbStatus.closeConnection();
        // msg = "更新联系人成功";
        // ToastUtils.mkShortTimeToast( msg);
        if (isDone) {
            return 1;
        } else {
            return 0;
        }

    }

}
