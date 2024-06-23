package com.meizu.cloud.pushsdk.c.g;

import androidx.annotation.NonNull;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.io.InputStream;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class i implements d {
    private final b a;
    private final m b;
    private boolean c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar != null) {
            this.a = bVar;
            this.b = mVar;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.c) {
            b bVar2 = this.a;
            if (bVar2.b == 0 && this.b.b(bVar2, 2048) == -1) {
                return -1;
            }
            return this.a.b(bVar, Math.min(j, this.a.b));
        } else {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.j();
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public InputStream d() {
        return new InputStream() {
            /* class com.meizu.cloud.pushsdk.c.g.i.AnonymousClass1 */

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (!i.this.c) {
                    return (int) Math.min(i.this.a.b, 2147483647L);
                }
                throw new IOException(IRequestConst.CLOSED);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.c) {
                    throw new IOException(IRequestConst.CLOSED);
                } else if (i.this.a.b == 0 && i.this.b.b(i.this.a, 2048) == -1) {
                    return -1;
                } else {
                    return i.this.a.f() & 255;
                }
            }

            @Override // java.io.InputStream
            public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
                if (!i.this.c) {
                    o.a((long) bArr.length, (long) i, (long) i2);
                    if (i.this.a.b == 0 && i.this.b.b(i.this.a, 2048) == -1) {
                        return -1;
                    }
                    return i.this.a.a(bArr, i, i2);
                }
                throw new IOException(IRequestConst.CLOSED);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public String h() throws IOException {
        this.a.a(this.b);
        return this.a.h();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public byte[] i() throws IOException {
        this.a.a(this.b);
        return this.a.i();
    }

    public String toString() {
        return "buffer(" + this.b + jl1.BRACKET_END_STR;
    }
}
