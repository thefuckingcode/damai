package com.google.protobuf;

import com.google.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Taobao */
public abstract class CodedOutputStream extends d {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger a = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean b = n.k();
    private static final long c = n.e();

    /* compiled from: Taobao */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class b extends CodedOutputStream {
        final byte[] d;
        final int e;
        int f;
        int g;

        b(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.d = bArr;
                this.e = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        /* access modifiers changed from: package-private */
        public final void H(long j) {
            byte[] bArr = this.d;
            int i = this.f;
            int i2 = i + 1;
            this.f = i2;
            bArr[i] = (byte) ((int) (j & 255));
            int i3 = i2 + 1;
            this.f = i3;
            bArr[i2] = (byte) ((int) ((j >> 8) & 255));
            int i4 = i3 + 1;
            this.f = i4;
            bArr[i3] = (byte) ((int) ((j >> 16) & 255));
            int i5 = i4 + 1;
            this.f = i5;
            bArr[i4] = (byte) ((int) (255 & (j >> 24)));
            int i6 = i5 + 1;
            this.f = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            this.f = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            this.f = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.f = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            this.g += 8;
        }

        /* access modifiers changed from: package-private */
        public final void I(int i, int i2) {
            J(WireFormat.c(i, i2));
        }

        /* access modifiers changed from: package-private */
        public final void J(int i) {
            if (CodedOutputStream.b) {
                long j = CodedOutputStream.c + ((long) this.f);
                long j2 = j;
                while ((i & com.alipay.sdk.m.n.a.g) != 0) {
                    n.m(this.d, j2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                    j2 = 1 + j2;
                }
                n.m(this.d, j2, (byte) i);
                int i2 = (int) ((1 + j2) - j);
                this.f += i2;
                this.g += i2;
                return;
            }
            while ((i & com.alipay.sdk.m.n.a.g) != 0) {
                byte[] bArr = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr[i3] = (byte) ((i & 127) | 128);
                this.g++;
                i >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i4 = this.f;
            this.f = i4 + 1;
            bArr2[i4] = (byte) i;
            this.g++;
        }

        /* access modifiers changed from: package-private */
        public final void K(long j) {
            if (CodedOutputStream.b) {
                long j2 = CodedOutputStream.c + ((long) this.f);
                long j3 = j;
                long j4 = j2;
                while ((j3 & -128) != 0) {
                    n.m(this.d, j4, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                    j4 = 1 + j4;
                }
                n.m(this.d, j4, (byte) ((int) j3));
                int i = (int) ((1 + j4) - j2);
                this.f += i;
                this.g += i;
                return;
            }
            long j5 = j;
            while ((j5 & -128) != 0) {
                byte[] bArr = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                bArr[i2] = (byte) ((((int) j5) & 127) | 128);
                this.g++;
                j5 >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i3 = this.f;
            this.f = i3 + 1;
            bArr2[i3] = (byte) ((int) j5);
            this.g++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int y() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c extends CodedOutputStream {
        private final byte[] d;
        private final int e;
        private int f;

        c(byte[] bArr, int i, int i2) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) >= 0) {
                this.d = bArr;
                this.f = i;
                this.e = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void A(int i, long j) throws IOException {
            M(i, 1);
            J(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void B(int i, MessageLite messageLite) throws IOException {
            M(i, 2);
            K(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void D(int i, String str) throws IOException {
            M(i, 2);
            L(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void E(int i, int i2) throws IOException {
            M(i, 0);
            F(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void F(int i) throws IOException {
            if (!CodedOutputStream.b || y() < 10) {
                while ((i & com.alipay.sdk.m.n.a.g) != 0) {
                    byte[] bArr = this.d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.d;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
                }
            } else {
                long j = CodedOutputStream.c + ((long) this.f);
                while ((i & com.alipay.sdk.m.n.a.g) != 0) {
                    n.m(this.d, j, (byte) ((i & 127) | 128));
                    this.f++;
                    i >>>= 7;
                    j = 1 + j;
                }
                n.m(this.d, j, (byte) i);
                this.f++;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void G(int i, long j) throws IOException {
            M(i, 0);
            N(j);
        }

        public final void H(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.d, this.f, remaining);
                this.f += remaining;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(remaining)), e2);
            }
        }

        public final void I(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)), e2);
            }
        }

        public final void J(long j) throws IOException {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                bArr[i] = (byte) (((int) j) & 255);
                int i3 = i2 + 1;
                this.f = i3;
                bArr[i2] = (byte) (((int) (j >> 8)) & 255);
                int i4 = i3 + 1;
                this.f = i4;
                bArr[i3] = (byte) (((int) (j >> 16)) & 255);
                int i5 = i4 + 1;
                this.f = i5;
                bArr[i4] = (byte) (((int) (j >> 24)) & 255);
                int i6 = i5 + 1;
                this.f = i6;
                bArr[i5] = (byte) (((int) (j >> 32)) & 255);
                int i7 = i6 + 1;
                this.f = i7;
                bArr[i6] = (byte) (((int) (j >> 40)) & 255);
                int i8 = i7 + 1;
                this.f = i8;
                bArr[i7] = (byte) (((int) (j >> 48)) & 255);
                this.f = i8 + 1;
                bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
            }
        }

        public final void K(MessageLite messageLite) throws IOException {
            F(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        public final void L(String str) throws IOException {
            int i = this.f;
            try {
                int q = CodedOutputStream.q(str.length() * 3);
                int q2 = CodedOutputStream.q(str.length());
                if (q2 == q) {
                    int i2 = i + q2;
                    this.f = i2;
                    int g = Utf8.g(str, this.d, i2, y());
                    this.f = i;
                    F((g - i) - q2);
                    this.f = g;
                    return;
                }
                F(Utf8.h(str));
                this.f = Utf8.g(str, this.d, this.f, y());
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f = i;
                u(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        public final void M(int i, int i2) throws IOException {
            F(WireFormat.c(i, i2));
        }

        public final void N(long j) throws IOException {
            if (!CodedOutputStream.b || y() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.d;
                    int i = this.f;
                    this.f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.d;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e2);
                }
            } else {
                long j2 = CodedOutputStream.c + ((long) this.f);
                while ((j & -128) != 0) {
                    n.m(this.d, j2, (byte) ((((int) j) & 127) | 128));
                    this.f++;
                    j >>>= 7;
                    j2 = 1 + j2;
                }
                n.m(this.d, j2, (byte) ((int) j));
                this.f++;
            }
        }

        @Override // com.google.protobuf.d
        public final void a(ByteBuffer byteBuffer) throws IOException {
            H(byteBuffer);
        }

        @Override // com.google.protobuf.d
        public final void b(byte[] bArr, int i, int i2) throws IOException {
            I(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void t() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int y() {
            return this.e - this.f;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class d extends b {
        private final OutputStream h;

        d(OutputStream outputStream, int i) {
            super(i);
            Objects.requireNonNull(outputStream, "out");
            this.h = outputStream;
        }

        private void L() throws IOException {
            this.h.write(this.d, 0, this.f);
            this.f = 0;
        }

        private void M(int i) throws IOException {
            if (this.e - this.f < i) {
                L();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void A(int i, long j) throws IOException {
            M(18);
            I(i, 1);
            H(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void B(int i, MessageLite messageLite) throws IOException {
            R(i, 2);
            P(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void D(int i, String str) throws IOException {
            R(i, 2);
            Q(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void E(int i, int i2) throws IOException {
            M(20);
            I(i, 0);
            J(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void F(int i) throws IOException {
            M(10);
            J(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void G(int i, long j) throws IOException {
            M(20);
            I(i, 0);
            K(j);
        }

        public void N(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i = this.e;
            int i2 = this.f;
            if (i - i2 >= remaining) {
                byteBuffer.get(this.d, i2, remaining);
                this.f += remaining;
                this.g += remaining;
                return;
            }
            int i3 = i - i2;
            byteBuffer.get(this.d, i2, i3);
            int i4 = remaining - i3;
            this.f = this.e;
            this.g += i3;
            L();
            while (true) {
                int i5 = this.e;
                if (i4 > i5) {
                    byteBuffer.get(this.d, 0, i5);
                    this.h.write(this.d, 0, this.e);
                    int i6 = this.e;
                    i4 -= i6;
                    this.g += i6;
                } else {
                    byteBuffer.get(this.d, 0, i4);
                    this.f = i4;
                    this.g += i4;
                    return;
                }
            }
        }

        public void O(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.e;
            int i4 = this.f;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.d, i4, i2);
                this.f += i2;
                this.g += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.d, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.f = this.e;
            this.g += i5;
            L();
            if (i7 <= this.e) {
                System.arraycopy(bArr, i6, this.d, 0, i7);
                this.f = i7;
            } else {
                this.h.write(bArr, i6, i7);
            }
            this.g += i7;
        }

        public void P(MessageLite messageLite) throws IOException {
            F(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        public void Q(String str) throws IOException {
            int i;
            try {
                int length = str.length() * 3;
                int q = CodedOutputStream.q(length);
                int i2 = q + length;
                int i3 = this.e;
                if (i2 > i3) {
                    byte[] bArr = new byte[length];
                    int g = Utf8.g(str, bArr, 0, length);
                    F(g);
                    b(bArr, 0, g);
                    return;
                }
                if (i2 > i3 - this.f) {
                    L();
                }
                int q2 = CodedOutputStream.q(str.length());
                int i4 = this.f;
                if (q2 == q) {
                    int i5 = i4 + q2;
                    try {
                        this.f = i5;
                        int g2 = Utf8.g(str, this.d, i5, this.e - i5);
                        this.f = i4;
                        i = (g2 - i4) - q2;
                        J(i);
                        this.f = g2;
                    } catch (Utf8.UnpairedSurrogateException e) {
                        this.g -= this.f - i4;
                        this.f = i4;
                        throw e;
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        throw new OutOfSpaceException(e2);
                    }
                } else {
                    i = Utf8.h(str);
                    J(i);
                    this.f = Utf8.g(str, this.d, this.f, i);
                }
                this.g += i;
            } catch (Utf8.UnpairedSurrogateException e3) {
                u(str, e3);
            }
        }

        public void R(int i, int i2) throws IOException {
            F(WireFormat.c(i, i2));
        }

        @Override // com.google.protobuf.d
        public void a(ByteBuffer byteBuffer) throws IOException {
            N(byteBuffer);
        }

        @Override // com.google.protobuf.d
        public void b(byte[] bArr, int i, int i2) throws IOException {
            O(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void t() throws IOException {
            if (this.f > 0) {
                L();
            }
        }
    }

    public static int f(int i, double d2) {
        return o(i) + g(d2);
    }

    public static int g(double d2) {
        return 8;
    }

    static int h(int i) {
        return q(i) + i;
    }

    public static int i(int i, MessageLite messageLite) {
        return o(i) + j(messageLite);
    }

    public static int j(MessageLite messageLite) {
        return h(messageLite.getSerializedSize());
    }

    static int k(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    @Deprecated
    public static int l(int i) {
        return q(i);
    }

    public static int m(int i, String str) {
        return o(i) + n(str);
    }

    public static int n(String str) {
        int i;
        try {
            i = Utf8.h(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i = str.getBytes(Internal.a).length;
        }
        return h(i);
    }

    public static int o(int i) {
        return q(WireFormat.c(i, 0));
    }

    public static int p(int i, int i2) {
        return o(i) + q(i2);
    }

    public static int q(int i) {
        if ((i & com.alipay.sdk.m.n.a.g) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int r(int i, long j) {
        return o(i) + s(j);
    }

    public static int s(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static CodedOutputStream v(OutputStream outputStream, int i) {
        return new d(outputStream, i);
    }

    public static CodedOutputStream w(byte[] bArr) {
        return x(bArr, 0, bArr.length);
    }

    public static CodedOutputStream x(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public abstract void A(int i, long j) throws IOException;

    public abstract void B(int i, MessageLite messageLite) throws IOException;

    @Deprecated
    public final void C(int i) throws IOException {
        F(i);
    }

    public abstract void D(int i, String str) throws IOException;

    public abstract void E(int i, int i2) throws IOException;

    public abstract void F(int i) throws IOException;

    public abstract void G(int i, long j) throws IOException;

    public final void e() {
        if (y() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void t() throws IOException;

    /* access modifiers changed from: package-private */
    public final void u(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.a);
        try {
            F(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException(e);
        } catch (OutOfSpaceException e2) {
            throw e2;
        }
    }

    public abstract int y();

    public final void z(int i, double d2) throws IOException {
        A(i, Double.doubleToRawLongBits(d2));
    }

    private CodedOutputStream() {
    }
}
