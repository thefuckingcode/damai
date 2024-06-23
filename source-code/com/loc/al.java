package com.loc;

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
public final class al {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    private static long e = 0;
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";
    public static final String k = "k";
    private static Vector<u1> l = new Vector<>();

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    static List<u1> b() {
        Vector<u1> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = l;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return l;
        }
    }

    public static void c(final Context context) {
        try {
            if (System.currentTimeMillis() - e >= DateUtils.MILLIS_PER_MINUTE) {
                e = System.currentTimeMillis();
                o0.f().d(new ck() {
                    /* class com.loc.al.AnonymousClass1 */

                    @Override // com.loc.ck
                    public final void a() {
                        try {
                            ao.k(context);
                            ao.m(context);
                            ao.l(context);
                            bs.b(context);
                            bq.c(context);
                        } catch (RejectedExecutionException unused) {
                        } catch (Throwable th) {
                            an.m(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            an.m(th, "Lg", "proL");
        }
    }

    @TargetApi(9)
    public static void d(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void e(u1 u1Var) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (u1Var != null) {
                    if (!l.contains(u1Var)) {
                        l.add(u1Var);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    static boolean f(String[] strArr, String str) {
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
                            if (h(strArr, str2.trim())) {
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

    public static void g(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    static boolean h(String[] strArr, String str) {
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

    public static String i(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }
}
