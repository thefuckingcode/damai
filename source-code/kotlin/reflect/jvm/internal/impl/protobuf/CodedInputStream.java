package kotlin.reflect.jvm.internal.impl.protobuf;

import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
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
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private RefillCallback n;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(InputStream inputStream) {
        this.h = false;
        this.j = Integer.MAX_VALUE;
        this.l = 64;
        this.m = ConfigReporter.BIT_GETTER_IMP;
        this.n = null;
        this.a = new byte[4096];
        this.c = 0;
        this.e = 0;
        this.i = 0;
        this.f = inputStream;
        this.b = false;
    }

    public static int B(int i2, InputStream inputStream) throws IOException {
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

    private void N() {
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

    private void O(int i2) throws IOException {
        if (!T(i2)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void S(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.i;
            int i4 = this.e;
            int i5 = i3 + i4 + i2;
            int i6 = this.j;
            if (i5 <= i6) {
                int i7 = this.c;
                int i8 = i7 - i4;
                this.e = i7;
                O(1);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.c;
                    if (i9 > i10) {
                        i8 += i10;
                        this.e = i10;
                        O(1);
                    } else {
                        this.e = i9;
                        return;
                    }
                }
            } else {
                R((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private boolean T(int i2) throws IOException {
        int i3 = this.e;
        if (i3 + i2 <= this.c) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i2);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
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
                    StringBuilder sb2 = new StringBuilder(102);
                    sb2.append("InputStream#read(byte[]) returned invalid result: ");
                    sb2.append(read);
                    sb2.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb2.toString());
                } else if (read > 0) {
                    this.c += read;
                    if ((this.i + i2) - this.m <= 0) {
                        N();
                        if (this.c >= i2) {
                            return true;
                        }
                        return T(i2);
                    }
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
            }
            return false;
        }
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private void d(int i2) throws IOException {
        if (this.c - this.e < i2) {
            O(i2);
        }
    }

    public static CodedInputStream g(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    static CodedInputStream h(e eVar) {
        CodedInputStream codedInputStream = new CodedInputStream(eVar);
        try {
            codedInputStream.j(eVar.size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private byte[] x(int i2) throws IOException {
        if (i2 > 0) {
            int i3 = this.i;
            int i4 = this.e;
            int i5 = i3 + i4 + i2;
            int i6 = this.j;
            if (i5 > i6) {
                R((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i2 < 4096) {
                byte[] bArr = new byte[i2];
                int i7 = this.c - i4;
                System.arraycopy(this.a, i4, bArr, 0, i7);
                this.e = this.c;
                int i8 = i2 - i7;
                d(i8);
                System.arraycopy(this.a, 0, bArr, i7, i8);
                this.e = i8;
                return bArr;
            } else {
                int i9 = this.c;
                this.i = i3 + i9;
                this.e = 0;
                this.c = 0;
                int i10 = i9 - i4;
                int i11 = i2 - i10;
                ArrayList<byte[]> arrayList = new ArrayList();
                while (i11 > 0) {
                    int min = Math.min(i11, 4096);
                    byte[] bArr2 = new byte[min];
                    int i12 = 0;
                    while (i12 < min) {
                        InputStream inputStream = this.f;
                        int read = inputStream == null ? -1 : inputStream.read(bArr2, i12, min - i12);
                        if (read != -1) {
                            this.i += read;
                            i12 += read;
                        } else {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                    }
                    i11 -= min;
                    arrayList.add(bArr2);
                }
                byte[] bArr3 = new byte[i2];
                System.arraycopy(this.a, i4, bArr3, 0, i10);
                for (byte[] bArr4 : arrayList) {
                    System.arraycopy(bArr4, 0, bArr3, i10, bArr4.length);
                    i10 += bArr4.length;
                }
                return bArr3;
            }
        } else if (i2 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        if (r2[r3] < 0) goto L_0x007c;
     */
    public int A() throws IOException {
        int i2;
        long j2;
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
                long j3 = (long) i7;
                if (j3 < 0) {
                    j2 = -128;
                } else {
                    int i8 = i6 + 1;
                    int i9 = i7 ^ (bArr[i6] << 14);
                    long j4 = (long) i9;
                    if (j4 >= 0) {
                        i2 = (int) (16256 ^ j4);
                    } else {
                        i6 = i8 + 1;
                        int i10 = i9 ^ (bArr[i8] << 21);
                        j3 = (long) i10;
                        if (j3 < 0) {
                            j2 = -2080896;
                        } else {
                            i8 = i6 + 1;
                            byte b3 = bArr[i6];
                            i2 = (int) (((long) (i10 ^ (b3 << 28))) ^ 266354560);
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
                                this.e = i6;
                                return i2;
                            }
                        }
                    }
                    i6 = i8;
                    this.e = i6;
                    return i2;
                }
                i2 = (int) (j3 ^ j2);
                this.e = i6;
                return i2;
            }
        }
        return (int) D();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
        if (((long) r2[r0]) < 0) goto L_0x00b8;
     */
    public long C() throws IOException {
        long j2;
        long j3;
        long j4;
        int i2 = this.e;
        int i3 = this.c;
        if (i3 != i2) {
            byte[] bArr = this.a;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.e = i4;
                return (long) b2;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                long j5 = (long) (b2 ^ (bArr[i4] << 7));
                if (j5 < 0) {
                    j3 = -128;
                } else {
                    int i6 = i5 + 1;
                    long j6 = j5 ^ ((long) (bArr[i5] << 14));
                    if (j6 >= 0) {
                        j4 = 16256;
                    } else {
                        i5 = i6 + 1;
                        j5 = j6 ^ ((long) (bArr[i6] << 21));
                        if (j5 < 0) {
                            j3 = -2080896;
                        } else {
                            i6 = i5 + 1;
                            j6 = j5 ^ (((long) bArr[i5]) << 28);
                            if (j6 >= 0) {
                                j4 = 266354560;
                            } else {
                                i5 = i6 + 1;
                                j5 = j6 ^ (((long) bArr[i6]) << 35);
                                if (j5 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i6 = i5 + 1;
                                    j6 = j5 ^ (((long) bArr[i5]) << 42);
                                    if (j6 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i5 = i6 + 1;
                                        j5 = j6 ^ (((long) bArr[i6]) << 49);
                                        if (j5 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            int i7 = i5 + 1;
                                            long j7 = (j5 ^ (((long) bArr[i5]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i5 = i7 + 1;
                                            } else {
                                                i5 = i7;
                                            }
                                            j2 = j7;
                                            this.e = i5;
                                            return j2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    j2 = j6 ^ j4;
                    i5 = i6;
                    this.e = i5;
                    return j2;
                }
                j2 = j5 ^ j3;
                this.e = i5;
                return j2;
            }
        }
        return D();
    }

    /* access modifiers changed from: package-private */
    public long D() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte w = w();
            j2 |= ((long) (w & z7.DEL)) << i2;
            if ((w & as2.MAX_POWER_OF_TWO) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int A = A();
        int i2 = this.c;
        int i3 = this.e;
        if (A <= i2 - i3 && A > 0) {
            String str = new String(this.a, i3, A, "UTF-8");
            this.e += A;
            return str;
        } else if (A == 0) {
            return "";
        } else {
            return new String(x(A), "UTF-8");
        }
    }

    public String J() throws IOException {
        byte[] bArr;
        int A = A();
        int i2 = this.e;
        if (A <= this.c - i2 && A > 0) {
            bArr = this.a;
            this.e = i2 + A;
        } else if (A == 0) {
            return "";
        } else {
            bArr = x(A);
            i2 = 0;
        }
        if (h.f(bArr, i2, i2 + A)) {
            return new String(bArr, i2, A, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int K() throws IOException {
        if (f()) {
            this.g = 0;
            return 0;
        }
        int A = A();
        this.g = A;
        if (WireFormat.a(A) != 0) {
            return this.g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public boolean P(int i2, CodedOutputStream codedOutputStream) throws IOException {
        int b2 = WireFormat.b(i2);
        if (b2 == 0) {
            long t = t();
            codedOutputStream.o0(i2);
            codedOutputStream.z0(t);
            return true;
        } else if (b2 == 1) {
            long z = z();
            codedOutputStream.o0(i2);
            codedOutputStream.V(z);
            return true;
        } else if (b2 == 2) {
            ByteString l2 = l();
            codedOutputStream.o0(i2);
            codedOutputStream.P(l2);
            return true;
        } else if (b2 == 3) {
            codedOutputStream.o0(i2);
            Q(codedOutputStream);
            int c2 = WireFormat.c(WireFormat.a(i2), 4);
            a(c2);
            codedOutputStream.o0(c2);
            return true;
        } else if (b2 == 4) {
            return false;
        } else {
            if (b2 == 5) {
                int y = y();
                codedOutputStream.o0(i2);
                codedOutputStream.U(y);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public void Q(CodedOutputStream codedOutputStream) throws IOException {
        int K;
        do {
            K = K();
            if (K == 0) {
                return;
            }
        } while (P(K, codedOutputStream));
    }

    public void R(int i2) throws IOException {
        int i3 = this.c;
        int i4 = this.e;
        if (i2 > i3 - i4 || i2 < 0) {
            S(i2);
        } else {
            this.e = i4 + i2;
        }
    }

    public void a(int i2) throws InvalidProtocolBufferException {
        if (this.g != i2) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int e() {
        int i2 = this.j;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.i + this.e);
    }

    public boolean f() throws IOException {
        return this.e == this.c && !T(1);
    }

    public void i(int i2) {
        this.j = i2;
        N();
    }

    public int j(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = i2 + this.i + this.e;
            int i4 = this.j;
            if (i3 <= i4) {
                this.j = i3;
                N();
                return i4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean k() throws IOException {
        return C() != 0;
    }

    public ByteString l() throws IOException {
        int A = A();
        int i2 = this.c;
        int i3 = this.e;
        if (A <= i2 - i3 && A > 0) {
            ByteString e2 = (!this.b || !this.h) ? ByteString.e(this.a, i3, A) : new b(this.a, this.e, A);
            this.e += A;
            return e2;
        } else if (A == 0) {
            return ByteString.EMPTY;
        } else {
            return new e(x(A));
        }
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public void r(int i2, MessageLite.Builder builder, c cVar) throws IOException {
        int i3 = this.k;
        if (i3 < this.l) {
            this.k = i3 + 1;
            builder.mergeFrom(this, cVar);
            a(WireFormat.c(i2, 4));
            this.k--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends MessageLite> T u(Parser<T> parser, c cVar) throws IOException {
        int A = A();
        if (this.k < this.l) {
            int j2 = j(A);
            this.k++;
            T parsePartialFrom = parser.parsePartialFrom(this, cVar);
            a(0);
            this.k--;
            i(j2);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void v(MessageLite.Builder builder, c cVar) throws IOException {
        int A = A();
        if (this.k < this.l) {
            int j2 = j(A);
            this.k++;
            builder.mergeFrom(this, cVar);
            a(0);
            this.k--;
            i(j2);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte w() throws IOException {
        if (this.e == this.c) {
            O(1);
        }
        byte[] bArr = this.a;
        int i2 = this.e;
        this.e = i2 + 1;
        return bArr[i2];
    }

    public int y() throws IOException {
        int i2 = this.e;
        if (this.c - i2 < 4) {
            O(4);
            i2 = this.e;
        }
        byte[] bArr = this.a;
        this.e = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long z() throws IOException {
        int i2 = this.e;
        if (this.c - i2 < 8) {
            O(8);
            i2 = this.e;
        }
        byte[] bArr = this.a;
        this.e = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    private CodedInputStream(e eVar) {
        this.h = false;
        this.j = Integer.MAX_VALUE;
        this.l = 64;
        this.m = ConfigReporter.BIT_GETTER_IMP;
        this.n = null;
        this.a = eVar.a;
        int y = eVar.y();
        this.e = y;
        this.c = y + eVar.size();
        this.i = -this.e;
        this.f = null;
        this.b = true;
    }
}
