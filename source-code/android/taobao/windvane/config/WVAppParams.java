package android.taobao.windvane.config;

import android.taobao.windvane.config.UCHASettings;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
public class WVAppParams {
    public String appKey;
    public String appSecret;
    public String appTag;
    public String appVersion;
    public UCHASettings.ConfigRate configRates;
    public int deleteCorePolicy = 0;
    public String deviceId;
    public boolean disableMultiUnknownCrash = false;
    public String imei;
    public String imsi;
    public boolean needSpeed = true;
    public boolean open4GDownload = false;
    public boolean open5GDownload = false;
    public boolean openUCDebug = true;
    public boolean reducePermission = false;
    public String ttid;
    public String uc7ZPath = null;
    public boolean ucCoreOuterControl = false;
    public int ucCoreWaitMills = 4000;
    public Callable<Boolean> ucDownloadChecker;
    public UCHASettings ucHASettings;
    public String ucLibDir = null;
    public boolean ucSdkInternationalEnv = false;
    public String[] ucsdkappkeySec = null;
    public boolean useGlobalUrlConfig = false;
    public boolean zcacheOldConfig = false;
    public boolean zcacheSpeed = false;
    public boolean zcacheType3 = true;
}
