package mtopsdk.xstate.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Random;
import mtopsdk.common.util.ConfigStoreManager;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.IDeviceInfo;
import tb.gl1;
import tb.jl1;

/* compiled from: Taobao */
public class PhoneInfo {
    private static final String IMEI = "mtopsdk_imei";
    private static final String IMSI = "mtopsdk_imsi";
    private static final String MACADDRESS = "mtopsdk_mac_address";
    private static final String TAG = "mtopsdk.PhoneInfo";
    private static volatile IDeviceInfo sDeviceInfo;
    private static ConfigStoreManager storeManager = ConfigStoreManager.getInstance();

    private static String generateImei() {
        StringBuilder sb = new StringBuilder();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String valueOf = String.valueOf(currentTimeMillis);
            sb.append(valueOf.substring(valueOf.length() - 5));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.getMODEL().replaceAll(" ", ""));
            while (sb2.length() < 6) {
                sb2.append(YKUpsConvert.CHAR_ZERO);
            }
            sb.append(sb2.substring(0, 6));
            Random random = new Random(currentTimeMillis);
            long j = 0;
            while (j < 4096) {
                j = random.nextLong();
            }
            sb.append(Long.toHexString(j).substring(0, 4));
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[generateImei] error --->" + th.toString());
        }
        return sb.toString();
    }

    @TargetApi(3)
    public static String getAndroidId(Context context) {
        IDeviceInfo iDeviceInfo = sDeviceInfo;
        if (iDeviceInfo != null && !TextUtils.isEmpty(iDeviceInfo.getAndroidId())) {
            return iDeviceInfo.getAndroidId();
        }
        if (context == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[getAndroidId]error ---" + th.toString());
            return null;
        }
    }

    @TargetApi(8)
    public static String getImei(Context context) {
        Throwable th;
        StringBuilder sb = new StringBuilder();
        try {
            StringBuilder sb2 = new StringBuilder(storeManager.getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, IMEI));
            try {
                if (StringUtils.isNotBlank(sb2.toString())) {
                    return new String(Base64.decode(sb2.toString(), 0));
                }
                StringBuilder sb3 = new StringBuilder(TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone")));
                try {
                    StringBuilder sb4 = new StringBuilder((StringUtils.isBlank(sb3.toString()) ? new StringBuilder(generateImei()) : sb3).toString().replaceAll(" ", "").trim());
                    while (sb4.length() < 15) {
                        sb4.insert(0, "0");
                    }
                    storeManager.saveConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, IMEI, Base64.encodeToString(sb4.toString().getBytes(), 0));
                    return sb4.toString().trim();
                } catch (Throwable th2) {
                    th = th2;
                    sb = sb3;
                    TBSdkLog.e(TAG, "[getImei] error ---" + th.toString());
                    return sb.toString();
                }
            } catch (Throwable th3) {
                th = th3;
                sb = sb2;
                TBSdkLog.e(TAG, "[getImei] error ---" + th.toString());
                return sb.toString();
            }
        } catch (Throwable th4) {
            th = th4;
            TBSdkLog.e(TAG, "[getImei] error ---" + th.toString());
            return sb.toString();
        }
    }

    @TargetApi(8)
    public static String getImsi(Context context) {
        StringBuilder sb;
        Throwable th;
        StringBuilder sb2 = new StringBuilder();
        try {
            StringBuilder sb3 = new StringBuilder(storeManager.getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, IMSI));
            try {
                if (StringUtils.isNotBlank(sb3.toString())) {
                    return new String(Base64.decode(sb3.toString(), 0));
                }
                StringBuilder sb4 = new StringBuilder(TelephonyManager.getSubscriberId((android.telephony.TelephonyManager) context.getSystemService("phone")));
                try {
                    sb = new StringBuilder((StringUtils.isBlank(sb4.toString()) ? new StringBuilder(generateImei()) : sb4).toString().replaceAll(" ", "").trim());
                    while (sb.length() < 15) {
                        sb.insert(0, "0");
                    }
                    storeManager.saveConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, IMSI, Base64.encodeToString(sb.toString().getBytes(), 0));
                } catch (Throwable th2) {
                    th = th2;
                    sb2 = sb4;
                    TBSdkLog.e(TAG, "[getImsi]error ---" + th.toString());
                    sb = sb2;
                    return sb.toString();
                }
                return sb.toString();
            } catch (Throwable th3) {
                th = th3;
                sb2 = sb3;
                TBSdkLog.e(TAG, "[getImsi]error ---" + th.toString());
                sb = sb2;
                return sb.toString();
            }
        } catch (Throwable th4) {
            th = th4;
            TBSdkLog.e(TAG, "[getImsi]error ---" + th.toString());
            sb = sb2;
            return sb.toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    @TargetApi(8)
    public static String getLocalMacAddress(Context context) {
        Throwable th;
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            String configItem = storeManager.getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, MACADDRESS);
            try {
                if (StringUtils.isNotBlank(configItem)) {
                    return new String(Base64.decode(configItem, 0));
                }
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        byte[] hardwareAddress = NetworkInterface.getHardwareAddress(java.net.NetworkInterface.getByName("wlan0"));
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        while (i < hardwareAddress.length) {
                            Object[] objArr = new Object[2];
                            objArr[0] = Byte.valueOf(hardwareAddress[i]);
                            objArr[1] = i < hardwareAddress.length - 1 ? ":" : str;
                            sb.append(String.format("%02X%s", objArr));
                            i++;
                        }
                        str = sb.toString();
                    } else {
                        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                        if (connectionInfo != null) {
                            str = com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo);
                        }
                    }
                    if (StringUtils.isNotBlank(str)) {
                        storeManager.saveConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, MACADDRESS, Base64.encodeToString(str.getBytes(), 0));
                    }
                    return str;
                }
                str = configItem;
                if (StringUtils.isNotBlank(str)) {
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                str = configItem;
                TBSdkLog.e(TAG, "[getLocalMacAddress]error ---" + th.toString());
                return str;
            }
        } catch (Throwable th3) {
            th = th3;
            TBSdkLog.e(TAG, "[getLocalMacAddress]error ---" + th.toString());
            return str;
        }
    }

    public static String getOriginalImei(Context context) {
        IDeviceInfo iDeviceInfo = sDeviceInfo;
        if (iDeviceInfo != null && !TextUtils.isEmpty(iDeviceInfo.getImei())) {
            return iDeviceInfo.getImei();
        }
        if (context == null) {
            return null;
        }
        try {
            String deviceId = TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone"));
            if (deviceId != null) {
                return deviceId.trim();
            }
            return deviceId;
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[getOriginalImei]error ---" + th.toString());
            return null;
        }
    }

    public static String getOriginalImsi(Context context) {
        IDeviceInfo iDeviceInfo = sDeviceInfo;
        if (iDeviceInfo != null && !TextUtils.isEmpty(iDeviceInfo.getSubscriberId())) {
            return iDeviceInfo.getSubscriberId();
        }
        if (context == null) {
            return null;
        }
        try {
            String subscriberId = TelephonyManager.getSubscriberId((android.telephony.TelephonyManager) context.getSystemService("phone"));
            if (subscriberId != null) {
                return subscriberId.trim();
            }
            return subscriberId;
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[getOriginalImsi]error ---" + th.toString());
            return null;
        }
    }

    public static String getPhoneBaseInfo(Context context) {
        try {
            String release = Build.VERSION.getRELEASE();
            String manufacturer = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
            String model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
            StringBuilder sb = new StringBuilder(32);
            sb.append("MTOPSDK/");
            sb.append(HttpHeaderConstant.M_SDKVER_VALUE);
            sb.append(" (");
            sb.append("Android");
            sb.append(";");
            sb.append(release);
            sb.append(";");
            sb.append(manufacturer);
            sb.append(";");
            sb.append(model);
            sb.append(jl1.BRACKET_END_STR);
            return sb.toString();
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[getPhoneBaseInfo] error ---" + th.toString());
            return "";
        }
    }

    public static String getSerialNum() {
        IDeviceInfo iDeviceInfo = sDeviceInfo;
        if (iDeviceInfo != null && !TextUtils.isEmpty(iDeviceInfo.getSerialNum())) {
            return iDeviceInfo.getSerialNum();
        }
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[getSerialNum]error ---" + th.toString());
            return null;
        }
    }

    public static void setDeviceInfo(IDeviceInfo iDeviceInfo) {
        if (iDeviceInfo != null) {
            sDeviceInfo = iDeviceInfo;
        }
        if (sDeviceInfo == null) {
            TBSdkLog.e(TAG, "[getLocalMacAddress]setDeviceInfo --- null");
        }
    }
}
