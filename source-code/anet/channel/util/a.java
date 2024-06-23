package anet.channel.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: Taobao */
public class a extends InputStream {
    private InputStream a = null;
    private long b = 0;

    public a(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "input stream cannot be null");
        this.a = inputStream;
    }

    public long a() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.b++;
        return this.a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.a.read(bArr, i, i2);
        if (read != -1) {
            this.b += (long) read;
        }
        return read;
    }
}
