package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.internal.connection.c;
import okhttp3.l;
import tb.ce;

/* compiled from: Taobao */
public final class q implements Closeable {
    final o a;
    final Protocol b;
    final int c;
    final String d;
    @Nullable
    final k e;
    final l f;
    @Nullable
    final r g;
    @Nullable
    final q h;
    @Nullable
    final q i;
    @Nullable
    final q j;
    final long k;
    final long l;
    @Nullable
    final c m;
    @Nullable
    private volatile ce n;

    q(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.e();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
    }

    @Nullable
    public r a() {
        return this.g;
    }

    public ce c() {
        ce ceVar = this.n;
        if (ceVar != null) {
            return ceVar;
        }
        ce k2 = ce.k(this.f);
        this.n = k2;
        return k2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        r rVar = this.g;
        if (rVar != null) {
            rVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public int e() {
        return this.c;
    }

    @Nullable
    public k f() {
        return this.e;
    }

    @Nullable
    public String g(String str) {
        return h(str, null);
    }

    @Nullable
    public String h(String str, @Nullable String str2) {
        String c2 = this.f.c(str);
        return c2 != null ? c2 : str2;
    }

    public boolean isSuccessful() {
        int i2 = this.c;
        return i2 >= 200 && i2 < 300;
    }

    public l j() {
        return this.f;
    }

    public String k() {
        return this.d;
    }

    @Nullable
    public q l() {
        return this.h;
    }

    public a m() {
        return new a(this);
    }

    @Nullable
    public q n() {
        return this.j;
    }

    public Protocol o() {
        return this.b;
    }

    public long p() {
        return this.l;
    }

    public o q() {
        return this.a;
    }

    public long r() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.i() + '}';
    }

    /* compiled from: Taobao */
    public static class a {
        @Nullable
        o a;
        @Nullable
        Protocol b;
        int c;
        String d;
        @Nullable
        k e;
        l.a f;
        @Nullable
        r g;
        @Nullable
        q h;
        @Nullable
        q i;
        @Nullable
        q j;
        long k;
        long l;
        @Nullable
        c m;

        public a() {
            this.c = -1;
            this.f = new l.a();
        }

        private void e(q qVar) {
            if (qVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, q qVar) {
            if (qVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (qVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (qVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (qVar.j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a b(@Nullable r rVar) {
            this.g = rVar;
            return this;
        }

        public q c() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.c < 0) {
                throw new IllegalStateException("code < 0: " + this.c);
            } else if (this.d != null) {
                return new q(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public a d(@Nullable q qVar) {
            if (qVar != null) {
                f("cacheResponse", qVar);
            }
            this.i = qVar;
            return this;
        }

        public a g(int i2) {
            this.c = i2;
            return this;
        }

        public a h(@Nullable k kVar) {
            this.e = kVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f.h(str, str2);
            return this;
        }

        public a j(l lVar) {
            this.f = lVar.f();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void k(c cVar) {
            this.m = cVar;
        }

        public a l(String str) {
            this.d = str;
            return this;
        }

        public a m(@Nullable q qVar) {
            if (qVar != null) {
                f("networkResponse", qVar);
            }
            this.h = qVar;
            return this;
        }

        public a n(@Nullable q qVar) {
            if (qVar != null) {
                e(qVar);
            }
            this.j = qVar;
            return this;
        }

        public a o(Protocol protocol) {
            this.b = protocol;
            return this;
        }

        public a p(long j2) {
            this.l = j2;
            return this;
        }

        public a q(o oVar) {
            this.a = oVar;
            return this;
        }

        public a r(long j2) {
            this.k = j2;
            return this;
        }

        a(q qVar) {
            this.c = -1;
            this.a = qVar.a;
            this.b = qVar.b;
            this.c = qVar.c;
            this.d = qVar.d;
            this.e = qVar.e;
            this.f = qVar.f.f();
            this.g = qVar.g;
            this.h = qVar.h;
            this.i = qVar.i;
            this.j = qVar.j;
            this.k = qVar.k;
            this.l = qVar.l;
            this.m = qVar.m;
        }
    }
}
