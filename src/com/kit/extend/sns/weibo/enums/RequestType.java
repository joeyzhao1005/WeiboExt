package com.kit.extend.sns.weibo.enums;

/**
 * Created by Zhao on 14/10/27.
 */
public class RequestType {

    /**
     * 删除收藏微博
     */
    public  static final String STATUS_DESTORY = "STATUS_DESTORY";


    /**
     * 读取好友时间线
     */
    public  static final String FRIENDS_TIME_LINE = "FRIENDS_TIME_LINE";


    /**
     * 读取单条微博
     */
    public  static final String STATUS_SHOW = "STATUS_SHOW";


    /**
     * 创建收藏微博
     */
    public  static final String FAVORITES_CREATE = "FAVORITES_CREATE";

    /**
     * 删除收藏微博
     */
    public  static final String FAVORITES_DESTORY = "FAVORITES_DESTORY";

    /**
     * 创建评论微博
     */
    public  static final String COMMENTS_CREATE = "COMMENTS_CREATE";

    /**
     * 创建评论微博
     */
    public  static final String REPOST_CREATE = "REPOST_CREATE";

    /**
     * 回复微博评论
     */
    public  static final String COMMENT_REPLY = "COMMENT_REPLY";

    /**
     * 回复微博评论
     */
    public  static final String COMMENT_DESTROY = "COMMENT_DESTROY";


    /**
     * 32个赞评论创建
     */
    public  static final String COMMENT_32_LIKE_CREATE = "COMMENT_32_LIKE_CREATE";


    /**
     * 32个赞评论销毁
     */
    public  static final String COMMENT_32_LIKE_DESTORY = "COMMENT_32_LIKE_DESTORY";


}
