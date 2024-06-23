package com.amap.api.col.s;

import androidx.core.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import tb.ok1;

/* compiled from: Taobao */
public class bz {
    static final /* synthetic */ boolean a = true;
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, ok1.OP_MAX_COUNT, 47};
    private static final byte[] c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, -9, -9, -9, -9, ok1.OP_UNARY_MIN, -9, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private bz() {
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, bArr.length);
        } catch (IOException e2) {
            if (a) {
                str = null;
            } else {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    private static byte[] b(byte[] bArr, int i) throws IOException {
        int i2;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        int i3 = i + 0;
        int i4 = 1;
        if (i3 > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        } else if (i == 0) {
            return new byte[0];
        } else {
            if (i >= 4) {
                byte[] bArr2 = c;
                int i5 = (i * 3) / 4;
                byte[] bArr3 = new byte[i5];
                byte[] bArr4 = new byte[4];
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (i6 < i3) {
                    byte b2 = bArr2[bArr[i6] & 255];
                    if (b2 >= -5) {
                        if (b2 >= -1) {
                            int i9 = i7 + 1;
                            bArr4[i7] = bArr[i6];
                            if (i9 <= 3) {
                                i7 = i9;
                            } else if (i8 < 0 || (i2 = i8 + 2) >= i5) {
                                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(i5), Integer.valueOf(i8)));
                            } else {
                                byte[] bArr5 = c;
                                if (bArr4[2] == 61) {
                                    bArr3[i8] = (byte) ((((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i4]] & 255) << 12)) >>> 16);
                                } else if (bArr4[3] == 61) {
                                    int i10 = ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i4]] & 255) << 12) | ((bArr5[bArr4[2]] & 255) << 6);
                                    bArr3[i8] = (byte) (i10 >>> 16);
                                    bArr3[i8 + 1] = (byte) (i10 >>> 8);
                                    i4 = 2;
                                } else {
                                    int i11 = ((bArr5[bArr4[i4]] & 255) << 12) | ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[2]] & 255) << 6) | (bArr5[bArr4[3]] & 255);
                                    bArr3[i8] = (byte) (i11 >> 16);
                                    bArr3[i8 + 1] = (byte) (i11 >> 8);
                                    bArr3[i2] = (byte) i11;
                                    i4 = 3;
                                }
                                i8 += i4;
                                if (bArr[i6] == 61) {
                                    break;
                                }
                                i7 = 0;
                            }
                        }
                        i6++;
                        i4 = 1;
                    } else {
                        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(bArr[i6] & 255), Integer.valueOf(i6)));
                    }
                }
                byte[] bArr6 = new byte[i8];
                System.arraycopy(bArr3, 0, bArr6, 0, i8);
                return bArr6;
            }
            throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i)));
        }
    }

    public static byte[] a(String str) throws IOException {
        return b(str);
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = b;
        int i4 = 0;
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        int i6 = i5 | i4;
        if (i2 == 1) {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i6 & 63];
            return bArr2;
        }
    }

    private static String a(byte[] bArr, int i) throws IOException {
        Objects.requireNonNull(bArr, "Cannot serialize a null array.");
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i)));
        } else if (i + 0 <= bArr.length) {
            int i2 = 4;
            int i3 = (i / 3) * 4;
            if (i % 3 <= 0) {
                i2 = 0;
            }
            int i4 = i3 + i2;
            byte[] bArr2 = new byte[i4];
            int i5 = i - 2;
            int i6 = 0;
            int i7 = 0;
            while (i6 < i5) {
                a(bArr, i6 + 0, 3, bArr2, i7);
                i6 += 3;
                i7 += 4;
            }
            if (i6 < i) {
                a(bArr, i6 + 0, i - i6, bArr2, i7);
                i7 += 4;
            }
            if (i7 <= i4 - 1) {
                byte[] bArr3 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr3, 0, i7);
                bArr2 = bArr3;
            }
            try {
                return new String(bArr2, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr2);
            }
        } else {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i), Integer.valueOf(bArr.length)));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:9|10|11|12|13|14|15|(3:16|17|(1:19)(1:57))|20|21|22|23|24|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|(10:10|11|12|13|14|15|(3:16|17|(1:19)(1:57))|20|21|22)|23|24|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:46|47|48|49|50|(2:51|52)|53) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x007f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0082 */
    private static byte[] b(String str) throws IOException {
        byte[] bArr;
        Throwable th;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        IOException e2;
        Objects.requireNonNull(str, "Input string was null.");
        try {
            bArr = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        byte[] b2 = b(bArr, bArr.length);
        if (b2.length >= 4 && 35615 == ((b2[0] & 255) | ((b2[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) {
            byte[] bArr2 = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(b2);
                    try {
                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        while (true) {
                            try {
                                int read = gZIPInputStream.read(bArr2);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, read);
                            } catch (IOException e3) {
                                e2 = e3;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    e2.printStackTrace();
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    return b2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                byteArrayOutputStream.close();
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                throw th;
                            }
                        }
                        b2 = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e2 = e4;
                        gZIPInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        e2.printStackTrace();
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return b2;
                    } catch (Throwable th4) {
                        th = th4;
                        gZIPInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    e2.printStackTrace();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return b2;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                byteArrayInputStream = null;
                gZIPInputStream = null;
                e2.printStackTrace();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return b2;
            } catch (Throwable th6) {
                th = th6;
                byteArrayInputStream = null;
                gZIPInputStream = null;
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                throw th;
            }
            gZIPInputStream.close();
            byteArrayInputStream.close();
        }
        return b2;
    }
}
