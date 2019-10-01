package com.kit.extend.sns.record.weibo.text;

import com.google.gson.Gson;
import com.kit.extend.sns.utils.TextUtils;
import com.sina.weibo.sdk.openapi.models.StatusList;

/**
 * 保存微博到文件
 *
 * Created by Zhao on 14-10-13.
 */
public class DoStatus {
    private static DoStatus instance;
    private static String FILE_NAME;

    public static DoStatus newInstance(String filename) {

        FILE_NAME = filename;

        if (null == instance) {
            instance = new DoStatus();
        }
        return instance;
    }

    /**
     * 保存评论
     *
     * @param commentList
     */
    public void saveStatusList(StatusList commentList) {

        Gson gson = new Gson();

        String str = gson.toJson(commentList);
        TextUtils.writeStr2File(str, FILE_NAME, "UTF-8");

    }

    /**
     * 获取评论
     *
     * @return
     */
    public StatusList getStatusList() {

        String str = TextUtils.readTxtFromLocal(FILE_NAME, "UTF_8");

        Gson gson = new Gson();
        StatusList commentList = gson.fromJson(str, StatusList.class);

        return commentList;
    }

}
