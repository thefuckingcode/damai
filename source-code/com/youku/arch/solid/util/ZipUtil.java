package com.youku.arch.solid.util;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
public final class ZipUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int BUFFER_LEN = 8192;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static boolean createOrExistsDir(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831743113")) {
            return ((Boolean) ipChange.ipc$dispatch("-1831743113", new Object[]{file})).booleanValue();
        } else if (file == null) {
            return false;
        } else {
            if (file.exists()) {
                return file.isDirectory();
            }
            if (!file.mkdirs()) {
                return false;
            }
        }
    }

    public static boolean createOrExistsFile(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678455680")) {
            return ((Boolean) ipChange.ipc$dispatch("-678455680", new Object[]{file})).booleanValue();
        } else if (file == null) {
            return false;
        } else {
            if (file.exists()) {
                return file.isFile();
            }
            if (!createOrExistsDir(file.getParentFile())) {
                return false;
            }
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    private static boolean unzipChildFile(File file, Map<String, File> map, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551730894")) {
            return ((Boolean) ipChange.ipc$dispatch("1551730894", new Object[]{file, map, zipFile, zipEntry, str})).booleanValue();
        }
        File file2 = new File(file, str);
        map.put(file2.getName(), file2);
        if (zipEntry.isDirectory()) {
            return createOrExistsDir(file2);
        }
        if (!createOrExistsFile(file2)) {
            return false;
        }
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                            return true;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                bufferedOutputStream = null;
                th = th3;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            bufferedOutputStream = null;
            th = th4;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
    }

    public static Map<String, File> unzipFileByKeyword(File file, File file2, String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2140079749")) {
            return (Map) ipChange.ipc$dispatch("-2140079749", new Object[]{file, file2, str});
        } else if (file == null || file2 == null) {
            return null;
        } else {
            HashMap hashMap = new HashMap();
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            try {
                if (TextUtils.isEmpty(str)) {
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        if (!unzipChildFile(file2, hashMap, zipFile, zipEntry, zipEntry.getName().replace("\\", "/"))) {
                            return hashMap;
                        }
                    }
                } else {
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry2 = (ZipEntry) entries.nextElement();
                        String replace = zipEntry2.getName().replace("\\", "/");
                        if (replace.contains(str) && !unzipChildFile(file2, hashMap, zipFile, zipEntry2, replace)) {
                            zipFile.close();
                            return hashMap;
                        }
                    }
                }
                zipFile.close();
                return hashMap;
            } finally {
                zipFile.close();
            }
        }
    }
}
