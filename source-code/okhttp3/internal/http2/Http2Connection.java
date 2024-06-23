package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import tb.oq1;

/* compiled from: Taobao */
public final class Http2Connection implements Closeable {
    private static final ExecutorService y = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.a.I("OkHttp Http2Connection", true));
    final boolean a;
    final b b;
    final Map<Integer, e> c = new LinkedHashMap();
    final String d;
    int e;
    int f;
    private boolean g;
    private final ScheduledExecutorService h;
    private final ExecutorService i;
    final PushObserver j;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    long q = 0;
    long r;
    h s = new h();
    final h t;
    final Socket u;
    final f v;
    final ReaderRunnable w;
    final Set<Integer> x;

    /* compiled from: Taobao */
    final class IntervalPingRunnable extends NamedRunnable {
        IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.d);
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.l < Http2Connection.this.k) {
                    z = true;
                } else {
                    Http2Connection.e(Http2Connection.this);
                    z = false;
                }
            }
            if (z) {
                Http2Connection.this.o(null);
            } else {
                Http2Connection.this.I(false, 1, 0);
            }
        }
    }

    /* compiled from: Taobao */
    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.d, Integer.valueOf(i), Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.I(this.reply, this.payload1, this.payload2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.d);
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        /* access modifiers changed from: package-private */
        public void applyAndAckSettings(boolean z, h hVar) {
            e[] eVarArr;
            long j;
            synchronized (Http2Connection.this.v) {
                synchronized (Http2Connection.this) {
                    int d = Http2Connection.this.t.d();
                    if (z) {
                        Http2Connection.this.t.a();
                    }
                    Http2Connection.this.t.h(hVar);
                    int d2 = Http2Connection.this.t.d();
                    eVarArr = null;
                    if (d2 == -1 || d2 == d) {
                        j = 0;
                    } else {
                        j = (long) (d2 - d);
                        if (!Http2Connection.this.c.isEmpty()) {
                            eVarArr = (e[]) Http2Connection.this.c.values().toArray(new e[Http2Connection.this.c.size()]);
                        }
                    }
                }
                try {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.v.a(http2Connection.t);
                } catch (IOException e) {
                    Http2Connection.this.o(e);
                }
            }
            if (eVarArr != null) {
                for (e eVar : eVarArr) {
                    synchronized (eVar) {
                        eVar.a(j);
                    }
                }
            }
            Http2Connection.y.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.d) {
                /* class okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass3 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.b.a(http2Connection);
                }
            });
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.z(i)) {
                Http2Connection.this.u(i, bufferedSource, i2, z);
                return;
            }
            e p = Http2Connection.this.p(i);
            if (p == null) {
                Http2Connection.this.K(i, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i2;
                Http2Connection.this.F(j);
                bufferedSource.skip(j);
                return;
            }
            p.m(bufferedSource, i2);
            if (z) {
                p.n(okhttp3.internal.a.EMPTY_HEADERS, true);
            }
        }

        /* access modifiers changed from: protected */
        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Throwable th;
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                this.reader.c(this);
                while (this.reader.b(false, this)) {
                }
                errorCode = ErrorCode.NO_ERROR;
                try {
                    Http2Connection.this.n(errorCode, ErrorCode.CANCEL, null);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                        Http2Connection.this.n(errorCode3, errorCode3, e);
                        okhttp3.internal.a.g(this.reader);
                    } catch (Throwable th2) {
                        th = th2;
                        Http2Connection.this.n(errorCode, errorCode2, e);
                        okhttp3.internal.a.g(this.reader);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                errorCode = errorCode2;
                ErrorCode errorCode32 = ErrorCode.PROTOCOL_ERROR;
                Http2Connection.this.n(errorCode32, errorCode32, e);
                okhttp3.internal.a.g(this.reader);
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode2;
                Http2Connection.this.n(errorCode, errorCode2, e);
                okhttp3.internal.a.g(this.reader);
                throw th;
            }
            okhttp3.internal.a.g(this.reader);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            e[] eVarArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                eVarArr = (e[]) Http2Connection.this.c.values().toArray(new e[Http2Connection.this.c.size()]);
                Http2Connection.this.g = true;
            }
            for (e eVar : eVarArr) {
                if (eVar.g() > i && eVar.j()) {
                    eVar.o(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.A(eVar.g());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<a> list) {
            if (Http2Connection.this.z(i)) {
                Http2Connection.this.w(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                e p = Http2Connection.this.p(i);
                if (p != null) {
                    p.n(okhttp3.internal.a.K(list), z);
                } else if (!Http2Connection.this.g) {
                    Http2Connection http2Connection = Http2Connection.this;
                    if (i > http2Connection.e) {
                        if (i % 2 != http2Connection.f % 2) {
                            final e eVar = new e(i, Http2Connection.this, false, z, okhttp3.internal.a.K(list));
                            Http2Connection http2Connection2 = Http2Connection.this;
                            http2Connection2.e = i;
                            http2Connection2.c.put(Integer.valueOf(i), eVar);
                            Http2Connection.y.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.d, Integer.valueOf(i)}) {
                                /* class okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass1 */

                                @Override // okhttp3.internal.NamedRunnable
                                public void execute() {
                                    try {
                                        Http2Connection.this.b.b(eVar);
                                    } catch (IOException e) {
                                        oq1 j = oq1.j();
                                        j.q(4, "Http2Connection.Listener failure for " + Http2Connection.this.d, e);
                                        try {
                                            eVar.d(ErrorCode.PROTOCOL_ERROR, e);
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            if (z) {
                synchronized (Http2Connection.this) {
                    if (i == 1) {
                        try {
                            Http2Connection.c(Http2Connection.this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (i == 2) {
                        Http2Connection.l(Http2Connection.this);
                    } else if (i == 3) {
                        Http2Connection.m(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                }
                return;
            }
            try {
                Http2Connection.this.h.execute(new PingRunnable(true, i, i2));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<a> list) {
            Http2Connection.this.x(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.z(i)) {
                Http2Connection.this.y(i, errorCode);
                return;
            }
            e A = Http2Connection.this.A(i);
            if (A != null) {
                A.o(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z, final h hVar) {
            try {
                Http2Connection.this.h.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.d}) {
                    /* class okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass2 */

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z, hVar);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.r += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            e p = Http2Connection.this.p(i);
            if (p != null) {
                synchronized (p) {
                    p.a(j);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static class a {
        Socket a;
        String b;
        BufferedSource c;
        BufferedSink d;
        b e = b.REFUSE_INCOMING_STREAMS;
        PushObserver f = PushObserver.CANCEL;
        boolean g;
        int h;

        public a(boolean z) {
            this.g = z;
        }

        public Http2Connection a() {
            return new Http2Connection(this);
        }

        public a b(b bVar) {
            this.e = bVar;
            return this;
        }

        public a c(int i) {
            this.h = i;
            return this;
        }

        public a d(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.a = socket;
            this.b = str;
            this.c = bufferedSource;
            this.d = bufferedSink;
            return this;
        }
    }

    /* compiled from: Taobao */
    public static abstract class b {
        public static final b REFUSE_INCOMING_STREAMS = new a();

        /* compiled from: Taobao */
        class a extends b {
            a() {
            }

            @Override // okhttp3.internal.http2.Http2Connection.b
            public void b(e eVar) throws IOException {
                eVar.d(ErrorCode.REFUSED_STREAM, null);
            }
        }

        public void a(Http2Connection http2Connection) {
        }

        public abstract void b(e eVar) throws IOException;
    }

    Http2Connection(a aVar) {
        h hVar = new h();
        this.t = hVar;
        this.x = new LinkedHashSet();
        this.j = aVar.f;
        boolean z = aVar.g;
        this.a = z;
        this.b = aVar.e;
        int i2 = z ? 1 : 2;
        this.f = i2;
        if (z) {
            this.f = i2 + 2;
        }
        if (z) {
            this.s.i(7, 16777216);
        }
        String str = aVar.b;
        this.d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, okhttp3.internal.a.I(okhttp3.internal.a.q("OkHttp %s Writer", str), false));
        this.h = scheduledThreadPoolExecutor;
        if (aVar.h != 0) {
            IntervalPingRunnable intervalPingRunnable = new IntervalPingRunnable();
            int i3 = aVar.h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, (long) i3, (long) i3, TimeUnit.MILLISECONDS);
        }
        this.i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.a.I(okhttp3.internal.a.q("OkHttp %s Push Observer", str), true));
        hVar.i(7, 65535);
        hVar.i(5, 16384);
        this.r = (long) hVar.d();
        this.u = aVar.a;
        this.v = new f(aVar.d, z);
        this.w = new ReaderRunnable(new Http2Reader(aVar.c, z));
    }

    static /* synthetic */ long c(Http2Connection http2Connection) {
        long j2 = http2Connection.l;
        http2Connection.l = 1 + j2;
        return j2;
    }

    static /* synthetic */ long e(Http2Connection http2Connection) {
        long j2 = http2Connection.k;
        http2Connection.k = 1 + j2;
        return j2;
    }

    static /* synthetic */ long l(Http2Connection http2Connection) {
        long j2 = http2Connection.n;
        http2Connection.n = 1 + j2;
        return j2;
    }

    static /* synthetic */ long m(Http2Connection http2Connection) {
        long j2 = http2Connection.o;
        http2Connection.o = 1 + j2;
        return j2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(@Nullable IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        n(errorCode, errorCode, iOException);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    private e s(int i2, List<a> list, boolean z) throws IOException {
        int i3;
        e eVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.v) {
            synchronized (this) {
                if (this.f > 1073741823) {
                    C(ErrorCode.REFUSED_STREAM);
                }
                if (!this.g) {
                    i3 = this.f;
                    this.f = i3 + 2;
                    eVar = new e(i3, this, z3, false, null);
                    if (z && this.r != 0) {
                        if (eVar.b != 0) {
                            z2 = false;
                            if (eVar.k()) {
                                this.c.put(Integer.valueOf(i3), eVar);
                            }
                        }
                    }
                    z2 = true;
                    if (eVar.k()) {
                    }
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            if (i2 == 0) {
                this.v.e(z3, i3, list);
            } else if (!this.a) {
                this.v.pushPromise(i2, i3, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.v.flush();
        }
        return eVar;
    }

    private synchronized void v(NamedRunnable namedRunnable) {
        if (!this.g) {
            this.i.execute(namedRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized e A(int i2) {
        e remove;
        remove = this.c.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    /* access modifiers changed from: package-private */
    public void B() {
        synchronized (this) {
            long j2 = this.n;
            long j3 = this.m;
            if (j2 >= j3) {
                this.m = j3 + 1;
                this.p = System.nanoTime() + 1000000000;
                try {
                    this.h.execute(new NamedRunnable("OkHttp %s ping", this.d) {
                        /* class okhttp3.internal.http2.Http2Connection.AnonymousClass3 */

                        @Override // okhttp3.internal.NamedRunnable
                        public void execute() {
                            Http2Connection.this.I(false, 2, 0);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void C(ErrorCode errorCode) throws IOException {
        synchronized (this.v) {
            synchronized (this) {
                if (!this.g) {
                    this.g = true;
                    this.v.d(this.e, errorCode, okhttp3.internal.a.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void D() throws IOException {
        E(true);
    }

    /* access modifiers changed from: package-private */
    public void E(boolean z) throws IOException {
        if (z) {
            this.v.connectionPreface();
            this.v.g(this.s);
            int d2 = this.s.d();
            if (d2 != 65535) {
                this.v.windowUpdate(0, (long) (d2 - 65535));
            }
        }
        new Thread(this.w).start();
    }

    /* access modifiers changed from: package-private */
    public synchronized void F(long j2) {
        long j3 = this.q + j2;
        this.q = j3;
        if (j3 >= ((long) (this.s.d() / 2))) {
            L(0, this.q);
            this.q = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.v.maxDataLength());
        r6 = (long) r3;
        r8.r -= r6;
     */
    public void G(int i2, boolean z, Buffer buffer, long j2) throws IOException {
        int min;
        long j3;
        if (j2 == 0) {
            this.v.data(z, i2, buffer, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        long j4 = this.r;
                        if (j4 > 0) {
                            break;
                        } else if (this.c.containsKey(Integer.valueOf(i2))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
            }
            j2 -= j3;
            this.v.data(z && j2 == 0, i2, buffer, min);
        }
    }

    /* access modifiers changed from: package-private */
    public void H(int i2, boolean z, List<a> list) throws IOException {
        this.v.e(z, i2, list);
    }

    /* access modifiers changed from: package-private */
    public void I(boolean z, int i2, int i3) {
        try {
            this.v.ping(z, i2, i3);
        } catch (IOException e2) {
            o(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(int i2, ErrorCode errorCode) throws IOException {
        this.v.f(i2, errorCode);
    }

    /* access modifiers changed from: package-private */
    public void K(final int i2, final ErrorCode errorCode) {
        try {
            this.h.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.d, Integer.valueOf(i2)}) {
                /* class okhttp3.internal.http2.Http2Connection.AnonymousClass1 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.J(i2, errorCode);
                    } catch (IOException e) {
                        Http2Connection.this.o(e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void L(final int i2, final long j2) {
        try {
            this.h.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.d, Integer.valueOf(i2)}) {
                /* class okhttp3.internal.http2.Http2Connection.AnonymousClass2 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.v.windowUpdate(i2, j2);
                    } catch (IOException e) {
                        Http2Connection.this.o(e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public void flush() throws IOException {
        this.v.flush();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003a */
    public void n(ErrorCode errorCode, ErrorCode errorCode2, @Nullable IOException iOException) {
        try {
            C(errorCode);
        } catch (IOException unused) {
        }
        e[] eVarArr = null;
        synchronized (this) {
            if (!this.c.isEmpty()) {
                eVarArr = (e[]) this.c.values().toArray(new e[this.c.size()]);
                this.c.clear();
            }
        }
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                try {
                    eVar.d(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        this.v.close();
        try {
            this.u.close();
        } catch (IOException unused3) {
        }
        this.h.shutdown();
        this.i.shutdown();
    }

    /* access modifiers changed from: package-private */
    public synchronized e p(int i2) {
        return this.c.get(Integer.valueOf(i2));
    }

    public synchronized boolean q(long j2) {
        if (this.g) {
            return false;
        }
        if (this.n >= this.m || j2 < this.p) {
            return true;
        }
        return false;
    }

    public synchronized int r() {
        return this.t.e(Integer.MAX_VALUE);
    }

    public e t(List<a> list, boolean z) throws IOException {
        return s(0, list, z);
    }

    /* access modifiers changed from: package-private */
    public void u(final int i2, BufferedSource bufferedSource, final int i3, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j2 = (long) i3;
        bufferedSource.require(j2);
        bufferedSource.read(buffer, j2);
        if (buffer.size() == j2) {
            v(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.d, Integer.valueOf(i2)}) {
                /* class okhttp3.internal.http2.Http2Connection.AnonymousClass6 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.j.onData(i2, buffer, i3, z);
                        if (onData) {
                            Http2Connection.this.v.f(i2, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.x.remove(Integer.valueOf(i2));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i3);
    }

    /* access modifiers changed from: package-private */
    public void w(final int i2, final List<a> list, final boolean z) {
        try {
            v(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.d, Integer.valueOf(i2)}) {
                /* class okhttp3.internal.http2.Http2Connection.AnonymousClass5 */

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    boolean onHeaders = Http2Connection.this.j.onHeaders(i2, list, z);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.v.f(i2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (onHeaders || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.x.remove(Integer.valueOf(i2));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void x(final int i2, final List<a> list) {
        synchronized (this) {
            if (this.x.contains(Integer.valueOf(i2))) {
                K(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.x.add(Integer.valueOf(i2));
            try {
                v(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.d, Integer.valueOf(i2)}) {
                    /* class okhttp3.internal.http2.Http2Connection.AnonymousClass4 */

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        if (Http2Connection.this.j.onRequest(i2, list)) {
                            try {
                                Http2Connection.this.v.f(i2, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.x.remove(Integer.valueOf(i2));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y(final int i2, final ErrorCode errorCode) {
        v(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.d, Integer.valueOf(i2)}) {
            /* class okhttp3.internal.http2.Http2Connection.AnonymousClass7 */

            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.j.onReset(i2, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.x.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean z(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }
}
