package okhttp3.internal.connection;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.d;
import okhttp3.g;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.k;
import okhttp3.m;
import okhttp3.o;
import okhttp3.q;
import okhttp3.s;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.h;
import tb.cv2;
import tb.f21;
import tb.ly0;
import tb.oq1;
import tb.tk1;

/* compiled from: Taobao */
public final class e extends Http2Connection.b implements Connection {
    public final f a;
    private final s b;
    private Socket c;
    private Socket d;
    private k e;
    private Protocol f;
    private Http2Connection g;
    private BufferedSource h;
    private BufferedSink i;
    boolean j;
    int k;
    int l;
    private int m;
    private int n = 1;
    final List<Reference<i>> o = new ArrayList();
    long p = AbsPerformance.LONG_NIL;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends RealWebSocket.d {
        final /* synthetic */ c d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar, boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink, c cVar) {
            super(z, bufferedSource, bufferedSink);
            this.d = cVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.d.a(-1, true, true, null);
        }
    }

    public e(f fVar, s sVar) {
        this.a = fVar;
        this.b = sVar;
    }

    private void e(int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Socket socket;
        Proxy b2 = this.b.b();
        okhttp3.a a2 = this.b.a();
        if (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) {
            socket = a2.j().createSocket();
        } else {
            socket = new Socket(b2);
        }
        this.c = socket;
        eventListener.g(call, this.b.d(), b2);
        this.c.setSoTimeout(i3);
        try {
            oq1.j().h(this.c, this.b.d(), i2);
            try {
                this.h = h.d(h.m(this.c));
                this.i = h.c(h.i(this.c));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.b.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0135 A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013b A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x013e  */
    private void f(b bVar) throws IOException {
        Throwable th;
        AssertionError e2;
        Protocol protocol;
        okhttp3.a a2 = this.b.a();
        SSLSocket sSLSocket = null;
        String str = null;
        try {
            SSLSocket sSLSocket2 = (SSLSocket) a2.k().createSocket(this.c, a2.l().m(), a2.l().x(), true);
            try {
                g a3 = bVar.a(sSLSocket2);
                if (a3.f()) {
                    oq1.j().g(sSLSocket2, a2.l().m(), a2.f());
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                k b2 = k.b(session);
                if (!a2.e().verify(a2.l().m(), session)) {
                    List<Certificate> f2 = b2.f();
                    if (!f2.isEmpty()) {
                        X509Certificate x509Certificate = (X509Certificate) f2.get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + a2.l().m() + " not verified:\n    certificate: " + d.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + tk1.a(x509Certificate));
                    }
                    throw new SSLPeerUnverifiedException("Hostname " + a2.l().m() + " not verified (no certificates)");
                }
                a2.a().a(a2.l().m(), b2.f());
                if (a3.f()) {
                    str = oq1.j().m(sSLSocket2);
                }
                this.d = sSLSocket2;
                this.h = h.d(h.m(sSLSocket2));
                this.i = h.c(h.i(this.d));
                this.e = b2;
                if (str != null) {
                    protocol = Protocol.get(str);
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
                this.f = protocol;
                oq1.j().a(sSLSocket2);
            } catch (AssertionError e3) {
                e2 = e3;
                sSLSocket = sSLSocket2;
                try {
                    if (!okhttp3.internal.a.A(e2)) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sSLSocket != null) {
                        oq1.j().a(sSLSocket);
                    }
                    okhttp3.internal.a.h(sSLSocket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                }
                okhttp3.internal.a.h(sSLSocket);
                throw th;
            }
        } catch (AssertionError e4) {
            e2 = e4;
            if (!okhttp3.internal.a.A(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    private void g(int i2, int i3, int i4, Call call, EventListener eventListener) throws IOException {
        o i5 = i();
        m i6 = i5.i();
        for (int i7 = 0; i7 < 21; i7++) {
            e(i2, i3, call, eventListener);
            i5 = h(i3, i4, i5, i6);
            if (i5 != null) {
                okhttp3.internal.a.h(this.c);
                this.c = null;
                this.i = null;
                this.h = null;
                eventListener.e(call, this.b.d(), this.b.b(), null);
            } else {
                return;
            }
        }
    }

    private o h(int i2, int i3, o oVar, m mVar) throws IOException {
        String str = "CONNECT " + okhttp3.internal.a.s(mVar, true) + " HTTP/1.1";
        while (true) {
            ly0 ly0 = new ly0(null, null, this.h, this.i);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.h.timeout().timeout((long) i2, timeUnit);
            this.i.timeout().timeout((long) i3, timeUnit);
            ly0.t(oVar.e(), str);
            ly0.finishRequest();
            q c2 = ly0.readResponseHeaders(false).q(oVar).c();
            ly0.s(c2);
            int e2 = c2.e();
            if (e2 != 200) {
                if (e2 == 407) {
                    o authenticate = this.b.a().h().authenticate(this.b, c2);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(c2.g(IRequestConst.CONNECTION))) {
                        return authenticate;
                    } else {
                        oVar = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c2.e());
                }
            } else if (this.h.getBuffer().exhausted() && this.i.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private o i() throws IOException {
        o b2 = new o.a().l(this.b.a().l()).f("CONNECT", null).d(BizTime.HOST, okhttp3.internal.a.s(this.b.a().l(), true)).d("Proxy-Connection", IRequestConst.CONNECTION_VALUE).d(IRequestConst.USER_AGENT, cv2.a()).b();
        o authenticate = this.b.a().h().authenticate(this.b, new q.a().q(b2).o(Protocol.HTTP_1_1).g(407).l("Preemptive Authenticate").b(okhttp3.internal.a.EMPTY_RESPONSE).r(-1).p(-1).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return authenticate != null ? authenticate : b2;
    }

    private void j(b bVar, int i2, Call call, EventListener eventListener) throws IOException {
        if (this.b.a().k() == null) {
            List<Protocol> f2 = this.b.a().f();
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (f2.contains(protocol)) {
                this.d = this.c;
                this.f = protocol;
                r(i2);
                return;
            }
            this.d = this.c;
            this.f = Protocol.HTTP_1_1;
            return;
        }
        eventListener.y(call);
        f(bVar);
        eventListener.x(call, this.e);
        if (this.f == Protocol.HTTP_2) {
            r(i2);
        }
    }

    private boolean q(List<s> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = list.get(i2);
            if (sVar.b().type() == Proxy.Type.DIRECT && this.b.b().type() == Proxy.Type.DIRECT && this.b.d().equals(sVar.d())) {
                return true;
            }
        }
        return false;
    }

    private void r(int i2) throws IOException {
        this.d.setSoTimeout(0);
        Http2Connection a2 = new Http2Connection.a(true).d(this.d, this.b.a().l().m(), this.h, this.i).b(this).c(i2).a();
        this.g = a2;
        a2.D();
    }

    @Override // okhttp3.internal.http2.Http2Connection.b
    public void a(Http2Connection http2Connection) {
        synchronized (this.a) {
            this.n = http2Connection.r();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.b
    public void b(okhttp3.internal.http2.e eVar) throws IOException {
        eVar.d(ErrorCode.REFUSED_STREAM, null);
    }

    public void c() {
        okhttp3.internal.a.h(this.c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public void d(int i2, int i3, int i4, int i5, boolean z, Call call, EventListener eventListener) {
        IOException e2;
        if (this.f == null) {
            List<g> b2 = this.b.a().b();
            b bVar = new b(b2);
            if (this.b.a().k() == null) {
                if (b2.contains(g.CLEARTEXT)) {
                    String m2 = this.b.a().l().m();
                    if (!oq1.j().o(m2)) {
                        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + m2 + " not permitted by network security policy"));
                    }
                } else {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            } else if (this.b.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            RouteException routeException = null;
            do {
                try {
                    if (!this.b.c()) {
                        g(i2, i3, i4, call, eventListener);
                        if (this.c == null) {
                            if (!this.b.c() && this.c == null) {
                                throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                            } else if (this.g != null) {
                                synchronized (this.a) {
                                    this.n = this.g.r();
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    } else {
                        try {
                            e(i2, i3, call, eventListener);
                        } catch (IOException e3) {
                            e2 = e3;
                            okhttp3.internal.a.h(this.d);
                            okhttp3.internal.a.h(this.c);
                            this.d = null;
                            this.c = null;
                            this.h = null;
                            this.i = null;
                            this.e = null;
                            this.f = null;
                            this.g = null;
                            eventListener.f(call, this.b.d(), this.b.b(), null, e2);
                            if (routeException != null) {
                            }
                            throw routeException;
                        }
                    }
                    try {
                        j(bVar, i5, call, eventListener);
                        eventListener.e(call, this.b.d(), this.b.b(), this.f);
                        if (!this.b.c()) {
                        }
                        if (this.g != null) {
                        }
                    } catch (IOException e4) {
                        e2 = e4;
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    okhttp3.internal.a.h(this.d);
                    okhttp3.internal.a.h(this.c);
                    this.d = null;
                    this.c = null;
                    this.h = null;
                    this.i = null;
                    this.e = null;
                    this.f = null;
                    this.g = null;
                    eventListener.f(call, this.b.d(), this.b.b(), null, e2);
                    if (routeException != null) {
                        routeException = new RouteException(e2);
                    } else {
                        routeException.addConnectException(e2);
                    }
                    if (!z || bVar.b(e2)) {
                        throw routeException;
                    }
                    do {
                        if (!this.b.c()) {
                        }
                        j(bVar, i5, call, eventListener);
                        eventListener.e(call, this.b.d(), this.b.b(), this.f);
                        if (!this.b.c()) {
                        }
                        if (this.g != null) {
                        }
                    } while (bVar.b(e2));
                    throw routeException;
                }
            } while (bVar.b(e2));
            throw routeException;
        }
        throw new IllegalStateException("already connected");
    }

    @Override // okhttp3.Connection
    public k handshake() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public boolean k(okhttp3.a aVar, @Nullable List<s> list) {
        if (this.o.size() >= this.n || this.j || !f21.a.e(this.b.a(), aVar)) {
            return false;
        }
        if (aVar.l().m().equals(route().a().l().m())) {
            return true;
        }
        if (this.g == null || list == null || !q(list) || aVar.e() != tk1.INSTANCE || !s(aVar.l())) {
            return false;
        }
        try {
            aVar.a().a(aVar.l().m(), handshake().f());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean l(boolean z) {
        if (this.d.isClosed() || this.d.isInputShutdown() || this.d.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.g;
        if (http2Connection != null) {
            return http2Connection.q(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.d.getSoTimeout();
                try {
                    this.d.setSoTimeout(1);
                    if (this.h.exhausted()) {
                        this.d.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.d.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.d.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean m() {
        return this.g != null;
    }

    /* access modifiers changed from: package-private */
    public ExchangeCodec n(OkHttpClient okHttpClient, Interceptor.Chain chain) throws SocketException {
        if (this.g != null) {
            return new okhttp3.internal.http2.d(okHttpClient, this, chain, this.g);
        }
        this.d.setSoTimeout(chain.readTimeoutMillis());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.h.timeout().timeout((long) chain.readTimeoutMillis(), timeUnit);
        this.i.timeout().timeout((long) chain.writeTimeoutMillis(), timeUnit);
        return new ly0(okHttpClient, this, this.h, this.i);
    }

    /* access modifiers changed from: package-private */
    public RealWebSocket.d o(c cVar) throws SocketException {
        this.d.setSoTimeout(0);
        p();
        return new a(this, true, this.h, this.i, cVar);
    }

    public void p() {
        synchronized (this.a) {
            this.j = true;
        }
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.f;
    }

    @Override // okhttp3.Connection
    public s route() {
        return this.b;
    }

    public boolean s(m mVar) {
        if (mVar.x() != this.b.a().l().x()) {
            return false;
        }
        if (mVar.m().equals(this.b.a().l().m())) {
            return true;
        }
        if (this.e == null || !tk1.INSTANCE.c(mVar.m(), (X509Certificate) this.e.f().get(0))) {
            return false;
        }
        return true;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void t(@Nullable IOException iOException) {
        synchronized (this.a) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i2 = this.m + 1;
                    this.m = i2;
                    if (i2 > 1) {
                        this.j = true;
                        this.k++;
                    }
                } else if (errorCode != ErrorCode.CANCEL) {
                    this.j = true;
                    this.k++;
                }
            } else if (!m() || (iOException instanceof ConnectionShutdownException)) {
                this.j = true;
                if (this.l == 0) {
                    if (iOException != null) {
                        this.a.c(this.b, iOException);
                    }
                    this.k++;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.b.a().l().m());
        sb.append(":");
        sb.append(this.b.a().l().x());
        sb.append(", proxy=");
        sb.append(this.b.b());
        sb.append(" hostAddress=");
        sb.append(this.b.d());
        sb.append(" cipherSuite=");
        k kVar = this.e;
        sb.append(kVar != null ? kVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f);
        sb.append('}');
        return sb.toString();
    }
}
