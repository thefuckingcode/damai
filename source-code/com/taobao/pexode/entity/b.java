package com.taobao.pexode.entity;

import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import tb.jl1;

/* compiled from: Taobao */
public class b extends c {
    private boolean i;
    private FileChannel j;
    private long k;
    private FileDescriptor l;

    public b(@NonNull FileInputStream fileInputStream, int i2) {
        super(fileInputStream, 0);
        this.j = fileInputStream.getChannel();
        try {
            this.l = fileInputStream.getFD();
        } catch (IOException unused) {
        }
        this.k = -1;
        FileChannel fileChannel = this.j;
        if (fileChannel != null) {
            try {
                this.k = fileChannel.position();
            } catch (IOException unused2) {
            }
        }
        boolean f = f(null);
        this.i = f;
        if (!f) {
            e(i2);
        } else if (this.l != null) {
            resetInputType(2);
        }
    }

    private boolean f(IOException[] iOExceptionArr) {
        long j2 = this.k;
        if (j2 < 0) {
            return false;
        }
        try {
            this.j.position(j2);
            return true;
        } catch (IOException e) {
            if (iOExceptionArr == null || iOExceptionArr.length <= 0) {
                return false;
            }
            iOExceptionArr[0] = e;
            return false;
        }
    }

    @Override // com.taobao.pexode.entity.RewindableStream, com.taobao.pexode.entity.c
    public int getBufferLength() {
        try {
            if (this.j.size() > 0) {
                return (int) this.j.size();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.getBufferLength();
    }

    @Override // com.taobao.pexode.entity.RewindableStream, com.taobao.pexode.entity.c
    public FileDescriptor getFD() {
        return this.l;
    }

    @Override // com.taobao.pexode.entity.c, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.i) {
            return this.a.read(bArr, i2, i3);
        }
        return super.read(bArr, i2, i3);
    }

    @Override // com.taobao.pexode.entity.RewindableStream, com.taobao.pexode.entity.c
    public void rewind() throws IOException {
        if (!this.i) {
            super.rewind();
        } else if (!this.h) {
            IOException[] iOExceptionArr = new IOException[1];
            if (!f(iOExceptionArr)) {
                IOException iOException = iOExceptionArr[0];
                StringBuilder sb = new StringBuilder();
                sb.append("cannot rewind cause file stream reposition(");
                sb.append(this.k);
                sb.append(":");
                sb.append(this.l);
                sb.append(") failed, detail=");
                sb.append(iOException != null ? iOException.getMessage() : "null");
                sb.append(jl1.AND_NOT);
                throw new IOException(sb.toString());
            }
        } else {
            throw new IOException("cannot rewind cause file stream has been closed!");
        }
    }

    @Override // com.taobao.pexode.entity.RewindableStream, com.taobao.pexode.entity.c
    public void rewindAndSetBufferSize(int i2) throws IOException {
        rewind();
        e(i2);
    }

    @Override // com.taobao.pexode.entity.c, java.io.InputStream
    public int read() throws IOException {
        if (this.i) {
            return this.a.read();
        }
        return super.read();
    }
}
