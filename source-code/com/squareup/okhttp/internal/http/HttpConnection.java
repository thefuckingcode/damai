package com.squareup.okhttp.internal.http;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.h;
import okio.o;
import org.apache.commons.net.SocketClient;
import tb.jl1;

/* compiled from: Taobao */
public final class HttpConnection {
    private static final int ON_IDLE_CLOSE = 2;
    private static final int ON_IDLE_HOLD = 0;
    private static final int ON_IDLE_POOL = 1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final Connection connection;
    private int onIdle = 0;
    private final ConnectionPool pool;
    private final BufferedSink sink;
    private final Socket socket;
    private final BufferedSource source;
    private int state = 0;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public abstract class AbstractSource implements Source {
        protected boolean closed;

        private AbstractSource() {
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean z) throws IOException {
            if (HttpConnection.this.state == 5) {
                HttpConnection.this.state = 0;
                if (z && HttpConnection.this.onIdle == 1) {
                    HttpConnection.this.onIdle = 0;
                    Internal.instance.recycle(HttpConnection.this.pool, HttpConnection.this.connection);
                } else if (HttpConnection.this.onIdle == 2) {
                    HttpConnection.this.state = 6;
                    HttpConnection.this.connection.getSocket().close();
                }
            } else {
                throw new IllegalStateException("state: " + HttpConnection.this.state);
            }
        }

        @Override // okio.Source
        public o timeout() {
            return HttpConnection.this.source.timeout();
        }

        /* access modifiers changed from: protected */
        public final void unexpectedEndOfInput() {
            Util.closeQuietly(HttpConnection.this.connection.getSocket());
            HttpConnection.this.state = 6;
        }
    }

    /* compiled from: Taobao */
    private final class ChunkedSink implements Sink {
        private boolean closed;

        private ChunkedSink() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                HttpConnection.this.sink.writeUtf8("0\r\n\r\n");
                HttpConnection.this.state = 3;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (!this.closed) {
                HttpConnection.this.sink.flush();
            }
        }

        @Override // okio.Sink
        public o timeout() {
            return HttpConnection.this.sink.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            } else if (j != 0) {
                HttpConnection.this.sink.writeHexadecimalUnsignedLong(j);
                HttpConnection.this.sink.writeUtf8(SocketClient.NETASCII_EOL);
                HttpConnection.this.sink.write(buffer, j);
                HttpConnection.this.sink.writeUtf8(SocketClient.NETASCII_EOL);
            }
        }
    }

    /* compiled from: Taobao */
    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpEngine httpEngine;

        ChunkedSource(HttpEngine httpEngine2) throws IOException {
            super();
            this.httpEngine = httpEngine2;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                HttpConnection.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = HttpConnection.this.source.readHexadecimalUnsignedLong();
                String trim = HttpConnection.this.source.readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Headers.Builder builder = new Headers.Builder();
                    HttpConnection.this.readHeaders(builder);
                    this.httpEngine.receiveHeaders(builder.build());
                    endOfInput(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                long j2 = this.bytesRemainingInChunk;
                if (j2 == 0 || j2 == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                long read = HttpConnection.this.source.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                unexpectedEndOfInput();
                throw new IOException("unexpected end of stream");
            }
        }
    }

    /* compiled from: Taobao */
    private final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;

        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    HttpConnection.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!this.closed) {
                HttpConnection.this.sink.flush();
            }
        }

        @Override // okio.Sink
        public o timeout() {
            return HttpConnection.this.sink.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(buffer.size(), 0, j);
                if (j <= this.bytesRemaining) {
                    HttpConnection.this.sink.write(buffer, j);
                    this.bytesRemaining -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
            throw new IllegalStateException(IRequestConst.CLOSED);
        }

        private FixedLengthSink(long j) {
            this.bytesRemaining = j;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput(true);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                long read = HttpConnection.this.source.read(buffer, Math.min(this.bytesRemaining, j));
                if (read != -1) {
                    long j2 = this.bytesRemaining - read;
                    this.bytesRemaining = j2;
                    if (j2 == 0) {
                        endOfInput(true);
                    }
                    return read;
                }
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    /* compiled from: Taobao */
    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = HttpConnection.this.source.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(false);
                return -1;
            }
        }
    }

    public HttpConnection(ConnectionPool connectionPool, Connection connection2, Socket socket2) throws IOException {
        this.pool = connectionPool;
        this.connection = connection2;
        this.socket = socket2;
        this.source = h.d(h.m(socket2));
        this.sink = h.c(h.i(socket2));
    }

    public long bufferSize() {
        return this.source.buffer().size();
    }

    public void closeIfOwnedBy(Object obj) throws IOException {
        Internal.instance.closeIfOwnedBy(this.connection, obj);
    }

    public void closeOnIdle() throws IOException {
        this.onIdle = 2;
        if (this.state == 0) {
            this.state = 6;
            this.connection.getSocket().close();
        }
    }

    public void flush() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    /* JADX INFO: finally extract failed */
    public boolean isReadable() {
        try {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(1);
                if (this.source.exhausted()) {
                    this.socket.setSoTimeout(soTimeout);
                    return false;
                }
                this.socket.setSoTimeout(soTimeout);
                return true;
            } catch (Throwable th) {
                this.socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpEngine);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new UnknownLengthSource();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public void poolOnIdle() {
        this.onIdle = 1;
        if (this.state == 0) {
            this.onIdle = 0;
            Internal.instance.recycle(this.pool, this.connection);
        }
    }

    public void readHeaders(Headers.Builder builder) throws IOException {
        while (true) {
            String readUtf8LineStrict = this.source.readUtf8LineStrict();
            if (readUtf8LineStrict.length() != 0) {
                Internal.instance.addLenient(builder, readUtf8LineStrict);
            } else {
                return;
            }
        }
    }

    public Response.Builder readResponse() throws IOException {
        StatusLine parse;
        Response.Builder message;
        int i = this.state;
        if (i == 1 || i == 3) {
            do {
                try {
                    parse = StatusLine.parse(this.source.readUtf8LineStrict());
                    message = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message);
                    Headers.Builder builder = new Headers.Builder();
                    readHeaders(builder);
                    builder.add(OkHeaders.SELECTED_PROTOCOL, parse.protocol.toString());
                    message.headers(builder.build());
                } catch (EOFException e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.connection + " (recycle count=" + Internal.instance.recycleCount(this.connection) + jl1.BRACKET_END_STR);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (parse.code == 100);
            this.state = 4;
            return message;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public void setTimeouts(int i, int i2) {
        if (i != 0) {
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
        }
        if (i2 != 0) {
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            this.sink.writeUtf8(str).writeUtf8(SocketClient.NETASCII_EOL);
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8(SocketClient.NETASCII_EOL);
            }
            this.sink.writeUtf8(SocketClient.NETASCII_EOL);
            this.state = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.state == 1) {
            this.state = 3;
            retryableSink.writeToSocket(this.sink);
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }
}
