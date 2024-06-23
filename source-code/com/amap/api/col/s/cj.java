package com.amap.api.col.s;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import tb.jl1;

/* compiled from: Taobao */
public final class cj {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    public static String e = "s";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";
    public static final String k = "k";
    private static long l;
    private static Vector<bv> m = new Vector<>();

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }

    @TargetApi(9)
    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    static boolean b(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(jl1.BRACKET_END_STR) && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void a(final Context context) {
        try {
            if (System.currentTimeMillis() - l >= DateUtils.MILLIS_PER_MINUTE) {
                l = System.currentTimeMillis();
                ed.a().b(new ee() {
                    /* class com.amap.api.col.s.cj.AnonymousClass1 */

                    @Override // com.amap.api.col.s.ee
                    public final void a() {
                        try {
                            cm.b(context);
                            cm.d(context);
                            cm.c(context);
                            dm.a(context);
                            dk.a(context);
                        } catch (RejectedExecutionException unused) {
                        } catch (Throwable th) {
                            cl.c(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            cl.c(th, "Lg", "proL");
        }
    }

    public static void a(bv bvVar) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (bvVar != null) {
                    if (!m.contains(bvVar)) {
                        m.add(bvVar);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    static List<bv> a() {
        Vector<bv> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return m;
        }
    }

    static boolean a(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                String[] split = str.split(StringUtils.LF);
                int length = split.length;
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 < length) {
                        String trim = split[i2].trim();
                        if (TextUtils.isEmpty(trim) || !trim.startsWith("at ") || !trim.contains("uncaughtException")) {
                            z = false;
                        }
                        if (z) {
                            return false;
                        }
                        i2++;
                    } else {
                        for (String str2 : split) {
                            if (b(strArr, str2.trim())) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
