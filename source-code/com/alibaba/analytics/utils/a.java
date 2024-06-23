package com.alibaba.analytics.utils;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import tb.ok1;

/* compiled from: Taobao */
public class a {
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, ok1.OP_MAX_COUNT, 47};
    private static final byte[] b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, -9, -9, -9, -9, ok1.OP_UNARY_MIN, -9, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static byte[] d(byte[] bArr) throws IOException {
        return e(bArr, 0, bArr.length, 0);
    }

    public static byte[] e(byte[] bArr, int i, int i2, int i3) throws IOException {
        int i4;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        if (i < 0 || (i4 = i + i2) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        } else if (i2 == 0) {
            return new byte[0];
        } else {
            if (i2 >= 4) {
                byte[] n = n(i3);
                byte[] bArr2 = new byte[((i2 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i5 = 0;
                int i6 = 0;
                while (i < i4) {
                    byte b2 = n[bArr[i] & 255];
                    if (b2 >= -5) {
                        if (b2 >= -1) {
                            int i7 = i5 + 1;
                            bArr3[i5] = bArr[i];
                            if (i7 > 3) {
                                i6 += f(bArr3, 0, bArr2, i6, i3);
                                if (bArr[i] == 61) {
                                    break;
                                }
                                i5 = 0;
                            } else {
                                i5 = i7;
                            }
                        }
                        i++;
                    } else {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)));
                    }
                }
                byte[] bArr4 = new byte[i6];
                System.arraycopy(bArr2, 0, bArr4, 0, i6);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i2);
        }
    }

    /* access modifiers changed from: private */
    public static int f(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        Objects.requireNonNull(bArr, "Source array was null.");
        Objects.requireNonNull(bArr2, "Destination array was null.");
        if (i < 0 || (i4 = i + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        } else if (i2 < 0 || (i5 = i2 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        } else {
            byte[] n = n(i3);
            int i6 = i + 2;
            if (bArr[i6] == 61) {
                bArr2[i2] = (byte) ((((n[bArr[i + 1]] & 255) << 12) | ((n[bArr[i]] & 255) << 18)) >>> 16);
                return 1;
            } else if (bArr[i4] == 61) {
                int i7 = ((n[bArr[i6]] & 255) << 6) | ((n[bArr[i + 1]] & 255) << 12) | ((n[bArr[i]] & 255) << 18);
                bArr2[i2] = (byte) (i7 >>> 16);
                bArr2[i2 + 1] = (byte) (i7 >>> 8);
                return 2;
            } else {
                int i8 = (n[bArr[i4]] & 255) | ((n[bArr[i + 1]] & 255) << 12) | ((n[bArr[i]] & 255) << 18) | ((n[bArr[i6]] & 255) << 6);
                bArr2[i2] = (byte) (i8 >> 16);
                bArr2[i2 + 1] = (byte) (i8 >> 8);
                bArr2[i5] = (byte) i8;
                return 3;
            }
        }
    }

    private static byte[] g(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] m = m(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = m[i7 >>> 18];
            bArr2[i3 + 1] = m[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = m[i7 >>> 18];
            bArr2[i3 + 1] = m[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = m[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = m[i7 >>> 18];
            bArr2[i3 + 1] = m[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = m[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = m[i7 & 63];
            return bArr2;
        }
    }

    /* access modifiers changed from: private */
    public static byte[] h(byte[] bArr, byte[] bArr2, int i, int i2) {
        g(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    public static String i(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : j(bArr);
    }

    public static String j(byte[] bArr) {
        try {
            return k(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String k(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] l = l(bArr, i, i2, i3);
        try {
            return new String(l, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(l);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:12|13|14|15|16|17|18|19|20|21|22|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:30|31|44|45|46|47|(2:48|49)|50) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0037 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0061 */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static byte[] l(byte[] bArr, int i, int i2, int i3) throws IOException {
        C0075a aVar;
        ?? r2;
        Throwable th;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        IOException e2;
        Objects.requireNonNull(bArr, "Cannot serialize a null array.");
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        } else if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
        } else if ((i3 & 2) != 0) {
            GZIPOutputStream gZIPOutputStream3 = null;
            try {
                ?? byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    aVar = new C0075a(byteArrayOutputStream, i3 | 1);
                } catch (IOException e3) {
                    e2 = e3;
                    aVar = null;
                    gZIPOutputStream = null;
                    gZIPOutputStream3 = byteArrayOutputStream;
                    try {
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPOutputStream2 = gZIPOutputStream3;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    aVar = null;
                    r2 = byteArrayOutputStream;
                    gZIPOutputStream3.close();
                    aVar.close();
                    try {
                        r2.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
                try {
                    gZIPOutputStream = new GZIPOutputStream(aVar);
                    try {
                        gZIPOutputStream.write(bArr, i, i2);
                        gZIPOutputStream.close();
                        gZIPOutputStream.close();
                        aVar.close();
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e4) {
                        e2 = e4;
                        gZIPOutputStream3 = byteArrayOutputStream;
                        throw e2;
                    } catch (Throwable th4) {
                        th = th4;
                        gZIPOutputStream2 = byteArrayOutputStream;
                        gZIPOutputStream3 = gZIPOutputStream;
                        r2 = gZIPOutputStream2;
                        gZIPOutputStream3.close();
                        aVar.close();
                        r2.close();
                        throw th;
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    gZIPOutputStream = null;
                    gZIPOutputStream3 = byteArrayOutputStream;
                    throw e2;
                } catch (Throwable th5) {
                    th = th5;
                    r2 = byteArrayOutputStream;
                    gZIPOutputStream3.close();
                    aVar.close();
                    r2.close();
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                aVar = null;
                gZIPOutputStream = null;
                throw e2;
            } catch (Throwable th6) {
                th = th6;
                r2 = 0;
                aVar = null;
                gZIPOutputStream3.close();
                aVar.close();
                r2.close();
                throw th;
            }
        } else {
            boolean z = (i3 & 8) != 0;
            int i4 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
            if (z) {
                i4 += i4 / 76;
            }
            byte[] bArr2 = new byte[i4];
            int i5 = i2 - 2;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i5) {
                g(bArr, i6 + i, 3, bArr2, i7, i3);
                int i9 = i8 + 4;
                if (!z || i9 < 76) {
                    i8 = i9;
                } else {
                    bArr2[i7 + 4] = 10;
                    i7++;
                    i8 = 0;
                }
                i6 += 3;
                i7 += 4;
            }
            if (i6 < i2) {
                g(bArr, i6 + i, i2 - i6, bArr2, i7, i3);
                i7 += 4;
            }
            if (i7 > i4 - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i7];
            System.arraycopy(bArr2, 0, bArr3, 0, i7);
            return bArr3;
        }
    }

    private static final byte[] m(int i) {
        if ((i & 16) == 16) {
            return c;
        }
        if ((i & 32) == 32) {
            return e;
        }
        return a;
    }

    /* access modifiers changed from: private */
    public static final byte[] n(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    /* renamed from: com.alibaba.analytics.utils.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0075a extends FilterOutputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public C0075a(OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.f = (i2 & 8) != 0;
            z = (i2 & 1) == 0 ? false : z;
            this.a = z;
            int i3 = z ? 3 : 4;
            this.d = i3;
            this.c = new byte[i3];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i2;
            this.j = a.n(i2);
        }

        public void a() throws IOException {
            int i2 = this.b;
            if (i2 <= 0) {
                return;
            }
            if (this.a) {
                ((FilterOutputStream) this).out.write(a.h(this.g, this.c, i2, this.i));
                this.b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(int i2) throws IOException {
            if (this.h) {
                ((FilterOutputStream) this).out.write(i2);
            } else if (this.a) {
                byte[] bArr = this.c;
                int i3 = this.b;
                int i4 = i3 + 1;
                this.b = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.d;
                if (i4 >= i5) {
                    ((FilterOutputStream) this).out.write(a.h(this.g, bArr, i5, this.i));
                    int i6 = this.e + 4;
                    this.e = i6;
                    if (this.f && i6 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                }
            } else {
                byte[] bArr2 = this.j;
                int i7 = i2 & 127;
                if (bArr2[i7] > -5) {
                    byte[] bArr3 = this.c;
                    int i8 = this.b;
                    int i9 = i8 + 1;
                    this.b = i9;
                    bArr3[i8] = (byte) i2;
                    if (i9 >= this.d) {
                        ((FilterOutputStream) this).out.write(this.g, 0, a.f(bArr3, 0, this.g, 0, this.i));
                        this.b = 0;
                    }
                } else if (bArr2[i7] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.h) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }
}
