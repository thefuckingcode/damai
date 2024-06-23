package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class TbsPVConfig extends TbsBaseConfig {
    private static TbsPVConfig b;
    public SharedPreferences mPreferences;

    public interface TbsPVConfigKey {
        public static final String KEY_DISABLED_CORE_VERSION = "disabled_core_version";
        public static final String KEY_EMERGENT_CORE_VERSION = "emergent_core_version";
        public static final String KEY_ENABLE_NO_SHARE_GRAY = "enable_no_share_gray";
        public static final String KEY_GET_LOCALCOREVERSION_MORETIMES = "get_localcoreversion_moretimes";
        public static final String KEY_IS_DISABLE_HOST_BACKUP_CORE = "disable_host_backup";
        public static final String KEY_READ_APK = "read_apk";
        public static final String KEY_TBS_CORE_SANDBOX_MODE_ENABLE = "tbs_core_sandbox_mode_enable";
    }

    @Override // com.tencent.smtt.sdk.TbsBaseConfig
    public String getConfigFileName() {
        return "tbs_pv_config";
    }

    private TbsPVConfig() {
    }

    public static synchronized TbsPVConfig getInstance(Context context) {
        TbsPVConfig tbsPVConfig;
        synchronized (TbsPVConfig.class) {
            if (b == null) {
                TbsPVConfig tbsPVConfig2 = new TbsPVConfig();
                b = tbsPVConfig2;
                tbsPVConfig2.init(context);
            }
            tbsPVConfig = b;
        }
        return tbsPVConfig;
    }

    public static synchronized void releaseInstance() {
        synchronized (TbsPVConfig.class) {
            b = null;
        }
    }

    public synchronized int getLocalCoreVersionMoreTimes() {
        int i;
        i = 0;
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_GET_LOCALCOREVERSION_MORETIMES);
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized int getEmergentCoreVersion() {
        int i;
        i = 0;
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_EMERGENT_CORE_VERSION);
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized int getReadApk() {
        int i;
        i = 0;
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_READ_APK);
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized int getDisabledCoreVersion() {
        int i;
        i = 0;
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_DISABLED_CORE_VERSION);
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public synchronized boolean isEnableNoCoreGray() {
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_ENABLE_NO_SHARE_GRAY);
            if (!TextUtils.isEmpty(str) && str.equals("true")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public synchronized boolean getTbsCoreSandboxModeEnable() {
        try {
            if ("true".equals((String) this.a.get(TbsPVConfigKey.KEY_TBS_CORE_SANDBOX_MODE_ENABLE))) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public synchronized boolean isDisableHostBackupCore() {
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_IS_DISABLE_HOST_BACKUP_CORE);
            if (!TextUtils.isEmpty(str) && str.equals("true")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public synchronized void putData(String str, String str2) {
        this.a.put(str, str2);
    }
}
