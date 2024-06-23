package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.entity.ConnType;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.loc.u1;
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
import tb.v13;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public final class v1 {
    private static final String[] a = {"arm64-v8a", "x86_64"};
    private static final String[] b = {"arm", DeviceUtils.ABI_X86};
    static String c;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        c = sb.toString();
    }

    public static byte[] A(byte[] bArr) {
        try {
            return G(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static String B(String str) {
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
            v13.e(th, "ut", "sPa");
        }
    }

    static String C(byte[] bArr) {
        try {
            return F(bArr);
        } catch (Throwable th) {
            v13.e(th, "ut", ConnType.H2S);
            return null;
        }
    }

    static String D(byte[] bArr) {
        try {
            return F(bArr);
        } catch (Throwable th) {
            v13.e(th, "ut", "csb2h");
            return null;
        }
    }

    private static void E(String str) {
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

    public static String F(byte[] bArr) {
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

    private static byte[] G(byte[] bArr) throws IOException, Throwable {
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

    public static u1 a() throws k {
        return new u1.a("collection", "1.0", "AMap_collection_1.0").b(new String[]{"com.amap.api.collection"}).c();
    }

    public static String b(long j) {
        return c(j, "yyyyMMdd HH:mm:ss:SSS");
    }

    public static String c(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            v13.e(th, "ut", "ctt");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    public static String d(Context context) {
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
                v13.e(th, "ut", "gct");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    String[] strArr2 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
                    if (strArr2 != null && strArr2.length > 0) {
                        str = strArr2[0];
                    }
                    if (!TextUtils.isEmpty(str) && Arrays.asList(a).contains(str)) {
                        String str2 = context.getApplicationInfo().nativeLibraryDir;
                        if (!TextUtils.isEmpty(str2)) {
                            if (Arrays.asList(b).contains(str2.substring(str2.lastIndexOf(File.separator) + 1)) && (strArr = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null)) != null && strArr.length > 0) {
                                str = strArr[0];
                            }
                        }
                    }
                } catch (Throwable th2) {
                    v13.e(th2, "ut", "gct_p");
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

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003a A[SYNTHETIC, Splitter:B:28:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0044 A[SYNTHETIC, Splitter:B:33:0x0044] */
    public static String e(Throwable th) {
        Throwable th2;
        PrintWriter printWriter;
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    while (true) {
                        th = th.getCause();
                        if (th == null) {
                            break;
                        }
                        th.printStackTrace(printWriter);
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
                        }
                        if (printWriter != null) {
                        }
                        return null;
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
            } catch (Throwable th7) {
                th2 = th7;
                printWriter = null;
                th2.printStackTrace();
                if (stringWriter != null) {
                }
                if (printWriter != null) {
                }
                return null;
            }
        } catch (Throwable th8) {
            th2 = th8;
            stringWriter = null;
            printWriter = null;
            th2.printStackTrace();
            if (stringWriter != null) {
                try {
                    stringWriter.close();
                } catch (Throwable th9) {
                    th9.printStackTrace();
                }
            }
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Throwable th10) {
                    th10.printStackTrace();
                }
            }
            return null;
        }
        throw th;
        if (printWriter != null) {
            printWriter.close();
        }
        throw th;
    }

    public static String f(Map<String, String> map) {
        String value;
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
                    value = entry.getValue();
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    value = entry.getValue();
                }
                stringBuffer.append(value);
            }
        } catch (Throwable th) {
            v13.e(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static String g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static Method h(Class cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(v(str), clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Calendar i(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.CHINA);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(simpleDateFormat.parse(str));
            instance.set(instance.get(1), instance.get(2), instance.get(5), instance2.get(11), instance2.get(12), instance2.get(13));
            return instance;
        } catch (ParseException e) {
            v13.e(e, "ut", "ctt");
            return null;
        }
    }

    public static void j(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6 = "";
        String i = l.i(context);
        String a2 = r1.a(i);
        String a3 = l.a(context);
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
                        str3 = v("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si") + "\"请求内容过长导致业务调用失败\"相关内容进行解决";
                        Log.i("authErrLog", c);
                        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                        Log.i("authErrLog", c);
                        E("SHA1Package:".concat(String.valueOf(i)));
                        E("key:".concat(String.valueOf(a3)));
                        E("csid:".concat(String.valueOf(str)));
                        E("gsid:".concat(String.valueOf(str2)));
                        E("json:" + jSONObject.toString());
                        Log.i("authErrLog", "                                                                               ");
                        Log.i("authErrLog", str3);
                        Log.i("authErrLog", c);
                    }
                } else if ("INVALID_USER_KEY".equals(str5)) {
                    if (jSONObject.has("key")) {
                        str6 = jSONObject.getString("key");
                    }
                    if (str6.length() > 0 && !a3.equals(str6)) {
                        str4 = v("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
                    }
                }
                str3 = str4;
            } catch (Throwable unused) {
                str6 = str4;
                str3 = str6;
                Log.i("authErrLog", c);
                Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                Log.i("authErrLog", c);
                E("SHA1Package:".concat(String.valueOf(i)));
                E("key:".concat(String.valueOf(a3)));
                E("csid:".concat(String.valueOf(str)));
                E("gsid:".concat(String.valueOf(str2)));
                E("json:" + jSONObject.toString());
                Log.i("authErrLog", "                                                                               ");
                Log.i("authErrLog", str3);
                Log.i("authErrLog", c);
            }
        } catch (Throwable unused2) {
            str3 = str6;
            Log.i("authErrLog", c);
            Log.i("authErrLog", "                                   鉴权错误信息                                  ");
            Log.i("authErrLog", c);
            E("SHA1Package:".concat(String.valueOf(i)));
            E("key:".concat(String.valueOf(a3)));
            E("csid:".concat(String.valueOf(str)));
            E("gsid:".concat(String.valueOf(str2)));
            E("json:" + jSONObject.toString());
            Log.i("authErrLog", "                                                                               ");
            Log.i("authErrLog", str3);
            Log.i("authErrLog", c);
        }
        Log.i("authErrLog", c);
        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
        Log.i("authErrLog", c);
        E("SHA1Package:".concat(String.valueOf(i)));
        E("key:".concat(String.valueOf(a3)));
        E("csid:".concat(String.valueOf(str)));
        E("gsid:".concat(String.valueOf(str2)));
        E("json:" + jSONObject.toString());
        Log.i("authErrLog", "                                                                               ");
        Log.i("authErrLog", str3);
        Log.i("authErrLog", c);
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, byte b2, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b2});
            int i = b2 & 255;
            if (i < 255 && i > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            v13.e(e, "ut", "wFie");
        }
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
            } catch (IOException e) {
                v13.e(e, "ut", "wsf");
            }
        } else {
            int length = str.length();
            if (length > 255) {
                length = 255;
            }
            k(byteArrayOutputStream, (byte) length, p(str));
        }
    }

    public static boolean m(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                v13.e(th, "ut", "cpm");
            }
        }
        return true;
    }

    public static boolean n(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] o(int i) {
        return new byte[]{(byte) (i / 256), (byte) (i % 256)};
    }

    public static byte[] p(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static u1 q() throws k {
        return new u1.a("co", "1.0.0", "AMap_co_1.0.0").b(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).c();
    }

    public static String r(String str) {
        if (str == null) {
            return null;
        }
        String i = p1.i(p(str));
        try {
            return ((char) ((i.length() % 26) + 65)) + i;
        } catch (Throwable th) {
            v13.e(th, "ut", "tsfb64");
            return "";
        }
    }

    public static String s(Map<String, String> map) {
        String str;
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            str = sb.toString();
        } else {
            str = null;
        }
        return B(str);
    }

    public static boolean t(Context context) {
        return g.a(context);
    }

    public static byte[] u(byte[] bArr) {
        try {
            return G(bArr);
        } catch (Throwable th) {
            v13.e(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String v(String str) {
        return str.length() < 2 ? "" : p1.a(str.substring(1));
    }

    public static byte[] w() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(p1.g(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            v13.e(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058  */
    public static byte[] x(byte[] bArr) {
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
                        v13.e(th2, "ut", "zp1");
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        v13.e(th3, "ut", "zp2");
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        v13.e(th, "ut", "zp");
                        if (zipOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        return bArr2;
                    } catch (Throwable th5) {
                        v13.e(th5, "ut", "zp2");
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                zipOutputStream = null;
                v13.e(th, "ut", "zp");
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th7) {
                        v13.e(th7, "ut", "zp1");
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
            v13.e(th, "ut", "zp");
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

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    static PublicKey y() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(p1.g("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
            try {
                CertificateFactory instance = CertificateFactory.getInstance(v("IWC41MDk"));
                KeyFactory instance2 = KeyFactory.getInstance(v("EUlNB"));
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

    public static byte[] z(String str) {
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
}
