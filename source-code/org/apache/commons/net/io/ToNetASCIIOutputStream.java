package org.apache.commons.net.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
public final class ToNetASCIIOutputStream extends FilterOutputStream {
    private boolean __lastWasCR = false;

    public ToNetASCIIOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public synchronized void write(int i) throws IOException {
        if (i != 10) {
            if (i == 13) {
                this.__lastWasCR = true;
                ((FilterOutputStream) this).out.write(13);
                return;
            }
        } else if (!this.__lastWasCR) {
            ((FilterOutputStream) this).out.write(13);
        }
        this.__lastWasCR = false;
        ((FilterOutputStream) this).out.write(i);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                int i4 = i + 1;
                write(bArr[i]);
                i = i4;
                i2 = i3;
            }
        }
    }
}
