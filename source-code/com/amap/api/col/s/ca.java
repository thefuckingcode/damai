package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
public final class ca {
    public static final String a = bw.c("SYmFja3Vwcw");
    public static final String b = bw.c("SLmFkaXU");
    public static final String c = bw.c("JIw");

    /* JADX WARNING: Can't wrap try/catch for region: R(10:26|27|(1:29)|(2:31|32)|33|34|35|36|37|39) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:16|17|18|(1:22)|23|24|25|26|27|(1:29)|(2:31|32)|33|34|35|36|37|39) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x009d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a0 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ab A[SYNTHETIC, Splitter:B:46:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b2 A[SYNTHETIC, Splitter:B:50:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b9 A[SYNTHETIC, Splitter:B:54:0x00b9] */
    public static synchronized void a(Context context, String str, String str2) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        synchronized (ca.class) {
            if (Build.VERSION.SDK_INT < 19 || (context != null && context.checkCallingOrSelfPermission(bw.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U=")) == 0 && context.checkCallingOrSelfPermission(bw.c("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) == 0)) {
                String a2 = a(context);
                if (!TextUtils.isEmpty(a2)) {
                    String str3 = str + c + str2;
                    File file = new File(a2 + File.separator + a);
                    File file2 = new File(file, b);
                    FileLock fileLock = null;
                    try {
                        if (!file.exists() || file.isDirectory()) {
                            file.mkdirs();
                        }
                        file2.createNewFile();
                        randomAccessFile = new RandomAccessFile(file2, "rws");
                        try {
                            fileChannel = randomAccessFile.getChannel();
                            try {
                                FileLock tryLock = fileChannel.tryLock();
                                if (tryLock != null) {
                                    fileChannel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                                }
                                if (tryLock != null) {
                                    tryLock.release();
                                }
                                fileChannel.close();
                                randomAccessFile.close();
                            } catch (Throwable unused) {
                                if (0 != 0) {
                                }
                                if (fileChannel != null) {
                                }
                                if (randomAccessFile != null) {
                                }
                            }
                        } catch (Throwable unused2) {
                            fileChannel = null;
                            if (0 != 0) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable unused5) {
                                }
                            }
                        }
                    } catch (Throwable unused6) {
                        fileChannel = null;
                        randomAccessFile = null;
                        if (0 != 0) {
                        }
                        if (fileChannel != null) {
                        }
                        if (randomAccessFile != null) {
                        }
                    }
                }
            }
        }
    }

    private static String a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 || (context.getApplicationInfo().targetSdkVersion >= 30 && i >= 30)) {
            return context.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
        }
        StorageManager storageManager = i >= 9 ? (StorageManager) context.getSystemService("storage") : null;
        try {
            Class<?> cls = Class.forName(bw.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(bw.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(bw.c("ZZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(bw.c("AaXNSZW1vdmFibGUK"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }
}
