package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.amap.api.mapcore.util.eq;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.MapsInitializer;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
public class FileUtil {
    private static final int BUFFER = 1024;
    private static final String FILE_PATH_ENTRY_BACK = "..";
    private static final String FILE_PATH_ENTRY_SEPARATOR = "/";
    private static final String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    /* compiled from: Taobao */
    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    /* compiled from: Taobao */
    public interface ZipCompressProgressListener {
        void onFinishProgress(long j);
    }

    public static boolean checkCanWrite(File file) {
        if (file == null || !file.canWrite()) {
            return false;
        }
        File file2 = new File(file, "amap.tmp");
        try {
            file2.createNewFile();
            if (!file2.exists()) {
                return false;
            }
            try {
                file2.delete();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static byte[] compress(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(str2));
            gZIPOutputStream.close();
        } catch (IOException e) {
            Log.e("gzip compress error.", e.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void copy(Context context, String str, File file) throws Exception {
        file.delete();
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        open.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0, null);
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j, long j2, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            } else if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && zipCompressProgressListener != null) {
                    long j3 = ((((long) i) + j) * 100) / j2;
                    if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                        zipCompressProgressListener.onFinishProgress(j3);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i;
            }
        }
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!deleteFile(listFiles[i])) {
                    return false;
                } else {
                    listFiles[i].delete();
                }
            }
        }
        file.delete();
        return true;
    }

    private static void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            fileProber(parentFile);
            parentFile.mkdir();
        }
    }

    public static String getExternalStroragePath(Context context) {
        int i;
        String str;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 12) {
            try {
                StorageManager storageManager = (StorageManager) context.getSystemService("storage");
                Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
                Method method2 = StorageManager.class.getMethod("getVolumeState", String.class);
                Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
                int length = objArr.length;
                String str2 = "";
                String str3 = str2;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i = 18;
                        str = null;
                        break;
                    }
                    Object obj = objArr[i3];
                    Method method3 = obj.getClass().getMethod("getPath", new Class[0]);
                    Method method4 = obj.getClass().getMethod("isRemovable", new Class[0]);
                    str = (String) method3.invoke(obj, new Object[0]);
                    String str4 = (String) method2.invoke(storageManager, method3.invoke(obj, new Object[0]));
                    Boolean bool = (Boolean) method4.invoke(obj, new Object[0]);
                    if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE)) {
                        if (!bool.booleanValue()) {
                            str3 = str4;
                            str2 = str;
                            i3++;
                            objArr = objArr;
                        } else if (!(str == null || str4 == null || !str4.equals("mounted"))) {
                            if (i2 > 18) {
                                try {
                                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                                    if (externalFilesDirs == null) {
                                        str = null;
                                    } else if (externalFilesDirs.length > 1) {
                                        str = externalFilesDirs[1].getAbsolutePath();
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            i = 18;
                        }
                    }
                    i3++;
                    objArr = objArr;
                }
                return i2 <= i ? (str != null || str2 == null || str3 == null || !str3.equals("mounted")) ? str : str2 : (str2 == null || str3 == null || !str3.equals("mounted")) ? str : str2;
            } catch (Throwable unused2) {
            }
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().toString();
        }
        return null;
    }

    public static String getMapBaseStorage(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        String str2 = Build.VERSION.SDK_INT > 18 ? "map_base_path_v44" : "map_base_path";
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        String str3 = MapsInitializer.sdcardDir;
        if (str3 == null || str3.trim().length() <= 0) {
            str = sharedPreferences.getString(str2, "");
        } else {
            str = MapsInitializer.sdcardDir + File.separatorChar;
        }
        if (str != null && str.length() > 2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return str;
                }
                String str4 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
                if (str4 != null && str4.length() > 2) {
                    File file2 = new File(str4);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (file2.isDirectory()) {
                        return str4;
                    }
                }
            }
        }
        String str5 = getExternalStroragePath(context) + AeUtil.ROOTPATH;
        if (str5 != null && str5.length() > 2) {
            File file3 = new File(str5);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory() && file3.canWrite()) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str2, str5);
                edit.commit();
                createNoMediaFileIfNotExist(str5);
                return str5;
            }
        }
        String str6 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (str6 != null && str6.length() > 2) {
            File file4 = new File(str6);
            if (!file4.exists()) {
                file4.mkdir();
            }
            file4.isDirectory();
        }
        return str6;
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static InputStream getZipInputStream(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (isGzip(bArr)) {
            return new GZIPInputStream(byteArrayInputStream);
        }
        return new ZipInputStream(byteArrayInputStream);
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static boolean isSafeEntryName(String str) {
        return !str.contains(FILE_PATH_ENTRY_BACK) && !str.contains("/") && !str.contains(FILE_PATH_ENTRY_SEPARATOR1) && !str.contains("%");
    }

    private static byte[] readByteByStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static byte[] readFileContents(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th) {
            hd.c(th, TAG, "readFileContents");
            eq.a(th);
            return null;
        }
    }

    public static byte[] readFileContentsFromAssets(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            int available = open.available();
            if (available == 0) {
                return null;
            }
            byte[] bArr = new byte[available];
            for (int i = 0; i < available; i += open.read(bArr, i, available - i)) {
            }
            open.close();
            return bArr;
        } catch (IOException | OutOfMemoryError unused) {
            return null;
        }
    }

    private static void safelyCloseFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void saveFile(String str, String str2, boolean z) {
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            File file = new File(absolutePath + "/" + str2);
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, z);
            fileOutputStream.write(str.getBytes("utf-8"));
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static Pair<String, byte[]> uncompressToByte(byte[] bArr) {
        InputStream inputStream;
        Throwable th;
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            try {
                if (inputStream instanceof ZipInputStream) {
                    str = ((ZipInputStream) inputStream).getNextEntry().getName();
                    if (!isSafeEntryName(str)) {
                        Log.e("gzip compress error.", "gzip name contains ../ " + str);
                        safelyCloseFile(inputStream);
                        return null;
                    }
                } else {
                    str = "";
                }
                if (inputStream != null) {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            Pair<String, byte[]> pair = new Pair<>(str, byteArrayOutputStream.toByteArray());
                            safelyCloseFile(inputStream);
                            return pair;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.e("gzip compress error.", th.getMessage());
                    safelyCloseFile(inputStream);
                    return null;
                } catch (Throwable th3) {
                    safelyCloseFile(inputStream);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            Log.e("gzip compress error.", th.getMessage());
            safelyCloseFile(inputStream);
            return null;
        }
        safelyCloseFile(inputStream);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map<java.lang.String, byte[]>] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static Map<String, byte[]> uncompressToByteWithKeys(byte[] bArr, String[] strArr) {
        Throwable th;
        HashMap hashMap = new HashMap();
        if (bArr == null || bArr.length == 0) {
            return hashMap;
        }
        ?? r2 = 0;
        try {
            InputStream zipInputStream = getZipInputStream(bArr);
            try {
                if (zipInputStream instanceof ZipInputStream) {
                    ZipInputStream zipInputStream2 = (ZipInputStream) zipInputStream;
                    while (true) {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            try {
                                String name = nextEntry.getName();
                                if (isSafeEntryName(name)) {
                                    int length = strArr.length;
                                    int i = 0;
                                    while (true) {
                                        if (i >= length) {
                                            break;
                                        }
                                        String str = strArr[i];
                                        if (name.equals(str)) {
                                            byte[] readByteByStream = readByteByStream(zipInputStream2);
                                            if (readByteByStream != null) {
                                                hashMap.put(str, readByteByStream);
                                            }
                                        } else {
                                            i++;
                                        }
                                    }
                                } else {
                                    Log.e("gzip compress error.", "gzip name contains ../ " + name);
                                    safelyCloseFile(zipInputStream);
                                    return r2;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        zipInputStream2.closeEntry();
                    }
                }
                safelyCloseFile(zipInputStream);
            } catch (Throwable th2) {
                th = th2;
                r2 = zipInputStream;
                try {
                    Log.e("gzip compress error.", th.getMessage());
                    return hashMap;
                } finally {
                    safelyCloseFile(r2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            Log.e("gzip compress error.", th.getMessage());
            return hashMap;
        }
        return hashMap;
    }

    public static String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    writeLock.unlock();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                writeLock.unlock();
                throw th;
            }
        }
        writeLock.unlock();
    }

    private static void decompress(InputStream inputStream, String str, long j, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress(null, new File(str), zipInputStream, j, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    public static String uncompressToString(byte[] bArr, String str) {
        Throwable th;
        IOException e;
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            if (inputStream != null) {
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
                            safelyCloseFile(inputStream);
                            return byteArrayOutputStream2;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.e("gzip compress error.", e.getMessage());
                        safelyCloseFile(inputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                    }
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            Log.e("gzip compress error.", e.getMessage());
            safelyCloseFile(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            safelyCloseFile(inputStream2);
            throw th;
        }
        safelyCloseFile(inputStream);
        return null;
    }

    private static void decompress(File file, File file2, ZipInputStream zipInputStream, long j, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        boolean z = false;
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            } else if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                String name = nextEntry.getName();
                if (TextUtils.isEmpty(name) || !isSafeEntryName(name)) {
                    z = true;
                } else {
                    File file3 = new File(file2.getPath() + File.separator + name);
                    fileProber(file3);
                    if (nextEntry.isDirectory()) {
                        file3.mkdirs();
                    } else {
                        i += decompressFile(file3, zipInputStream, (long) i, j, zipCompressProgressListener, unZipFileBrake);
                    }
                    zipInputStream.closeEntry();
                }
            } else {
                zipInputStream.closeEntry();
                return;
            }
        }
        z = true;
        if (z && file != null) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }
}
