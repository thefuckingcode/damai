package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.o;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b {
    final boolean a;
    final Random b;
    final BufferedSink c;
    final Buffer d;
    boolean e;
    final Buffer f = new Buffer();
    final a g = new a();
    boolean h;
    private final byte[] i;
    private final Buffer.c j;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class a implements Sink {
        int a;
        long b;
        boolean c;
        boolean d;

        a() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, okio.Sink
        public void close() throws IOException {
            if (!this.d) {
                b bVar = b.this;
                bVar.d(this.a, bVar.f.size(), this.c, true);
                this.d = true;
                b.this.h = false;
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!this.d) {
                b bVar = b.this;
                bVar.d(this.a, bVar.f.size(), this.c, false);
                this.c = false;
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // okio.Sink
        public o timeout() {
            return b.this.c.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!this.d) {
                b.this.f.write(buffer, j);
                boolean z = this.c && this.b != -1 && b.this.f.size() > this.b - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                long completeSegmentByteCount = b.this.f.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z) {
                    b.this.d(this.a, completeSegmentByteCount, this.c, false);
                    this.c = false;
                    return;
                }
                return;
            }
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    b(boolean z, BufferedSink bufferedSink, Random random) {
        Objects.requireNonNull(bufferedSink, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.a = z;
        this.c = bufferedSink;
        this.d = bufferedSink.buffer();
        this.b = random;
        Buffer.c cVar = null;
        this.i = z ? new byte[4] : null;
        this.j = z ? new Buffer.c() : cVar;
    }

    private void c(int i2, ByteString byteString) throws IOException {
        if (!this.e) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.d.writeByte(i2 | 128);
                if (this.a) {
                    this.d.writeByte(size | 128);
                    this.b.nextBytes(this.i);
                    this.d.write(this.i);
                    if (size > 0) {
                        long size2 = this.d.size();
                        this.d.write(byteString);
                        this.d.readAndWriteUnsafe(this.j);
                        this.j.b(size2);
                        a.b(this.j, this.i);
                        this.j.close();
                    }
                } else {
                    this.d.writeByte(size);
                    this.d.write(byteString);
                }
                this.c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException(IRequestConst.CLOSED);
    }

    /* access modifiers changed from: package-private */
    public Sink a(int i2, long j2) {
        if (!this.h) {
            this.h = true;
            a aVar = this.g;
            aVar.a = i2;
            aVar.b = j2;
            aVar.c = true;
            aVar.d = false;
            return aVar;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i2 == 0 && byteString == null)) {
            if (i2 != 0) {
                a.c(i2);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i2);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            c(8, byteString2);
        } finally {
            this.e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, long j2, boolean z, boolean z2) throws IOException {
        if (!this.e) {
            int i3 = 0;
            if (!z) {
                i2 = 0;
            }
            if (z2) {
                i2 |= 128;
            }
            this.d.writeByte(i2);
            if (this.a) {
                i3 = 128;
            }
            if (j2 <= 125) {
                this.d.writeByte(((int) j2) | i3);
            } else if (j2 <= 65535) {
                this.d.writeByte(i3 | 126);
                this.d.writeShort((int) j2);
            } else {
                this.d.writeByte(i3 | 127);
                this.d.writeLong(j2);
            }
            if (this.a) {
                this.b.nextBytes(this.i);
                this.d.write(this.i);
                if (j2 > 0) {
                    long size = this.d.size();
                    this.d.write(this.f, j2);
                    this.d.readAndWriteUnsafe(this.j);
                    this.j.b(size);
                    a.b(this.j, this.i);
                    this.j.close();
                }
            } else {
                this.d.write(this.f, j2);
            }
            this.c.emit();
            return;
        }
        throw new IOException(IRequestConst.CLOSED);
    }

    /* access modifiers changed from: package-private */
    public void e(ByteString byteString) throws IOException {
        c(9, byteString);
    }

    /* access modifiers changed from: package-private */
    public void f(ByteString byteString) throws IOException {
        c(10, byteString);
    }
}
