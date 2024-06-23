package android.taobao.windvane.jsbridge.api;

import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import anet.channel.status.NetworkStatusHelper;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.taomai.android.h5container.api.TMNetworkPlugin;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.a90;

/* compiled from: Taobao */
public class WVNetwork extends WVApiPlugin {
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    private final int NETWORK_TYPE_1xRTT = 7;
    private final int NETWORK_TYPE_CDMA = 4;
    private final int NETWORK_TYPE_EDGE = 2;
    private final int NETWORK_TYPE_EHRPD = 14;
    private final int NETWORK_TYPE_EVDO_0 = 5;
    private final int NETWORK_TYPE_EVDO_A = 6;
    private final int NETWORK_TYPE_EVDO_B = 12;
    private final int NETWORK_TYPE_GPRS = 1;
    private final int NETWORK_TYPE_GSM = 16;
    private final int NETWORK_TYPE_HSDPA = 8;
    private final int NETWORK_TYPE_HSPA = 10;
    private final int NETWORK_TYPE_HSPAP = 15;
    private final int NETWORK_TYPE_HSUPA = 9;
    private final int NETWORK_TYPE_IDEN = 11;
    private final int NETWORK_TYPE_LTE = 13;
    private final int NETWORK_TYPE_NR = 20;
    private final int NETWORK_TYPE_UMTS = 3;

    /* access modifiers changed from: package-private */
    /* renamed from: android.taobao.windvane.jsbridge.api.WVNetwork$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[NetworkStatusHelper.NetworkStatus.values().length];
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus = iArr;
            iArr[NetworkStatusHelper.NetworkStatus.NONE.ordinal()] = 1;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.NO.ordinal()] = 2;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G2.ordinal()] = 3;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G3.ordinal()] = 4;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G4.ordinal()] = 5;
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.WIFI.ordinal()] = 6;
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G5.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private boolean getNetworkInfoBySystem(WVCallBackContext wVCallBackContext, WVResult wVResult) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) this.mContext.getSystemService("connectivity"));
        } catch (Throwable th) {
            wVResult.addData("msg", th.getMessage());
            wVCallBackContext.error(wVResult);
            networkInfo = null;
        }
        if (networkInfo == null) {
            wVResult.addData("type", "NONE");
            wVCallBackContext.success(wVResult);
            return false;
        } else if (networkInfo.getType() == 1) {
            wVResult.addData("type", "WIFI");
            wVCallBackContext.success(wVResult);
            return false;
        } else {
            switch (networkInfo.getSubtype()) {
                case 1:
                    wVResult.addData("message", "GPRS");
                    wVResult.addData("type", "2G");
                    break;
                case 2:
                    wVResult.addData("message", "EDGE");
                    wVResult.addData("type", "2G");
                    break;
                case 3:
                    wVResult.addData("message", "UMTS");
                    wVResult.addData("type", "3G");
                    break;
                case 4:
                    wVResult.addData("message", "CDMA");
                    wVResult.addData("type", "2G");
                    break;
                case 5:
                    wVResult.addData("message", "EVDO_0");
                    wVResult.addData("type", "3G");
                    break;
                case 6:
                    wVResult.addData("message", "EVDO_A");
                    wVResult.addData("type", "3G");
                    break;
                case 7:
                    wVResult.addData("message", "1xRTT");
                    wVResult.addData("type", "2G");
                    break;
                case 8:
                    wVResult.addData("message", "HSDPA");
                    wVResult.addData("type", "3G");
                    break;
                case 9:
                    wVResult.addData("message", "HSUPA");
                    wVResult.addData("type", "3G");
                    break;
                case 10:
                    wVResult.addData("message", "HSPA");
                    wVResult.addData("type", "3G");
                    break;
                case 11:
                    wVResult.addData("message", "IDEN");
                    wVResult.addData("type", "2G");
                    break;
                case 12:
                    wVResult.addData("message", "EVDO_B");
                    wVResult.addData("type", "3G");
                    break;
                case 13:
                    wVResult.addData("message", "LTE");
                    wVResult.addData("type", "4G");
                    break;
                case 14:
                    wVResult.addData("message", "EHRPD");
                    wVResult.addData("type", "3G");
                    break;
                case 15:
                    wVResult.addData("message", "HSPAP");
                    wVResult.addData("type", "3G");
                    break;
                case 16:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "GSM");
                        wVResult.addData("type", "2G");
                        break;
                    }
                case 17:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "TD_SCDMA");
                        wVResult.addData("type", "3G");
                        break;
                    }
                case 18:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "IWLAN");
                        wVResult.addData("type", "WIFI");
                        break;
                    }
                case 19:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "LTE_CA");
                        wVResult.addData("type", "4G");
                        break;
                    }
                case 20:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "NR");
                        wVResult.addData("type", "5G");
                        break;
                    }
                default:
                    wVResult.addData("type", "UNKNOWN");
                    break;
            }
            return true;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!TMNetworkPlugin.ACTION_NETWORK.equals(str)) {
            return false;
        }
        getNetworkType(str2, wVCallBackContext);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028 A[SYNTHETIC, Splitter:B:11:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e A[SYNTHETIC, Splitter:B:22:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A[SYNTHETIC, Splitter:B:31:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0108  */
    public final void getNetworkType(String str, WVCallBackContext wVCallBackContext) {
        boolean z;
        boolean z2;
        WVResult wVResult = new WVResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            z = jSONObject.optBoolean("wifiStatus", false);
            try {
                z2 = jSONObject.optBoolean("wifiList", false);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            z = false;
            z2 = false;
            if (z) {
            }
            if (z2) {
            }
            WVCommonConfig.getInstance();
            if (!WVCommonConfig.commonConfig.open5GAdapter) {
            }
            wVCallBackContext.success(wVResult);
        }
        if (z) {
            try {
                WifiInfo connectionInfo = ((WifiManager) this.mContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    String ssid = connectionInfo.getSSID();
                    if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
                        ssid = ssid.substring(1, ssid.length() - 1);
                    }
                    wVResult.addData("ssid", ssid);
                    wVResult.addData(a90.BSSID, connectionInfo.getBSSID());
                }
            } catch (Throwable unused3) {
            }
        }
        if (z2) {
            try {
                WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
                wifiManager.startScan();
                JSONArray jSONArray = new JSONArray();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                for (int i = 0; i < scanResults.size(); i++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ssid", scanResults.get(i).SSID);
                    jSONObject2.put(a90.BSSID, scanResults.get(i).BSSID);
                    jSONArray.put(jSONObject2);
                }
                wVResult.addData("wifiList", jSONArray);
            } catch (Throwable unused4) {
            }
        }
        WVCommonConfig.getInstance();
        if (!WVCommonConfig.commonConfig.open5GAdapter) {
            try {
                NetworkStatusHelper.NetworkStatus i2 = NetworkStatusHelper.i();
                String e = NetworkStatusHelper.e();
                switch (AnonymousClass1.$SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[i2.ordinal()]) {
                    case 1:
                        wVResult.addData("type", "NONE");
                        break;
                    case 2:
                        wVResult.addData("type", "NO");
                        break;
                    case 3:
                        wVResult.addData("type", "2G");
                        break;
                    case 4:
                        wVResult.addData("type", "3G");
                        break;
                    case 5:
                        wVResult.addData("type", "4G");
                        break;
                    case 6:
                        wVResult.addData("type", "WIFI");
                        break;
                    case 7:
                        wVResult.addData("type", "5G");
                        break;
                    default:
                        wVResult.addData("type", "UNKNOWN");
                        break;
                }
                wVResult.addData("message", e);
            } catch (Throwable th) {
                if (getNetworkInfoBySystem(wVCallBackContext, wVResult)) {
                    wVResult.addData("", th.getMessage());
                    wVCallBackContext.error(wVResult);
                    return;
                }
                return;
            }
        } else if (!getNetworkInfoBySystem(wVCallBackContext, wVResult)) {
            return;
        }
        wVCallBackContext.success(wVResult);
    }

    public StringBuffer lookUpScan(List<ScanResult> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < list.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index_");
            int i2 = i + 1;
            sb.append(new Integer(i2).toString());
            sb.append(":");
            stringBuffer.append(sb.toString());
            stringBuffer.append(list.get(i).SSID.toString());
            stringBuffer.append(StringUtils.LF);
            i = i2;
        }
        return stringBuffer;
    }
}
