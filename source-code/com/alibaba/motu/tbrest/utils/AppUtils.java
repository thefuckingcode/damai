package com.alibaba.motu.tbrest.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class AppUtils {

    /* compiled from: Taobao */
    public interface ReaderListener {
        boolean onReadLine(String str);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                LogUtil.e("close.", e);
            }
        }
    }

    public static String dumpMeminfo(Context context) {
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Integer num = null;
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                num = Integer.valueOf((int) (memoryInfo.threshold >> 10));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JavaTotal:");
            sb.append(Runtime.getRuntime().totalMemory());
            sb.append(" JavaFree:");
            sb.append(Runtime.getRuntime().freeMemory());
            sb.append(" NativeHeap:");
            sb.append(Debug.getNativeHeapSize());
            sb.append(" NativeAllocated:");
            sb.append(Debug.getNativeHeapAllocatedSize());
            sb.append(" NativeFree:");
            sb.append(Debug.getNativeHeapFreeSize());
            sb.append(" threshold:");
            if (num != null) {
                str = num + " KB";
            } else {
                str = "not valid";
            }
            sb.append(str);
            return sb.toString();
        } catch (Exception e) {
            LogUtil.e("dumpMeminfo", e);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0147  */
    public static String dumpStorage(Context context) {
        boolean z;
        boolean z2;
        File rootDirectory;
        File dataDirectory;
        File downloadCacheDirectory;
        StringBuilder sb = new StringBuilder();
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            LogUtil.w("hasSDCard", e);
            z = false;
        }
        try {
            if ((context.getApplicationInfo().flags & 262144) != 0) {
                z2 = true;
                sb.append("hasSDCard: " + z + StringUtils.LF);
                sb.append("installSDCard: " + z2 + StringUtils.LF);
                rootDirectory = Environment.getRootDirectory();
                if (rootDirectory != null) {
                    long[] sizes = getSizes(rootDirectory.getAbsolutePath());
                    sb.append("RootDirectory: " + rootDirectory.getAbsolutePath() + " ");
                    sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes[0]), Long.valueOf(sizes[1]), Long.valueOf(sizes[2])));
                }
                dataDirectory = Environment.getDataDirectory();
                if (dataDirectory != null) {
                    long[] sizes2 = getSizes(dataDirectory.getAbsolutePath());
                    sb.append("DataDirectory: " + dataDirectory.getAbsolutePath() + " ");
                    sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes2[0]), Long.valueOf(sizes2[1]), Long.valueOf(sizes2[2])));
                }
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (dataDirectory != null) {
                    sb.append("ExternalStorageDirectory: " + externalStorageDirectory.getAbsolutePath() + " ");
                    long[] sizes3 = getSizes(externalStorageDirectory.getAbsolutePath());
                    sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes3[0]), Long.valueOf(sizes3[1]), Long.valueOf(sizes3[2])));
                }
                downloadCacheDirectory = Environment.getDownloadCacheDirectory();
                if (downloadCacheDirectory != null) {
                    sb.append("DownloadCacheDirectory: " + downloadCacheDirectory.getAbsolutePath() + " ");
                    long[] sizes4 = getSizes(downloadCacheDirectory.getAbsolutePath());
                    sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes4[0]), Long.valueOf(sizes4[1]), Long.valueOf(sizes4[2])));
                }
                return sb.toString();
            }
        } catch (Exception e2) {
            LogUtil.w("installSDCard", e2);
        }
        z2 = false;
        sb.append("hasSDCard: " + z + StringUtils.LF);
        sb.append("installSDCard: " + z2 + StringUtils.LF);
        try {
            rootDirectory = Environment.getRootDirectory();
            if (rootDirectory != null) {
            }
            dataDirectory = Environment.getDataDirectory();
            if (dataDirectory != null) {
            }
            File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
            if (dataDirectory != null) {
            }
            downloadCacheDirectory = Environment.getDownloadCacheDirectory();
            if (downloadCacheDirectory != null) {
            }
        } catch (Exception e3) {
            LogUtil.e("getSizes", e3);
        }
        return sb.toString();
    }

    public static String dumpThread(Thread thread) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format("Thread Name: '%s'\n", thread.getName()));
            sb.append(String.format("\"%s\" prio=%d tid=%d %s\n", thread.getName(), Integer.valueOf(thread.getPriority()), Long.valueOf(thread.getId()), thread.getState()));
            StackTraceElement[] stackTrace = thread.getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("\tat %s\n", stackTrace[i].toString()));
            }
        } catch (Exception e) {
            LogUtil.e("dumpThread", e);
        }
        return sb.toString();
    }

    public static String getGMT8Time(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            LogUtil.e("getGMT8Time", e);
            return "";
        }
    }

    public static String getMeminfo() {
        return readFully(new File("/proc/meminfo")).trim();
    }

    public static String getMyProcessNameByAppProcessInfo(Context context) {
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMyProcessNameByCmdline() {
        try {
            return readLine("/proc/self/cmdline").trim();
        } catch (Exception e) {
            LogUtil.e("get my process name by cmd line failure .", e);
            return null;
        }
    }

    public static String getMyStatus() {
        return readFully(new File("/proc/self/status")).trim();
    }

    private static long[] getSizes(String str) {
        long j;
        long j2;
        long j3;
        long j4;
        long[] jArr = {-1, -1, -1};
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT < 18) {
                j4 = (long) statFs.getBlockSize();
                j3 = (long) statFs.getBlockCount();
                j2 = (long) statFs.getFreeBlocks();
                j = (long) statFs.getAvailableBlocks();
            } else {
                j4 = statFs.getBlockSizeLong();
                j3 = statFs.getBlockCountLong();
                j2 = statFs.getFreeBlocksLong();
                j = statFs.getAvailableBlocksLong();
            }
            jArr[0] = j3 * j4;
            jArr[1] = j2 * j4;
            jArr[2] = j4 * j;
        } catch (Exception e) {
            LogUtil.e("getSizes", e);
        }
        return jArr;
    }

    public static Boolean isBackgroundRunning(Context context) {
        try {
            if (Integer.parseInt(readLine("/proc/self/oom_adj").trim()) == 0) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public static String readFully(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        Exception e;
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                inputStreamReader = null;
                try {
                    LogUtil.e("readFully.", e);
                    closeQuietly(inputStreamReader);
                    closeQuietly(fileInputStream);
                    return sb.toString();
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader2 = inputStreamReader;
                    closeQuietly(inputStreamReader2);
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeQuietly(inputStreamReader2);
                closeQuietly(fileInputStream);
                throw th;
            }
            try {
                char[] cArr = new char[4096];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (-1 == read) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (Exception e3) {
                e = e3;
                LogUtil.e("readFully.", e);
                closeQuietly(inputStreamReader);
                closeQuietly(fileInputStream);
                return sb.toString();
            }
        } catch (Exception e4) {
            fileInputStream = null;
            e = e4;
            inputStreamReader = null;
            LogUtil.e("readFully.", e);
            closeQuietly(inputStreamReader);
            closeQuietly(fileInputStream);
            return sb.toString();
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            closeQuietly(inputStreamReader2);
            closeQuietly(fileInputStream);
            throw th;
        }
        closeQuietly(inputStreamReader);
        closeQuietly(fileInputStream);
        return sb.toString();
    }

    public static String readLine(String str) {
        return readLine(new File(str));
    }

    public static String readLineAndDel(File file) {
        try {
            String readLine = readLine(file);
            file.delete();
            return readLine;
        } catch (Exception e) {
            LogUtil.e("readLineAndDel", e);
            return null;
        }
    }

    public static List<String> readLines(File file, int i) {
        Throwable th;
        IOException e;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            int i2 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    i2++;
                    arrayList.add(readLine);
                    if (i > 0 && i2 >= i) {
                        break;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    try {
                        LogUtil.e("readLine", e);
                        closeQuietly(bufferedReader);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    closeQuietly(bufferedReader);
                    throw th;
                }
            }
            closeQuietly(bufferedReader2);
        } catch (IOException e3) {
            e = e3;
            LogUtil.e("readLine", e);
            closeQuietly(bufferedReader);
            return arrayList;
        }
        return arrayList;
    }

    public static boolean writeFile(File file, String str) {
        return writeFile(file, str, false);
    }

    public static String readLine(File file) {
        List<String> readLines = readLines(file, 1);
        return !readLines.isEmpty() ? readLines.get(0) : "";
    }

    public static boolean writeFile(File file, String str, boolean z) {
        Throwable th;
        IOException e;
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file, z);
            try {
                fileWriter2.write(str);
                fileWriter2.flush();
                closeQuietly(fileWriter2);
                return true;
            } catch (IOException e2) {
                e = e2;
                fileWriter = fileWriter2;
                try {
                    LogUtil.e("writeFile", e);
                    closeQuietly(fileWriter);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(fileWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = fileWriter2;
                closeQuietly(fileWriter);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            LogUtil.e("writeFile", e);
            closeQuietly(fileWriter);
            return false;
        }
    }

    public static void readLine(File file, ReaderListener readerListener) {
        Throwable th;
        IOException e;
        String readLine;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            do {
                try {
                    readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        closeQuietly(bufferedReader2);
                        return;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    try {
                        LogUtil.e("readLine", e);
                        closeQuietly(bufferedReader);
                    } catch (Throwable th2) {
                        th = th2;
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readerListener.onReadLine(readLine));
            closeQuietly(bufferedReader2);
        } catch (IOException e3) {
            e = e3;
            LogUtil.e("readLine", e);
            closeQuietly(bufferedReader);
        }
    }
}
