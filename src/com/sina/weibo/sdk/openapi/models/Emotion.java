package com.sina.weibo.sdk.openapi.models;

import java.io.Serializable;

/**
 * Created by Zhao on 14/11/8.
 */
public class Emotion implements Serializable{

//    "category": "休闲",
//            "common": true,
//            "hot": false,
//            "icon": "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/eb/smile.gif",
//            "phrase": "[呵呵]",
//            "picid": null,
//            "type": "face",
//            "url": "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/eb/smile.gif",
//            "value": "[呵呵]"

    /**
     * 表情所属类别
     */
    public String category;

    public boolean common;
    public boolean hot;

    /**
     * 图标网址
     */
    public String icon;

    /**
     * 表达式
     */
    public String phrase;
    public String picid;

    /**
     * 图片所属类别 如:face
     */
    public String type;

    /**
     * 图片url
     */
    public String url;

    /**
     * 值
     */
    public String value;
}
