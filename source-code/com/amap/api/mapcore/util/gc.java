package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: Taobao */
public class gc {
    static String a = null;
    static boolean b = false;
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    hd.b(gn.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String b(Context context) {
        try {
            if (!"".equals(c)) {
                return c;
            }
            PackageManager packageManager = context.getPackageManager();
            c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return c;
        } catch (Throwable th) {
            ha.a(th, "AI", "gAN");
        }
    }

    public static String c(Context context) {
        try {
            String str = d;
            if (str != null && !"".equals(str)) {
                return d;
            }
            String packageName = context.getPackageName();
            d = packageName;
            if (!a(packageName)) {
                d = context.getPackageName();
            }
            return d;
        } catch (Throwable th) {
            ha.a(th, "AI", "gpck");
        }
    }

    public static String d(Context context) {
        try {
            if (!"".equals(e)) {
                return e;
            }
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = e;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable th) {
            ha.a(th, "AI", "gAV");
        }
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (a(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(d)) {
                str = c(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            ha.a(th, "AI", "gsp");
            return a;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    public static String f(Context context) {
        gd.a(context);
        try {
            return h(context);
        } catch (Throwable th) {
            ha.a(th, "AI", "gKy");
            return f;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056 A[SYNTHETIC, Splitter:B:29:0x0056] */
    private static String g(Context context) {
        Throwable th;
        FileInputStream fileInputStream;
        File file = new File(hb.c(context, "k.store"));
        String str = "";
        if (!file.exists()) {
            return str;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String a2 = gn.a(bArr);
                if (a2.length() == 32) {
                    str = a2;
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                try {
                    ha.a(th, "AI", "gKe");
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        } catch (Throwable th7) {
            fileInputStream = null;
            th = th7;
            ha.a(th, "AI", "gKe");
            if (file.exists()) {
            }
            if (fileInputStream != null) {
            }
            return str;
        }
        throw th;
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return f;
            }
            String string = bundle.getString("com.amap.api.v2.apikey");
            f = string;
            if (string == null) {
                f = g(context);
            }
        }
        return f;
    }

    static boolean a() {
        try {
            if (b) {
                return true;
            }
            if (a(a)) {
                b = true;
                return true;
            } else if (!TextUtils.isEmpty(a)) {
                b = false;
                a = null;
                return false;
            } else if (a(d)) {
                b = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(d)) {
                    b = false;
                    d = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(final Context context, final String str) {
        hd.d().submit(new Runnable() {
            /* class com.amap.api.mapcore.util.gc.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
            /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
            public void run() {
                Throwable th;
                FileOutputStream fileOutputStream = null;
                try {
                    File file = new File(hb.c(context, "k.store"));
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(gn.a(str));
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        try {
                            ha.a(th, "AI", "stf");
                            if (fileOutputStream == null) {
                                fileOutputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    ha.a(th, "AI", "stf");
                    if (fileOutputStream == null) {
                    }
                }
                throw th;
            }
        });
    }

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f = str;
            if (context != null) {
                b(context, str);
            }
        }
    }
}
