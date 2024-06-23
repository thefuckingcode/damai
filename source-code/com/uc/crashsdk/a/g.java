package com.uc.crashsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.taobao.weex.common.Constants;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.b;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class g {
    static final /* synthetic */ boolean a = true;
    private static Context b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static boolean h;
    private static final Object i = new Object();
    private static final char[] j = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(File file, File file2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            a(fileInputStream2);
                            a(fileOutputStream);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                a(fileInputStream);
                a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            a(fileInputStream);
            a(fileOutputStream);
            throw th;
        }
    }

    public static void b(File file) {
        a(file, "");
    }

    public static String c(File file) {
        Throwable th;
        String str = "";
        if (!file.exists()) {
            return str;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[256];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                str = sb.toString();
                a(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                try {
                    a(th, false);
                    return str;
                } finally {
                    a(fileInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            a(th, false);
            return str;
        }
        return str;
    }

    public static String d(File file) {
        return a(file, 64, true);
    }

    public static byte[] e(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                a(fileInputStream);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                try {
                    a(th, false);
                    return null;
                } finally {
                    a(fileInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            a(th, false);
            return null;
        }
    }

    public static boolean f() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean g() {
        int indexOf;
        String i2 = i();
        if (!a(i2) && (indexOf = i2.indexOf(" root ")) > 0) {
            String substring = i2.substring(0, indexOf);
            if (substring.contains(Constants.Name.X) || substring.contains("s")) {
                return true;
            }
        }
        return false;
    }

    public static String h() {
        l();
        if (a(f)) {
            return "";
        }
        return f;
    }

    public static String i() {
        l();
        if (a(g)) {
            return "";
        }
        return g;
    }

    public static void j() {
        f.a(0, new e(800), 15000);
    }

    public static void k() {
        if (b.d && h) {
            JNIBridge.set(123, f);
            JNIBridge.set(124, g);
        }
    }

    private static void l() {
        String trim;
        int indexOf;
        int indexOf2;
        if (!h) {
            synchronized (i) {
                if (!h) {
                    String a2 = a(new String[]{"sh", "-c", "type su"});
                    if (!a(a2) && (indexOf = (trim = a2.trim()).indexOf(32)) > 0 && trim.contains("/su") && (indexOf2 = trim.indexOf(47, indexOf + 1)) > 0) {
                        String substring = trim.substring(indexOf2);
                        f = substring;
                        String a3 = a(new String[]{"ls", "-l", substring});
                        if (!a(a3)) {
                            g = a3.trim();
                        }
                    }
                    h = true;
                    k();
                }
            }
        }
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static String d() {
        String str = e;
        return str != null ? str : "";
    }

    public static void b(Throwable th) {
        a(th, true);
    }

    public static String d(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = digest[i3];
                char[] cArr = j;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                sb.append(c2);
                sb.append(c3);
            }
            return sb.toString();
        } catch (Exception e2) {
            a.a("crashsdk", "getMD5: ", e2);
            return null;
        }
    }

    public static String b() {
        return c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e A[SYNTHETIC, Splitter:B:13:0x001e] */
    public static String a(File file, int i2, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i2];
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    String str = new String(bArr, 0, read);
                    a(fileInputStream);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                if (z) {
                    try {
                        a(th, false);
                    } catch (Throwable th3) {
                        a(fileInputStream);
                        throw th3;
                    }
                }
                a(fileInputStream);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (z) {
            }
            a(fileInputStream);
            return null;
        }
        a(fileInputStream);
        return null;
    }

    public static boolean e() {
        if (g()) {
            return true;
        }
        return f();
    }

    public static long c(String str) {
        if (a(str)) {
            return 0;
        }
        try {
            long parseLong = Long.parseLong(str.trim());
            if (parseLong < 0) {
                return 0;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static String c() {
        return d;
    }

    public static ArrayList<String> a(File file, int i2) {
        BufferedReader bufferedReader;
        Throwable th;
        ArrayList<String> arrayList = new ArrayList<>();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2, 512);
                int i3 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i3++;
                        if (i2 > 0 && i3 >= i2) {
                            break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = fileReader2;
                        try {
                            a(th, false);
                            a(fileReader);
                            a(bufferedReader);
                            return arrayList;
                        } catch (Throwable th3) {
                            a(fileReader);
                            a(bufferedReader);
                            throw th3;
                        }
                    }
                }
                a(fileReader2);
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                fileReader = fileReader2;
                a(th, false);
                a(fileReader);
                a(bufferedReader);
                return arrayList;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            a(th, false);
            a(fileReader);
            a(bufferedReader);
            return arrayList;
        }
        a(bufferedReader);
        return arrayList;
    }

    public static boolean a(File file, byte[] bArr) {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                a(fileOutputStream2);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    a(th, false);
                    return false;
                } finally {
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            a(th, false);
            return false;
        }
    }

    public static boolean a(File file, String str) {
        Throwable th;
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str, 0, str.length());
                a(fileWriter2);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = fileWriter2;
                try {
                    a(th, false);
                    return false;
                } finally {
                    a(fileWriter);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            a(th, false);
            return false;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a(th, true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if (r2.toLowerCase().startsWith("http") != false) goto L_0x0029;
     */
    public static String a(String str, String str2, boolean z) {
        String str3 = null;
        if (new File(str).exists()) {
            String a2 = b.a(str);
            if (!a(a2)) {
                if (z) {
                    a2 = a2.trim();
                }
                str3 = a2;
            }
        }
        return str3 == null ? str2 : str3;
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static void a(Throwable th) {
        a(th, false);
    }

    private static void a(Throwable th, boolean z) {
        if (!z) {
            try {
                if (!com.uc.crashsdk.g.M()) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        th.printStackTrace();
    }

    public static void a(Context context) {
        if (b != null) {
            a.b("mContext is existed");
        }
        b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        c = applicationInfo.dataDir;
        d = applicationInfo.sourceDir;
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            if (obj != null && (obj instanceof String)) {
                e = (String) obj;
            }
        } catch (Throwable th) {
            a(th, false);
        }
    }

    public static Context a() {
        return b;
    }

    public static void a(int i2) {
        if (i2 == 800) {
            l();
        } else if (!a) {
            throw new AssertionError();
        }
    }

    private static String a(String[] strArr) {
        BufferedReader bufferedReader;
        Throwable th;
        Reader reader;
        try {
            reader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new BufferedReader(reader, 512);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                try {
                    a(th, false);
                    return null;
                } finally {
                    a(bufferedReader);
                    a(reader);
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String trim = sb.toString().trim();
                        a(bufferedReader);
                        a(reader);
                        return trim;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                a(th, false);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            reader = bufferedReader;
            a(th, false);
            return null;
        }
    }
}
