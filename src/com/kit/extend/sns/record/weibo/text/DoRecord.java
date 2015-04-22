package com.kit.extend.sns.record.weibo.text;

import com.google.gson.Gson;
import com.kit.app.enums.CharsetName;
import com.kit.utils.TextUtils;

/**
 * Created by Zhao on 14-10-13.
 */
public class DoRecord {
    private static DoRecord instance;
    private static String FILE_NAME;
    private Class clazz;

    public static DoRecord newInstance(String filename) {

        FILE_NAME = filename;

        if (null == instance) {
            instance = new DoRecord();
        }
        return instance;
    }

    /**
     * 保存评论
     *
     * @param commentList
     */
    public void saveData(Object commentList, Class clazz) {
        this.clazz = clazz;

        Gson gson = new Gson();
        String str = gson.toJson(commentList);
        TextUtils.writeStr2File(str, FILE_NAME, "UTF-8");

    }

    /**
     * 获取评论
     *
     * @return
     */
    public Object getData( Class clazz) {

        String str = TextUtils.readTxtFromLocal(FILE_NAME, CharsetName.UTF_8);

        Gson gson = new Gson();
        Object commentList = gson.fromJson(str, clazz);

        return commentList;
    }

}
