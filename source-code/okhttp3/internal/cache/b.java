package okhttp3.internal.cache;

import android.taobao.windvane.connect.HttpConnector;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import mtopsdk.common.util.HttpHeaderConstant;
import okhttp3.l;
import okhttp3.o;
import okhttp3.q;
import tb.ce;
import tb.f21;
import tb.my0;
import tb.qy0;

/* compiled from: Taobao */
public final class b {
    @Nullable
    public final o a;
    @Nullable
    public final q b;

    /* compiled from: Taobao */
    public static class a {
        final long a;
        final o b;
        final q c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l = -1;

        public a(long j2, o oVar, q qVar) {
            this.a = j2;
            this.b = oVar;
            this.c = qVar;
            if (qVar != null) {
                this.i = qVar.r();
                this.j = qVar.p();
                l j3 = qVar.j();
                int h2 = j3.h();
                for (int i2 = 0; i2 < h2; i2++) {
                    String e2 = j3.e(i2);
                    String j4 = j3.j(i2);
                    if (HttpHeaderConstant.DATE.equalsIgnoreCase(e2)) {
                        this.d = my0.b(j4);
                        this.e = j4;
                    } else if ("Expires".equalsIgnoreCase(e2)) {
                        this.h = my0.b(j4);
                    } else if ("Last-Modified".equalsIgnoreCase(e2)) {
                        this.f = my0.b(j4);
                        this.g = j4;
                    } else if ("ETag".equalsIgnoreCase(e2)) {
                        this.k = j4;
                    } else if ("Age".equalsIgnoreCase(e2)) {
                        this.l = qy0.f(j4, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.d;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0L, this.j - date.getTime());
            }
            int i2 = this.l;
            if (i2 != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) i2));
            }
            long j3 = this.j;
            return j2 + (j3 - this.i) + (this.a - j3);
        }

        private long b() {
            long j2;
            long j3;
            ce c2 = this.c.c();
            if (c2.d() != -1) {
                return TimeUnit.SECONDS.toMillis((long) c2.d());
            }
            if (this.h != null) {
                Date date = this.d;
                if (date != null) {
                    j3 = date.getTime();
                } else {
                    j3 = this.j;
                }
                long time = this.h.getTime() - j3;
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f == null || this.c.q().i().y() != null) {
                return 0;
            } else {
                Date date2 = this.d;
                if (date2 != null) {
                    j2 = date2.getTime();
                } else {
                    j2 = this.i;
                }
                long time2 = j2 - this.f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        private b d() {
            if (this.c == null) {
                return new b(this.b, null);
            }
            if (this.b.f() && this.c.f() == null) {
                return new b(this.b, null);
            }
            if (!b.a(this.c, this.b)) {
                return new b(this.b, null);
            }
            ce b2 = this.b.b();
            if (b2.h() || e(this.b)) {
                return new b(this.b, null);
            }
            ce c2 = this.c.c();
            long a2 = a();
            long b3 = b();
            if (b2.d() != -1) {
                b3 = Math.min(b3, TimeUnit.SECONDS.toMillis((long) b2.d()));
            }
            long j2 = 0;
            long millis = b2.f() != -1 ? TimeUnit.SECONDS.toMillis((long) b2.f()) : 0;
            if (!c2.g() && b2.e() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) b2.e());
            }
            if (!c2.h()) {
                long j3 = millis + a2;
                if (j3 < j2 + b3) {
                    q.a m = this.c.m();
                    if (j3 >= b3) {
                        m.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a2 > 86400000 && f()) {
                        m.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new b(null, m.c());
                }
            }
            String str = this.k;
            String str2 = HttpConnector.IF_MODIFY_SINCE;
            if (str != null) {
                str2 = HttpConnector.IF_NONE_MATCH;
            } else if (this.f != null) {
                str = this.g;
            } else if (this.d == null) {
                return new b(this.b, null);
            } else {
                str = this.e;
            }
            l.a f2 = this.b.e().f();
            f21.a.b(f2, str2, str);
            return new b(this.b.h().e(f2.e()).b(), this.c);
        }

        private static boolean e(o oVar) {
            return (oVar.c(HttpConnector.IF_MODIFY_SINCE) == null && oVar.c(HttpConnector.IF_NONE_MATCH) == null) ? false : true;
        }

        private boolean f() {
            return this.c.c().d() == -1 && this.h == null;
        }

        public b c() {
            b d2 = d();
            return (d2.a == null || !this.b.b().j()) ? d2 : new b(null, null);
        }
    }

    b(o oVar, q qVar) {
        this.a = oVar;
        this.b = qVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.c().b() == false) goto L_0x0059;
     */
    public static boolean a(q qVar, o oVar) {
        int e = qVar.e();
        if (!(e == 200 || e == 410 || e == 414 || e == 501 || e == 203 || e == 204)) {
            if (e != 307) {
                if (!(e == 308 || e == 404 || e == 405)) {
                    switch (e) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (qVar.g("Expires") == null) {
                if (qVar.c().d() == -1) {
                    if (!qVar.c().c()) {
                    }
                }
            }
        }
        if (qVar.c().i() || oVar.b().i()) {
            return false;
        }
        return true;
    }
}
