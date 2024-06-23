package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

/* compiled from: Taobao */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
