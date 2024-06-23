package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.c;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class FaultHidingSink extends c {
    private boolean hasErrors;

    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override // java.io.Closeable, okio.c, java.lang.AutoCloseable, okio.Sink
    public void close() throws IOException {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    @Override // okio.c, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onException(IOException iOException) {
    }

    @Override // okio.c, okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.hasErrors) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }
}
