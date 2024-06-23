package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BaseNCodec;
import tb.jl1;

/* compiled from: Taobao */
public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    /* access modifiers changed from: package-private */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        if (!context.eof) {
            boolean z = true;
            if (i2 < 0) {
                context.eof = true;
            }
            int i3 = i;
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    break;
                }
                int i5 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 == this.pad) {
                    context.eof = z;
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
                if (b2 >= 0) {
                    byte[] bArr2 = this.decodeTable;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        int i6 = context.modulus;
                        int i7 = z ? 1 : 0;
                        int i8 = z ? 1 : 0;
                        int i9 = z ? 1 : 0;
                        int i10 = (i6 + i7) % 8;
                        context.modulus = i10;
                        long j = (context.lbitWorkArea << 5) + ((long) b);
                        context.lbitWorkArea = j;
                        if (i10 == 0) {
                            int i11 = context.pos;
                            int i12 = i11 + 1;
                            context.pos = i12;
                            ensureBufferSize[i11] = (byte) ((int) ((j >> 32) & 255));
                            int i13 = i12 + 1;
                            context.pos = i13;
                            ensureBufferSize[i12] = (byte) ((int) ((j >> 24) & 255));
                            int i14 = i13 + 1;
                            context.pos = i14;
                            ensureBufferSize[i13] = (byte) ((int) ((j >> 16) & 255));
                            int i15 = i14 + 1;
                            context.pos = i15;
                            ensureBufferSize[i14] = (byte) ((int) ((j >> 8) & 255));
                            context.pos = i15 + 1;
                            ensureBufferSize[i15] = (byte) ((int) (j & 255));
                        }
                    }
                }
                i4++;
                i3 = i5;
                z = true;
            }
            if (context.eof && context.modulus >= 2) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
                switch (context.modulus) {
                    case 2:
                        int i16 = context.pos;
                        context.pos = i16 + 1;
                        ensureBufferSize2[i16] = (byte) ((int) ((context.lbitWorkArea >> 2) & 255));
                        return;
                    case 3:
                        int i17 = context.pos;
                        context.pos = i17 + 1;
                        ensureBufferSize2[i17] = (byte) ((int) ((context.lbitWorkArea >> 7) & 255));
                        return;
                    case 4:
                        long j2 = context.lbitWorkArea >> 4;
                        context.lbitWorkArea = j2;
                        int i18 = context.pos;
                        int i19 = i18 + 1;
                        context.pos = i19;
                        ensureBufferSize2[i18] = (byte) ((int) ((j2 >> 8) & 255));
                        context.pos = i19 + 1;
                        ensureBufferSize2[i19] = (byte) ((int) (j2 & 255));
                        return;
                    case 5:
                        long j3 = context.lbitWorkArea >> 1;
                        context.lbitWorkArea = j3;
                        int i20 = context.pos;
                        int i21 = i20 + 1;
                        context.pos = i21;
                        ensureBufferSize2[i20] = (byte) ((int) ((j3 >> 16) & 255));
                        int i22 = i21 + 1;
                        context.pos = i22;
                        ensureBufferSize2[i21] = (byte) ((int) ((j3 >> 8) & 255));
                        context.pos = i22 + 1;
                        ensureBufferSize2[i22] = (byte) ((int) (j3 & 255));
                        return;
                    case 6:
                        long j4 = context.lbitWorkArea >> 6;
                        context.lbitWorkArea = j4;
                        int i23 = context.pos;
                        int i24 = i23 + 1;
                        context.pos = i24;
                        ensureBufferSize2[i23] = (byte) ((int) ((j4 >> 16) & 255));
                        int i25 = i24 + 1;
                        context.pos = i25;
                        ensureBufferSize2[i24] = (byte) ((int) ((j4 >> 8) & 255));
                        context.pos = i25 + 1;
                        ensureBufferSize2[i25] = (byte) ((int) (j4 & 255));
                        return;
                    case 7:
                        long j5 = context.lbitWorkArea >> 3;
                        context.lbitWorkArea = j5;
                        int i26 = context.pos;
                        int i27 = i26 + 1;
                        context.pos = i27;
                        ensureBufferSize2[i26] = (byte) ((int) ((j5 >> 24) & 255));
                        int i28 = i27 + 1;
                        context.pos = i28;
                        ensureBufferSize2[i27] = (byte) ((int) ((j5 >> 16) & 255));
                        int i29 = i28 + 1;
                        context.pos = i29;
                        ensureBufferSize2[i28] = (byte) ((int) ((j5 >> 8) & 255));
                        context.pos = i29 + 1;
                        ensureBufferSize2[i29] = (byte) ((int) (j5 & 255));
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        int i3;
        if (!context.eof) {
            int i4 = 1;
            if (i2 < 0) {
                context.eof = true;
                if (context.modulus != 0 || this.lineLength != 0) {
                    byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                    int i5 = context.pos;
                    int i6 = context.modulus;
                    if (i6 != 0) {
                        if (i6 == 1) {
                            int i7 = i5 + 1;
                            context.pos = i7;
                            byte[] bArr2 = this.encodeTable;
                            long j = context.lbitWorkArea;
                            ensureBufferSize[i5] = bArr2[((int) (j >> 3)) & 31];
                            int i8 = i7 + 1;
                            context.pos = i8;
                            ensureBufferSize[i7] = bArr2[((int) (j << 2)) & 31];
                            int i9 = i8 + 1;
                            context.pos = i9;
                            byte b = this.pad;
                            ensureBufferSize[i8] = b;
                            int i10 = i9 + 1;
                            context.pos = i10;
                            ensureBufferSize[i9] = b;
                            int i11 = i10 + 1;
                            context.pos = i11;
                            ensureBufferSize[i10] = b;
                            int i12 = i11 + 1;
                            context.pos = i12;
                            ensureBufferSize[i11] = b;
                            int i13 = i12 + 1;
                            context.pos = i13;
                            ensureBufferSize[i12] = b;
                            context.pos = i13 + 1;
                            ensureBufferSize[i13] = b;
                        } else if (i6 == 2) {
                            int i14 = i5 + 1;
                            context.pos = i14;
                            byte[] bArr3 = this.encodeTable;
                            long j2 = context.lbitWorkArea;
                            ensureBufferSize[i5] = bArr3[((int) (j2 >> 11)) & 31];
                            int i15 = i14 + 1;
                            context.pos = i15;
                            ensureBufferSize[i14] = bArr3[((int) (j2 >> 6)) & 31];
                            int i16 = i15 + 1;
                            context.pos = i16;
                            ensureBufferSize[i15] = bArr3[((int) (j2 >> 1)) & 31];
                            int i17 = i16 + 1;
                            context.pos = i17;
                            ensureBufferSize[i16] = bArr3[((int) (j2 << 4)) & 31];
                            int i18 = i17 + 1;
                            context.pos = i18;
                            byte b2 = this.pad;
                            ensureBufferSize[i17] = b2;
                            int i19 = i18 + 1;
                            context.pos = i19;
                            ensureBufferSize[i18] = b2;
                            int i20 = i19 + 1;
                            context.pos = i20;
                            ensureBufferSize[i19] = b2;
                            context.pos = i20 + 1;
                            ensureBufferSize[i20] = b2;
                        } else if (i6 == 3) {
                            int i21 = i5 + 1;
                            context.pos = i21;
                            byte[] bArr4 = this.encodeTable;
                            long j3 = context.lbitWorkArea;
                            ensureBufferSize[i5] = bArr4[((int) (j3 >> 19)) & 31];
                            int i22 = i21 + 1;
                            context.pos = i22;
                            ensureBufferSize[i21] = bArr4[((int) (j3 >> 14)) & 31];
                            int i23 = i22 + 1;
                            context.pos = i23;
                            ensureBufferSize[i22] = bArr4[((int) (j3 >> 9)) & 31];
                            int i24 = i23 + 1;
                            context.pos = i24;
                            ensureBufferSize[i23] = bArr4[((int) (j3 >> 4)) & 31];
                            int i25 = i24 + 1;
                            context.pos = i25;
                            ensureBufferSize[i24] = bArr4[((int) (j3 << 1)) & 31];
                            int i26 = i25 + 1;
                            context.pos = i26;
                            byte b3 = this.pad;
                            ensureBufferSize[i25] = b3;
                            int i27 = i26 + 1;
                            context.pos = i27;
                            ensureBufferSize[i26] = b3;
                            context.pos = i27 + 1;
                            ensureBufferSize[i27] = b3;
                        } else if (i6 == 4) {
                            int i28 = i5 + 1;
                            context.pos = i28;
                            byte[] bArr5 = this.encodeTable;
                            long j4 = context.lbitWorkArea;
                            ensureBufferSize[i5] = bArr5[((int) (j4 >> 27)) & 31];
                            int i29 = i28 + 1;
                            context.pos = i29;
                            ensureBufferSize[i28] = bArr5[((int) (j4 >> 22)) & 31];
                            int i30 = i29 + 1;
                            context.pos = i30;
                            ensureBufferSize[i29] = bArr5[((int) (j4 >> 17)) & 31];
                            int i31 = i30 + 1;
                            context.pos = i31;
                            ensureBufferSize[i30] = bArr5[((int) (j4 >> 12)) & 31];
                            int i32 = i31 + 1;
                            context.pos = i32;
                            ensureBufferSize[i31] = bArr5[((int) (j4 >> 7)) & 31];
                            int i33 = i32 + 1;
                            context.pos = i33;
                            ensureBufferSize[i32] = bArr5[((int) (j4 >> 2)) & 31];
                            int i34 = i33 + 1;
                            context.pos = i34;
                            ensureBufferSize[i33] = bArr5[((int) (j4 << 3)) & 31];
                            context.pos = i34 + 1;
                            ensureBufferSize[i34] = this.pad;
                        } else {
                            throw new IllegalStateException("Impossible modulus " + context.modulus);
                        }
                    }
                    int i35 = context.currentLinePos;
                    int i36 = context.pos;
                    int i37 = i35 + (i36 - i5);
                    context.currentLinePos = i37;
                    if (this.lineLength > 0 && i37 > 0) {
                        byte[] bArr6 = this.lineSeparator;
                        System.arraycopy(bArr6, 0, ensureBufferSize, i36, bArr6.length);
                        context.pos += this.lineSeparator.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i38 = i;
            int i39 = 0;
            while (i39 < i2) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
                int i40 = (context.modulus + i4) % 5;
                context.modulus = i40;
                int i41 = i38 + 1;
                byte b4 = bArr[i38];
                int i42 = b4;
                if (b4 < 0) {
                    i42 = b4 + 256;
                }
                long j5 = (context.lbitWorkArea << 8) + (i42 == 1 ? 1 : 0);
                context.lbitWorkArea = j5;
                if (i40 == 0) {
                    int i43 = context.pos;
                    int i44 = i43 + 1;
                    context.pos = i44;
                    byte[] bArr7 = this.encodeTable;
                    ensureBufferSize2[i43] = bArr7[((int) (j5 >> 35)) & 31];
                    int i45 = i44 + 1;
                    context.pos = i45;
                    ensureBufferSize2[i44] = bArr7[((int) (j5 >> 30)) & 31];
                    int i46 = i45 + 1;
                    context.pos = i46;
                    i3 = i41;
                    ensureBufferSize2[i45] = bArr7[((int) (j5 >> 25)) & 31];
                    int i47 = i46 + 1;
                    context.pos = i47;
                    ensureBufferSize2[i46] = bArr7[((int) (j5 >> 20)) & 31];
                    int i48 = i47 + 1;
                    context.pos = i48;
                    ensureBufferSize2[i47] = bArr7[((int) (j5 >> 15)) & 31];
                    int i49 = i48 + 1;
                    context.pos = i49;
                    ensureBufferSize2[i48] = bArr7[((int) (j5 >> 10)) & 31];
                    int i50 = i49 + 1;
                    context.pos = i50;
                    ensureBufferSize2[i49] = bArr7[((int) (j5 >> 5)) & 31];
                    int i51 = i50 + 1;
                    context.pos = i51;
                    ensureBufferSize2[i50] = bArr7[((int) j5) & 31];
                    int i52 = context.currentLinePos + 8;
                    context.currentLinePos = i52;
                    int i53 = this.lineLength;
                    if (i53 > 0 && i53 <= i52) {
                        byte[] bArr8 = this.lineSeparator;
                        System.arraycopy(bArr8, 0, ensureBufferSize2, i51, bArr8.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                        i39++;
                        i38 = i3;
                        i4 = 1;
                    }
                } else {
                    i3 = i41;
                }
                i39++;
                i38 = i3;
                i4 = 1;
            }
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            return b < bArr.length && bArr[b] != -1;
        }
    }

    public Base32(byte b) {
        this(false, b);
    }

    public Base32(boolean z) {
        this(0, null, z, (byte) 61);
    }

    public Base32(boolean z, byte b) {
        this(0, null, z, b);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false, (byte) 61);
    }

    public Base32(int i, byte[] bArr, boolean z) {
        this(i, bArr, z, (byte) 61);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base32(int i, byte[] bArr, boolean z, byte b) {
        super(5, 8, i, bArr == null ? 0 : bArr.length, b);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr == null) {
            throw new IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
        } else if (!containsAlphabetOrPad(bArr)) {
            this.encodeSize = bArr.length + 8;
            byte[] bArr2 = new byte[bArr.length];
            this.lineSeparator = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + newStringUtf8 + jl1.ARRAY_END_STR);
        }
        this.decodeSize = this.encodeSize - 1;
        if (isInAlphabet(b) || BaseNCodec.isWhiteSpace(b)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
    }
}
