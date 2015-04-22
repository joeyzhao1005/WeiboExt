/*
 * UserObjectWapper.java created on 2010-7-28 上午08:48:35 by bwl (Liu Daoru)
 */

package com.sina.weibo.sdk.openapi.models;

import com.sina.weibo.sdk.exception.WeiboException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 对User对象列表进行的包装，以支持cursor相关信息传递
 *
 * @author sinaWeibo
 */
public class UserWapper implements Serializable {

    private static final long serialVersionUID = -3119107701303920284L;

    /**
     * 用户对象列表
     */
    private ArrayList<User> users;

    /**
     * 向前翻页的cursor
     */
    private long previousCursor;

    /**
     * 向后翻页的cursor
     */
    private long nextCursor;

    private long totalNumber;

    private String hasvisible;


    public UserWapper() {
    }

    public UserWapper(ArrayList<User> users, long previousCursor, long nextCursor, long totalNumber, String hasvisible) {
        this.users = users;
        this.previousCursor = previousCursor;
        this.nextCursor = nextCursor;
        this.totalNumber = totalNumber;
        this.hasvisible = hasvisible;
    }

    /**
     * @param res
     * @return
     * @throws WeiboException
     * @throws JSONException
     */
    public static UserWapper parse(String res) throws WeiboException, JSONException {
        JSONObject jsonUsers = new JSONObject(res); //asJSONArray();
        try {
            JSONArray user = jsonUsers.getJSONArray("users");
            int size = user.length();
            ArrayList<User> users = new ArrayList<User>(size);
            for (int i = 0; i < size; i++) {
                users.add(User.parse(user.getJSONObject(i)));
            }
            long previousCursor = jsonUsers.getLong("previous_cursor");
            long nextCursor = jsonUsers.getLong("next_cursor");
            long totalNumber = jsonUsers.getLong("total_number");
            String hasvisible = "true";
            try {
                hasvisible = jsonUsers.getString("hasvisible");
            } catch (Exception e) {
//                LogUtils.showException(e);
            }
            return new UserWapper(users, previousCursor, nextCursor, totalNumber, hasvisible);
        } catch (JSONException jsone) {
            throw new WeiboException(jsone);
        }
    }


    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public long getPreviousCursor() {
        return previousCursor;
    }

    public void setPreviousCursor(long previousCursor) {
        this.previousCursor = previousCursor;
    }

    public long getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(long nextCursor) {
        this.nextCursor = nextCursor;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getHasvisible() {
        return hasvisible;
    }

    public void setHasvisible(String hasvisible) {
        this.hasvisible = hasvisible;
    }

}
