package com.meizu.cloud.pushsdk.c.g;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Taobao */
public interface l extends Closeable, Flushable {
    void a(b bVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    @Override // java.io.Flushable
    void flush() throws IOException;
}
