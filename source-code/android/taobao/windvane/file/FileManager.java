package android.taobao.windvane.file;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.uc.crashsdk.export.CrashApi;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import tb.o70;

/* compiled from: Taobao */
public class FileManager {
    static final int BUFFER = 1024;
    private static final String TAG = "FileManager";
    public static final String UNZIP_SUCCESS = "success";
    private static File cachedDir;

    public static boolean copy(String str, String str2) {
        return copy(new File(str), new File(str2));
    }

    public static boolean copyDir(String str, String str2) {
        String formatUrl = formatUrl(str);
        String formatUrl2 = formatUrl(str2);
        new File(formatUrl2).mkdirs();
        File[] listFiles = new File(formatUrl).listFiles();
        byte[] bArr = new byte[2048];
        if (listFiles == null) {
            return false;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                File file = listFiles[i];
                if (!copy(file, new File(new File(formatUrl2).getAbsolutePath() + File.separator + listFiles[i].getName()), bArr)) {
                    return false;
                }
            }
            if (listFiles[i].isDirectory()) {
                StringBuilder sb = new StringBuilder();
                sb.append(formatUrl);
                String str3 = File.separator;
                sb.append(str3);
                sb.append(listFiles[i].getName());
                String sb2 = sb.toString();
                if (!copyDir(sb2, formatUrl2 + str3 + listFiles[i].getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[SYNTHETIC, Splitter:B:33:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    public static void copyFile(InputStream inputStream, File file) {
        Throwable th;
        FileNotFoundException e;
        IOException e2;
        if (inputStream != null && file != null) {
            FileOutputStream fileOutputStream = null;
            try {
                file.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    TaoLog.e(TAG, "copyFile: dest FileNotFoundException:" + e.getMessage());
                    if (fileOutputStream == null) {
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    fileOutputStream = fileOutputStream2;
                    try {
                        TaoLog.e(TAG, "copyFile: write IOException:" + e2.getMessage());
                        if (fileOutputStream == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                TaoLog.e(TAG, "copyFile: dest FileNotFoundException:" + e.getMessage());
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (IOException e8) {
                e2 = e8;
                TaoLog.e(TAG, "copyFile: write IOException:" + e2.getMessage());
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            }
        }
    }

    public static String createBaseDir(Application application, String str, String str2, boolean z) {
        File file;
        StringBuilder sb;
        String str3 = null;
        if (z) {
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            if (!wVCommonConfigData.targetSdkAdapte || Build.VERSION.SDK_INT < 29) {
                WVCommonConfig.getInstance();
                if (wVCommonConfigData.storeCachedDir) {
                    if (cachedDir == null) {
                        cachedDir = application.getExternalCacheDir();
                    }
                    file = cachedDir;
                } else {
                    file = application.getExternalCacheDir();
                }
            } else {
                file = application.getExternalFilesDir("apk");
            }
            if (file != null) {
                sb = new StringBuilder();
                sb.append(file.getAbsolutePath());
                sb.append(File.separator);
            } else {
                File externalCacheDir = CommonUtils.getExternalCacheDir(application);
                if (externalCacheDir != null) {
                    sb = new StringBuilder();
                    sb.append(externalCacheDir.getAbsolutePath());
                    sb.append(File.separator);
                } else {
                    sb = null;
                }
            }
            if (!TextUtils.isEmpty(str) && sb != null) {
                sb.append(str);
                sb.append(File.separator);
                sb.append(str2);
                str3 = sb.toString();
            }
        }
        if (str3 == null) {
            str3 = createInnerCacheStorage(application, str, str2);
        }
        TaoLog.d(TAG, "createBaseDir path:" + str3);
        return str3;
    }

    public static File createFolder(Context context, String str) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!TextUtils.isEmpty(str)) {
            absolutePath = absolutePath + File.separator + str;
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String createInnerCacheStorage(Application application, String str, String str2) {
        if (application.getFilesDir() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(application.getCacheDir().getAbsolutePath());
        if (!TextUtils.isEmpty(str)) {
            sb.append(File.separator);
            sb.append(str);
        }
        sb.append(File.separator);
        sb.append(str2);
        String sb2 = sb.toString();
        TaoLog.d(TAG, "createInnerCacheStorage path:" + sb2);
        return sb2;
    }

    public static String createInnerfileStorage(Application application, String str, String str2) {
        if (application.getFilesDir() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(application.getFilesDir().getAbsolutePath());
        if (!TextUtils.isEmpty(str)) {
            sb.append(File.separator);
            sb.append(str);
        }
        sb.append(File.separator);
        sb.append(str2);
        String sb2 = sb.toString();
        TaoLog.d(TAG, "createInnerfileStorage path:" + sb2);
        return sb2;
    }

    private static String formatUrl(String str) {
        String replaceAll = str.replaceAll(WVUtils.URL_SEPARATOR, "/");
        return replaceAll.endsWith("/") ? replaceAll.substring(0, replaceAll.length() - 1) : replaceAll;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0090 A[Catch:{ Exception -> 0x01e7, all -> 0x01e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0142 A[SYNTHETIC, Splitter:B:50:0x0142] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0160 A[SYNTHETIC, Splitter:B:55:0x0160] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x007b A[Catch:{ Exception -> 0x01ee, all -> 0x01ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x020f A[SYNTHETIC, Splitter:B:83:0x020f] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x024c A[SYNTHETIC, Splitter:B:94:0x024c] */
    public static String unZipByFilePath(String str, String str2) {
        ZipFile zipFile;
        Throwable th;
        Exception e;
        Enumeration<? extends ZipEntry> enumeration;
        Throwable th2;
        FileOutputStream fileOutputStream;
        String str3 = str2;
        long currentTimeMillis = System.currentTimeMillis();
        CrashApi.getInstance().addHeaderInfo("wv_zip_url", str);
        CrashApi.getInstance().addHeaderInfo("device_identifier", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND() + o70.DINAMIC_PREFIX_AT + Build.VERSION.getRELEASE());
        CrashApi instance = CrashApi.getInstance();
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        instance.addHeaderInfo("config_version", wVCommonConfigData.v);
        CrashApi.getInstance().addHeaderInfo("zip_degrade_config", wVCommonConfigData.zipDegradeMode + " / " + wVCommonConfigData.zipDegradeList);
        try {
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                FileOutputStream fileOutputStream2 = null;
                InputStream inputStream = null;
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String name = zipEntry.getName();
                    if (name != null) {
                        enumeration = entries;
                        if (!name.contains("../")) {
                            String str4 = str3 + "/" + name;
                            File file2 = new File(str4);
                            if (zipEntry.isDirectory()) {
                                file2.mkdirs();
                            } else if (!file2.exists()) {
                                file2.getParentFile().mkdirs();
                                file2.createNewFile();
                            }
                            try {
                                InputStream inputStream2 = zipFile2.getInputStream(zipEntry);
                                try {
                                    fileOutputStream = new FileOutputStream(str4);
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    inputStream = inputStream2;
                                    if (fileOutputStream2 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    throw th2;
                                }
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream2.read(bArr);
                                        if (read != -1) {
                                            fileOutputStream.write(bArr, 0, read);
                                        } else {
                                            try {
                                                break;
                                            } catch (IOException e2) {
                                                TaoLog.e(TAG, "stream failed to close : " + e2.getMessage());
                                                fileOutputStream2 = fileOutputStream;
                                            }
                                        }
                                    }
                                    fileOutputStream.close();
                                    fileOutputStream2 = null;
                                    try {
                                        inputStream2.close();
                                        inputStream = null;
                                    } catch (IOException e3) {
                                        TaoLog.e(TAG, "stream failed to close : " + e3.getMessage());
                                        inputStream = inputStream2;
                                    }
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    inputStream = inputStream2;
                                    fileOutputStream2 = fileOutputStream;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e4) {
                                            TaoLog.e(TAG, "stream failed to close : " + e4.getMessage());
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                            TaoLog.e(TAG, "stream failed to close : " + e5.getMessage());
                                        }
                                    }
                                    throw th2;
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                if (fileOutputStream2 != null) {
                                }
                                if (inputStream != null) {
                                }
                                throw th2;
                            }
                        }
                    } else {
                        enumeration = entries;
                    }
                    entries = enumeration;
                    str3 = str2;
                }
                try {
                    zipFile2.close();
                } catch (IOException e6) {
                    TaoLog.e(TAG, "zipfile failed to close : " + e6.getMessage());
                }
                try {
                    CrashApi.getInstance().addHeaderInfo("wv_zip_url", "");
                    CrashApi.getInstance().addHeaderInfo("device_identifier", "");
                    CrashApi.getInstance().addHeaderInfo("config_version", "");
                    CrashApi.getInstance().addHeaderInfo("zip_degrade_config", "");
                } catch (Throwable unused) {
                }
                if (TaoLog.getLogStatus()) {
                    return "success";
                }
                TaoLog.d(TAG, "unZipByFilePath use time(ms) : " + (System.currentTimeMillis() - currentTimeMillis));
                return "success";
            } catch (Exception e7) {
                e = e7;
                zipFile = zipFile2;
                try {
                    TaoLog.e(TAG, "unZipByFilePath failed : " + e.getMessage());
                    String message = e.getMessage();
                    if (zipFile != null) {
                    }
                    return message;
                } catch (Throwable th6) {
                    th = th6;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e8) {
                            TaoLog.e(TAG, "zipfile failed to close : " + e8.getMessage());
                        }
                        try {
                            CrashApi.getInstance().addHeaderInfo("wv_zip_url", "");
                            CrashApi.getInstance().addHeaderInfo("device_identifier", "");
                            CrashApi.getInstance().addHeaderInfo("config_version", "");
                            CrashApi.getInstance().addHeaderInfo("zip_degrade_config", "");
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                zipFile = zipFile2;
                if (zipFile != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            zipFile = null;
            TaoLog.e(TAG, "unZipByFilePath failed : " + e.getMessage());
            String message2 = e.getMessage();
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e10) {
                    TaoLog.e(TAG, "zipfile failed to close : " + e10.getMessage());
                }
                try {
                    CrashApi.getInstance().addHeaderInfo("wv_zip_url", "");
                    CrashApi.getInstance().addHeaderInfo("device_identifier", "");
                    CrashApi.getInstance().addHeaderInfo("config_version", "");
                    CrashApi.getInstance().addHeaderInfo("zip_degrade_config", "");
                } catch (Throwable unused3) {
                }
            }
            return message2;
        } catch (Throwable th8) {
            th = th8;
            zipFile = null;
            if (zipFile != null) {
            }
            throw th;
        }
    }

    public static boolean unzip(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return unzip(new FileInputStream(str), str2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean copy(File file, File file2) {
        return copy(file, file2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r6.length < 10) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0086 A[SYNTHETIC, Splitter:B:48:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0090 A[SYNTHETIC, Splitter:B:53:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009c A[SYNTHETIC, Splitter:B:60:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a6 A[SYNTHETIC, Splitter:B:65:0x00a6] */
    public static boolean copy(File file, File file2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Exception e;
        FileInputStream fileInputStream = null;
        try {
            if (!file.exists()) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.w(TAG, "src file not exist, " + file.getAbsoluteFile());
                }
                return false;
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                if (bArr != null) {
                    try {
                    } catch (Exception e2) {
                        fileInputStream = fileInputStream2;
                        fileOutputStream = fileOutputStream2;
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        fileInputStream = fileInputStream2;
                        fileOutputStream = fileOutputStream2;
                        th = th3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bArr = new byte[2048];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                fileOutputStream2.flush();
                try {
                    fileInputStream2.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                try {
                    fileOutputStream2.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
                return true;
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static boolean unzip(byte[] bArr, String str) {
        return unzip(new ByteArrayInputStream(bArr), str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ed A[SYNTHETIC, Splitter:B:52:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f5 A[Catch:{ IOException -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0115 A[SYNTHETIC, Splitter:B:62:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011d A[Catch:{ IOException -> 0x0119 }] */
    public static boolean unzip(InputStream inputStream, String str) {
        Throwable th;
        ZipInputStream zipInputStream;
        Exception e;
        if (inputStream == null || str == null) {
            return false;
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        FileOutputStream fileOutputStream = null;
        try {
            zipInputStream = new ZipInputStream(inputStream);
            try {
                byte[] bArr = new byte[1024];
                StringBuffer stringBuffer = new StringBuffer(200);
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    stringBuffer.append(nextEntry.getName());
                    if (!stringBuffer.toString().contains("../")) {
                        File file = new File(str + stringBuffer.toString());
                        stringBuffer.delete(0, stringBuffer.length());
                        if (nextEntry.isDirectory()) {
                            file.mkdirs();
                        } else {
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr, 0, 1024);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                } catch (Exception e2) {
                                    e = e2;
                                    fileOutputStream = fileOutputStream2;
                                    try {
                                        TaoLog.e(TAG, "unzip: IOException:" + e.getMessage());
                                        if (fileOutputStream != null) {
                                        }
                                        if (zipInputStream != null) {
                                        }
                                        inputStream.close();
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (fileOutputStream != null) {
                                        }
                                        if (zipInputStream != null) {
                                        }
                                        inputStream.close();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                    }
                                    if (zipInputStream != null) {
                                    }
                                    inputStream.close();
                                    throw th;
                                }
                            }
                            fileOutputStream2.close();
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        TaoLog.e(TAG, "close Stream Exception:" + e3.getMessage());
                    }
                }
                zipInputStream.close();
                inputStream.close();
                return true;
            } catch (Exception e4) {
                e = e4;
                TaoLog.e(TAG, "unzip: IOException:" + e.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        TaoLog.e(TAG, "close Stream Exception:" + e5.getMessage());
                        return false;
                    }
                }
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                inputStream.close();
                return false;
            }
        } catch (Exception e6) {
            e = e6;
            zipInputStream = null;
            TaoLog.e(TAG, "unzip: IOException:" + e.getMessage());
            if (fileOutputStream != null) {
            }
            if (zipInputStream != null) {
            }
            inputStream.close();
            return false;
        } catch (Throwable th4) {
            th = th4;
            zipInputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    TaoLog.e(TAG, "close Stream Exception:" + e7.getMessage());
                    throw th;
                }
            }
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            inputStream.close();
            throw th;
        }
    }
}
