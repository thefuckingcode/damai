package tb;

import com.taobao.monitor.impl.data.utsession.IUTSession;

/* compiled from: Taobao */
public class zq2 implements IUTSession {
    private static final zq2 b = new zq2();
    private IUTSession a = null;

    private zq2() {
    }

    public static zq2 a() {
        return b;
    }

    public void b(IUTSession iUTSession) {
        this.a = iUTSession;
    }

    @Override // com.taobao.monitor.impl.data.utsession.IUTSession
    public String getUtsid() {
        IUTSession iUTSession = this.a;
        return iUTSession == null ? "" : iUTSession.getUtsid();
    }
}
