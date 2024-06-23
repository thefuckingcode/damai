package tb;

/* compiled from: Taobao */
public final class tb {
    public int[] a = new int[1];
    public int b = 0;

    private void d(int i) {
        if (i > (this.a.length << 5)) {
            int[] h = h(i);
            int[] iArr = this.a;
            System.arraycopy(iArr, 0, h, 0, iArr.length);
            this.a = h;
        }
    }

    private static int[] h(int i) {
        return new int[((i + 31) >> 5)];
    }

    public void a(boolean z) {
        d(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i = this.b;
            int i2 = i >> 5;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.b++;
    }

    public void b(tb tbVar) {
        int f = tbVar.f();
        d(this.b + f);
        for (int i = 0; i < f; i++) {
            a(tbVar.e(i));
        }
    }

    public void c(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        d(this.b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i2--;
        }
    }

    public boolean e(int i) {
        return ((1 << (i & 31)) & this.a[i >> 5]) != 0;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return (this.b + 7) >> 3;
    }

    public void i(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (e(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public void j(tb tbVar) {
        if (this.a.length == tbVar.a.length) {
            int i = 0;
            while (true) {
                int[] iArr = this.a;
                if (i < iArr.length) {
                    iArr[i] = iArr[i] ^ tbVar.a[i];
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.b);
        for (int i = 0; i < this.b; i++) {
            if ((i & 7) == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(e(i) ? 'X' : '.');
        }
        return stringBuffer.toString();
    }
}
