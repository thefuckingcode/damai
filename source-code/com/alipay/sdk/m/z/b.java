package com.alipay.sdk.m.z;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public final class b {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[SYNTHETIC, Splitter:B:17:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    public static String a(String str, String str2) {
        BufferedReader bufferedReader;
        Throwable th;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(str, str2);
            if (!file.exists()) {
                return null;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    }
                } catch (IOException unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    return sb.toString();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
                try {
                    break;
                } catch (Throwable unused2) {
                }
            }
            bufferedReader.close();
            return sb.toString();
        } catch (IOException unused3) {
            if (bufferedReader2 != null) {
                bufferedReader = bufferedReader2;
                break;
                bufferedReader.close();
            }
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }
}
