package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: Taobao */
public final class cx implements Closeable {
    public static final Charset a = Charset.forName("US-ASCII");
    private final InputStream b;
    private final Charset c;
    private byte[] d;
    private int e;
    private int f;

    public cx(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private void b() throws IOException {
        InputStream inputStream = this.b;
        byte[] bArr = this.d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.e = 0;
            this.f = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.b) {
            if (this.d != null) {
                this.d = null;
                this.b.close();
            }
        }
    }

    private cx(InputStream inputStream, Charset charset, byte b2) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (charset.equals(a)) {
            this.b = inputStream;
            this.c = charset;
            this.d = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final String a() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.b) {
            if (this.d != null) {
                if (this.e >= this.f) {
                    b();
                }
                for (int i3 = this.e; i3 != this.f; i3++) {
                    byte[] bArr2 = this.d;
                    if (bArr2[i3] == 10) {
                        int i4 = this.e;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.c.name());
                                this.e = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.c.name());
                        this.e = i3 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.f - this.e) + 80) {
                    /* class com.amap.api.col.s.cx.AnonymousClass1 */

                    public final String toString() {
                        int i = ((ByteArrayOutputStream) this).count;
                        if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                            i--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i, cx.this.c.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr3 = this.d;
                    int i5 = this.e;
                    r1.write(bArr3, i5, this.f - i5);
                    this.f = -1;
                    b();
                    i = this.e;
                    while (true) {
                        if (i != this.f) {
                            bArr = this.d;
                            if (bArr[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                int i6 = this.e;
                if (i != i6) {
                    r1.write(bArr, i6, i - i6);
                }
                this.e = i + 1;
                return r1.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }
}
