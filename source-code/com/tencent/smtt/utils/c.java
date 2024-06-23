package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.UByte;

/* compiled from: DataReader */
public class c implements Closeable {
    private final RandomAccessFile a;
    private final File b;
    private final byte[] c;
    private boolean d;

    public c(String str) throws FileNotFoundException {
        this(new File(str));
    }

    public c(File file) throws FileNotFoundException {
        this.c = new byte[8];
        this.b = file;
        this.a = new RandomAccessFile(file, "r");
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(long j) throws IOException {
        this.a.seek(j);
    }

    public final int a(byte[] bArr) throws IOException {
        return this.a.read(bArr);
    }

    public final int a(char[] cArr) throws IOException {
        byte[] bArr = new byte[cArr.length];
        int read = this.a.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        return read;
    }

    public final short a() throws IOException {
        short readShort = this.a.readShort();
        if (!this.d) {
            return readShort;
        }
        return (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
    }

    public final int b() throws IOException {
        int readInt = this.a.readInt();
        if (!this.d) {
            return readInt;
        }
        return ((readInt & -16777216) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
    }

    public final long c() throws IOException {
        if (!this.d) {
            return this.a.readLong();
        }
        this.a.readFully(this.c, 0, 8);
        byte[] bArr = this.c;
        return ((long) (bArr[0] & UByte.MAX_VALUE)) | (((long) bArr[7]) << 56) | (((long) (bArr[6] & UByte.MAX_VALUE)) << 48) | (((long) (bArr[5] & UByte.MAX_VALUE)) << 40) | (((long) (bArr[4] & UByte.MAX_VALUE)) << 32) | (((long) (bArr[3] & UByte.MAX_VALUE)) << 24) | (((long) (bArr[2] & UByte.MAX_VALUE)) << 16) | (((long) (bArr[1] & UByte.MAX_VALUE)) << 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
