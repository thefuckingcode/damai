package com.ali.ha.fulltrace;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: Taobao */
public class a {
    public static void a(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static String b(Context context, String str) {
        return d(context, str, true);
    }

    public static String c(Context context, String str) {
        File dir = context.getDir("fulltrace", 0);
        if (dir == null) {
            return "";
        }
        File file = new File(dir.getAbsolutePath(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static String d(Context context, String str, boolean z) {
        File file;
        if (str == null) {
            str = "";
        }
        File file2 = null;
        if (z) {
            try {
                file = context.getExternalCacheDir();
            } catch (Throwable unused) {
            }
        } else {
            file = context.getExternalFilesDir(null);
        }
        if (file != null) {
            file2 = new File(file, "fulltrace/" + str);
        }
        if (file2 == null) {
            File cacheDir = z ? context.getCacheDir() : context.getFilesDir();
            file2 = new File(cacheDir, "fulltrace/" + str);
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.getAbsolutePath();
    }

    public static byte[] e(File file) throws IOException {
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
