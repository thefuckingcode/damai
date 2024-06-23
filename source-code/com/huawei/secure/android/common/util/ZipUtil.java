package com.huawei.secure.android.common.util;

import android.annotation.SuppressLint;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
public class ZipUtil {
    private static final String a = "ZipUtil";
    private static final int b = 104857600;
    private static final int c = 100;
    private static final int d = 4096;
    private static final String e = "../";
    private static final String f = "..\\";

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.zip.ZipFile */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x012c  */
    @SuppressLint({"NewApi"})
    private static List<File> a(File file, File file2, long j, boolean z) {
        Throwable th;
        IOException e2;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (file == null || file2 == null) {
            return null;
        }
        boolean z2 = true;
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                int i = 0;
                while (true) {
                    if (!entries.hasMoreElements()) {
                        z3 = z2;
                        break;
                    }
                    try {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        String name = zipEntry.getName();
                        if (TextUtils.isEmpty(name)) {
                            continue;
                        } else {
                            String normalize = Normalizer.normalize(name, Normalizer.Form.NFKC);
                            if (e(normalize)) {
                                Log.e(a, "zipPath is a invalid path: " + d(normalize));
                                break;
                            }
                            File file3 = new File(file2, normalize.replaceAll("\\\\", "/"));
                            if (z && file3.exists() && file3.isFile()) {
                                e(file3);
                            }
                            arrayList.add(file3);
                            if (zipEntry.isDirectory()) {
                                if (!a(file3)) {
                                    IOUtil.closeSecure(zipFile);
                                    a(arrayList);
                                    return null;
                                }
                            } else if (!b(file3)) {
                                IOUtil.closeSecure(zipFile);
                                a(arrayList);
                                return null;
                            } else {
                                try {
                                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                                    try {
                                        fileOutputStream = new FileOutputStream(file3);
                                        try {
                                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            bufferedOutputStream = null;
                                            fileOutputStream2 = fileOutputStream;
                                            IOUtil.closeSecure((InputStream) bufferedInputStream);
                                            IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                            IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                            throw th2;
                                        }
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        bufferedOutputStream = null;
                                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                        IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                        throw th2;
                                    }
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = bufferedInputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            i += read;
                                            if (((long) i) > j) {
                                                Log.e(a, "unzipFileNew: over than top size");
                                                z2 = false;
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, read);
                                        }
                                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                        IOUtil.closeSecure((OutputStream) fileOutputStream);
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        fileOutputStream2 = fileOutputStream;
                                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                        IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                        throw th2;
                                    }
                                } catch (Throwable th6) {
                                    th2 = th6;
                                    bufferedInputStream = null;
                                    bufferedOutputStream = null;
                                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                                    IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                    IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                    throw th2;
                                }
                            }
                        }
                    } catch (IllegalArgumentException unused) {
                        Log.e(a, "entries.nextElement IllegalArgumentException");
                    }
                }
                IOUtil.closeSecure(zipFile);
                if (!z3) {
                    a(arrayList);
                }
            } catch (IOException e3) {
                e2 = e3;
                fileOutputStream2 = zipFile;
                try {
                    Log.e(a, "unzip new IOException : " + e2.getMessage());
                    IOUtil.closeSecure((Closeable) fileOutputStream2);
                    a(arrayList);
                    return arrayList;
                } catch (Throwable th7) {
                    th = th7;
                    z2 = false;
                    IOUtil.closeSecure((Closeable) fileOutputStream2);
                    if (!z2) {
                        a(arrayList);
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream2 = zipFile;
                IOUtil.closeSecure((Closeable) fileOutputStream2);
                if (!z2) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e2 = e4;
            Log.e(a, "unzip new IOException : " + e2.getMessage());
            IOUtil.closeSecure((Closeable) fileOutputStream2);
            a(arrayList);
            return arrayList;
        } catch (Throwable th9) {
            th = th9;
            IOUtil.closeSecure((Closeable) fileOutputStream2);
            if (!z2) {
            }
            throw th;
        }
        return arrayList;
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    private static String d(String str) {
        int lastIndexOf;
        return (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(File.separator)) != -1) ? str.substring(lastIndexOf + 1) : str;
    }

    private static void e(File file) {
        if (file != null) {
            if (file.isFile()) {
                c(file);
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    c(file);
                    return;
                }
                for (File file2 : listFiles) {
                    e(file2);
                }
                c(file);
            }
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, ZipAppConstants.LIMITED_APP_SPACE, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, ZipAppConstants.LIMITED_APP_SPACE, 100, z);
    }

    private static void c(File file) {
        if (file != null && !file.delete()) {
            LogsUtil.e(a, "delete file error");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0049 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        android.util.Log.e(com.huawei.secure.android.common.util.ZipUtil.a, "unzip  over than top size");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d0, code lost:
        r2 = false;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d4, code lost:
        r7 = r12;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010e, code lost:
        r12 = r10;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0111, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0112, code lost:
        r12 = r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f3 A[ExcHandler: all (th java.lang.Throwable), PHI: r7 r10 
      PHI: (r7v9 java.io.FileInputStream) = (r7v7 java.io.FileInputStream), (r7v11 java.io.FileInputStream), (r7v11 java.io.FileInputStream) binds: [B:14:0x0049, B:51:0x00ec, B:52:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v15 java.io.FileOutputStream) = (r10v12 java.io.FileOutputStream), (r10v17 java.io.FileOutputStream), (r10v17 java.io.FileOutputStream) binds: [B:14:0x0049, B:51:0x00ec, B:52:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:14:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fc A[ExcHandler: all (th java.lang.Throwable), Splitter:B:37:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x014a  */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Deprecated
    public static boolean unZip(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        FileOutputStream fileOutputStream;
        ?? r10;
        ZipInputStream zipInputStream;
        Throwable th;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream;
        ?? r7;
        IOException e2;
        FileOutputStream fileOutputStream3;
        String str3 = str2;
        boolean z2 = false;
        if (!a(str, str2, j, i)) {
            return false;
        }
        String str4 = File.separator;
        if (str3.endsWith(str4) && str2.length() > str4.length()) {
            str3 = str3.substring(0, str2.length() - str4.length());
        }
        boolean z3 = true;
        int i2 = 4096;
        byte[] bArr = new byte[4096];
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
                fileOutputStream2 = null;
                int i3 = 0;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String replaceAll = nextEntry.getName().replaceAll("\\\\", "/");
                        File file = new File(str3, replaceAll);
                        String normalize = Normalizer.normalize(replaceAll, Normalizer.Form.NFKC);
                        if (e(normalize)) {
                            Log.e(a, "zipPath is a invalid path: " + d(normalize));
                            z3 = false;
                            break;
                        }
                        if (z && file.exists() && file.isFile()) {
                            e(file);
                        }
                        if (nextEntry.isDirectory()) {
                            d(file);
                            arrayList.add(file);
                            fileInputStream2 = fileInputStream2;
                        } else {
                            File parentFile = file.getParentFile();
                            if (parentFile != null && !parentFile.exists()) {
                                d(parentFile);
                            }
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                r10 = new BufferedOutputStream(fileOutputStream);
                                while (true) {
                                    try {
                                        int i4 = z2 ? 1 : 0;
                                        int i5 = z2 ? 1 : 0;
                                        int i6 = z2 ? 1 : 0;
                                        int i7 = z2 ? 1 : 0;
                                        int i8 = z2 ? 1 : 0;
                                        int i9 = z2 ? 1 : 0;
                                        int i10 = z2 ? 1 : 0;
                                        int i11 = z2 ? 1 : 0;
                                        int read = zipInputStream.read(bArr, i4, i2);
                                        if (read == -1) {
                                            break;
                                        }
                                        i3 += read;
                                        if (((long) i3) > j) {
                                            break;
                                        }
                                        z2 = false;
                                        r10.write(bArr, 0, read);
                                        i2 = 4096;
                                    } catch (IOException e3) {
                                        e2 = e3;
                                        fileOutputStream3 = fileOutputStream;
                                        fileOutputStream = fileOutputStream3;
                                        fileInputStream2 = fileInputStream;
                                        try {
                                            LogsUtil.e(a, "Unzip IOException : " + e2.getMessage());
                                            fileInputStream = fileInputStream2;
                                            r7 = r10;
                                            fileOutputStream2 = fileOutputStream;
                                            a(fileInputStream, (BufferedOutputStream) r7, zipInputStream, fileOutputStream2);
                                            if (!z2) {
                                            }
                                            return z2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            a(fileInputStream2, (BufferedOutputStream) r10, zipInputStream, fileOutputStream);
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                    }
                                }
                                arrayList.add(file);
                                r10.flush();
                                IOUtil.closeSecure((OutputStream) r10);
                                IOUtil.closeSecure((OutputStream) fileOutputStream);
                                fileInputStream2 = r10;
                                fileOutputStream2 = fileOutputStream;
                            } catch (IOException e4) {
                                e2 = e4;
                                r10 = fileInputStream2;
                                fileInputStream2 = fileInputStream;
                                LogsUtil.e(a, "Unzip IOException : " + e2.getMessage());
                                fileInputStream = fileInputStream2;
                                r7 = r10;
                                fileOutputStream2 = fileOutputStream;
                                a(fileInputStream, (BufferedOutputStream) r7, zipInputStream, fileOutputStream2);
                                if (!z2) {
                                }
                                return z2;
                            } catch (Throwable th4) {
                                th = th4;
                                FileInputStream fileInputStream3 = fileInputStream2;
                                r10 = fileInputStream3;
                                fileInputStream2 = fileInputStream;
                                a(fileInputStream2, (BufferedOutputStream) r10, zipInputStream, fileOutputStream);
                                throw th;
                            }
                        }
                        zipInputStream.closeEntry();
                        i2 = 4096;
                        fileInputStream2 = fileInputStream2;
                    } catch (IOException e5) {
                        e2 = e5;
                        r10 = fileInputStream2;
                        fileOutputStream3 = fileOutputStream2;
                        fileOutputStream = fileOutputStream3;
                        fileInputStream2 = fileInputStream;
                        LogsUtil.e(a, "Unzip IOException : " + e2.getMessage());
                        fileInputStream = fileInputStream2;
                        r7 = r10;
                        fileOutputStream2 = fileOutputStream;
                        a(fileInputStream, (BufferedOutputStream) r7, zipInputStream, fileOutputStream2);
                        if (!z2) {
                        }
                        return z2;
                    } catch (Throwable th5) {
                    }
                }
                IOUtil.closeSecure((InputStream) zipInputStream);
                IOUtil.closeSecure((InputStream) fileInputStream);
                z2 = z3;
                r7 = fileInputStream2;
            } catch (IOException e6) {
                e2 = e6;
                zipInputStream = null;
                r10 = null;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                LogsUtil.e(a, "Unzip IOException : " + e2.getMessage());
                fileInputStream = fileInputStream2;
                r7 = r10;
                fileOutputStream2 = fileOutputStream;
                a(fileInputStream, (BufferedOutputStream) r7, zipInputStream, fileOutputStream2);
                if (!z2) {
                }
                return z2;
            } catch (Throwable th6) {
                th = th6;
                zipInputStream = null;
                r10 = null;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                a(fileInputStream2, (BufferedOutputStream) r10, zipInputStream, fileOutputStream);
                throw th;
            }
        } catch (IOException e7) {
            e2 = e7;
            zipInputStream = null;
            r10 = null;
            fileOutputStream = null;
            LogsUtil.e(a, "Unzip IOException : " + e2.getMessage());
            fileInputStream = fileInputStream2;
            r7 = r10;
            fileOutputStream2 = fileOutputStream;
            a(fileInputStream, (BufferedOutputStream) r7, zipInputStream, fileOutputStream2);
            if (!z2) {
            }
            return z2;
        } catch (Throwable th7) {
            th = th7;
            zipInputStream = null;
            r10 = null;
            fileOutputStream = null;
            a(fileInputStream2, (BufferedOutputStream) r10, zipInputStream, fileOutputStream);
            throw th;
        }
        a(fileInputStream, (BufferedOutputStream) r7, zipInputStream, fileOutputStream2);
        if (!z2) {
            a(arrayList);
        }
        return z2;
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        if (!a(str, str2, j, i)) {
            return null;
        }
        String str3 = File.separator;
        if (str2.endsWith(str3) && str2.length() > str3.length()) {
            str2 = str2.substring(0, str2.length() - str3.length());
        }
        return a(c(str), c(str2), j, z);
    }

    private static void d(File file) {
        if (file != null && !file.exists() && !file.mkdirs()) {
            LogsUtil.e(a, "mkdirs error , files exists or IOException.");
        }
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(a, "isContainInvalidStr: name is null");
            return true;
        } else if (str.contains(e) || str.contains(f) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00")) {
            return true;
        } else {
            return false;
        }
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str) && e(str)) {
            Log.e(a, "IllegalArgumentException--path is not a standard path");
            throw new IllegalArgumentException("path is not a standard path");
        }
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[SYNTHETIC, Splitter:B:32:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0045 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019 A[Catch:{ IOException -> 0x004d, all -> 0x004a }] */
    private static boolean a(String str, long j, int i) {
        Throwable th;
        IOException e2;
        boolean z = false;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                long j2 = 0;
                int i2 = 0;
                while (true) {
                    if (!entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        j2 += zipEntry.getSize();
                        i2++;
                        if (e(zipEntry.getName()) || i2 >= i || j2 > j || zipEntry.getSize() == -1) {
                            LogsUtil.e(a, "File name is invalid or too many files or too big");
                        }
                        if (!entries.hasMoreElements()) {
                            z = true;
                            break;
                        }
                    }
                }
                LogsUtil.e(a, "File name is invalid or too many files or too big");
                try {
                    zipFile2.close();
                } catch (IOException unused) {
                    LogsUtil.e(a, "close zipFile IOException ");
                }
            } catch (IOException e3) {
                e2 = e3;
                zipFile = zipFile2;
                try {
                    LogsUtil.e(a, "not a valid zip file, IOException : " + e2.getMessage());
                    if (zipFile != null) {
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            LogsUtil.e(a, "close zipFile IOException ");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile = zipFile2;
                if (zipFile != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e2 = e4;
            LogsUtil.e(a, "not a valid zip file, IOException : " + e2.getMessage());
            if (zipFile != null) {
                zipFile.close();
            }
            return z;
        }
        return z;
    }

    private static boolean a(String str, String str2, long j, int i) throws SecurityCommonException {
        if (TextUtils.isEmpty(str) || e(str)) {
            LogsUtil.e(a, "zip file is not valid");
            return false;
        } else if (TextUtils.isEmpty(str2) || e(str2)) {
            LogsUtil.e(a, "target directory is not valid");
            return false;
        } else if (a(str, j, i)) {
            return true;
        } else {
            LogsUtil.e(a, "zip file contains valid chars or too many files");
            throw new SecurityCommonException("unsecure zipfile!");
        }
    }

    private static boolean a(List<File> list) {
        try {
            for (File file : list) {
                e(file);
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
