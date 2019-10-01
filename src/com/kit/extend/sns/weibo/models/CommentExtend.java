//package com.kit.extend.sns.weibo.models;
//
//import com.google.gson.reflect.TypeToken;
//import com.kit.utils.GsonUtils;
//import com.sina.weibo.sdk.openapi.models.Comment;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//
///**
// * Created by Zhao on 15/4/11.
// */
//public class Comment  extends Comment implements Serializable{
//    public static ArrayList<Comment> toStatusExtends(ArrayList<Comment> statusList) {
//
//        String strJson = GsonUtils.toJson(statusList);
//
//
//        ArrayList<Comment> statusExtends = (ArrayList<Comment>) GsonUtils.getList(strJson,
//                new TypeToken<ArrayList<Comment>>() {
//                }.getType());
////        for (Status status : statusList) {
////
////
////            Comment statusExtend = GsonUtils.getObj();
////            statusExtends.add(statusExtend);
////        }
//
//        return statusExtends;
//    }
//}
