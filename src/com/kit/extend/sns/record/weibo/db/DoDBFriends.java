package com.kit.extend.sns.record.weibo.db;

import android.content.Context;
import android.database.Cursor;

import com.kit.extend.sns.weibo.core.Comparator4FriendsById;
import com.kit.utils.ListUtils;
import com.kit.utils.log.ZogUtils;
import com.sina.weibo.sdk.openapi.models.Status;
import com.sina.weibo.sdk.openapi.models.StatusList;
import com.sina.weibo.sdk.openapi.models.User;
import com.sina.weibo.sdk.openapi.models.UserWapper;

import java.util.ArrayList;
import java.util.List;


public class DoDBFriends {

    public static User getDataFromLocalById(Context context, String userId) {
        DBFriends dbFriends = new DBFriends(context);
        User user = dbFriends.selectByIdReturnUser(userId);
        return user;
    }

    public static ArrayList<User> getUsersDataFromLocal(Context context) {

        ArrayList<User> userList = new ArrayList<User>();

        DBFriends dbFriends = new DBFriends(context);
        dbFriends.open();

        Cursor c = dbFriends.selectAllOrderBy(DBFriends.FIELD_USERID, "asc");

        while (c.moveToNext()) {

            User user = new User();
            long userid = c.getLong(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_USERID));
            String screenName = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_SCREENNAME));
            String name = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_NAME));
            int province = c.getInt(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_PROVINCE));
            int city = c.getInt(c.getColumnIndexOrThrow(DBFriends.FIELD_CITY));
            String location = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_LOCATION));
            String description = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_DESCRIPTION));
            String url = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_URL));
            String profileImageUrl = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_PROFILEIMAGEURL));
            String userDomain = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_USERDOMAIN));
            String gender = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_GENDER));
            int followersCount = c.getInt(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_FOLLOWERSCOUNT));
            int friendsCount = c.getInt(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_FRIENDSCOUNT));
            int statusesCount = c.getInt(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_STATUSESCOUNT));
            int favouritesCount = c.getInt(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_FAVOURITESCOUNT));
            String createdAt = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_CREATEDAT));
            String following = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_FOLLOWING));
            String verified = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_VERIFIED));
            int verifiedType = c.getInt(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_VERIFIEDTYPE));
            String allowAllActMsg = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_ALLOWALLACTMSG));
            String allowAllComment = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_ALLOWALLCOMMENT));
            String followMe = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_FOLLOWME));
            String avatarLarge = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_AVATARLARGE));
            int onlineStatus = c.getInt(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_ONLINESTATUS));
            long newestStatusID = c.getLong(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_NEWESTSTATUSID));
            int biFollowersCount = c.getInt(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_BIFOLLOWERSCOUNT));
            String remark = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_REMARK));
            String lang = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_LANG));
            String verifiedReason = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_VERIFIEDREASON));
            String weihao = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_WEIHAO));
            String statusId = c.getString(c
                    .getColumnIndexOrThrow(DBFriends.FIELD_STATUSID));

            user.id = (userid + "");
            user.screen_name = (screenName);
            user.name = (name);
            user.province = (province);
            user.city = (city);
            user.location = (location);
            user.description = (description);
            user.url = (url);
            user.profile_image_url = (profileImageUrl);
            user.domain = (userDomain);
            user.gender = (gender);
            user.followers_count = (followersCount);
            user.friends_count = (friendsCount);
            user.statuses_count = (statusesCount);
            user.favourites_count = (favouritesCount);
            user.created_at = (createdAt);
            user.following = (following.equals("true") ? true : false);
            user.verified = (verified.equals("true") ? true : false);
            user.verified_type = (verifiedType);
            user.allow_all_act_msg = (allowAllActMsg.equals("true") ? true : false);
            user.allow_all_comment = (allowAllComment.equals("true") ? true
                    : false);
            user.follow_me = (followMe.equals("true") ? true : false);
            user.avatar_large = (avatarLarge);
            user.online_status = (onlineStatus);
            Status s1 = new Status();
            s1.id = (newestStatusID + "");
            user.status = (s1);
            user.bi_followers_count = (biFollowersCount);
            user.remark = (remark);
            user.lang = (lang);
            user.verified_reason = (verifiedReason);
            user.weihao = (weihao);
            //user.setStatusId(statusId);

            userList.add(user);
        }
        c.close();
        dbFriends.closeConnection();


        ZogUtils.i( "userList.size:" + userList.size());
        return userList;
    }

    public static int initDataToLocal(Context context, List<User> list) {

        DBFriends dbFriends = new DBFriends(context.getApplicationContext());
        dbFriends.open();

        boolean isDone = false;
        isDone = dbFriends.insert(list);
        dbFriends.closeConnection();

        ZogUtils.i( "initDataToLocal isDone:" + isDone);

        if (isDone) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * 从微博列表页获取用户,并储存到用户表
     *
     * @param context
     * @param statusList
     * @return
     */
    public static int initDataToLocalFromStatus(Context context, StatusList statusList) {

        ArrayList<User> dbList = getUsersDataFromLocal(context);
        ZogUtils.i( "dbList.size:" + dbList.size());


        DBFriends dbFriends = new DBFriends(context.getApplicationContext());
        dbFriends.open();

        ArrayList<User> statusUserList = new ArrayList<User>();

        ArrayList<User> insertList = new ArrayList<User>();
        ArrayList<User> updateList = new ArrayList<User>();
        for (Status status : statusList.statusList) {

            statusUserList.add(status.user);
        }

        for (User user : statusUserList) {

            if (ListUtils.isContain(dbList, user, new Comparator4FriendsById())) {//已有，则更新
                updateList.add(user);
            } else {//没有新的，那就插入
                insertList.add(user);
            }
        }

        insertList = (ArrayList<User>) ListUtils.removeDuplicate(insertList, new Comparator4FriendsById());
        updateList = (ArrayList<User>) ListUtils.removeDuplicate(updateList, new Comparator4FriendsById());


        boolean isDone, isDone2;
        if (insertList != null) {
            isDone = dbFriends.insert(insertList);
        } else {
            isDone = true;
        }
        if (updateList != null) {
            isDone2 = dbFriends.update(updateList);
        } else {
            isDone2 = true;
        }

        dbFriends.closeConnection();

        ZogUtils.i( "initDataToLocalFromStatus isDone:" + isDone + " isDone2:" + isDone2);

        if (isDone && isDone2) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * 数据库中重复的更新，数据库中没有的更新
     *
     * @param context
     * @return
     */
    public static int initDataToLocalRemoveDuplicate(Context context, UserWapper userList) {

        ArrayList<User> dbList = getUsersDataFromLocal(context);

        DBFriends dbFriends = new DBFriends(context.getApplicationContext());
        dbFriends.open();


        ArrayList<User> insertList = new ArrayList<User>();
        ArrayList<User> updateList = new ArrayList<User>();

        for (User user : userList.getUsers()) {

            ZogUtils.i( "user.id:" + user.id);
            if (ListUtils.isContain(dbList, user, new Comparator4FriendsById())) {//已有，则更新
                updateList.add(user);
            } else {//没有新的，那就插入
                insertList.add(user);
            }
        }


        insertList = (ArrayList<User>) ListUtils.removeDuplicate(insertList, new Comparator4FriendsById());
        updateList = (ArrayList<User>) ListUtils.removeDuplicate(updateList, new Comparator4FriendsById());


        boolean isDone, isDone2;
        if (insertList != null) {
            ZogUtils.i( "initDataToLocalRemoveDuplicate insertList:" + insertList.size());

            isDone = dbFriends.insert(insertList);
        } else {
            isDone = true;
        }
        if (updateList != null) {
            ZogUtils.i( "initDataToLocalRemoveDuplicate " + "updateList:" + updateList.size());

            isDone2 = dbFriends.update(updateList);
        } else {
            isDone2 = true;
        }

        dbFriends.closeConnection();

        ZogUtils.i( "initDataToLocalRemoveDuplicate isDone:" + isDone + " isDone2:" + isDone2);

        if (isDone && isDone2) {
            return 1;
        } else {
            return 0;
        }

    }


    public static int getCount(Context context) {
        DBFriends dbFriends = new DBFriends(context.getApplicationContext());
        dbFriends.open();

        int i = dbFriends.getCount();

        dbFriends.closeConnection();
        return i;
    }

    public static void clean(Context context) {
        DBFriends dbFriends = new DBFriends(context);
        dbFriends.open();
        try {
            dbFriends.clean();
        } catch (Exception e) {
            ZogUtils.showException(e);
        }
        dbFriends.closeConnection();
    }
}
