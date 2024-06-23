package tb;

/* compiled from: Taobao */
public final class dw1 {
    public static final int NUM_MASK_PATTERNS = 8;
    private ve1 a = null;
    private ge0 b = null;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private vd j = null;

    public static boolean j(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public ge0 a() {
        return this.b;
    }

    public int b() {
        return this.e;
    }

    public vd c() {
        return this.j;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.c;
    }

    public boolean i() {
        int i2;
        vd vdVar;
        return (this.a == null || this.b == null || this.c == -1 || this.d == -1 || (i2 = this.e) == -1 || this.f == -1 || this.g == -1 || this.h == -1 || this.i == -1 || !j(i2) || this.f != this.g + this.h || (vdVar = this.j) == null || this.d != vdVar.e() || this.j.e() != this.j.d()) ? false : true;
    }

    public void k(ge0 ge0) {
        this.b = ge0;
    }

    public void l(int i2) {
        this.e = i2;
    }

    public void m(vd vdVar) {
        this.j = vdVar;
    }

    public void n(int i2) {
        this.d = i2;
    }

    public void o(ve1 ve1) {
        this.a = ve1;
    }

    public void p(int i2) {
        this.g = i2;
    }

    public void q(int i2) {
        this.h = i2;
    }

    public void r(int i2) {
        this.i = i2;
    }

    public void s(int i2) {
        this.f = i2;
    }

    public void t(int i2) {
        this.c = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("<<\n");
        stringBuffer.append(" mode: ");
        stringBuffer.append(this.a);
        stringBuffer.append("\n ecLevel: ");
        stringBuffer.append(this.b);
        stringBuffer.append("\n version: ");
        stringBuffer.append(this.c);
        stringBuffer.append("\n matrixWidth: ");
        stringBuffer.append(this.d);
        stringBuffer.append("\n maskPattern: ");
        stringBuffer.append(this.e);
        stringBuffer.append("\n numTotalBytes: ");
        stringBuffer.append(this.f);
        stringBuffer.append("\n numDataBytes: ");
        stringBuffer.append(this.g);
        stringBuffer.append("\n numECBytes: ");
        stringBuffer.append(this.h);
        stringBuffer.append("\n numRSBlocks: ");
        stringBuffer.append(this.i);
        if (this.j == null) {
            stringBuffer.append("\n matrix: null\n");
        } else {
            stringBuffer.append("\n matrix:\n");
            stringBuffer.append(this.j.toString());
        }
        stringBuffer.append(">>\n");
        return stringBuffer.toString();
    }
}
