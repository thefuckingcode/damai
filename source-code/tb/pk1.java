package tb;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class pk1 {
    public static String a() {
        return Build.getMANUFACTURER();
    }

    public static int b() {
        String g = g("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(g)) {
            return -1;
        }
        try {
            return Integer.parseInt(g) + 2;
        } catch (Exception e) {
            ry.d("OSUtils", String.format("get MIUI version code failed: %s", g), e);
            return -1;
        }
    }

    public static String c() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String d() {
        return h() ? "MIUI" : "OTHER";
    }

    public static String e() {
        return i() ? g("ro.miui.ui.version.name") : "";
    }

    public static String f() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a A[SYNTHETIC, Splitter:B:21:0x004a] */
    public static String g(String str) {
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    vx.b(e2);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    vx.b(e);
                    if (bufferedReader != null) {
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            vx.b(e4);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            vx.b(e);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        return str2;
    }

    public static boolean h() {
        return !TextUtils.isEmpty(g("ro.miui.ui.version.name")) || b() != -1;
    }

    public static boolean i() {
        return "Xiaomi".equals(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
    }
}
