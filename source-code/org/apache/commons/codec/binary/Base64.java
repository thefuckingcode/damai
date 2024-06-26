package org.apache.commons.codec.binary;

import java.math.BigInteger;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec;
import tb.jl1;
import tb.ok1;

/* compiled from: Taobao */
public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, ok1.OP_MAX_COUNT, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "encodeInteger called with null parameter");
        return encodeBase64(toIntegerBytes(bigInteger), false);
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b >= bArr.length || bArr[b] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    static byte[] toIntegerBytes(BigInteger bigInteger) {
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

    /* access modifiers changed from: package-private */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        if (!context.eof) {
            if (i2 < 0) {
                context.eof = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == this.pad) {
                    context.eof = true;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr2 = DECODE_TABLE;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        int i5 = (context.modulus + 1) % 4;
                        context.modulus = i5;
                        int i6 = (context.ibitWorkArea << 6) + b;
                        context.ibitWorkArea = i6;
                        if (i5 == 0) {
                            int i7 = context.pos;
                            int i8 = i7 + 1;
                            context.pos = i8;
                            ensureBufferSize[i7] = (byte) ((i6 >> 16) & 255);
                            int i9 = i8 + 1;
                            context.pos = i9;
                            ensureBufferSize[i8] = (byte) ((i6 >> 8) & 255);
                            context.pos = i9 + 1;
                            ensureBufferSize[i9] = (byte) (i6 & 255);
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (context.eof && context.modulus != 0) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
                int i10 = context.modulus;
                if (i10 == 1) {
                    return;
                }
                if (i10 == 2) {
                    int i11 = context.ibitWorkArea >> 4;
                    context.ibitWorkArea = i11;
                    int i12 = context.pos;
                    context.pos = i12 + 1;
                    ensureBufferSize2[i12] = (byte) (i11 & 255);
                } else if (i10 == 3) {
                    int i13 = context.ibitWorkArea >> 2;
                    context.ibitWorkArea = i13;
                    int i14 = context.pos;
                    int i15 = i14 + 1;
                    context.pos = i15;
                    ensureBufferSize2[i14] = (byte) ((i13 >> 8) & 255);
                    context.pos = i15 + 1;
                    ensureBufferSize2[i15] = (byte) (i13 & 255);
                } else {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (!context.eof) {
            if (i2 < 0) {
                context.eof = true;
                if (context.modulus != 0 || this.lineLength != 0) {
                    byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                    int i3 = context.pos;
                    int i4 = context.modulus;
                    if (i4 != 0) {
                        if (i4 == 1) {
                            int i5 = i3 + 1;
                            context.pos = i5;
                            byte[] bArr2 = this.encodeTable;
                            int i6 = context.ibitWorkArea;
                            ensureBufferSize[i3] = bArr2[(i6 >> 2) & 63];
                            int i7 = i5 + 1;
                            context.pos = i7;
                            ensureBufferSize[i5] = bArr2[(i6 << 4) & 63];
                            if (bArr2 == STANDARD_ENCODE_TABLE) {
                                int i8 = i7 + 1;
                                context.pos = i8;
                                byte b = this.pad;
                                ensureBufferSize[i7] = b;
                                context.pos = i8 + 1;
                                ensureBufferSize[i8] = b;
                            }
                        } else if (i4 == 2) {
                            int i9 = i3 + 1;
                            context.pos = i9;
                            byte[] bArr3 = this.encodeTable;
                            int i10 = context.ibitWorkArea;
                            ensureBufferSize[i3] = bArr3[(i10 >> 10) & 63];
                            int i11 = i9 + 1;
                            context.pos = i11;
                            ensureBufferSize[i9] = bArr3[(i10 >> 4) & 63];
                            int i12 = i11 + 1;
                            context.pos = i12;
                            ensureBufferSize[i11] = bArr3[(i10 << 2) & 63];
                            if (bArr3 == STANDARD_ENCODE_TABLE) {
                                context.pos = i12 + 1;
                                ensureBufferSize[i12] = this.pad;
                            }
                        } else {
                            throw new IllegalStateException("Impossible modulus " + context.modulus);
                        }
                    }
                    int i13 = context.currentLinePos;
                    int i14 = context.pos;
                    int i15 = i13 + (i14 - i3);
                    context.currentLinePos = i15;
                    if (this.lineLength > 0 && i15 > 0) {
                        byte[] bArr4 = this.lineSeparator;
                        System.arraycopy(bArr4, 0, ensureBufferSize, i14, bArr4.length);
                        context.pos += this.lineSeparator.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i16 = 0;
            while (i16 < i2) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
                int i17 = (context.modulus + 1) % 3;
                context.modulus = i17;
                int i18 = i + 1;
                byte b2 = bArr[i];
                int i19 = b2;
                if (b2 < 0) {
                    i19 = b2 + 256;
                }
                int i20 = (context.ibitWorkArea << 8) + (i19 == 1 ? 1 : 0);
                context.ibitWorkArea = i20;
                if (i17 == 0) {
                    int i21 = context.pos;
                    int i22 = i21 + 1;
                    context.pos = i22;
                    byte[] bArr5 = this.encodeTable;
                    ensureBufferSize2[i21] = bArr5[(i20 >> 18) & 63];
                    int i23 = i22 + 1;
                    context.pos = i23;
                    ensureBufferSize2[i22] = bArr5[(i20 >> 12) & 63];
                    int i24 = i23 + 1;
                    context.pos = i24;
                    ensureBufferSize2[i23] = bArr5[(i20 >> 6) & 63];
                    int i25 = i24 + 1;
                    context.pos = i25;
                    ensureBufferSize2[i24] = bArr5[i20 & 63];
                    int i26 = context.currentLinePos + 4;
                    context.currentLinePos = i26;
                    int i27 = this.lineLength;
                    if (i27 > 0 && i27 <= i26) {
                        byte[] bArr6 = this.lineSeparator;
                        System.arraycopy(bArr6, 0, ensureBufferSize2, i25, bArr6.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i16++;
                i = i18;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            return b < bArr.length && bArr[b] != -1;
        }
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!(isBase64(bArr[i]) || BaseNCodec.isWhiteSpace(bArr[i]))) {
                return false;
            }
        }
        return true;
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= ((long) i)) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.decodeTable = DECODE_TABLE;
        if (bArr == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + jl1.ARRAY_END_STR);
        } else if (i > 0) {
            this.encodeSize = bArr.length + 4;
            byte[] bArr2 = new byte[bArr.length];
            this.lineSeparator = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
