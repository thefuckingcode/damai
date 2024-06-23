package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

/* compiled from: Taobao */
public class aj {
    public static boolean a(Context context, String str, long j) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        IOException e;
        if (Build.VERSION.SDK_INT >= 23 && !h.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return true;
        }
        FileLock fileLock = null;
        try {
            File file = new File(new File(context.getExternalFilesDir(null), "/.vdevdir/"), "lcfp.lock");
            ab.m248a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                boolean b = b(context, str, j);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused) {
                    }
                }
                ab.a(randomAccessFile);
                return b;
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    ab.a(randomAccessFile);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused3) {
                        }
                    }
                    ab.a(randomAccessFile);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
            e.printStackTrace();
            fileLock.release();
            ab.a(randomAccessFile);
            return true;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            fileLock.release();
            ab.a(randomAccessFile);
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b5, code lost:
        r1 = r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00ad */
    private static boolean b(Context context, String str, long j) {
        BufferedWriter bufferedWriter;
        Throwable th;
        IOException e;
        BufferedReader bufferedReader;
        File file = new File(new File(context.getExternalFilesDir(null), "/.vdevdir/"), "lcfp");
        ArrayList<String> arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + ":" + context.getPackageName() + "," + currentTimeMillis;
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":");
                    if (split.length == 2) {
                        if (TextUtils.equals(split[0], String.valueOf(str))) {
                            String[] split2 = split[1].split(",");
                            if (split2.length == 2) {
                                long parseLong = Long.parseLong(split2[1]);
                                if (!TextUtils.equals(split2[0], context.getPackageName()) && ((float) Math.abs(currentTimeMillis - parseLong)) < ((float) (1000 * j)) * 0.9f) {
                                    ab.a(bufferedReader);
                                    return false;
                                }
                            }
                        } else {
                            arrayList.add(readLine);
                        }
                    }
                }
            } catch (Exception unused) {
                bufferedReader = null;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                BufferedReader bufferedReader2 = null;
                ab.a(bufferedReader2);
                throw th3;
            }
            ab.a(bufferedReader);
        } else if (!ab.m248a(file)) {
            return true;
        }
        arrayList.add(str2);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                for (String str3 : arrayList) {
                    bufferedWriter.write(str3);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    b.d(e.toString());
                    ab.a(bufferedWriter);
                    return true;
                } catch (Throwable th4) {
                    th = th4;
                    ab.a(bufferedWriter);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            bufferedWriter = null;
            b.d(e.toString());
            ab.a(bufferedWriter);
            return true;
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
            ab.a(bufferedWriter);
            throw th;
        }
        ab.a(bufferedWriter);
        return true;
    }
}
