package tb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
public class pd implements Comparable<pd> {
    final byte[] a;
    int b;
    int c;

    private pd(byte[] bArr, int i) {
        bArr = bArr == null ? new byte[i] : bArr;
        this.a = bArr;
        this.b = bArr.length;
        this.c = i;
    }

    public static pd b(int i) {
        return new pd(null, i);
    }

    public static pd g(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return h(bArr, bArr.length);
    }

    public static pd h(byte[] bArr, int i) {
        if (bArr == null || i < 0 || i > bArr.length) {
            return null;
        }
        return new pd(bArr, i);
    }

    /* renamed from: a */
    public int compareTo(pd pdVar) {
        int i = this.b;
        int i2 = pdVar.b;
        if (i != i2) {
            return i - i2;
        }
        if (this.a == null) {
            return -1;
        }
        if (pdVar.a == null) {
            return 1;
        }
        return hashCode() - pdVar.hashCode();
    }

    public byte[] c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public int e(InputStream inputStream) throws IOException {
        int i = 0;
        int read = inputStream.read(this.a, 0, this.b);
        if (read != -1) {
            i = read;
        }
        this.c = i;
        return read;
    }

    public void f() {
        if (this.b != 0) {
            rd.a().b(this);
        }
    }

    public void i(OutputStream outputStream) throws IOException {
        outputStream.write(this.a, 0, this.c);
    }
}
