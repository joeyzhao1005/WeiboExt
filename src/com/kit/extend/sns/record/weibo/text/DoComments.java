package com.kit.extend.sns.record.weibo.text;

import com.google.gson.Gson;
import com.kit.app.enums.CharsetName;
import com.kit.utils.TextUtils;
import com.sina.weibo.sdk.openapi.models.CommentList;

/**
 * Created by Zhao on 14-10-13.
 */
public class DoComments {
    private static DoComments instance;
    private static String FILE_NAME;

    public static DoComments newInstance(String filename) {

        FILE_NAME = filename;

        if (null == instance) {
            instance = new DoComments();
        }
        return instance;
    }

    /**
     * 保存评论
     *
     * @param commentList
     */
    public void saveCommentList(CommentList commentList) {

        Gson gson = new Gson();

        String str = gson.toJson(commentList);
        TextUtils.writeStr2File(str, FILE_NAME, "UTF-8");

    }

    /**
     * 获取评论
     *
     * @return
     */
    public CommentList getCommentList() {

        String str = TextUtils.readTxtFromLocal(FILE_NAME, CharsetName.UTF_8);

        Gson gson = new Gson();
        CommentList commentList = gson.fromJson(str, CommentList.class);

        return commentList;
    }

}
