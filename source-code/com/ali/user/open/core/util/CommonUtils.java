package com.ali.user.open.core.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.taobao.windvane.util.NetWork;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.broadcast.LoginAction;
import com.ali.user.open.core.callback.FailureCallback;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.channels.FileLock;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public class CommonUtils {
    public static final String BAICHUAN_TAG = "baichuan_mp";
    public static final String TAG = "ucc.CommonUtils";
    public static String mAppVersion;
    private static String sProcessName;

    public static void addExt(Map<String, String> map) {
        if (ConfigManager.getInstance().isMiniProgram() && map != null) {
            map.put("sdkPlatform", BAICHUAN_TAG);
        }
    }

    private static void createFile(File file, boolean z) {
        if (z) {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getAndroidAppVersion() {
        return "android_" + getAppVersion();
    }

    public static String getAppVersion() {
        if (mAppVersion == null) {
            try {
                PackageInfo packageInfo = KernelContext.getApplicationContext().getPackageManager().getPackageInfo(KernelContext.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    mAppVersion = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return mAppVersion;
    }

    public static boolean getDarkModeStatus(Context context) {
        if (ConfigManager.getInstance().getThemeDataProvider() != null) {
            return ConfigManager.getInstance().getThemeDataProvider().isDark();
        }
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static String getHashString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString(b & 15));
        }
        return sb.toString();
    }

    public static String getLocalIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String getNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                SDKLogger.w(TAG, "can not get Context.CONNECTIVITY_SERVICE");
                return "none";
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null) {
                if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    return "wifi";
                }
            } else {
                SDKLogger.w(TAG, "can not get ConnectivityManager.TYPE_WIFI");
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                if (NetworkInfo.State.CONNECTED == networkInfo2.getState()) {
                    return NetWork.CONN_TYPE_GPRS;
                }
            } else {
                SDKLogger.w(TAG, "can not get ConnectivityManager.TYPE_MOBILE");
            }
            return "none";
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        synchronized (CommonUtils.class) {
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

    public static void handleWebviewDir(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                Log.d(TAG, "handleWebviewDir");
                HashSet<String> hashSet = new HashSet();
                String absolutePath = context.getDataDir().getAbsolutePath();
                String processName = getProcessName(context);
                if (!TextUtils.equals(context.getPackageName(), processName)) {
                    if (TextUtils.isEmpty(processName)) {
                        processName = context.getPackageName();
                    }
                    WebView.setDataDirectorySuffix(processName);
                    String str = JSMethod.NOT_SET + processName;
                    hashSet.add(absolutePath + "/app_webview" + str + "/webview_data.lock");
                    if (isHuaweiRom()) {
                        hashSet.add(absolutePath + "/app_hws_webview" + str + "/webview_data.lock");
                    }
                } else {
                    String str2 = JSMethod.NOT_SET + processName;
                    hashSet.add(absolutePath + "/app_webview" + "/webview_data.lock");
                    hashSet.add(absolutePath + "/app_webview" + str2 + "/webview_data.lock");
                    if (isHuaweiRom()) {
                        hashSet.add(absolutePath + "/app_hws_webview" + "/webview_data.lock");
                        hashSet.add(absolutePath + "/app_hws_webview" + str2 + "/webview_data.lock");
                    }
                }
                for (String str3 : hashSet) {
                    File file = new File(str3);
                    if (file.exists()) {
                        tryLockOrRecreateFile(file);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isHuaweiRom() {
        try {
            return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER().toUpperCase().contains("HUAWEI");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkAvailable() {
        if (KernelContext.getApplicationContext() == null) {
            return true;
        }
        return isNetworkAvailable(KernelContext.getApplicationContext());
    }

    public static void onFailure(final FailureCallback failureCallback, final ResultCode resultCode) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.user.open.core.util.CommonUtils.AnonymousClass1 */

            public void run() {
                FailureCallback failureCallback = failureCallback;
                if (failureCallback != null) {
                    ResultCode resultCode = resultCode;
                    failureCallback.onFailure(resultCode.code, resultCode.message);
                }
            }
        });
    }

    public static void sendBroadcast(LoginAction loginAction, Map<String, String> map) {
        Intent intent = new Intent();
        intent.setAction(loginAction.name());
        intent.setPackage(KernelContext.getApplicationContext().getPackageName());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!(key == null || value == null)) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        KernelContext.getApplicationContext().sendBroadcast(intent);
    }

    public static void sendUT(String str) {
        sendUT(str, null);
    }

    public static String toString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void toast(final String str) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.user.open.core.util.CommonUtils.AnonymousClass3 */

            public void run() {
                Toast.makeText(KernelContext.getApplicationContext(), ResourceUtils.getString(str), 0).show();
            }
        });
    }

    public static void toastSystemException() {
        toast("member_sdk_system_exception");
    }

    @TargetApi(28)
    private static void tryLockOrRecreateFile(File file) {
        try {
            FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (tryLock != null) {
                tryLock.close();
            } else {
                createFile(file, file.delete());
            }
        } catch (Exception e) {
            e.printStackTrace();
            boolean z = false;
            if (file.exists()) {
                z = file.delete();
            }
            createFile(file, z);
        }
    }

    public static void onFailure(final FailureCallback failureCallback, final int i, final String str) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.user.open.core.util.CommonUtils.AnonymousClass2 */

            public void run() {
                FailureCallback failureCallback = failureCallback;
                if (failureCallback != null) {
                    failureCallback.onFailure(i, str);
                }
            }
        });
    }

    public static void sendUT(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && AliMemberSDK.getService(UserTrackerService.class) != null) {
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send(str, map);
        }
    }

    public static void addExt(JSONObject jSONObject) {
        if (ConfigManager.getInstance().isMiniProgram() && jSONObject != null) {
            try {
                jSONObject.put("sdkPlatform", BAICHUAN_TAG);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING)) {
                return true;
            }
        }
        return false;
    }
}
