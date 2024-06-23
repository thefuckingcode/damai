package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import tb.jl1;

/* compiled from: Taobao */
public final class b implements Sink {
    private final BufferedSink a;
    private final Deflater b;
    private boolean c;

    public b(Sink sink, Deflater deflater) {
        this(h.c(sink), deflater);
    }

    @IgnoreJRERequirement
    private void a(boolean z) throws IOException {
        m writableSegment;
        int i;
        Buffer buffer = this.a.buffer();
        while (true) {
            writableSegment = buffer.writableSegment(1);
            if (z) {
                Deflater deflater = this.b;
                byte[] bArr = writableSegment.a;
                int i2 = writableSegment.c;
                i = deflater.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater2 = this.b;
                byte[] bArr2 = writableSegment.a;
                int i3 = writableSegment.c;
                i = deflater2.deflate(bArr2, i3, 8192 - i3);
            }
            if (i > 0) {
                writableSegment.c += i;
                buffer.size += (long) i;
                this.a.emitCompleteSegments();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (writableSegment.b == writableSegment.c) {
            buffer.head = writableSegment.b();
            n.a(writableSegment);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() throws IOException {
        this.b.finish();
        a(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() throws IOException {
        if (!this.c) {
            Throwable th = null;
            try {
                c();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.c = true;
            if (th != null) {
                p.f(th);
            }
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.a.flush();
    }

    @Override // okio.Sink
    public o timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.a + jl1.BRACKET_END_STR;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        p.b(buffer.size, 0, j);
        while (j > 0) {
            m mVar = buffer.head;
            int min = (int) Math.min(j, (long) (mVar.c - mVar.b));
            this.b.setInput(mVar.a, mVar.b, min);
            a(false);
            long j2 = (long) min;
            buffer.size -= j2;
            int i = mVar.b + min;
            mVar.b = i;
            if (i == mVar.c) {
                buffer.head = mVar.b();
                n.a(mVar);
            }
            j -= j2;
        }
    }

    b(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater != null) {
            this.a = bufferedSink;
            this.b = deflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
