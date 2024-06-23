package com.taobao.android.launcher.statistics.common.processes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class ProcFile extends File {
    public final String content;

    protected ProcFile(String str) throws IOException {
        super(str);
        this.content = readFile(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033 A[SYNTHETIC, Splitter:B:16:0x0033] */
    static String readFile(String str) throws IOException {
        Throwable th;
        BufferedReader bufferedReader = null;
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            try {
                String str2 = "";
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    sb.append(str2);
                    sb.append(readLine);
                    str2 = StringUtils.LF;
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
