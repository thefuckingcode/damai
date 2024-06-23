package com.uploader.implement.b.a;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionExtraCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;

/* compiled from: Taobao */
public class c implements SessionCb, SessionExtraCb {
    private com.uploader.implement.c a;
    private SpdyAgent b;
    private SpdySession c;
    private final Context d;
    private final f e;
    private volatile a f;
    private volatile String g = "DISCONNECTED";
    private List<C0250c> h = new LinkedList();
    private final int i;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface a {
        void a();

        void a(int i);

        void a(int i, int i2);

        void a(byte[] bArr, int i);

        void b(int i);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements AccsSSLCallback {
        b() {
        }

        @Override // org.android.spdy.AccsSSLCallback
        public byte[] getSSLPublicKey(int i, byte[] bArr) {
            try {
                return c.this.a.b.decrypt(c.this.d, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
            } catch (Exception e) {
                if (!com.uploader.implement.a.d(16)) {
                    return null;
                }
                com.uploader.implement.a.b(16, "CustomizedSession", "call config.decrypt error.", e);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.uploader.implement.b.a.c$c  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0250c {
        byte[] a;
        int b;
        int c;

        public C0250c(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(hashCode());
            sb.append(" WaitingData{ length=");
            sb.append(this.b);
            sb.append(", sendSequence=");
            sb.append(this.c);
            sb.append("}");
            return sb.toString();
        }
    }

    public c(com.uploader.implement.c cVar, f fVar) {
        this.a = cVar;
        this.d = cVar.c;
        this.e = fVar;
        this.i = hashCode();
    }

    private void c(int i2) {
        synchronized (this.h) {
            this.h.clear();
        }
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "CustomizedSession", this.i + " CustomizedSession onClose, error:" + i2);
        }
        if (this.f != null) {
            this.f.a(i2);
        }
    }

    private void f(C0250c cVar) {
        synchronized (this.h) {
            this.h.add(cVar);
            if (com.uploader.implement.a.d(8)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(this.i);
                sb.append(" [addWaitingData] ");
                sb.append(cVar);
                sb.append(", mSession:");
                SpdySession spdySession = this.c;
                sb.append(spdySession != null ? Integer.valueOf(spdySession.hashCode()) : "");
                com.uploader.implement.a.a(8, "CustomizedSession", sb.toString());
            }
        }
    }

    private void j() {
        try {
            SpdyAgent.enableDebug = false;
            SpdyAgent instance = SpdyAgent.getInstance(this.d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            this.b = instance;
            if (this.e.f) {
                instance.setAccsSslCallback(new b());
            }
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "CustomizedSession", this.i + " initSpdyAgent");
            }
        } catch (Exception e2) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "CustomizedSession", this.i + " init SpdyAgent failed.", e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        com.uploader.implement.e.b.a(new com.uploader.implement.b.a.c.AnonymousClass2(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r1 == null) goto L_?;
     */
    private void k() {
        synchronized (this.h) {
            if (!this.h.isEmpty()) {
                final C0250c remove = this.h.remove(0);
            }
        }
    }

    public void b() {
        if (i()) {
            try {
                this.g = "CONNECTING";
                int i2 = this.e.f ? SpdyProtocol.SSSL_0RTT_CUSTOM : 16;
                f fVar = this.e;
                SessionInfo sessionInfo = new SessionInfo(fVar.a, fVar.b, Integer.toString(this.i), null, 0, null, this, i2);
                sessionInfo.setConnectionTimeoutMs(10000);
                if (this.e.f) {
                    if (2 == this.a.b.getCurrentElement().a) {
                        sessionInfo.setPubKeySeqNum(0);
                    } else {
                        sessionInfo.setPubKeySeqNum(6);
                    }
                }
                if (this.b == null) {
                    j();
                }
                this.c = this.b.createSession(sessionInfo);
                if (com.uploader.implement.a.d(4)) {
                    com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession createSession,mSession:" + this.c.hashCode() + " getRefCount:" + this.c.getRefCount());
                }
            } catch (SpdyErrorException e2) {
                this.g = "CONNECTFAILED";
                if (com.uploader.implement.a.d(16)) {
                    com.uploader.implement.a.b(16, "CustomizedSession", this.i + "CustomizedSession connect failed", e2);
                }
                c(e2.SpdyErrorGetCode());
            }
        } else if (com.uploader.implement.a.d(8)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.i);
            sb.append(" CustomizedSession already connected,mSession:");
            SpdySession spdySession = this.c;
            sb.append(spdySession != null ? Integer.valueOf(spdySession.hashCode()) : "");
            com.uploader.implement.a.a(8, "CustomizedSession", sb.toString());
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
    }

    public void d(int i2, byte[] bArr, int i3) {
        try {
            if (!i()) {
                this.c.sendCustomControlFrame(i2, -1, -1, i3, bArr);
                if (com.uploader.implement.a.d(4)) {
                    StringBuilder sb = new StringBuilder(64);
                    sb.append(this.i);
                    sb.append(" send sendCustomControlFrame. sequence=");
                    sb.append(i2);
                    sb.append(", length=");
                    sb.append(i3);
                    sb.append(", mSession:");
                    sb.append(this.c.hashCode());
                    com.uploader.implement.a.a(4, "CustomizedSession", sb.toString());
                }
                if (this.f != null) {
                    this.f.b(i2);
                }
            } else if (com.uploader.implement.a.d(16)) {
                StringBuilder sb2 = new StringBuilder(64);
                sb2.append(this.i);
                sb2.append(" send failed, needConnect and return, sequence:");
                sb2.append(i2);
                sb2.append(", length=");
                sb2.append(i3);
                sb2.append(", mSession:");
                SpdySession spdySession = this.c;
                sb2.append(spdySession != null ? Integer.valueOf(spdySession.hashCode()) : "");
                com.uploader.implement.a.a(16, "CustomizedSession", sb2.toString());
            }
        } catch (SpdyErrorException e2) {
            int SpdyErrorGetCode = e2.SpdyErrorGetCode();
            if (-3848 == SpdyErrorGetCode) {
                f(new C0250c(bArr, i3, i2));
                return;
            }
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "CustomizedSession", this.i + " send sendCustomControlFrame failed", e2);
            }
            if (this.f != null) {
                this.f.a(i2, SpdyErrorGetCode);
            }
        }
    }

    public void e(a aVar) {
        this.f = aVar;
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        try {
            return this.a.b.getSslTicket(this.d, "ARUP_SSL_TICKET_KEY");
        } catch (Exception e2) {
            if (!com.uploader.implement.a.d(16)) {
                return null;
            }
            com.uploader.implement.a.b(16, "CustomizedSession", "CustomizedSession call config.getSslTicket error.", e2);
            return null;
        }
    }

    public void h() {
        SpdySession spdySession = this.c;
        if (spdySession != null) {
            spdySession.closeSession();
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession closeSession,session:" + this.c.hashCode());
            }
        }
        this.g = "DISCONNECTED";
    }

    public boolean i() {
        String str = this.g;
        return !"CONNECTED".equals(str) && !"CONNECTING".equals(str);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        try {
            return this.a.b.putSslTicket(this.d, "ARUP_SSL_TICKET_KEY", bArr);
        } catch (Exception e2) {
            if (!com.uploader.implement.a.d(16)) {
                return -1;
            }
            com.uploader.implement.a.b(16, "CustomizedSession", "CustomizedSession call config.putSslTicket error.", e2);
            return -1;
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession spdyCustomControlFrameFailCallback, session:" + spdySession.hashCode() + ", id:" + i2 + ", error:" + i3);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        if (this.f != null) {
            this.f.a(bArr, i5);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
                spdySession.clearAllStreamCb();
            } catch (Throwable unused) {
            }
        }
        this.g = "DISCONNECTED";
        if (com.uploader.implement.a.d(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.i);
            sb.append(" CustomizedSession spdySessionCloseCallback,session:");
            sb.append(spdySession != null ? Integer.valueOf(spdySession.hashCode()) : "");
            sb.append(", error:");
            sb.append(i2);
            com.uploader.implement.a.a(2, "CustomizedSession", sb.toString());
        }
        c(i2);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.g = "CONNECTED";
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession spdySessionConnectCB,session:" + spdySession.hashCode());
        }
        if (this.f != null) {
            this.f.a();
        }
        k();
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            spdySession.cleanUp();
        }
        this.g = "CONNECTFAILED";
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "CustomizedSession", this.i + " CustomizedSession spdySessionFailedError,session:" + spdySession + ", error:" + i2);
        }
        c(i2);
    }

    @Override // org.android.spdy.SessionExtraCb
    public void spdySessionOnWritable(SpdySession spdySession, Object obj, int i2) {
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "CustomizedSession", this.i + " CustomizedSession spdySessionOnWritable session:" + spdySession.hashCode() + ",size:" + i2);
        }
        k();
    }
}
