package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.b;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.a;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* compiled from: Taobao */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    private static SharedPreferences g;
    private String a;
    private String b;
    private String c;
    private int d = 1;
    private long e = -1;
    private a f;

    public QQToken(String str) {
        this.a = str;
    }

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (g == null) {
                g = g.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = g;
        }
        return sharedPreferences;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(m.j(str), 2);
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.b;
    }

    public String getAppId() {
        return this.a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public String getOpenId() {
        return this.c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.a);
            }
        } catch (Exception e2) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e2.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.b != null && System.currentTimeMillis() < this.e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f == null) {
                this.f = new a(g.a());
            }
            return a(str, this.f);
        } catch (Exception e2) {
            SLog.i("QQToken", "login loadSession" + e2.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f == null) {
                this.f = new a(g.a());
            }
            return a(this.a, jSONObject, this.f);
        } catch (Exception e2) {
            SLog.i("QQToken", "login saveSession" + e2.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.e = 0;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public void setOpenId(String str) {
        this.c = str;
        b.a().a(str);
    }

    private static synchronized JSONObject a(String str, a aVar) {
        String str2;
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            } else {
                String string = a().getString(a(str), "");
                if (TextUtils.isEmpty(string)) {
                    if (!JniInterface.isJniOk) {
                        k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                        JniInterface.loadSo();
                    }
                    if (!JniInterface.isJniOk) {
                        SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                        return null;
                    }
                    String c2 = c(str);
                    String string2 = a().getString(c2, "");
                    if (TextUtils.isEmpty(string2)) {
                        String b2 = b(str);
                        String string3 = a().getString(b2, "");
                        if (TextUtils.isEmpty(string3)) {
                            SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                            return null;
                        }
                        try {
                            str2 = JniInterface.d1(string3);
                            if (TextUtils.isEmpty(str2)) {
                                SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                return null;
                            }
                            a(str, new JSONObject(str2), aVar);
                            a().edit().remove(b2).apply();
                        } catch (Exception e2) {
                            SLog.e("QQToken", "Catch Exception", e2);
                            return null;
                        } finally {
                            a().edit().remove(b2).apply();
                        }
                    } else {
                        try {
                            str2 = JniInterface.d2(string2);
                            a(str, new JSONObject(str2), aVar);
                        } catch (Exception e3) {
                            SLog.e("QQToken", "Catch Exception", e3);
                            return null;
                        } finally {
                            a().edit().remove(c2).apply();
                        }
                    }
                } else {
                    str2 = aVar.b(string);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    SLog.i("QQToken", "loadJsonPreference sucess");
                    return jSONObject;
                } catch (Exception e4) {
                    SLog.i("QQToken", "loadJsonPreference decode " + e4.toString());
                    return null;
                }
            }
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, a aVar) {
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            } else if (str == null || jSONObject == null) {
                SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
                return false;
            } else {
                try {
                    String string = jSONObject.getString(Constants.PARAM_EXPIRES_IN);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String a2 = a(str);
                        String a3 = aVar.a(jSONObject.toString());
                        if (a2.length() <= 6 || a3 == null) {
                            SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                            return false;
                        }
                        a().edit().putString(a2, a3).commit();
                        SLog.i("QQToken", "saveJsonPreference sucess");
                        return true;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e2) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e2.toString());
                    return false;
                }
            }
        }
    }

    private static String a(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_aes_google";
    }
}
