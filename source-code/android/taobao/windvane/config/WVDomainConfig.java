package android.taobao.windvane.config;

import android.taobao.windvane.config.WVConfigUpdateCallback;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVDomainConfig {
    private static final String TAG = "WVDomainConfig";
    private static volatile WVDomainConfig instance;
    private String forbiddenDomainRedirectURL = "";

    public static WVDomainConfig getInstance() {
        if (instance == null) {
            synchronized (WVDomainConfig.class) {
                if (instance == null) {
                    instance = new WVDomainConfig();
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean parseConfig(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("v", "");
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        String optString2 = jSONObject.optString("aliDomain", "");
        String optString3 = jSONObject.optString("thirdPartyDomain", "");
        String optString4 = jSONObject.optString("supportDownloadDomain", "");
        String optString5 = jSONObject.optString("forbiddenDomain", "");
        String optString6 = jSONObject.optString("allowAccessDomain", "");
        this.forbiddenDomainRedirectURL = jSONObject.optString("forbiddenDomainRedirectURL", "");
        if (!TextUtils.isEmpty(optString2)) {
            WVServerConfig.DOMAIN_PATTERN = optString2;
            WVServerConfig.domainPat = null;
        }
        if (!TextUtils.isEmpty(optString3)) {
            WVServerConfig.THIRD_PARTY_DOMAIN_PATTERN = optString3;
            WVServerConfig.thirdPartyDomain = null;
        }
        if (!TextUtils.isEmpty(optString4)) {
            WVServerConfig.SUPPORT_DOWNLOAD_DOMAIN_PATTERN = optString4;
            WVServerConfig.supportDownloadDomain = null;
        }
        if (!TextUtils.isEmpty(optString6)) {
            WVServerConfig.ALLOW_ACCESS_DOMAIN_PATTERN = optString6;
            WVServerConfig.allowAccessDomain = null;
        }
        if (!TextUtils.isEmpty(optString5)) {
            WVServerConfig.FORBIDDEN_DOMAIN_PATTERN = optString5;
            WVServerConfig.forbiddenDomain = null;
            if (!TextUtils.isEmpty(this.forbiddenDomainRedirectURL) && WVServerConfig.isBlackUrl(this.forbiddenDomainRedirectURL)) {
                this.forbiddenDomainRedirectURL = "";
            }
        }
        WVServerConfig.v = optString;
        return true;
    }

    public String getForbiddenDomainRedirectURL() {
        return this.forbiddenDomainRedirectURL;
    }

    public void init() {
        parseConfig(ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "domainwv-data"));
    }

    public void updateDomainRule(final WVConfigUpdateCallback wVConfigUpdateCallback, final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = WVConfigManager.getInstance().getConfigUrl("2", WVServerConfig.v, WVConfigUtils.getTargetValue(), str2);
        }
        ConnectManager.getInstance().connectSync(str, new HttpConnectListener<HttpResponse>() {
            /* class android.taobao.windvane.config.WVDomainConfig.AnonymousClass1 */

            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onError(int i, String str) {
                WVConfigUpdateCallback wVConfigUpdateCallback = wVConfigUpdateCallback;
                if (wVConfigUpdateCallback != null) {
                    wVConfigUpdateCallback.updateError(str, str);
                    wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UNKNOWN_ERROR, 0);
                }
                TaoLog.d(WVDomainConfig.TAG, "update domain failed! : " + str);
                super.onError(i, str);
            }

            public void onFinish(HttpResponse httpResponse, int i) {
                if (wVConfigUpdateCallback != null) {
                    if (httpResponse == null || httpResponse.getData() == null) {
                        wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.NULL_DATA, 0);
                        return;
                    }
                    try {
                        String str = new String(httpResponse.getData(), "utf-8");
                        if (WVDomainConfig.this.parseConfig(str)) {
                            ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "domainwv-data", str);
                            wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.SUCCESS, 1);
                            return;
                        }
                        wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.NO_VERSION, 0);
                    } catch (UnsupportedEncodingException e) {
                        wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.ENCODING_ERROR, 0);
                        TaoLog.e(WVDomainConfig.TAG, "config encoding error. " + e.getMessage());
                    }
                }
            }
        });
    }
}
