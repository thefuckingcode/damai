package tb;

import anet.channel.request.Cancelable;
import anet.channel.util.ALog;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

/* compiled from: Taobao */
public class km2 implements Cancelable {
    public static final km2 NULL = new km2(null, 0, null);
    private final int a;
    private final SpdySession b;
    private final String c;

    public km2(SpdySession spdySession, int i, String str) {
        this.b = spdySession;
        this.a = i;
        this.c = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        int i;
        try {
            if (this.b != null && (i = this.a) != 0) {
                ALog.f("awcn.TnetCancelable", "cancel tnet request", this.c, "streamId", Integer.valueOf(i));
                this.b.streamReset((long) this.a, 5);
            }
        } catch (SpdyErrorException e) {
            ALog.d("awcn.TnetCancelable", "request cancel failed.", this.c, e, "errorCode", Integer.valueOf(e.SpdyErrorGetCode()));
        }
    }
}
