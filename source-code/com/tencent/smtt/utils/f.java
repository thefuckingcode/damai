package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.lzy.okgo.cache.CacheEntity;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: FileUtil */
public class f {
    public static String a = null;
    public static final a b = new a() {
        /* class com.tencent.smtt.utils.f.AnonymousClass2 */

        @Override // com.tencent.smtt.utils.f.a
        public boolean a(File file, File file2) {
            return file.length() == file2.length() && file.lastModified() == file2.lastModified();
        }
    };
    private static final int c = 4;
    private static RandomAccessFile d;

    /* compiled from: FileUtil */
    public interface a {
        boolean a(File file, File file2);
    }

    /* compiled from: FileUtil */
    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str) throws Exception;
    }

    public static String a(Context context, int i) {
        return a(context, context.getApplicationInfo().packageName, i, true);
    }

    public static String a(Context context, String str, int i, boolean z) {
        String str2;
        if (context == null) {
            return "";
        }
        try {
            str2 = Environment.getExternalStorageDirectory() + File.separator;
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        switch (i) {
            case 1:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + File.separator + "tbs" + File.separator + str;
            case 2:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tbs" + File.separator + "backup" + File.separator + str;
            case 3:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
            case 4:
                if (str2.equals("")) {
                    return b(context, "backup");
                }
                String str3 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                if (!z) {
                    return str3;
                }
                File file = new File(str3);
                if (file.exists() && file.canWrite()) {
                    return str3;
                }
                if (file.exists()) {
                    return b(context, "backup");
                }
                file.mkdirs();
                if (!file.canWrite()) {
                    return b(context, "backup");
                }
                return str3;
            case 5:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + File.separator + "tbs" + File.separator + str;
            case 6:
                String str4 = a;
                if (str4 != null) {
                    return str4;
                }
                String b2 = b(context, "tbslog");
                a = b2;
                return b2;
            case 7:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + "core";
            case 8:
                return b(context, "env");
            default:
                return "";
        }
    }

    private static String b(Context context, String str) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            return context.getExternalFilesDir(str).getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                return Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + CacheEntity.DATA + File.separator + context.getApplicationInfo().packageName + File.separator + "files" + File.separator + str;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static boolean a(Context context) {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context == null) {
            return false;
        }
        if (context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            z = false;
        }
        return z;
    }

    public static boolean a(File file, File file2) throws Exception {
        return a(file.getPath(), file2.getPath());
    }

    public static boolean a(String str, String str2) throws Exception {
        return a(str, str2, Build.CPU_ABI, Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, j.a("ro.product.cpu.upgradeabi", "armeabi"));
    }

    private static boolean a(String str, final String str2, String str3, String str4, String str5) throws Exception {
        return a(str, str3, str4, str5, new b() {
            /* class com.tencent.smtt.utils.f.AnonymousClass1 */

            @Override // com.tencent.smtt.utils.f.b
            public boolean a(InputStream inputStream, ZipEntry zipEntry, String str) throws Exception {
                try {
                    return f.b(inputStream, zipEntry, str2, str);
                } catch (Exception e) {
                    throw new Exception("copyFileIfChanged Exception", e);
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cd  */
    private static boolean a(String str, String str2, String str3, String str4, b bVar) throws Exception {
        Throwable th;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                boolean z = false;
                boolean z2 = false;
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String name = zipEntry.getName();
                    if (name != null) {
                        if (!name.contains("../")) {
                            if (name.startsWith("lib/") || name.startsWith("assets/")) {
                                String substring = name.substring(name.lastIndexOf(47));
                                if (substring.endsWith(".so")) {
                                    int i = c;
                                    if (name.regionMatches(i, str2, 0, str2.length()) && name.charAt(str2.length() + i) == '/') {
                                        z = true;
                                    } else if (str3 != null && name.regionMatches(i, str3, 0, str3.length()) && name.charAt(str3.length() + i) == '/') {
                                        z2 = true;
                                        if (z) {
                                        }
                                    } else if (str4 != null && name.regionMatches(i, str4, 0, str4.length()) && name.charAt(i + str4.length()) == '/' && !z) {
                                        if (z2) {
                                        }
                                    }
                                }
                                InputStream inputStream = zipFile2.getInputStream(zipEntry);
                                try {
                                    if (!bVar.a(inputStream, zipEntry, substring.substring(1))) {
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        zipFile2.close();
                                        return false;
                                    }
                                } finally {
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                }
                            }
                        }
                    }
                }
                zipFile2.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (zipFile != null) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8  */
    public static boolean b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) throws Exception {
        Throwable th;
        IOException e;
        a(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                fileOutputStream2.close();
                if (a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                    TbsLog.e("FileHelper", "file is different: " + str3);
                    return false;
                } else if (file.setLastModified(zipEntry.getTime())) {
                    return true;
                } else {
                    TbsLog.e("FileHelper", "Couldn't set time for dst file " + file);
                    return true;
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    b(file);
                    throw new IOException("Couldn't write dst file " + file, e);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
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
        } catch (IOException e3) {
            e = e3;
            b(file);
            throw new IOException("Couldn't write dst file " + file, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    private static boolean a(String str, long j, long j2, long j3) throws Exception {
        Throwable th;
        File file = new File(str);
        if (file.length() != j) {
            TbsLog.e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                TbsLog.i("FileHelper", "" + file.getName() + ": crc = " + value + ", zipCrc = " + j3);
                if (value != j3) {
                    fileInputStream2.close();
                    return true;
                }
                fileInputStream2.close();
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static boolean b(File file, File file2) throws Exception {
        return a(file, file2, (FileFilter) null);
    }

    public static boolean a(File file, File file2, FileFilter fileFilter) throws Exception {
        return a(file, file2, fileFilter, b);
    }

    public static boolean a(File file, File file2, FileFilter fileFilter, a aVar) throws Exception {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return b(file, file2, fileFilter, aVar);
        }
        File[] listFiles = file.listFiles(fileFilter);
        if (listFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file3 : listFiles) {
            if (!a(file3, new File(file2, file3.getName()), fileFilter)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0098  */
    private static boolean b(File file, File file2, FileFilter fileFilter, a aVar) throws Exception {
        FileChannel fileChannel;
        Throwable th;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        FileChannel fileChannel2 = null;
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    if (file2.exists()) {
                        if (aVar != null && aVar.a(file, file2)) {
                            return true;
                        }
                        b(file2);
                    }
                    File parentFile = file2.getParentFile();
                    if (parentFile.isFile()) {
                        b(parentFile);
                    }
                    if (!parentFile.exists() && !parentFile.mkdirs()) {
                        return false;
                    }
                    FileChannel channel = new FileInputStream(file).getChannel();
                    try {
                        FileChannel channel2 = new FileOutputStream(file2).getChannel();
                        long size = channel.size();
                        if (channel2.transferFrom(channel, 0, size) != size) {
                            b(file2);
                            if (channel != null) {
                                channel.close();
                            }
                            if (channel2 != null) {
                                channel2.close();
                            }
                            return false;
                        }
                        if (channel != null) {
                            channel.close();
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        return true;
                    } catch (Throwable th2) {
                        fileChannel2 = channel;
                        th = th2;
                        fileChannel = null;
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        throw th;
                    }
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            if (fileChannel2 != null) {
            }
            if (fileChannel != null) {
            }
            throw th;
        }
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        b(file);
        return file.mkdirs();
    }

    public static void b(File file) {
        a(file, false);
    }

    public static void a(File file, boolean z) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z + file + Log.getStackTraceString(new Throwable()));
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    a(file2, z);
                }
                if (!z) {
                    file.delete();
                }
            }
        }
    }

    public static void a(File file, boolean z, String str) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z + "except" + str + file + Log.getStackTraceString(new Throwable()));
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!file2.getName().equals(str)) {
                        a(file2, z);
                    }
                }
                if (!z) {
                    file.delete();
                }
            }
        }
    }

    public static boolean c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static FileOutputStream d(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file);
    }

    public static boolean b(Context context) {
        long a2 = q.a();
        boolean z = a2 >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + a2);
        }
        return z;
    }

    public static String c(Context context) {
        return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
    }

    static String d(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static File a(Context context, boolean z, String str) {
        String str2;
        if (z) {
            str2 = d(context);
        } else {
            str2 = c(context);
        }
        if (str2 == null) {
            return null;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    public static File a(Context context, String str) {
        File file = new File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            TbsLog.e("FileHelper", "getPermanentTbsFile -- no permission!");
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                TbsLog.e("FileHelper", "getPermanentTbsFile -- exception: " + e);
                return null;
            }
        }
        return file2;
    }

    public static FileOutputStream b(Context context, boolean z, String str) {
        File a2 = a(context, z, str);
        if (a2 == null) {
            return null;
        }
        try {
            return new FileOutputStream(a2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static FileLock a(Context context, FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock.isValid()) {
                return tryLock;
            }
            return null;
        } catch (OverlappingFileLockException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static FileLock e(Context context) {
        boolean z;
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable unused) {
            z = true;
        }
        FileLock fileLock = null;
        if (!z) {
            FileOutputStream b2 = b(context, true, "tbs_rename_lock");
            if (b2 == null) {
                TbsLog.i("FileHelper", "init -- failed to get rename fileLock#1!");
            } else {
                fileLock = a(context, b2);
                if (fileLock == null) {
                    TbsLog.i("FileHelper", "init -- failed to get rename fileLock#2!");
                } else {
                    TbsLog.i("FileHelper", "init -- get rename fileLock success!");
                }
            }
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is " + fileLock);
            return fileLock;
        }
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
        File a2 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 " + a2);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "r");
            d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0, LongCompanionObject.MAX_VALUE, true);
        } catch (Throwable th) {
            TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + th);
        }
        if (fileLock == null) {
            fileLock = g(context);
        }
        if (fileLock == null) {
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: " + "tbs_rename_lock");
        } else {
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- success: " + "tbs_rename_lock");
        }
        return fileLock;
    }

    private static FileLock g(Context context) {
        FileLock fileLock = null;
        try {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File a2 = a(context, "tbs_rename_lock");
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                boolean z = false;
                int i = 0;
                while (i < 20 && fileLock == null) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "r");
                    d = randomAccessFile;
                    fileLock = randomAccessFile.getChannel().tryLock(0, LongCompanionObject.MAX_VALUE, true);
                    i++;
                }
                if (fileLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("getTbsCoreLoadFileLock,retry num=");
                sb.append(i);
                sb.append("success=");
                if (fileLock == null) {
                    z = true;
                }
                sb.append(z);
                TbsLog.i("FileHelper", sb.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return fileLock;
    }

    public static FileLock f(Context context) {
        FileLock fileLock;
        File a2 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 " + a2);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "rw");
            d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0, LongCompanionObject.MAX_VALUE, false);
        } catch (Throwable unused) {
            TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: " + "tbs_rename_lock");
            fileLock = null;
        }
        if (fileLock == null) {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- failed: " + "tbs_rename_lock");
        } else {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- success: " + "tbs_rename_lock");
        }
        return fileLock;
    }

    public static synchronized void a(Context context, FileLock fileLock) {
        synchronized (f.class) {
            TbsLog.i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: " + fileLock);
            FileChannel channel = fileLock.channel();
            if (channel != null && channel.isOpen()) {
                try {
                    fileLock.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
