package android.taobao.windvane.packageapp.zipapp.data;

import android.support.v4.media.session.PlaybackStateCompat;
import android.taobao.windvane.config.EnvEnum;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.packageapp.WVPackageAppService;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;

/* compiled from: Taobao */
public class ZipAppInfo {
    private ZipAppTypeEnum appType;
    public String errorCode;
    public long f = 5;
    public ArrayList<String> folders = new ArrayList<>();
    public long installedSeq = 0;
    public String installedVersion = "0.0";
    public boolean isDamage = false;
    public boolean isInUse;
    public boolean isInstantApp = false;
    public boolean isOptional = false;
    public boolean isPreViewApp = false;
    public ArrayList<String> localFolders = new ArrayList<>();
    public String mappingUrl = "";
    public String name = "";
    public long s = 0;
    public int status = -1;
    public long t = 0;
    public int tempPriority;
    private ZipUpdateInfoEnum updateInfo;
    private ZipUpdateTypeEnum updateType;
    public String v = "";
    public String z = "";

    /* renamed from: android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$taobao$windvane$config$EnvEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[EnvEnum.values().length];
            $SwitchMap$android$taobao$windvane$config$EnvEnum = iArr;
            iArr[EnvEnum.ONLINE.ordinal()] = 1;
            $SwitchMap$android$taobao$windvane$config$EnvEnum[EnvEnum.PRE.ordinal()] = 2;
            try {
                $SwitchMap$android$taobao$windvane$config$EnvEnum[EnvEnum.DAILY.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public boolean equals(ZipAppInfo zipAppInfo) {
        String str;
        String str2 = this.v;
        if (str2 != null && zipAppInfo != null && (str = zipAppInfo.v) != null && !str2.equals(str)) {
            return false;
        }
        if (zipAppInfo == null || this.s == zipAppInfo.s) {
            return true;
        }
        return false;
    }

    public String genMidPath(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("/");
        sb.append((!z2 && !"0.0".equals(this.installedVersion)) ? this.installedVersion : this.v);
        return sb.toString();
    }

    public ZipAppTypeEnum getAppType() {
        ZipAppTypeEnum[] values = ZipAppTypeEnum.values();
        for (ZipAppTypeEnum zipAppTypeEnum : values) {
            if (zipAppTypeEnum.getValue() == (this.f & 240)) {
                this.appType = zipAppTypeEnum;
                if (zipAppTypeEnum == ZipAppTypeEnum.ZIP_APP_TYPE_MINI_APP) {
                    this.isInstantApp = true;
                    this.appType = ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP;
                }
                return this.appType;
            }
        }
        return ZipAppTypeEnum.ZIP_APP_TYPE_UNKNOWN;
    }

    public ZipUpdateInfoEnum getInfo() {
        ZipUpdateInfoEnum[] values = ZipUpdateInfoEnum.values();
        for (ZipUpdateInfoEnum zipUpdateInfoEnum : values) {
            if (zipUpdateInfoEnum.getValue() == (this.f & 12288)) {
                this.updateInfo = zipUpdateInfoEnum;
                return zipUpdateInfoEnum;
            }
        }
        return ZipUpdateInfoEnum.ZIP_APP_TYPE_NORMAL;
    }

    public boolean getIs2GUpdate() {
        return (this.f & PlaybackStateCompat.ACTION_PREPARE) != 0;
    }

    public boolean getIs3GUpdate() {
        return (this.f & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0;
    }

    public String getNameAndSeq() {
        return this.name + "-" + this.installedSeq;
    }

    public String getNameandVersion() {
        return this.name + JSMethod.NOT_SET + this.v;
    }

    public int getPriority() {
        return (int) (this.f & 15);
    }

    public ZipUpdateTypeEnum getUpdateType() {
        ZipUpdateTypeEnum[] values = ZipUpdateTypeEnum.values();
        for (ZipUpdateTypeEnum zipUpdateTypeEnum : values) {
            if (zipUpdateTypeEnum.getValue() == (this.f & 3840)) {
                this.updateType = zipUpdateTypeEnum;
                return zipUpdateTypeEnum;
            }
        }
        return ZipUpdateTypeEnum.ZIP_UPDATE_TYPE_PASSIVE;
    }

    public String getZipUrl() {
        if (this.z.contains("wapp")) {
            this.z = "";
        }
        WVPackageAppService.IPackageZipPrefixAdapter packageZipPrefixAdapter = WVPackageAppService.getPackageZipPrefixAdapter();
        if (packageZipPrefixAdapter != null) {
            String packageZipPrefix = packageZipPrefixAdapter.getPackageZipPrefix(GlobalConfig.env, this.isPreViewApp);
            if (!TextUtils.isEmpty(packageZipPrefix)) {
                this.z = packageZipPrefix;
                TaoLog.d("ZipURL", "Zip url by app config: [" + this.name + "] " + packageZipPrefix);
            }
        }
        if (TextUtils.isEmpty(this.z)) {
            if (this.isPreViewApp && (isAppInstalled() || this.isInstantApp)) {
                this.isPreViewApp = false;
            }
            if (!this.isPreViewApp) {
                WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
                if (TextUtils.isEmpty(wVCommonConfigData.packageZipPrefix)) {
                    int i = AnonymousClass1.$SwitchMap$android$taobao$windvane$config$EnvEnum[GlobalConfig.env.ordinal()];
                    if (i == 1) {
                        this.z = "https://ossgw.alicdn.com/awp/h5.m.taobao.com/";
                    } else if (i == 2) {
                        this.z = "http://h5.wapa.taobao.com/";
                    } else if (i != 3) {
                        this.z = "https://ossgw.alicdn.com/awp/h5.m.taobao.com/";
                    } else {
                        this.z = "http://h5.waptest.taobao.com/";
                    }
                } else {
                    this.z = wVCommonConfigData.packageZipPrefix;
                }
            } else {
                WVCommonConfigData wVCommonConfigData2 = WVCommonConfig.commonConfig;
                if (TextUtils.isEmpty(wVCommonConfigData2.packageZipPreviewPrefix)) {
                    int i2 = AnonymousClass1.$SwitchMap$android$taobao$windvane$config$EnvEnum[GlobalConfig.env.ordinal()];
                    if (i2 == 1) {
                        this.z = "http://wapp.m.taobao.com/";
                    } else if (i2 == 2) {
                        this.z = "http://wapp.wapa.taobao.com/";
                    } else if (i2 != 3) {
                        this.z = "http://wapp.m.taobao.com/";
                    } else {
                        this.z = "http://wapp.waptest.taobao.com/";
                    }
                } else {
                    this.z = wVCommonConfigData2.packageZipPreviewPrefix;
                }
            }
        }
        StringBuilder sb = new StringBuilder(this.z);
        if ('/' != sb.charAt(sb.length() - 1)) {
            sb.append("/");
        }
        sb.append("app/");
        sb.append(this.name);
        sb.append("/app-");
        sb.append(this.s);
        if (!this.isPreViewApp && !GlobalConfig.env.equals(EnvEnum.PRE) && this.v.equals(this.installedVersion) && this.s != this.installedSeq) {
            sb.append("-incr");
        }
        sb.append(".zip");
        return sb.toString();
    }

    public boolean isAppInstalled() {
        return (0 == this.installedSeq || this.status == ZipAppConstants.ZIP_REMOVED) ? false : true;
    }
}
