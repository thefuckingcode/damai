package okhttp3.internal.http;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.internal.a;
import okhttp3.internal.connection.c;
import okhttp3.o;
import okhttp3.q;
import okio.BufferedSink;
import okio.h;
import tb.ty0;

/* compiled from: Taobao */
public final class b implements Interceptor {
    private final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    @Override // okhttp3.Interceptor
    public q intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        q qVar;
        c cVar = (c) chain;
        c a2 = cVar.a();
        o request = cVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        a2.r(request);
        q.a aVar = null;
        if (!ty0.b(request.g()) || request.a() == null) {
            a2.k();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(request.c("Expect"))) {
                a2.g();
                a2.o();
                aVar = a2.m(true);
                z = true;
            } else {
                z = false;
            }
            if (aVar != null) {
                a2.k();
                if (!a2.c().m()) {
                    a2.j();
                }
            } else if (request.a().f()) {
                a2.g();
                request.a().h(h.c(a2.d(request, true)));
            } else {
                BufferedSink c = h.c(a2.d(request, false));
                request.a().h(c);
                c.close();
            }
        }
        if (request.a() == null || !request.a().f()) {
            a2.f();
        }
        if (!z) {
            a2.o();
        }
        if (aVar == null) {
            aVar = a2.m(false);
        }
        q c2 = aVar.q(request).h(a2.c().handshake()).r(currentTimeMillis).p(System.currentTimeMillis()).c();
        int e = c2.e();
        if (e == 100) {
            c2 = a2.m(false).q(request).h(a2.c().handshake()).r(currentTimeMillis).p(System.currentTimeMillis()).c();
            e = c2.e();
        }
        a2.n(c2);
        if (!this.a || e != 101) {
            qVar = c2.m().b(a2.l(c2)).c();
        } else {
            qVar = c2.m().b(a.EMPTY_RESPONSE).c();
        }
        if ("close".equalsIgnoreCase(qVar.q().c(IRequestConst.CONNECTION)) || "close".equalsIgnoreCase(qVar.g(IRequestConst.CONNECTION))) {
            a2.j();
        }
        if ((e != 204 && e != 205) || qVar.a().f() <= 0) {
            return qVar;
        }
        throw new ProtocolException("HTTP " + e + " had non-zero Content-Length: " + qVar.a().f());
    }
}
