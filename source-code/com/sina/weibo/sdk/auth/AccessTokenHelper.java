package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.sina.weibo.sdk.a.b;
import com.sina.weibo.sdk.a.e;
import com.sina.weibo.sdk.net.c;
import com.tencent.connect.common.Constants;

/* compiled from: Taobao */
public class AccessTokenHelper {
    private static final String PREFERENCES_NAME = "com_weibo_sdk_android";

    public static void clearAccessToken(Context context) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("com_weibo_sdk_android", 0).edit();
            edit.clear();
            edit.apply();
        }
    }

    public static Oauth2AccessToken readAccessToken(Context context) {
        if (context == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com_weibo_sdk_android", 0);
        oauth2AccessToken.setUid(sharedPreferences.getString("uid", ""));
        oauth2AccessToken.setScreenName(sharedPreferences.getString(ALBiometricsKeys.KEY_USERNAME, ""));
        oauth2AccessToken.setAccessToken(sharedPreferences.getString(Constants.PARAM_ACCESS_TOKEN, ""));
        oauth2AccessToken.setRefreshToken(sharedPreferences.getString("refresh_token", ""));
        oauth2AccessToken.setExpiresTime(sharedPreferences.getLong(Constants.PARAM_EXPIRES_IN, 0));
        return oauth2AccessToken;
    }

    public static void refreshAccessToken(final Context context, String str) {
        Oauth2AccessToken readAccessToken = readAccessToken(context);
        if (readAccessToken != null) {
            b.a.k().a(new e(str, readAccessToken, new c<String>() {
                /* class com.sina.weibo.sdk.auth.AccessTokenHelper.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.sina.weibo.sdk.net.c
                public final /* synthetic */ void a(String str) {
                    AccessTokenHelper.writeAccessToken(context, Oauth2AccessToken.parseAccessToken(str));
                }

                @Override // com.sina.weibo.sdk.net.c
                public final void onError(Throwable th) {
                }
            }));
        }
    }

    public static void writeAccessToken(Context context, Oauth2AccessToken oauth2AccessToken) {
        if (context != null && oauth2AccessToken != null && !TextUtils.isEmpty(oauth2AccessToken.getAccessToken())) {
            SharedPreferences.Editor edit = context.getSharedPreferences("com_weibo_sdk_android", 0).edit();
            edit.putString("uid", oauth2AccessToken.getUid());
            edit.putString(ALBiometricsKeys.KEY_USERNAME, oauth2AccessToken.getScreenName());
            edit.putString(Constants.PARAM_ACCESS_TOKEN, oauth2AccessToken.getAccessToken());
            edit.putString("refresh_token", oauth2AccessToken.getRefreshToken());
            edit.putLong(Constants.PARAM_EXPIRES_IN, oauth2AccessToken.getExpiresTime());
            edit.apply();
        }
    }
}
