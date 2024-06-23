package com.google.protobuf;

import com.alipay.sdk.m.n.a;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import tb.as2;
import tb.z7;

/* compiled from: Taobao */
public final class CodedInputStream {
    private final byte[] a;
    private final boolean b;
    private int c;
    private int d;
    private int e;
    private final InputStream f;
    private int g;
    private boolean h = false;
    private int i;
    private int j = Integer.MAX_VALUE;
    private int k;
    private int l = 100;
    private int m = ConfigReporter.BIT_GETTER_IMP;
    private RefillCallback n = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(byte[] bArr, int i2, int i3, boolean z) {
        this.a = bArr;
        this.c = i3 + i2;
        this.e = i2;
        this.i = -i2;
        this.f = null;
        this.b = z;
    }

    private void D(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.i;
            int i4 = this.e;
            int i5 = i3 + i4 + i2;
            int i6 = this.j;
            if (i5 <= i6) {
                int i7 = this.c;
                int i8 = i7 - i4;
                this.e = i7;
                z(1);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.c;
                    if (i9 > i10) {
                        i8 += i10;
                        this.e = i10;
                        z(1);
                    } else {
                        this.e = i9;
                        return;
                    }
                }
            } else {
                C((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private void E() throws IOException {
        int i2 = this.c;
        int i3 = this.e;
        if (i2 - i3 >= 10) {
            byte[] bArr = this.a;
            int i4 = 0;
            while (i4 < 10) {
                int i5 = i3 + 1;
                if (bArr[i3] >= 0) {
                    this.e = i5;
                    return;
                } else {
                    i4++;
                    i3 = i5;
                }
            }
        }
        F();
    }

    private void F() throws IOException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (m() >= 0) {
                return;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private boolean G(int i2) throws IOException {
        int i3 = this.e;
        if (i3 + i2 <= this.c) {
            throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
        } else if (this.i + i3 + i2 > this.j) {
            return false;
        } else {
            RefillCallback refillCallback = this.n;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            if (this.f != null) {
                int i4 = this.e;
                if (i4 > 0) {
                    int i5 = this.c;
                    if (i5 > i4) {
                        byte[] bArr = this.a;
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.i += i4;
                    this.c -= i4;
                    this.e = 0;
                }
                InputStream inputStream = this.f;
                byte[] bArr2 = this.a;
                int i6 = this.c;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.a.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read > 0) {
                    this.c += read;
                    if ((this.i + i2) - this.m <= 0) {
                        y();
                        if (this.c >= i2) {
                            return true;
                        }
                        return G(i2);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
    }

    public static CodedInputStream c(InputStream inputStream) {
        return new CodedInputStream(inputStream, 4096);
    }

    public static CodedInputStream d(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return f(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        byte[] bArr = new byte[duplicate.remaining()];
        duplicate.get(bArr);
        return e(bArr);
    }

    public static CodedInputStream e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static CodedInputStream f(byte[] bArr, int i2, int i3) {
        return g(bArr, i2, i3, false);
    }

    static CodedInputStream g(byte[] bArr, int i2, int i3, boolean z) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i2, i3, z);
        try {
            codedInputStream.i(i3);
            return codedInputStream;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private byte[] n(int i2) throws IOException {
        if (i2 > 0) {
            int i3 = this.i;
            int i4 = this.e;
            int i5 = i3 + i4 + i2;
            if (i5 <= this.m) {
                int i6 = this.j;
                if (i5 <= i6) {
                    InputStream inputStream = this.f;
                    if (inputStream != null) {
                        int i7 = this.c;
                        int i8 = i7 - i4;
                        this.i = i3 + i7;
                        this.e = 0;
                        this.c = 0;
                        int i9 = i2 - i8;
                        if (i9 < 4096 || i9 <= inputStream.available()) {
                            byte[] bArr = new byte[i2];
                            System.arraycopy(this.a, i4, bArr, 0, i8);
                            while (i8 < i2) {
                                int read = this.f.read(bArr, i8, i2 - i8);
                                if (read != -1) {
                                    this.i += read;
                                    i8 += read;
                                } else {
                                    throw InvalidProtocolBufferException.truncatedMessage();
                                }
                            }
                            return bArr;
                        }
                        ArrayList<byte[]> arrayList = new ArrayList();
                        while (i9 > 0) {
                            int min = Math.min(i9, 4096);
                            byte[] bArr2 = new byte[min];
                            int i10 = 0;
                            while (i10 < min) {
                                int read2 = this.f.read(bArr2, i10, min - i10);
                                if (read2 != -1) {
                                    this.i += read2;
                                    i10 += read2;
                                } else {
                                    throw InvalidProtocolBufferException.truncatedMessage();
                                }
                            }
                            i9 -= min;
                            arrayList.add(bArr2);
                        }
                        byte[] bArr3 = new byte[i2];
                        System.arraycopy(this.a, i4, bArr3, 0, i8);
                        for (byte[] bArr4 : arrayList) {
                            System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                            i8 += bArr4.length;
                        }
                        return bArr3;
                    }
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                C((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        } else if (i2 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    public static int q(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & 127;
        int i4 = 7;
        while (i4 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i3 |= (read & 127) << i4;
                if ((read & 128) == 0) {
                    return i3;
                }
                i4 += 7;
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if ((read2 & 128) == 0) {
                return i3;
            } else {
                i4 += 7;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void y() {
        int i2 = this.c + this.d;
        this.c = i2;
        int i3 = this.i + i2;
        int i4 = this.j;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.d = i5;
            this.c = i2 - i5;
            return;
        }
        this.d = 0;
    }

    private void z(int i2) throws IOException {
        if (!G(i2)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public boolean A(int i2) throws IOException {
        int b2 = WireFormat.b(i2);
        if (b2 == 0) {
            E();
            return true;
        } else if (b2 == 1) {
            C(8);
            return true;
        } else if (b2 == 2) {
            C(p());
            return true;
        } else if (b2 == 3) {
            B();
            a(WireFormat.c(WireFormat.a(i2), 4));
            return true;
        } else if (b2 == 4) {
            return false;
        } else {
            if (b2 == 5) {
                C(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public void B() throws IOException {
        int v;
        do {
            v = v();
            if (v == 0) {
                return;
            }
        } while (A(v));
    }

    public void C(int i2) throws IOException {
        int i3 = this.c;
        int i4 = this.e;
        if (i2 > i3 - i4 || i2 < 0) {
            D(i2);
        } else {
            this.e = i4 + i2;
        }
    }

    public void a(int i2) throws InvalidProtocolBufferException {
        if (this.g != i2) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public boolean b() throws IOException {
        return this.e == this.c && !G(1);
    }

    public void h(int i2) {
        this.j = i2;
        y();
    }

    public int i(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = i2 + this.i + this.e;
            int i4 = this.j;
            if (i3 <= i4) {
                this.j = i3;
                y();
                return i4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public ByteString j() throws IOException {
        ByteString byteString;
        int p = p();
        int i2 = this.c;
        int i3 = this.e;
        if (p <= i2 - i3 && p > 0) {
            if (!this.b || !this.h) {
                byteString = ByteString.copyFrom(this.a, i3, p);
            } else {
                byteString = ByteString.wrap(this.a, i3, p);
            }
            this.e += p;
            return byteString;
        } else if (p == 0) {
            return ByteString.EMPTY;
        } else {
            return ByteString.wrap(n(p));
        }
    }

    public double k() throws IOException {
        return Double.longBitsToDouble(o());
    }

    public <T extends MessageLite> T l(Parser<T> parser, g gVar) throws IOException {
        int p = p();
        if (this.k < this.l) {
            int i2 = i(p);
            this.k++;
            T parsePartialFrom = parser.parsePartialFrom(this, gVar);
            a(0);
            this.k--;
            h(i2);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte m() throws IOException {
        if (this.e == this.c) {
            z(1);
        }
        byte[] bArr = this.a;
        int i2 = this.e;
        this.e = i2 + 1;
        return bArr[i2];
    }

    public long o() throws IOException {
        int i2 = this.e;
        if (this.c - i2 < 8) {
            z(8);
            i2 = this.e;
        }
        byte[] bArr = this.a;
        this.e = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r2[r3] < 0) goto L_0x006a;
     */
    public int p() throws IOException {
        int i2;
        int i3 = this.e;
        int i4 = this.c;
        if (i4 != i3) {
            byte[] bArr = this.a;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.e = i5;
                return b2;
            } else if (i4 - i5 >= 9) {
                int i6 = i5 + 1;
                int i7 = b2 ^ (bArr[i5] << 7);
                if (i7 < 0) {
                    i2 = i7 ^ a.g;
                } else {
                    int i8 = i6 + 1;
                    int i9 = i7 ^ (bArr[i6] << 14);
                    if (i9 >= 0) {
                        i2 = i9 ^ 16256;
                    } else {
                        i6 = i8 + 1;
                        int i10 = i9 ^ (bArr[i8] << 21);
                        if (i10 < 0) {
                            i2 = i10 ^ -2080896;
                        } else {
                            i8 = i6 + 1;
                            byte b3 = bArr[i6];
                            i2 = (i10 ^ (b3 << 28)) ^ 266354560;
                            if (b3 < 0) {
                                i6 = i8 + 1;
                                if (bArr[i8] < 0) {
                                    i8 = i6 + 1;
                                    if (bArr[i6] < 0) {
                                        i6 = i8 + 1;
                                        if (bArr[i8] < 0) {
                                            i8 = i6 + 1;
                                            if (bArr[i6] < 0) {
                                                i6 = i8 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i6 = i8;
                }
                this.e = i6;
                return i2;
            }
        }
        return (int) s();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
        if (((long) r2[r0]) < 0) goto L_0x00b6;
     */
    public long r() throws IOException {
        long j2;
        long j3;
        long j4;
        int i2;
        int i3 = this.e;
        int i4 = this.c;
        if (i4 != i3) {
            byte[] bArr = this.a;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.e = i5;
                return (long) b2;
            } else if (i4 - i5 >= 9) {
                int i6 = i5 + 1;
                int i7 = b2 ^ (bArr[i5] << 7);
                if (i7 < 0) {
                    i2 = i7 ^ a.g;
                } else {
                    int i8 = i6 + 1;
                    int i9 = i7 ^ (bArr[i6] << 14);
                    if (i9 >= 0) {
                        i6 = i8;
                        j2 = (long) (i9 ^ 16256);
                    } else {
                        i6 = i8 + 1;
                        int i10 = i9 ^ (bArr[i8] << 21);
                        if (i10 < 0) {
                            i2 = i10 ^ -2080896;
                        } else {
                            long j5 = (long) i10;
                            int i11 = i6 + 1;
                            long j6 = j5 ^ (((long) bArr[i6]) << 28);
                            if (j6 >= 0) {
                                j4 = 266354560;
                            } else {
                                i6 = i11 + 1;
                                long j7 = j6 ^ (((long) bArr[i11]) << 35);
                                if (j7 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i11 = i6 + 1;
                                    j6 = j7 ^ (((long) bArr[i6]) << 42);
                                    if (j6 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i6 = i11 + 1;
                                        j7 = j6 ^ (((long) bArr[i11]) << 49);
                                        if (j7 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            int i12 = i6 + 1;
                                            long j8 = (j7 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                i6 = i12 + 1;
                                            } else {
                                                i6 = i12;
                                            }
                                            j2 = j8;
                                        }
                                    }
                                }
                                j2 = j7 ^ j3;
                            }
                            j2 = j6 ^ j4;
                            i6 = i11;
                        }
                    }
                    this.e = i6;
                    return j2;
                }
                j2 = (long) i2;
                this.e = i6;
                return j2;
            }
        }
        return s();
    }

    /* access modifiers changed from: package-private */
    public long s() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte m2 = m();
            j2 |= ((long) (m2 & z7.DEL)) << i2;
            if ((m2 & as2.MAX_POWER_OF_TWO) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public String t() throws IOException {
        int p = p();
        int i2 = this.c;
        int i3 = this.e;
        if (p <= i2 - i3 && p > 0) {
            String str = new String(this.a, i3, p, Internal.a);
            this.e += p;
            return str;
        } else if (p == 0) {
            return "";
        } else {
            if (p > i2) {
                return new String(n(p), Internal.a);
            }
            z(p);
            String str2 = new String(this.a, this.e, p, Internal.a);
            this.e += p;
            return str2;
        }
    }

    public String u() throws IOException {
        byte[] bArr;
        int p = p();
        int i2 = this.e;
        int i3 = this.c;
        if (p <= i3 - i2 && p > 0) {
            bArr = this.a;
            this.e = i2 + p;
        } else if (p == 0) {
            return "";
        } else {
            if (p <= i3) {
                z(p);
                bArr = this.a;
                this.e = p + 0;
            } else {
                bArr = n(p);
            }
            i2 = 0;
        }
        if (Utf8.q(bArr, i2, i2 + p)) {
            return new String(bArr, i2, p, Internal.a);
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int v() throws IOException {
        if (b()) {
            this.g = 0;
            return 0;
        }
        int p = p();
        this.g = p;
        if (WireFormat.a(p) != 0) {
            return this.g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int w() throws IOException {
        return p();
    }

    public long x() throws IOException {
        return r();
    }

    private CodedInputStream(InputStream inputStream, int i2) {
        this.a = new byte[i2];
        this.e = 0;
        this.i = 0;
        this.f = inputStream;
        this.b = false;
    }
}
