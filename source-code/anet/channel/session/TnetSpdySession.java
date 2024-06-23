package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.detect.NetworkDetector;
import anet.channel.entity.ConnType;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.heartbeat.SelfKillHeartbeatImpl;
import anet.channel.request.Cancelable;
import anet.channel.security.ISecurity;
import anet.channel.statist.CustomFrameStat;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.weex.annotation.JSMethod;
import com.youku.live.livesdk.preloader.Preloader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.network.util.Constants;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import tb.a92;
import tb.fe0;
import tb.gm;
import tb.h9;
import tb.hm;
import tb.i70;
import tb.ju2;
import tb.km2;
import tb.pd;
import tb.rd;
import tb.ry0;
import tb.ss0;
import tb.ue0;
import tb.w6;

/* compiled from: Taobao */
public class TnetSpdySession extends Session implements SessionCb {
    protected SpdyAgent B;
    protected SpdySession C;
    protected volatile boolean D = false;
    protected long E;
    protected long F = 0;
    private int G = 0;
    protected int H = -1;
    protected DataFrameCb I = null;
    protected IHeartbeat J = null;
    protected IAuth K = null;
    protected String L = null;
    protected ISecurity M = null;
    private boolean N = false;
    private boolean O;
    private volatile boolean P = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements IAuth.AuthCallback {
        a() {
        }

        @Override // anet.channel.IAuth.AuthCallback
        public void onAuthFail(int i, String str) {
            TnetSpdySession.this.r(5, null);
            SessionStatistic sessionStatistic = TnetSpdySession.this.s;
            if (sessionStatistic != null) {
                sessionStatistic.closeReason = "Accs_Auth_Fail:" + i;
                TnetSpdySession.this.s.errorCode = (long) i;
            }
            TnetSpdySession.this.b();
        }

        @Override // anet.channel.IAuth.AuthCallback
        public void onAuthSuccess() {
            TnetSpdySession tnetSpdySession = TnetSpdySession.this;
            SessionStatistic sessionStatistic = tnetSpdySession.s;
            sessionStatistic.ret = 1;
            ALog.c("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession.r, "authTime", Long.valueOf(sessionStatistic.authTime));
            TnetSpdySession tnetSpdySession2 = TnetSpdySession.this;
            if (tnetSpdySession2.F > 0) {
                tnetSpdySession2.s.authTime = System.currentTimeMillis() - TnetSpdySession.this.F;
            }
            TnetSpdySession.this.r(4, null);
            TnetSpdySession.this.E = System.currentTimeMillis();
            TnetSpdySession tnetSpdySession3 = TnetSpdySession.this;
            IHeartbeat iHeartbeat = tnetSpdySession3.J;
            if (iHeartbeat != null) {
                iHeartbeat.start(tnetSpdySession3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements AccsSSLCallback {
        b() {
        }

        @Override // org.android.spdy.AccsSSLCallback
        public byte[] getSSLPublicKey(int i, byte[] bArr) {
            byte[] bArr2;
            Throwable th;
            try {
                TnetSpdySession tnetSpdySession = TnetSpdySession.this;
                bArr2 = tnetSpdySession.M.decrypt(((Session) tnetSpdySession).a, ISecurity.CIPHER_ALGORITHM_AES128, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
                if (bArr2 != null) {
                    try {
                        if (ALog.g(2)) {
                            ALog.f("getSSLPublicKey", null, "decrypt", new String(bArr2));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        ALog.d("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
                        return bArr2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bArr2 = null;
                ALog.d("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
                return bArr2;
            }
            return bArr2;
        }
    }

    /* compiled from: Taobao */
    private class c extends i70 {
        private anet.channel.request.a a;
        private RequestCb b;
        private int c = 0;
        private long d = 0;

        public c(anet.channel.request.a aVar, RequestCb requestCb) {
            this.a = aVar;
            this.b = requestCb;
        }

        private void a(SuperviseData superviseData, int i, String str) {
            try {
                this.a.r.rspEnd = System.currentTimeMillis();
                anet.channel.fulltrace.a.f().log(this.a.r.span, "netRspRecvEnd", null);
                if (!this.a.r.isDone.get()) {
                    if (i > 0) {
                        this.a.r.ret = 1;
                        TnetSpdySession.this.P = true;
                    }
                    this.a.r.statusCode = i;
                    this.a.r.msg = str;
                    if (superviseData != null) {
                        this.a.r.rspEnd = superviseData.responseEnd;
                        this.a.r.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                        RequestStatistic requestStatistic = this.a.r;
                        requestStatistic.sendDataTime = superviseData.sendEnd - requestStatistic.sendStart;
                        this.a.r.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                        this.a.r.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                        this.a.r.sendDataSize = (long) (superviseData.bodySize + superviseData.compressSize);
                        this.a.r.recDataSize = this.d + ((long) superviseData.recvUncompressSize);
                        this.a.r.reqHeadInflateSize = (long) superviseData.uncompressSize;
                        this.a.r.reqHeadDeflateSize = (long) superviseData.compressSize;
                        this.a.r.reqBodyInflateSize = (long) superviseData.bodySize;
                        this.a.r.reqBodyDeflateSize = (long) superviseData.bodySize;
                        this.a.r.rspHeadDeflateSize = (long) superviseData.recvCompressSize;
                        this.a.r.rspHeadInflateSize = (long) superviseData.recvUncompressSize;
                        this.a.r.rspBodyDeflateSize = (long) superviseData.recvBodySize;
                        this.a.r.rspBodyInflateSize = this.d;
                        if (this.a.r.contentLength == 0) {
                            this.a.r.contentLength = (long) superviseData.originContentLength;
                        }
                        SessionStatistic sessionStatistic = TnetSpdySession.this.s;
                        sessionStatistic.recvSizeCount += (long) (superviseData.recvBodySize + superviseData.recvCompressSize);
                        sessionStatistic.sendSizeCount += (long) (superviseData.bodySize + superviseData.compressSize);
                        ALog.e("awcn.TnetSpdySession", "[setStatisticData]", this.a.n(), "tnetStat", superviseData.superviseDataToString(), Preloader.KEY_SESSION, TnetSpdySession.this.r);
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // org.android.spdy.Spdycb
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.g(1)) {
                ALog.c("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.a.n(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z));
            }
            this.d += (long) spdyByteArray.getDataLength();
            this.a.r.recDataSize += (long) spdyByteArray.getDataLength();
            this.a.r.lastRecvDataTime = System.currentTimeMillis() - this.a.r.sendStart;
            IHeartbeat iHeartbeat = TnetSpdySession.this.J;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.b != null) {
                pd d2 = rd.a().d(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.b.onDataReceive(d2, z);
            }
            TnetSpdySession.this.n(32, null);
        }

        @Override // org.android.spdy.Spdycb
        public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
            this.a.r.firstDataTime = System.currentTimeMillis() - this.a.r.sendStart;
            this.c = ry0.i(map);
            TnetSpdySession.this.G = 0;
            ALog.f("awcn.TnetSpdySession", "", this.a.n(), HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(this.c));
            ALog.f("awcn.TnetSpdySession", "", this.a.n(), "response headers", map);
            RequestCb requestCb = this.b;
            if (requestCb != null) {
                requestCb.onResponseCode(this.c, ry0.b(map));
            }
            TnetSpdySession.this.n(16, null);
            this.a.r.contentEncoding = ry0.d(map, Constants.Protocol.CONTENT_ENCODING);
            this.a.r.contentType = ry0.d(map, "Content-Type");
            this.a.r.contentLength = (long) ry0.f(map);
            this.a.r.serverRT = ry0.h(map);
            this.a.r.eagleEyeId = ry0.g(map);
            this.a.r.isHitCache = ry0.e(map);
            TnetSpdySession.this.o(this.a, this.c);
            TnetSpdySession.this.p(this.a, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.J;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // org.android.spdy.Spdycb
        public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
            String str;
            if (ALog.g(1)) {
                ALog.c("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.a.n(), "streamId", Long.valueOf(j), "errorCode", Integer.valueOf(i));
            }
            if (i != 0) {
                this.c = fe0.ERROR_TNET_REQUEST_FAIL;
                str = fe0.a(fe0.ERROR_TNET_REQUEST_FAIL, String.valueOf(i));
                if (i != -2005) {
                    w6.b().commitStat(new ExceptionStatistic(-300, str, this.a.r, null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.a.n(), Preloader.KEY_SESSION, TnetSpdySession.this.r, "status code", Integer.valueOf(i), "URL", this.a.j().l());
            } else {
                str = "SUCCESS";
            }
            this.a.r.tnetErrorCode = i;
            a(superviseData, this.c, str);
            RequestCb requestCb = this.b;
            if (requestCb != null) {
                requestCb.onFinish(this.c, str, this.a.r);
            }
            if (i == -2004) {
                if (!TnetSpdySession.this.D) {
                    TnetSpdySession.this.t(true);
                }
                if (TnetSpdySession.N(TnetSpdySession.this) >= 2) {
                    gm gmVar = new gm();
                    gmVar.a = false;
                    gmVar.b = TnetSpdySession.this.N;
                    anet.channel.strategy.a.a().notifyConnEvent(((Session) TnetSpdySession.this).e, ((Session) TnetSpdySession.this).l, gmVar);
                    TnetSpdySession.this.c(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, hm hmVar) {
        super(context, hmVar);
    }

    static /* synthetic */ int N(TnetSpdySession tnetSpdySession) {
        int i = tnetSpdySession.G + 1;
        tnetSpdySession.G = i;
        return i;
    }

    private void S() {
        SpdyAgent.enableDebug = false;
        this.B = SpdyAgent.getInstance(this.a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.M;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.B.setAccsSslCallback(new b());
        }
        if (!h9.Q()) {
            try {
                this.B.getClass().getDeclaredMethod("disableHeaderCache", new Class[0]).invoke(this.B, new Object[0]);
                ALog.f("awcn.TnetSpdySession", "tnet disableHeaderCache", null, new Object[0]);
            } catch (Exception e) {
                ALog.d("awcn.TnetSpdySession", "tnet disableHeaderCache", null, e, new Object[0]);
            }
        }
    }

    private void T(int i, int i2, boolean z, String str) {
        DataFrameCb dataFrameCb = this.I;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i, i2, z, str);
        }
    }

    /* access modifiers changed from: protected */
    public void P() {
        IAuth iAuth = this.K;
        if (iAuth != null) {
            iAuth.auth(this, new a());
            return;
        }
        r(4, null);
        this.s.ret = 1;
        IHeartbeat iHeartbeat = this.J;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    public void Q(anet.channel.a aVar) {
        if (aVar != null) {
            this.L = aVar.i();
            this.M = aVar.m();
        }
    }

    public void R(a92 a92) {
        if (a92 != null) {
            this.I = a92.f;
            this.K = a92.d;
            if (a92.b) {
                this.s.isKL = 1;
                this.v = true;
                IHeartbeat iHeartbeat = a92.e;
                this.J = iHeartbeat;
                boolean z = a92.c;
                this.N = z;
                if (iHeartbeat == null) {
                    if (!z || h9.i()) {
                        this.J = anet.channel.heartbeat.a.b();
                    } else {
                        this.J = anet.channel.heartbeat.a.a();
                    }
                }
            }
        }
        if (h9.x() && this.J == null) {
            this.J = new SelfKillHeartbeatImpl();
        }
    }

    public void U(int i) {
        this.H = i;
    }

    @Override // anet.channel.Session
    public void b() {
        ALog.e("awcn.TnetSpdySession", "force close!", this.r, Preloader.KEY_SESSION, this);
        r(7, null);
        try {
            IHeartbeat iHeartbeat = this.J;
            if (iHeartbeat != null) {
                iHeartbeat.stop();
                this.J = null;
            }
            SpdySession spdySession = this.C;
            if (spdySession != null) {
                spdySession.closeSession();
            }
        } catch (Exception unused) {
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i) {
    }

    @Override // anet.channel.Session
    public void e() {
        ue0 ue0;
        Throwable th;
        int e;
        int i = this.o;
        int i2 = 1;
        if (i != 1 && i != 0 && i != 4) {
            try {
                if (this.B == null) {
                    S();
                }
                if (h9.k() && Inet64Util.p() && ju2.c(this.f)) {
                    try {
                        this.g = Inet64Util.e(this.f);
                    } catch (Exception unused) {
                    }
                }
                String valueOf = String.valueOf(System.currentTimeMillis());
                ALog.e("awcn.TnetSpdySession", "connect", this.r, "host", this.d, TbAuthConstants.IP, this.g, "port", Integer.valueOf(this.h), "sessionId", valueOf, "SpdyProtocol,", this.k, "proxyIp,", this.i, "proxyPort,", Integer.valueOf(this.j));
                String str = this.g;
                int i3 = this.h;
                SessionInfo sessionInfo = new SessionInfo(str, i3, this.d + JSMethod.NOT_SET + this.L, this.i, this.j, valueOf, this, this.k.c());
                sessionInfo.setConnectionTimeoutMs((int) (((float) this.t) * anet.channel.util.c.f()));
                int b2 = NetworkDetector.b();
                try {
                    if (h9.G() && b2 > 0 && b2 < 1460 && NetworkStatusHelper.i().isWifi()) {
                        sessionInfo.setMss(b2);
                        this.s.mss = b2;
                        ALog.e("awcn.TnetSpdySession", "connect", this.r, "setMss", Integer.valueOf(b2));
                    }
                } catch (Exception unused2) {
                }
                if (this.k.j() || this.k.g() || this.k.h()) {
                    sessionInfo.setCertHost(this.n ? this.f : this.e);
                } else {
                    int i4 = this.H;
                    if (i4 >= 0) {
                        sessionInfo.setPubKeySeqNum(i4);
                    } else {
                        ConnType connType = this.k;
                        ISecurity iSecurity = this.M;
                        int d = connType.d(iSecurity != null ? iSecurity.isSecOff() : true);
                        this.H = d;
                        sessionInfo.setPubKeySeqNum(d);
                    }
                }
                if (this.k.h() && (e = h9.e()) >= 0) {
                    sessionInfo.setXquicCongControl(e);
                }
                SpdySession createSession = this.B.createSession(sessionInfo);
                this.C = createSession;
                if (createSession.getRefCount() > 1) {
                    ALog.e("awcn.TnetSpdySession", "get session ref count > 1!!!", this.r, new Object[0]);
                    this.A = true;
                    r(0, new ue0(1));
                    P();
                    return;
                }
                ue0 = null;
                try {
                    r(1, null);
                    this.E = System.currentTimeMillis();
                    SessionStatistic sessionStatistic = this.s;
                    if (TextUtils.isEmpty(this.i)) {
                        i2 = 0;
                    }
                    sessionStatistic.isProxy = i2;
                    SessionStatistic sessionStatistic2 = this.s;
                    sessionStatistic2.isTunnel = "false";
                    sessionStatistic2.isBackground = ss0.i();
                    this.F = 0;
                } catch (Throwable th2) {
                    th = th2;
                    r(2, ue0);
                    ALog.d("awcn.TnetSpdySession", "connect exception ", this.r, th, new Object[0]);
                }
            } catch (Throwable th3) {
                th = th3;
                ue0 = null;
                r(2, ue0);
                ALog.d("awcn.TnetSpdySession", "connect exception ", this.r, th, new Object[0]);
            }
        }
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = null;
        if (TextUtils.isEmpty(domain)) {
            ALog.f("awcn.TnetSpdySession", "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            ISecurity iSecurity = this.M;
            if (iSecurity != null) {
                Context context = this.a;
                bArr = iSecurity.getBytes(context, "accs_ssl_key2_" + domain);
            }
        } catch (Throwable th) {
            ALog.d("awcn.TnetSpdySession", "getSSLMeta", null, th, new Object[0]);
        }
        if (bArr != null && bArr.length > 0) {
            this.s.isHitTicket = 1;
        }
        this.s.ticketTime = System.currentTimeMillis() - currentTimeMillis;
        return bArr;
    }

    /* access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable l() {
        return new Runnable() {
            /* class anet.channel.session.TnetSpdySession.AnonymousClass1 */

            public void run() {
                if (TnetSpdySession.this.D) {
                    TnetSpdySession tnetSpdySession = TnetSpdySession.this;
                    ALog.e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.r, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.D));
                    try {
                        TnetSpdySession.this.n(2048, null);
                        SessionStatistic sessionStatistic = TnetSpdySession.this.s;
                        if (sessionStatistic != null) {
                            sessionStatistic.closeReason = "ping time out";
                        }
                        gm gmVar = new gm();
                        gmVar.a = false;
                        gmVar.b = TnetSpdySession.this.N;
                        anet.channel.strategy.a.a().notifyConnEvent(((Session) TnetSpdySession.this).e, ((Session) TnetSpdySession.this).l, gmVar);
                        TnetSpdySession.this.c(true);
                    } catch (Exception unused) {
                    }
                }
            }
        };
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            ISecurity iSecurity = this.M;
            if (iSecurity == null) {
                return -1;
            }
            Context context = this.a;
            if (iSecurity.saveBytes(context, "accs_ssl_key2_" + domain, bArr)) {
                return 0;
            }
            return -1;
        } catch (Throwable th) {
            ALog.d("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
            return -1;
        }
    }

    @Override // anet.channel.Session
    public boolean q() {
        return this.o == 4;
    }

    /* access modifiers changed from: protected */
    @Override // anet.channel.Session
    public void s() {
        this.D = false;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        ALog.e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.r, com.taobao.accs.common.Constants.KEY_DATA_ID, Integer.valueOf(i));
        T(i, i2, true, "tnet error");
        CustomFrameStat customFrameStat = new CustomFrameStat();
        customFrameStat.host = this.e;
        customFrameStat.isAccs = this.N;
        customFrameStat.errCode = i2;
        customFrameStat.ret = 0;
        w6.b().commitStat(customFrameStat);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        ALog.e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.r, "len", Integer.valueOf(i4), "frameCb", this.I);
        if (ALog.g(1) && i4 < 512) {
            String str = "";
            for (int i5 = 0; i5 < bArr.length; i5++) {
                str = str + Integer.toHexString(bArr[i5] & 255) + " ";
            }
            ALog.e("awcn.TnetSpdySession", null, this.r, "str", str);
        }
        DataFrameCb dataFrameCb = this.I;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i, i2);
        } else {
            ALog.e("awcn.TnetSpdySession", "AccsFrameCb is null", this.r, new Object[0]);
            w6.b().commitStat(new ExceptionStatistic(-105, null, "rt"));
        }
        this.s.inceptCount++;
        IHeartbeat iHeartbeat = this.J;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        if (ALog.g(2)) {
            ALog.f("awcn.TnetSpdySession", "ping receive", this.r, BizTime.HOST, this.d, "id", Long.valueOf(j));
        }
        if (j >= 0) {
            this.D = false;
            this.G = 0;
            IHeartbeat iHeartbeat = this.J;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            n(128, null);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        ALog.e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.r, " errorCode:", Integer.valueOf(i));
        IHeartbeat iHeartbeat = this.J;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.J = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.d("awcn.TnetSpdySession", "session clean up failed!", null, e, new Object[0]);
            }
        }
        if (i == -3516 || i == -5004) {
            gm gmVar = new gm();
            gmVar.a = false;
            anet.channel.strategy.a.a().notifyConnEvent(this.e, this.l, gmVar);
        }
        r(6, new ue0(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.s;
            sessionStatistic.requestCount = (long) superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = (long) superviseConnectInfo.keepalive_period_second;
            try {
                if (this.k.h()) {
                    SessionStatistic sessionStatistic2 = this.s;
                    sessionStatistic2.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    sessionStatistic2.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    sessionStatistic2.lossRate = superviseConnectInfo.lossRate;
                    sessionStatistic2.tlpCount = superviseConnectInfo.tlpCount;
                    sessionStatistic2.rtoCount = superviseConnectInfo.rtoCount;
                    sessionStatistic2.srtt = superviseConnectInfo.srtt;
                }
                if (spdySession != null) {
                    ALog.e("awcn.TnetSpdySession", "[spdySessionCloseCallback]", this.r, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic3 = this.s;
        if (sessionStatistic3.errorCode == 0) {
            sessionStatistic3.errorCode = (long) i;
        }
        sessionStatistic3.lastPingInterval = (int) (System.currentTimeMillis() - this.E);
        w6.b().commitStat(this.s);
        if (ju2.d(this.s.ip)) {
            w6.b().commitStat(new SessionMonitor(this.s));
        }
        w6.b().commitAlarm(this.s.getAlarmObject());
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.s;
        sessionStatistic.connectionTime = (long) superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = (long) superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = (long) superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.e();
        this.F = System.currentTimeMillis();
        if (this.k.h()) {
            SessionStatistic sessionStatistic2 = this.s;
            sessionStatistic2.scid = superviseConnectInfo.scid;
            sessionStatistic2.dcid = superviseConnectInfo.dcid;
            sessionStatistic2.congControlKind = superviseConnectInfo.congControlKind;
            this.O = spdySession.isQuicTry0RTT();
            ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.r, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
        r(0, new ue0(1));
        P();
        ALog.e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.r, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.d("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", null, e, new Object[0]);
            }
        }
        r(2, new ue0(256, i, "tnet connect fail"));
        ALog.e("awcn.TnetSpdySession", null, this.r, " errorId:", Integer.valueOf(i));
        SessionStatistic sessionStatistic = this.s;
        sessionStatistic.errorCode = (long) i;
        sessionStatistic.ret = 0;
        if (!sessionStatistic.isReported) {
            sessionStatistic.ret = 2;
        }
        sessionStatistic.netType = NetworkStatusHelper.e();
        w6.b().commitStat(this.s);
        if (ju2.d(this.s.ip)) {
            w6.b().commitStat(new SessionMonitor(this.s));
        }
        w6.b().commitAlarm(this.s.getAlarmObject());
    }

    @Override // anet.channel.Session
    public void t(boolean z) {
        u(z, this.u);
    }

    @Override // anet.channel.Session
    public void u(boolean z, int i) {
        if (ALog.g(1)) {
            ALog.c("awcn.TnetSpdySession", "ping", this.r, "host", this.d, "thread", Thread.currentThread().getName());
        }
        if (z) {
            try {
                if (this.C != null) {
                    int i2 = this.o;
                    if (i2 == 0 || i2 == 4) {
                        n(64, null);
                        if (!this.D) {
                            this.D = true;
                            this.s.ppkgCount++;
                            this.C.submitPing();
                            if (ALog.g(1)) {
                                ALog.c("awcn.TnetSpdySession", this.d + " submit ping ms:" + (System.currentTimeMillis() - this.E) + " force:" + z, this.r, new Object[0]);
                            }
                            y(i);
                            this.E = System.currentTimeMillis();
                            IHeartbeat iHeartbeat = this.J;
                            if (iHeartbeat != null) {
                                iHeartbeat.reSchedule();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                SessionStatistic sessionStatistic = this.s;
                if (sessionStatistic != null) {
                    sessionStatistic.closeReason = "session null";
                }
                ALog.e("awcn.TnetSpdySession", this.d + " session null", this.r, new Object[0]);
                b();
            } catch (SpdyErrorException e) {
                if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.r, new Object[0]);
                    r(6, new ue0(2));
                }
                ALog.d("awcn.TnetSpdySession", "ping", this.r, e, new Object[0]);
            } catch (Exception e2) {
                ALog.d("awcn.TnetSpdySession", "ping", this.r, e2, new Object[0]);
            }
        }
    }

    @Override // anet.channel.Session
    public Cancelable w(anet.channel.request.a aVar, RequestCb requestCb) {
        SpdyErrorException e;
        Exception e2;
        int i;
        String str;
        SpdyRequest spdyRequest;
        boolean z;
        km2 km2 = km2.NULL;
        RequestStatistic requestStatistic = aVar != null ? aVar.r : new RequestStatistic(this.e, null);
        requestStatistic.setConnType(this.k);
        if (requestStatistic.start == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = currentTimeMillis;
            requestStatistic.start = currentTimeMillis;
        }
        requestStatistic.setIPAndPort(this.g, this.h);
        requestStatistic.ipRefer = this.l.getIpSource();
        requestStatistic.ipType = this.l.getIpType();
        requestStatistic.unit = this.m;
        if (this.k.h()) {
            requestStatistic.cid = this.s.scid + "|" + this.s.dcid;
        }
        SessionStatistic sessionStatistic = this.s;
        requestStatistic.xqcConnEnv = sessionStatistic.xqcConnEnv;
        requestStatistic.isComplex = sessionStatistic.isComplex;
        if (aVar == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, fe0.b(-102), requestStatistic);
            }
            return km2;
        }
        try {
            if (this.C == null || !((i = this.o) == 0 || i == 4)) {
                requestCb.onFinish(fe0.ERROR_SESSION_INVALID, fe0.b(fe0.ERROR_SESSION_INVALID), aVar.r);
                return km2;
            }
            if (this.n) {
                aVar.w(this.f, this.h);
            }
            aVar.x(this.k.k());
            URL p = aVar.p();
            if (ALog.g(2)) {
                ALog.f("awcn.TnetSpdySession", "", aVar.n(), "request URL", p.toString());
                ALog.f("awcn.TnetSpdySession", "", aVar.n(), "request Method", aVar.k());
                ALog.f("awcn.TnetSpdySession", "", aVar.n(), "request headers", aVar.g());
            }
            if (TextUtils.isEmpty(this.i) || this.j <= 0) {
                str = "";
                z = true;
                spdyRequest = new SpdyRequest(p, aVar.k(), RequestPriority.DEFAULT_PRIORITY, -1, aVar.e());
            } else {
                z = true;
                str = "";
                spdyRequest = new SpdyRequest(p, p.getHost(), p.getPort(), this.i, this.j, aVar.k(), RequestPriority.DEFAULT_PRIORITY, -1, aVar.e(), 0);
            }
            if (!h9.g() || !this.O || requestStatistic.maxRetryTime <= 0 || this.P) {
                spdyRequest.setRequestRdTimeoutMs(aVar.l());
            } else {
                spdyRequest.setRequestRdTimeoutMs(3000);
                requestStatistic.is0RttOptimize = z;
            }
            Map<String, String> g = aVar.g();
            if (!g.containsKey(BizTime.HOST)) {
                spdyRequest.addHeaders(g);
                spdyRequest.addHeader(":host", this.n ? this.f : aVar.h());
            } else {
                HashMap hashMap = new HashMap(aVar.g());
                String remove = hashMap.remove(BizTime.HOST);
                if (this.n) {
                    remove = this.f;
                }
                hashMap.put(":host", remove);
                spdyRequest.addHeaders(hashMap);
            }
            SpdyDataProvider spdyDataProvider = new SpdyDataProvider(aVar.d());
            aVar.r.sendStart = System.currentTimeMillis();
            anet.channel.fulltrace.a.f().log(aVar.r.span, "netReqSendStart", "type=TnetSpdySession");
            RequestStatistic requestStatistic2 = aVar.r;
            requestStatistic2.processTime = requestStatistic2.sendStart - aVar.r.start;
            int submitRequest = this.C.submitRequest(spdyRequest, spdyDataProvider, this, new c(aVar, requestCb));
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            if (ALog.g(i2)) {
                String n = aVar.n();
                Object[] objArr = new Object[2];
                objArr[0] = "streamId";
                Integer valueOf = Integer.valueOf(submitRequest);
                char c2 = z ? 1 : 0;
                char c3 = z ? 1 : 0;
                char c4 = z ? 1 : 0;
                objArr[c2] = valueOf;
                ALog.c("awcn.TnetSpdySession", str, n, objArr);
            }
            km2 km22 = new km2(this.C, submitRequest, aVar.n());
            try {
                SessionStatistic sessionStatistic2 = this.s;
                sessionStatistic2.requestCount++;
                sessionStatistic2.stdRCount++;
                this.E = System.currentTimeMillis();
                IHeartbeat iHeartbeat = this.J;
                if (iHeartbeat != null) {
                    iHeartbeat.reSchedule();
                }
                return km22;
            } catch (SpdyErrorException e3) {
                e = e3;
                km2 = km22;
                if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.r, new Object[0]);
                    r(6, new ue0(2));
                }
                requestCb.onFinish(-300, fe0.a(-300, String.valueOf(e.SpdyErrorGetCode())), requestStatistic);
                return km2;
            } catch (Exception e4) {
                e2 = e4;
                km2 = km22;
                ALog.d("awcn.TnetSpdySession", "send request error.", this.r, e2, new Object[0]);
                requestCb.onFinish(-101, fe0.b(-101), requestStatistic);
                return km2;
            }
        } catch (SpdyErrorException e5) {
            e = e5;
            ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.r, new Object[0]);
            r(6, new ue0(2));
            requestCb.onFinish(-300, fe0.a(-300, String.valueOf(e.SpdyErrorGetCode())), requestStatistic);
            return km2;
        } catch (Exception e6) {
            e2 = e6;
            ALog.d("awcn.TnetSpdySession", "send request error.", this.r, e2, new Object[0]);
            requestCb.onFinish(-101, fe0.b(-101), requestStatistic);
            return km2;
        }
    }

    @Override // anet.channel.Session
    public void x(int i, byte[] bArr, int i2) {
        SpdySession spdySession;
        int i3;
        CustomFrameStat customFrameStat = new CustomFrameStat();
        customFrameStat.host = this.e;
        customFrameStat.isAccs = this.N;
        try {
            if (this.I == null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame error dataFrameCb is null", this.r, new Object[0]);
                customFrameStat.errCode = -1;
                w6.b().commitStat(customFrameStat);
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.r, com.taobao.accs.common.Constants.KEY_DATA_ID, Integer.valueOf(i), "type", Integer.valueOf(i2));
            if (this.o != 4 || (spdySession = this.C) == null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.r, "sendCustomFrame con invalid mStatus:" + this.o);
                customFrameStat.errCode = -3;
                T(i, fe0.ERROR_SESSION_INVALID, true, "session invalid");
                w6.b().commitStat(customFrameStat);
            } else if (bArr == null || bArr.length <= 16384) {
                if (bArr == null) {
                    i3 = 0;
                } else {
                    i3 = bArr.length;
                }
                spdySession.sendCustomControlFrame(i, i2, 0, i3, bArr);
                SessionStatistic sessionStatistic = this.s;
                sessionStatistic.requestCount++;
                sessionStatistic.cfRCount++;
                this.E = System.currentTimeMillis();
                customFrameStat.ret = 1;
                w6.b().commitStat(customFrameStat);
            } else {
                customFrameStat.errCode = -2;
                T(i, fe0.ERROR_DATA_TOO_LARGE, false, null);
                w6.b().commitStat(customFrameStat);
            }
        } catch (SpdyErrorException e) {
            ALog.d("awcn.TnetSpdySession", "sendCustomFrame error", this.r, e, new Object[0]);
            T(i, -300, true, "SpdyErrorException: " + e.toString());
            customFrameStat.errCode = e.SpdyErrorGetCode();
            if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                r(6, new ue0(2));
            }
        } catch (Exception e2) {
            ALog.d("awcn.TnetSpdySession", "sendCustomFrame error", this.r, e2, new Object[0]);
            customFrameStat.errCode = -4;
            T(i, -101, true, e2.toString());
        } catch (Throwable th) {
            w6.b().commitStat(customFrameStat);
            throw th;
        }
    }
}
