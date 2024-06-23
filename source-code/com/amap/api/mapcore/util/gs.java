package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
public class gs {
    public static final String a = gn.c("SYmFja3Vwcw");
    public static final String b = gn.c("SLmFkaXU");
    public static final String c = gn.c("JIw");

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008b A[SYNTHETIC, Splitter:B:35:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092  */
    public static synchronized void a(Context context, String str, String str2) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        synchronized (gs.class) {
            String a2 = a(context, false);
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
                            try {
                                fileChannel.close();
                            } catch (IOException unused) {
                            }
                        } catch (Throwable unused2) {
                            if (0 != 0) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            a(randomAccessFile);
                        }
                    } catch (Throwable unused4) {
                        fileChannel = null;
                        if (0 != 0) {
                        }
                        if (fileChannel != null) {
                        }
                        a(randomAccessFile);
                    }
                } catch (Throwable unused5) {
                    fileChannel = null;
                    randomAccessFile = null;
                    if (0 != 0) {
                    }
                    if (fileChannel != null) {
                    }
                    a(randomAccessFile);
                }
                a(randomAccessFile);
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(Context context, boolean z) {
        StorageManager storageManager = Build.VERSION.SDK_INT >= 9 ? (StorageManager) context.getSystemService("storage") : null;
        try {
            Class<?> cls = Class.forName(gn.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(gn.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(gn.c("ZZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(gn.c("AaXNSZW1vdmFibGUK"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }
}
