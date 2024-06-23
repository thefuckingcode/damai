package org.apache.commons.net.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
public final class FromNetASCIIOutputStream extends FilterOutputStream {
    private boolean __lastWasCR = false;

    public FromNetASCIIOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    private void __write(int i) throws IOException {
        if (i != 10) {
            if (i != 13) {
                if (this.__lastWasCR) {
                    ((FilterOutputStream) this).out.write(13);
                    this.__lastWasCR = false;
                }
                ((FilterOutputStream) this).out.write(i);
                return;
            }
            this.__lastWasCR = true;
        } else if (this.__lastWasCR) {
            ((FilterOutputStream) this).out.write(FromNetASCIIInputStream._lineSeparatorBytes);
            this.__lastWasCR = false;
        } else {
            this.__lastWasCR = false;
            ((FilterOutputStream) this).out.write(10);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (FromNetASCIIInputStream._noConversionRequired) {
            super.close();
            return;
        }
        if (this.__lastWasCR) {
            ((FilterOutputStream) this).out.write(13);
        }
        super.close();
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public synchronized void write(int i) throws IOException {
        if (FromNetASCIIInputStream._noConversionRequired) {
            ((FilterOutputStream) this).out.write(i);
        } else {
            __write(i);
        }
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (FromNetASCIIInputStream._noConversionRequired) {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
            return;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                __write(bArr[i]);
                i++;
                i2 = i3;
            } else {
                return;
            }
        }
    }
}
