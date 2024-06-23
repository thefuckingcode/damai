package anet.channel.util;

import android.text.TextUtils;
import android.util.Log;
import tb.jl1;

/* compiled from: Taobao */
public class ALog {
    public static a a;
    private static volatile ILog b;
    private static Object c = "|";
    private static boolean d = true;
    private static boolean e = true;

    /* compiled from: Taobao */
    public interface ILog {
        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th);

        void i(String str, String str2);

        boolean isPrintLog(int i);

        boolean isValid();

        void setLogLevel(int i);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th);
    }

    /* compiled from: Taobao */
    public static class a implements ILog {
        int a = 1;

        @Override // anet.channel.util.ALog.ILog
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // anet.channel.util.ALog.ILog
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // anet.channel.util.ALog.ILog
        public void i(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // anet.channel.util.ALog.ILog
        public boolean isPrintLog(int i) {
            return i >= this.a;
        }

        @Override // anet.channel.util.ALog.ILog
        public boolean isValid() {
            return true;
        }

        @Override // anet.channel.util.ALog.ILog
        public void setLogLevel(int i) {
            if (i < 0 || i > 5) {
                this.a = 5;
            } else {
                this.a = i;
            }
        }

        @Override // anet.channel.util.ALog.ILog
        public void w(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // anet.channel.util.ALog.ILog
        public void e(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        @Override // anet.channel.util.ALog.ILog
        public void w(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }
    }

    static {
        a aVar = new a();
        a = aVar;
        b = aVar;
    }

    private static String a(String str, String str2, Object... objArr) {
        Object obj;
        Object obj2;
        if (str == null && str2 == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(c);
            sb.append("[seq:");
            sb.append(str2);
            sb.append(jl1.ARRAY_END_STR);
        }
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        if (objArr != null) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(" ");
                if (objArr[i] != null) {
                    obj = objArr[i];
                } else {
                    obj = "";
                }
                sb.append(obj);
                sb.append(":");
                if (objArr[i2] != null) {
                    obj2 = objArr[i2];
                } else {
                    obj2 = "";
                }
                sb.append(obj2);
                i += 2;
            }
            if (i < objArr.length) {
                sb.append(" ");
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    private static String b(String str) {
        return str;
    }

    public static void c(String str, String str2, String str3, Object... objArr) {
        if (g(1) && b != null) {
            b.d(b(str), a(str2, str3, objArr));
        }
    }

    public static void d(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (g(4) && b != null) {
            b.e(b(str), a(str2, str3, objArr), th);
        }
    }

    public static void e(String str, String str2, String str3, Object... objArr) {
        if (g(4) && b != null) {
            b.e(b(str), a(str2, str3, objArr));
        }
    }

    public static void f(String str, String str2, String str3, Object... objArr) {
        if (g(2) && b != null) {
            b.i(b(str), a(str2, str3, objArr));
        }
    }

    public static boolean g(int i) {
        if (d && b != null) {
            return b.isPrintLog(i);
        }
        return false;
    }

    public static void h(ILog iLog) {
        if (iLog != null) {
            if ((e || !iLog.getClass().getSimpleName().toLowerCase().contains("tlog")) && iLog.isValid()) {
                b = iLog;
            }
        }
    }

    @Deprecated
    public static void i(boolean z) {
        if (!z) {
            e = false;
            b = a;
            return;
        }
        e = true;
    }

    public static void j(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (g(3) && b != null) {
            b.w(b(str), a(str2, str3, objArr), th);
        }
    }

    public static void k(String str, String str2, String str3, Object... objArr) {
        if (g(3) && b != null) {
            b.w(b(str), a(str2, str3, objArr));
        }
    }
}
