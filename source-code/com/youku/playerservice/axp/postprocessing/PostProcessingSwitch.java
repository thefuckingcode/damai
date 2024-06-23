package com.youku.playerservice.axp.postprocessing;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.utils.Logger;
import java.util.Arrays;

/* compiled from: Taobao */
public class PostProcessingSwitch {
    static final String SWITCH_KEY = "switch_key";
    static final String SWITCH_NAMESPACE = "switch_namespace";
    static final String SWITCH_ON = "switch_on";
    static final String SWITCH_TYPE = "switch_type";
    private static String TAG = "PostProcessing-Switch";
    static final String TYPE_APS = "type_aps";
    static final String TYPE_SETTINGS = "type_setting";

    private static boolean isApsOn(JSONObject jSONObject) {
        String string = jSONObject.getString(SWITCH_NAMESPACE);
        String string2 = jSONObject.getString(SWITCH_KEY);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return false;
        }
        String config = ConfigFetcher.getInstance().getConfig(string, string2, null);
        String string3 = jSONObject.getString(SWITCH_ON);
        if (TextUtils.isEmpty(string3)) {
            return false;
        }
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "isApsOn namespace=" + string + " key=" + string2 + " switchOn=" + string3 + " value=" + config);
        }
        return Arrays.asList(string3.split(",")).contains(config);
    }

    public static boolean isOn(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = JSON.parseObject(str);
        } catch (Exception unused) {
        }
        if (jSONObject == null) {
            return false;
        }
        if (Logger.DEBUG) {
            String str2 = TAG;
            Logger.d(str2, "isOn? " + jSONObject);
        }
        String string = jSONObject.getString(SWITCH_TYPE);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        string.hashCode();
        if (string.equals(TYPE_APS)) {
            return isApsOn(jSONObject);
        }
        if (string.equals(TYPE_SETTINGS) && context != null) {
            return isSettingOn(context, jSONObject);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0080 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081  */
    private static boolean isSettingOn(Context context, @NonNull JSONObject jSONObject) {
        String string;
        String string2;
        String string3 = jSONObject.getString(SWITCH_KEY);
        String str = null;
        try {
            if (TextUtils.isEmpty(string3)) {
                return false;
            }
            String uri = Settings.System.CONTENT_URI.toString();
            if (string3.startsWith(uri)) {
                string2 = Settings.System.getString(context.getContentResolver(), string3.substring(uri.length() + 1));
            } else {
                String uri2 = Settings.Secure.CONTENT_URI.toString();
                if (string3.startsWith(uri2)) {
                    string2 = Settings.Secure.getString(context.getContentResolver(), string3.substring(uri2.length() + 1));
                } else {
                    if (Build.VERSION.SDK_INT >= 17) {
                        String uri3 = Settings.Global.CONTENT_URI.toString();
                        if (string3.startsWith(uri3)) {
                            string2 = Settings.Global.getString(context.getContentResolver(), string3.substring(uri3.length() + 1));
                        }
                    }
                    string = jSONObject.getString(SWITCH_ON);
                    if (!TextUtils.isEmpty(string)) {
                        return false;
                    }
                    if (Logger.DEBUG) {
                        String str2 = TAG;
                        Logger.d(str2, "isSettingOn key=" + string3 + " switchOn=" + string + " value=" + str);
                    }
                    return Arrays.asList(string.split(",")).contains(str);
                }
            }
            str = string2;
            string = jSONObject.getString(SWITCH_ON);
            if (!TextUtils.isEmpty(string)) {
            }
        } catch (Exception unused) {
        }
    }
}
