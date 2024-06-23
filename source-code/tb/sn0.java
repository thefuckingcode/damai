package tb;

import anet.channel.request.Cancelable;
import anet.channel.util.ALog;
import java.util.concurrent.Future;

/* compiled from: Taobao */
public class sn0 implements Cancelable {
    public static final sn0 NULL = new sn0(null, null);
    private final Future<?> a;
    private final String b;

    public sn0(Future<?> future, String str) {
        this.a = future;
        this.b = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        if (this.a != null) {
            ALog.f("awcn.FutureCancelable", "cancel request", this.b, new Object[0]);
            this.a.cancel(true);
        }
    }
}
