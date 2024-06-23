package tb;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class un0 {
    private final tn0 a;
    private final int[] b;

    un0(tn0 tn0, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = tn0;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = tn0.d().b;
            return;
        }
        int[] iArr2 = new int[(length - i)];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    /* access modifiers changed from: package-private */
    public un0 a(un0 un0) {
        if (!this.a.equals(un0.a)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        } else if (f()) {
            return un0;
        } else {
            if (un0.f()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = un0.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = tn0.a(iArr2[i - length], iArr[i]);
            }
            return new un0(this.a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public un0[] b(un0 un0) {
        if (!this.a.equals(un0.a)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        } else if (!un0.f()) {
            un0 d = this.a.d();
            int e = this.a.e(un0.c(un0.e()));
            un0 un02 = this;
            while (un02.e() >= un0.e() && !un02.f()) {
                int e2 = un02.e() - un0.e();
                int g = this.a.g(un02.c(un02.e()), e);
                un0 h = un0.h(e2, g);
                d = d.a(this.a.b(e2, g));
                un02 = un02.a(h);
            }
            return new un0[]{d, un02};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    public int[] d() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.b.length - 1;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public un0 g(un0 un0) {
        if (!this.a.equals(un0.a)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        } else if (f() || un0.f()) {
            return this.a.d();
        } else {
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = un0.b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = tn0.a(iArr3[i4], this.a.g(i2, iArr2[i3]));
                }
            }
            return new un0(this.a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public un0 h(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.a.d();
        } else {
            int length = this.b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.a.g(this.b[i3], i2);
            }
            return new un0(this.a, iArr);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(e() * 8);
        for (int e = e(); e >= 0; e--) {
            int c = c(e);
            if (c != 0) {
                if (c < 0) {
                    stringBuffer.append(" - ");
                    c = -c;
                } else if (stringBuffer.length() > 0) {
                    stringBuffer.append(" + ");
                }
                if (e == 0 || c != 1) {
                    int f = this.a.f(c);
                    if (f == 0) {
                        stringBuffer.append('1');
                    } else if (f == 1) {
                        stringBuffer.append('a');
                    } else {
                        stringBuffer.append("a^");
                        stringBuffer.append(f);
                    }
                }
                if (e != 0) {
                    if (e == 1) {
                        stringBuffer.append('x');
                    } else {
                        stringBuffer.append("x^");
                        stringBuffer.append(e);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
