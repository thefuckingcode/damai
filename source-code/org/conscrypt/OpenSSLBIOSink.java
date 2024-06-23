package org.conscrypt;

import java.io.ByteArrayOutputStream;

final class OpenSSLBIOSink {
    private final ByteArrayOutputStream buffer;
    private final long ctx;
    private int position;

    static OpenSSLBIOSink create() {
        return new OpenSSLBIOSink(new ByteArrayOutputStream());
    }

    private OpenSSLBIOSink(ByteArrayOutputStream byteArrayOutputStream) {
        this.ctx = NativeCrypto.create_BIO_OutputStream(byteArrayOutputStream);
        this.buffer = byteArrayOutputStream;
    }

    /* access modifiers changed from: package-private */
    public int available() {
        return this.buffer.size() - this.position;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.buffer.reset();
        this.position = 0;
    }

    /* access modifiers changed from: package-private */
    public long skip(long j) {
        int min = Math.min(available(), (int) j);
        int i = this.position + min;
        this.position = i;
        if (i == this.buffer.size()) {
            reset();
        }
        return (long) min;
    }

    /* access modifiers changed from: package-private */
    public long getContext() {
        return this.ctx;
    }

    /* access modifiers changed from: package-private */
    public byte[] toByteArray() {
        return this.buffer.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public int position() {
        return this.position;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            NativeCrypto.BIO_free_all(this.ctx);
        } finally {
            super.finalize();
        }
    }
}
