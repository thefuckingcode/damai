package tb;

import java.util.Vector;

/* compiled from: Taobao */
public final class ux1 {
    private final tn0 a;
    private final Vector b;

    public ux1(tn0 tn0) {
        if (tn0.QR_CODE_FIELD.equals(tn0)) {
            this.a = tn0;
            Vector vector = new Vector();
            this.b = vector;
            vector.addElement(new un0(tn0, new int[]{1}));
            return;
        }
        throw new IllegalArgumentException("Only QR Code is supported at this time");
    }

    private un0 a(int i) {
        if (i >= this.b.size()) {
            Vector vector = this.b;
            un0 un0 = (un0) vector.elementAt(vector.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                tn0 tn0 = this.a;
                un0 = un0.g(new un0(tn0, new int[]{1, tn0.c(size - 1)}));
                this.b.addElement(un0);
            }
        }
        return (un0) this.b.elementAt(i);
    }

    public void b(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                un0 a2 = a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] d = new un0(this.a, iArr2).h(i, 1).b(a2)[1].d();
                int length2 = i - d.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(d, 0, iArr, length + length2, d.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
