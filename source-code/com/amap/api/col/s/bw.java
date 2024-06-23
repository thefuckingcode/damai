package com.amap.api.col.s;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.entity.ConnType;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.amap.api.col.s.bv;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public final class bw {
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

    public static bv b() throws bj {
        return new bv.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();
    }

    public static String c(String str) {
        if (str.length() < 2) {
            return "";
        }
        return bp.a(str.substring(1));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    static PublicKey d() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bp.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
            try {
                CertificateFactory instance = CertificateFactory.getInstance(c("IWC41MDk"));
                KeyFactory instance2 = KeyFactory.getInstance(c("EUlNB"));
                Certificate generateCertificate = instance.generateCertificate(byteArrayInputStream);
                if (generateCertificate != null) {
                    if (instance2 != null) {
                        PublicKey generatePublic = instance2.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return generatePublic;
                    }
                }
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return null;
            } catch (Throwable unused) {
                if (byteArrayInputStream != null) {
                }
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            return null;
        }
    }

    private static String e(String str) {
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
            ci.a(th, "ut", "sPa");
        }
    }

    static String f(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            ci.a(th, "ut", "csb2h");
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
                hexString = "0".concat(hexString);
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
                ci.a(th, "ut", "gct");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    String[] strArr2 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
                    if (strArr2 != null && strArr2.length > 0) {
                        str = strArr2[0];
                    }
                    if (!TextUtils.isEmpty(str) && Arrays.asList(b).contains(str)) {
                        String str2 = context.getApplicationInfo().nativeLibraryDir;
                        if (!TextUtils.isEmpty(str2)) {
                            if (Arrays.asList(c).contains(str2.substring(str2.lastIndexOf(File.separator) + 1)) && (strArr = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null)) != null && strArr.length > 0) {
                                str = strArr[0];
                            }
                        }
                    }
                } catch (Throwable th2) {
                    ci.a(th2, "ut", "gct_p");
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
            String[] split2 = new StringBuffer(new String(bp.b(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            ci.a(th, "ut", "gIV");
            return new byte[16];
        }
    }

    private static void f(String str) {
        int i;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String substring = str.substring(0, 78);
            Log.i("authErrLog", "|" + substring + "|");
            str = str.substring(78);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        Log.i("authErrLog", sb.toString());
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String c2 = bp.c(a(str));
        try {
            return ((char) ((c2.length() % 26) + 65)) + c2;
        } catch (Throwable th) {
            ci.a(th, "ut", "tsfb64");
            return "";
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            ci.a(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String b(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return e(sb.toString());
    }

    static String e(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            ci.a(th, "ut", ConnType.H2S);
            return null;
        }
    }

    public static byte[] d(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] d(String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
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
                        ci.a(th2, "ut", "zp1");
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        ci.a(th3, "ut", "zp2");
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        ci.a(th, "ut", "zp");
                        if (zipOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        return bArr2;
                    } catch (Throwable th5) {
                        ci.a(th5, "ut", "zp2");
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                zipOutputStream = null;
                ci.a(th, "ut", "zp");
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th7) {
                        ci.a(th7, "ut", "zp1");
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
            ci.a(th, "ut", "zp");
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
            } catch (Throwable th) {
                ci.a(th, "ut", "cpm");
            }
        }
        return true;
    }

    public static bv a() throws bj {
        return new bv.a("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
            } catch (IOException e) {
                ci.a(e, "ut", "wsf");
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
            ci.a(e, "ut", "wFie");
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
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

    public static String a(Map<String, String> map) {
        if (map.size() == 0) {
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
            ci.a(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) (i / 256), (byte) (i % 256)};
    }

    public static String a(long j) {
        return a(j, "yyyyMMdd HH:mm:ss:SSS");
    }

    public static String a(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            ci.a(th, "ut", "ctt");
            return null;
        }
    }

    public static void a(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = "";
        String e = bk.e(context);
        String a2 = bs.a(e);
        String a3 = bk.a(context);
        try {
            if (jSONObject.has("info")) {
                str5 = jSONObject.getString("info");
                str4 = "请在高德开放平台官网中搜索\"" + str5 + "\"相关内容进行解决";
            } else {
                str5 = str6;
                str4 = str5;
            }
            try {
                if ("INVALID_USER_SCODE".equals(str5)) {
                    String string = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : str6;
                    if (jSONObject.has("sec_code_debug")) {
                        str6 = jSONObject.getString("sec_code_debug");
                    }
                    if (a2.equals(string) || a2.equals(str6)) {
                        str3 = c("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si") + "\"请求内容过长导致业务调用失败\"相关内容进行解决";
                        Log.i("authErrLog", a);
                        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                        Log.i("authErrLog", a);
                        f("SHA1Package:".concat(String.valueOf(e)));
                        f("key:".concat(String.valueOf(a3)));
                        f("csid:".concat(String.valueOf(str)));
                        f("gsid:".concat(String.valueOf(str2)));
                        f("json:" + jSONObject.toString());
                        Log.i("authErrLog", "                                                                               ");
                        Log.i("authErrLog", str3);
                        Log.i("authErrLog", a);
                    }
                } else if ("INVALID_USER_KEY".equals(str5)) {
                    if (jSONObject.has("key")) {
                        str6 = jSONObject.getString("key");
                    }
                    if (str6.length() > 0 && !a3.equals(str6)) {
                        str4 = c("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
                    }
                }
                str3 = str4;
            } catch (Throwable unused) {
                str6 = str4;
                str3 = str6;
                Log.i("authErrLog", a);
                Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                Log.i("authErrLog", a);
                f("SHA1Package:".concat(String.valueOf(e)));
                f("key:".concat(String.valueOf(a3)));
                f("csid:".concat(String.valueOf(str)));
                f("gsid:".concat(String.valueOf(str2)));
                f("json:" + jSONObject.toString());
                Log.i("authErrLog", "                                                                               ");
                Log.i("authErrLog", str3);
                Log.i("authErrLog", a);
            }
        } catch (Throwable unused2) {
            str3 = str6;
            Log.i("authErrLog", a);
            Log.i("authErrLog", "                                   鉴权错误信息                                  ");
            Log.i("authErrLog", a);
            f("SHA1Package:".concat(String.valueOf(e)));
            f("key:".concat(String.valueOf(a3)));
            f("csid:".concat(String.valueOf(str)));
            f("gsid:".concat(String.valueOf(str2)));
            f("json:" + jSONObject.toString());
            Log.i("authErrLog", "                                                                               ");
            Log.i("authErrLog", str3);
            Log.i("authErrLog", a);
        }
        Log.i("authErrLog", a);
        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
        Log.i("authErrLog", a);
        f("SHA1Package:".concat(String.valueOf(e)));
        f("key:".concat(String.valueOf(a3)));
        f("csid:".concat(String.valueOf(str)));
        f("gsid:".concat(String.valueOf(str2)));
        f("json:" + jSONObject.toString());
        Log.i("authErrLog", "                                                                               ");
        Log.i("authErrLog", str3);
        Log.i("authErrLog", a);
    }

    public static Calendar a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.CHINA);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(simpleDateFormat.parse(str));
            instance.set(instance.get(1), instance.get(2), instance.get(5), instance2.get(11), instance2.get(12), instance2.get(13));
            return instance;
        } catch (ParseException e) {
            ci.a(e, "ut", "ctt");
            return null;
        }
    }
}
