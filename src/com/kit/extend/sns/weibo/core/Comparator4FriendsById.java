package com.kit.extend.sns.weibo.core;

import com.sina.weibo.sdk.openapi.models.User;

import java.util.Comparator;

/**
 * 拼音比较器
 */
public class Comparator4FriendsById implements Comparator<User> {
    public int compare(User o1, User o2) {
        if (o1.id == o2.id) {
            return 0;
        } else {
            return 1;
        }
    }
}