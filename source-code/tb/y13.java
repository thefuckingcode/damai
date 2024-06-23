package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.loc.an;
import com.loc.l;
import com.loc.p1;
import com.loc.r1;
import com.loc.v1;
import java.util.Arrays;

/* compiled from: Taobao */
public final class y13 {
    static byte[] a;
    static byte[] b;

    public y13(String str) {
        r1.a(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static int a(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            an.m(th, "csp", "giv");
            return i;
        }
    }

    public static SharedPreferences.Editor b(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                v13.e(th, "sp", "ge");
            }
        }
        return null;
    }

    public static String c(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return v1.g(q(context, v1.z(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void d(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putString(str2, v1.F(m(context, v1.p(str3))));
                e(edit);
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(SharedPreferences.Editor editor) {
        if (editor != null) {
            try {
                editor.apply();
            } catch (Throwable th) {
                v13.e(th, "sp", "cm");
            }
        }
    }

    public static void f(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    editor.remove(str);
                }
            } catch (Throwable th) {
                v13.e(th, "sp", "rk");
            }
        }
    }

    public static void g(SharedPreferences.Editor editor, String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (Throwable th) {
            an.m(th, "csp", "putPrefsInt");
        }
    }

    public static void h(SharedPreferences.Editor editor, String str, long j) {
        if (editor != null && !TextUtils.isEmpty(str)) {
            try {
                editor.putLong(str, j);
            } catch (Throwable th) {
                an.m(th, "csp", "plv");
            }
        }
    }

    public static void i(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                v13.e(th, "sp", IRequestConst.PS);
            }
        }
    }

    public static void j(SharedPreferences.Editor editor, String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (Throwable th) {
            an.m(th, "csp", "setPrefsStr");
        }
    }

    public static boolean k(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            an.m(th, "csp", "gbv");
            return z;
        }
    }

    private static byte[] l(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = l.j(context).getBytes();
        a = bytes;
        return bytes;
    }

    public static byte[] m(Context context, byte[] bArr) {
        try {
            return p1.h(l(context), bArr, p(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static long n(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, 0);
        } catch (Throwable th) {
            an.m(th, "csp", "glv");
            return 0;
        }
    }

    public static String o(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            an.m(th, "csp", "gsv");
            return str3;
        }
    }

    private static byte[] p(Context context) {
        byte[] bArr = b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        int i = 0;
        if (Build.VERSION.SDK_INT < 9) {
            b = new byte[(l(context).length / 2)];
            while (true) {
                byte[] bArr2 = b;
                if (i >= bArr2.length) {
                    break;
                }
                bArr2[i] = l(context)[i];
                i++;
            }
        } else {
            b = Arrays.copyOfRange(l(context), 0, l(context).length / 2);
        }
        return b;
    }

    public static byte[] q(Context context, byte[] bArr) {
        try {
            return p1.e(l(context), bArr, p(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
