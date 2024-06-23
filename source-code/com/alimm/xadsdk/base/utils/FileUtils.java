package com.alimm.xadsdk.base.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
public class FileUtils {
    private static final int COPY_BUFFER_SIZE = 4096;
    public static final int DIR_TYPE_CACHE = 1;
    public static final int DIR_TYPE_FILE = 0;
    private static final String TAG = "FileUtils";

    /* compiled from: Taobao */
    public interface FileKeepRule {
        boolean needKept(String str);
    }

    private static void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean copyTo(File file, InputStream inputStream) {
        Throwable th;
        IOException e;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        closeIO(fileOutputStream2);
                        return true;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    LogUtils.d(TAG, "copyTo exception: output = " + file, e);
                    closeIO(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    closeIO(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                closeIO(fileOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            LogUtils.d(TAG, "copyTo exception: output = " + file, e);
            closeIO(fileOutputStream);
            return false;
        }
    }

    public static boolean decompress(String str, String str2) {
        Throwable th;
        Exception e;
        ZipInputStream zipInputStream = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(new File(str)));
            boolean z = true;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry != null) {
                        String joinPath = joinPath(str2, nextEntry.getName());
                        if (nextEntry.isDirectory()) {
                            mkdir(joinPath);
                        } else {
                            z &= copyTo(new File(joinPath), zipInputStream2);
                        }
                    } else {
                        closeIO(zipInputStream2);
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    zipInputStream = zipInputStream2;
                    try {
                        LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
                        closeIO(zipInputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        closeIO(zipInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream = zipInputStream2;
                    closeIO(zipInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
            closeIO(zipInputStream);
            return false;
        }
    }

    public static void delete(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                deleteFile(new File(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteExpiredFiles(String str, int i, FileKeepRule fileKeepRule) {
        try {
            List<File> files = getFiles(str);
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "deleteExpiredFiles: expireDays = " + i);
            }
            if (files != null && files.size() > 0) {
                for (File file : files) {
                    if (System.currentTimeMillis() - file.lastModified() > TimeUnit.DAYS.toMillis((long) i) && (fileKeepRule == null || !fileKeepRule.needKept(file.getName()))) {
                        if (LogUtils.DEBUG) {
                            LogUtils.d(TAG, "deleteExpiredFile: file = " + file);
                        }
                        deleteFile(file);
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "deleteExpiredFiles: exception.", e);
        }
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (!deleteFile(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static boolean ensureFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            File parentFile = file.getParentFile();
            return (parentFile.exists() || parentFile.mkdirs()) && file.createNewFile();
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean exists(String str) {
        try {
            return !TextUtils.isEmpty(str) && new File(str).exists();
        } catch (SecurityException e) {
            LogUtils.d(TAG, "call exists failed.", e);
            return false;
        }
    }

    public static File getExternalDir(@NonNull Context context, int i) {
        if (i == 0) {
            try {
                return context.getExternalFilesDir(null);
            } catch (Throwable unused) {
                LogUtils.d(TAG, "getExternalDir exception: type = " + i);
                return null;
            }
        } else if (i == 1) {
            return context.getExternalCacheDir();
        } else {
            return null;
        }
    }

    @NonNull
    public static List<File> getFiles(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            getFiles(str, arrayList);
        }
        return arrayList;
    }

    private static List<File> getFiles(String str, List<File> list) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    getFiles(file2.getAbsolutePath(), list);
                }
                list.add(file2);
            }
        }
        return list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        r5 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x001b] */
    public static synchronized String getStrFromFile(String str) {
        String str2;
        Exception e;
        synchronized (FileUtils.class) {
            String str3 = "";
            FileInputStream fileInputStream = null;
            try {
                if (!new File(str).exists()) {
                    closeIO(null);
                    return null;
                }
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    str2 = new String(bArr, "UTF-8");
                    fileInputStream2.close();
                    closeIO(fileInputStream2);
                } catch (Exception e2) {
                    e = e2;
                    str3 = str2;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        closeIO(fileInputStream);
                        str2 = str3;
                        return str2;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        closeIO(fileInputStream);
                        throw th2;
                    }
                } catch (Throwable th3) {
                }
                return str2;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                closeIO(fileInputStream);
                str2 = str3;
                return str2;
            }
        }
    }

    public static String joinPath(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (i > 0) {
                    sb.append(File.separator);
                }
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    public static void mkdir(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                } catch (Exception e) {
                    LogUtils.d(TAG, "mkdir exception: folderPath = " + str, e);
                }
            }
        }
    }

    public static String readAssetFile(@NonNull Context context, @NonNull String str) {
        Throwable th;
        Exception e;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        closeIO(bufferedReader2);
                        return sb2;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                bufferedReader = bufferedReader2;
                try {
                    e.printStackTrace();
                    closeIO(bufferedReader);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    closeIO(bufferedReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                closeIO(bufferedReader);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            closeIO(bufferedReader);
            return "";
        }
    }

    public static List<String> readLines(String str) {
        Throwable th;
        IOException e;
        LinkedList linkedList = new LinkedList();
        if (exists(str)) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        linkedList.add(readLine);
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        try {
                            e.printStackTrace();
                            closeIO(bufferedReader);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            closeIO(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        closeIO(bufferedReader);
                        throw th;
                    }
                }
                closeIO(bufferedReader2);
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                closeIO(bufferedReader);
                return linkedList;
            }
        }
        return linkedList;
    }

    public static synchronized boolean saveStrToFile(String str, String str2) {
        Throwable th;
        Exception e;
        synchronized (FileUtils.class) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(str);
                if (!file.exists()) {
                    new File(file.getParent()).mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str2.getBytes());
                    fileOutputStream2.close();
                    closeIO(fileOutputStream2);
                    z = true;
                } catch (Exception e2) {
                    fileOutputStream = fileOutputStream2;
                    e = e2;
                    try {
                        e.printStackTrace();
                        closeIO(fileOutputStream);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        closeIO(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileOutputStream = fileOutputStream2;
                    th = th3;
                    closeIO(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                closeIO(fileOutputStream);
                return z;
            }
            return z;
        }
    }

    public static void writeLine(String str, boolean z, String str2) {
        Throwable th;
        IOException e;
        if (ensureFileExists(str)) {
            PrintWriter printWriter = null;
            try {
                PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(str, z)));
                try {
                    printWriter2.println(str2);
                    closeIO(printWriter2);
                } catch (IOException e2) {
                    e = e2;
                    printWriter = printWriter2;
                    try {
                        e.printStackTrace();
                        closeIO(printWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        closeIO(printWriter);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    printWriter = printWriter2;
                    closeIO(printWriter);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                closeIO(printWriter);
            }
        }
    }
}
