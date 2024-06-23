package tb;

import android.os.Handler;

/* compiled from: Taobao */
public class o3 {
    private final Handler a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        static final o3 a = new o3();
    }

    public static o3 b() {
        return b.a;
    }

    public Handler a() {
        return this.a;
    }

    private o3() {
        this.a = qs0.e().d();
    }
}
