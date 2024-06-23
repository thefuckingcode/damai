package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.taobao.monitor.procedure.e;

/* compiled from: Taobao */
public class us1 {
    public static final e PROCEDURE_FACTORY = new e();
    public static final co1 PROCEDURE_MANAGER = new co1();
    @SuppressLint({"StaticFieldLeak"})
    private static final us1 d = new us1();
    private Context a;
    private final Handler b;
    private final HandlerThread c;

    private us1() {
        HandlerThread handlerThread = new HandlerThread("APM-Procedure");
        this.c = handlerThread;
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
    }

    public static us1 d() {
        return d;
    }

    public Context a() {
        return this.a;
    }

    public Handler b() {
        return this.b;
    }

    public HandlerThread c() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public us1 e(Context context) {
        this.a = context;
        return this;
    }
}
