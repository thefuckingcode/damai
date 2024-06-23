package com.youku.arch.v3.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* compiled from: Taobao */
public class FileUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "OneArch.FileUtil";
    private static String mSeparator = File.separator;
    private static char mSeparatorChar = File.separatorChar;

    public static synchronized int clearFolder(String str, long j) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1875557543")) {
                return ((Integer) ipChange.ipc$dispatch("-1875557543", new Object[]{str, Long.valueOf(j)})).intValue();
            }
            if (!TextUtils.isEmpty(str)) {
                i = clearFolder(new File(str), j);
            }
            return i;
        }
    }

    public static int clearFolderNoSynchronized(File file, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "581912545")) {
            return ((Integer) ipChange.ipc$dispatch("581912545", new Object[]{file, Long.valueOf(j)})).intValue();
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        int i = 0;
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                i += clearFolder(file2, j);
            }
            if (file2.lastModified() < currentTimeMillis && file2.delete()) {
                i++;
            }
        }
        return i;
    }

    public static void closeQuietly(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847702425")) {
            ipChange.ipc$dispatch("1847702425", new Object[]{closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean copy(String str, String str2) {
        FileNotFoundException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1491919522")) {
            return ((Boolean) ipChange.ipc$dispatch("-1491919522", new Object[]{str, str2})).booleanValue();
        } else if (str == null || str2 == null) {
            throw new NullPointerException("path should not be null.");
        } else {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str2);
                try {
                    return store(fileInputStream2, str);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return false;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                fileInputStream.close();
                return false;
            }
        }
    }

    public static void copyFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158171582")) {
            ipChange.ipc$dispatch("1158171582", new Object[]{str, str2});
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    copyFile(fileInputStream2, fileOutputStream);
                    fileOutputStream.flush();
                    closeQuietly(fileInputStream2);
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
            closeQuietly(fileInputStream);
            closeQuietly(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            closeQuietly(fileInputStream);
            closeQuietly(fileOutputStream);
            throw th;
        }
        closeQuietly(fileOutputStream);
    }

    public static synchronized File createFile(String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2083553376")) {
                return (File) ipChange.ipc$dispatch("2083553376", new Object[]{str});
            } else if (TextUtils.isEmpty(str)) {
                return null;
            } else {
                File file = new File(str);
                if (file.isFile()) {
                    return file;
                }
                File parentFile = file.getParentFile();
                if (parentFile != null && (parentFile.isDirectory() || parentFile.mkdirs())) {
                    try {
                        if (file.createNewFile()) {
                            return file;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }
    }

    public static synchronized File createFolder(String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1352869202")) {
                return (File) ipChange.ipc$dispatch("1352869202", new Object[]{str});
            }
            File file = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file2 = new File(str);
            if (file2.isDirectory() || file2.mkdirs()) {
                file = file2;
            }
            return file;
        }
    }

    public static synchronized boolean delete(String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "345709982")) {
                return ((Boolean) ipChange.ipc$dispatch("345709982", new Object[]{str})).booleanValue();
            }
            if (!TextUtils.isEmpty(str) && delete(new File(str))) {
                z = true;
            }
            return z;
        }
    }

    public static void deleteAllFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46203783")) {
            ipChange.ipc$dispatch("46203783", new Object[]{str});
            return;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length != 0) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                deleteAllFile(listFiles[i].getAbsolutePath());
                                listFiles[i].delete();
                            } else {
                                listFiles[i].delete();
                            }
                        }
                        return;
                    }
                }
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public static void deleteFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493317634")) {
            ipChange.ipc$dispatch("-1493317634", new Object[]{str});
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean deleteNoSynchronized(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "409491433")) {
            return !TextUtils.isEmpty(str) && deleteNoSynchronized(new File(str));
        }
        return ((Boolean) ipChange.ipc$dispatch("409491433", new Object[]{str})).booleanValue();
    }

    public static boolean exists(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "132282253")) {
            return !TextUtils.isEmpty(str) && new File(str).exists();
        }
        return ((Boolean) ipChange.ipc$dispatch("132282253", new Object[]{str})).booleanValue();
    }

    public static boolean fileExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138951025")) {
            return ((Boolean) ipChange.ipc$dispatch("138951025", new Object[]{str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
            return true;
        }
    }

    public static long fileLength(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937657111")) {
            return ((Long) ipChange.ipc$dispatch("1937657111", new Object[]{str})).longValue();
        } else if (fileExists(str)) {
            return new File(str).length();
        } else {
            return 0;
        }
    }

    public static boolean folderExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1960801857")) {
            return ((Boolean) ipChange.ipc$dispatch("-1960801857", new Object[]{str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                return false;
            }
            return true;
        }
    }

    public static String getCanonicalPath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305103774")) {
            return (String) ipChange.ipc$dispatch("1305103774", new Object[]{str});
        }
        try {
            return new File(str).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getFileExtension(String str) {
        int lastIndexOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145384184")) {
            return (String) ipChange.ipc$dispatch("-145384184", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf2 = str.lastIndexOf(63);
        if (lastIndexOf2 > 0) {
            str = str.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = str.lastIndexOf(47);
        if (lastIndexOf3 >= 0) {
            str = str.substring(lastIndexOf3 + 1);
        }
        return (str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) < 0) ? "" : str.substring(lastIndexOf + 1);
    }

    public static String getFileName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593426364")) {
            return (String) ipChange.ipc$dispatch("-1593426364", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            int lastIndexOf = str.lastIndexOf(63);
            if (lastIndexOf > 0) {
                str = str.substring(0, lastIndexOf);
            }
            int lastIndexOf2 = str.lastIndexOf(mSeparatorChar);
            return lastIndexOf2 >= 0 ? str.substring(lastIndexOf2 + 1) : str;
        }
    }

    public static String getFilePath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1822762078")) {
            return (String) ipChange.ipc$dispatch("1822762078", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            int lastIndexOf = (str == null || !str.startsWith(mSeparator)) ? -1 : str.lastIndexOf(mSeparatorChar);
            return lastIndexOf == -1 ? mSeparator : str.substring(0, lastIndexOf);
        }
    }

    public static String getFileShortName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687183888")) {
            return (String) ipChange.ipc$dispatch("-687183888", new Object[]{str});
        }
        String fileName = getFileName(str);
        int lastIndexOf = fileName.lastIndexOf(46);
        return lastIndexOf > 0 ? fileName.substring(0, lastIndexOf) : fileName;
    }

    public static synchronized long getFileSize(String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "460057114")) {
                return ((Long) ipChange.ipc$dispatch("460057114", new Object[]{str})).longValue();
            }
            return TextUtils.isEmpty(str) ? 0 : getFileSize(new File(str));
        }
    }

    public static Uri getResourceUri(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469424955")) {
            return (Uri) ipChange.ipc$dispatch("-469424955", new Object[]{context, Integer.valueOf(i)});
        }
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005d, code lost:
        if (exists(r6 + r5 + r0) != false) goto L_0x0061;
     */
    public static boolean isSamePhysicalPath(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1905657")) {
            return ((Boolean) ipChange.ipc$dispatch("-1905657", new Object[]{str, str2})).booleanValue();
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str3 = File.separator;
        sb.append(str3);
        sb.append(valueOf.toString());
        String sb2 = sb.toString();
        createFile(sb2);
        if (exists(sb2)) {
        }
        z = false;
        delete(sb2);
        return z;
    }

    public static long lastModified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746186682")) {
            return ((Long) ipChange.ipc$dispatch("746186682", new Object[]{str})).longValue();
        } else if (TextUtils.isEmpty(str)) {
            return 0;
        } else {
            return new File(str).lastModified();
        }
    }

    public static String load(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152333887")) {
            return (String) ipChange.ipc$dispatch("-1152333887", new Object[]{str});
        }
        Objects.requireNonNull(str, "path should not be null.");
        String str2 = null;
        try {
            str2 = stringFromInputStream(new FileInputStream(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2 != null ? str2 : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0045 A[SYNTHETIC, Splitter:B:30:0x0045] */
    public static byte[] readFile(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377011018")) {
            return (byte[]) ipChange.ipc$dispatch("377011018", new Object[]{str});
        } else if (str == null) {
            return null;
        } else {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] byteArray = toByteArray(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                    }
                    return byteArray;
                } catch (Exception unused2) {
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
    }

    public static String readFileFromAssets(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "695400362")) {
            return (String) ipChange.ipc$dispatch("695400362", new Object[]{context, str});
        }
        AssetManager assets = context.getAssets();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream2 = null;
        try {
            inputStream = assets.open(str);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                        closeQuietly(inputStream);
                        closeQuietly(byteArrayOutputStream);
                        return str2;
                    }
                }
            } catch (IOException unused) {
                closeQuietly(inputStream);
                closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                closeQuietly(inputStream2);
                closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            closeQuietly(inputStream);
            closeQuietly(byteArrayOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeQuietly(inputStream2);
            closeQuietly(byteArrayOutputStream);
            throw th;
        }
    }

    public static String readFileFromRaw(Context context, int i) {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1825375070")) {
            return (String) ipChange.ipc$dispatch("-1825375070", new Object[]{context, Integer.valueOf(i)});
        }
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(context.getResources().openRawResource(i));
            try {
                bufferedReader = new BufferedReader(inputStreamReader2);
                String str = "";
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str = str + readLine;
                        } else {
                            closeQuietly(inputStreamReader2);
                            closeQuietly(bufferedReader);
                            return str;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStreamReader = inputStreamReader2;
                        try {
                            e.printStackTrace();
                            closeQuietly(inputStreamReader);
                            closeQuietly(bufferedReader);
                            return "";
                        } catch (Throwable th2) {
                            th = th2;
                            closeQuietly(inputStreamReader);
                            closeQuietly(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = inputStreamReader2;
                        closeQuietly(inputStreamReader);
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                inputStreamReader = inputStreamReader2;
                e.printStackTrace();
                closeQuietly(inputStreamReader);
                closeQuietly(bufferedReader);
                return "";
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = inputStreamReader2;
                closeQuietly(inputStreamReader);
                closeQuietly(bufferedReader);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            e.printStackTrace();
            closeQuietly(inputStreamReader);
            closeQuietly(bufferedReader);
            return "";
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            closeQuietly(inputStreamReader);
            closeQuietly(bufferedReader);
            throw th;
        }
    }

    public static boolean rename(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361321461")) {
            return ((Boolean) ipChange.ipc$dispatch("361321461", new Object[]{str, str2})).booleanValue();
        }
        File file = new File(str);
        if (!file.isFile() || !file.renameTo(new File(str2))) {
            return false;
        }
        return true;
    }

    public static void setSeparatorChar(char c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083640293")) {
            ipChange.ipc$dispatch("-2083640293", new Object[]{Character.valueOf(c)});
            return;
        }
        mSeparatorChar = c;
        mSeparator = String.valueOf(c);
    }

    public static synchronized boolean store(String str, String str2) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "284468838")) {
                return ((Boolean) ipChange.ipc$dispatch("284468838", new Object[]{str, str2})).booleanValue();
            }
            return store(str, str2, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0074 A[SYNTHETIC, Splitter:B:37:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087 A[SYNTHETIC, Splitter:B:47:0x0087] */
    public static boolean storeNoSynchronized(InputStream inputStream, String str) {
        Throwable th;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051633320")) {
            return ((Boolean) ipChange.ipc$dispatch("2051633320", new Object[]{inputStream, str})).booleanValue();
        }
        Objects.requireNonNull(str, "filePath should not be null.");
        FileOutputStream fileOutputStream = null;
        try {
            File createFile = createFile(str);
            if (createFile == null) {
                Log.d("FileUtils", String.format("inputStream sotreFile == null filePath=%s", str));
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return false;
            }
            byte[] bArr = new byte[4096];
            FileOutputStream fileOutputStream2 = new FileOutputStream(createFile);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                        }
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    inputStream.close();
                    throw th;
                }
            }
            fileOutputStream2.close();
            try {
                inputStream.close();
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            return true;
        } catch (Exception e9) {
            e = e9;
            e.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            inputStream.close();
            return false;
        }
    }

    public static String stringFromInputStream(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648332621")) {
            return (String) ipChange.ipc$dispatch("1648332621", new Object[]{inputStream});
        }
        try {
            byte[] bArr = new byte[4096];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream2;
        } catch (Exception e2) {
            e2.printStackTrace();
            inputStream.close();
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            try {
                inputStream.close();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1879123843")) {
            return (byte[]) ipChange.ipc$dispatch("1879123843", new Object[]{inputStream});
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[100];
        while (true) {
            int read = inputStream.read(bArr, 0, 100);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean updateFileLastModified(String str, long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1547278343")) {
            return fileExists(str) && new File(str).setLastModified(j);
        }
        return ((Boolean) ipChange.ipc$dispatch("1547278343", new Object[]{str, Long.valueOf(j)})).booleanValue();
    }

    public static String validateFileName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489811464")) {
            return (String) ipChange.ipc$dispatch("-1489811464", new Object[]{str});
        } else if (str == null) {
            return null;
        } else {
            return str.replaceAll("([{/\\\\:*?\"<>|}\\u0000-\\u001f\\uD7B0-\\uFFFF]+)", "");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041 A[SYNTHETIC, Splitter:B:21:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0048 A[SYNTHETIC, Splitter:B:27:0x0048] */
    public static boolean writeFile(String str, byte[] bArr) {
        Throwable th;
        FileOutputStream fileOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108526071")) {
            return ((Boolean) ipChange.ipc$dispatch("-108526071", new Object[]{str, bArr})).booleanValue();
        }
        if (!(str == null || bArr == null)) {
            File file = new File(str);
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static synchronized void clearFolder(String str, long j, boolean z) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1987304494")) {
                ipChange.ipc$dispatch("1987304494", new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)});
                return;
            }
            clearFolder(str, j, (String[]) null);
        }
    }

    public static synchronized boolean delete(File file) {
        File[] listFiles;
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "675112267")) {
                return ((Boolean) ipChange.ipc$dispatch("675112267", new Object[]{file})).booleanValue();
            }
            if (file == null) {
                return true;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (!delete(file2)) {
                        return false;
                    }
                }
            }
            if (!file.exists() || file.delete()) {
                z = true;
            }
            return z;
        }
    }

    public static boolean deleteNoSynchronized(File file) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094615786")) {
            return ((Boolean) ipChange.ipc$dispatch("-1094615786", new Object[]{file})).booleanValue();
        }
        if (file == null) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (!delete(file2)) {
                    return false;
                }
            }
        }
        if (!file.exists() || file.delete()) {
            return true;
        }
        return false;
    }

    public static synchronized long getFileSize(File file) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-417179705")) {
                return ((Long) ipChange.ipc$dispatch("-417179705", new Object[]{file})).longValue();
            }
            long j = 0;
            if (file == null) {
                return 0;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        j += file2.isDirectory() ? getFileSize(file2) : file2.length();
                    }
                }
            } else {
                j = file.length();
            }
            return j;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0075 A[SYNTHETIC, Splitter:B:38:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085 A[SYNTHETIC, Splitter:B:47:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0091 A[SYNTHETIC, Splitter:B:54:0x0091] */
    public static synchronized boolean store(String str, String str2, boolean z) {
        Throwable th;
        IOException e;
        ArrayIndexOutOfBoundsException e2;
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "228645046")) {
                return ((Boolean) ipChange.ipc$dispatch("228645046", new Object[]{str, str2, Boolean.valueOf(z)})).booleanValue();
            } else if (str2 != null) {
                BufferedWriter bufferedWriter = null;
                try {
                    File createFile = createFile(str2);
                    if (createFile == null) {
                        Log.d("FileUtils", String.format("file == null path=%s", str2));
                        return false;
                    }
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(createFile, z));
                    if (str == null) {
                        str = "";
                    }
                    try {
                        bufferedWriter2.write(str);
                        bufferedWriter2.flush();
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return true;
                    } catch (IOException e4) {
                        e = e4;
                        bufferedWriter = bufferedWriter2;
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                        }
                        return false;
                    } catch (ArrayIndexOutOfBoundsException e5) {
                        e2 = e5;
                        bufferedWriter = bufferedWriter2;
                        try {
                            e2.printStackTrace();
                            if (bufferedWriter != null) {
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    return false;
                } catch (ArrayIndexOutOfBoundsException e9) {
                    e2 = e9;
                    e2.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return false;
                }
            } else {
                throw new NullPointerException("path should not be null.");
            }
        }
    }

    public static synchronized void clearFolder(String str, long j, String[] strArr) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-810513415")) {
                ipChange.ipc$dispatch("-810513415", new Object[]{str, Long.valueOf(j), strArr});
                return;
            }
            long fileSize = getFileSize(str);
            if (fileSize > j) {
                List arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
                File[] listFiles = new File(str).listFiles();
                if (listFiles != null) {
                    List<File> asList = Arrays.asList(listFiles);
                    try {
                        Collections.sort(asList, new Comparator<File>() {
                            /* class com.youku.arch.v3.util.FileUtil.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public int compare(File file, File file2) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-284594818")) {
                                    return ((Integer) ipChange.ipc$dispatch("-284594818", new Object[]{this, file, file2})).intValue();
                                } else if (file.lastModified() == file2.lastModified()) {
                                    return 0;
                                } else {
                                    if (file.lastModified() < file2.lastModified()) {
                                        return -1;
                                    }
                                    return 1;
                                }
                            }
                        });
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    for (File file : asList) {
                        if (fileSize <= j) {
                            break;
                        } else if (!arrayList.contains(file.getAbsolutePath())) {
                            file.lastModified();
                            fileSize -= file.length();
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545668699")) {
            ipChange.ipc$dispatch("545668699", new Object[]{inputStream, outputStream});
            return;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static synchronized int clearFolder(File file, long j) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1017565004")) {
                return ((Integer) ipChange.ipc$dispatch("1017565004", new Object[]{file, Long.valueOf(j)})).intValue();
            }
            long currentTimeMillis = System.currentTimeMillis() - j;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        i2 += clearFolder(file2, j);
                    }
                    if (file2.lastModified() < currentTimeMillis && file2.delete()) {
                        i2++;
                    }
                    i++;
                }
                i = i2;
            }
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0079 A[SYNTHETIC, Splitter:B:44:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x008d A[SYNTHETIC, Splitter:B:55:0x008d] */
    public static synchronized boolean store(InputStream inputStream, String str) {
        Throwable th;
        Exception e;
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-791479917")) {
                return ((Boolean) ipChange.ipc$dispatch("-791479917", new Object[]{inputStream, str})).booleanValue();
            } else if (str != null) {
                FileOutputStream fileOutputStream = null;
                try {
                    File createFile = createFile(str);
                    if (createFile == null) {
                        Log.d("FileUtils", String.format("inputStream file == null path=%s", str));
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return false;
                    }
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream2 = new FileOutputStream(createFile);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read > 0) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            fileOutputStream = fileOutputStream2;
                            try {
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                try {
                                    inputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                try {
                                    inputStream.close();
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                            }
                            inputStream.close();
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                    return true;
                } catch (Exception e10) {
                    e = e10;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                    }
                    inputStream.close();
                    return false;
                }
            } else {
                throw new NullPointerException("path should not be null.");
            }
        }
    }

    public static synchronized int clearFolder(File file) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1972486334")) {
                return ((Integer) ipChange.ipc$dispatch("1972486334", new Object[]{file})).intValue();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        i2 += clearFolder(file2);
                    }
                    if (file2.delete()) {
                        i2++;
                    }
                    i++;
                }
                i = i2;
            }
            return i;
        }
    }
}
