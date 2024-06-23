package com.youku.usercenter.passport.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.cert.CertificateFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public final class SysUtil {
    private static String sPkgKeyDigest;
    private static String sProcessName;
    private static Toast sToast;

    public static String getApkPublicKeyDigest(Context context) {
        if (context != null && TextUtils.isEmpty(sPkgKeyDigest)) {
            sPkgKeyDigest = getApkPublicKeyDigest(context, context.getPackageName());
        }
        return sPkgKeyDigest;
    }

    public static String getAppName(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(str, 0).applicationInfo.loadLabel(packageManager).toString().trim();
        } catch (Throwable th) {
            Logger.printStackTrace(th);
            return null;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getBSSID(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getBSSID();
            }
            return null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getDeviceBrand() {
        return Build.getMANUFACTURER();
    }

    public static String getDeviceId(Context context) {
        if (context == null) {
            return null;
        }
        return UTDevice.getUtdid(context);
    }

    public static String getDeviceIp() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        String hostAddress = inetAddress.getHostAddress();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return hostAddress;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getDeviceMac() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return EncryptUtil.toHexString(com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface.getHardwareAddress(networkInterface), ":", false);
                        }
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getDeviceModel() {
        return Build.getMODEL();
    }

    public static Drawable getDialogBgRes(Context context) {
        Resources resources = context.getResources();
        if (resources == null) {
            return null;
        }
        try {
            int identifier = resources.getIdentifier("dialog_gradient_bg", "drawable", context.getPackageName());
            if (identifier > 0) {
                return resources.getDrawable(identifier);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getImei(Context context) {
        try {
            return TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone"));
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static double[] getLocation(Context context) {
        Location lastKnownLocation;
        if (context == null) {
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider == null || (lastKnownLocation = com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.getLastKnownLocation(locationManager, bestProvider)) == null) {
                return null;
            }
            return new double[]{com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(lastKnownLocation), com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(lastKnownLocation)};
        } catch (SecurityException e) {
            Logger.printStackTrace(e);
        } catch (Exception e2) {
            Logger.printStackTrace(e2);
        }
        return null;
    }

    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null) {
                return "";
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return "WIFI";
            }
            if (type != 0) {
                return "OTHER";
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            return String.valueOf(getNetworkType30(context));
        } catch (Exception unused) {
            Logger.e("Get network type failed");
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    private static int getNetworkType30(Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT < 30) {
                return TelephonyManager.getNetworkType(telephonyManager);
            }
            return TelephonyManager.getDataNetworkType(telephonyManager);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getOSVersion() {
        return Build.VERSION.getRELEASE();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[SYNTHETIC, Splitter:B:33:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0092 A[SYNTHETIC, Splitter:B:50:0x0092] */
    public static String getProcessName(Context context) {
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        String str = sProcessName;
        if (str != null) {
            return str;
        }
        synchronized (SysUtil.class) {
            String str2 = sProcessName;
            if (str2 != null) {
                return str2;
            }
            int myPid = Process.myPid();
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/" + myPid + "/cmdline"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = bufferedReader.read();
                        if (read <= 0) {
                            break;
                        }
                        sb.append((char) read);
                    }
                    String sb2 = sb.toString();
                    sProcessName = sb2;
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return sb2;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                        }
                        while (r7.hasNext()) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                e.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str3 = runningAppProcessInfo.processName;
                        sProcessName = str3;
                        return str3;
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static String getRunningInfo() {
        try {
            return String.format(Locale.CHINESE, "[%s, %d][SDK]", getProcessName(null), Long.valueOf(Thread.currentThread().getId()));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getSSID(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
            return null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getScreenSize(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) + Constants.Name.X + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static Drawable getTlIcon(Context context, String str) {
        Resources resources = context.getResources();
        if (resources == null) {
            return null;
        }
        try {
            int identifier = resources.getIdentifier("passport_icon_tl_" + str, "drawable", context.getPackageName());
            if (identifier > 0) {
                return resources.getDrawable(identifier);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getTlName(Context context, String str) {
        Resources resources = context.getResources();
        if (resources == null) {
            return "";
        }
        try {
            int identifier = resources.getIdentifier("passport_tl_" + str, "string", context.getPackageName());
            if (identifier > 0) {
                return resources.getString(identifier);
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean hasActiveNetwork(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity")) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return false;
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
    }

    public static boolean isSupportYoukuAuth(Context context) {
        return false;
    }

    public static boolean popAllFragments(Activity activity) {
        try {
            return activity.getFragmentManager().popBackStackImmediate((String) null, 1);
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return false;
        }
    }

    public static String readThreadStack() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void showQuickToast(Context context, String str) {
    }

    public static boolean supportDial(Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() == 1 || telephonyManager.getSimState() == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042 A[SYNTHETIC, Splitter:B:17:0x0042] */
    public static String getApkPublicKeyDigest(Context context, String str) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        try {
            byteArrayInputStream = new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
            try {
                String encryptMD5 = EncryptUtil.encryptMD5(CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey().toString(), true);
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return encryptMD5;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Logger.printStackTrace(th);
                    return null;
                } finally {
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            Logger.printStackTrace(th);
            return null;
        }
    }
}
