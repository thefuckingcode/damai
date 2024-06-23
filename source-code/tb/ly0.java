package tb;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.l;
import okhttp3.m;
import okhttp3.q;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.o;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public final class ly0 implements ExchangeCodec {
    private final OkHttpClient a;
    private final okhttp3.internal.connection.e b;
    private final BufferedSource c;
    private final BufferedSink d;
    private int e = 0;
    private long f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    private l g;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public abstract class b implements Source {
        protected final okio.e a;
        protected boolean b;

        private b() {
            this.a = new okio.e(ly0.this.c.timeout());
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (ly0.this.e != 6) {
                if (ly0.this.e == 5) {
                    ly0.this.k(this.a);
                    ly0.this.e = 6;
                    return;
                }
                throw new IllegalStateException("state: " + ly0.this.e);
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                return ly0.this.c.read(buffer, j);
            } catch (IOException e) {
                ly0.this.b.p();
                a();
                throw e;
            }
        }

        @Override // okio.Source
        public o timeout() {
            return this.a;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class c implements Sink {
        private final okio.e a;
        private boolean b;

        c() {
            this.a = new okio.e(ly0.this.d.timeout());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public synchronized void close() throws IOException {
            if (!this.b) {
                this.b = true;
                ly0.this.d.writeUtf8("0\r\n\r\n");
                ly0.this.k(this.a);
                ly0.this.e = 3;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (!this.b) {
                ly0.this.d.flush();
            }
        }

        @Override // okio.Sink
        public o timeout() {
            return this.a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.b) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            } else if (j != 0) {
                ly0.this.d.writeHexadecimalUnsignedLong(j);
                ly0.this.d.writeUtf8(SocketClient.NETASCII_EOL);
                ly0.this.d.write(buffer, j);
                ly0.this.d.writeUtf8(SocketClient.NETASCII_EOL);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class d extends b {
        private final m d;
        private long e = -1;
        private boolean f = true;

        d(m mVar) {
            super();
            this.d = mVar;
        }

        private void c() throws IOException {
            if (this.e != -1) {
                ly0.this.c.readUtf8LineStrict();
            }
            try {
                this.e = ly0.this.c.readHexadecimalUnsignedLong();
                String trim = ly0.this.c.readUtf8LineStrict().trim();
                if (this.e < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + trim + "\"");
                } else if (this.e == 0) {
                    this.f = false;
                    ly0 ly0 = ly0.this;
                    ly0.g = ly0.r();
                    qy0.g(ly0.this.a.cookieJar(), this.d, ly0.this.g);
                    a();
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.b) {
                if (this.f && !okhttp3.internal.a.p(this, 100, TimeUnit.MILLISECONDS)) {
                    ly0.this.b.p();
                    a();
                }
                this.b = true;
            }
        }

        @Override // tb.ly0.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            } else if (!this.f) {
                return -1;
            } else {
                long j2 = this.e;
                if (j2 == 0 || j2 == -1) {
                    c();
                    if (!this.f) {
                        return -1;
                    }
                }
                long read = super.read(buffer, Math.min(j, this.e));
                if (read != -1) {
                    this.e -= read;
                    return read;
                }
                ly0.this.b.p();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class e extends b {
        private long d;

        e(long j) {
            super();
            this.d = j;
            if (j == 0) {
                a();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.b) {
                if (this.d != 0 && !okhttp3.internal.a.p(this, 100, TimeUnit.MILLISECONDS)) {
                    ly0.this.b.p();
                    a();
                }
                this.b = true;
            }
        }

        @Override // tb.ly0.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.b) {
                long j2 = this.d;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.d - read;
                    this.d = j3;
                    if (j3 == 0) {
                        a();
                    }
                    return read;
                }
                ly0.this.b.p();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            } else {
                throw new IllegalStateException(IRequestConst.CLOSED);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class f implements Sink {
        private final okio.e a;
        private boolean b;

        private f() {
            this.a = new okio.e(ly0.this.d.timeout());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            if (!this.b) {
                this.b = true;
                ly0.this.k(this.a);
                ly0.this.e = 3;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!this.b) {
                ly0.this.d.flush();
            }
        }

        @Override // okio.Sink
        public o timeout() {
            return this.a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!this.b) {
                okhttp3.internal.a.f(buffer.size(), 0, j);
                ly0.this.d.write(buffer, j);
                return;
            }
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class g extends b {
        private boolean d;

        private g(ly0 ly0) {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.b) {
                if (!this.d) {
                    a();
                }
                this.b = true;
            }
        }

        @Override // tb.ly0.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException(IRequestConst.CLOSED);
            } else if (this.d) {
                return -1;
            } else {
                long read = super.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.d = true;
                a();
                return -1;
            }
        }
    }

    public ly0(OkHttpClient okHttpClient, okhttp3.internal.connection.e eVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.a = okHttpClient;
        this.b = eVar;
        this.c = bufferedSource;
        this.d = bufferedSink;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(okio.e eVar) {
        o a2 = eVar.a();
        eVar.b(o.NONE);
        a2.clearDeadline();
        a2.clearTimeout();
    }

    private Sink l() {
        if (this.e == 1) {
            this.e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source m(m mVar) {
        if (this.e == 4) {
            this.e = 5;
            return new d(mVar);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source n(long j) {
        if (this.e == 4) {
            this.e = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Sink o() {
        if (this.e == 1) {
            this.e = 2;
            return new f();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private Source p() {
        if (this.e == 4) {
            this.e = 5;
            this.b.p();
            return new g();
        }
        throw new IllegalStateException("state: " + this.e);
    }

    private String q() throws IOException {
        String readUtf8LineStrict = this.c.readUtf8LineStrict(this.f);
        this.f -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private l r() throws IOException {
        l.a aVar = new l.a();
        while (true) {
            String q = q();
            if (q.length() == 0) {
                return aVar.e();
            }
            f21.a.a(aVar, q);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        okhttp3.internal.connection.e eVar = this.b;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.internal.connection.e connection() {
        return this.b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(okhttp3.o oVar, long j) throws IOException {
        if (oVar.a() != null && oVar.a().f()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        } else if ("chunked".equalsIgnoreCase(oVar.c("Transfer-Encoding"))) {
            return l();
        } else {
            if (j != -1) {
                return o();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(q qVar) {
        if (!qy0.c(qVar)) {
            return n(0);
        }
        if ("chunked".equalsIgnoreCase(qVar.g("Transfer-Encoding"))) {
            return m(qVar.q().i());
        }
        long b2 = qy0.b(qVar);
        if (b2 != -1) {
            return n(b2);
        }
        return p();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public q.a readResponseHeaders(boolean z) throws IOException {
        int i = this.e;
        if (i == 1 || i == 3) {
            try {
                okhttp3.internal.http.e a2 = okhttp3.internal.http.e.a(q());
                q.a j = new q.a().o(a2.a).g(a2.b).l(a2.c).j(r());
                if (z && a2.b == 100) {
                    return null;
                }
                if (a2.b == 100) {
                    this.e = 3;
                    return j;
                }
                this.e = 4;
                return j;
            } catch (EOFException e2) {
                okhttp3.internal.connection.e eVar = this.b;
                String A = eVar != null ? eVar.route().a().l().A() : "unknown";
                throw new IOException("unexpected end of stream on " + A, e2);
            }
        } else {
            throw new IllegalStateException("state: " + this.e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(q qVar) {
        if (!qy0.c(qVar)) {
            return 0;
        }
        if ("chunked".equalsIgnoreCase(qVar.g("Transfer-Encoding"))) {
            return -1;
        }
        return qy0.b(qVar);
    }

    public void s(q qVar) throws IOException {
        long b2 = qy0.b(qVar);
        if (b2 != -1) {
            Source n = n(b2);
            okhttp3.internal.a.F(n, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            n.close();
        }
    }

    public void t(l lVar, String str) throws IOException {
        if (this.e == 0) {
            this.d.writeUtf8(str).writeUtf8(SocketClient.NETASCII_EOL);
            int h = lVar.h();
            for (int i = 0; i < h; i++) {
                this.d.writeUtf8(lVar.e(i)).writeUtf8(": ").writeUtf8(lVar.j(i)).writeUtf8(SocketClient.NETASCII_EOL);
            }
            this.d.writeUtf8(SocketClient.NETASCII_EOL);
            this.e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public l trailers() {
        if (this.e == 6) {
            l lVar = this.g;
            return lVar != null ? lVar : okhttp3.internal.a.EMPTY_HEADERS;
        }
        throw new IllegalStateException("too early; can't read the trailers yet");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(okhttp3.o oVar) throws IOException {
        t(oVar.e(), f02.a(oVar, this.b.route().b().type()));
    }
}
