package com.heytap.msp.push.encrypt;

import java.math.BigInteger;
import java.util.Objects;
import org.apache.commons.codec.binary.StringUtils;
import tb.jl1;
import tb.ok1;

/* compiled from: Taobao */
public class a extends b {
    static final byte[] a = {13, 10};
    private static final int m = 6;
    private static final int n = 3;
    private static final int o = 4;
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, ok1.OP_MAX_COUNT, 47};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final int s = 63;
    private final byte[] t;
    private final byte[] u;
    private final byte[] v;
    private final int w;
    private final int x;
    private int y;

    public a() {
        this(0);
    }

    public a(int i) {
        this(i, a);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.u = r;
        if (bArr != null) {
            if (l(bArr)) {
                String newStringUtf8 = StringUtils.newStringUtf8(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + jl1.ARRAY_END_STR);
            } else if (i > 0) {
                this.x = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.v = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.w = this.x - 1;
                this.t = !z ? q : p;
            }
        }
        this.x = 4;
        this.v = null;
        this.w = this.x - 1;
        this.t = !z ? q : p;
    }

    public a(boolean z) {
        this(76, a, z);
    }

    public static boolean a(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = r;
                if (b >= bArr.length || bArr[b] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(String str) {
        return b(StringUtils.getBytesUtf8(str));
    }

    public static boolean a(byte[] bArr) {
        return b(bArr);
    }

    public static byte[] a(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "encodeInteger called with null parameter");
        return a(b(bigInteger), false);
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, a, z2);
        long m2 = aVar.m(bArr);
        if (m2 <= ((long) i)) {
            return aVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m2 + ") than the specified maximum size of " + i);
    }

    public static boolean b(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!(a(bArr[i]) || b.c(bArr[i]))) {
                return false;
            }
        }
        return true;
    }

    public static byte[] b(String str) {
        return new a().c(str);
    }

    static byte[] b(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    public static byte[] c(byte[] bArr) {
        return a(bArr, false);
    }

    public static String d(byte[] bArr) {
        return StringUtils.newStringUtf8(a(bArr, false));
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String f(byte[] bArr) {
        return StringUtils.newStringUtf8(a(bArr, false, true));
    }

    public static byte[] g(byte[] bArr) {
        return a(bArr, true);
    }

    public static byte[] h(byte[] bArr) {
        return new a().decode(bArr);
    }

    public static BigInteger i(byte[] bArr) {
        return new BigInteger(1, h(bArr));
    }

    /* access modifiers changed from: package-private */
    @Override // com.heytap.msp.push.encrypt.b
    public void a(byte[] bArr, int i, int i2) {
        if (!this.j) {
            if (i2 < 0) {
                this.j = true;
                if (this.l != 0 || this.g != 0) {
                    a(this.x);
                    int i3 = this.i;
                    int i4 = this.l;
                    if (i4 == 1) {
                        byte[] bArr2 = this.h;
                        int i5 = i3 + 1;
                        this.i = i5;
                        byte[] bArr3 = this.t;
                        int i6 = this.y;
                        bArr2[i3] = bArr3[(i6 >> 2) & 63];
                        int i7 = i5 + 1;
                        this.i = i7;
                        bArr2[i5] = bArr3[(i6 << 4) & 63];
                        if (bArr3 == p) {
                            int i8 = i7 + 1;
                            this.i = i8;
                            bArr2[i7] = 61;
                            this.i = i8 + 1;
                            bArr2[i8] = 61;
                        }
                    } else if (i4 == 2) {
                        byte[] bArr4 = this.h;
                        int i9 = i3 + 1;
                        this.i = i9;
                        byte[] bArr5 = this.t;
                        int i10 = this.y;
                        bArr4[i3] = bArr5[(i10 >> 10) & 63];
                        int i11 = i9 + 1;
                        this.i = i11;
                        bArr4[i9] = bArr5[(i10 >> 4) & 63];
                        int i12 = i11 + 1;
                        this.i = i12;
                        bArr4[i11] = bArr5[(i10 << 2) & 63];
                        if (bArr5 == p) {
                            this.i = i12 + 1;
                            bArr4[i12] = 61;
                        }
                    }
                    int i13 = this.k;
                    int i14 = this.i;
                    int i15 = i13 + (i14 - i3);
                    this.k = i15;
                    if (this.g > 0 && i15 > 0) {
                        byte[] bArr6 = this.v;
                        System.arraycopy(bArr6, 0, this.h, i14, bArr6.length);
                        this.i += this.v.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i16 = 0;
            while (i16 < i2) {
                a(this.x);
                int i17 = (this.l + 1) % 3;
                this.l = i17;
                int i18 = i + 1;
                byte b = bArr[i];
                int i19 = b;
                if (b < 0) {
                    i19 = b + 256;
                }
                int i20 = (this.y << 8) + (i19 == 1 ? 1 : 0);
                this.y = i20;
                if (i17 == 0) {
                    byte[] bArr7 = this.h;
                    int i21 = this.i;
                    int i22 = i21 + 1;
                    this.i = i22;
                    byte[] bArr8 = this.t;
                    bArr7[i21] = bArr8[(i20 >> 18) & 63];
                    int i23 = i22 + 1;
                    this.i = i23;
                    bArr7[i22] = bArr8[(i20 >> 12) & 63];
                    int i24 = i23 + 1;
                    this.i = i24;
                    bArr7[i23] = bArr8[(i20 >> 6) & 63];
                    int i25 = i24 + 1;
                    this.i = i25;
                    bArr7[i24] = bArr8[i20 & 63];
                    int i26 = this.k + 4;
                    this.k = i26;
                    int i27 = this.g;
                    if (i27 > 0 && i27 <= i26) {
                        byte[] bArr9 = this.v;
                        System.arraycopy(bArr9, 0, bArr7, i25, bArr9.length);
                        this.i += this.v.length;
                        this.k = 0;
                    }
                }
                i16++;
                i = i18;
            }
        }
    }

    public boolean a() {
        return this.t == q;
    }

    /* access modifiers changed from: package-private */
    @Override // com.heytap.msp.push.encrypt.b
    public void b(byte[] bArr, int i, int i2) {
        byte b;
        if (!this.j) {
            if (i2 < 0) {
                this.j = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                a(this.w);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    this.j = true;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr2 = r;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        int i5 = (this.l + 1) % 4;
                        this.l = i5;
                        int i6 = (this.y << 6) + b;
                        this.y = i6;
                        if (i5 == 0) {
                            byte[] bArr3 = this.h;
                            int i7 = this.i;
                            int i8 = i7 + 1;
                            this.i = i8;
                            bArr3[i7] = (byte) ((i6 >> 16) & 255);
                            int i9 = i8 + 1;
                            this.i = i9;
                            bArr3[i8] = (byte) ((i6 >> 8) & 255);
                            this.i = i9 + 1;
                            bArr3[i9] = (byte) (i6 & 255);
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (this.j && this.l != 0) {
                a(this.w);
                int i10 = this.l;
                if (i10 == 2) {
                    int i11 = this.y >> 4;
                    this.y = i11;
                    byte[] bArr4 = this.h;
                    int i12 = this.i;
                    this.i = i12 + 1;
                    bArr4[i12] = (byte) (i11 & 255);
                } else if (i10 == 3) {
                    int i13 = this.y >> 2;
                    this.y = i13;
                    byte[] bArr5 = this.h;
                    int i14 = this.i;
                    int i15 = i14 + 1;
                    this.i = i15;
                    bArr5[i14] = (byte) ((i13 >> 8) & 255);
                    this.i = i15 + 1;
                    bArr5[i15] = (byte) (i13 & 255);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.heytap.msp.push.encrypt.b
    public boolean b(byte b) {
        if (b >= 0) {
            byte[] bArr = this.u;
            return b < bArr.length && bArr[b] != -1;
        }
    }
}
