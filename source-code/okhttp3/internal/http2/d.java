package okhttp3.internal.http2;

import com.taobao.login4android.constants.LoginConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.a;
import okhttp3.internal.connection.e;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.l;
import okhttp3.o;
import okhttp3.q;
import okio.Sink;
import okio.Source;
import tb.f02;
import tb.f21;
import tb.qy0;

/* compiled from: Taobao */
public final class d implements ExchangeCodec {
    private static final List<String> g = a.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", LoginConstants.LOGIN_UPGRADE, a.TARGET_METHOD_UTF8, a.TARGET_PATH_UTF8, a.TARGET_SCHEME_UTF8, a.TARGET_AUTHORITY_UTF8);
    private static final List<String> h = a.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", LoginConstants.LOGIN_UPGRADE);
    private final Interceptor.Chain a;
    private final e b;
    private final Http2Connection c;
    private volatile e d;
    private final Protocol e;
    private volatile boolean f;

    public d(OkHttpClient okHttpClient, e eVar, Interceptor.Chain chain, Http2Connection http2Connection) {
        this.b = eVar;
        this.a = chain;
        this.c = http2Connection;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.e = !protocols.contains(protocol) ? Protocol.HTTP_2 : protocol;
    }

    public static List<a> a(o oVar) {
        l e2 = oVar.e();
        ArrayList arrayList = new ArrayList(e2.h() + 4);
        arrayList.add(new a(a.TARGET_METHOD, oVar.g()));
        arrayList.add(new a(a.TARGET_PATH, f02.c(oVar.i())));
        String c2 = oVar.c(BizTime.HOST);
        if (c2 != null) {
            arrayList.add(new a(a.TARGET_AUTHORITY, c2));
        }
        arrayList.add(new a(a.TARGET_SCHEME, oVar.i().C()));
        int h2 = e2.h();
        for (int i = 0; i < h2; i++) {
            String lowerCase = e2.e(i).toLowerCase(Locale.US);
            if (!g.contains(lowerCase) || (lowerCase.equals("te") && e2.j(i).equals("trailers"))) {
                arrayList.add(new a(lowerCase, e2.j(i)));
            }
        }
        return arrayList;
    }

    public static q.a b(l lVar, Protocol protocol) throws IOException {
        l.a aVar = new l.a();
        int h2 = lVar.h();
        okhttp3.internal.http.e eVar = null;
        for (int i = 0; i < h2; i++) {
            String e2 = lVar.e(i);
            String j = lVar.j(i);
            if (e2.equals(a.RESPONSE_STATUS_UTF8)) {
                eVar = okhttp3.internal.http.e.a("HTTP/1.1 " + j);
            } else if (!h.contains(e2)) {
                f21.a.b(aVar, e2, j);
            }
        }
        if (eVar != null) {
            return new q.a().o(protocol).g(eVar.b).l(eVar.c).j(aVar.e());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.f = true;
        if (this.d != null) {
            this.d.f(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public e connection() {
        return this.b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(o oVar, long j) {
        return this.d.h();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.d.h().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.c.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(q qVar) {
        return this.d.i();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public q.a readResponseHeaders(boolean z) throws IOException {
        q.a b2 = b(this.d.p(), this.e);
        if (!z || f21.a.d(b2) != 100) {
            return b2;
        }
        return null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(q qVar) {
        return qy0.b(qVar);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public l trailers() throws IOException {
        return this.d.q();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(o oVar) throws IOException {
        if (this.d == null) {
            this.d = this.c.t(a(oVar), oVar.a() != null);
            if (!this.f) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                this.d.l().timeout((long) this.a.readTimeoutMillis(), timeUnit);
                this.d.s().timeout((long) this.a.writeTimeoutMillis(), timeUnit);
                return;
            }
            this.d.f(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
    }
}
