package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.as2;
import tb.jl1;
import tb.z7;

/* compiled from: Taobao */
public final class Buffer implements Cloneable, ByteChannel, BufferedSink, BufferedSource {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    m head;
    long size;

    /* compiled from: Taobao */
    class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return Buffer.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            Buffer.this.writeByte((int) ((byte) i));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            Buffer.this.write(bArr, i, i2);
        }
    }

    /* compiled from: Taobao */
    class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(Buffer.this.size, 2147483647L);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            Buffer buffer = Buffer.this;
            if (buffer.size > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return Buffer.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return Buffer.this.read(bArr, i, i2);
        }
    }

    /* compiled from: Taobao */
    public static final class c implements Closeable {
        public Buffer a;
        public boolean b;
        private m c;
        public long d = -1;
        public byte[] e;
        public int f = -1;
        public int g = -1;

        public final int a() {
            long j = this.d;
            if (j == this.a.size) {
                throw new IllegalStateException();
            } else if (j == -1) {
                return b(0);
            } else {
                return b(j + ((long) (this.g - this.f)));
            }
        }

        public final int b(long j) {
            int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if (i >= 0) {
                Buffer buffer = this.a;
                long j2 = buffer.size;
                if (j <= j2) {
                    if (i == 0 || j == j2) {
                        this.c = null;
                        this.d = j;
                        this.e = null;
                        this.f = -1;
                        this.g = -1;
                        return -1;
                    }
                    long j3 = 0;
                    m mVar = buffer.head;
                    m mVar2 = this.c;
                    if (mVar2 != null) {
                        long j4 = this.d - ((long) (this.f - mVar2.b));
                        if (j4 > j) {
                            j2 = j4;
                            mVar2 = mVar;
                            mVar = mVar2;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        mVar2 = mVar;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i2 = mVar2.c;
                            int i3 = mVar2.b;
                            if (j < ((long) (i2 - i3)) + j3) {
                                break;
                            }
                            j3 += (long) (i2 - i3);
                            mVar2 = mVar2.f;
                        }
                    } else {
                        while (j2 > j) {
                            mVar = mVar.g;
                            j2 -= (long) (mVar.c - mVar.b);
                        }
                        mVar2 = mVar;
                        j3 = j2;
                    }
                    if (this.b && mVar2.d) {
                        m f2 = mVar2.f();
                        Buffer buffer2 = this.a;
                        if (buffer2.head == mVar2) {
                            buffer2.head = f2;
                        }
                        mVar2 = mVar2.c(f2);
                        mVar2.g.b();
                    }
                    this.c = mVar2;
                    this.d = j;
                    this.e = mVar2.a;
                    int i4 = mVar2.b + ((int) (j - j3));
                    this.f = i4;
                    int i5 = mVar2.c;
                    this.g = i5;
                    return i5 - i4;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.a.size)));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a != null) {
                this.a = null;
                this.c = null;
                this.d = -1;
                this.e = null;
                this.f = -1;
                this.g = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            m mVar = this.head;
            if (mVar != null) {
                byte[] bArr = mVar.a;
                int i = mVar.b;
                instance.update(bArr, i, mVar.c - i);
                m mVar2 = this.head;
                while (true) {
                    mVar2 = mVar2.f;
                    if (mVar2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = mVar2.a;
                    int i2 = mVar2.b;
                    instance.update(bArr2, i2, mVar2.c - i2);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            m mVar = this.head;
            if (mVar != null) {
                byte[] bArr = mVar.a;
                int i = mVar.b;
                instance.update(bArr, i, mVar.c - i);
                m mVar2 = this.head;
                while (true) {
                    mVar2 = mVar2.f;
                    if (mVar2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = mVar2.a;
                    int i2 = mVar2.b;
                    instance.update(bArr2, i2, mVar2.c - i2);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.Source, java.lang.AutoCloseable, okio.Sink, java.io.Closeable, java.nio.channels.Channel
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0;
        }
        m mVar = this.head.g;
        int i = mVar.c;
        return (i >= 8192 || !mVar.e) ? j : j - ((long) (i - mVar.b));
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0, this.size);
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.size;
        if (j != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        m mVar = this.head;
        m mVar2 = buffer.head;
        int i = mVar.b;
        int i2 = mVar2.b;
        while (j2 < this.size) {
            long min = (long) Math.min(mVar.c - i, mVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (mVar.a[i] != mVar2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == mVar.c) {
                mVar = mVar.f;
                i = mVar.b;
            }
            if (i2 == mVar2.c) {
                mVar2 = mVar2.f;
                i2 = mVar2.b;
            }
            j2 += min;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.Sink, okio.BufferedSink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        int i;
        p.b(this.size, j, 1);
        long j2 = this.size;
        if (j2 - j > j) {
            m mVar = this.head;
            while (true) {
                int i2 = mVar.c;
                int i3 = mVar.b;
                long j3 = (long) (i2 - i3);
                if (j < j3) {
                    return mVar.a[i3 + ((int) j)];
                }
                j -= j3;
                mVar = mVar.f;
            }
        } else {
            long j4 = j - j2;
            m mVar2 = this.head;
            do {
                mVar2 = mVar2.g;
                int i4 = mVar2.c;
                i = mVar2.b;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return mVar2.a[i + ((int) j4)];
        }
    }

    public int hashCode() {
        m mVar = this.head;
        if (mVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = mVar.c;
            for (int i3 = mVar.b; i3 < i2; i3++) {
                i = (i * 31) + mVar.a[i3];
            }
            mVar = mVar.f;
        } while (mVar != this.head);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0, AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new b();
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(MessageDigestAlgorithms.MD5);
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new a();
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return h.d(new j(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final c readAndWriteUnsafe() {
        return readAndWriteUnsafe(new c());
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.size;
        if (j != 0) {
            m mVar = this.head;
            int i = mVar.b;
            int i2 = mVar.c;
            int i3 = i + 1;
            byte b2 = mVar.a[i];
            this.size = j - 1;
            if (i3 == i2) {
                this.head = mVar.b();
                n.a(mVar);
            } else {
                mVar.b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
        if (r8 == false) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return -r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return r3;
     */
    @Override // okio.BufferedSource
    public long readDecimalLong() {
        byte b2;
        long j = 0;
        if (this.size != 0) {
            long j2 = -922337203685477580L;
            long j3 = -7;
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            loop0:
            while (true) {
                m mVar = this.head;
                byte[] bArr = mVar.a;
                int i2 = mVar.b;
                int i3 = mVar.c;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    b2 = bArr[i2];
                    if (b2 >= 48 && b2 <= 57) {
                        int i4 = 48 - b2;
                        int i5 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i5 < 0 || (i5 == 0 && ((long) i4) < j3)) {
                            Buffer writeByte = new Buffer().writeDecimalLong(j).writeByte((int) b2);
                        } else {
                            j = (j * 10) + ((long) i4);
                        }
                    } else if (b2 == 45 && i == 0) {
                        j3--;
                        z = true;
                    } else if (i != 0) {
                        z2 = true;
                    } else {
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b2));
                    }
                    i2++;
                    i++;
                    j2 = -922337203685477580L;
                }
                if (i2 == i3) {
                    this.head = mVar.b();
                    n.a(mVar);
                } else {
                    mVar.b = i2;
                }
                if (z2 || this.head == null) {
                    this.size -= (long) i;
                } else {
                    j2 = -922337203685477580L;
                }
            }
            Buffer writeByte2 = new Buffer().writeDecimalLong(j).writeByte((int) b2);
            if (!z) {
                writeByte2.readByte();
            }
            throw new NumberFormatException("Number too large: " + writeByte2.readUtf8());
        }
        throw new IllegalStateException("size == 0");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, AbsPerformance.LONG_NIL, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r15.head = r6.b();
        okio.n.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r1 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        int i;
        int i2;
        if (this.size != 0) {
            int i3 = 0;
            long j = 0;
            boolean z = false;
            do {
                m mVar = this.head;
                byte[] bArr = mVar.a;
                int i4 = mVar.b;
                int i5 = mVar.c;
                while (true) {
                    if (i4 >= i5) {
                        break;
                    }
                    byte b2 = bArr[i4];
                    if (b2 < 48 || b2 > 57) {
                        if (b2 >= 97 && b2 <= 102) {
                            i2 = b2 - 97;
                        } else if (b2 >= 65 && b2 <= 70) {
                            i2 = b2 - 65;
                        } else if (i3 == 0) {
                            z = true;
                        } else {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                        }
                        i = i2 + 10;
                    } else {
                        i = b2 - 48;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i4++;
                        i3++;
                    } else {
                        Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b2);
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                }
                if (i3 == 0) {
                }
            } while (this.head != null);
            this.size -= (long) i3;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.size;
        if (j >= 4) {
            m mVar = this.head;
            int i = mVar.b;
            int i2 = mVar.c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = mVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.size = j - 4;
            if (i8 == i2) {
                this.head = mVar.b();
                n.a(mVar);
            } else {
                mVar.b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return p.c(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        long j = this.size;
        if (j >= 8) {
            m mVar = this.head;
            int i = mVar.b;
            int i2 = mVar.c;
            if (i2 - i < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = mVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            long j2 = (((long) bArr[i3]) & 255) << 48;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j3 = j2 | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            this.size = j - 8;
            if (i10 == i2) {
                this.head = mVar.b();
                n.a(mVar);
            } else {
                mVar.b = i10;
            }
            return j3;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return p.d(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.size;
        if (j >= 2) {
            m mVar = this.head;
            int i = mVar.b;
            int i2 = mVar.c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = mVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.size = j - 2;
            if (i4 == i2) {
                this.head = mVar.b();
                n.a(mVar);
            } else {
                mVar.b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return p.e(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final c readUnsafe() {
        return readUnsafe(new c());
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, p.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.size != 0) {
            byte b2 = getByte(0);
            if ((b2 & as2.MAX_POWER_OF_TWO) == 0) {
                i3 = b2 & z7.DEL;
                i2 = 1;
                i = 0;
            } else if ((b2 & 224) == 192) {
                i3 = b2 & 31;
                i2 = 2;
                i = 128;
            } else if ((b2 & 240) == 224) {
                i3 = b2 & 15;
                i2 = 3;
                i = 2048;
            } else if ((b2 & 248) == 240) {
                i3 = b2 & 7;
                i2 = 4;
                i = 65536;
            } else {
                skip(1);
                return REPLACEMENT_CHARACTER;
            }
            long j = (long) i2;
            if (this.size >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = (long) i4;
                    byte b3 = getByte(j2);
                    if ((b3 & 192) == 128) {
                        i3 = (i3 << 6) | (b3 & 63);
                    } else {
                        skip(j2);
                        return REPLACEMENT_CHARACTER;
                    }
                }
                skip(j);
                if (i3 > 1114111) {
                    return REPLACEMENT_CHARACTER;
                }
                if ((i3 < 55296 || i3 > 57343) && i3 >= i) {
                    return i3;
                }
                return REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b2) + jl1.BRACKET_END_STR);
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j = this.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        m mVar = this.head;
        arrayList.add(Integer.valueOf(mVar.c - mVar.b));
        m mVar2 = this.head;
        while (true) {
            mVar2 = mVar2.f;
            if (mVar2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(mVar2.c - mVar2.b));
        }
    }

    @Override // okio.BufferedSource
    public int select(i iVar) {
        int selectPrefix = selectPrefix(iVar, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) iVar.a[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public int selectPrefix(i iVar, boolean z) {
        int i;
        int i2;
        int i3;
        m mVar;
        int i4;
        m mVar2 = this.head;
        int i5 = -2;
        if (mVar2 != null) {
            byte[] bArr = mVar2.a;
            int i6 = mVar2.b;
            int i7 = mVar2.c;
            int[] iArr = iVar.b;
            m mVar3 = mVar2;
            int i8 = 0;
            int i9 = -1;
            loop0:
            while (true) {
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (mVar3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = i12 + (i11 * -1);
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr[i6] & 255) != iArr[i12]) {
                            return i9;
                        }
                        boolean z2 = i16 == i14;
                        if (i15 == i7) {
                            m mVar4 = mVar3.f;
                            i4 = mVar4.b;
                            byte[] bArr2 = mVar4.a;
                            i3 = mVar4.c;
                            if (mVar4 != mVar2) {
                                mVar = mVar4;
                                bArr = bArr2;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                mVar = null;
                            }
                        } else {
                            i3 = i7;
                            i4 = i15;
                            mVar = mVar3;
                        }
                        if (z2) {
                            i = iArr[i16];
                            i2 = i4;
                            i7 = i3;
                            mVar3 = mVar;
                            break;
                        }
                        i6 = i4;
                        i7 = i3;
                        i12 = i16;
                        mVar3 = mVar;
                    }
                } else {
                    int i17 = i6 + 1;
                    int i18 = bArr[i6] & 255;
                    int i19 = i12 + i11;
                    while (i12 != i19) {
                        if (i18 == iArr[i12]) {
                            i = iArr[i12 + i11];
                            if (i17 == i7) {
                                mVar3 = mVar3.f;
                                i2 = mVar3.b;
                                bArr = mVar3.a;
                                i7 = mVar3.c;
                                if (mVar3 == mVar2) {
                                    mVar3 = null;
                                }
                            } else {
                                i2 = i17;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                if (i >= 0) {
                    return i;
                }
                i8 = -i;
                i6 = i2;
                i5 = -2;
            }
            return z ? i5 : i9;
        } else if (z) {
            return -2;
        } else {
            return iVar.indexOf(ByteString.EMPTY);
        }
    }

    public final ByteString sha1() {
        return digest(MessageDigestAlgorithms.SHA_1);
    }

    public final ByteString sha256() {
        return digest(MessageDigestAlgorithms.SHA_256);
    }

    public final ByteString sha512() {
        return digest(MessageDigestAlgorithms.SHA_512);
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            m mVar = this.head;
            if (mVar != null) {
                int min = (int) Math.min(j, (long) (mVar.c - mVar.b));
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                m mVar2 = this.head;
                int i = mVar2.b + min;
                mVar2.b = i;
                if (i == mVar2.c) {
                    this.head = mVar2.b();
                    n.a(mVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    @Override // okio.Source, okio.Sink
    public o timeout() {
        return o.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* access modifiers changed from: package-private */
    public m writableSegment(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        m mVar = this.head;
        if (mVar == null) {
            m b2 = n.b();
            this.head = b2;
            b2.g = b2;
            b2.f = b2;
            return b2;
        }
        m mVar2 = mVar.g;
        return (mVar2.c + i > 8192 || !mVar2.e) ? mVar2.c(n.b()) : mVar2;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    @Override // java.lang.Object
    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        m d = this.head.d();
        buffer.head = d;
        d.g = d;
        d.f = d;
        m mVar = this.head;
        while (true) {
            mVar = mVar.f;
            if (mVar != this.head) {
                buffer.head.g.c(mVar.d());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream != null) {
            p.b(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            m mVar = this.head;
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
                outputStream.write(mVar.a, i3, min);
                j2 -= (long) min;
                mVar = mVar.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j) {
        return indexOf(b2, j, AbsPerformance.LONG_NIL);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j >= 0) {
            m mVar = this.head;
            if (mVar == null) {
                return -1;
            }
            long j3 = this.size;
            if (j3 - j < j) {
                while (j3 > j) {
                    mVar = mVar.g;
                    j3 -= (long) (mVar.c - mVar.b);
                }
            } else {
                while (true) {
                    long j4 = ((long) (mVar.c - mVar.b)) + j2;
                    if (j4 >= j) {
                        break;
                    }
                    mVar = mVar.f;
                    j2 = j4;
                }
                j3 = j2;
            }
            if (byteString.size() == 2) {
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (j3 < this.size) {
                    byte[] bArr = mVar.a;
                    i = (int) ((((long) mVar.b) + j) - j3);
                    int i3 = mVar.c;
                    while (i < i3) {
                        byte b4 = bArr[i];
                        if (b4 == b2 || b4 == b3) {
                            i2 = mVar.b;
                        } else {
                            i++;
                        }
                    }
                    j3 += (long) (mVar.c - mVar.b);
                    mVar = mVar.f;
                    j = j3;
                }
                return -1;
            }
            byte[] internalArray = byteString.internalArray();
            while (j3 < this.size) {
                byte[] bArr2 = mVar.a;
                i = (int) ((((long) mVar.b) + j) - j3);
                int i4 = mVar.c;
                while (i < i4) {
                    byte b5 = bArr2[i];
                    for (byte b6 : internalArray) {
                        if (b5 == b6) {
                            i2 = mVar.b;
                        }
                    }
                    i++;
                }
                j3 += (long) (mVar.c - mVar.b);
                mVar = mVar.f;
                j = j3;
            }
            return -1;
            return ((long) (i - i2)) + j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        p.b((long) bArr.length, (long) i, (long) i2);
        m mVar = this.head;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(i2, mVar.c - mVar.b);
        System.arraycopy(mVar.a, mVar.b, bArr, i, min);
        int i3 = mVar.b + min;
        mVar.b = i3;
        this.size -= (long) min;
        if (i3 == mVar.c) {
            this.head = mVar.b();
            n.a(mVar);
        }
        return min;
    }

    public final c readAndWriteUnsafe(c cVar) {
        if (cVar.a == null) {
            cVar.a = this;
            cVar.b = true;
            return cVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public final c readUnsafe(c cVar) {
        if (cVar.a == null) {
            cVar.a = this;
            cVar.b = false;
            return cVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = AbsPerformance.LONG_NIL;
            if (j != AbsPerformance.LONG_NIL) {
                j2 = j + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32L, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        m writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.a;
        int i2 = writableSegment.c;
        writableSegment.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        m writableSegment = writableSegment(i2);
        byte[] bArr = writableSegment.a;
        int i3 = writableSegment.c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        writableSegment.c += i2;
        this.size += (long) i2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        m writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.a;
        int i = writableSegment.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.c += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        m writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.a;
        int i2 = writableSegment.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment.c = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(p.c(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        m writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.a;
        int i = writableSegment.c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment.c = i8 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(p.d(j));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        m writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.a;
        int i2 = writableSegment.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment.c = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) p.e((short) i));
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream != null) {
            p.b(this.size, 0, j);
            m mVar = this.head;
            while (j > 0) {
                int min = (int) Math.min(j, (long) (mVar.c - mVar.b));
                outputStream.write(mVar.a, mVar.b, min);
                int i = mVar.b + min;
                mVar.b = i;
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                if (i == mVar.c) {
                    m b2 = mVar.b();
                    this.head = b2;
                    n.a(mVar);
                    mVar = b2;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j, long j2) {
        m mVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.size;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (mVar = this.head) == null) {
            return -1;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                mVar = mVar.g;
                j4 -= (long) (mVar.c - mVar.b);
            }
        } else {
            while (true) {
                long j6 = ((long) (mVar.c - mVar.b)) + j3;
                if (j6 >= j) {
                    break;
                }
                mVar = mVar.f;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = mVar.a;
            int min = (int) Math.min((long) mVar.c, (((long) mVar.b) + j5) - j4);
            for (int i = (int) ((((long) mVar.b) + j7) - j4); i < min; i++) {
                if (bArr[i] == b2) {
                    return ((long) (i - mVar.b)) + j4;
                }
            }
            j4 += (long) (mVar.c - mVar.b);
            mVar = mVar.f;
            j7 = j4;
        }
        return -1;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        p.b(this.size, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        p.b(this.size, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            m mVar = this.head;
            int i = mVar.b;
            if (((long) i) + j > ((long) mVar.c)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(mVar.a, i, (int) j, charset);
            int i2 = (int) (((long) mVar.b) + j);
            mVar.b = i2;
            this.size -= j;
            if (i2 == mVar.c) {
                this.head = mVar.b();
                n.a(mVar);
            }
            return str;
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, p.UTF_8);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream != null) {
            while (true) {
                if (j > 0 || z) {
                    m writableSegment = writableSegment(1);
                    int read = inputStream.read(writableSegment.a, writableSegment.c, (int) Math.min(j, (long) (8192 - writableSegment.c)));
                    if (read != -1) {
                        writableSegment.c += read;
                        long j2 = (long) read;
                        this.size += j2;
                        j -= j2;
                    } else if (!z) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    /* access modifiers changed from: package-private */
    public String readUtf8Line(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1);
        return readUtf82;
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(p.UTF_8)) {
            return writeUtf8(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    m writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.a;
                    int i3 = writableSegment.c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = writableSegment.c;
                    int i6 = (i3 + i4) - i5;
                    writableSegment.c = i5 + i6;
                    this.size += (long) i6;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((charAt & jl1.CONDITION_IF) | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> '\f') | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((charAt & jl1.CONDITION_IF) | 128);
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                            writeByte((i8 >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                            writeByte(((i8 >> 12) & 63) | 128);
                            writeByte(((i8 >> 6) & 63) | 128);
                            writeByte((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    private boolean rangeEquals(m mVar, int i, ByteString byteString, int i2, int i3) {
        int i4 = mVar.c;
        byte[] bArr = mVar.a;
        while (i2 < i3) {
            if (i == i4) {
                mVar = mVar.f;
                byte[] bArr2 = mVar.a;
                bArr = bArr2;
                i = mVar.b;
                i4 = mVar.c;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            p.b((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                m writableSegment = writableSegment(1);
                int min = Math.min(i3 - i, 8192 - writableSegment.c);
                System.arraycopy(bArr, i, writableSegment.a, writableSegment.c, min);
                i += min;
                writableSegment.c += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            p.b(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
            m mVar = this.head;
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
                m d = mVar.d();
                int i3 = (int) (((long) d.b) + j);
                d.b = i3;
                d.c = Math.min(i3 + ((int) j2), d.c);
                m mVar2 = buffer.head;
                if (mVar2 == null) {
                    d.g = d;
                    d.f = d;
                    buffer.head = d;
                } else {
                    mVar2.g.c(d);
                }
                j2 -= (long) (d.c - d.b);
                mVar = mVar.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        m mVar = this.head;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), mVar.c - mVar.b);
        byteBuffer.put(mVar.a, mVar.b, min);
        int i = mVar.b + min;
        mVar.b = i;
        this.size -= (long) min;
        if (i == mVar.c) {
            this.head = mVar.b();
            n.a(mVar);
        }
        return min;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                m writableSegment = writableSegment(1);
                int min = Math.min(i, 8192 - writableSegment.c);
                byteBuffer.get(writableSegment.a, writableSegment.c, min);
                i -= min;
                writableSegment.c += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j >= 0) {
                m mVar = this.head;
                long j3 = -1;
                if (mVar == null) {
                    return -1;
                }
                long j4 = this.size;
                if (j4 - j < j) {
                    while (j4 > j) {
                        mVar = mVar.g;
                        j4 -= (long) (mVar.c - mVar.b);
                    }
                } else {
                    while (true) {
                        long j5 = ((long) (mVar.c - mVar.b)) + j2;
                        if (j5 >= j) {
                            break;
                        }
                        mVar = mVar.f;
                        j2 = j5;
                    }
                    j4 = j2;
                }
                byte b2 = byteString.getByte(0);
                int size2 = byteString.size();
                long j6 = 1 + (this.size - ((long) size2));
                long j7 = j;
                m mVar2 = mVar;
                long j8 = j4;
                while (j8 < j6) {
                    byte[] bArr2 = mVar2.a;
                    int min = (int) Math.min((long) mVar2.c, (((long) mVar2.b) + j6) - j8);
                    int i = (int) ((((long) mVar2.b) + j7) - j8);
                    while (i < min) {
                        if (bArr2[i] == b2) {
                            bArr = bArr2;
                            if (rangeEquals(mVar2, i + 1, byteString, 1, size2)) {
                                return ((long) (i - mVar2.b)) + j8;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i++;
                        bArr2 = bArr;
                    }
                    j8 += (long) (mVar2.c - mVar2.b);
                    mVar2 = mVar2.f;
                    j7 = j8;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        int i;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            p.b(buffer.size, 0, j);
            while (j > 0) {
                m mVar = buffer.head;
                if (j < ((long) (mVar.c - mVar.b))) {
                    m mVar2 = this.head;
                    m mVar3 = mVar2 != null ? mVar2.g : null;
                    if (mVar3 != null && mVar3.e) {
                        long j2 = ((long) mVar3.c) + j;
                        if (mVar3.d) {
                            i = 0;
                        } else {
                            i = mVar3.b;
                        }
                        if (j2 - ((long) i) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            mVar.g(mVar3, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    buffer.head = mVar.e((int) j);
                }
                m mVar4 = buffer.head;
                long j3 = (long) (mVar4.c - mVar4.b);
                buffer.head = mVar4.b();
                m mVar5 = this.head;
                if (mVar5 == null) {
                    this.head = mVar4;
                    mVar4.g = mVar4;
                    mVar4.f = mVar4;
                } else {
                    mVar5.g.c(mVar4).a();
                }
                buffer.size -= j3;
                this.size += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
