package okhttp3.internal.http;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.util.List;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.network.util.Constants;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.o;
import okhttp3.p;
import okhttp3.q;
import okio.f;
import okio.h;
import tb.ac1;
import tb.cv2;
import tb.hx1;
import tb.ln;
import tb.qy0;

/* compiled from: Taobao */
public final class a implements Interceptor {
    private final CookieJar a;

    public a(CookieJar cookieJar) {
        this.a = cookieJar;
    }

    private String a(List<ln> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            ln lnVar = list.get(i);
            sb.append(lnVar.c());
            sb.append(com.alipay.sdk.m.n.a.h);
            sb.append(lnVar.k());
        }
        return sb.toString();
    }

    @Override // okhttp3.Interceptor
    public q intercept(Interceptor.Chain chain) throws IOException {
        o request = chain.request();
        o.a h = request.h();
        p a2 = request.a();
        if (a2 != null) {
            ac1 b = a2.b();
            if (b != null) {
                h.d("Content-Type", b.toString());
            }
            long a3 = a2.a();
            if (a3 != -1) {
                h.d(Constants.Protocol.CONTENT_LENGTH, Long.toString(a3));
                h.h("Transfer-Encoding");
            } else {
                h.d("Transfer-Encoding", "chunked");
                h.h(Constants.Protocol.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (request.c(BizTime.HOST) == null) {
            h.d(BizTime.HOST, okhttp3.internal.a.s(request.i(), false));
        }
        if (request.c(IRequestConst.CONNECTION) == null) {
            h.d(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
        }
        if (request.c("Accept-Encoding") == null && request.c("Range") == null) {
            z = true;
            h.d("Accept-Encoding", "gzip");
        }
        List<ln> loadForRequest = this.a.loadForRequest(request.i());
        if (!loadForRequest.isEmpty()) {
            h.d(IRequestConst.COOKIE, a(loadForRequest));
        }
        if (request.c(IRequestConst.USER_AGENT) == null) {
            h.d(IRequestConst.USER_AGENT, cv2.a());
        }
        q proceed = chain.proceed(h.b());
        qy0.g(this.a, request.i(), proceed.j());
        q.a q = proceed.m().q(request);
        if (z && "gzip".equalsIgnoreCase(proceed.g(Constants.Protocol.CONTENT_ENCODING)) && qy0.c(proceed)) {
            f fVar = new f(proceed.a().j());
            q.j(proceed.j().f().g(Constants.Protocol.CONTENT_ENCODING).g(Constants.Protocol.CONTENT_LENGTH).e());
            q.b(new hx1(proceed.g("Content-Type"), -1, h.d(fVar)));
        }
        return q.c();
    }
}
