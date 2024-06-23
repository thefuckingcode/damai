package tb;

/* compiled from: Taobao */
public class bt0 {
    private final float[] a;
    private final int[] b;

    public bt0(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    public int[] a() {
        return this.b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.b.length;
    }

    public void d(bt0 bt0, bt0 bt02, float f) {
        if (bt0.b.length == bt02.b.length) {
            for (int i = 0; i < bt0.b.length; i++) {
                this.a[i] = he1.k(bt0.a[i], bt02.a[i], f);
                this.b[i] = xr0.c(f, bt0.b[i], bt02.b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + bt0.b.length + " vs " + bt02.b.length + jl1.BRACKET_END_STR);
    }
}
