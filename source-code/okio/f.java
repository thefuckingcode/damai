package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: Taobao */
public final class f implements Source {
    private int a = 0;
    private final BufferedSource b;
    private final Inflater c;
    private final g d;
    private final CRC32 e = new CRC32();

    public f(Source source) {
        if (source != null) {
            Inflater inflater = new Inflater(true);
            this.c = inflater;
            BufferedSource d2 = h.d(source);
            this.b = d2;
            this.d = new g(d2, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    private void c() throws IOException {
        this.b.require(10);
        byte b2 = this.b.buffer().getByte(3);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            f(this.b.buffer(), 0, 10);
        }
        a("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8);
        if (((b2 >> 2) & 1) == 1) {
            this.b.require(2);
            if (z) {
                f(this.b.buffer(), 0, 2);
            }
            long readShortLe = (long) this.b.buffer().readShortLe();
            this.b.require(readShortLe);
            if (z) {
                f(this.b.buffer(), 0, readShortLe);
            }
            this.b.skip(readShortLe);
        }
        if (((b2 >> 3) & 1) == 1) {
            long indexOf = this.b.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z) {
                    f(this.b.buffer(), 0, indexOf + 1);
                }
                this.b.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b2 >> 4) & 1) == 1) {
            long indexOf2 = this.b.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z) {
                    f(this.b.buffer(), 0, indexOf2 + 1);
                }
                this.b.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.b.readShortLe(), (short) ((int) this.e.getValue()));
            this.e.reset();
        }
    }

    private void e() throws IOException {
        a("CRC", this.b.readIntLe(), (int) this.e.getValue());
        a("ISIZE", this.b.readIntLe(), (int) this.c.getBytesWritten());
    }

    private void f(Buffer buffer, long j, long j2) {
        m mVar = buffer.head;
        while (true) {
            int i = mVar.c;
            int i2 = mVar.b;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            mVar = mVar.f;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) mVar.b) + j);
            int min = (int) Math.min((long) (mVar.c - i3), j2);
            this.e.update(mVar.a, i3, min);
            j2 -= (long) min;
            mVar = mVar.f;
            j = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i == 0) {
            return 0;
        } else {
            if (this.a == 0) {
                c();
                this.a = 1;
            }
            if (this.a == 1) {
                long j2 = buffer.size;
                long read = this.d.read(buffer, j);
                if (read != -1) {
                    f(buffer, j2, read);
                    return read;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                e();
                this.a = 3;
                if (!this.b.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    @Override // okio.Source
    public o timeout() {
        return this.b.timeout();
    }
}
