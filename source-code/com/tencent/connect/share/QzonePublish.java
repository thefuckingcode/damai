package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: Taobao */
public class QzonePublish extends BaseApi {
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0365  */
    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        String str3;
        String appId;
        String openId;
        String str4;
        String str5;
        String str6;
        String str7;
        Intent intent;
        Exception e;
        SLog.i("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string = bundle.getString("summary");
        int i = bundle.getInt("req_type", 3);
        String string2 = bundle.getString("appName");
        String string3 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        int i2 = bundle.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
        long j = bundle.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
        try {
            Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                Set<String> keySet = bundle2.keySet();
                str2 = "";
                try {
                    JSONObject jSONObject = new JSONObject();
                    Iterator<String> it = keySet.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(bundle2.getString(next))) {
                            str = string2;
                            try {
                                jSONObject.put(next, bundle2.getString(next));
                            } catch (Exception e2) {
                                e = e2;
                                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                                str3 = str2;
                                appId = this.c.getAppId();
                                openId = this.c.getOpenId();
                                SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                                if (3 == i) {
                                }
                                str5 = str3;
                                str6 = "openSDK_LOG.QzonePublish";
                                str4 = openId;
                                str7 = str2;
                                if (4 == i) {
                                }
                                if (!TextUtils.isEmpty(string)) {
                                }
                                if (!TextUtils.isEmpty(appId)) {
                                }
                                if (!TextUtils.isEmpty(str)) {
                                }
                                if (!m.e(str4)) {
                                }
                                if (!TextUtils.isEmpty(str5)) {
                                }
                                stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
                                SLog.v(str6, "doPublishToQzone, url: " + stringBuffer.toString());
                                a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
                                intent = new Intent("android.intent.action.VIEW");
                                intent.setPackage("com.tencent.mobileqq");
                                intent.setData(Uri.parse(stringBuffer.toString()));
                                intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                                if (a(intent)) {
                                }
                                SLog.i(SLog.TAG, "doPublishToQzone() --end");
                            }
                        } else {
                            str = string2;
                        }
                        it = it;
                        string2 = str;
                    }
                    str = string2;
                    if (jSONObject.length() > 0) {
                        str3 = jSONObject.toString();
                        appId = this.c.getAppId();
                        openId = this.c.getOpenId();
                        SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                        if (3 == i || stringArrayList == null) {
                            str5 = str3;
                            str6 = "openSDK_LOG.QzonePublish";
                            str4 = openId;
                            str7 = str2;
                        } else {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            StringBuffer stringBuffer3 = new StringBuffer();
                            str6 = "openSDK_LOG.QzonePublish";
                            int size = stringArrayList.size();
                            str5 = str3;
                            int i3 = 0;
                            while (i3 < size) {
                                stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i3)));
                                String a = m.a(appId, activity, stringArrayList.get(i3), iUiListener);
                                if (!TextUtils.isEmpty(a)) {
                                    stringBuffer3.append(URLEncoder.encode(a));
                                }
                                if (i3 != size - 1) {
                                    stringBuffer2.append(";");
                                    stringBuffer3.append(";");
                                }
                                i3++;
                                openId = openId;
                            }
                            str4 = openId;
                            stringBuffer.append("&image_url=" + Base64.encodeToString(m.j(stringBuffer2.toString()), 2));
                            if (!TextUtils.isEmpty(stringBuffer3.toString())) {
                                stringBuffer.append("&image_uri=" + Base64.encodeToString(m.j(stringBuffer3.toString()), 2));
                            }
                            str7 = "7";
                        }
                        if (4 == i) {
                            stringBuffer.append("&videoPath=" + Base64.encodeToString(m.j(string3), 2));
                            String a2 = m.a(appId, activity, string3, iUiListener);
                            if (!TextUtils.isEmpty(a2)) {
                                stringBuffer.append("&videoUri=" + Base64.encodeToString(m.j(a2), 2));
                            }
                            stringBuffer.append("&videoDuration=" + Base64.encodeToString(m.j(String.valueOf(i2)), 2));
                            stringBuffer.append("&videoSize=" + Base64.encodeToString(m.j(String.valueOf(j)), 2));
                            str7 = "8";
                        }
                        if (!TextUtils.isEmpty(string)) {
                            stringBuffer.append("&description=" + Base64.encodeToString(m.j(string), 2));
                        }
                        if (!TextUtils.isEmpty(appId)) {
                            stringBuffer.append("&share_id=" + appId);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(str), 2));
                        }
                        if (!m.e(str4)) {
                            stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(str4), 2));
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(m.j(str5), 2));
                        }
                        stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
                        SLog.v(str6, "doPublishToQzone, url: " + stringBuffer.toString());
                        a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
                        intent = new Intent("android.intent.action.VIEW");
                        intent.setPackage("com.tencent.mobileqq");
                        intent.setData(Uri.parse(stringBuffer.toString()));
                        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                        if (a(intent)) {
                            a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
                            e.a().a(0, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", str7, "0", "1", "0");
                        } else {
                            SLog.e(str6, "doPublishToQzone() target activity not found");
                            e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", str7, "0", "1", "0");
                        }
                        SLog.i(SLog.TAG, "doPublishToQzone() --end");
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = string2;
                    SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                    str3 = str2;
                    appId = this.c.getAppId();
                    openId = this.c.getOpenId();
                    SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                    if (3 == i) {
                    }
                    str5 = str3;
                    str6 = "openSDK_LOG.QzonePublish";
                    str4 = openId;
                    str7 = str2;
                    if (4 == i) {
                    }
                    if (!TextUtils.isEmpty(string)) {
                    }
                    if (!TextUtils.isEmpty(appId)) {
                    }
                    if (!TextUtils.isEmpty(str)) {
                    }
                    if (!m.e(str4)) {
                    }
                    if (!TextUtils.isEmpty(str5)) {
                    }
                    stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
                    SLog.v(str6, "doPublishToQzone, url: " + stringBuffer.toString());
                    a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setPackage("com.tencent.mobileqq");
                    intent.setData(Uri.parse(stringBuffer.toString()));
                    intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                    if (a(intent)) {
                    }
                    SLog.i(SLog.TAG, "doPublishToQzone() --end");
                }
            } else {
                str2 = "";
                str = string2;
            }
        } catch (Exception e4) {
            e = e4;
            str2 = "";
            str = string2;
            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
            str3 = str2;
            appId = this.c.getAppId();
            openId = this.c.getOpenId();
            SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
            if (3 == i) {
            }
            str5 = str3;
            str6 = "openSDK_LOG.QzonePublish";
            str4 = openId;
            str7 = str2;
            if (4 == i) {
            }
            if (!TextUtils.isEmpty(string)) {
            }
            if (!TextUtils.isEmpty(appId)) {
            }
            if (!TextUtils.isEmpty(str)) {
            }
            if (!m.e(str4)) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
            SLog.v(str6, "doPublishToQzone, url: " + stringBuffer.toString());
            a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
            intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.tencent.mobileqq");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
            if (a(intent)) {
            }
            SLog.i(SLog.TAG, "doPublishToQzone() --end");
        }
        str3 = str2;
        appId = this.c.getAppId();
        openId = this.c.getOpenId();
        SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
        if (3 == i) {
        }
        str5 = str3;
        str6 = "openSDK_LOG.QzonePublish";
        str4 = openId;
        str7 = str2;
        if (4 == i) {
        }
        if (!TextUtils.isEmpty(string)) {
        }
        if (!TextUtils.isEmpty(appId)) {
        }
        if (!TextUtils.isEmpty(str)) {
        }
        if (!m.e(str4)) {
        }
        if (!TextUtils.isEmpty(str5)) {
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
        SLog.v(str6, "doPublishToQzone, url: " + stringBuffer.toString());
        a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
        intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.mobileqq");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        if (a(intent)) {
        }
        SLog.i(SLog.TAG, "doPublishToQzone() --end");
    }

    public void publishToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (!com.tencent.connect.a.a("openSDK_LOG.QzonePublish", iUiListener)) {
            if (bundle == null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
                SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
                e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            } else if (!m.f(activity)) {
                iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
                SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
                e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
                new TDialog(activity, "", a(""), null, this.c).show();
            } else {
                String a = m.a(activity);
                int i = 0;
                if (a == null) {
                    a = bundle.getString("appName");
                } else if (a.length() > 20) {
                    a = a.substring(0, 20) + "...";
                }
                if (!TextUtils.isEmpty(a)) {
                    bundle.putString("appName", a);
                }
                int i2 = bundle.getInt("req_type");
                if (i2 == 3) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
                    if (stringArrayList != null && stringArrayList.size() > 0) {
                        while (i < stringArrayList.size()) {
                            if (!m.i(stringArrayList.get(i))) {
                                stringArrayList.remove(i);
                                i--;
                            }
                            i++;
                        }
                        bundle.putStringArrayList("imageUrl", stringArrayList);
                    }
                    b(activity, bundle, iUiListener);
                    SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                } else if (i2 == 4) {
                    final String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
                    if (!m.i(string)) {
                        SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                        iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                        return;
                    }
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        /* class com.tencent.connect.share.QzonePublish.AnonymousClass1 */

                        public void onPrepared(MediaPlayer mediaPlayer) {
                            long length = new File(string).length();
                            int duration = mediaPlayer.getDuration();
                            bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, string);
                            bundle.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                            bundle.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                            QzonePublish.this.b(activity, bundle, iUiListener);
                            SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                        }
                    });
                    mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        /* class com.tencent.connect.share.QzonePublish.AnonymousClass2 */

                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                            return false;
                        }
                    });
                    try {
                        mediaPlayer.setDataSource(string);
                        mediaPlayer.prepareAsync();
                    } catch (Exception unused) {
                        SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
                        iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                    }
                } else {
                    iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                    SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
                    e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
                }
            }
        }
    }
}
