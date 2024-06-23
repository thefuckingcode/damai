package com.alibaba.motu.crashreporter2;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: Taobao */
public class MemReader {
    private static final String[] CORES = {"FDSize", "VmPeak", "VmSize", "VmHWM", "VmRSS", "VmData", "VmStk", "VmExe", "VmLib", "VmSwap", "Threads"};
    private static final int PID = Process.myPid();

    private static boolean inCores(String str) {
        for (String str2 : CORES) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A[SYNTHETIC, Splitter:B:19:0x005b] */
    public static String readMemContent() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + PID + "/status")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (inCores(readLine)) {
                        String replace = readLine.replace("\t", "").replace(" ", "");
                        sb.append(" ,");
                        sb.append(replace);
                    }
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                }
                return null;
            }
        } catch (Throwable unused3) {
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        }
    }
}
