package com.taobao.android.riverlogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class RVLRemoteInfo {
    private final String a;
    private final String b;
    private final boolean c = false;
    private final CommandFilter d = null;
    private boolean e = true;

    /* compiled from: Taobao */
    public interface CommandFilter {
        boolean filter(@NonNull String str, @Nullable String str2);
    }

    public RVLRemoteInfo(@NonNull String str, @NonNull String str2) {
        this.a = str;
        this.b = str2;
    }

    public static RVLRemoteInfo f(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("server", null);
            if (optString == null) {
                optString = jSONObject.optString("appWsUrl", null);
                if (optString == null) {
                    return null;
                }
                str2 = jSONObject.optString("debugId", null);
            } else {
                str2 = jSONObject.optString("id", null);
            }
            if (str2 == null) {
                return null;
            }
            return new RVLRemoteInfo(optString, str2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String a() {
        return this.b;
    }

    public CommandFilter b() {
        return this.d;
    }

    public boolean c() {
        if (this.d != null) {
            return false;
        }
        return this.e;
    }

    public String d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }
}
