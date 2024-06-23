package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: Taobao */
public class CreateFileUtil {
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    public static void deleteSecure(File file) {
        if (file != null && file.exists() && !file.delete()) {
            Logger.w(TAG, "deleteSecure exception");
        }
    }

    public static String getCacheDirPath(Context context) {
        return context == null ? "" : ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static String getCanonicalPath(String str) {
        try {
            return newFile(str).getCanonicalPath();
        } catch (IOException e) {
            Logger.w(TAG, "the canonicalPath has IOException", e);
            return str;
        } catch (SecurityException e2) {
            Logger.w(TAG, "the canonicalPath has securityException", e2);
            return str;
        } catch (Exception e3) {
            Logger.w(TAG, "the canonicalPath has other Exception", e3);
            return str;
        }
    }

    @Deprecated
    public static boolean isPVersion() {
        return EmuiUtil.isUpPVersion();
    }

    public static File newFile(String str) {
        if (str == null) {
            return null;
        }
        if (!EmuiUtil.isUpPVersion() || !ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME)) {
            return new File(str);
        }
        return new ExternalStorageFile(str);
    }

    public static FileInputStream newFileInputStream(String str) throws FileNotFoundException {
        if (str == null) {
            Logger.w(TAG, "newFileInputStream  file is null");
            throw new FileNotFoundException("file is null");
        } else if (!EmuiUtil.isUpPVersion() || !ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) {
            return new FileInputStream(str);
        } else {
            return new ExternalStorageFileInputStream(str);
        }
    }

    public static FileOutputStream newFileOutputStream(File file) throws FileNotFoundException {
        if (file == null) {
            Logger.e(TAG, "newFileOutputStream  file is null");
            throw new FileNotFoundException("file is null");
        } else if (!EmuiUtil.isUpPVersion() || !ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) {
            return new FileOutputStream(file);
        } else {
            return new ExternalStorageFileOutputStream(file);
        }
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) throws FileNotFoundException {
        if (str == null) {
            Logger.w(TAG, "newFileOutputStream  file is null");
            throw new FileNotFoundException("file is null");
        } else if (!EmuiUtil.isUpPVersion() || !ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME)) {
            return new RandomAccessFile(str, str2);
        } else {
            return new ExternalStorageRandomAccessFile(str, str2);
        }
    }

    public static void deleteSecure(String str) {
        if (!TextUtils.isEmpty(str)) {
            deleteSecure(newFile(str));
        }
    }
}
