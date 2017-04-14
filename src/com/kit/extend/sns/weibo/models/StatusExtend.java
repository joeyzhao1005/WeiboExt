package com.kit.extend.sns.weibo.models;

import com.google.gson.reflect.TypeToken;
import com.kit.extend.sns.utils.GsonUtils;
import com.sina.weibo.sdk.openapi.models.Comment;
import com.sina.weibo.sdk.openapi.models.Status;

import java.util.ArrayList;

/**
 * Created by Zhao on 15/4/10.
 */
public class StatusExtend extends Status {
    public Comment comment32Like;
    public Comment historyComment32Like;

    public static ArrayList<StatusExtend> toStatusExtends(ArrayList<Status> statusList) {

        String strJson = GsonUtils.toJson(statusList);


        ArrayList<StatusExtend> statusExtends =  GsonUtils.getArrayList(strJson,
                new TypeToken<ArrayList<StatusExtend>>() {
                }.getType());
//        for (Status status : statusList) {
//
//
//            StatusExtend statusExtend = GsonUtils.getObj();
//            statusExtends.add(statusExtend);
//        }

        return statusExtends;
    }
}
