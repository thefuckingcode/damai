package okhttp3.internal.ws;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.internal.ws.WebSocketProtocol;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.WebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okhttp3.o;
import okhttp3.q;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.commons.lang3.time.DateUtils;
import tb.cz2;
import tb.f21;
import tb.ix1;

/* compiled from: Taobao */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final List<Protocol> x = Collections.singletonList(Protocol.HTTP_1_1);
    private final o a;
    final cz2 b;
    private final Random c;
    private final long d;
    private final String e;
    private Call f;
    private final Runnable g;
    private WebSocketReader h;
    private b i;
    private ScheduledExecutorService j;
    private d k;
    private final ArrayDeque<ByteString> l = new ArrayDeque<>();
    private final ArrayDeque<Object> m = new ArrayDeque<>();
    private long n;
    private boolean o;
    private ScheduledFuture<?> p;
    private int q = -1;
    private String r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private boolean w;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public void run() {
            RealWebSocket.this.k();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Callback {
        final /* synthetic */ o a;

        a(o oVar) {
            this.a = oVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            RealWebSocket.this.e(iOException, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, q qVar) {
            okhttp3.internal.connection.c f = f21.a.f(qVar);
            try {
                RealWebSocket.this.b(qVar, f);
                d i = f.i();
                try {
                    RealWebSocket.this.f("OkHttp WebSocket " + this.a.i().A(), i);
                    cz2 cz2 = RealWebSocket.this.b;
                    throw null;
                } catch (Exception e) {
                    RealWebSocket.this.e(e, null);
                }
            } catch (IOException e2) {
                if (f != null) {
                    f.q();
                }
                RealWebSocket.this.e(e2, qVar);
                okhttp3.internal.a.g(qVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b {
        final int a;
        final ByteString b;
        final long c;

        b(int i, ByteString byteString, long j) {
            this.a = i;
            this.b = byteString;
            this.c = j;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class c {
        final int a;
        final ByteString b;

        c(int i, ByteString byteString) {
            this.a = i;
            this.b = byteString;
        }
    }

    /* compiled from: Taobao */
    public static abstract class d implements Closeable {
        public final boolean a;
        public final BufferedSource b;
        public final BufferedSink c;

        public d(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.a = z;
            this.b = bufferedSource;
            this.c = bufferedSink;
        }
    }

    public RealWebSocket(o oVar, cz2 cz2, Random random, long j2) {
        if ("GET".equals(oVar.g())) {
            this.a = oVar;
            this.c = random;
            this.d = j2;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.e = ByteString.of(bArr).base64();
            this.g = new ix1(this);
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + oVar.g());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        do {
            try {
            } catch (IOException e2) {
                e(e2, null);
                return;
            }
        } while (j());
    }

    private void h() {
        ScheduledExecutorService scheduledExecutorService = this.j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.g);
        }
    }

    private synchronized boolean i(ByteString byteString, int i2) {
        if (!this.s) {
            if (!this.o) {
                if (this.n + ((long) byteString.size()) > 16777216) {
                    close(1001, null);
                    return false;
                }
                this.n += (long) byteString.size();
                this.m.add(new c(i2, byteString));
                h();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(q qVar, @Nullable okhttp3.internal.connection.c cVar) throws IOException {
        if (qVar.e() == 101) {
            String g2 = qVar.g(IRequestConst.CONNECTION);
            if ("Upgrade".equalsIgnoreCase(g2)) {
                String g3 = qVar.g("Upgrade");
                if ("websocket".equalsIgnoreCase(g3)) {
                    String g4 = qVar.g("Sec-WebSocket-Accept");
                    String base64 = ByteString.encodeUtf8(this.e + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                    if (!base64.equals(g4)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + g4 + "'");
                    } else if (cVar == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + g3 + "'");
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + g2 + "'");
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + qVar.e() + " " + qVar.k() + "'");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean c(int i2, String str, long j2) {
        a.c(i2);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (((long) byteString.size()) > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.s) {
            if (!this.o) {
                this.o = true;
                this.m.add(new b(i2, byteString, j2));
                h();
                return true;
            }
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.f.cancel();
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i2, String str) {
        return c(i2, str, DateUtils.MILLIS_PER_MINUTE);
    }

    public void d(OkHttpClient okHttpClient) {
        OkHttpClient b2 = okHttpClient.newBuilder().g(EventListener.NONE).j(x).b();
        o b3 = this.a.h().d("Upgrade", "websocket").d(IRequestConst.CONNECTION, "Upgrade").d("Sec-WebSocket-Key", this.e).d("Sec-WebSocket-Version", "13").b();
        Call h2 = f21.a.h(b2, b3);
        this.f = h2;
        h2.enqueue(new a(b3));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        okhttp3.internal.a.g(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
        throw r4;
     */
    public void e(Exception exc, @Nullable q qVar) {
        synchronized (this) {
            if (!this.s) {
                this.s = true;
                d dVar = this.k;
                this.k = null;
                ScheduledFuture<?> scheduledFuture = this.p;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledExecutorService scheduledExecutorService = this.j;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
            }
        }
    }

    public void f(String str, d dVar) throws IOException {
        synchronized (this) {
            this.k = dVar;
            this.i = new b(dVar.a, dVar.c, this.c);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, okhttp3.internal.a.I(str, false));
            this.j = scheduledThreadPoolExecutor;
            if (this.d != 0) {
                PingRunnable pingRunnable = new PingRunnable();
                long j2 = this.d;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j2, j2, TimeUnit.MILLISECONDS);
            }
            if (!this.m.isEmpty()) {
                h();
            }
        }
        this.h = new WebSocketReader(dVar.a, dVar.b, this);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r2 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        if ((r4 instanceof okhttp3.internal.ws.RealWebSocket.c) == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r2 = ((okhttp3.internal.ws.RealWebSocket.c) r4).b;
        r0 = okio.h.c(r0.a(((okhttp3.internal.ws.RealWebSocket.c) r4).a, (long) r2.size()));
        r0.write(r2);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r9.n -= (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if ((r4 instanceof okhttp3.internal.ws.RealWebSocket.b) == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0086, code lost:
        r4 = (okhttp3.internal.ws.RealWebSocket.b) r4;
        r0.b(r4.a, r4.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        if (r1 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        okhttp3.internal.a.g(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009c, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009e, code lost:
        okhttp3.internal.a.g(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a1, code lost:
        throw r0;
     */
    public boolean j() throws IOException {
        Object obj;
        d dVar;
        synchronized (this) {
            if (this.s) {
                return false;
            }
            b bVar = this.i;
            ByteString poll = this.l.poll();
            if (poll == null) {
                obj = this.m.poll();
                if (obj instanceof b) {
                    if (this.q != -1) {
                        dVar = this.k;
                        this.k = null;
                        this.j.shutdown();
                    } else {
                        this.p = this.j.schedule(new CancelRunnable(), ((b) obj).c, TimeUnit.MILLISECONDS);
                    }
                } else if (obj == null) {
                    return false;
                }
                dVar = null;
            } else {
                dVar = null;
                obj = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r1 == -1) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        e(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.d + "ms (after " + (r1 - 1) + " successful ping/pongs)"), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.e(okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        e(r0, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    public void k() {
        synchronized (this) {
            if (!this.s) {
                b bVar = this.i;
                int i2 = this.w ? this.t : -1;
                this.t++;
                this.w = true;
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i2, String str) {
        d dVar;
        if (i2 != -1) {
            synchronized (this) {
                if (this.q == -1) {
                    this.q = i2;
                    this.r = str;
                    if (!this.o || !this.m.isEmpty()) {
                        dVar = null;
                    } else {
                        dVar = this.k;
                        this.k = null;
                        ScheduledFuture<?> scheduledFuture = this.p;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this.j.shutdown();
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                throw null;
            } catch (Throwable th) {
                okhttp3.internal.a.g(dVar);
                throw th;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        throw null;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        if (!this.s) {
            if (!this.o || !this.m.isEmpty()) {
                this.l.add(byteString);
                h();
                this.u++;
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.v++;
        this.w = false;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.n;
    }

    @Override // okhttp3.WebSocket
    public o request() {
        return this.a;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        Objects.requireNonNull(str, "text == null");
        return i(ByteString.encodeUtf8(str), 1);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        throw null;
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        Objects.requireNonNull(byteString, "bytes == null");
        return i(byteString, 2);
    }
}
