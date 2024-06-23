package android.taobao.windvane.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.TimeZones;

/* compiled from: Taobao */
public class CommonUtils {
    private static final String TAG = "CommonUtils";
    private static String currentProcessName = "";
    private static Boolean isMainProcess;

    public static Bitmap base64ToBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.replace(' ', '+'), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean canWriteFile(String str, String str2) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length());
            randomAccessFile.write(str.getBytes());
            randomAccessFile.close();
            if (!file.exists()) {
                return false;
            }
            file.delete();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            return false;
        }
    }

    public static int compareVer(String str, String str2) {
        if (str == null) {
            str = "0";
        }
        if (str2 == null) {
            str2 = "0";
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int i = length > length2 ? length : length2;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 >= length || i2 >= length2) {
                int i3 = length > length2 ? toInt(split[i2]) : toInt(split2[i2]) * -1;
                if (i3 != 0) {
                    return i3;
                }
            } else {
                int i4 = toInt(split[i2]);
                int i5 = toInt(split2[i2]);
                if (i4 != i5) {
                    return i4 - i5;
                }
            }
        }
        return 0;
    }

    public static String formatDate(long j) {
        return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH).format(new Date(j));
    }

    public static File getExternalCacheDir(Context context) {
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    if (!externalCacheDir.exists()) {
                        externalCacheDir.mkdirs();
                    }
                    return externalCacheDir;
                }
            } catch (Exception unused) {
            }
        }
        File file = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                /* class android.taobao.windvane.util.CommonUtils.AnonymousClass1CpuFilter */

                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            TaoLog.d("HomePageNetwork", "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            TaoLog.d("HomePageNetwork", "CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    public static String getProcessName(Context context) {
        try {
            String str = currentProcessName;
            if (str != null && str.length() > 0) {
                return currentProcessName;
            }
            if (context == null) {
                return null;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    currentProcessName = runningAppProcessInfo.processName;
                }
            }
            return currentProcessName;
        } catch (Exception e) {
            TaoLog.e("getProcessName error", e.toString());
        }
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        try {
            th.printStackTrace(new PrintWriter(stringWriter));
        } catch (Throwable unused) {
        }
        return stringWriter.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    public static int getTotalRAM() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        IOException e;
        String str = null;
        try {
            randomAccessFile = new RandomAccessFile("/proc/meminfo", UploadQueueMgr.MSGTYPE_REALTIME);
            try {
                str = randomAccessFile.readLine();
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    if (str == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            randomAccessFile = null;
            e.printStackTrace();
            if (randomAccessFile != null) {
            }
            if (str == null) {
            }
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
            if (randomAccessFile != null) {
            }
            throw th;
        }
        if (str == null) {
            return 1024;
        }
        try {
            return Integer.parseInt(str.replace("kB", "").replace("MemTotal:", "").trim()) / 1000;
        } catch (NumberFormatException e6) {
            e6.printStackTrace();
            return 1024;
        }
    }

    public static boolean hasSDCardMounted() {
        String externalStorageState = Environment.getExternalStorageState();
        return externalStorageState != null && externalStorageState.equals("mounted");
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || packageManager.getPackageInfo(str, 0) == null) {
                    return false;
                }
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isHtml(String str) {
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("text/html");
    }

    public static boolean isImage(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("image");
    }

    public static boolean isLowendPhone() {
        int numCores = getNumCores();
        int totalRAM = getTotalRAM();
        TaoLog.d("HomePageNetwork", "processorCore = " + numCores + " ram = " + totalRAM + " MB");
        return numCores == 1 && totalRAM < 800;
    }

    public static boolean isMainProcess(Context context) {
        if (isMainProcess == null) {
            isMainProcess = Boolean.valueOf(context != null && TextUtils.equals(getProcessName(context), context.getPackageName()));
        }
        return isMainProcess.booleanValue();
    }

    public static boolean isPicture(String str) {
        if (!(str == null || -1 == str.lastIndexOf("."))) {
            String substring = str.substring(str.lastIndexOf(".") + 1, str.length());
            String[] strArr = {"png", "jpeg", "jpg", "webp"};
            for (int i = 0; i < 4; i++) {
                if (strArr[i].equals(substring)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String parseCharset(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("charset")) == -1 || str.indexOf("=", indexOf) == -1) {
            return "";
        }
        String substring = str.substring(str.indexOf("=", indexOf) + 1);
        int indexOf2 = substring.indexOf(";");
        if (indexOf2 != -1) {
            substring = substring.substring(0, indexOf2).trim();
        }
        return substring.trim();
    }

    public static long parseDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
            return simpleDateFormat.parse(str.trim()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long parseMaxAge(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("max-age=") == -1) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(8);
        int i = 0;
        while (i < substring.length() && Character.isDigit(substring.charAt(i))) {
            sb.append(substring.charAt(i));
            i++;
        }
        try {
            return Long.parseLong(sb.toString()) * 1000;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String parseMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(";");
        if (indexOf == -1) {
            return str.trim();
        }
        return str.substring(0, indexOf).trim();
    }

    public static int toInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
