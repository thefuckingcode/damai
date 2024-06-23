package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class l implements BufferedSource {
    public final Buffer a = new Buffer();
    public final Source b;
    boolean c;

    l(Source source) {
        Objects.requireNonNull(source, "source == null");
        this.b = source;
    }

    @Override // okio.BufferedSource
    public Buffer buffer() {
        return this.a;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.clear();
        }
    }

    @Override // okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (!this.c) {
            return this.a.exhausted() && this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this.a;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) throws IOException {
        return indexOf(b2, 0, AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new a();
    }

    public boolean isOpen() {
        return !this.c;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return h.d(new j(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) throws IOException {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.c) {
            Buffer buffer2 = this.a;
            if (buffer2.size == 0 && this.b.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return this.a.read(buffer, Math.min(j, this.a.size));
        } else {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        if (sink != null) {
            long j = 0;
            while (this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                long completeSegmentByteCount = this.a.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j += completeSegmentByteCount;
                    sink.write(this.a, completeSegmentByteCount);
                }
            }
            if (this.a.size() <= 0) {
                return j;
            }
            long size = j + this.a.size();
            Buffer buffer = this.a;
            sink.write(buffer, buffer.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public byte readByte() throws IOException {
        require(1);
        return this.a.readByte();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.a.writeAll(this.b);
        return this.a.readByteArray();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() throws IOException {
        this.a.writeAll(this.b);
        return this.a.readByteString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    @Override // okio.BufferedSource
    public long readDecimalLong() throws IOException {
        require(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request((long) i2)) {
                break;
            }
            byte b2 = this.a.getByte((long) i);
            if ((b2 >= 48 && b2 <= 57) || (i == 0 && b2 == 45)) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b2)));
            }
        }
        if (i == 0) {
        }
        return this.a.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            require((long) bArr.length);
            this.a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer buffer = this.a;
                long j = buffer.size;
                if (j > 0) {
                    int read = buffer.read(bArr, i, (int) j);
                    if (read != -1) {
                        i += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws IOException {
        require(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request((long) i2)) {
                break;
            }
            byte b2 = this.a.getByte((long) i);
            if ((b2 >= 48 && b2 <= 57) || ((b2 >= 97 && b2 <= 102) || (b2 >= 65 && b2 <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b2)));
            }
        }
        return this.a.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() throws IOException {
        require(4);
        return this.a.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4);
        return this.a.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() throws IOException {
        require(8);
        return this.a.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws IOException {
        require(8);
        return this.a.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() throws IOException {
        require(2);
        return this.a.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2);
        return this.a.readShortLe();
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        if (charset != null) {
            this.a.writeAll(this.b);
            return this.a.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    public String readUtf8() throws IOException {
        this.a.writeAll(this.b);
        return this.a.readUtf8();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        require(1);
        byte b2 = this.a.getByte(0);
        if ((b2 & 224) == 192) {
            require(2);
        } else if ((b2 & 240) == 224) {
            require(3);
        } else if ((b2 & 248) == 240) {
            require(4);
        }
        return this.a.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.a.readUtf8Line(indexOf);
        }
        long j = this.a.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) throws IOException {
        Buffer buffer;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.c) {
            do {
                buffer = this.a;
                if (buffer.size >= j) {
                    return true;
                }
            } while (this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return false;
        } else {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    @Override // okio.BufferedSource
    public void require(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(i iVar) throws IOException {
        if (!this.c) {
            do {
                int selectPrefix = this.a.selectPrefix(iVar, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.a.skip((long) iVar.a[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.b.read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return -1;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws IOException {
        if (!this.c) {
            while (j > 0) {
                Buffer buffer = this.a;
                if (buffer.size == 0 && this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.a.size());
                this.a.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException(IRequestConst.CLOSED);
    }

    @Override // okio.Source
    public o timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + jl1.BRACKET_END_STR;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j) throws IOException {
        return indexOf(b2, j, AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) throws IOException {
        if (!this.c) {
            while (true) {
                long indexOfElement = this.a.indexOfElement(byteString, j);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                Buffer buffer = this.a;
                long j2 = buffer.size;
                if (this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j = Math.max(j, j2);
            }
        } else {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        } else if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!(request(1 + j2) && this.a.getByte(j2) == byteString.getByte(i + i3))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == AbsPerformance.LONG_NIL ? Long.MAX_VALUE : j + 1;
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return this.a.readUtf8Line(indexOf);
            }
            if (j2 < AbsPerformance.LONG_NIL && request(j2) && this.a.getByte(j2 - 1) == 13 && request(1 + j2) && this.a.getByte(j2) == 10) {
                return this.a.readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.a;
            buffer2.copyTo(buffer, 0, Math.min(32L, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.a.size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(IRequestConst.CLOSED);
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        } else {
            while (j < j2) {
                long indexOf = this.a.indexOf(b2, j, j2);
                if (indexOf == -1) {
                    Buffer buffer = this.a;
                    long j3 = buffer.size;
                    if (j3 >= j2 || this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws IOException {
        require(j);
        return this.a.readByteArray(j);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws IOException {
        require(j);
        return this.a.readByteString(j);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws IOException {
        require(j);
        return this.a.readUtf8(j);
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws IOException {
        require(j);
        if (charset != null) {
            return this.a.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* compiled from: Taobao */
    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            l lVar = l.this;
            if (!lVar.c) {
                return (int) Math.min(lVar.a.size, 2147483647L);
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            l.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            l lVar = l.this;
            if (!lVar.c) {
                Buffer buffer = lVar.a;
                if (buffer.size == 0 && lVar.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return l.this.a.readByte() & 255;
            }
            throw new IOException(IRequestConst.CLOSED);
        }

        public String toString() {
            return l.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!l.this.c) {
                p.b((long) bArr.length, (long) i, (long) i2);
                l lVar = l.this;
                Buffer buffer = lVar.a;
                if (buffer.size == 0 && lVar.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return l.this.a.read(bArr, i, i2);
            }
            throw new IOException(IRequestConst.CLOSED);
        }
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws IOException {
        try {
            require(j);
            this.a.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(this.a);
            throw e;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = (long) i2;
        p.b((long) bArr.length, (long) i, j);
        Buffer buffer = this.a;
        if (buffer.size == 0 && this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.a.read(bArr, i, (int) Math.min(j, this.a.size));
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        if (!this.c) {
            while (true) {
                long indexOf = this.a.indexOf(byteString, j);
                if (indexOf != -1) {
                    return indexOf;
                }
                Buffer buffer = this.a;
                long j2 = buffer.size;
                if (this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j = Math.max(j, (j2 - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException(IRequestConst.CLOSED);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer = this.a;
        if (buffer.size == 0 && this.b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }
}
