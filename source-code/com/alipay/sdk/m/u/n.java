package com.alipay.sdk.m.u;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.m.h.d;
import com.alipay.sdk.m.h.f;
import com.alipay.sdk.m.m.a;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mtopsdk.common.util.SymbolExpUtil;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import tb.gl1;
import tb.jl1;
import tb.ke1;
import tb.u91;
import tb.v;
import tb.v00;

/* compiled from: Taobao */
public class n {
    public static final String a = "com.alipay.android.app";
    public static final String b = "com.eg.android.AlipayGphone";
    public static final String c = "com.eg.android.AlipayGphoneRC";
    public static final int d = 99;
    public static final String[] e = {"10.1.5.1013151", "10.1.5.1013148"};
    public static final int f = 125;
    public static final int g = 460;
    public static final char[] h = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F, 'G', 'H', u91.LEVEL_I, 'J', 'K', u91.LEVEL_L, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', u91.LEVEL_V, u91.LEVEL_W, 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', v00.DIR};

    /* compiled from: Taobao */
    public static class a implements Runnable {
        public final /* synthetic */ Activity a;

        public a(Activity activity) {
            this.a = activity;
        }

        public void run() {
            this.a.finish();
        }
    }

    /* compiled from: Taobao */
    public static class b implements Runnable {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ ConditionVariable b;

        public b(Runnable runnable, ConditionVariable conditionVariable) {
            this.a = runnable;
            this.b = conditionVariable;
        }

        public void run() {
            try {
                this.a.run();
            } finally {
                this.b.open();
            }
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int i = 0;
            if (!TextUtils.isEmpty(str2)) {
                i = str3.indexOf(str2, indexOf);
            }
            if (i < 1) {
                return str3.substring(indexOf);
            }
            return str3.substring(indexOf, i);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        if (EnvUtils.isSandBox()) {
            return c;
        }
        try {
            return com.alipay.sdk.m.j.a.d.get(0).a;
        } catch (Throwable unused) {
            return "com.eg.android.AlipayGphone";
        }
    }

    public static String b(Context context) {
        return "-1;-1";
    }

    public static String c(String str) {
        return (!EnvUtils.isSandBox() || !TextUtils.equals(str, c)) ? "com.eg.android.AlipayGphone.IAlixPay" : "com.eg.android.AlipayGphoneRC.IAlixPay";
    }

    public static int d(String str) {
        for (int i = 0; i < 64; i++) {
            if (str.equals(String.valueOf(h[i]))) {
                return i;
            }
        }
        return 0;
    }

    public static String e(com.alipay.sdk.m.s.a aVar, String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, e2);
            return "";
        }
    }

    public static String f() {
        return "Android " + Build.VERSION.getRELEASE();
    }

    public static String g(Context context) {
        String f2 = f();
        String e2 = e();
        String c2 = c(context);
        String f3 = f(context);
        return " (" + f2 + ";" + e2 + ";" + c2 + ";" + ";" + f3 + jl1.BRACKET_END_STR + "(sdk android)";
    }

    public static JSONObject h(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static String i(String str) {
        try {
            Uri parse = Uri.parse(str);
            return String.format("%s%s", parse.getAuthority(), parse.getPath());
        } catch (Throwable th) {
            e.a(th);
            return "-";
        }
    }

    public static String c(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String f(Context context) {
        DisplayMetrics d2 = d(context);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(d2) + jl1.MUL + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(d2);
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split("&");
        for (String str2 : split) {
            int indexOf = str2.indexOf("=", 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    /* JADX INFO: finally extract failed */
    public static String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + StringUtils.LF + matcher.group(2) + " " + matcher.group(3) + StringUtils.LF + matcher.group(4);
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String e() {
        String d2 = d();
        int indexOf = d2.indexOf("-");
        if (indexOf != -1) {
            d2 = d2.substring(0, indexOf);
        }
        int indexOf2 = d2.indexOf(StringUtils.LF);
        if (indexOf2 != -1) {
            d2 = d2.substring(0, indexOf2);
        }
        return "Linux " + d2;
    }

    public static boolean h(Context context) {
        try {
            if (context.getPackageManager().getPackageInfo(a, 128) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean h() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* compiled from: Taobao */
    public static final class c {
        public final PackageInfo a;
        public final int b;
        public final String c;

        public c(PackageInfo packageInfo, int i, String str) {
            this.a = packageInfo;
            this.b = i;
            this.c = str;
        }

        public boolean a(com.alipay.sdk.m.s.a aVar) {
            Signature[] signatureArr = this.a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String a2 = n.a(aVar, signature.toByteArray());
                if (a2 != null && !TextUtils.equals(a2, this.c)) {
                    com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.D, String.format("Got %s, expected %s", a2, this.c));
                    return true;
                }
            }
            return false;
        }

        public boolean a() {
            return this.a.versionCode < this.b;
        }
    }

    public static String c(com.alipay.sdk.m.s.a aVar, String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "rflex", e2.getClass().getSimpleName());
            return null;
        }
    }

    public static boolean i() {
        try {
            String[] split = com.alipay.sdk.m.m.a.D().g().split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            String model = Build.getMODEL();
            if (TextUtils.isEmpty(model)) {
                return false;
            }
            for (String str : split) {
                if (TextUtils.equals(model, str) || TextUtils.equals(str, "all")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            e.a(th);
            return false;
        }
    }

    public static String a(com.alipay.sdk.m.s.a aVar, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            com.alipay.sdk.m.k.a.a(aVar, "auth", com.alipay.sdk.m.k.b.x, e2);
            return null;
        }
    }

    public static boolean f(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static String e(Context context) {
        String b2 = m.b(context);
        return b2.substring(0, b2.indexOf(ke1.SCHEME_SLASH));
    }

    public static String g(String str) {
        return a(str, true);
    }

    public static Map<String, String> b(com.alipay.sdk.m.s.a aVar, String str) {
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            String[] split = str.substring(indexOf + 1).split("&");
            for (String str2 : split) {
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), e(aVar, str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }

    public static int c() {
        try {
            String lowerCase = Build.getBRAND().toLowerCase();
            String lowerCase2 = Build.getMANUFACTURER().toLowerCase();
            if (a("huawei", lowerCase, lowerCase2)) {
                return 1;
            }
            if (a("oppo", lowerCase, lowerCase2)) {
                return 2;
            }
            if (a("vivo", lowerCase, lowerCase2)) {
                return 4;
            }
            if (a("lenovo", lowerCase, lowerCase2)) {
                return 8;
            }
            if (a("xiaomi", lowerCase, lowerCase2)) {
                return 16;
            }
            return a("oneplus", new Object[]{lowerCase, lowerCase2}) ? 32 : 0;
        } catch (Exception unused) {
            return 61440;
        }
    }

    public static int g() {
        try {
            return Process.myUid();
        } catch (Throwable th) {
            e.a(th);
            return -200;
        }
    }

    public static int e(String str) {
        try {
            String j = com.alipay.sdk.m.m.a.D().j();
            int i = 0;
            if (TextUtils.isEmpty(j)) {
                return 0;
            }
            if (b(j, "").contains(str)) {
                i = 2;
            }
            return i | 1;
        } catch (Throwable unused) {
            return 61440;
        }
    }

    public static DisplayMetrics d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getApplicationContext().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return displayMetrics;
    }

    public static c a(com.alipay.sdk.m.s.a aVar, Context context, List<a.b> list) {
        c a2;
        if (list == null) {
            return null;
        }
        for (a.b bVar : list) {
            if (bVar != null && (a2 = a(aVar, context, bVar.a, bVar.b, bVar.c)) != null && !a2.a(aVar) && !a2.a()) {
                return a2;
            }
        }
        return null;
    }

    public static boolean d(com.alipay.sdk.m.s.a aVar, String str) {
        try {
            int e2 = e(str);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "bindExt", "" + e2);
            if (!com.alipay.sdk.m.m.a.D().o() || (e2 & 2) != 2) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static c a(com.alipay.sdk.m.s.a aVar, Context context, String str, int i, String str2) {
        PackageInfo packageInfo;
        if (EnvUtils.isSandBox() && "com.eg.android.AlipayGphone".equals(str)) {
            str = c;
        }
        try {
            packageInfo = a(context, str);
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.b(aVar, "auth", com.alipay.sdk.m.k.b.v, th.getMessage());
            packageInfo = null;
        }
        if (!a(aVar, packageInfo)) {
            return null;
        }
        return a(packageInfo, i, str2);
    }

    public static String b(com.alipay.sdk.m.s.a aVar, Context context) {
        return a(aVar, context, context.getPackageName());
    }

    public static int b(int i) {
        return i / 100000;
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = str + "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = str + "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = str + "info.signatures.length <= 0";
            } else {
                z = true;
            }
        }
        if (!z) {
            com.alipay.sdk.m.k.a.b(aVar, "auth", com.alipay.sdk.m.k.b.w, str);
        }
        return z;
    }

    public static String b(String str, String str2) {
        String string = Settings.Secure.getString(((Application) com.alipay.sdk.m.s.b.d().b()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    public static boolean b(com.alipay.sdk.m.s.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.g)) {
            return false;
        }
        return aVar.g.toLowerCase().contains("auth");
    }

    public static PackageInfo a(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static c a(PackageInfo packageInfo, int i, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new c(packageInfo, i, str);
    }

    public static long a(String str) {
        return a(str, 6);
    }

    public static long a(String str, int i) {
        int pow = (int) Math.pow(2.0d, (double) i);
        int length = str.length();
        long j = 0;
        int i2 = 0;
        int i3 = length;
        while (i2 < length) {
            int i4 = i2 + 1;
            j += ((long) Integer.parseInt(String.valueOf(d(str.substring(i2, i4))))) * ((long) Math.pow((double) pow, (double) (i3 - 1)));
            i3--;
            i2 = i4;
        }
        return j;
    }

    public static int a() {
        String c2 = com.alipay.sdk.m.s.b.d().c();
        if (TextUtils.isEmpty(c2)) {
            return -1;
        }
        String replaceAll = c2.replaceAll("=", "");
        if (replaceAll.length() >= 5) {
            replaceAll = replaceAll.substring(0, 5);
        }
        int a2 = (int) (a(replaceAll) % 10000);
        return a2 < 0 ? a2 * -1 : a2;
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, Context context, List<a.b> list, boolean z) {
        try {
            for (a.b bVar : list) {
                if (bVar != null) {
                    String str = bVar.a;
                    if (EnvUtils.isSandBox() && "com.eg.android.AlipayGphone".equals(str)) {
                        str = c;
                    }
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            if (!z) {
                                return true;
                            }
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, packageInfo.packageName + "|" + packageInfo.versionName);
                            return true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.h0, th);
            return false;
        }
    }

    public static boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = e;
            if (TextUtils.equals(str, strArr[0]) || TextUtils.equals(str, strArr[1])) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 65.0d))));
            } else if (nextInt == 1) {
                sb.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 97.0d))));
            } else if (nextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, String str, Activity activity) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.m.toLowerCase()) || str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.n.toLowerCase())) {
            try {
                c a2 = a(aVar, activity, com.alipay.sdk.m.j.a.d);
                if (a2 != null && !a2.a()) {
                    if (!a2.a(aVar)) {
                        if (str.startsWith("intent://platformapi/startapp")) {
                            str = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.m.l.a.m);
                        }
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                }
            } catch (Throwable unused) {
            }
            return true;
        } else if (TextUtils.equals(str, com.alipay.sdk.m.l.a.p) || TextUtils.equals(str, a("http", com.alipay.sdk.m.l.a.r))) {
            com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
            activity.finish();
            return true;
        } else if (!str.startsWith(com.alipay.sdk.m.l.a.o)) {
            return false;
        } else {
            try {
                String substring = str.substring(str.indexOf(com.alipay.sdk.m.l.a.o) + 24);
                int parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf(com.alipay.sdk.m.l.a.s) + 10));
                if (parseInt != com.alipay.sdk.m.j.c.SUCCEEDED.b()) {
                    if (parseInt != com.alipay.sdk.m.j.c.PAY_WAITTING.b()) {
                        com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
                        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(b2.b(), b2.a(), ""));
                        activity.runOnUiThread(new a(activity));
                        return true;
                    }
                }
                if (com.alipay.sdk.m.l.a.w) {
                    StringBuilder sb = new StringBuilder();
                    String decode = URLDecoder.decode(str);
                    String decode2 = URLDecoder.decode(decode);
                    String str3 = decode2.substring(decode2.indexOf(com.alipay.sdk.m.l.a.o) + 24, decode2.lastIndexOf(com.alipay.sdk.m.l.a.s)).split(com.alipay.sdk.m.l.a.u)[0];
                    int indexOf = decode.indexOf(com.alipay.sdk.m.l.a.u) + 12;
                    sb.append(str3);
                    sb.append(com.alipay.sdk.m.l.a.u);
                    sb.append(decode.substring(indexOf, decode.indexOf("&", indexOf)));
                    sb.append(decode.substring(decode.indexOf("&", indexOf)));
                    str2 = sb.toString();
                } else {
                    String decode3 = URLDecoder.decode(str);
                    str2 = decode3.substring(decode3.indexOf(com.alipay.sdk.m.l.a.o) + 24, decode3.lastIndexOf(com.alipay.sdk.m.l.a.s));
                }
                com.alipay.sdk.m.j.c b3 = com.alipay.sdk.m.j.c.b(parseInt);
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(b3.b(), b3.a(), str2));
            } catch (Exception unused2) {
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.e());
            }
            activity.runOnUiThread(new a(activity));
            return true;
        }
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.v, th);
            return "";
        }
    }

    public static String a(String str, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            if (!z || digest.length <= 16) {
                return a(digest);
            }
            byte[] bArr = new byte[16];
            System.arraycopy(digest, 0, bArr, 0, 16);
            return a(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(Character.forDigit((b2 & 240) >> 4, 16));
            sb.append(Character.forDigit(b2 & 15, 16));
        }
        return sb.toString();
    }

    public static ActivityInfo a(Context context) {
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            e.a(th);
            return null;
        }
    }

    public static String a(com.alipay.sdk.m.s.a aVar) {
        return c(aVar, "ro.build.fingerprint");
    }

    public static <T> T a(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, String str) {
        try {
            String host = new URL(str).getHost();
            if (host.endsWith(com.alipay.sdk.m.l.a.A) || host.endsWith(com.alipay.sdk.m.l.a.B)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ckUrlErr", th);
            return false;
        }
    }

    public static JSONObject a(Intent intent) {
        Bundle extras;
        JSONObject jSONObject = new JSONObject();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, String.valueOf(extras.get(str)));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, jSONObject.optString(next));
            } catch (Throwable th) {
                e.a(th);
            }
        }
        return hashMap;
    }

    public static boolean a(Object obj, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            for (Object obj2 : objArr) {
                if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                    return true;
                }
            }
            return false;
        } else if (obj == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean a(long j, Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        ConditionVariable conditionVariable = new ConditionVariable();
        Thread thread = new Thread(new b(runnable, conditionVariable));
        if (!TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        if (j > 0) {
            return conditionVariable.block(j);
        }
        try {
            conditionVariable.block();
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context) {
        try {
            String a2 = j.a(aVar, context, "alipay_cashier_ap_fi", "");
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
            try {
                j.b(aVar, context, "alipay_cashier_ap_fi", com.alipay.sdk.m.h.a.a("FU", System.currentTimeMillis(), new d(), 0, new f()).a());
                String a3 = j.a(aVar, context, "alipay_cashier_ap_fi", "");
                if (!TextUtils.isEmpty(a3)) {
                    return a3;
                }
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "e_regen_empty", "");
                return "";
            } catch (Exception e2) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "e_gen", e2.getClass().getSimpleName());
                return "";
            }
        } catch (Exception e3) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "e_gen_err", e3);
            return "";
        }
    }

    public static void a(String str, String str2, Context context, com.alipay.sdk.m.s.a aVar) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !b(aVar) && com.alipay.sdk.m.m.a.D().v()) {
            try {
                Intent intent = new Intent(com.alipay.sdk.m.l.b.l);
                intent.putExtra("bizType", str);
                intent.putExtra("exName", str2);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent);
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "AppNotify", str + "|" + str2);
            } catch (Exception unused) {
            }
        }
    }
}
