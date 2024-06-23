package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: Taobao */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_MINI_PROGRAM = 7;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    private boolean a = true;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    public String mViaShareQzoneType = "";

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x03f8  */
    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        int i;
        String str2;
        String appId;
        String openIdWithCache;
        boolean a2;
        String str3;
        Exception e2;
        SLog.i("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        String string4 = bundle.getString("audio_url");
        int i2 = bundle.getInt("req_type", 1);
        String string5 = bundle.getString("appName");
        String string6 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        String string7 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        String string8 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i3 = bundle.getInt("cflag", 0);
        String string9 = bundle.getString("share_qq_ext_str");
        String str4 = "";
        try {
            Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                Set<String> keySet = bundle2.keySet();
                str2 = string9;
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (String str5 : keySet) {
                        str = string6;
                        try {
                            i = i2;
                            try {
                                jSONObject.put(str5, bundle2.get(str5));
                                i2 = i;
                                string6 = str;
                            } catch (Exception e3) {
                                e2 = e3;
                                SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e2);
                                appId = this.c.getAppId();
                                openIdWithCache = this.c.getOpenIdWithCache();
                                SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
                                str3 = stringArrayList.get(0);
                                stringBuffer.append("&image_url=" + Base64.encodeToString(m.j(URLEncoder.encode(str3)), 2));
                                if (!m.h(str3)) {
                                }
                                if (!TextUtils.isEmpty(string)) {
                                }
                                if (!TextUtils.isEmpty(string2)) {
                                }
                                if (!TextUtils.isEmpty(appId)) {
                                }
                                if (!TextUtils.isEmpty(string3)) {
                                }
                                if (!TextUtils.isEmpty(string5)) {
                                }
                                if (!m.e(openIdWithCache)) {
                                }
                                if (!m.e(string4)) {
                                }
                                stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
                                if (!TextUtils.isEmpty(str)) {
                                }
                                if (!TextUtils.isEmpty(string7)) {
                                }
                                if (!TextUtils.isEmpty(string8)) {
                                }
                                if (!m.e(str2)) {
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                }
                                stringBuffer.append("&cflag=" + Base64.encodeToString(m.j(String.valueOf(i3)), 2));
                                SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                                a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(stringBuffer.toString()));
                                intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                                a2 = a(intent);
                                if (m.g(activity, "4.6.0")) {
                                }
                                if (a2) {
                                }
                                SLog.i(SLog.TAG, "doShareToQzone() --end");
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            i = i2;
                            SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e2);
                            appId = this.c.getAppId();
                            openIdWithCache = this.c.getOpenIdWithCache();
                            SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
                            str3 = stringArrayList.get(0);
                            stringBuffer.append("&image_url=" + Base64.encodeToString(m.j(URLEncoder.encode(str3)), 2));
                            if (!m.h(str3)) {
                            }
                            if (!TextUtils.isEmpty(string)) {
                            }
                            if (!TextUtils.isEmpty(string2)) {
                            }
                            if (!TextUtils.isEmpty(appId)) {
                            }
                            if (!TextUtils.isEmpty(string3)) {
                            }
                            if (!TextUtils.isEmpty(string5)) {
                            }
                            if (!m.e(openIdWithCache)) {
                            }
                            if (!m.e(string4)) {
                            }
                            stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
                            if (!TextUtils.isEmpty(str)) {
                            }
                            if (!TextUtils.isEmpty(string7)) {
                            }
                            if (!TextUtils.isEmpty(string8)) {
                            }
                            if (!m.e(str2)) {
                            }
                            if (!TextUtils.isEmpty(str4)) {
                            }
                            stringBuffer.append("&cflag=" + Base64.encodeToString(m.j(String.valueOf(i3)), 2));
                            SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                            a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(Uri.parse(stringBuffer.toString()));
                            intent2.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                            a2 = a(intent2);
                            if (m.g(activity, "4.6.0")) {
                            }
                            if (a2) {
                            }
                            SLog.i(SLog.TAG, "doShareToQzone() --end");
                        }
                    }
                    i = i2;
                    str = string6;
                    if (keySet.size() > 0) {
                        str4 = jSONObject.toString();
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    i = i2;
                    str = string6;
                    SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e2);
                    appId = this.c.getAppId();
                    openIdWithCache = this.c.getOpenIdWithCache();
                    SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
                    str3 = stringArrayList.get(0);
                    stringBuffer.append("&image_url=" + Base64.encodeToString(m.j(URLEncoder.encode(str3)), 2));
                    if (!m.h(str3)) {
                    }
                    if (!TextUtils.isEmpty(string)) {
                    }
                    if (!TextUtils.isEmpty(string2)) {
                    }
                    if (!TextUtils.isEmpty(appId)) {
                    }
                    if (!TextUtils.isEmpty(string3)) {
                    }
                    if (!TextUtils.isEmpty(string5)) {
                    }
                    if (!m.e(openIdWithCache)) {
                    }
                    if (!m.e(string4)) {
                    }
                    stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
                    if (!TextUtils.isEmpty(str)) {
                    }
                    if (!TextUtils.isEmpty(string7)) {
                    }
                    if (!TextUtils.isEmpty(string8)) {
                    }
                    if (!m.e(str2)) {
                    }
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    stringBuffer.append("&cflag=" + Base64.encodeToString(m.j(String.valueOf(i3)), 2));
                    SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                    a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
                    Intent intent22 = new Intent("android.intent.action.VIEW");
                    intent22.setData(Uri.parse(stringBuffer.toString()));
                    intent22.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                    a2 = a(intent22);
                    if (m.g(activity, "4.6.0")) {
                    }
                    if (a2) {
                    }
                    SLog.i(SLog.TAG, "doShareToQzone() --end");
                }
            } else {
                i = i2;
                str = string6;
                str2 = string9;
            }
        } catch (Exception e6) {
            e2 = e6;
            i = i2;
            str = string6;
            str2 = string9;
            SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e2);
            appId = this.c.getAppId();
            openIdWithCache = this.c.getOpenIdWithCache();
            SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
            str3 = stringArrayList.get(0);
            stringBuffer.append("&image_url=" + Base64.encodeToString(m.j(URLEncoder.encode(str3)), 2));
            if (!m.h(str3)) {
            }
            if (!TextUtils.isEmpty(string)) {
            }
            if (!TextUtils.isEmpty(string2)) {
            }
            if (!TextUtils.isEmpty(appId)) {
            }
            if (!TextUtils.isEmpty(string3)) {
            }
            if (!TextUtils.isEmpty(string5)) {
            }
            if (!m.e(openIdWithCache)) {
            }
            if (!m.e(string4)) {
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
            if (!TextUtils.isEmpty(str)) {
            }
            if (!TextUtils.isEmpty(string7)) {
            }
            if (!TextUtils.isEmpty(string8)) {
            }
            if (!m.e(str2)) {
            }
            if (!TextUtils.isEmpty(str4)) {
            }
            stringBuffer.append("&cflag=" + Base64.encodeToString(m.j(String.valueOf(i3)), 2));
            SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
            a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
            Intent intent222 = new Intent("android.intent.action.VIEW");
            intent222.setData(Uri.parse(stringBuffer.toString()));
            intent222.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
            a2 = a(intent222);
            if (m.g(activity, "4.6.0")) {
            }
            if (a2) {
            }
            SLog.i(SLog.TAG, "doShareToQzone() --end");
        }
        appId = this.c.getAppId();
        openIdWithCache = this.c.getOpenIdWithCache();
        SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
        if (stringArrayList != null && stringArrayList.size() > 0) {
            str3 = stringArrayList.get(0);
            stringBuffer.append("&image_url=" + Base64.encodeToString(m.j(URLEncoder.encode(str3)), 2));
            if (!m.h(str3)) {
                String a3 = m.a(appId, activity, str3, iUiListener);
                if (!TextUtils.isEmpty(a3)) {
                    stringBuffer.append("&image_uri=" + Base64.encodeToString(m.j(URLEncoder.encode(a3)), 2));
                }
            }
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + Base64.encodeToString(m.j(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + Base64.encodeToString(m.j(string2), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + Base64.encodeToString(m.j(string3), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(string5), 2));
        }
        if (!m.e(openIdWithCache)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openIdWithCache), 2));
        }
        if (!m.e(string4)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(m.j(string4), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i)), 2));
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("&mini_program_appid=" + Base64.encodeToString(m.j(String.valueOf(str)), 2));
        }
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&mini_program_path=" + Base64.encodeToString(m.j(String.valueOf(string7)), 2));
        }
        if (!TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_type=" + Base64.encodeToString(m.j(String.valueOf(string8)), 2));
        }
        if (!m.e(str2)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(m.j(str2), 2));
        }
        if (!TextUtils.isEmpty(str4)) {
            stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(m.j(str4), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(m.j(String.valueOf(i3)), 2));
        SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
        a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
        Intent intent2222 = new Intent("android.intent.action.VIEW");
        intent2222.setData(Uri.parse(stringBuffer.toString()));
        intent2222.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        a2 = a(intent2222);
        if (m.g(activity, "4.6.0")) {
            if (a2) {
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_QZSHARE, iUiListener);
                a(activity, intent2222, Constants.REQUEST_OLD_QZSHARE);
            }
            SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
            }
            if (a2) {
                a(activity, Constants.REQUEST_QZONE_SHARE, intent2222, false);
            }
        }
        if (a2) {
            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
            e.a().a(0, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
            e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        SLog.i(SLog.TAG, "doShareToQzone() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02f0  */
    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        int i;
        Bundle bundle2;
        String str3;
        SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (!com.tencent.connect.a.a("openSDK_LOG.QzoneShare", iUiListener)) {
            if (bundle == null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
                e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
                return;
            }
            String string = bundle.getString("title");
            String string2 = bundle.getString("summary");
            String string3 = bundle.getString("targetUrl");
            String string4 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
            String string5 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            String a2 = m.a(activity);
            if (a2 == null) {
                a2 = bundle.getString("appName");
                str2 = "appName";
            } else {
                str2 = "appName";
                if (a2.length() > 20) {
                    StringBuilder sb = new StringBuilder();
                    str = "summary";
                    sb.append(a2.substring(0, 20));
                    sb.append("...");
                    a2 = sb.toString();
                    i = bundle.getInt("req_type");
                    SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i);
                    if (i != 1) {
                        this.mViaShareQzoneType = "1";
                    } else if (i != 5) {
                        this.mViaShareQzoneType = "1";
                    } else {
                        this.mViaShareQzoneType = "2";
                    }
                    if (i != 1) {
                        SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, SHARE_TO_QZONE_TYPE_IMAGE_TEXT needTitle = true");
                        this.a = true;
                        this.d = false;
                        this.e = true;
                        this.f = false;
                    } else if (i == 5) {
                        iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                        e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                        return;
                    } else if (i != 7) {
                        if (!m.e(string) || !m.e(string2)) {
                            this.a = true;
                        } else if (stringArrayList == null || stringArrayList.size() == 0) {
                            string = "来自" + a2 + "的分享";
                            this.a = true;
                        } else {
                            this.a = false;
                        }
                        this.d = false;
                        SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, default needTitle = true, shareType = " + i);
                        this.e = true;
                        this.f = false;
                    } else {
                        if (TextUtils.isEmpty(string4) || TextUtils.isEmpty(string5)) {
                            iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, "appid or path empty."));
                        }
                        this.e = false;
                        this.f = false;
                        this.a = false;
                    }
                    if (!m.a() || !m.g(activity, "4.5.0")) {
                        if (this.a) {
                            if (TextUtils.isEmpty(string3)) {
                                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                                e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                                return;
                            } else if (!m.h(string3)) {
                                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                                e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_ERROR);
                                return;
                            }
                        }
                        if (!this.d) {
                            bundle2 = bundle;
                            bundle2.putString("title", "");
                            bundle2.putString(str, "");
                        } else {
                            bundle2 = bundle;
                            if (!this.e || !m.e(string)) {
                                if (m.e(string) || string.length() <= 200) {
                                    str3 = null;
                                } else {
                                    str3 = null;
                                    bundle2.putString("title", m.a(string, 200, (String) null, (String) null));
                                }
                                if (!m.e(string2) && string2.length() > 600) {
                                    bundle2.putString(str, m.a(string2, 600, str3, str3));
                                }
                            } else {
                                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                                e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                                return;
                            }
                        }
                        if (!TextUtils.isEmpty(a2)) {
                            bundle2.putString(str2, a2);
                        }
                        if (stringArrayList == null && stringArrayList.size() != 0) {
                            int i2 = 0;
                            while (i2 < stringArrayList.size()) {
                                String str4 = stringArrayList.get(i2);
                                if (!m.h(str4) && !m.i(str4)) {
                                    stringArrayList.remove(i2);
                                    i2--;
                                }
                                i2++;
                            }
                            if (stringArrayList.size() == 0) {
                                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                                e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                                return;
                            }
                            bundle2.putStringArrayList("imageUrl", stringArrayList);
                        } else if (this.f) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                            e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                            return;
                        }
                        if (m.g(activity, "4.6.0")) {
                            SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                            b(activity, bundle, iUiListener);
                        } else if (k.c(activity, "4.2.0") < 0 || k.c(activity, "4.6.0") >= 0) {
                            SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                            new TDialog(activity, "", a(""), null, this.c).show();
                        } else {
                            SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                            QQShare qQShare = new QQShare(activity, this.c);
                            if (stringArrayList != null && stringArrayList.size() > 0) {
                                String str5 = stringArrayList.get(0);
                                if (i != 5 || m.i(str5)) {
                                    bundle2.putString("imageLocalUrl", str5);
                                } else {
                                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                                    SLog.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                    e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                    return;
                                }
                            }
                            if (!m.g(activity, "4.5.0")) {
                                bundle2.putInt("cflag", 1);
                            }
                            qQShare.shareToQQ(activity, bundle2, iUiListener);
                        }
                        SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
                    }
                    iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                    SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
                    e.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
                    return;
                }
            }
            str = "summary";
            i = bundle.getInt("req_type");
            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i);
            if (i != 1) {
            }
            if (i != 1) {
            }
            if (!m.a()) {
            }
            if (this.a) {
            }
            if (!this.d) {
            }
            if (!TextUtils.isEmpty(a2)) {
            }
            if (stringArrayList == null) {
            }
            if (this.f) {
            }
            if (m.g(activity, "4.6.0")) {
            }
            SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
        }
    }
}
