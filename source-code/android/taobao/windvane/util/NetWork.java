package android.taobao.windvane.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.taobao.windvane.config.GlobalConfig;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHost;

/* compiled from: Taobao */
public class NetWork {
    public static final int CHINA_MOBILE = 1;
    public static final int CHINA_TELECOM = 3;
    public static final int CHINA_UNICOM = 2;
    public static final String CONN_TYPE_GPRS = "gprs";
    public static final String CONN_TYPE_NONE = "none";
    public static final String CONN_TYPE_WIFI = "wifi";
    public static final int SIM_NO = -1;
    public static final int SIM_OK = 0;
    public static final int SIM_UNKNOW = -2;
    private static BroadcastReceiver connChangerRvr;
    public static boolean proxy;

    public static HttpHost getHttpsProxyInfo(Context context) {
        NetworkInfo networkInfo;
        if (Build.VERSION.SDK_INT < 11) {
            try {
                networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            } catch (Exception e) {
                e.printStackTrace();
                networkInfo = null;
            }
            if (networkInfo == null || !networkInfo.isAvailable() || networkInfo.getType() != 0) {
                return null;
            }
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost != null) {
                return new HttpHost(defaultHost, defaultPort);
            }
            return null;
        }
        String property = System.getProperty("https.proxyHost");
        String property2 = System.getProperty("https.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            return new HttpHost(property, Integer.parseInt(property2));
        }
        return null;
    }

    public static int getNSP(Context context) {
        if (getSimState(context) != 0) {
            return -1;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String replaceAll = telephonyManager.getNetworkOperatorName().replaceAll(" ", "");
        String networkOperator = telephonyManager.getNetworkOperator();
        TaoLog.d("NSP: ", "operator = " + replaceAll + "  type = " + networkOperator);
        if (networkOperator != null) {
            replaceAll = networkOperator;
        }
        if (replaceAll == null || replaceAll.length() == 0) {
            return -2;
        }
        if (replaceAll.compareToIgnoreCase("中国移动") == 0 || replaceAll.compareToIgnoreCase("CMCC") == 0 || replaceAll.compareToIgnoreCase("ChinaMobile") == 0 || replaceAll.compareToIgnoreCase("46000") == 0) {
            return 1;
        }
        if (replaceAll.compareToIgnoreCase("中国电信") == 0 || replaceAll.compareToIgnoreCase("ChinaTelecom") == 0 || replaceAll.compareToIgnoreCase("46003") == 0 || replaceAll.compareToIgnoreCase("ChinaTelcom") == 0 || replaceAll.compareToIgnoreCase("460003") == 0) {
            return 3;
        }
        if (replaceAll.compareToIgnoreCase("中国联通") == 0 || replaceAll.compareToIgnoreCase("ChinaUnicom") == 0 || replaceAll.compareToIgnoreCase("46001") == 0 || replaceAll.compareToIgnoreCase("CU-GSM") == 0 || replaceAll.compareToIgnoreCase("CHN-CUGSM") == 0 || replaceAll.compareToIgnoreCase("CHNUnicom") == 0) {
            return 2;
        }
        String imsi = PhoneInfo.getImsi(context);
        if (imsi.startsWith("46000") || imsi.startsWith("46002") || imsi.startsWith("46007")) {
            return 1;
        }
        if (imsi.startsWith("46001")) {
            return 2;
        }
        if (imsi.startsWith("46003")) {
            return 3;
        }
        return -2;
    }

    public static String getNetConnType(Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            TaoLog.w("Network", "can not get Context.CONNECTIVITY_SERVICE");
            return "none";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                return "wifi";
            }
        } else {
            TaoLog.w("Network", "can not get ConnectivityManager.TYPE_WIFI");
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo2.getState()) {
                return CONN_TYPE_GPRS;
            }
        } else {
            TaoLog.w("Network", "can not get ConnectivityManager.TYPE_MOBILE");
        }
        return "none";
    }

    public static Map<String, String> getNetWorkSubTypeMap(Context context) {
        NetworkInfo networkInfo;
        String str;
        HashMap hashMap = new HashMap(2);
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            str = "";
        } catch (Throwable th) {
            str = th.getMessage();
            networkInfo = null;
        }
        if (networkInfo == null) {
            hashMap.put("message", str);
            hashMap.put("type", "NONE");
            return hashMap;
        } else if (networkInfo.getType() == 1) {
            hashMap.put("message", str);
            hashMap.put("type", "WIFI");
            return hashMap;
        } else {
            String str2 = "2G";
            switch (networkInfo.getSubtype()) {
                case 1:
                    str = "GPRS";
                    break;
                case 2:
                    str = "EDGE";
                    break;
                case 3:
                    str = "UMTS";
                    str2 = "3G";
                    break;
                case 4:
                    str = "CDMA";
                    break;
                case 5:
                    str = "EVDO_0";
                    str2 = "3G";
                    break;
                case 6:
                    str = "EVDO_A";
                    str2 = "3G";
                    break;
                case 7:
                    str = "1xRTT";
                    break;
                case 8:
                    str = "HSDPA";
                    str2 = "3G";
                    break;
                case 9:
                    str = "HSUPA";
                    str2 = "3G";
                    break;
                case 10:
                    str = "HSPA";
                    str2 = "3G";
                    break;
                case 11:
                    str = "IDEN";
                    break;
                case 12:
                    str = "EVDO_B";
                    str2 = "3G";
                    break;
                case 13:
                    str = "LTE";
                    str2 = "4G";
                    break;
                case 14:
                    str = "EHRPD";
                    str2 = "3G";
                    break;
                case 15:
                    str = "HSPAP";
                    str2 = "3G";
                    break;
                default:
                    str2 = "UNKNOWN";
                    break;
            }
            hashMap.put("message", str);
            hashMap.put("type", str2);
            return hashMap;
        }
    }

    public static String getNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
            return null;
        }
        NetworkInfo.State state = activeNetworkInfo.getState();
        if (state != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING) {
            return null;
        }
        return activeNetworkInfo.getTypeName() + " " + activeNetworkInfo.getSubtypeName() + activeNetworkInfo.getExtraInfo();
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return -9;
        }
        return activeNetworkInfo.getType();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        if (r12 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a9  */
    public static HashMap<String, String> getProxyInfo(Context context, Uri uri) {
        Cursor cursor;
        Throwable th;
        String networkInfo = getNetworkInfo(context);
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor2 = null;
        if (networkInfo == null) {
            return null;
        }
        TaoLog.d("getProxyInfo", "current network:" + networkInfo);
        if (networkInfo.contains("WIFI") || networkInfo.compareToIgnoreCase("MOBILE UMTS") == 0) {
            return hashMap;
        }
        try {
            cursor = context.getContentResolver().query(uri, null, "mcc =?", new String[]{"460"}, null);
            try {
                if (cursor.moveToFirst()) {
                    do {
                        if (cursor.getCount() > 0) {
                            hashMap.put("host", cursor.getString(cursor.getColumnIndex("proxy")));
                            hashMap.put("port", cursor.getString(cursor.getColumnIndex("port")));
                            String string = cursor.getString(cursor.getColumnIndex("apn"));
                            TaoLog.d("getProxyInfo", "apn:" + string);
                            if (networkInfo.contains(string)) {
                                cursor.close();
                                return hashMap;
                            }
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        cursor.close();
        return null;
    }

    public static int getSimState(Context context) {
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        if (simState == 5) {
            return 0;
        }
        return simState == 1 ? -1 : -2;
    }

    public static boolean isAvailable(Context context) {
        return getNetworkType(context) >= 0;
    }

    public static boolean isConnectionInexpensive() {
        return isWiFiActive() || isEthernetActive(GlobalConfig.context);
    }

    public static boolean isEthernetActive(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return getNetworkType(context) == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWiFiActive() {
        return isWiFiActive(GlobalConfig.context);
    }

    public static void setProxy(String str, String str2) {
        if (str == null || str.length() == 0) {
            System.getProperties().put("proxySet", "false");
            proxy = false;
            return;
        }
        proxy = true;
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("proxyHost", str);
        if (str2 == null || str2.length() <= 0) {
            System.getProperties().put("proxyPort", "80");
        } else {
            System.getProperties().put("proxyPort", str2);
        }
    }

    public static void unRegNetWorkRev(Context context) {
        setProxy(null, null);
        try {
            BroadcastReceiver broadcastReceiver = connChangerRvr;
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isWiFiActive(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return getNetworkType(context) == 1;
        } catch (Exception unused) {
            return false;
        }
    }
}
