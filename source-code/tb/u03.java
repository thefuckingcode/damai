package tb;

import org.apache.commons.codec.binary.StringUtils;

/* compiled from: Taobao */
public class u03 extends m23 {
    static final byte[] p = {13, 10};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, ok1.OP_MAX_COUNT, 47};
    private static final byte[] r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] s = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] j;
    private final byte[] k;
    private final byte[] l;
    private final int m;
    private final int n;
    private int o;

    public u03() {
        this(0);
    }

    public u03(int i) {
        this(i, p);
    }

    public u03(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    public u03(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.k = s;
        if (bArr != null) {
            if (k(bArr)) {
                String newStringUtf8 = StringUtils.newStringUtf8(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + jl1.ARRAY_END_STR);
            } else if (i > 0) {
                this.n = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.l = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.m = this.n - 1;
                this.j = !z ? r : q;
            }
        }
        this.n = 4;
        this.l = null;
        this.m = this.n - 1;
        this.j = !z ? r : q;
    }

    public static byte[] l(String str) {
        return new u03().h(str);
    }

    /* access modifiers changed from: package-private */
    @Override // tb.m23
    public void c(byte[] bArr, int i, int i2) {
        if (!this.g) {
            if (i2 < 0) {
                this.g = true;
                if (this.i != 0 || this.a != 0) {
                    b(this.n);
                    int i3 = this.e;
                    int i4 = this.i;
                    if (i4 == 1) {
                        byte[] bArr2 = this.d;
                        int i5 = i3 + 1;
                        this.e = i5;
                        byte[] bArr3 = this.j;
                        int i6 = this.o;
                        bArr2[i3] = bArr3[(i6 >> 2) & 63];
                        int i7 = i5 + 1;
                        this.e = i7;
                        bArr2[i5] = bArr3[(i6 << 4) & 63];
                        if (bArr3 == q) {
                            int i8 = i7 + 1;
                            this.e = i8;
                            bArr2[i7] = 61;
                            this.e = i8 + 1;
                            bArr2[i8] = 61;
                        }
                    } else if (i4 == 2) {
                        byte[] bArr4 = this.d;
                        int i9 = i3 + 1;
                        this.e = i9;
                        byte[] bArr5 = this.j;
                        int i10 = this.o;
                        bArr4[i3] = bArr5[(i10 >> 10) & 63];
                        int i11 = i9 + 1;
                        this.e = i11;
                        bArr4[i9] = bArr5[(i10 >> 4) & 63];
                        int i12 = i11 + 1;
                        this.e = i12;
                        bArr4[i11] = bArr5[(i10 << 2) & 63];
                        if (bArr5 == q) {
                            this.e = i12 + 1;
                            bArr4[i12] = 61;
                        }
                    }
                    int i13 = this.h;
                    int i14 = this.e;
                    int i15 = i13 + (i14 - i3);
                    this.h = i15;
                    if (this.a > 0 && i15 > 0) {
                        byte[] bArr6 = this.l;
                        System.arraycopy(bArr6, 0, this.d, i14, bArr6.length);
                        this.e += this.l.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i16 = 0;
            while (i16 < i2) {
                b(this.n);
                int i17 = (this.i + 1) % 3;
                this.i = i17;
                int i18 = i + 1;
                byte b = bArr[i];
                int i19 = b;
                if (b < 0) {
                    i19 = b + 256;
                }
                int i20 = (this.o << 8) + (i19 == 1 ? 1 : 0);
                this.o = i20;
                if (i17 == 0) {
                    byte[] bArr7 = this.d;
                    int i21 = this.e;
                    int i22 = i21 + 1;
                    this.e = i22;
                    byte[] bArr8 = this.j;
                    bArr7[i21] = bArr8[(i20 >> 18) & 63];
                    int i23 = i22 + 1;
                    this.e = i23;
                    bArr7[i22] = bArr8[(i20 >> 12) & 63];
                    int i24 = i23 + 1;
                    this.e = i24;
                    bArr7[i23] = bArr8[(i20 >> 6) & 63];
                    int i25 = i24 + 1;
                    this.e = i25;
                    bArr7[i24] = bArr8[i20 & 63];
                    int i26 = this.h + 4;
                    this.h = i26;
                    int i27 = this.a;
                    if (i27 > 0 && i27 <= i26) {
                        byte[] bArr9 = this.l;
                        System.arraycopy(bArr9, 0, bArr7, i25, bArr9.length);
                        this.e += this.l.length;
                        this.h = 0;
                    }
                }
                i16++;
                i = i18;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // tb.m23
    public void d(byte[] bArr, int i, int i2) {
        byte b;
        if (!this.g) {
            if (i2 < 0) {
                this.g = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                b(this.m);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    this.g = true;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr2 = s;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        int i5 = (this.i + 1) % 4;
                        this.i = i5;
                        int i6 = (this.o << 6) + b;
                        this.o = i6;
                        if (i5 == 0) {
                            byte[] bArr3 = this.d;
                            int i7 = this.e;
                            int i8 = i7 + 1;
                            this.e = i8;
                            bArr3[i7] = (byte) ((i6 >> 16) & 255);
                            int i9 = i8 + 1;
                            this.e = i9;
                            bArr3[i8] = (byte) ((i6 >> 8) & 255);
                            this.e = i9 + 1;
                            bArr3[i9] = (byte) (i6 & 255);
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (this.g && this.i != 0) {
                b(this.m);
                int i10 = this.i;
                if (i10 == 2) {
                    int i11 = this.o >> 4;
                    this.o = i11;
                    byte[] bArr4 = this.d;
                    int i12 = this.e;
                    this.e = i12 + 1;
                    bArr4[i12] = (byte) (i11 & 255);
                } else if (i10 == 3) {
                    int i13 = this.o >> 2;
                    this.o = i13;
                    byte[] bArr5 = this.d;
                    int i14 = this.e;
                    int i15 = i14 + 1;
                    this.e = i15;
                    bArr5[i14] = (byte) ((i13 >> 8) & 255);
                    this.e = i15 + 1;
                    bArr5[i15] = (byte) (i13 & 255);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.m23
    public boolean e(byte b) {
        if (b >= 0) {
            byte[] bArr = this.k;
            return b < bArr.length && bArr[b] != -1;
        }
    }
}
