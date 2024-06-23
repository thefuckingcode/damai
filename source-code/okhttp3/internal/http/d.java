package okhttp3.internal.http;

import anet.channel.request.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import mtopsdk.network.util.Constants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.m;
import okhttp3.o;
import okhttp3.p;
import okhttp3.q;
import okhttp3.s;
import tb.f21;
import tb.ty0;

/* compiled from: Taobao */
public final class d implements Interceptor {
    private final OkHttpClient a;

    public d(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    private o a(q qVar, @Nullable s sVar) throws IOException {
        String g;
        m B;
        Proxy proxy;
        if (qVar != null) {
            int e = qVar.e();
            String g2 = qVar.q().g();
            p pVar = null;
            if (e == 307 || e == 308) {
                if (!g2.equals("GET") && !g2.equals(a.c.HEAD)) {
                    return null;
                }
            } else if (e == 401) {
                return this.a.authenticator().authenticate(sVar, qVar);
            } else {
                if (e != 503) {
                    if (e == 407) {
                        if (sVar != null) {
                            proxy = sVar.b();
                        } else {
                            proxy = this.a.proxy();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.a.proxyAuthenticator().authenticate(sVar, qVar);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (e != 408) {
                        switch (e) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.a.retryOnConnectionFailure()) {
                        return null;
                    } else {
                        p a2 = qVar.q().a();
                        if (a2 != null && a2.g()) {
                            return null;
                        }
                        if ((qVar.n() == null || qVar.n().e() != 408) && e(qVar, 0) <= 0) {
                            return qVar.q();
                        }
                        return null;
                    }
                } else if ((qVar.n() == null || qVar.n().e() != 503) && e(qVar, Integer.MAX_VALUE) == 0) {
                    return qVar.q();
                } else {
                    return null;
                }
            }
            if (!this.a.followRedirects() || (g = qVar.g("Location")) == null || (B = qVar.q().i().B(g)) == null) {
                return null;
            }
            if (!B.C().equals(qVar.q().i().C()) && !this.a.followSslRedirects()) {
                return null;
            }
            o.a h = qVar.q().h();
            if (ty0.b(g2)) {
                boolean d = ty0.d(g2);
                if (ty0.c(g2)) {
                    h.f("GET", null);
                } else {
                    if (d) {
                        pVar = qVar.q().a();
                    }
                    h.f(g2, pVar);
                }
                if (!d) {
                    h.h("Transfer-Encoding");
                    h.h(Constants.Protocol.CONTENT_LENGTH);
                    h.h("Content-Type");
                }
            }
            if (!okhttp3.internal.a.E(qVar.q().i(), B)) {
                h.h("Authorization");
            }
            return h.l(B).b();
        }
        throw new IllegalStateException();
    }

    private boolean b(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean c(IOException iOException, i iVar, boolean z, o oVar) {
        if (!this.a.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z || !d(iOException, oVar)) && b(iOException, z) && iVar.c()) {
            return true;
        }
        return false;
    }

    private boolean d(IOException iOException, o oVar) {
        p a2 = oVar.a();
        return (a2 != null && a2.g()) || (iOException instanceof FileNotFoundException);
    }

    private int e(q qVar, int i) {
        String g = qVar.g("Retry-After");
        if (g == null) {
            return i;
        }
        if (g.matches("\\d+")) {
            return Integer.valueOf(g).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b3, code lost:
        r1.f();
     */
    @Override // okhttp3.Interceptor
    public q intercept(Interceptor.Chain chain) throws IOException {
        o request = chain.request();
        c cVar = (c) chain;
        i c = cVar.c();
        q qVar = null;
        int i = 0;
        while (true) {
            c.m(request);
            if (!c.i()) {
                try {
                    q b = cVar.b(request, c, null);
                    if (qVar != null) {
                        b = b.m().n(qVar.m().b(null).c()).c();
                    }
                    qVar = b;
                    c f = f21.a.f(qVar);
                    o a2 = a(qVar, f != null ? f.c().route() : null);
                    if (a2 == null) {
                        if (f != null && f.h()) {
                            c.p();
                        }
                        return qVar;
                    }
                    p a3 = a2.a();
                    if (a3 != null && a3.g()) {
                        return qVar;
                    }
                    okhttp3.internal.a.g(qVar.a());
                    if (c.h()) {
                        f.e();
                    }
                    i++;
                    if (i <= 20) {
                        request = a2;
                    } else {
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    }
                } catch (RouteException e) {
                    if (!c(e.getLastConnectException(), c, false, request)) {
                        throw e.getFirstConnectException();
                    }
                } catch (IOException e2) {
                    if (!c(e2, c, !(e2 instanceof ConnectionShutdownException), request)) {
                        throw e2;
                    }
                } catch (Throwable th) {
                    c.f();
                    throw th;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
    }
}
