package com.alibaba.wireless.security.framework.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* compiled from: Taobao */
public class a {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[SYNTHETIC, Splitter:B:18:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b A[SYNTHETIC, Splitter:B:25:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    public static String a(File file) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        bufferedReader.close();
                        return sb.toString();
                    }
                }
            } catch (Exception unused) {
                if (bufferedReader != null) {
                    return null;
                }
                try {
                    bufferedReader.close();
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
            bufferedReader = null;
            if (bufferedReader != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e A[SYNTHETIC, Splitter:B:20:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054 A[SYNTHETIC, Splitter:B:25:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    public static boolean a(File file, String str) {
        Throwable th;
        if (file == null || str == null) {
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + ".tmp");
        BufferedWriter bufferedWriter = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, false));
            try {
                bufferedWriter2.write(str);
                bufferedWriter2.flush();
                bufferedWriter2.close();
                return file2.renameTo(file);
            } catch (Exception unused) {
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                }
                throw th;
            }
        } catch (Exception unused2) {
            if (bufferedWriter != null) {
                return false;
            }
            try {
                bufferedWriter.close();
                return false;
            } catch (Exception unused3) {
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public static boolean a(String str) {
        return !str.contains("..") && !str.contains("\\") && !str.contains("%");
    }
}
