package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import tb.jl1;

/* compiled from: Taobao */
public class AsyncTimeout extends o {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    @Nullable
    static AsyncTimeout head;
    private boolean inQueue;
    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class Watchdog extends Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0015, code lost:
            r1.timedOut();
         */
        public void run() {
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        AsyncTimeout awaitTimeout = AsyncTimeout.awaitTimeout();
                        if (awaitTimeout != null) {
                            if (awaitTimeout == AsyncTimeout.head) {
                                AsyncTimeout.head = null;
                                return;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Sink {
        final /* synthetic */ Sink a;

        a(Sink sink) {
            this.a = sink;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            AsyncTimeout.this.enter();
            try {
                this.a.close();
                AsyncTimeout.this.exit(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.exit(e);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            AsyncTimeout.this.enter();
            try {
                this.a.flush();
                AsyncTimeout.this.exit(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.exit(e);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        @Override // okio.Sink
        public o timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.a + jl1.BRACKET_END_STR;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            p.b(buffer.size, 0, j);
            while (true) {
                long j2 = 0;
                if (j > 0) {
                    m mVar = buffer.head;
                    while (true) {
                        if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            break;
                        }
                        j2 += (long) (mVar.c - mVar.b);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        mVar = mVar.f;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        this.a.write(buffer, j2);
                        j -= j2;
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e) {
                        throw AsyncTimeout.this.exit(e);
                    } catch (Throwable th) {
                        AsyncTimeout.this.exit(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Source {
        final /* synthetic */ Source a;

        b(Source source) {
            this.a = source;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            AsyncTimeout.this.enter();
            try {
                this.a.close();
                AsyncTimeout.this.exit(true);
            } catch (IOException e) {
                throw AsyncTimeout.this.exit(e);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            AsyncTimeout.this.enter();
            try {
                long read = this.a.read(buffer, j);
                AsyncTimeout.this.exit(true);
                return read;
            } catch (IOException e) {
                throw AsyncTimeout.this.exit(e);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        @Override // okio.Source
        public o timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.a + jl1.BRACKET_END_STR;
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    static AsyncTimeout awaitTimeout() throws InterruptedException {
        AsyncTimeout asyncTimeout = head.next;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = asyncTimeout.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            AsyncTimeout.class.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    private static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = head;
            while (asyncTimeout2 != null) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout3;
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (head == null) {
                head = new AsyncTimeout();
                new Watchdog().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (i != 0) {
                asyncTimeout.timeoutAt = j + nanoTime;
            } else if (z) {
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
            AsyncTimeout asyncTimeout2 = head;
            while (true) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == null) {
                    break;
                } else if (remainingNanos < asyncTimeout3.remainingNanos(nanoTime)) {
                    break;
                } else {
                    asyncTimeout2 = asyncTimeout2.next;
                }
            }
            asyncTimeout.next = asyncTimeout2.next;
            asyncTimeout2.next = asyncTimeout;
            if (asyncTimeout2 == head) {
                AsyncTimeout.class.notify();
            }
        }
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(Sink sink) {
        return new a(sink);
    }

    public final Source source(Source source) {
        return new b(source);
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    /* access modifiers changed from: package-private */
    public final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException exit(IOException iOException) throws IOException {
        if (!exit()) {
            return iOException;
        }
        return newTimeoutException(iOException);
    }
}
