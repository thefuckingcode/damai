package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import tb.jl1;

/* compiled from: Taobao */
public final class h {
    static final Logger a = Logger.getLogger(h.class.getName());

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Sink {
        final /* synthetic */ o a;
        final /* synthetic */ OutputStream b;

        a(o oVar, OutputStream outputStream) {
            this.a = oVar;
            this.b = outputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            this.b.close();
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            this.b.flush();
        }

        @Override // okio.Sink
        public o timeout() {
            return this.a;
        }

        public String toString() {
            return "sink(" + this.b + jl1.BRACKET_END_STR;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            p.b(buffer.size, 0, j);
            while (j > 0) {
                this.a.throwIfReached();
                m mVar = buffer.head;
                int min = (int) Math.min(j, (long) (mVar.c - mVar.b));
                this.b.write(mVar.a, mVar.b, min);
                int i = mVar.b + min;
                mVar.b = i;
                long j2 = (long) min;
                j -= j2;
                buffer.size -= j2;
                if (i == mVar.c) {
                    buffer.head = mVar.b();
                    n.a(mVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Source {
        final /* synthetic */ o a;
        final /* synthetic */ InputStream b;

        b(o oVar, InputStream inputStream) {
            this.a = oVar;
            this.b = inputStream;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i == 0) {
                return 0;
            } else {
                try {
                    this.a.throwIfReached();
                    m writableSegment = buffer.writableSegment(1);
                    int read = this.b.read(writableSegment.a, writableSegment.c, (int) Math.min(j, (long) (8192 - writableSegment.c)));
                    if (read == -1) {
                        return -1;
                    }
                    writableSegment.c += read;
                    long j2 = (long) read;
                    buffer.size += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (h.e(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        @Override // okio.Source
        public o timeout() {
            return this.a;
        }

        public String toString() {
            return "source(" + this.b + jl1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    class c implements Sink {
        c() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
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
            buffer.skip(j);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d extends AsyncTimeout {
        final /* synthetic */ Socket a;

        d(Socket socket) {
            this.a = socket;
        }

        /* access modifiers changed from: protected */
        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        @Override // okio.AsyncTimeout
        public void timedOut() {
            try {
                this.a.close();
            } catch (Exception e) {
                Logger logger = h.a;
                Level level = Level.WARNING;
                logger.log(level, "Failed to close timed out socket " + this.a, (Throwable) e);
            } catch (AssertionError e2) {
                if (h.e(e2)) {
                    Logger logger2 = h.a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + this.a, (Throwable) e2);
                    return;
                }
                throw e2;
            }
        }
    }

    private h() {
    }

    public static Sink a(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink b() {
        return new c();
    }

    public static BufferedSink c(Sink sink) {
        return new k(sink);
    }

    public static BufferedSource d(Source source) {
        return new l(source);
    }

    static boolean e(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink f(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink g(OutputStream outputStream) {
        return h(outputStream, new o());
    }

    private static Sink h(OutputStream outputStream, o oVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (oVar != null) {
            return new a(oVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink i(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            AsyncTimeout n = n(socket);
            return n.sink(h(socket.getOutputStream(), n));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static Source j(File file) throws FileNotFoundException {
        if (file != null) {
            return k(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source k(InputStream inputStream) {
        return l(inputStream, new o());
    }

    private static Source l(InputStream inputStream, o oVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (oVar != null) {
            return new b(oVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Source m(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            AsyncTimeout n = n(socket);
            return n.source(l(socket.getInputStream(), n));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static AsyncTimeout n(Socket socket) {
        return new d(socket);
    }
}
