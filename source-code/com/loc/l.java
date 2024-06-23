package com.loc;

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
import tb.v13;

/* compiled from: Taobao */
public final class l {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    static String e;
    static boolean f;

    public static String a(Context context) {
        try {
            return l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return d;
        }
    }

    static void b(final Context context, final String str) {
        if (!TextUtils.isEmpty(str)) {
            d = str;
            if (context != null) {
                o0.f().d(new ck() {
                    /* class com.loc.l.AnonymousClass1 */

                    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[SYNTHETIC, Splitter:B:21:0x0045] */
                    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                    @Override // com.loc.ck
                    public final void a() {
                        Throwable th;
                        FileOutputStream fileOutputStream = null;
                        try {
                            File file = new File(al.i(context, "k.store"));
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                fileOutputStream2.write(v1.p(str));
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
                                    v13.e(th, "AI", "stf");
                                    if (fileOutputStream == null) {
                                        try {
                                            fileOutputStream.close();
                                            return;
                                        } catch (Throwable th4) {
                                            th4.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            v13.e(th, "AI", "stf");
                            if (fileOutputStream == null) {
                            }
                        }
                        throw th;
                    }
                });
            }
        }
    }

    public static void c(String str) {
        b = str;
    }

    static boolean d() {
        try {
            if (f) {
                return true;
            }
            if (f(e)) {
                f = true;
                return true;
            } else if (!TextUtils.isEmpty(e)) {
                f = false;
                e = null;
                return false;
            } else if (f(b)) {
                f = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(b)) {
                    f = false;
                    b = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
        }
    }

    public static String e(Context context) {
        try {
            if (!"".equals(a)) {
                return a;
            }
            PackageManager packageManager = context.getPackageManager();
            a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return a;
        } catch (Throwable th) {
            v13.e(th, "AI", "gAN");
        }
    }

    private static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    an.l(v1.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String g(Context context) {
        try {
            String str = b;
            if (str != null && !"".equals(str)) {
                return b;
            }
            String packageName = context.getPackageName();
            b = packageName;
            if (!f(packageName)) {
                b = context.getPackageName();
            }
            return b;
        } catch (Throwable th) {
            v13.e(th, "AI", "gpck");
        }
    }

    public static String h(Context context) {
        try {
            if (!"".equals(c)) {
                return c;
            }
            c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = c;
            return str == null ? "" : str;
        } catch (Throwable th) {
            v13.e(th, "AI", "gAV");
        }
    }

    public static String i(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(v1.v("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
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
            if (f(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(b)) {
                str = g(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            v13.e(th, "AI", "gsp");
            return e;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    public static String j(Context context) {
        m.c(context);
        try {
            return l(context);
        } catch (Throwable th) {
            v13.e(th, "AI", "gKy");
            return d;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056 A[SYNTHETIC, Splitter:B:29:0x0056] */
    private static String k(Context context) {
        Throwable th;
        FileInputStream fileInputStream;
        File file = new File(al.i(context, "k.store"));
        String str = "";
        if (!file.exists()) {
            return str;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String g = v1.g(bArr);
                if (g.length() == 32) {
                    str = g;
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
                    v13.e(th, "AI", "gKe");
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
            v13.e(th, "AI", "gKe");
            if (file.exists()) {
            }
            if (fileInputStream != null) {
            }
            return str;
        }
        throw th;
    }

    private static String l(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return d;
            }
            String string = bundle.getString("com.amap.api.v2.apikey");
            d = string;
            if (string == null) {
                d = k(context);
            }
        }
        return d;
    }
}
