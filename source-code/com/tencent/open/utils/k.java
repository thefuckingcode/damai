package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.a.a.a;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.b;
import com.tencent.open.log.SLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.jl1;

/* compiled from: Taobao */
public class k {
    private static ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();

    public static String a(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        if (i != 10114) {
            return null;
        }
        return "action_common_channel";
    }

    public static void a() {
        a.clear();
    }

    public static String b(Context context, String str) {
        String str2 = "";
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(signatureArr[0].toByteArray());
            String a2 = m.a(instance.digest());
            instance.reset();
            SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + a2);
            instance.update(m.j(packageName + JSMethod.NOT_SET + a2 + JSMethod.NOT_SET + str + str2));
            str2 = m.a(instance.digest());
            instance.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            SLog.v("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    public static boolean c(Context context, Intent intent) {
        boolean z = false;
        if (!(context == null || intent == null)) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? component null");
                return false;
            }
            String packageName = component.getPackageName();
            String a2 = a(context, packageName);
            if (a2 != null && !a2.isEmpty()) {
                z = true;
            }
            SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? packageName = " + packageName + ", appVersionName= " + a2);
        }
        return z;
    }

    public static int d(Context context, String str) {
        return a(a(context, Constants.PACKAGE_TIM), str);
    }

    private static PackageInfo e(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        synchronized (k.class) {
            if (a.containsKey(str)) {
                a aVar = a.get(str);
                if (aVar == null) {
                    SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper is null");
                    return null;
                }
                PackageInfo packageInfo = aVar.b;
                if (packageInfo == null) {
                    SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper packageInfo is null");
                }
                return packageInfo;
            }
            PackageInfo f = f(context, str);
            a.put(str, new a(str, f));
            return f;
        }
    }

    private static PackageInfo f(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo null. packageName= " + str);
            }
            return packageInfo;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo exception", e);
            return null;
        }
    }

    private static boolean g(Context context, String str) {
        if (h.a(context, c(), str) == null && e(context, str) == null) {
            return false;
        }
        return true;
    }

    public static void a(String str) {
        if (str != null) {
            a.remove(str);
        }
    }

    public static String a(Context context, String str) {
        String a2 = h.a(context, c(), str);
        if (a2 != null && !"UNKNOWN".equals(a2)) {
            return a2;
        }
        PackageInfo e = e(context, str);
        if (e != null) {
            return e.versionName;
        }
        SLog.e("openSDK_LOG.SystemUtils", "getAppVersionName return null. package= " + str);
        return null;
    }

    public static boolean d(Context context) {
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !b()) {
            return true;
        }
        return false;
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        return split2.length > i ? -1 : 0;
    }

    public static boolean c(Context context) {
        if (g(context, "com.tencent.mobileqq")) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq");
            return true;
        } else if (g(context, Constants.PACKAGE_TIM)) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: tim");
            return true;
        } else if (g(context, Constants.PACKAGE_QQ_PAD)) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: pad");
            return true;
        } else {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: disable speed");
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (m.g(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private static String c() {
        String b = b.b();
        if (b == null || b.isEmpty()) {
            SLog.e("openSDK_LOG.SystemUtils", "getAppId error: " + b);
        }
        return b;
    }

    public static boolean b(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add("com.tencent.mobileqq");
        arrayList.add(Constants.PACKAGE_TIM);
        if (context != null && m.c(context)) {
            arrayList.add(Constants.PACKAGE_QQ_PAD);
        }
        return a(context, intent, arrayList);
    }

    public static String a(Activity activity, String str) {
        if (activity == null) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] a2 = e.a(str);
            if (a2 == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(a2, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(a2, 8, bArr2, 0, 16);
            return e.a(activity.getPackageName(), e.a(bArr2), bArr);
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
            return "";
        }
    }

    public static int b(String str) {
        if ("shareToQQ".equals(str)) {
            return Constants.REQUEST_QQ_SHARE;
        }
        if ("shareToQzone".equals(str)) {
            return Constants.REQUEST_QZONE_SHARE;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return Constants.REQUEST_LOGIN;
        }
        if ("action_request".equals(str)) {
            return Constants.REQUEST_API;
        }
        return -1;
    }

    public static boolean a(Context context, Intent intent) {
        boolean z = true;
        if (context == null || intent == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("isActivityExist params error! [");
            sb.append(context == null);
            sb.append(",");
            if (intent != null) {
                z = false;
            }
            sb.append(z);
            sb.append(jl1.ARRAY_END_STR);
            SLog.e("openSDK_LOG.SystemUtils", sb.toString());
            return false;
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            z = false;
        }
        if (!z) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isActivityExist false. result=");
            sb2.append(queryIntentActivities == null ? "null" : Integer.valueOf(queryIntentActivities.size()));
            sb2.append(" Intent= ");
            sb2.append(intent);
            SLog.e("openSDK_LOG.SystemUtils", sb2.toString());
        }
        return z;
    }

    public static boolean b(Context context) {
        boolean g = g(context, "com.tencent.mobileqq");
        SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled " + g);
        return g;
    }

    private static boolean b() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent, List<String> list) {
        Object obj;
        boolean z = true;
        if (context == null || intent == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("isTargetActivityExist params error! [");
            sb.append(context == null);
            sb.append(",");
            if (intent != null) {
                z = false;
            }
            sb.append(z);
            sb.append(jl1.ARRAY_END_STR);
            SLog.e("openSDK_LOG.SystemUtils", sb.toString());
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (!TextUtils.isEmpty(intent.getPackage())) {
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                z = false;
            }
            if (!z) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isTargetActivityExist false. result=");
                if (queryIntentActivities == null) {
                    obj = "null";
                } else {
                    obj = Integer.valueOf(queryIntentActivities.size());
                }
                sb2.append(obj);
                SLog.e("openSDK_LOG.SystemUtils", sb2.toString());
            }
            return z;
        } else if (list == null) {
            SLog.e("openSDK_LOG.SystemUtils", "isTargetActivityExist params error! targetPackageList is null");
            return false;
        } else {
            for (String str : list) {
                if (str != null) {
                    intent.setPackage(str);
                    List<ResolveInfo> queryIntentActivities2 = packageManager.queryIntentActivities(intent, 0);
                    intent.setPackage(null);
                    if (queryIntentActivities2 != null && queryIntentActivities2.size() > 0) {
                        return true;
                    }
                }
            }
            SLog.e("openSDK_LOG.SystemUtils", "isTargetActivityExist false");
            return false;
        }
    }

    public static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1 A[SYNTHETIC, Splitter:B:43:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b8 A[SYNTHETIC, Splitter:B:47:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bf A[SYNTHETIC, Splitter:B:53:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c6 A[SYNTHETIC, Splitter:B:57:0x00c6] */
    @SuppressLint({"SdCardPath"})
    public static boolean a(String str, String str2, int i) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + str);
        Context a2 = g.a();
        if (a2 == null) {
            SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
            return false;
        }
        SharedPreferences sharedPreferences = a2.getSharedPreferences("secure_lib", 0);
        File file = new File(a2.getFilesDir(), str2);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            int i2 = sharedPreferences.getInt("version", 0);
            SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
            if (i == i2) {
                return true;
            }
        }
        InputStream inputStream = null;
        r4 = null;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            InputStream open = a2.getAssets().open(str);
            try {
                fileOutputStream2 = a2.openFileOutput(str2, 0);
                a(open, fileOutputStream2);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("version", i);
                edit.commit();
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException unused) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                try {
                    SLog.e("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            SLog.e("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
        }
    }

    public static String a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
            SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
            return null;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e2);
            return null;
        }
    }
}
