package com.taobao.alivfssdk.fresco.cache.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
public class b {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements WriterCallback {
        final /* synthetic */ InputStream a;

        a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.taobao.alivfssdk.fresco.cache.common.WriterCallback
        public OutputStream write(OutputStream outputStream) throws IOException {
            com.taobao.alivfssdk.fresco.common.internal.a.a(this.a, outputStream);
            return outputStream;
        }
    }

    public static WriterCallback a(InputStream inputStream) {
        return new a(inputStream);
    }
}
