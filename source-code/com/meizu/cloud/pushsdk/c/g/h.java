package com.meizu.cloud.pushsdk.c.g;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class h implements c {
    private final b a;
    private final l b;
    private boolean c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar != null) {
            this.a = bVar;
            this.b = lVar;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(m mVar) throws IOException {
        if (mVar != null) {
            long j = 0;
            while (true) {
                long b2 = mVar.b(this.a, 2048);
                if (b2 == -1) {
                    return j;
                }
                j += b2;
                a();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public c a() throws IOException {
        if (!this.c) {
            long e = this.a.e();
            if (e > 0) {
                this.b.a(this.a, e);
            }
            return this;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j) throws IOException {
        if (!this.c) {
            this.a.a(bVar, j);
            a();
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public b b() {
        return this.a;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c b(e eVar) throws IOException {
        if (!this.c) {
            this.a.b(eVar);
            return a();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c b(String str) throws IOException {
        if (!this.c) {
            this.a.b(str);
            return a();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c c(byte[] bArr) throws IOException {
        if (!this.c) {
            this.a.c(bArr);
            return a();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.c) {
            this.a.c(bArr, i, i2);
            return a();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.c) {
            Throwable th = null;
            try {
                b bVar = this.a;
                long j = bVar.b;
                if (j > 0) {
                    this.b.a(bVar, j);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                o.a(th);
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c e(long j) throws IOException {
        if (!this.c) {
            this.a.e(j);
            return a();
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (!this.c) {
            b bVar = this.a;
            long j = bVar.b;
            if (j > 0) {
                this.b.a(bVar, j);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    public String toString() {
        return "buffer(" + this.b + jl1.BRACKET_END_STR;
    }
}
