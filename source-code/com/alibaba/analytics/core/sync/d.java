package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.apache.commons.lang3.time.DateUtils;
import tb.bc;
import tb.h82;
import tb.i82;
import tb.mm2;
import tb.qm2;
import tb.yd;

/* compiled from: Taobao */
public class d {
    private static final Object a = new Object();
    private static final Object b = new Object();
    private static int c = -1;
    private static int d = 0;
    private static SpdySession e = null;
    private static ByteArrayOutputStream f = null;
    private static long g = 0;
    private static long h = 0;
    private static byte[] i = null;
    private static boolean j = true;
    private static boolean k = false;
    public static final i82 mMonitor = new i82();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements AccsSSLCallback {
        a() {
        }

        @Override // org.android.spdy.AccsSSLCallback
        public byte[] getSSLPublicKey(int i, byte[] bArr) {
            return qm2.c().f(16, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b implements SessionCb, SessionExtraCb {
        private byte[] a;
        private String b;

        public b(String str) {
            this.b = "accs_ssl_key2_" + str;
        }

        private int a(byte[] bArr) {
            return (bArr == null || qm2.c().e(this.b, bArr) == 0) ? -1 : 0;
        }

        @Override // org.android.spdy.SessionCb
        public void bioPingRecvCallback(SpdySession spdySession, int i) {
        }

        @Override // org.android.spdy.SessionCb
        public byte[] getSSLMeta(SpdySession spdySession) {
            if (!qm2.c().b()) {
                return this.a;
            }
            byte[] a2 = qm2.c().a(this.b);
            return a2 != null ? a2 : new byte[0];
        }

        @Override // org.android.spdy.SessionCb
        public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
            if (qm2.c().b()) {
                return a(bArr);
            }
            this.a = bArr;
            return 0;
        }

        @Override // org.android.spdy.SessionCb
        public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        }

        @Override // org.android.spdy.SessionCb
        public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
            if (spdySession == d.e) {
                if (d.f == null) {
                    ByteArrayOutputStream unused = d.f = new ByteArrayOutputStream(1024);
                    long unused2 = d.h = d.r(bArr);
                }
                if (d.h != -1) {
                    try {
                        d.f.write(bArr);
                    } catch (IOException unused3) {
                    }
                    d.g += (long) bArr.length;
                    if (d.h == d.g - 8) {
                        try {
                            d.f.flush();
                        } catch (IOException unused4) {
                        }
                        byte[] byteArray = d.f.toByteArray();
                        try {
                            d.f.close();
                        } catch (IOException unused5) {
                        }
                        int unused6 = d.c = a.l(byteArray);
                        if (d.c != 0) {
                            d.p();
                        }
                        d.t();
                        return;
                    }
                    return;
                }
                int unused7 = d.c = -1;
                d.p();
                d.t();
                return;
            }
            Logger.v("TnetUtil", "[spdyCustomControlFrameRecvCallback] session != spdySessionUT");
        }

        @Override // org.android.spdy.SessionCb
        public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        }

        @Override // org.android.spdy.SessionCb
        public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
            if (spdySession == d.e) {
                int unused = d.c = i;
                synchronized (d.b) {
                    SpdySession unused2 = d.e = null;
                }
            }
        }

        @Override // org.android.spdy.SessionCb
        public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
            if (spdySession == d.e) {
                d.u(spdySession);
            }
        }

        @Override // org.android.spdy.SessionCb
        public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
            if (Variables.n().O()) {
                d.mMonitor.onEvent(h82.a(h82.q, null, Double.valueOf(1.0d)));
            }
            if (spdySession == d.e) {
                int unused = d.c = i;
                d.p();
            }
        }

        @Override // org.android.spdy.SessionExtraCb
        public void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
            if (spdySession == d.e) {
                d.u(spdySession);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void p() {
        Logger.d();
        synchronized (b) {
            SpdySession spdySession = e;
            if (spdySession != null) {
                spdySession.closeSession();
            }
            e = null;
            a.a();
            com.alibaba.analytics.utils.b.b();
        }
        t();
    }

    static void q() {
        Logger.d();
        synchronized (b) {
            SpdySession spdySession = e;
            if (spdySession != null) {
                spdySession.closeSession();
            }
            j = true;
            e = null;
            a.a();
            com.alibaba.analytics.utils.b.b();
        }
        t();
    }

    /* access modifiers changed from: private */
    public static long r(byte[] bArr) {
        if (bArr == null || bArr.length < 12) {
            return -1;
        }
        return (long) yd.b(bArr, 1, 3);
    }

    static void s() {
        synchronized (b) {
            if (e == null) {
                com.alibaba.analytics.utils.b.b();
                a.k();
                j = true;
            } else {
                j = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void t() {
        Object obj = a;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    /* access modifiers changed from: private */
    public static void u(SpdySession spdySession) {
        byte[] bArr;
        int i2;
        synchronized (b) {
            while (true) {
                SpdySession spdySession2 = e;
                if (spdySession == spdySession2 && spdySession2 != null && (bArr = i) != null && bArr.length > (i2 = d)) {
                    try {
                        if (bArr.length - i2 > 131072) {
                            spdySession.sendCustomControlFrame(-1, -1, -1, 131072, yd.g(bArr, i2, 131072));
                            d += 131072;
                        } else {
                            int length = bArr.length - i2;
                            if (length > 0) {
                                spdySession.sendCustomControlFrame(-1, -1, -1, length, yd.g(bArr, i2, length));
                                d += length;
                            }
                        }
                    } catch (SpdyErrorException e2) {
                        Logger.i("TnetUtil", "SpdyErrorException", e2);
                        if (e2.SpdyErrorGetCode() != -3848) {
                            c = e2.SpdyErrorGetCode();
                            p();
                        }
                        return;
                    }
                }
            }
        }
    }

    static bc v(byte[] bArr) {
        long currentTimeMillis;
        Logger.d();
        boolean O = Variables.n().O();
        Double valueOf = Double.valueOf(1.0d);
        if (O) {
            mMonitor.onEvent(h82.a(h82.n, null, valueOf));
        }
        bc bcVar = new bc();
        synchronized (b) {
            i = bArr;
            d = 0;
            bcVar.d = (long) bArr.length;
        }
        synchronized (a) {
            ByteArrayOutputStream byteArrayOutputStream = f;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
            f = null;
            g = 0;
            h = 0;
            long currentTimeMillis2 = System.currentTimeMillis();
            c = -1;
            try {
                if (w()) {
                    if (Variables.n().O()) {
                        mMonitor.onEvent(h82.a(h82.o, null, valueOf));
                    }
                    SpdyAgent instance = SpdyAgent.getInstance(Variables.n().j(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
                    if (qm2.c().b()) {
                        instance.setAccsSslCallback(new a());
                    }
                    mm2 f2 = c.b().f();
                    String a2 = f2.a();
                    int b2 = f2.b();
                    Logger.f("TnetUtil", "host", a2, "port", Integer.valueOf(b2));
                    SessionInfo sessionInfo = new SessionInfo(a2, b2, null, null, 0, null, new b(a2), SpdyProtocol.SSSL_0RTT_CUSTOM);
                    if (qm2.c().b()) {
                        sessionInfo.setPubKeySeqNum(8);
                    } else {
                        sessionInfo.setPubKeySeqNum(9);
                    }
                    sessionInfo.setConnectionTimeoutMs(10000);
                    synchronized (b) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        e = instance.createSession(sessionInfo);
                        bcVar.b = System.currentTimeMillis() - currentTimeMillis3;
                        k = false;
                    }
                    Logger.f("TnetUtil", "createSession");
                    a.wait(DateUtils.MILLIS_PER_MINUTE);
                } else if (e == null || (j && !Variables.n().I())) {
                    p();
                } else {
                    u(e);
                    a.wait(DateUtils.MILLIS_PER_MINUTE);
                }
            } catch (Exception e2) {
                p();
                Logger.i("TnetUtil", "CreateSession Exception", e2);
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
            if (currentTimeMillis >= DateUtils.MILLIS_PER_MINUTE) {
                if (Variables.n().O()) {
                    mMonitor.onEvent(h82.a(h82.p, null, valueOf));
                }
                p();
                Logger.v("TnetUtil", "WAIT_TIMEOUT");
            }
        }
        a.m((long) d);
        synchronized (b) {
            i = null;
            d = 0;
        }
        bcVar.a = c;
        bcVar.c = currentTimeMillis;
        bcVar.e = a.a;
        a.a = null;
        Logger.f("TnetUtil", "PostData isSuccess", Boolean.valueOf(bcVar.a()), "errCode", Integer.valueOf(bcVar.a), "rt", Long.valueOf(bcVar.c));
        return bcVar;
    }

    static boolean w() {
        if (e == null) {
            return j || Variables.n().I();
        }
        return false;
    }
}
