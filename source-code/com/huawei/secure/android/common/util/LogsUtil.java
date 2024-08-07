package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class LogsUtil {
    private static final Pattern a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    private static final char b = '*';
    private static final int c = 2;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a extends Throwable {
        private static final long d = 7129050843360571879L;
        private String a;
        private Throwable b;
        private Throwable c;

        public a(Throwable th) {
            this.c = th;
        }

        public void a(Throwable th) {
            this.b = th;
        }

        public Throwable getCause() {
            Throwable th = this.b;
            if (th == this) {
                return null;
            }
            return th;
        }

        public String getMessage() {
            return this.a;
        }

        public String toString() {
            Throwable th = this.c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.a.startsWith(str)) {
                return this.a;
            }
            return str + this.a;
        }

        public void a(String str) {
            this.a = str;
        }
    }

    private static String a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 0) {
                charArray[i] = b;
            }
        }
        return new String(charArray);
    }

    public static void d(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, a(str2, z));
        }
    }

    public static void e(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2, z));
        }
    }

    public static void i(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2, z));
        }
    }

    public static void w(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2, z));
        }
    }

    public static void d(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.d(str, a(str2, str3));
        }
    }

    public static void e(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, a(str2, str3));
        }
    }

    public static void i(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, a(str2, str3));
        }
    }

    public static void w(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, a(str2, str3));
        }
    }

    public static void d(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.d(str, a(str2, str3), a(th));
        }
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.e(str, a(str2, str3), a(th));
        }
    }

    public static void i(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.i(str, a(str2, str3), a(th));
        }
    }

    public static void w(String str, String str2, String str3, Throwable th) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            Log.w(str, a(str2, str3), a(th));
        }
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(a(str2));
        }
        return sb.toString();
    }

    public static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, a(str2, false));
        }
    }

    public static void e(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2, false));
        }
    }

    public static void i(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2, false));
        }
    }

    public static void w(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2, false));
        }
    }

    public static void d(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, a(str2, z), a(th));
        }
    }

    public static void e(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.e(str, a(str2, z), a(th));
        }
    }

    public static void i(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.i(str, a(str2, z), a(th));
        }
    }

    public static void w(String str, String str2, Throwable th, boolean z) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.w(str, a(str2, z), a(th));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.d(str, a(str2, false), a(th));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.e(str, a(str2, false), a(th));
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.i(str, a(str2, false), a(th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.w(str, a(str2, false), a(th));
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i = 1;
        if (1 == length) {
            return String.valueOf((char) b);
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (a.matcher(String.valueOf(charAt)).matches()) {
                if (i % 2 == 0) {
                    charAt = b;
                }
                i++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static Throwable a(Throwable th) {
        if (th == null) {
            return null;
        }
        a aVar = new a(th);
        aVar.setStackTrace(th.getStackTrace());
        aVar.a(b(th.getMessage()));
        Throwable cause = th.getCause();
        a aVar2 = aVar;
        while (cause != null) {
            a aVar3 = new a(cause);
            aVar3.setStackTrace(cause.getStackTrace());
            aVar3.a(b(cause.getMessage()));
            aVar2.a(aVar3);
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }
}
