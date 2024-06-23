package com.tencent.smtt.sdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: DeviceInfo */
public class a {
    public static int a = 600;
    private static int b;

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    public static int a() {
        IOException e;
        Throwable th;
        int i = b;
        if (i > 0) {
            return i;
        }
        BufferedReader bufferedReader = null;
        int i2 = 0;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        int indexOf = readLine.indexOf("MemTotal:");
                        if (-1 != indexOf) {
                            String trim = readLine.substring(indexOf + 9).trim();
                            if (!(trim == null || trim.length() == 0 || !trim.contains("k"))) {
                                i2 = Integer.parseInt(trim.substring(0, trim.indexOf("k")).trim()) / 1024;
                            }
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                    }
                    b = i2;
                    return i2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    try {
                        th.printStackTrace();
                        if (bufferedReader != null) {
                        }
                        b = i2;
                        return i2;
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            b = i2;
            return i2;
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            b = i2;
            return i2;
        }
        b = i2;
        return i2;
    }
}
