package com.alibaba.wireless.security.framework.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class e {
    private static String[] a = {"armeabi", "armeabi-v7a", DeviceUtils.ABI_X86, "arm64-v8a", "x86_64"};
    private static boolean b = true;
    private static boolean c = false;
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = true;
    private static boolean g;

    public static String a(Context context) {
        try {
            int myPid = Process.myPid();
            if (context == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    return str != null ? str : "";
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(ClassLoader classLoader, String str) {
        if (classLoader == null || str == null || "".equals(str)) {
            return null;
        }
        String a2 = a(classLoader, str, true);
        return a2 == null ? a(classLoader, str, false) : a2;
    }

    private static String a(ClassLoader classLoader, String str, boolean z) {
        Method method;
        if (classLoader != null) {
            if (z) {
                try {
                    method = classLoader.getClass().getMethod("findLibrary", String.class);
                } catch (Exception unused) {
                }
            } else {
                method = classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                Object invoke = method.invoke(classLoader, str);
                if (invoke != null) {
                    if (invoke instanceof String) {
                        return (String) invoke;
                    }
                }
            }
        }
        return null;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069 A[SYNTHETIC, Splitter:B:35:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    public static boolean a(String str, String str2, File file) {
        boolean z;
        ZipFile zipFile;
        IOException e2;
        boolean z2 = false;
        z2 = false;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
            try {
                String[] strArr = a;
                z = false;
                for (String str3 : strArr) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(SolidMonitor.CHECK_TYPE_LIB);
                    String str4 = File.separator;
                    sb.append(str4);
                    sb.append(str3);
                    sb.append(str4);
                    sb.append(str2);
                    ZipEntry entry = zipFile.getEntry(sb.toString());
                    if (!(entry == null || entry.getSize() == 0)) {
                        if (a.a(entry.getName())) {
                            z = a(zipFile, entry, file);
                        }
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                zipFile2 = zipFile;
                try {
                    FLOG.w("", e2);
                    if (zipFile2 == null) {
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (zipFile2 != null) {
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
            }
        } catch (IOException e4) {
            e2 = e4;
            FLOG.w("", e2);
            if (zipFile2 == null) {
                return z2;
            }
            z = z2;
            zipFile = zipFile2;
            zipFile.close();
            return z;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009f, code lost:
        r9 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:7:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a9 A[SYNTHETIC, Splitter:B:56:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b0 A[SYNTHETIC, Splitter:B:60:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bb A[SYNTHETIC, Splitter:B:68:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00c2 A[SYNTHETIC, Splitter:B:72:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00cc  */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file) {
        File file2;
        ?? r9;
        ?? r10;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th2;
        ?? fileOutputStream;
        boolean z = false;
        if (zipFile == null || zipEntry == null || file == null) {
            return false;
        }
        InputStream inputStream3 = null;
        try {
            file2 = new File(file.getAbsolutePath() + ".tmp." + Process.myPid());
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception unused) {
                    inputStream3 = inputStream;
                    r9 = inputStream3;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (r9 != 0) {
                        try {
                            r9.close();
                        } catch (Exception unused3) {
                        }
                    }
                    file2.delete();
                    if (!z) {
                    }
                    return z;
                } catch (Throwable th3) {
                    th2 = th3;
                    inputStream2 = inputStream;
                    th = th2;
                    inputStream3 = inputStream2;
                    r10 = inputStream3;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (r10 != 0) {
                        try {
                            r10.close();
                        } catch (Exception unused5) {
                        }
                    }
                    file2.delete();
                    throw th;
                }
            } catch (Exception unused6) {
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = null;
                inputStream3 = inputStream2;
                r10 = inputStream3;
                if (inputStream3 != null) {
                }
                if (r10 != 0) {
                }
                file2.delete();
                throw th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (!file.exists() || file.length() != zipEntry.getSize()) {
                        if (file2.exists() && file2.length() == zipEntry.getSize()) {
                            file.delete();
                            z = file2.renameTo(file);
                        }
                        file2.delete();
                        if (!z || !file.exists() || file.length() <= 0 || file.length() != zipEntry.getSize()) {
                            return z;
                        }
                        return true;
                    }
                    z = true;
                    file2.delete();
                    if (!z) {
                    }
                    return z;
                } catch (Exception unused7) {
                    inputStream = null;
                    inputStream3 = fileOutputStream;
                    inputStream3 = inputStream;
                    r9 = inputStream3;
                    if (inputStream3 != null) {
                    }
                    if (r9 != 0) {
                    }
                    file2.delete();
                    if (!z) {
                    }
                    return z;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream2 = null;
                    inputStream3 = fileOutputStream;
                    inputStream3 = inputStream2;
                    r10 = inputStream3;
                    if (inputStream3 != null) {
                    }
                    if (r10 != 0) {
                    }
                    file2.delete();
                    throw th;
                }
            } catch (Exception unused8) {
                inputStream3 = fileOutputStream;
                inputStream3 = inputStream;
                r9 = inputStream3;
                if (inputStream3 != null) {
                }
                if (r9 != 0) {
                }
                file2.delete();
                if (!z) {
                }
                return z;
            } catch (Throwable th6) {
                th2 = th6;
                inputStream3 = fileOutputStream;
                inputStream2 = inputStream;
                th = th2;
                inputStream3 = inputStream2;
                r10 = inputStream3;
                if (inputStream3 != null) {
                }
                if (r10 != 0) {
                }
                file2.delete();
                throw th;
            }
        } catch (Exception unused9) {
            r9 = 0;
            file2 = null;
            if (inputStream3 != null) {
            }
            if (r9 != 0) {
            }
            file2.delete();
            if (!z) {
            }
            return z;
        } catch (Throwable th7) {
            th = th7;
            r10 = 0;
            file2 = null;
            if (inputStream3 != null) {
            }
            if (r10 != 0) {
            }
            file2.delete();
            throw th;
        }
    }

    public static boolean b(Context context) {
        if (f) {
            try {
                String a2 = a(context);
                String packageName = context.getPackageName();
                if ("com.ali.money.shield".equals(packageName)) {
                    packageName = packageName + ":fore";
                }
                g = a2.equals(packageName);
                f = false;
            } catch (Exception unused) {
            }
        }
        return g;
    }

    public static boolean c(Context context) {
        boolean z;
        if (b) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    int i = packageInfo.applicationInfo.flags;
                    if ((i & 1) != 0 && (i & 128) == 0) {
                        z = true;
                        c = z;
                        b = false;
                    }
                }
            } catch (Throwable unused) {
            }
            z = false;
            c = z;
            b = false;
        }
        return c;
    }

    public static boolean d(Context context) {
        boolean z;
        if (d) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (!(packageInfo == null || (packageInfo.applicationInfo.flags & 128) == 0)) {
                    z = true;
                    e = z;
                    d = false;
                }
            } catch (Throwable unused) {
            }
            z = false;
            e = z;
            d = false;
        }
        return e;
    }
}
