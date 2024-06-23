package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.g.d;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: Taobao */
public abstract class l implements Closeable {
    public abstract d a();

    public final InputStream b() {
        return a().d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m.a(a());
    }
}
