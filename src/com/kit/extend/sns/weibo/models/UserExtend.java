package com.kit.extend.sns.weibo.models;

import com.google.gson.reflect.TypeToken;
import com.kit.extend.sns.utils.GsonUtils;
import com.sina.weibo.sdk.openapi.models.User;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by Zhao on 15/4/11.
 */
public class UserExtend extends User implements Serializable {

    public static ArrayList<UserExtend> toUserExtends(ArrayList<User> statusList) {

        String strJson = GsonUtils.toJson(statusList);


        ArrayList<UserExtend> statusExtends = GsonUtils.getArrayList(strJson,
                new TypeToken<ArrayList<UserExtend>>() {
                }.getType());
//        for (Status status : statusList) {
//
//
//            UserExtend statusExtend = GsonUtils.getObj();
//            statusExtends.add(statusExtend);
//        }

        return statusExtends;
    }
}
