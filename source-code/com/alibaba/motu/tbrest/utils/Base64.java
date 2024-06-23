package com.alibaba.motu.tbrest.utils;

import androidx.core.view.MotionEventCompat;
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
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    public static final int GZIP = 2;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    private static final String PREFERRED_ENCODING = "US-ASCII";
    public static final int URL_SAFE = 16;
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte[] _ORDERED_ALPHABET = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] _ORDERED_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, -9, -9, -9, -9, ok1.OP_UNARY_MIN, -9, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] _STANDARD_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, ok1.OP_MAX_COUNT, 47};
    private static final byte[] _STANDARD_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] _URL_SAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] _URL_SAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, ok1.OP_CREATE_JSON, ok1.OP_CREATE_ARRAY, ok1.OP_INSERT_VALUE, ok1.OP_INSERT_KVPAIR, ok1.OP_UNARY_MIN, ok1.OP_GOTO, ok1.OP_TYPEOF, ok1.OP_CALL_DX_EVENT, ok1.OP_CALL_DX_PARSER, ok1.OP_GET_OPT_JUMP, ok1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* compiled from: Taobao */
    public static class InputStream extends FilterInputStream {
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private byte[] decodabet;
        private boolean encode;
        private int lineLength;
        private int numSigBytes;
        private int options;
        private int position;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read;
            if (this.position < 0) {
                if (this.encode) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        int read2 = ((FilterInputStream) this).in.read();
                        if (read2 < 0) {
                            break;
                        }
                        bArr[i2] = (byte) read2;
                        i++;
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    Base64.encode3to4(bArr, 0, i, this.buffer, 0, this.options);
                    this.position = 0;
                    this.numSigBytes = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = ((FilterInputStream) this).in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.decodabet[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 == 4) {
                        this.numSigBytes = Base64.decode4to3(bArr2, 0, this.buffer, 0, this.options);
                        this.position = 0;
                    } else if (i3 == 0) {
                        return -1;
                    } else {
                        throw new IOException("Improperly padded Base64 input.");
                    }
                }
            }
            int i4 = this.position;
            if (i4 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            } else if (i4 >= this.numSigBytes) {
                return -1;
            } else {
                if (!this.encode || !this.breakLines || this.lineLength < 76) {
                    this.lineLength++;
                    byte[] bArr3 = this.buffer;
                    int i5 = i4 + 1;
                    this.position = i5;
                    byte b = bArr3[i4];
                    if (i5 >= this.bufferLength) {
                        this.position = -1;
                    }
                    return b & 255;
                }
                this.lineLength = 0;
                return 10;
            }
        }

        public InputStream(java.io.InputStream inputStream, int i) {
            super(inputStream);
            this.options = i;
            boolean z = true;
            this.breakLines = (i & 8) > 0;
            z = (i & 1) <= 0 ? false : z;
            this.encode = z;
            int i2 = z ? 4 : 3;
            this.bufferLength = i2;
            this.buffer = new byte[i2];
            this.position = -1;
            this.lineLength = 0;
            this.decodabet = Base64.getDecodabet(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    /* compiled from: Taobao */
    public static class OutputStream extends FilterOutputStream {
        private byte[] b4;
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private byte[] decodabet;
        private boolean encode;
        private int lineLength;
        private int options;
        private int position;
        private boolean suspendEncoding;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            ((FilterOutputStream) this).out = null;
        }

        public void flushBase64() throws IOException {
            int i = this.position;
            if (i <= 0) {
                return;
            }
            if (this.encode) {
                ((FilterOutputStream) this).out.write(Base64.encode3to4(this.b4, this.buffer, i, this.options));
                this.position = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void resumeEncoding() {
            this.suspendEncoding = false;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.suspendEncoding = true;
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(int i) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(i);
            } else if (this.encode) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                int i4 = this.bufferLength;
                if (i3 >= i4) {
                    ((FilterOutputStream) this).out.write(Base64.encode3to4(this.b4, bArr, i4, this.options));
                    int i5 = this.lineLength + 4;
                    this.lineLength = i5;
                    if (this.breakLines && i5 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                }
            } else {
                byte[] bArr2 = this.decodabet;
                int i6 = i & 127;
                if (bArr2[i6] > -5) {
                    byte[] bArr3 = this.buffer;
                    int i7 = this.position;
                    int i8 = i7 + 1;
                    this.position = i8;
                    bArr3[i7] = (byte) i;
                    if (i8 >= this.bufferLength) {
                        ((FilterOutputStream) this).out.write(this.b4, 0, Base64.decode4to3(bArr3, 0, this.b4, 0, this.options));
                        this.position = 0;
                    }
                } else if (bArr2[i6] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            boolean z = true;
            this.breakLines = (i & 8) != 0;
            z = (i & 1) == 0 ? false : z;
            this.encode = z;
            int i2 = z ? 3 : 4;
            this.bufferLength = i2;
            this.buffer = new byte[i2];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.b4 = new byte[4];
            this.options = i;
            this.decodabet = Base64.getDecodabet(i);
        }

        @Override // java.io.OutputStream, java.io.FilterOutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    private Base64() {
    }

    public static byte[] decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length, 0);
    }

    /* access modifiers changed from: private */
    public static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        Objects.requireNonNull(bArr, "Source array was null.");
        Objects.requireNonNull(bArr2, "Destination array was null.");
        if (i < 0 || (i4 = i + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        } else if (i2 < 0 || (i5 = i2 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        } else {
            byte[] decodabet = getDecodabet(i3);
            int i6 = i + 2;
            if (bArr[i6] == 61) {
                bArr2[i2] = (byte) ((((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18)) >>> 16);
                return 1;
            } else if (bArr[i4] == 61) {
                int i7 = ((decodabet[bArr[i6]] & 255) << 6) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18);
                bArr2[i2] = (byte) (i7 >>> 16);
                bArr2[i2 + 1] = (byte) (i7 >>> 8);
                return 2;
            } else {
                int i8 = (decodabet[bArr[i4]] & 255) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i6]] & 255) << 6);
                bArr2[i2] = (byte) (i8 >> 16);
                bArr2[i2 + 1] = (byte) (i8 >> 8);
                bArr2[i5] = (byte) i8;
                return 3;
            }
        }
    }

    public static void decodeFileToFile(String str, String str2) throws IOException {
        Throwable th;
        IOException e;
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
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
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
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static byte[] decodeFromFile(String str) throws IOException {
        Throwable th;
        IOException e;
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
                    } catch (IOException e2) {
                        e = e2;
                        inputStream = inputStream2;
                        try {
                            throw e;
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
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static void decodeToFile(String str, String str2) throws IOException {
        Throwable th;
        IOException e;
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str2), 0);
            try {
                outputStream2.write(str.getBytes("US-ASCII"));
                try {
                    outputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = outputStream2;
                try {
                    throw e;
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
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static Object decodeToObject(String str) throws IOException, ClassNotFoundException {
        return decodeToObject(str, 0, null);
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            encode3to4(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    /* access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i, int i2) {
        encode3to4(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    public static String encodeBase64String(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : encodeBytes(bArr);
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

    public static void encodeFileToFile(String str, String str2) throws IOException {
        Throwable th;
        IOException e;
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
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
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
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static String encodeFromFile(String str) throws IOException {
        Throwable th;
        IOException e;
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
                } catch (IOException e2) {
                    e = e2;
                    inputStream = inputStream2;
                    try {
                        throw e;
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
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static String encodeObject(Serializable serializable) throws IOException {
        return encodeObject(serializable, 0);
    }

    public static void encodeToFile(byte[] bArr, String str) throws IOException {
        Throwable th;
        IOException e;
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
            } catch (IOException e2) {
                e = e2;
                outputStream = outputStream2;
                try {
                    throw e;
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
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    private static final byte[] getAlphabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_ALPHABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_ALPHABET;
        }
        return _STANDARD_ALPHABET;
    }

    /* access modifiers changed from: private */
    public static final byte[] getDecodabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_DECODABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_DECODABET;
        }
        return _STANDARD_DECODABET;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) throws IOException {
        int i4;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        if (i < 0 || (i4 = i + i2) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        } else if (i2 == 0) {
            return new byte[0];
        } else {
            if (i2 >= 4) {
                byte[] decodabet = getDecodabet(i3);
                byte[] bArr2 = new byte[((i2 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i5 = 0;
                int i6 = 0;
                while (i < i4) {
                    byte b = decodabet[bArr[i] & 255];
                    if (b >= -5) {
                        if (b >= -1) {
                            int i7 = i5 + 1;
                            bArr3[i5] = bArr[i];
                            if (i7 > 3) {
                                i6 += decode4to3(bArr3, 0, bArr2, i6, i3);
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
    public static Object decodeToObject(String str, int i, final ClassLoader classLoader) throws IOException, ClassNotFoundException {
        ?? r3;
        Throwable th;
        IOException e;
        ClassNotFoundException e2;
        ObjectInputStream objectInputStream;
        byte[] decode = decode(str, i);
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(decode);
            if (classLoader == null) {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream2);
                } catch (IOException e3) {
                    e = e3;
                    throw e;
                } catch (ClassNotFoundException e4) {
                    e2 = e4;
                    classLoader = null;
                    byteArrayInputStream = byteArrayInputStream2;
                    throw e2;
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
                    /* class com.alibaba.motu.tbrest.utils.Base64.AnonymousClass1 */

                    @Override // java.io.ObjectInputStream
                    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                        Class<?> cls = Class.forName(objectStreamClass.getName(), false, classLoader);
                        return cls == null ? super.resolveClass(objectStreamClass) : cls;
                    }
                };
            }
            Object readObject = objectInputStream.readObject();
            byteArrayInputStream2.close();
            objectInputStream.close();
            return readObject;
        } catch (IOException e5) {
            e = e5;
            throw e;
        } catch (ClassNotFoundException e6) {
            e2 = e6;
            classLoader = null;
            throw e2;
        } catch (Throwable th3) {
            th = th3;
            r3 = classLoader;
            byteArrayInputStream.close();
            r3.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] alphabet = getAlphabet(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = EQUALS_SIGN;
            bArr2[i3 + 3] = EQUALS_SIGN;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = alphabet[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = EQUALS_SIGN;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = alphabet[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = alphabet[i7 & 63];
            return bArr2;
        }
    }

    public static String encodeBytes(byte[] bArr, int i) throws IOException {
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
    public static byte[] encodeBytesToBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
        OutputStream outputStream;
        ?? r2;
        Throwable th;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        IOException e;
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
                } catch (IOException e2) {
                    e = e2;
                    outputStream = null;
                    gZIPOutputStream = null;
                    gZIPOutputStream3 = byteArrayOutputStream;
                    try {
                        throw e;
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
                    } catch (IOException e3) {
                        e = e3;
                        gZIPOutputStream3 = byteArrayOutputStream;
                        throw e;
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
                } catch (IOException e4) {
                    e = e4;
                    gZIPOutputStream = null;
                    gZIPOutputStream3 = byteArrayOutputStream;
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    r2 = byteArrayOutputStream;
                    gZIPOutputStream3.close();
                    outputStream.close();
                    r2.close();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                outputStream = null;
                gZIPOutputStream = null;
                throw e;
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
                encode3to4(bArr, i6 + i, 3, bArr2, i7, i3);
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
                encode3to4(bArr, i6 + i, i2 - i6, bArr2, i7, i3);
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
    public static String encodeObject(Serializable serializable, int i) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        OutputStream outputStream;
        ?? r1;
        IOException e;
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
                        } catch (IOException e2) {
                            e = e2;
                            objectOutputStream = null;
                            objectOutputStream3 = byteArrayOutputStream;
                            try {
                                throw e;
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
                    } catch (IOException e3) {
                        e = e3;
                        gZIPOutputStream = null;
                        objectOutputStream3 = byteArrayOutputStream;
                        objectOutputStream = null;
                        throw e;
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
            } catch (IOException e4) {
                e = e4;
                gZIPOutputStream = null;
                outputStream = null;
                objectOutputStream3 = byteArrayOutputStream;
                objectOutputStream = null;
                throw e;
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
        } catch (IOException e5) {
            e = e5;
            gZIPOutputStream = null;
            objectOutputStream = null;
            outputStream = null;
            throw e;
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

    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
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
            encode3to4(bArr2, bArr, min, 0);
            for (int i = 0; i < 4; i++) {
                charBuffer.put((char) (bArr2[i] & 255));
            }
        }
    }

    public static byte[] decode(String str) throws IOException {
        return decode(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|(3:16|17|(8:18|19|20|21|(3:22|23|(1:25)(1:63))|26|27|28))|29|30|31|32) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:15|16|17|(8:18|19|20|21|(3:22|23|(1:25)(1:63))|26|27|28)|29|30|31|32) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:52|53|54|55|56|57|58|59) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0089 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x008c */
    public static byte[] decode(String str, int i) throws IOException {
        byte[] bArr;
        Throwable th;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        IOException e;
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
                            } catch (IOException e2) {
                                e = e2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    e.printStackTrace();
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    return decode;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
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
                    } catch (IOException e3) {
                        e = e3;
                        gZIPInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        e.printStackTrace();
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
                } catch (IOException e4) {
                    e = e4;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    e.printStackTrace();
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
            } catch (IOException e5) {
                e = e5;
                byteArrayInputStream = null;
                gZIPInputStream = null;
                e.printStackTrace();
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
            byteArrayInputStream.close();
        }
        return decode;
    }
}
