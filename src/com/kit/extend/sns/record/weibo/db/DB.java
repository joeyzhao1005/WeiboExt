package com.kit.extend.sns.record.weibo.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
	// public static final String SHMETRO_PATH = android.os.Environment
	// .getExternalStorageDirectory().getAbsolutePath() + "/pantomobile";

	public final static String DATABASE_NAME = "db.sqlite";
	public final static int DATABASE_VERSION = 1;

	public static DB mDbHelper;
	public static SQLiteDatabase mDb;
	public Context context;

	public DB(Context context) {

		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context.getApplicationContext();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// //////////////////////////////////////////////////////////////////////////////////

		createDB1(db);
		createDB2(db);
		createDB3(db);
		createDB4(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public void createDB1(SQLiteDatabase db) {
		StringBuilder sql1 = new StringBuilder();
		sql1.append("CREATE TABLE if not exists ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.TABLE_NAME);
		sql1.append(" (");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_ID + " 	integer primary key autoincrement, ");

		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_USERID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_STATUSID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_CREATEDAT + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_MID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_IDSTR + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_TEXT + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_FAVORITED + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_TRUNCATED + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_INREPLYTOSTATUSID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_INREPLYTOUSERID + " integer, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_INREPLYTOSCREENNAME + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_THUMBNAILPIC + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_BMIDDLEPIC + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_ORIGINALPIC + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_RETWEETEDSTATUSID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_GEO + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_LATITUDE + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_LONGITUDE + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_REPOSTSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_COMMENTSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_ANNOTATIONS + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_MLEVEL + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_SOURCEURL + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_SOURCERELATIONSHIP + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_SOURCENAME + " TEXT, ");
        sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_PIC_URLS + " TEXT, ");
        sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_VISIBLETYPE + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_VISIBLELISTID + " INTEGER ");

		sql1.append(");");

		// System.out.println(sql1.toString());

		db.execSQL(sql1.toString());
	}

	public void createDB2(SQLiteDatabase db) {
		StringBuilder sql1 = new StringBuilder();
		sql1.append("CREATE TABLE if not exists ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.TABLE_NAME);
		sql1.append(" (");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_ID + " 	integer primary key autoincrement, ");

		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_USERID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_SCREENNAME + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_NAME + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_PROVINCE + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_CITY + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_LOCATION + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_DESCRIPTION + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_URL + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_PROFILEIMAGEURL + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_USERDOMAIN + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_GENDER + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_FOLLOWERSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_FRIENDSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_STATUSESCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_FAVOURITESCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_CREATEDAT + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_FOLLOWING + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_VERIFIED + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_VERIFIEDTYPE + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_ALLOWALLACTMSG + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_ALLOWALLCOMMENT + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_FOLLOWME + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_AVATARLARGE + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_ONLINESTATUS + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_NEWESTSTATUSID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_BIFOLLOWERSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_REMARK + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_LANG + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_VERIFIEDREASON + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_WEIHAO + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBUser.FIELD_STATUSID + " TEXT ");

		sql1.append(");");

		// System.out.println(sql1.toString());

		db.execSQL(sql1.toString());
	}

	public void createDB3(SQLiteDatabase db) {
		StringBuilder sql1 = new StringBuilder();
		sql1.append("CREATE TABLE if not exists ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.TABLE_NAME);
		sql1.append(" (");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_ID
				+ " 	integer primary key autoincrement, ");

		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_USERID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_STATUSID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_CREATEDAT + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_MID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_IDSTR + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_TEXT + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_FAVORITED + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_TRUNCATED + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_INREPLYTOSTATUSID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_INREPLYTOUSERID + " integer, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_INREPLYTOSCREENNAME + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_THUMBNAILPIC + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_BMIDDLEPIC + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_ORIGINALPIC + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_RETWEETEDSTATUSID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_GEO + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_LATITUDE + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_LONGITUDE + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_REPOSTSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_COMMENTSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_ANNOTATIONS + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_MLEVEL + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_SOURCEURL + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_SOURCERELATIONSHIP + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_SOURCENAME + " TEXT, ");
        sql1.append(com.kit.extend.sns.record.weibo.db.DBStatus.FIELD_PIC_URLS + " TEXT, ");
        sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_VISIBLETYPE + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBRetweetedStatus.FIELD_VISIBLELISTID + " INTEGER ");

		sql1.append(");");

		// System.out.println(sql1.toString());

		db.execSQL(sql1.toString());
	}

	public void createDB4(SQLiteDatabase db) {
		StringBuilder sql1 = new StringBuilder();
		sql1.append("CREATE TABLE if not exists ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.TABLE_NAME);
		sql1.append(" (");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_ID
				+ " 	integer primary key autoincrement, ");

		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_USERID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_SCREENNAME + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_NAME + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_PROVINCE + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_CITY + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_LOCATION + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_DESCRIPTION + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_URL + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_PROFILEIMAGEURL + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_USERDOMAIN + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_GENDER + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_FOLLOWERSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_FRIENDSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_STATUSESCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_FAVOURITESCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_CREATEDAT + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_FOLLOWING + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_VERIFIED + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_VERIFIEDTYPE + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_ALLOWALLACTMSG + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_ALLOWALLCOMMENT + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_FOLLOWME + " BOOLEAN, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_AVATARLARGE + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_ONLINESTATUS + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_NEWESTSTATUSID + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_BIFOLLOWERSCOUNT + " INTEGER, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_REMARK + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_LANG + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_VERIFIEDREASON + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_WEIHAO + " TEXT, ");
		sql1.append(com.kit.extend.sns.record.weibo.db.DBFriends.FIELD_STATUSID + " TEXT ");

		sql1.append(");");

		System.out.println(sql1.toString());

		db.execSQL(sql1.toString());
	}

	public DB open() throws SQLException {

		mDbHelper = new DB(context);

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