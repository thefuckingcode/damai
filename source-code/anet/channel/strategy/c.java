package anet.channel.strategy;

import android.content.Context;
import anet.channel.statist.StrategyStatObject;
import anet.channel.util.ALog;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import tb.ss0;
import tb.t82;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class c {
    private static File a;
    private static volatile boolean b;
    private static Comparator<File> c = new a();

    /* compiled from: Taobao */
    static class a implements Comparator<File> {
        a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return (int) (file2.lastModified() - file.lastModified());
        }
    }

    private static boolean a(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    static synchronized void b() {
        synchronized (c.class) {
            ALog.f("awcn.StrategySerializeHelper", "clear start.", null, new Object[0]);
            File file = a;
            if (file == null) {
                ALog.k("awcn.StrategySerializeHelper", "folder path not initialized, wait to clear", null, new Object[0]);
                b = true;
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    }
                }
                ALog.f("awcn.StrategySerializeHelper", "clear end.", null, new Object[0]);
            }
        }
    }

    static synchronized File[] c() {
        synchronized (c.class) {
            File file = a;
            if (file == null) {
                return null;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles, c);
            }
            return listFiles;
        }
    }

    public static File d(String str) {
        a(a);
        return new File(a, str);
    }

    public static void e(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir(), "awcn_strategy");
                a = file;
                if (!a(file)) {
                    ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", a.getAbsolutePath());
                }
                if (!ss0.j()) {
                    String d = ss0.d();
                    File file2 = new File(a, d.substring(d.indexOf(58) + 1));
                    a = file2;
                    if (!a(file2)) {
                        ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", a.getAbsolutePath());
                    }
                }
                ALog.f("awcn.StrategySerializeHelper", "StrateyFolder", null, com.alibaba.security.realidentity.jsbridge.a.V, a.getAbsolutePath());
                if (b) {
                    b();
                    b = false;
                    return;
                }
                g();
            } catch (Throwable th) {
                ALog.d("awcn.StrategySerializeHelper", "StrategySerializeHelper initialize failed!!!", null, th, new Object[0]);
            }
        }
    }

    static synchronized void f(Serializable serializable, String str, StrategyStatObject strategyStatObject) {
        synchronized (c.class) {
            t82.b(serializable, d(str), strategyStatObject);
        }
    }

    static synchronized void g() {
        synchronized (c.class) {
            File[] c2 = c();
            if (c2 != null) {
                int i = 0;
                for (File file : c2) {
                    if (!file.isDirectory()) {
                        if (System.currentTimeMillis() - file.lastModified() > 172800000) {
                            file.delete();
                        } else if (file.getName().startsWith("WIFI")) {
                            int i2 = i + 1;
                            if (((long) i) > 10) {
                                file.delete();
                            }
                            i = i2;
                        }
                    }
                }
            }
        }
    }

    static synchronized <T> T h(String str, StrategyStatObject strategyStatObject) {
        T t;
        synchronized (c.class) {
            t = (T) t82.c(d(str), strategyStatObject);
        }
        return t;
    }
}
