package tb;

import java.lang.reflect.Array;

/* compiled from: Taobao */
public class p82 {
    private int a;
    private int b;
    private float[][] c;
    private int d;
    private int e;

    public p82(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (i <= 0) {
            throw new IllegalArgumentException("sampleBufSize is invalid.");
        } else if (i2 > 0) {
            int[] iArr = new int[2];
            iArr[1] = i2;
            iArr[0] = i;
            this.c = (float[][]) Array.newInstance(float.class, iArr);
        } else {
            throw new IllegalArgumentException("numAxes is invalid.");
        }
    }

    public void a(float[] fArr) {
        if (fArr.length >= this.b) {
            this.d = (this.d + 1) % this.a;
            for (int i = 0; i < this.b; i++) {
                this.c[this.d][i] = fArr[i];
            }
            this.e++;
            return;
        }
        throw new IllegalArgumentException("values.length is less than # of axes.");
    }

    public float b(int i) {
        if (!f()) {
            throw new IllegalStateException("Average not available. Not enough samples.");
        } else if (i < 0 || i >= this.b) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("axis must be between 0 and ");
            sb.append(this.b - 1);
            throw new IllegalStateException(sb.toString());
        } else {
            float f = 0.0f;
            int i2 = 0;
            while (true) {
                int i3 = this.a;
                if (i2 >= i3) {
                    return f / ((float) i3);
                }
                f += this.c[i2][i];
                i2++;
            }
        }
    }

    public float c() {
        float f = 0.0f;
        for (int i = 0; i < this.b; i++) {
            f = Math.max(f, d(i));
        }
        return f;
    }

    public float d(int i) {
        if (i < 0 || i >= this.b) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("axis must be between 0 and ");
            sb.append(this.b - 1);
            throw new IllegalStateException(sb.toString());
        }
        float b2 = b(i);
        float f = 0.0f;
        for (int i2 = 0; i2 < this.a; i2++) {
            f = Math.max(Math.abs(this.c[i2][i] - b2), f);
        }
        return f;
    }

    public void e() {
        this.e = 0;
        this.d = 0;
    }

    public boolean f() {
        return this.e >= this.a;
    }
}
