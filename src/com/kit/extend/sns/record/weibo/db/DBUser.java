package com.kit.extend.sns.record.weibo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.sina.weibo.sdk.openapi.models.User;

import java.util.List;

public class DBUser extends DB {

    public final static String TABLE_NAME = "user";

    public final static String FIELD_USERID = "id";
    public final static String FIELD_SCREENNAME = "screenName";
    public final static String FIELD_NAME = "name";
    public final static String FIELD_PROVINCE = "province";
    public final static String FIELD_CITY = "city";
    public final static String FIELD_LOCATION = "location";
    public final static String FIELD_DESCRIPTION = "description";
    public final static String FIELD_URL = "url";
    public final static String FIELD_PROFILEIMAGEURL = "profileImageUrl";
    public final static String FIELD_USERDOMAIN = "userDomain";
    public final static String FIELD_GENDER = "gender";
    public final static String FIELD_FOLLOWERSCOUNT = "followersCount";
    public final static String FIELD_FRIENDSCOUNT = "friendsCount";
    public final static String FIELD_STATUSESCOUNT = "statusesCount";
    public final static String FIELD_FAVOURITESCOUNT = "favouritesCount";
    public final static String FIELD_CREATEDAT = "createdAt";
    public final static String FIELD_FOLLOWING = "following";
    public final static String FIELD_VERIFIED = "verified";
    public final static String FIELD_VERIFIEDTYPE = "verifiedType";
    public final static String FIELD_ALLOWALLACTMSG = "allowAllActMsg";
    public final static String FIELD_ALLOWALLCOMMENT = "allowAllComment";
    public final static String FIELD_FOLLOWME = "followMe";
    public final static String FIELD_AVATARLARGE = "avatarLarge";
    public final static String FIELD_ONLINESTATUS = "onlineStatus";
    public final static String FIELD_NEWESTSTATUSID = "newestStatusID";
    public final static String FIELD_BIFOLLOWERSCOUNT = "biFollowersCount";
    public final static String FIELD_REMARK = "remark";
    public final static String FIELD_LANG = "lang";
    public final static String FIELD_VERIFIEDREASON = "verifiedReason";
    public final static String FIELD_WEIHAO = "weihao";
    public final static String FIELD_STATUSID = "statusId";

    public static final String FIELD_ID = "_id";

    public DBUser(Context context) {

        super(context);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = " DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public Cursor selectAll() {
        // SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_NAME, null, null, null, null, null,
                FIELD_USERID + " desc");

        return cursor;
    }

    public Cursor selectAllOrderBy(String column, String order) {
        // SQLiteDatabase mDb =mDbhis.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_NAME, null, null, null, null, null,
                column + " " + order);

        return cursor;
    }

    public Cursor selectById(String id) {
        String where = FIELD_USERID + " =  '" + id + "'";

        // //System.out.println(where);

        Cursor cursor = mDb.query(TABLE_NAME, null, where, null, null, null,
                null);
        return cursor;
    }

    public User selectByIdReturnUser(String id) {
        // //System.out.println("selectByIdReturnUser userId:" + id);
        Cursor c = selectById(id);
        User user = new User();

        if (c.getCount() > 0 && c.moveToFirst()) {

            long userid = c.getLong(c
                    .getColumnIndexOrThrow(DBUser.FIELD_USERID));
            String screenName = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_SCREENNAME));
            String name = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_NAME));
            int province = c.getInt(c
                    .getColumnIndexOrThrow(DBUser.FIELD_PROVINCE));
            int city = c.getInt(c.getColumnIndexOrThrow(DBUser.FIELD_CITY));
            String location = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_LOCATION));
            String description = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_DESCRIPTION));
            String url = c.getString(c.getColumnIndexOrThrow(DBUser.FIELD_URL));
            String profileImageUrl = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_PROFILEIMAGEURL));
            String userDomain = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_USERDOMAIN));
            String gender = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_GENDER));
            int followersCount = c.getInt(c
                    .getColumnIndexOrThrow(DBUser.FIELD_FOLLOWERSCOUNT));
            int friendsCount = c.getInt(c
                    .getColumnIndexOrThrow(DBUser.FIELD_FRIENDSCOUNT));
            int statusesCount = c.getInt(c
                    .getColumnIndexOrThrow(DBUser.FIELD_STATUSESCOUNT));
            int favouritesCount = c.getInt(c
                    .getColumnIndexOrThrow(DBUser.FIELD_FAVOURITESCOUNT));
            String createdAt = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_CREATEDAT));
            String following = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_FOLLOWING));
            String verified = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_VERIFIED));
            int verifiedType = c.getInt(c
                    .getColumnIndexOrThrow(DBUser.FIELD_VERIFIEDTYPE));
            String allowAllActMsg = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_ALLOWALLACTMSG));
            String allowAllComment = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_ALLOWALLCOMMENT));
            String followMe = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_FOLLOWME));
            String avatarLarge = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_AVATARLARGE));
            int onlineStatus = c.getInt(c
                    .getColumnIndexOrThrow(DBUser.FIELD_ONLINESTATUS));
            String newestStatusID = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_NEWESTSTATUSID));
            int biFollowersCount = c.getInt(c
                    .getColumnIndexOrThrow(DBUser.FIELD_BIFOLLOWERSCOUNT));
            String remark = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_REMARK));
            String lang = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_LANG));
            String verifiedReason = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_VERIFIEDREASON));
            String weihao = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_WEIHAO));
            String statusId = c.getString(c
                    .getColumnIndexOrThrow(DBUser.FIELD_STATUSID));

            user.id = (userid) + "";
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
//			Status s1 = new Status();
//			s1.setId(newestStatusID);
//			user.setStatus(s1);
//			user.setBiFollowersCount(biFollowersCount);
//			user.setRemark(remark);
//			user.setLang(lang);
//			user.setVerifiedReason(verifiedReason);
//			user.setWeihao(weihao);
//			user.setStatusId(statusId);
        }
        c.close();
        return user;

    }

    public Boolean isExistById(String id) {

        String where = FIELD_USERID + " =  '" + id + "'";

        // //System.out.println(where);

        Cursor cursor = mDb.query(TABLE_NAME, null, where, null, null, null,
                null);
        // //System.out.println("cursor.getCount(): " + cursor.getCount());
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    public Cursor selectByName(String column, String str) {
        String where = " " + column + " = '" + str + "' ";
        // SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_NAME, null, where, null, null, null,
                FIELD_USERID + " desc");
        return cursor;
    }

    public boolean insert(List<User> list) {
        // 使用事务插入速度最快，使用基本sql语句次之 使用ContentValues最慢
        // long before = System.nanoTime();
        try {
            mDb.beginTransaction();
            for (User o : list) {

                ContentValues values = new ContentValues();

                values.put(DBUser.FIELD_USERID, o.id);
                values.put(DBUser.FIELD_SCREENNAME, o.screen_name);
                values.put(DBUser.FIELD_NAME, o.name);
                values.put(DBUser.FIELD_PROVINCE, o.province);
                values.put(DBUser.FIELD_CITY, o.city);
                values.put(DBUser.FIELD_LOCATION, o.location);
                values.put(DBUser.FIELD_DESCRIPTION, o.description);
                values.put(DBUser.FIELD_URL, o.url);
                values.put(DBUser.FIELD_PROFILEIMAGEURL, o.profile_image_url);
                values.put(DBUser.FIELD_USERDOMAIN, o.domain);
                values.put(DBUser.FIELD_GENDER, o.gender);
                values.put(DBUser.FIELD_FOLLOWERSCOUNT, o.followers_count);
                values.put(DBUser.FIELD_FRIENDSCOUNT, o.friends_count);
                values.put(DBUser.FIELD_STATUSESCOUNT, o.statuses_count);
                values.put(DBUser.FIELD_FAVOURITESCOUNT, o.favourites_count);
                values.put(DBUser.FIELD_CREATEDAT, o.created_at);
                values.put(DBUser.FIELD_FOLLOWING, o.following);
                values.put(DBUser.FIELD_VERIFIED, o.verified);
                values.put(DBUser.FIELD_VERIFIEDTYPE, o.verified_type);
                values.put(DBUser.FIELD_ALLOWALLACTMSG, o.allow_all_act_msg);
                values.put(DBUser.FIELD_ALLOWALLCOMMENT, o.allow_all_comment);
                values.put(DBUser.FIELD_FOLLOWME, o.follow_me);
                values.put(DBUser.FIELD_AVATARLARGE, o.avatar_large);
                values.put(DBUser.FIELD_ONLINESTATUS, o.online_status);
                values.put(DBUser.FIELD_NEWESTSTATUSID, o.status.id);
                values.put(DBUser.FIELD_BIFOLLOWERSCOUNT,
                        o.bi_followers_count);
                values.put(DBUser.FIELD_REMARK, o.remark);
                values.put(DBUser.FIELD_LANG, o.lang);
                values.put(DBUser.FIELD_VERIFIEDREASON, o.verified_reason);
                values.put(DBUser.FIELD_WEIHAO, o.weihao);
                //values.put(DBUser.FIELD_STATUSID, o.getStatusId());

                mDb.insert(TABLE_NAME, null, values);
            }
            mDb.setTransactionSuccessful();
            mDb.endTransaction();

            // long after = System.nanoTime();
            // long chazhi = after - before;
            // //System.out.println("after - before: " + chazhi);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public long insert(ContentValues initialValues) {

        return mDb.insert(TABLE_NAME, null, initialValues);
    }

    public boolean insertWithSQL(User o) {
        // 使用事务插入速度最快，使用基本sql语句次之 直接使用ContentValues最慢
        // 这个速度比insert(List<Contact> list)慢
        // long before = System.nanoTime();
        try {

            if (!isExistById(o.id + "")) {
                String sql = "insert into " + TABLE_NAME + "(" + FIELD_USERID
                        + "," + FIELD_SCREENNAME + "," + FIELD_NAME + ","
                        + FIELD_PROVINCE + "," + FIELD_CITY + ","
                        + FIELD_LOCATION + "," + FIELD_DESCRIPTION + ","
                        + FIELD_URL + "," + FIELD_PROFILEIMAGEURL + ","
                        + FIELD_USERDOMAIN + "," + FIELD_GENDER + ","
                        + FIELD_FOLLOWERSCOUNT + "," + FIELD_FRIENDSCOUNT + ","
                        + FIELD_STATUSESCOUNT + "," + FIELD_FAVOURITESCOUNT
                        + "," + FIELD_CREATEDAT + "," + FIELD_FOLLOWING + ","
                        + FIELD_VERIFIED + "," + FIELD_VERIFIEDTYPE + ","
                        + FIELD_ALLOWALLACTMSG + "," + FIELD_ALLOWALLCOMMENT
                        + "," + FIELD_FOLLOWME + "," + FIELD_AVATARLARGE + ","
                        + FIELD_ONLINESTATUS + "," + FIELD_NEWESTSTATUSID + ","
                        + FIELD_BIFOLLOWERSCOUNT + "," + FIELD_REMARK + ","
                        + FIELD_LANG + "," + FIELD_VERIFIEDREASON + ","
                        + FIELD_WEIHAO + ")" + " values('" + o.id
                        + "','" + o.screen_name + "','" + o.name
                        + "','" + o.province + "','" + o.city + "','"
                        + o.location + "','" + o.description + "','"
                        + o.url + "','" + o.profile_image_url + "','"
                        + o.domain + "','" + o.gender + "','"
                        + o.followers_count + "','" + o.friends_count
                        + "','" + o.statuses_count + "','"
                        + o.favourites_count + "','" + o.created_at
                        + "','" + o.following + "','" + o.verified
                        + "','" + o.verified_type + "','"
                        + o.allow_all_act_msg + "','" + o.allow_all_comment
                        + "','" + o.follow_me + "','" + o.avatar_large
                        + "','" + o.online_status + "','"
                        + (o.status != null ? o.status.id : "")
                        + "','" + o.bi_followers_count + "','"
                        + o.remark + "','" + o.lang + "','"
                        + o.verified_reason + "','" + o.weihao + "')";
                // //System.out.println("insert sql: " + sql);
                mDb.execSQL(sql);

                // long after = System.nanoTime();
                // long chazhi = after - before;
                // //System.out.println("after - before: " + chazhi);

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public int update(int id) {
        // SQLiteDatabase mDb = this.getWritableDatabase();
        String where = FIELD_USERID + "=?";
        String[] whereValue = {Integer.toString(id)};
        ContentValues cv = new ContentValues();

        cv.put(FIELD_USERID, id);

        int row = mDb.update(TABLE_NAME, cv, where, whereValue);

        mDb.close();
        return row;
    }

    public int getCount() {

        Cursor cursor = mDb
                .rawQuery("select count(*) from " + TABLE_NAME, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();

        return count;
    }

    public void delete(int id) {
        // SQLiteDatabase mDb = this.getWritableDatabase();
        String where = FIELD_USERID + "=?";
        String[] whereValue = {Integer.toString(id)};
        mDb.delete(TABLE_NAME, where, whereValue);
    }

    public void addColumn(String column, String columnType) throws Exception {
        // SQLiteDatabase mDb = this.getWritableDatabase();

        String updateSql = "alter table user add " + column + " " + columnType;
        mDb.execSQL(updateSql);
    }

    /**
     * 清空表中的数据
     */
    public void clean() {
        // this.getWritableDatabase()
        // .execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // //System.out.println("clean删除表");
        // this.onCreate(this.getWritableDatabase());
        // this.getWritableDatabase().close();

        // SQLiteDatabase mDb = this.getWritableDatabase();
        // mDb.execSQL("TRUNCATE TABLE " + TABLE_NAME);
        // mDb.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // this.onCreate(this.getWritableDatabase());
        // mDb = this.getWritableDatabase();
        mDb.execSQL("DELETE FROM " + TABLE_NAME);
        // mDb.execSQL("select * from sqlite_sequence");
        mDb.execSQL("update sqlite_sequence set seq=0 where name='"
                + TABLE_NAME + "'");
    }

    public DBUser open() throws SQLException {
        closeConnection();

        mDbHelper = new DBUser(context);

        mDb = mDbHelper.getWritableDatabase();

        return this;
    }

    /**
     * 关闭数据源
     *
     * @author SHANHY
     */
    public void closeConnection() {
        if (mDb != null && mDb.isOpen()) {
            mDb.close();
        }
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

}