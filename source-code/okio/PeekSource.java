package okio;

import com.lzy.okgo.model.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 1, 16})
/* compiled from: PeekSource.kt */
public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        Intrinsics.checkParameterIsNotNull(bufferedSource, "upstream");
        this.upstream = bufferedSource;
        Buffer buffer2 = bufferedSource.getBuffer();
        this.buffer = buffer2;
        this.expectedSegment = buffer2.head;
        Segment segment = buffer2.head;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r4 == r5.pos) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    @Override // okio.Source
    public long read(Buffer buffer2, long j) {
        Intrinsics.checkParameterIsNotNull(buffer2, "sink");
        boolean z = false;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (!this.closed) {
            Segment segment = this.expectedSegment;
            if (segment != null) {
                if (segment == this.buffer.head) {
                    int i = this.expectedPos;
                    Segment segment2 = this.buffer.head;
                    if (segment2 == null) {
                        Intrinsics.throwNpe();
                    }
                }
                if (z) {
                    throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
                } else if (j == 0) {
                    return 0;
                } else {
                    if (!this.upstream.request(this.pos + 1)) {
                        return -1;
                    }
                    if (this.expectedSegment == null && this.buffer.head != null) {
                        this.expectedSegment = this.buffer.head;
                        Segment segment3 = this.buffer.head;
                        if (segment3 == null) {
                            Intrinsics.throwNpe();
                        }
                        this.expectedPos = segment3.pos;
                    }
                    long min = Math.min(j, this.buffer.size() - this.pos);
                    this.buffer.copyTo(buffer2, this.pos, min);
                    this.pos += min;
                    return min;
                }
            }
            z = true;
            if (z) {
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }
}
