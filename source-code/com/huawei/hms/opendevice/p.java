package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* compiled from: Taobao */
public abstract class p {
    public static String a;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0046, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0052, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0053, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0056, code lost:
        throw r3;
     */
    public static String a() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String trim = readLine.trim();
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
                return trim;
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            return "";
        } catch (IOException unused) {
            HMSLog.e("CommFun", "get current app processes IOException!");
            return "";
        } catch (Exception e) {
            HMSLog.e("CommFun", "get current app processes exception!" + e.getMessage());
            return "";
        }
    }

    public static boolean b() {
        int i = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.d("CommFun", "Emui Api Level:" + i);
        return i > 0;
    }

    public static String c(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            str = context.createDeviceProtectedStorageContext().getDataDir() + "";
        } else {
            str = context.getFilesDir().getParent();
        }
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("CommFun", "get storage root path of the current user failed.");
        }
        return str;
    }

    public static long d(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1;
        }
    }

    public static boolean e(Context context) {
        return b() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && d(context) < 110001400;
    }

    public static String b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            HMSLog.w("CommFun", "get running app processes null!");
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName != null) {
                HMSLog.i("CommFun", "info.pid -> " + runningAppProcessInfo.pid + ", info.processName -> " + runningAppProcessInfo.processName);
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String b = b(context);
        a = b;
        if (!TextUtils.isEmpty(b)) {
            return a;
        }
        String a2 = a();
        a = a2;
        return a2;
    }
}
