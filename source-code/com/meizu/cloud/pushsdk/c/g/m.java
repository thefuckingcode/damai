package com.meizu.cloud.pushsdk.c.g;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Taobao */
public interface m extends Closeable {
    long b(b bVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
