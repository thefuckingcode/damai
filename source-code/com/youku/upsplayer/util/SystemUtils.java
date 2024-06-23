package com.youku.upsplayer.util;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.gl1;

/* compiled from: Taobao */
public class SystemUtils {
    private static final String[] OS_LINUX_RUNTIME = {"/bin/bash", "-l", "-c"};
    private static final String TAG = "SystemUtils";
    private static final String[] WIN_RUNTIME = {"cmd.exe", "/C"};
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static long lastTime = 0;
    private static Class<?> mClassType;
    private static Method mGetIntMethod;
    private static Method mGetMethod;
    private static Method mSetMethod;
    private static long startTime = 0;

    private static <T> T[] concat(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static String get(String str) {
        init();
        try {
            return (String) mGetMethod.invoke(mClassType, str);
        } catch (Exception unused) {
            Log.d(TAG, "get key " + str + " failed ");
            return null;
        }
    }

    public static int getInt(String str, int i) {
        init();
        try {
            return ((Integer) mGetIntMethod.invoke(mClassType, str, Integer.valueOf(i))).intValue();
        } catch (Exception unused) {
            Log.d(TAG, "get key " + str + " failed ");
            return i;
        }
    }

    private static void init() {
        try {
            if (mClassType == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                mClassType = cls;
                mGetMethod = cls.getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class);
                mSetMethod = mClassType.getDeclaredMethod("set", String.class, String.class);
                mGetIntMethod = mClassType.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isUTExposure() {
        int i = getInt("debug.yingshi.config.utexposure", 1);
        Log.d(TAG, "isUTSend: debug switch =" + i);
        return i > 0;
    }

    public static boolean isUTSend() {
        int i = getInt("debug.yingshi.config.utsend", 1);
        Log.d(TAG, "isUTSend: debug switch =" + i);
        return i > 0;
    }

    public static boolean isUtDebugTurnOn() {
        int i = getInt("debug.yingshi.config.ut", 0);
        Log.d(TAG, "isUTSend: debug switch =" + i);
        return i > 0;
    }

    public static boolean isUtRealTimeTurnOn() {
        int i = getInt("debug.yingshi.config.utrealtime", 0);
        Log.d(TAG, "isUTSend: debug switch =" + i);
        return i > 0;
    }

    public static void printTime() {
        StringBuilder sb;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        long currentTimeMillis = System.currentTimeMillis();
        if (startTime == 0) {
            sb.append("albertCurrentTime ");
            sb.append(stackTraceElement.getFileName());
            sb.append(":");
            sb.append(stackTraceElement.getLineNumber());
            sb.append("行 start time:");
            sb.append(df.format(new Date(currentTimeMillis)));
            Log.d(TAG, sb.toString());
            startTime = currentTimeMillis;
        } else {
            sb = new StringBuilder();
            sb.append("albertCurrentTime ");
            sb.append(stackTraceElement.getFileName());
            sb.append(":");
            sb.append(stackTraceElement.getLineNumber());
            sb.append("行 time:");
            sb.append(currentTimeMillis - lastTime);
            sb.append(" total:");
            sb.append(currentTimeMillis - startTime);
            Log.d(TAG, sb.toString());
        }
        lastTime = currentTimeMillis;
    }

    public static void printTimeClear() {
        startTime = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094 A[SYNTHETIC, Splitter:B:28:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1 A[SYNTHETIC, Splitter:B:36:0x00a1] */
    public static List<String> runProcess(boolean z, String... strArr) {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        Object[] concat;
        Log.d(TAG, "command to run: ");
        for (String str : strArr) {
            Log.d(TAG, str);
        }
        Log.d(TAG, StringUtils.LF);
        BufferedReader bufferedReader2 = null;
        if (z) {
            try {
                concat = concat(WIN_RUNTIME, strArr);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } else {
            concat = concat(OS_LINUX_RUNTIME, strArr);
        }
        ProcessBuilder processBuilder = new ProcessBuilder((String[]) concat);
        processBuilder.redirectErrorStream(true);
        Process start = processBuilder.start();
        start.waitFor();
        bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                Log.d(TAG, "temp line: " + readLine);
                arrayList.add(readLine);
            }
            Log.d(TAG, "result after command: " + arrayList);
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return arrayList;
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            return null;
        }
    }

    public static void set(String str, String str2) {
        init();
        try {
            mSetMethod.invoke(mClassType, str, str2);
        } catch (Exception unused) {
            Log.d(TAG, "set key " + str + " failed ");
        }
    }
}
