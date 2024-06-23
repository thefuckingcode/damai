package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.entity.ConnType;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.amap.api.mapcore.util.gm;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class gn {
    static String a;
    private static final String[] b = {"arm64-v8a", "x86_64"};
    private static final String[] c = {"arm", DeviceUtils.ABI_X86};

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        a = sb.toString();
    }

    public static Method a(Class cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(c(str), clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static gm b() throws gb {
        return new gm.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();
    }

    public static String c(String str) {
        if (str.length() < 2) {
            return "";
        }
        return gh.a(str.substring(1));
    }

    public static String d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            ha.a(th, "ut", "sPa");
        }
    }

    static String e(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            ha.a(th, "ut", ConnType.H2S);
            return null;
        }
    }

    static String f(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String g(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = YKUpsConvert.CHAR_ZERO + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static byte[] h(byte[] bArr) throws IOException, Throwable {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream2.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = gZIPOutputStream2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    public static String a(Context context) {
        String str;
        String[] strArr;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21 && i < 28) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                Field declaredField = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                str = (String) declaredField.get(applicationInfo);
            } catch (Throwable th) {
                ha.a(th, "ut", "gct");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    String[] strArr2 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
                    if (strArr2 != null && strArr2.length >= 1) {
                        str = strArr2[0];
                    }
                    if (!TextUtils.isEmpty(str) && Arrays.asList(b).contains(str)) {
                        String str2 = context.getApplicationInfo().nativeLibraryDir;
                        if (!TextUtils.isEmpty(str2)) {
                            if (Arrays.asList(c).contains(str2.substring(str2.lastIndexOf(File.separator) + 1)) && (strArr = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null)) != null && strArr.length >= 1) {
                                str = strArr[0];
                            }
                        }
                    }
                } catch (Throwable th2) {
                    ha.a(th2, "ut", "gct_p");
                }
            }
            return !TextUtils.isEmpty(str) ? com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI() : str;
        }
        str = "";
        if (Build.VERSION.SDK_INT >= 28) {
        }
        if (!TextUtils.isEmpty(str)) {
        }
    }

    public static byte[] c() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(gh.b(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            ha.a(th, "ut", "gIV");
            return new byte[16];
        }
    }

    public static byte[] e(String str) {
        if (str.length() % 2 != 0) {
            str = "0" + str;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String a2 = gh.a(str);
            return a2.contains(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL() + Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String c2 = gh.c(a(str));
        try {
            return ((char) ((c2.length() % 26) + 65)) + c2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                }
            }
        } catch (Throwable th) {
            ha.a(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    static void g(String str) {
        if (str.length() < 78) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            sb.append(str);
            for (int i = 0; i < 78 - str.length(); i++) {
                sb.append(" ");
            }
            sb.append("|");
            h(sb.toString());
            return;
        }
        String substring = str.substring(0, 78);
        h("|" + substring + "|");
        g(str.substring(78));
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d A[SYNTHETIC, Splitter:B:26:0x004d] */
    static PublicKey d() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        try {
            byteArrayInputStream = new ByteArrayInputStream(gh.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                KeyFactory instance2 = KeyFactory.getInstance("RSA");
                Certificate generateCertificate = instance.generateCertificate(byteArrayInputStream);
                if (generateCertificate != null) {
                    if (instance2 != null) {
                        PublicKey generatePublic = instance2.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        return generatePublic;
                    }
                }
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                try {
                    th.printStackTrace();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayInputStream = null;
            th.printStackTrace();
            if (byteArrayInputStream != null) {
            }
            return null;
        }
        throw th;
    }

    private static void h(String str) {
        Log.i("authErrLog", str);
    }

    public static byte[] b(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            ha.a(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String c(Map<String, String> map) {
        return d(a(map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058  */
    public static byte[] c(byte[] bArr) {
        Throwable th;
        ZipOutputStream zipOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(DumpManager.LOG_PATH));
                    zipOutputStream.write(bArr);
                    zipOutputStream.closeEntry();
                    zipOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th2) {
                        ha.a(th2, "ut", "zp1");
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        ha.a(th3, "ut", "zp2");
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        ha.a(th, "ut", "zp");
                        if (zipOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        return bArr2;
                    } catch (Throwable th5) {
                        ha.a(th5, "ut", "zp2");
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                zipOutputStream = null;
                ha.a(th, "ut", "zp");
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th7) {
                        ha.a(th7, "ut", "zp1");
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr2;
            }
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = null;
            zipOutputStream = null;
            ha.a(th, "ut", "zp");
            if (zipOutputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            return bArr2;
        }
        return bArr2;
        throw th;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.close();
        }
        throw th;
    }

    public static boolean a(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static byte[] d(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static gm a() throws gb {
        return new gm.a("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            int length = str.length();
            if (length > 255) {
                length = 255;
            }
            a(byteArrayOutputStream, (byte) length, a(str));
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, byte b2, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b2});
            int i = b2 & 255;
            if (i < 255 && i > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            ha.a(e, "ut", "wFie");
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003e A[SYNTHETIC, Splitter:B:27:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0048 A[SYNTHETIC, Splitter:B:32:0x0048] */
    public static String a(Throwable th) {
        Throwable th2;
        PrintWriter printWriter;
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                        cause.printStackTrace(printWriter);
                    }
                    String obj = stringWriter.toString();
                    try {
                        stringWriter.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    try {
                        printWriter.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    return obj;
                } catch (Throwable th5) {
                    th2 = th5;
                    try {
                        th2.printStackTrace();
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        }
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
            } catch (Throwable th9) {
                th2 = th9;
                printWriter = null;
                th2.printStackTrace();
                if (stringWriter != null) {
                }
                if (printWriter != null) {
                }
                return null;
            }
        } catch (Throwable th10) {
            th2 = th10;
            stringWriter = null;
            printWriter = null;
            th2.printStackTrace();
            if (stringWriter != null) {
            }
            if (printWriter != null) {
            }
            return null;
        }
        throw th;
        if (printWriter != null) {
            printWriter.close();
        }
        throw th;
    }

    public static byte[] a(int i, int i2) {
        if (i2 > 4) {
            return new byte[0];
        }
        if (i2 != 2) {
            return new byte[i2];
        }
        return new byte[]{(byte) (i / 256), (byte) (i % 256)};
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5 = "";
        String e = gc.e(context);
        String b2 = gk.b(e);
        String a2 = gc.a(context);
        try {
            if (jSONObject.has("info")) {
                str4 = jSONObject.getString("info");
                str3 = "请在高德开放平台官网中搜索\"" + str4 + "\"相关内容进行解决";
            } else {
                str4 = str5;
                str3 = str4;
            }
            try {
                if ("INVALID_USER_SCODE".equals(str4)) {
                    String string = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : str5;
                    if (jSONObject.has("sec_code_debug")) {
                        str5 = jSONObject.getString("sec_code_debug");
                    }
                    if (b2.equals(string) || b2.equals(str5)) {
                        str3 = "请在高德开放平台官网中搜索\"请求内容过长导致业务调用失败\"相关内容进行解决";
                    }
                } else if ("INVALID_USER_KEY".equals(str4)) {
                    if (jSONObject.has("key")) {
                        str5 = jSONObject.getString("key");
                    }
                    if (str5.length() > 0 && !a2.equals(str5)) {
                        str3 = "请在高德开放平台官网上发起技术咨询工单—>账号与Key问题，咨询INVALID_USER_KEY如何解决";
                    }
                }
            } catch (Throwable unused) {
                str5 = str3;
                str3 = str5;
                h(a);
                h("                                   鉴权错误信息                                  ");
                h(a);
                g("SHA1Package:" + e);
                g("key:" + a2);
                g("csid:" + str);
                g("gsid:" + str2);
                g("json:" + jSONObject.toString());
                h("                                                                               ");
                h(str3);
                h(a);
            }
        } catch (Throwable unused2) {
            str3 = str5;
            h(a);
            h("                                   鉴权错误信息                                  ");
            h(a);
            g("SHA1Package:" + e);
            g("key:" + a2);
            g("csid:" + str);
            g("gsid:" + str2);
            g("json:" + jSONObject.toString());
            h("                                                                               ");
            h(str3);
            h(a);
        }
        h(a);
        h("                                   鉴权错误信息                                  ");
        h(a);
        g("SHA1Package:" + e);
        g("key:" + a2);
        g("csid:" + str);
        g("gsid:" + str2);
        g("json:" + jSONObject.toString());
        h("                                                                               ");
        h(str3);
        h(a);
    }
}
