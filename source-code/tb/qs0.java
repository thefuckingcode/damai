package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Taobao */
public class qs0 {
    @SuppressLint({"StaticFieldLeak"})
    private static final qs0 d = new qs0();
    private Context a;
    private Handler b;
    private String c;

    private qs0() {
    }

    public static qs0 e() {
        return d;
    }

    public Context a() {
        return this.a;
    }

    public Handler b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Handler d() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("APM-Monitor-Biz");
            handlerThread.start();
            this.b = new Handler(handlerThread.getLooper());
        }
        return this.b;
    }

    public qs0 f(Context context) {
        this.a = context;
        return this;
    }

    public void g(Handler handler) {
        this.b = handler;
    }

    public qs0 h(String str) {
        this.c = str;
        return this;
    }
}
