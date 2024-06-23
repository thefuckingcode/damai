package com.meizu.cloud.pushsdk.c.g;

import java.io.IOException;
import tb.jl1;

/* compiled from: Taobao */
public abstract class f implements l {
    private final l a;

    public f(l lVar) {
        if (lVar != null) {
            this.a = lVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j) throws IOException {
        this.a.a(bVar, j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + jl1.BRACKET_START_STR + this.a.toString() + jl1.BRACKET_END_STR;
    }
}
