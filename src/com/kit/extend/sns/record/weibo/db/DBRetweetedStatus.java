package com.kit.extend.sns.record.weibo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kit.utils.ListUtils;
import com.sina.weibo.sdk.openapi.models.PicUrl;
import com.sina.weibo.sdk.openapi.models.Source;
import com.sina.weibo.sdk.openapi.models.Status;
import com.sina.weibo.sdk.openapi.models.StatusList;
import com.sina.weibo.sdk.openapi.models.StatusWapper;
import com.sina.weibo.sdk.openapi.models.User;
import com.sina.weibo.sdk.openapi.models.Visible;

import java.util.ArrayList;
import java.util.List;

public class DBRetweetedStatus extends DB {

    public final static String TABLE_NAME = "retweeted_status";

    public final static String FIELD_USERID = "userId";
    public final static String FIELD_STATUSID = "id";
    public final static String FIELD_CREATEDAT = "createdAt";
    public final static String FIELD_MID = "mid";
    public final static String FIELD_IDSTR = "idstr";
    public final static String FIELD_TEXT = "content";

    public final static String FIELD_FAVORITED = "favorited";
    public final static String FIELD_TRUNCATED = "truncated";
    public final static String FIELD_INREPLYTOSTATUSID = "inReplyToStatusId";
    public final static String FIELD_INREPLYTOUSERID = "inReplyToUserId";
    public final static String FIELD_INREPLYTOSCREENNAME = "inReplyToScreenName";
    public final static String FIELD_THUMBNAILPIC = "thumbnailPic";
    public final static String FIELD_BMIDDLEPIC = "bmiddlePic";
    public final static String FIELD_ORIGINALPIC = "originalPic";
    public final static String FIELD_RETWEETEDSTATUSID = "retweetedStatusId";
    public final static String FIELD_GEO = "geo";
    public final static String FIELD_LATITUDE = "latitude";
    public final static String FIELD_LONGITUDE = "longitude";
    public final static String FIELD_REPOSTSCOUNT = "repostsCount";
    public final static String FIELD_COMMENTSCOUNT = "commentsCount";
    public final static String FIELD_ANNOTATIONS = "annotations";
    public final static String FIELD_MLEVEL = "mlevel";

    public final static String FIELD_SOURCEURL = "sourceUrl";
    public final static String FIELD_SOURCERELATIONSHIP = "sourceRelationShip";
    public final static String FIELD_SOURCENAME = "sourceName";

    public final static String FIELD_VISIBLETYPE = "visibleType";
    public final static String FIELD_VISIBLELISTID = "visibleListId";
    /**
     * 微博配图地址。多图时返回多图链接。无配图返回"[]"
     */
    public final static String FIELD_PIC_URLS = "picUrls";

    public static final String FIELD_ID = "_id";

    public DBRetweetedStatus(Context context) {

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
                FIELD_STATUSID + " desc");

        return cursor;
    }

    public Cursor selectAllOrderBy(String column, String order) {
        // SQLiteDatabase mDb =mDbhis.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_NAME, null, null, null, null, null,
                column + " " + order);

        return cursor;
    }

    public Cursor selectSomeOrderBy(String where, String column, String order) {
        // SQLiteDatabase mDb =mDbhis.getReadableDatabase();
        //System.out.println(where);

        Cursor cursor = mDb.query(TABLE_NAME, null, where, null, null, null,
                column + " " + order);

        return cursor;
    }

    public Cursor selectById(int id) {
        String where = FIELD_STATUSID + " = " + id;
        // SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_NAME, null, where, null, null, null,
                null);
        return cursor;
    }

    public StatusWapper selectByIdReturnStatus(long id) {
        String where = FIELD_STATUSID + " = '" + id + "'";
        // SQLiteDatabase mDb = this.getReadableDatabase();
        //System.out.println("where: " + where);
        Cursor cursor = mDb.query(TABLE_NAME, null, where, null, null, null,
                null);

        cursor.moveToFirst();

        String userId = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_USERID));

        DBUser dbUser = new DBUser(context);
        dbUser.open();
        User user = dbUser.selectByIdReturnUser(userId);
        dbUser.closeConnection();

        String createdAt = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_CREATEDAT));
        String mid = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_MID));
        String idstr = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_IDSTR));
        String text = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_TEXT));
        String favorited = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_FAVORITED));
        String truncated = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_TRUNCATED));
        String inReplyToStatusId = cursor
                .getString(cursor
                        .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_INREPLYTOSTATUSID));
        String inReplyToUserId = cursor
                .getString(cursor
                        .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_INREPLYTOUSERID));
        String inReplyToScreenName = cursor
                .getString(cursor
                        .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_INREPLYTOSCREENNAME));
        String thumbnailPic = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_THUMBNAILPIC));
        String bmiddlePic = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_BMIDDLEPIC));
        String originalPic = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_ORIGINALPIC));
        long retweetedStatusId = cursor
                .getLong(cursor
                        .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_RETWEETEDSTATUSID));
        String geo = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_GEO));
        String latitude = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_LATITUDE));
        String longitude = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_LONGITUDE));
        int repostsCount = cursor.getInt(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_REPOSTSCOUNT));
        int commentsCount = cursor.getInt(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_COMMENTSCOUNT));
        String annotations = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_ANNOTATIONS));
        int mlevel = cursor.getInt(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_MLEVEL));

        String sourceUrl = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_ANNOTATIONS));
        String sourceRelationShip = cursor
                .getString(cursor
                        .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_SOURCERELATIONSHIP));
        String sourceName = cursor.getString(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_SOURCENAME));
        Source source = new Source();
        source.setUrl(sourceUrl);
        source.setRelationship(sourceRelationShip);
        source.setName(sourceName);

        int visibleType = cursor.getInt(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_VISIBLETYPE));
        int visibleListId = cursor.getInt(cursor
                .getColumnIndexOrThrow(DBRetweetedStatus.FIELD_VISIBLELISTID));

        String pic_urls = cursor.getString(cursor
                .getColumnIndexOrThrow(FIELD_PIC_URLS));
        // json转为带泛型的list
        ArrayList<PicUrl> picUrls = new Gson().fromJson(pic_urls,
                new TypeToken<List<PicUrl>>() {
                }.getType());

        Visible visible = new Visible();
        visible.type = (visibleType);
        visible.list_id = (visibleListId);

        StatusWapper status = new StatusWapper();
        status.user = (user);
        status.created_at = (createdAt);
        status.id = (id+"");
        status.mid = (mid);
        status.idstr = (idstr);
        status.text = (text);
        status.source = (source.getName());
        status.favorited = (favorited.equals("true") ? true : false);
        status.truncated = (truncated.equals("true") ? true : false);
        status.in_reply_to_status_id = (inReplyToStatusId);
        status.in_reply_to_user_id = (inReplyToUserId);
        status.in_reply_to_screen_name = (inReplyToScreenName);
        status.thumbnail_pic = (thumbnailPic);
        status.bmiddle_pic = (bmiddlePic);
        status.original_pic = (originalPic);
        if (retweetedStatusId != 0) {
            StatusWapper s2 = new StatusWapper();
            s2.id = (retweetedStatusId+"");
            status.retweeted_status = (s2);
        }

//		status.setGeo(geo);
//		status.setLatitude(Double.parseDouble(latitude));
//		status.setLongitude(Double.parseDouble(longitude));
        status.reposts_count = (repostsCount);
        status.comments_count = (commentsCount);
        //	status.setAnnotations(annotations);
        status.mlevel = (mlevel);
        status.visible = (visible);
        status.pic_urls = (picUrls);

        cursor.close();

        return status;
    }

    public Cursor selectByName(String column, String str) {
        String where = " " + column + " = '" + str + "' ";
        // SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.query(TABLE_NAME, null, where, null, null, null,
                FIELD_STATUSID + " desc");
        return cursor;
    }

    public boolean insert(StatusList statusWapper) {
        // 使用事务插入速度最快，使用基本sql语句次之 使用ContentValues最慢
        // long before = System.nanoTime();
        try {
            mDb.beginTransaction();
            for (Status s : statusWapper.statusList) {

                ContentValues values = new ContentValues();

                values.put(DBRetweetedStatus.FIELD_USERID, s.user.id);
                values.put(DBRetweetedStatus.FIELD_STATUSID, s.id);
                values.put(DBRetweetedStatus.FIELD_CREATEDAT, s.created_at);
                values.put(DBRetweetedStatus.FIELD_MID, s.mid);
                values.put(DBRetweetedStatus.FIELD_IDSTR, s.idstr);
                values.put(DBRetweetedStatus.FIELD_TEXT, s.text);

                values.put(DBRetweetedStatus.FIELD_FAVORITED, s.favorited);
                values.put(DBRetweetedStatus.FIELD_TRUNCATED, s.truncated);
                values.put(DBRetweetedStatus.FIELD_INREPLYTOSTATUSID,
                        s.in_reply_to_status_id);
                values.put(DBRetweetedStatus.FIELD_INREPLYTOUSERID,
                        s.in_reply_to_user_id);
                values.put(DBRetweetedStatus.FIELD_INREPLYTOSCREENNAME,
                        s.in_reply_to_screen_name);
                values.put(DBRetweetedStatus.FIELD_THUMBNAILPIC,
                        s.thumbnail_pic);
                values.put(DBRetweetedStatus.FIELD_BMIDDLEPIC,
                        s.bmiddle_pic);
                values.put(DBRetweetedStatus.FIELD_ORIGINALPIC,
                        s.original_pic);

                Status s2 = s.retweeted_status;
                if (s2 != null) {
                    values.put(DBRetweetedStatus.FIELD_RETWEETEDSTATUSID,
                            s2.id);

                    ContentValues values2 = new ContentValues();

                    values2.put(DBRetweetedStatus.FIELD_USERID, s2.user
                            .id);
                    values2.put(DBRetweetedStatus.FIELD_STATUSID, s2.id);
                    values2.put(DBRetweetedStatus.FIELD_CREATEDAT, s2.created_at);
                    values2.put(DBRetweetedStatus.FIELD_MID, s2.mid);
                    values2.put(DBRetweetedStatus.FIELD_IDSTR, s2.idstr);
                    values2.put(DBRetweetedStatus.FIELD_TEXT, s2.text);

                    values2.put(DBRetweetedStatus.FIELD_FAVORITED,
                            s2.favorited);
                    values2.put(DBRetweetedStatus.FIELD_TRUNCATED,
                            s2.truncated);
                    values2.put(DBRetweetedStatus.FIELD_INREPLYTOSTATUSID,
                            s2.in_reply_to_status_id);
                    values2.put(DBRetweetedStatus.FIELD_INREPLYTOUSERID,
                            s2.in_reply_to_user_id);
                    values2.put(DBRetweetedStatus.FIELD_INREPLYTOSCREENNAME,
                            s2.in_reply_to_screen_name);
                    values2.put(DBRetweetedStatus.FIELD_THUMBNAILPIC,
                            s2.thumbnail_pic);
                    values2.put(DBRetweetedStatus.FIELD_BMIDDLEPIC,
                            s2.bmiddle_pic);
                    values2.put(DBRetweetedStatus.FIELD_ORIGINALPIC,
                            s2.original_pic);

                    if (s2.retweeted_status != null) {
                        values2.put(DBRetweetedStatus.FIELD_RETWEETEDSTATUSID,
                                s2.retweeted_status.id);
                    }

//					values2.put(DBRetweetedStatus.FIELD_GEO, s2.getGeo());
//					values2.put(DBRetweetedStatus.FIELD_LATITUDE,
//							s2.getLatitude());
//					values2.put(DBRetweetedStatus.FIELD_LONGITUDE,
//							s2.getLongitude());
                    values2.put(DBRetweetedStatus.FIELD_REPOSTSCOUNT,
                            s2.reposts_count);
                    values2.put(DBRetweetedStatus.FIELD_COMMENTSCOUNT,
                            s2.comments_count);
//					values2.put(DBRetweetedStatus.FIELD_ANNOTATIONS,
//							s2.getAnnotations());
                    values2.put(DBRetweetedStatus.FIELD_MLEVEL, s2.mlevel);
                    values2.put(DBRetweetedStatus.FIELD_VISIBLETYPE, s2
                            .visible.type);
                    values2.put(DBRetweetedStatus.FIELD_VISIBLELISTID, s2
                            .visible.list_id);

                    values2.put(FIELD_PIC_URLS, ListUtils.isNullOrContainEmpty(s2.pic_urls)
                            ? "" : new Gson().toJson(s2.pic_urls));

//                            values2.put(DBRetweetedStatus.FIELD_SOURCEURL, s2
//                                    .getSource().getUrl());
//                    values2.put(DBRetweetedStatus.FIELD_SOURCERELATIONSHIP, s2
//                            .getSource().getRelationship());
                    values2.put(DBRetweetedStatus.FIELD_SOURCENAME, s2
                            .source);

                    mDb.insert(TABLE_NAME, null, values2);

                }
//				values.put(DBRetweetedStatus.FIELD_GEO, s.getGeo());
//				values.put(DBRetweetedStatus.FIELD_LATITUDE, s.getLatitude());
//				values.put(DBRetweetedStatus.FIELD_LONGITUDE, s.getLongitude());
                values.put(DBRetweetedStatus.FIELD_REPOSTSCOUNT,
                        s.reposts_count);
                values.put(DBRetweetedStatus.FIELD_COMMENTSCOUNT,
                        s.comments_count);
//				values.put(DBRetweetedStatus.FIELD_ANNOTATIONS,
//						s.getAnnotations());
                values.put(DBRetweetedStatus.FIELD_MLEVEL, s.mlevel);
                values.put(DBRetweetedStatus.FIELD_VISIBLETYPE, s.visible
                        .type);
                values.put(DBRetweetedStatus.FIELD_VISIBLELISTID, s
                        .visible.list_id);
                values.put(FIELD_PIC_URLS, ListUtils.isNullOrContainEmpty(s.pic_urls)
                        ? "" : new Gson().toJson(s.pic_urls));


//				values.put(DBRetweetedStatus.FIELD_SOURCEURL, s.getSource()
//						.getUrl());
//				values.put(DBRetweetedStatus.FIELD_SOURCERELATIONSHIP, s
//						.getSource().getRelationship());
                values.put(DBRetweetedStatus.FIELD_SOURCENAME, s.source);

                mDb.insert(TABLE_NAME, null, values);

                DBUser dbUser = new DBUser(context);
                dbUser.insertWithSQL(s.user);

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

    public int update(int id) {
        // SQLiteDatabase mDb = this.getWritableDatabase();
        String where = FIELD_STATUSID + "=?";
        String[] whereValue = {Integer.toString(id)};
        ContentValues cv = new ContentValues();

        cv.put(FIELD_STATUSID, id);

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
        String where = FIELD_STATUSID + "=?";
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

    public DBRetweetedStatus open() throws SQLException {
        closeConnection();
        mDbHelper = new DBRetweetedStatus(context);

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