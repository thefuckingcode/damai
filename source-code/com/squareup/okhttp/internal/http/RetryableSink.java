package com.squareup.okhttp.internal.http;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.o;

/* compiled from: Taobao */
public final class RetryableSink implements Sink {
    private boolean closed;
    private final Buffer content;
    private final int limit;

    public RetryableSink(int i) {
        this.content = new Buffer();
        this.limit = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (this.content.size() < ((long) this.limit)) {
                throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.size());
            }
        }
    }

    public long contentLength() throws IOException {
        return this.content.size();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // okio.Sink
    public o timeout() {
        return o.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (!this.closed) {
            Util.checkOffsetAndCount(buffer.size(), 0, j);
            if (this.limit == -1 || this.content.size() <= ((long) this.limit) - j) {
                this.content.write(buffer, j);
                return;
            }
            throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    public void writeToSocket(Sink sink) throws IOException {
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.content;
        buffer2.copyTo(buffer, 0, buffer2.size());
        sink.write(buffer, buffer.size());
    }

    public RetryableSink() {
        this(-1);
    }
}
