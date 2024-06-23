package android.taobao.windvane.config;

import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVLocaleConfig {
    private static volatile WVLocaleConfig instance;
    public String mCurrentLocale = null;
    public String mLastLocale = null;

    public static WVLocaleConfig getInstance() {
        if (instance == null) {
            synchronized (WVLocaleConfig.class) {
                if (instance == null) {
                    instance = new WVLocaleConfig();
                }
            }
        }
        return instance;
    }

    public void init() {
        try {
            String stringVal = ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "locale");
            if (!TextUtils.isEmpty(stringVal)) {
                JSONObject jSONObject = new JSONObject(stringVal);
                this.mCurrentLocale = jSONObject.optString("currentLocale", null);
                this.mLastLocale = jSONObject.optString("lastLocale", null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028  */
    public boolean needFull() {
        boolean z;
        String str = this.mCurrentLocale;
        boolean z2 = true;
        if (str != null) {
            String str2 = this.mLastLocale;
            if (str2 == null) {
                this.mLastLocale = str;
            } else if (!str.equals(str2)) {
                this.mLastLocale = this.mCurrentLocale;
            }
            z = true;
            if (this.mLastLocale == null && this.mCurrentLocale == null) {
                this.mLastLocale = null;
            } else {
                z2 = z;
            }
            if (z2) {
                save();
            }
            return z2;
        }
        z = false;
        if (this.mLastLocale == null) {
        }
        z2 = z;
        if (z2) {
        }
        return z2;
    }

    public void save() {
        if (this.mCurrentLocale != null || this.mLastLocale != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("currentLocale", this.mCurrentLocale);
                jSONObject.put("lastLocale", this.mLastLocale);
                WVThreadPool.getInstance().execute(new Runnable() {
                    /* class android.taobao.windvane.config.WVLocaleConfig.AnonymousClass1 */

                    public void run() {
                        ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "locale", jSONObject.toString());
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLocale(String str) {
        this.mCurrentLocale = str;
        save();
    }
}
