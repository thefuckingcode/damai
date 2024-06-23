package com.alipay.android.phone.mobilesdk.socketcraft.util;

import androidx.core.view.MotionEventCompat;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import tb.ok1;

/* compiled from: Taobao */
public class Base64 {
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

    /* compiled from: Taobao */
    public static class InputStream extends FilterInputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private int h;
        private byte[] i;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read;
            if (this.b < 0) {
                if (this.a) {
                    byte[] bArr = new byte[3];
                    int i2 = 0;
                    for (int i3 = 0; i3 < 3; i3++) {
                        int read2 = ((FilterInputStream) this).in.read();
                        if (read2 < 0) {
                            break;
                        }
                        bArr[i3] = (byte) read2;
                        i2++;
                    }
                    if (i2 <= 0) {
                        return -1;
                    }
                    Base64.f(bArr, 0, i2, this.c, 0, this.h);
                    this.b = 0;
                    this.e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i4 = 0;
                    while (i4 < 4) {
                        do {
                            read = ((FilterInputStream) this).in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.i[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i4] = (byte) read;
                        i4++;
                    }
                    if (i4 == 4) {
                        this.e = Base64.e(bArr2, 0, this.c, 0, this.h);
                        this.b = 0;
                    } else if (i4 == 0) {
                        return -1;
                    } else {
                        throw new IOException("Improperly padded Base64 input.");
                    }
                }
            }
            int i5 = this.b;
            if (i5 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            } else if (i5 >= this.e) {
                return -1;
            } else {
                if (!this.a || !this.g || this.f < 76) {
                    this.f++;
                    byte[] bArr3 = this.c;
                    int i6 = i5 + 1;
                    this.b = i6;
                    byte b2 = bArr3[i5];
                    if (i6 >= this.d) {
                        this.b = -1;
                    }
                    return b2 & 255;
                }
                this.f = 0;
                return 10;
            }
        }

        public InputStream(java.io.InputStream inputStream, int i2) {
            super(inputStream);
            this.h = i2;
            boolean z = true;
            this.g = (i2 & 8) > 0;
            z = (i2 & 1) <= 0 ? false : z;
            this.a = z;
            int i3 = z ? 4 : 3;
            this.d = i3;
            this.c = new byte[i3];
            this.b = -1;
            this.f = 0;
            this.i = Base64.i(i2);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i2 + i4] = (byte) read;
                    i4++;
                } else if (i4 == 0) {
                    return -1;
                }
            }
            return i4;
        }
    }

    /* compiled from: Taobao */
    public static class OutputStream extends FilterOutputStream {
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

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public void close() {
            flushBase64();
            super.close();
            this.c = null;
            ((FilterOutputStream) this).out = null;
        }

        public void flushBase64() {
            int i2 = this.b;
            if (i2 <= 0) {
                return;
            }
            if (this.a) {
                ((FilterOutputStream) this).out.write(Base64.g(this.g, this.c, i2, this.i));
                this.b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void resumeEncoding() {
            this.h = false;
        }

        public void suspendEncoding() {
            flushBase64();
            this.h = true;
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(int i2) {
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
                    ((FilterOutputStream) this).out.write(Base64.g(this.g, bArr, i5, this.i));
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
                        ((FilterOutputStream) this).out.write(this.g, 0, Base64.e(bArr3, 0, this.g, 0, this.i));
                        this.b = 0;
                    }
                } else if (bArr2[i7] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public OutputStream(java.io.OutputStream outputStream, int i2) {
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
            this.j = Base64.i(i2);
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(byte[] bArr, int i2, int i3) {
            if (this.h) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }

    private Base64() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, 0, bArr.length, 0);
    }

    public static void decodeFileToFile(String str, String str2) {
        Throwable th;
        IOException e2;
        byte[] decodeFromFile = decodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(decodeFromFile);
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e3) {
                e2 = e3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e2 = e4;
            throw e2;
        }
    }

    public static byte[] decodeFromFile(String str) {
        Throwable th;
        IOException e2;
        InputStream inputStream = null;
        try {
            File file = new File(str);
            if (file.length() <= 2147483647L) {
                byte[] bArr = new byte[((int) file.length())];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                int i = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i, 4096);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (IOException e3) {
                        e2 = e3;
                        inputStream = inputStream2;
                        try {
                            throw e2;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            }
            throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
        } catch (IOException e4) {
            e2 = e4;
            throw e2;
        }
    }

    public static void decodeToFile(String str, String str2) {
        Throwable th;
        IOException e2;
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str2), 0);
            try {
                outputStream2.write(str.getBytes("US-ASCII"));
                try {
                    outputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e3) {
                e2 = e3;
                outputStream = outputStream2;
                try {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e2 = e4;
            throw e2;
        }
    }

    public static Object decodeToObject(String str) {
        return decodeToObject(str, 0, null);
    }

    /* access modifiers changed from: private */
    public static int e(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        Objects.requireNonNull(bArr, "Source array was null.");
        Objects.requireNonNull(bArr2, "Destination array was null.");
        if (i < 0 || (i4 = i + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        } else if (i2 < 0 || (i5 = i2 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        } else {
            byte[] i6 = i(i3);
            int i7 = i + 2;
            if (bArr[i7] == 61) {
                bArr2[i2] = (byte) ((((i6[bArr[i + 1]] & 255) << 12) | ((i6[bArr[i]] & 255) << 18)) >>> 16);
                return 1;
            } else if (bArr[i4] == 61) {
                int i8 = ((i6[bArr[i7]] & 255) << 6) | ((i6[bArr[i + 1]] & 255) << 12) | ((i6[bArr[i]] & 255) << 18);
                bArr2[i2] = (byte) (i8 >>> 16);
                bArr2[i2 + 1] = (byte) (i8 >>> 8);
                return 2;
            } else {
                int i9 = (i6[bArr[i4]] & 255) | ((i6[bArr[i + 1]] & 255) << 12) | ((i6[bArr[i]] & 255) << 18) | ((i6[bArr[i7]] & 255) << 6);
                bArr2[i2] = (byte) (i9 >> 16);
                bArr2[i2 + 1] = (byte) (i9 >> 8);
                bArr2[i5] = (byte) i9;
                return 3;
            }
        }
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            g(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static String encodeBytes(byte[] bArr) {
        try {
            return encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        try {
            return encodeBytesToBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static void encodeFileToFile(String str, String str2) {
        Throwable th;
        IOException e2;
        String encodeFromFile = encodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(encodeFromFile.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e3) {
                e2 = e3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e2 = e4;
            throw e2;
        }
    }

    public static String encodeFromFile(String str) {
        Throwable th;
        IOException e2;
        InputStream inputStream = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((((double) file.length()) * 1.4d) + 1.0d), 40)];
            InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
            int i = 0;
            while (true) {
                try {
                    int read = inputStream2.read(bArr, i, 4096);
                    if (read < 0) {
                        break;
                    }
                    i += read;
                } catch (IOException e3) {
                    e2 = e3;
                    inputStream = inputStream2;
                    try {
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i, "US-ASCII");
            try {
                inputStream2.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (IOException e4) {
            e2 = e4;
            throw e2;
        }
    }

    public static String encodeObject(Serializable serializable) {
        return encodeObject(serializable, 0);
    }

    public static void encodeToFile(byte[] bArr, String str) {
        Throwable th;
        IOException e2;
        Objects.requireNonNull(bArr, "Data to encode was null.");
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str), 1);
            try {
                outputStream2.write(bArr);
                try {
                    outputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e3) {
                e2 = e3;
                outputStream = outputStream2;
                try {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e2 = e4;
            throw e2;
        }
    }

    /* access modifiers changed from: private */
    public static byte[] f(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] h = h(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = h[i7 >>> 18];
            bArr2[i3 + 1] = h[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = h[i7 >>> 18];
            bArr2[i3 + 1] = h[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = h[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = h[i7 >>> 18];
            bArr2[i3 + 1] = h[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = h[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = h[i7 & 63];
            return bArr2;
        }
    }

    /* access modifiers changed from: private */
    public static byte[] g(byte[] bArr, byte[] bArr2, int i, int i2) {
        f(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    private static final byte[] h(int i) {
        if ((i & 16) == 16) {
            return c;
        }
        if ((i & 32) == 32) {
            return e;
        }
        return a;
    }

    /* access modifiers changed from: private */
    public static final byte[] i(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        int i4;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        if (i < 0 || (i4 = i + i2) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        } else if (i2 == 0) {
            return new byte[0];
        } else {
            if (i2 >= 4) {
                byte[] i5 = i(i3);
                byte[] bArr2 = new byte[((i2 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i6 = 0;
                int i7 = 0;
                while (i < i4) {
                    byte b2 = i5[bArr[i] & 255];
                    if (b2 >= -5) {
                        if (b2 >= -1) {
                            int i8 = i6 + 1;
                            bArr3[i6] = bArr[i];
                            if (i8 > 3) {
                                i7 += e(bArr3, 0, bArr2, i7, i3);
                                if (bArr[i] == 61) {
                                    break;
                                }
                                i6 = 0;
                            } else {
                                i6 = i8;
                            }
                        }
                        i++;
                    } else {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)));
                    }
                }
                byte[] bArr4 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr4, 0, i7);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i2);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:14|15|30|31|32|33|34) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|(2:4|5)(1:6)|7|8|9|10|11|12) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x003c */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static Object decodeToObject(String str, int i, final ClassLoader classLoader) {
        ?? r3;
        Throwable th;
        IOException e2;
        ClassNotFoundException e3;
        ObjectInputStream objectInputStream;
        byte[] decode = decode(str, i);
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(decode);
            if (classLoader == null) {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream2);
                } catch (IOException e4) {
                    e2 = e4;
                    throw e2;
                } catch (ClassNotFoundException e5) {
                    e3 = e5;
                    classLoader = null;
                    byteArrayInputStream = byteArrayInputStream2;
                    throw e3;
                } catch (Throwable th2) {
                    th = th2;
                    r3 = 0;
                    byteArrayInputStream = byteArrayInputStream2;
                    byteArrayInputStream.close();
                    r3.close();
                    throw th;
                }
            } else {
                objectInputStream = new ObjectInputStream(byteArrayInputStream2) {
                    /* class com.alipay.android.phone.mobilesdk.socketcraft.util.Base64.AnonymousClass1 */

                    @Override // java.io.ObjectInputStream
                    public final Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
                        Class<?> cls = Class.forName(objectStreamClass.getName(), false, classLoader);
                        return cls == null ? super.resolveClass(objectStreamClass) : cls;
                    }
                };
            }
            Object readObject = objectInputStream.readObject();
            byteArrayInputStream2.close();
            objectInputStream.close();
            return readObject;
        } catch (IOException e6) {
            e2 = e6;
            throw e2;
        } catch (ClassNotFoundException e7) {
            e3 = e7;
            classLoader = null;
            throw e3;
        } catch (Throwable th3) {
            th = th3;
            r3 = classLoader;
            byteArrayInputStream.close();
            r3.close();
            throw th;
        }
    }

    public static String encodeBytes(byte[] bArr, int i) {
        return encodeBytes(bArr, 0, bArr.length, i);
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
    public static byte[] encodeBytesToBytes(byte[] bArr, int i, int i2, int i3) {
        OutputStream outputStream;
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
                    outputStream = new OutputStream(byteArrayOutputStream, i3 | 1);
                } catch (IOException e3) {
                    e2 = e3;
                    outputStream = null;
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
                    outputStream = null;
                    r2 = byteArrayOutputStream;
                    gZIPOutputStream3.close();
                    outputStream.close();
                    try {
                        r2.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
                try {
                    gZIPOutputStream = new GZIPOutputStream(outputStream);
                    try {
                        gZIPOutputStream.write(bArr, i, i2);
                        gZIPOutputStream.close();
                        gZIPOutputStream.close();
                        outputStream.close();
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
                        outputStream.close();
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
                    outputStream.close();
                    r2.close();
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                outputStream = null;
                gZIPOutputStream = null;
                throw e2;
            } catch (Throwable th6) {
                th = th6;
                r2 = 0;
                outputStream = null;
                gZIPOutputStream3.close();
                outputStream.close();
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
                f(bArr, i6 + i, 3, bArr2, i7, i3);
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
                f(bArr, i6 + i, i2 - i6, bArr2, i7, i3);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:12|47|48|49|50|51|52|53|54|55) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:3|4|5|(5:7|8|9|10|11)(1:15)|16|17|18|19|20|21|22|23|24|25|26|27) */
    /* JADX WARNING: Can't wrap try/catch for region: R(18:1|2|3|4|5|(5:7|8|9|10|11)(1:15)|16|17|18|19|20|21|22|23|24|25|26|27) */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|4|5|(5:7|8|9|10|11)(1:15)|16|17|18|19|20|21|22|23|24|25|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        return new java.lang.String(r1.toByteArray());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0037 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0079 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x007c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x007f */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static String encodeObject(Serializable serializable, int i) {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        OutputStream outputStream;
        ?? r1;
        IOException e2;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        Objects.requireNonNull(serializable, "Cannot serialize a null object.");
        ObjectOutputStream objectOutputStream3 = null;
        try {
            ?? byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                outputStream = new OutputStream(byteArrayOutputStream, i | 1);
                if ((i & 2) != 0) {
                    try {
                        gZIPOutputStream = new GZIPOutputStream(outputStream);
                        try {
                            objectOutputStream2 = new ObjectOutputStream(gZIPOutputStream);
                        } catch (IOException e3) {
                            e2 = e3;
                            objectOutputStream = null;
                            objectOutputStream3 = byteArrayOutputStream;
                            try {
                                throw e2;
                            } catch (Throwable th2) {
                                th = th2;
                                r1 = objectOutputStream3;
                                objectOutputStream3 = objectOutputStream;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            r1 = byteArrayOutputStream;
                            objectOutputStream3.close();
                            gZIPOutputStream.close();
                            outputStream.close();
                            r1.close();
                            throw th;
                        }
                    } catch (IOException e4) {
                        e2 = e4;
                        gZIPOutputStream = null;
                        objectOutputStream3 = byteArrayOutputStream;
                        objectOutputStream = null;
                        throw e2;
                    } catch (Throwable th4) {
                        th = th4;
                        gZIPOutputStream = null;
                        r1 = byteArrayOutputStream;
                        objectOutputStream3.close();
                        gZIPOutputStream.close();
                        outputStream.close();
                        r1.close();
                        throw th;
                    }
                } else {
                    objectOutputStream2 = new ObjectOutputStream(outputStream);
                    gZIPOutputStream = null;
                }
                objectOutputStream2.writeObject(serializable);
                objectOutputStream2.close();
                gZIPOutputStream.close();
                outputStream.close();
                byteArrayOutputStream.close();
                return new String(byteArrayOutputStream.toByteArray(), "US-ASCII");
            } catch (IOException e5) {
                e2 = e5;
                gZIPOutputStream = null;
                outputStream = null;
                objectOutputStream3 = byteArrayOutputStream;
                objectOutputStream = null;
                throw e2;
            } catch (Throwable th5) {
                th = th5;
                gZIPOutputStream = null;
                outputStream = null;
                r1 = byteArrayOutputStream;
                objectOutputStream3.close();
                gZIPOutputStream.close();
                outputStream.close();
                r1.close();
                throw th;
            }
        } catch (IOException e6) {
            e2 = e6;
            gZIPOutputStream = null;
            objectOutputStream = null;
            outputStream = null;
            throw e2;
        } catch (Throwable th6) {
            th = th6;
            gZIPOutputStream = null;
            r1 = 0;
            outputStream = null;
            objectOutputStream3.close();
            gZIPOutputStream.close();
            outputStream.close();
            r1.close();
            throw th;
        }
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        try {
            return encodeBytes(bArr, i, i2, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i, i2, i3);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(encodeBytesToBytes);
        }
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            g(bArr2, bArr, min, 0);
            for (int i = 0; i < 4; i++) {
                charBuffer.put((char) (bArr2[i] & 255));
            }
        }
    }

    public static byte[] decode(String str) {
        return decode(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:53|54|55|56|57|(2:58|59)|60) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:15|16|17|(8:18|19|20|21|(3:22|23|(1:25)(1:64))|26|27|28)|29|30|31|32) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x008d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x0090 */
    public static byte[] decode(String str, int i) {
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
        byte[] decode = decode(bArr, 0, bArr.length, i);
        boolean z = (i & 4) != 0;
        if (decode != null && decode.length >= 4 && !z && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) {
            byte[] bArr2 = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(decode);
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
                                    SCLogCatUtil.error("WS_Base64", "Base64 decode error.", e2);
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    return decode;
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
                        decode = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e2 = e4;
                        gZIPInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        SCLogCatUtil.error("WS_Base64", "Base64 decode error.", e2);
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return decode;
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
                    SCLogCatUtil.error("WS_Base64", "Base64 decode error.", e2);
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return decode;
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
                SCLogCatUtil.error("WS_Base64", "Base64 decode error.", e2);
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return decode;
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
            try {
                byteArrayInputStream.close();
            } catch (Exception unused3) {
            }
        }
        return decode;
    }
}
