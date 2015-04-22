package com.kit.extend.sns.record.weibo.db;

import android.content.Context;
import android.database.Cursor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sina.weibo.sdk.openapi.models.Source;
import com.sina.weibo.sdk.openapi.models.Status;
import com.sina.weibo.sdk.openapi.models.StatusList;
import com.sina.weibo.sdk.openapi.models.User;
import com.sina.weibo.sdk.openapi.models.Visible;

import java.util.ArrayList;
import java.util.List;


public class DoDBStatus {
    public static StatusList getStatusDataFromLocal(Context context, int page, int count) {

        ArrayList<Status> statuses = new ArrayList<Status>();

        DBStatus dbStatus = new DBStatus(context.getApplicationContext());

        dbStatus.open();
        Cursor returnCursor = dbStatus.selectOrderBy(null, page, count,
                DBStatus.FIELD_STATUSID, "desc");

        while (returnCursor.moveToNext()) {

            String userId = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_USERID));

            DBUser dbUser = new DBUser(context);
            dbUser.open();
            User user = dbUser.selectByIdReturnUser(userId);
            dbUser.closeConnection();

            long id = returnCursor.getLong(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_STATUSID));
            String createdAt = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_CREATEDAT));
            String mid = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_MID));
            String idstr = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_IDSTR));
            String text = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_TEXT));
            String favorited = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_FAVORITED));
            String truncated = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_TRUNCATED));
            String inReplyToStatusId = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_INREPLYTOSTATUSID));
            String inReplyToUserId = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_INREPLYTOUSERID));
            String inReplyToScreenName = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_INREPLYTOSCREENNAME));
            String thumbnailPic = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_THUMBNAILPIC));
            String bmiddlePic = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_BMIDDLEPIC));
            String originalPic = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_ORIGINALPIC));
            long retweetedStatusId = returnCursor.getLong(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_RETWEETEDSTATUSID));
            String geo = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_GEO));
            String latitude = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_LATITUDE));
            String longitude = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_LONGITUDE));
            int repostsCount = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_REPOSTSCOUNT));
            int commentsCount = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_COMMENTSCOUNT));
            String annotations = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_ANNOTATIONS));
            int mlevel = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_MLEVEL));

            String sourceUrl = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_ANNOTATIONS));
            String sourceRelationShip = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_SOURCERELATIONSHIP));
            String sourceName = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_SOURCENAME));
            Source source = new Source();
            source.setUrl(sourceUrl);
            source.setRelationship(sourceRelationShip);
            source.setName(sourceName);

            int visibleType = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_VISIBLETYPE));
            int visibleListId = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_VISIBLELISTID));
            String pic_urls = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_PIC_URLS));
            // json转为带泛型的list
            ArrayList<String> picUrls = new Gson().fromJson(pic_urls,
                    new TypeToken<List<String>>() {
                    }.getType());


            Visible visible = new Visible();
            visible.type = (visibleType);
            visible.list_id = (visibleListId);

            Status status = new Status();
            status.user = (user);
            status.created_at = (createdAt);
            status.id = (id + "");
            status.mid = (mid + "");
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

//			status.setGeo(geo);
//			status.setLatitude(Double.parseDouble(latitude));
//			status.setLongitude(Double.parseDouble(longitude));
            status.reposts_count = (repostsCount);
            status.comments_count = (commentsCount);
//			status.setAnnotations(annotations);
            status.mlevel = (mlevel);
            status.visible = (visible);
            status.pic_urls = (picUrls);

            // Status s2 = new Status();
            // s2.setId(retweetedStatusId);
            // status.setRetweetedStatus(s2);
            Status s2 = null;
            if (retweetedStatusId != 0) {

                DBRetweetedStatus dbRetweetedStatus = new DBRetweetedStatus(
                        context.getApplicationContext());

                dbRetweetedStatus.open();
                s2 = dbRetweetedStatus
                        .selectByIdReturnStatus(retweetedStatusId);
                dbRetweetedStatus.closeConnection();

            }
            status.retweeted_status = (s2);

            //System.out.println("status.text: " + status.getText());
            statuses.add(status);
        }
        returnCursor.close();
        dbStatus.closeConnection();
        StatusList statusList = new StatusList();
        statusList.statusList = statuses;
        return statusList;
    }

    public static StatusList getStatusDataFromLocal(Context context) {

        ArrayList<Status> statuses = new ArrayList<Status>();

        DBStatus dbStatus = new DBStatus(context.getApplicationContext());

        dbStatus.open();
        Cursor returnCursor = dbStatus.selectAllOrderBy(
                DBStatus.FIELD_STATUSID, "desc");

        while (returnCursor.moveToNext()) {

            String userId = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_USERID));

            DBUser dbUser = new DBUser(context);
            dbUser.open();
            User user = dbUser.selectByIdReturnUser(userId);
            dbUser.closeConnection();

            long id = returnCursor.getLong(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_STATUSID));
            String createdAt = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_CREATEDAT));
            String mid = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_MID));
            String idstr = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_IDSTR));
            String text = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_TEXT));
            String favorited = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_FAVORITED));
            String truncated = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_TRUNCATED));
            String inReplyToStatusId = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_INREPLYTOSTATUSID));
            String inReplyToUserId = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_INREPLYTOUSERID));
            String inReplyToScreenName = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_INREPLYTOSCREENNAME));
            String thumbnailPic = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_THUMBNAILPIC));
            String bmiddlePic = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_BMIDDLEPIC));
            String originalPic = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_ORIGINALPIC));
            long retweetedStatusId = returnCursor.getLong(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_RETWEETEDSTATUSID));
            String geo = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_GEO));
            String latitude = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_LATITUDE));
            String longitude = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_LONGITUDE));
            int repostsCount = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_REPOSTSCOUNT));
            int commentsCount = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_COMMENTSCOUNT));
            String annotations = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_ANNOTATIONS));
            int mlevel = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_MLEVEL));

            String sourceUrl = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_ANNOTATIONS));
            String sourceRelationShip = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_SOURCERELATIONSHIP));
            String sourceName = returnCursor.getString(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_SOURCENAME));
            Source source = new Source();
            source.setUrl(sourceUrl);
            source.setRelationship(sourceRelationShip);
            source.setName(sourceName);

            int visibleType = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_VISIBLETYPE));
            int visibleListId = returnCursor.getInt(returnCursor
                    .getColumnIndexOrThrow(DBStatus.FIELD_VISIBLELISTID));

            Visible visible = new Visible();
            visible.type = (visibleType);
            visible.list_id = (visibleListId);

            Status status = new Status();
            status.user = (user);
            status.created_at = (createdAt);
            status.id = (id + "");
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

//			status.setGeo(geo);
//			status.setLatitude(Double.parseDouble(latitude));
//			status.setLongitude(Double.parseDouble(longitude));
            status.reposts_count = (repostsCount);
            status.comments_count = (commentsCount);
//			status.setAnnotations(annotations);
            status.mlevel = (mlevel);
            status.visible = (visible);

            // Status s2 = new Status();
            // s2.setId(retweetedStatusId);
            // status.setRetweetedStatus(s2);
            Status s2 = null;
            if (retweetedStatusId != 0) {

                DBRetweetedStatus dbRetweetedStatus = new DBRetweetedStatus(
                        context.getApplicationContext());

                dbRetweetedStatus.open();
                s2 = dbRetweetedStatus
                        .selectByIdReturnStatus(retweetedStatusId);
                dbRetweetedStatus.closeConnection();

            }
            status.retweeted_status = (s2);

            //System.out.println("status.text: " + status.getText());
            statuses.add(status);
        }
        returnCursor.close();
        dbStatus.closeConnection();
        StatusList statusList = new StatusList();
        statusList.statusList = statuses;
        return statusList;
    }

    @SuppressWarnings("unused")
    public static int initStatusData2Local(Context context,
                                           StatusList statusList) {

        DBStatus dbStatus = new DBStatus(context.getApplicationContext());
        dbStatus.open();
        dbStatus.clean();
        dbStatus.close();

        DBRetweetedStatus dbRetweetedStatus = new DBRetweetedStatus(
                context.getApplicationContext());
        dbRetweetedStatus.open();
        dbRetweetedStatus.clean();
        dbRetweetedStatus.close();

        DBUser dbUser = new DBUser(context.getApplicationContext());
        dbUser.open();
        dbUser.clean();
        dbUser.close();

        boolean isDone = false;
        dbStatus.open();
        isDone = dbStatus.insert(statusList);
        dbUser.closeConnection();
        dbRetweetedStatus.closeConnection();
        dbStatus.closeConnection();

        // msg = "更新联系人成功";
        // ToastUtils.mkShortTimeToast(context, msg);
        if (isDone) {
            return 1;
        } else {
            return 0;
        }

    }


    public static void clearStatusData(Context context) {

        DBStatus dbStatus = new DBStatus(context.getApplicationContext());
        dbStatus.open();
        dbStatus.clean();
        dbStatus.close();


    }

}
