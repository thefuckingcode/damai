package okio;

import com.lzy.okgo.model.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 1, 16})
/* compiled from: Pipe.kt */
public final class Pipe$sink$1 implements Sink {
    final /* synthetic */ Pipe this$0;
    private final Timeout timeout = new Timeout();

    /* JADX WARN: Incorrect args count in method signature: ()V */
    Pipe$sink$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "source");
        Sink sink = null;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!this.this$0.getSinkClosed$okio()) {
                while (true) {
                    if (j <= 0) {
                        break;
                    }
                    Sink foldedSink$okio = this.this$0.getFoldedSink$okio();
                    if (foldedSink$okio != null) {
                        sink = foldedSink$okio;
                        break;
                    } else if (!this.this$0.getSourceClosed$okio()) {
                        long maxBufferSize$okio = this.this$0.getMaxBufferSize$okio() - this.this$0.getBuffer$okio().size();
                        if (maxBufferSize$okio == 0) {
                            this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
                        } else {
                            long min = Math.min(maxBufferSize$okio, j);
                            this.this$0.getBuffer$okio().write(buffer, min);
                            j -= min;
                            Buffer buffer$okio = this.this$0.getBuffer$okio();
                            if (buffer$okio != null) {
                                buffer$okio.notifyAll();
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                            }
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        if (sink != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.write(buffer, j);
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.write(buffer, j);
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        Sink sink = null;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!this.this$0.getSinkClosed$okio()) {
                Sink foldedSink$okio = this.this$0.getFoldedSink$okio();
                if (foldedSink$okio != null) {
                    sink = foldedSink$okio;
                } else if (this.this$0.getSourceClosed$okio()) {
                    if (this.this$0.getBuffer$okio().size() > 0) {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
        if (sink != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.flush();
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.flush();
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r1 = r11.this$0;
        r2 = r0.timeout();
        r1 = r1.sink().timeout();
        r3 = r2.timeoutNanos();
        r2.timeout(okio.Timeout.Companion.minTimeout(r1.timeoutNanos(), r2.timeoutNanos()), java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        if (r2.hasDeadline() == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r5 = r2.deadlineNanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008c, code lost:
        if (r1.hasDeadline() == false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
        r2.deadlineNanoTime(java.lang.Math.min(r2.deadlineNanoTime(), r1.deadlineNanoTime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00af, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b0, code lost:
        r2.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
        if (r1.hasDeadline() != false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        r2.deadlineNanoTime(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00be, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c3, code lost:
        if (r1.hasDeadline() == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c5, code lost:
        r2.deadlineNanoTime(r1.deadlineNanoTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00df, code lost:
        r2.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e8, code lost:
        if (r1.hasDeadline() != false) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ea, code lost:
        r2.clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ed, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() {
        Sink sink = null;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!this.this$0.getSinkClosed$okio()) {
                Sink foldedSink$okio = this.this$0.getFoldedSink$okio();
                if (foldedSink$okio != null) {
                    sink = foldedSink$okio;
                } else if (!this.this$0.getSourceClosed$okio() || this.this$0.getBuffer$okio().size() <= 0) {
                    this.this$0.setSinkClosed$okio(true);
                    Buffer buffer$okio = this.this$0.getBuffer$okio();
                    if (buffer$okio != null) {
                        buffer$okio.notifyAll();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                    }
                } else {
                    throw new IOException("source is closed");
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.timeout;
    }
}
