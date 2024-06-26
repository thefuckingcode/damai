package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.f.b;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Locale;

/* compiled from: Taobao */
public class GrsBaseInfo implements Cloneable {
    private static final String TAG = GrsBaseInfo.class.getSimpleName();
    private String androidVersion;
    private String appName;
    private String countrySource;
    private String deviceModel;
    private String issueCountry;
    private String regCountry;
    private String romVersion;
    private String serCountry;
    private String uid;
    private String versionName;

    /* compiled from: Taobao */
    public @interface CountryCodeSource {
        public static final String APP = "APP";
        public static final String LOCALE_INFO = "LOCALE_INFO";
        public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
        public static final String SIM_COUNTRY = "SIM_COUNTRY";
        public static final String UNKNOWN = "UNKNOWN";
        public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    }

    public GrsBaseInfo() {
    }

    public GrsBaseInfo(Context context) {
        this.issueCountry = GrsApp.getInstance().getIssueCountryCode(context);
    }

    private StringBuffer getStringBuffer(StringBuffer stringBuffer, boolean z, Context context) {
        String androidVersion2 = getAndroidVersion();
        if (!TextUtils.isEmpty(androidVersion2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("android_version");
            stringBuffer.append("=");
            stringBuffer.append(androidVersion2);
        }
        String romVersion2 = getRomVersion();
        if (!TextUtils.isEmpty(romVersion2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("rom_version");
            stringBuffer.append("=");
            stringBuffer.append(romVersion2);
        }
        String deviceModel2 = getDeviceModel();
        if (!TextUtils.isEmpty(deviceModel2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append(IRequestConst.DEVICE_MODEL);
            stringBuffer.append("=");
            stringBuffer.append(deviceModel2);
        }
        String countrySource2 = getCountrySource();
        if (!TextUtils.isEmpty(countrySource2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("country_source");
            stringBuffer.append("=");
            stringBuffer.append(countrySource2);
        }
        if (!TextUtils.isEmpty(stringBuffer.toString())) {
            stringBuffer.append("&");
        }
        stringBuffer.append("package_name");
        stringBuffer.append("=");
        stringBuffer.append(context.getPackageName());
        return stringBuffer;
    }

    private boolean isEqual(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    @Override // java.lang.Object
    public GrsBaseInfo clone() {
        return (GrsBaseInfo) super.clone();
    }

    public boolean compare(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GrsBaseInfo.class != obj.getClass() || !(obj instanceof GrsBaseInfo)) {
            return false;
        }
        GrsBaseInfo grsBaseInfo = (GrsBaseInfo) obj;
        return isEqual(this.serCountry, grsBaseInfo.serCountry) && isEqual(this.versionName, grsBaseInfo.versionName) && isEqual(this.appName, grsBaseInfo.appName) && isEqual(this.uid, grsBaseInfo.uid) && isEqual(this.regCountry, grsBaseInfo.regCountry) && isEqual(this.issueCountry, grsBaseInfo.issueCountry) && isEqual(this.androidVersion, grsBaseInfo.androidVersion) && isEqual(this.romVersion, grsBaseInfo.romVersion) && isEqual(this.deviceModel, grsBaseInfo.deviceModel) && isEqual(this.countrySource, grsBaseInfo.countrySource);
    }

    public GrsBaseInfo copy() {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setAppName(this.appName);
        grsBaseInfo.setSerCountry(this.serCountry);
        grsBaseInfo.setRegCountry(this.regCountry);
        grsBaseInfo.setIssueCountry(this.issueCountry);
        grsBaseInfo.setCountrySource(this.countrySource);
        grsBaseInfo.setAndroidVersion(this.androidVersion);
        grsBaseInfo.setDeviceModel(this.deviceModel);
        grsBaseInfo.setRomVersion(this.romVersion);
        grsBaseInfo.setUid(this.uid);
        grsBaseInfo.setVersionName(this.versionName);
        return grsBaseInfo;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getGrsParasKey(boolean z, boolean z2, Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        b a = b.a(context.getPackageName(), this);
        a a2 = a != null ? a.a() : null;
        String grsReqParamJoint = getGrsReqParamJoint(z, z2, a2 != null ? a2.b() : "", context);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append(grsReqParamJoint);
        }
        return stringBuffer.toString();
    }

    public String getGrsReqParamJoint(boolean z, boolean z2, String str, Context context) {
        String a;
        StringBuffer stringBuffer = new StringBuffer();
        if ("1.0".equals(str)) {
            Logger.v(TAG, "1.0 interface has no query param appname");
        } else {
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("app_name");
                stringBuffer.append("=");
            } else if (!TextUtils.isEmpty(getAppName())) {
                stringBuffer.append("app_name");
                stringBuffer.append("=");
                str = getAppName();
            }
            stringBuffer.append(str);
        }
        String versionName2 = getVersionName();
        if (!TextUtils.isEmpty(versionName2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("app_version");
            stringBuffer.append("=");
            stringBuffer.append(versionName2);
        }
        String uid2 = getUid();
        if (!TextUtils.isEmpty(uid2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("uid");
            stringBuffer.append("=");
            if (z) {
                a = com.huawei.hms.framework.network.grs.h.b.b(uid2);
            } else if (z2) {
                a = com.huawei.hms.framework.network.grs.h.b.a(uid2);
            } else {
                stringBuffer.append(uid2);
            }
            stringBuffer.append(a);
        }
        String regCountry2 = getRegCountry();
        if (!TextUtils.isEmpty(regCountry2) && !"UNKNOWN".equals(regCountry2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("reg_country");
            stringBuffer.append("=");
            stringBuffer.append(regCountry2);
        }
        String serCountry2 = getSerCountry();
        if (!TextUtils.isEmpty(serCountry2) && !"UNKNOWN".equals(serCountry2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("ser_country");
            stringBuffer.append("=");
            stringBuffer.append(serCountry2);
        }
        String issueCountry2 = getIssueCountry();
        if (!TextUtils.isEmpty(issueCountry2) && !"UNKNOWN".equals(issueCountry2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append("&");
            }
            stringBuffer.append("issue_country");
            stringBuffer.append("=");
            stringBuffer.append(issueCountry2);
        }
        return getStringBuffer(stringBuffer, z2, context).toString();
    }

    public String getIssueCountry() {
        return this.issueCountry;
    }

    public String getRegCountry() {
        return this.regCountry;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public String getSerCountry() {
        return this.serCountry;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAndroidVersion(String str) {
        this.androidVersion = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCountrySource(String str) {
        this.countrySource = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    @Deprecated
    public void setIssueCountry(String str) {
        this.issueCountry = str != null ? str.toUpperCase(Locale.ENGLISH) : "";
    }

    public void setRegCountry(String str) {
        this.regCountry = str != null ? str.toUpperCase(Locale.ENGLISH) : "";
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public void setSerCountry(String str) {
        this.serCountry = str != null ? str.toUpperCase(Locale.ENGLISH) : "";
    }

    @Deprecated
    public void setUid(String str) {
        this.uid = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public int uniqueCode() {
        return (this.appName + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.serCountry + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.regCountry + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.issueCountry).hashCode();
    }
}
