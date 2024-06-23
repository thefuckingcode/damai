package okio;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: Taobao */
public final class g implements Source {
    private final BufferedSource a;
    private final Inflater b;
    private int c;
    private boolean d;

    public g(Source source, Inflater inflater) {
        this(h.d(source), inflater);
    }

    private void c() throws IOException {
        int i = this.c;
        if (i != 0) {
            int remaining = i - this.b.getRemaining();
            this.c -= remaining;
            this.a.skip((long) remaining);
        }
    }

    public final boolean a() throws IOException {
        if (!this.b.needsInput()) {
            return false;
        }
        c();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.a.exhausted()) {
            return true;
        } else {
            m mVar = this.a.buffer().head;
            int i = mVar.c;
            int i2 = mVar.b;
            int i3 = i - i2;
            this.c = i3;
            this.b.setInput(mVar.a, i2, i3);
            return false;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            this.b.end();
            this.d = true;
            this.a.close();
        }
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        m writableSegment;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.d) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean a2 = a();
                try {
                    writableSegment = buffer.writableSegment(1);
                    int inflate = this.b.inflate(writableSegment.a, writableSegment.c, (int) Math.min(j, (long) (8192 - writableSegment.c)));
                    if (inflate > 0) {
                        writableSegment.c += inflate;
                        long j2 = (long) inflate;
                        buffer.size += j2;
                        return j2;
                    } else if (this.b.finished()) {
                        break;
                    } else if (this.b.needsDictionary()) {
                        break;
                    } else if (a2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            c();
            if (writableSegment.b != writableSegment.c) {
                return -1;
            }
            buffer.head = writableSegment.b();
            n.a(writableSegment);
            return -1;
        }
    }

    @Override // okio.Source
    public o timeout() {
        return this.a.timeout();
    }

    g(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.a = bufferedSource;
            this.b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
