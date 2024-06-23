package com.ali.user.mobile.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;

/* compiled from: Taobao */
public class FileUtil {
    public static void deleteFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public static String getEaDeviceId() {
        String str;
        if (DataProviderFactory.getDataProvider().getEnvType() == 3) {
            str = "ONLINE";
        } else {
            str = DataProviderFactory.getDataProvider().getEnvType() == 2 ? "PRE" : "TEST";
        }
        return DataProviderFactory.getApplicationContext().getSharedPreferences("onesdk_device", 0).getString(str + "_sdkDeviceId", null);
    }

    public static String getExtensionName(String str) {
        int lastIndexOf;
        return (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() + -1) ? str : str.substring(lastIndexOf + 1);
    }

    public static int getLaunchTimes() {
        SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences("aliuser_bootcount", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT);
        if (!sharedPreferences.getString("todaytime", "").equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())))) {
            edit.putString("todaytime", simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
        }
        int i = sharedPreferences.getInt("bootcountnum", 0);
        int i2 = 1;
        if (i >= 1) {
            i2 = 1 + i;
            edit.putInt("bootcountnum", i2);
        } else {
            edit.putInt("bootcountnum", 1);
        }
        edit.apply();
        return i2;
    }

    public static String getSdcardFile(String str) {
        String str2 = DataProviderFactory.getApplicationContext().getFilesDir().getPath() + "/device/";
        if (!new File(str2).exists()) {
            return "";
        }
        return readFileData(DataProviderFactory.getApplicationContext(), str2 + str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r5 != null) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037 A[SYNTHETIC, Splitter:B:22:0x0037] */
    public static String readFileData(Context context, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        String str2 = "";
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                int available = fileInputStream.available();
                if (available > 0) {
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr);
                    str2 = new String(bArr, "UTF-8");
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (Exception unused2) {
        }
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    public static void writeFileData(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Exception e;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                fileOutputStream.write(str2.getBytes(Charset.forName("UTF-8")));
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                    }
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            fileOutputStream = null;
            e = e3;
            e.printStackTrace();
            if (fileOutputStream == null) {
                return;
            }
            fileOutputStream.close();
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused) {
                }
            }
            throw th;
        }
        try {
            fileOutputStream.close();
        } catch (Exception unused2) {
        }
    }

    public static void writeSdcardFile(String str, String str2) {
        Context applicationContext = DataProviderFactory.getApplicationContext();
        String str3 = DataProviderFactory.getApplicationContext().getFilesDir().getPath() + "/device/";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        writeFileData(applicationContext, str3 + str, str2);
    }
}
