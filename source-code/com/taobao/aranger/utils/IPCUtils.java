package com.taobao.aranger.utils;

import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
public class IPCUtils {
    public static final String TAG = "IPCUtils";
    private static final List<ProviderInfo> providerInfoList = new CopyOnWriteArrayList();
    private static final Set<String> providerInfoSet = new CopyOnWriteArraySet();
    private static ActivityManager sActivityManager;
    private static String sCurrentProcessName;

    public static String getAuthorityWithoutUserId(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(64) + 1);
    }

    private static Uri getContentAuthorities(String str) {
        return Uri.parse("content://" + str);
    }

    public static String getCurrentProcessName() {
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            if (Build.VERSION.SDK_INT >= 28) {
                sCurrentProcessName = Application.getProcessName();
            } else {
                sCurrentProcessName = ActivityThread.currentProcessName();
            }
            if (TextUtils.isEmpty(sCurrentProcessName)) {
                sCurrentProcessName = getProcessName(Process.myPid());
            }
        }
        return sCurrentProcessName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0089 A[SYNTHETIC, Splitter:B:37:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0096 A[SYNTHETIC, Splitter:B:43:0x0096] */
    private static String getProcessName(int i) {
        Throwable th;
        Exception e;
        if (sActivityManager == null) {
            sActivityManager = (ActivityManager) ARanger.getContext().getSystemService("activity");
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = sActivityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String readLine = bufferedReader2.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader2.close();
                } catch (IOException e2) {
                    Log.e(TAG, "getProcessName close is fail. exception=", e2);
                }
                return readLine;
            } catch (Exception e3) {
                e = e3;
                bufferedReader = bufferedReader2;
                try {
                    Log.e(TAG, "getProcessName read is fail. exception=", e);
                    if (bufferedReader != null) {
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        Log.e(TAG, "getProcessName close is fail. exception=", e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            Log.e(TAG, "getProcessName read is fail. exception=", e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    Log.e(TAG, "getProcessName close is fail. exception=", e6);
                }
            }
            return "";
        }
    }

    public static String getProcessNameFromUri(Uri uri) {
        for (ProviderInfo providerInfo : providerInfoList) {
            if (getContentAuthorities(providerInfo.authority).equals(uri)) {
                return providerInfo.processName;
            }
        }
        return null;
    }

    public static int getUserIdFromAuthority(String str, int i) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(64)) == -1) {
            return i;
        }
        try {
            return Integer.parseInt(str.substring(0, lastIndexOf));
        } catch (NumberFormatException unused) {
            return -10000;
        }
    }

    public static boolean isProcessAlive(ComponentName componentName) {
        try {
            Set<String> set = providerInfoSet;
            if (!set.contains(componentName.getPackageName())) {
                set.add(componentName.getPackageName());
                Collections.addAll(providerInfoList, ARanger.getContext().getPackageManager().getPackageInfo(componentName.getPackageName(), 8).providers);
            }
            String str = "";
            for (ProviderInfo providerInfo : providerInfoList) {
                if (providerInfo.name.equals(componentName.getClassName())) {
                    str = providerInfo.processName;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (sActivityManager == null) {
                sActivityManager = (ActivityManager) ARanger.getContext().getSystemService("activity");
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = sActivityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(componentName.getPackageName(), AdapterUtilityImpl.channelService));
            return ARanger.getContext().stopService(intent);
        } catch (Exception unused) {
            return false;
        }
    }

    public static Uri queryContentAuthorityFromProvider(ComponentName componentName) throws IPCException {
        try {
            Set<String> set = providerInfoSet;
            if (!set.contains(componentName.getPackageName())) {
                set.add(componentName.getPackageName());
                Collections.addAll(providerInfoList, ARanger.getContext().getPackageManager().getPackageInfo(componentName.getPackageName(), 8).providers);
            }
            for (ProviderInfo providerInfo : providerInfoList) {
                if (providerInfo.name.equals(componentName.getClassName())) {
                    return getContentAuthorities(providerInfo.authority);
                }
            }
            throw new IPCException(29, "can't find authorities in the " + componentName.getClass() + ", please check the provider is correct.");
        } catch (Exception e) {
            throw new IPCException(30, e);
        }
    }
}
