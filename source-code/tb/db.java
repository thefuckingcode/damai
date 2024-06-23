package tb;

import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.ut.mini.module.plugin.UTPluginMgr;

/* compiled from: Taobao */
public class db {
    private static fn2 a = new fn2();
    private static xo b = new xo();
    private static db c = new db();

    private db() {
    }

    public static db c() {
        return c;
    }

    public void a(String str, Object obj) {
        b.a(str, obj);
    }

    public void b(String str, String str2) {
        a.a(str, str2);
    }

    public void d() {
        UTPluginMgr.getInstance().registerPlugin(a);
        MotuCrashReporter.getInstance().setCrashCaughtListener(b);
    }
}
