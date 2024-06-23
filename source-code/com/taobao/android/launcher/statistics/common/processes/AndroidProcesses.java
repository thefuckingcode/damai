package com.taobao.android.launcher.statistics.common.processes;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class AndroidProcesses {
    private static final int AID_READPROC = 3009;
    public static final String TAG = "AndroidProcesses";
    private static boolean loggingEnabled;

    AndroidProcesses() {
        throw new AssertionError("no instances");
    }

    public static List<AndroidAppProcess> getRunningAppProcesses() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File("/proc").listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        arrayList.add(new AndroidAppProcess(parseInt));
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static List<AndroidAppProcess> getRunningForegroundApps(Context context) {
        int i;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File("/proc").listFiles();
        PackageManager packageManager = context.getPackageManager();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        AndroidAppProcess androidAppProcess = new AndroidAppProcess(parseInt);
                        if (androidAppProcess.foreground && (((i = androidAppProcess.uid) < 1000 || i > 9999) && !androidAppProcess.name.contains(":") && packageManager.getLaunchIntentForPackage(androidAppProcess.getPackageName()) != null)) {
                            arrayList.add(androidAppProcess);
                        }
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static List<AndroidProcess> getRunningProcesses() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File("/proc").listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                try {
                    int parseInt = Integer.parseInt(file.getName());
                    try {
                        arrayList.add(new AndroidProcess(parseInt));
                    } catch (IOException e) {
                        log(e, "Error reading from /proc/%d.", Integer.valueOf(parseInt));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }

    public static boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public static boolean isMyProcessInTheForeground() {
        try {
            return new AndroidAppProcess(Process.myPid()).foreground;
        } catch (Exception e) {
            log(e, "Error finding our own process", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[SYNTHETIC, Splitter:B:37:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    public static boolean isProcessInfoHidden() {
        Throwable th;
        boolean z = false;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/mounts"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split.length == 6 && split[1].equals("/proc")) {
                            if (split[3].contains("hidepid=1") || split[3].contains("hidepid=2")) {
                                z = true;
                            }
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused) {
                            }
                            return z;
                        }
                    } else {
                        try {
                            bufferedReader2.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                } catch (IOException unused3) {
                    bufferedReader = bufferedReader2;
                    try {
                        Log.d(TAG, "Error reading /proc/mounts. Checking if UID 'readproc' exists.");
                        if (bufferedReader != null) {
                        }
                        if (Process.getUidForName("readproc") == 3009) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException unused5) {
            Log.d(TAG, "Error reading /proc/mounts. Checking if UID 'readproc' exists.");
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (Process.getUidForName("readproc") == 3009) {
            }
        }
        if (Process.getUidForName("readproc") == 3009) {
            return true;
        }
        return false;
    }

    public static void log(String str, Object... objArr) {
        if (loggingEnabled) {
            if (objArr.length != 0) {
                str = String.format(str, objArr);
            }
            Log.d(TAG, str);
        }
    }

    public static void setLoggingEnabled(boolean z) {
        loggingEnabled = z;
    }

    public static void log(Throwable th, String str, Object... objArr) {
        if (loggingEnabled) {
            if (objArr.length != 0) {
                str = String.format(str, objArr);
            }
            Log.d(TAG, str, th);
        }
    }
}
