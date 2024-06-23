package okhttp3.internal.http2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.l;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.o;

/* compiled from: Taobao */
public final class e {
    long a = 0;
    long b;
    final int c;
    final Http2Connection d;
    private final Deque<l> e;
    private boolean f;
    private final b g;
    final a h;
    final c i;
    final c j;
    @Nullable
    ErrorCode k;
    @Nullable
    IOException l;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class a implements Sink {
        private final Buffer a = new Buffer();
        private l b;
        boolean c;
        boolean d;

        a() {
        }

        private void a(boolean z) throws IOException {
            e eVar;
            long min;
            e eVar2;
            boolean z2;
            synchronized (e.this) {
                e.this.j.enter();
                while (true) {
                    try {
                        eVar = e.this;
                        if (eVar.b > 0 || this.d || this.c || eVar.k != null) {
                            eVar.j.exitAndThrowIfTimedOut();
                            e.this.c();
                            min = Math.min(e.this.b, this.a.size());
                            eVar2 = e.this;
                            eVar2.b -= min;
                        } else {
                            eVar.r();
                        }
                    } finally {
                        e.this.j.exitAndThrowIfTimedOut();
                    }
                }
                eVar.j.exitAndThrowIfTimedOut();
                e.this.c();
                min = Math.min(e.this.b, this.a.size());
                eVar2 = e.this;
                eVar2.b -= min;
            }
            eVar2.j.enter();
            if (z) {
                try {
                    if (min == this.a.size()) {
                        z2 = true;
                        e eVar3 = e.this;
                        eVar3.d.G(eVar3.c, z2, this.a, min);
                    }
                } catch (Throwable th) {
                    e.this.j.exitAndThrowIfTimedOut();
                    throw th;
                }
            }
            z2 = false;
            e eVar32 = e.this;
            eVar32.d.G(eVar32.c, z2, this.a, min);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            if (r8.a.size() <= 0) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            if (r8.b == null) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
            if (r3 == false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
            if (r8.a.size() <= 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
            a(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
            r0 = r8.e;
            r0.d.H(r0.c, true, okhttp3.internal.a.J(r8.b));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
            if (r2 == false) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
            if (r8.a.size() <= 0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
            r0 = r8.e;
            r0.d.G(r0.c, true, null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            r2 = r8.e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r8.c = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x006c, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
            r8.e.d.flush();
            r8.e.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.e.h.d != false) goto L_0x0067;
         */
        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            synchronized (e.this) {
                if (this.c) {
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (e.this) {
                e.this.c();
            }
            while (this.a.size() > 0) {
                a(false);
                e.this.d.flush();
            }
        }

        @Override // okio.Sink
        public o timeout() {
            return e.this.j;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            this.a.write(buffer, j);
            while (this.a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class b implements Source {
        private final Buffer a = new Buffer();
        private final Buffer b = new Buffer();
        private final long c;
        private l d;
        boolean e;
        boolean f;

        b(long j) {
            this.c = j;
        }

        private void f(long j) {
            e.this.d.F(j);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            synchronized (e.this) {
                this.e = true;
                size = this.b.size();
                this.b.clear();
                e.this.notifyAll();
            }
            if (size > 0) {
                f(size);
            }
            e.this.b();
        }

        /* access modifiers changed from: package-private */
        public void e(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            while (j > 0) {
                synchronized (e.this) {
                    z = this.f;
                    z2 = true;
                    z3 = this.b.size() + j > this.c;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    e.this.f(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.a, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (e.this) {
                            if (this.e) {
                                j2 = this.a.size();
                                this.a.clear();
                            } else {
                                if (this.b.size() != 0) {
                                    z2 = false;
                                }
                                this.b.writeAll(this.a);
                                if (z2) {
                                    e.this.notifyAll();
                                }
                                j2 = 0;
                            }
                        }
                        if (j2 > 0) {
                            f(j2);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            Throwable th;
            long read;
            if (j >= 0) {
                while (true) {
                    th = null;
                    synchronized (e.this) {
                        e.this.i.enter();
                        try {
                            e eVar = e.this;
                            if (eVar.k != null) {
                                th = eVar.l;
                                if (th == null) {
                                    th = new StreamResetException(e.this.k);
                                }
                            }
                            if (this.e) {
                                throw new IOException("stream closed");
                            } else if (this.b.size() > 0) {
                                Buffer buffer2 = this.b;
                                read = buffer2.read(buffer, Math.min(j, buffer2.size()));
                                e eVar2 = e.this;
                                long j2 = eVar2.a + read;
                                eVar2.a = j2;
                                if (th == null && j2 >= ((long) (eVar2.d.s.d() / 2))) {
                                    e eVar3 = e.this;
                                    eVar3.d.L(eVar3.c, eVar3.a);
                                    e.this.a = 0;
                                }
                            } else if (this.f || th != null) {
                                read = -1;
                            } else {
                                e.this.r();
                            }
                        } finally {
                            e.this.i.exitAndThrowIfTimedOut();
                        }
                    }
                }
                e.this.i.exitAndThrowIfTimedOut();
                if (read != -1) {
                    f(read);
                    return read;
                } else if (th == null) {
                    return -1;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
        }

        @Override // okio.Source
        public o timeout() {
            return e.this.i;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends AsyncTimeout {
        c() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        /* access modifiers changed from: protected */
        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        @Override // okio.AsyncTimeout
        public void timedOut() {
            e.this.f(ErrorCode.CANCEL);
            e.this.d.B();
        }
    }

    e(int i2, Http2Connection http2Connection, boolean z, boolean z2, @Nullable l lVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        this.i = new c();
        this.j = new c();
        Objects.requireNonNull(http2Connection, "connection == null");
        this.c = i2;
        this.d = http2Connection;
        this.b = (long) http2Connection.t.d();
        b bVar = new b((long) http2Connection.s.d());
        this.g = bVar;
        a aVar = new a();
        this.h = aVar;
        bVar.f = z2;
        aVar.d = z;
        if (lVar != null) {
            arrayDeque.add(lVar);
        }
        if (j() && lVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        } else if (!j() && lVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean e(ErrorCode errorCode, @Nullable IOException iOException) {
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.f && this.h.d) {
                return false;
            }
            this.k = errorCode;
            this.l = iOException;
            notifyAll();
            this.d.A(this.c);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() throws IOException {
        boolean z;
        boolean k2;
        synchronized (this) {
            b bVar = this.g;
            if (!bVar.f && bVar.e) {
                a aVar = this.h;
                if (aVar.d || aVar.c) {
                    z = true;
                    k2 = k();
                }
            }
            z = false;
            k2 = k();
        }
        if (z) {
            d(ErrorCode.CANCEL, null);
        } else if (!k2) {
            this.d.A(this.c);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() throws IOException {
        a aVar = this.h;
        if (aVar.c) {
            throw new IOException("stream closed");
        } else if (aVar.d) {
            throw new IOException("stream finished");
        } else if (this.k != null) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.k);
        }
    }

    public void d(ErrorCode errorCode, @Nullable IOException iOException) throws IOException {
        if (e(errorCode, iOException)) {
            this.d.J(this.c, errorCode);
        }
    }

    public void f(ErrorCode errorCode) {
        if (e(errorCode, null)) {
            this.d.K(this.c, errorCode);
        }
    }

    public int g() {
        return this.c;
    }

    public Sink h() {
        synchronized (this) {
            if (!this.f) {
                if (!j()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.h;
    }

    public Source i() {
        return this.g;
    }

    public boolean j() {
        if (this.d.a == ((this.c & 1) == 1)) {
            return true;
        }
        return false;
    }

    public synchronized boolean k() {
        if (this.k != null) {
            return false;
        }
        b bVar = this.g;
        if (bVar.f || bVar.e) {
            a aVar = this.h;
            if ((aVar.d || aVar.c) && this.f) {
                return false;
            }
        }
        return true;
    }

    public o l() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void m(BufferedSource bufferedSource, int i2) throws IOException {
        this.g.e(bufferedSource, (long) i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    public void n(l lVar, boolean z) {
        boolean k2;
        synchronized (this) {
            if (this.f) {
                if (z) {
                    this.g.d = lVar;
                    if (z) {
                        this.g.f = true;
                    }
                    k2 = k();
                    notifyAll();
                }
            }
            this.f = true;
            this.e.add(lVar);
            if (z) {
            }
            k2 = k();
            notifyAll();
        }
        if (!k2) {
            this.d.A(this.c);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void o(ErrorCode errorCode) {
        if (this.k == null) {
            this.k = errorCode;
            notifyAll();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized l p() throws IOException {
        this.i.enter();
        while (this.e.isEmpty() && this.k == null) {
            try {
                r();
            } catch (Throwable th) {
                this.i.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.i.exitAndThrowIfTimedOut();
        if (!this.e.isEmpty()) {
        } else {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.k);
        }
        return this.e.removeFirst();
    }

    public synchronized l q() throws IOException {
        if (this.k != null) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.k);
        }
        b bVar = this.g;
        if (!bVar.f || !bVar.a.exhausted() || !this.g.b.exhausted()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return this.g.d != null ? this.g.d : okhttp3.internal.a.EMPTY_HEADERS;
    }

    /* access modifiers changed from: package-private */
    public void r() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public o s() {
        return this.j;
    }
}
