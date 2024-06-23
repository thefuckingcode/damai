package com.taobao.pexode.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class a {
    static Context a;

    public static void a(Context context) {
        a = context;
    }

    public static boolean b(String str, int i) {
        boolean z;
        String c = c(str, i);
        File file = new File(c);
        if (file.exists()) {
            try {
                System.load(c);
                z = true;
            } catch (Throwable unused) {
                file.delete();
            }
            if (!z || NdkCore.a(DeviceUtils.ABI_MIPS) || NdkCore.a(DeviceUtils.ABI_X86)) {
                return z;
            }
            try {
                return d(str, i);
            } catch (IOException e) {
                e.printStackTrace();
                return z;
            }
        }
        z = false;
        return !z ? z : z;
    }

    static String c(String str, int i) {
        String str2;
        Context context = a;
        if (context == null) {
            return "";
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            str2 = "/data/data/" + a.getPackageName() + "/files";
        } else {
            str2 = filesDir.getPath();
        }
        return str2 + "/lib" + str + "_bk_" + i + ".so";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:27|28|29|30|31|32|(3:35|36|37)|40) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:42|43|44|(0)|(0)|54|55|56) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x009f */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081 A[SYNTHETIC, Splitter:B:35:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095 A[SYNTHETIC, Splitter:B:48:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c A[SYNTHETIC, Splitter:B:52:0x009c] */
    static boolean d(String str, int i) throws IOException {
        Throwable th;
        FileOutputStream fileOutputStream;
        if (a == null) {
            return false;
        }
        String str2 = "lib/armeabi/lib" + str + ".so";
        String c = c(str, i);
        ApplicationInfo applicationInfo = a.getApplicationInfo();
        ZipFile zipFile = new ZipFile(applicationInfo != null ? applicationInfo.sourceDir : "");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith(str2)) {
                InputStream inputStream = null;
                try {
                    File file = new File(c);
                    if (file.exists()) {
                        file.delete();
                    }
                    InputStream inputStream2 = zipFile.getInputStream(zipEntry);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        zipFile.close();
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        int i2 = 0;
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read > 0) {
                                fileOutputStream.write(bArr, 0, read);
                                i2 += read;
                            } else {
                                inputStream2.close();
                                fileOutputStream.close();
                                zipFile.close();
                                if (i2 > 0) {
                                    try {
                                        System.load(c);
                                        return true;
                                    } catch (Throwable th3) {
                                        th3.printStackTrace();
                                    }
                                }
                                return false;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        zipFile.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    zipFile.close();
                    throw th;
                }
            }
        }
        return false;
    }
}
