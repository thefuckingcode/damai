package tb;

import java.lang.reflect.Array;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
public final class vd {
    private final byte[][] a;
    private final int b;
    private final int c;

    public vd(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.a = (byte[][]) Array.newInstance(byte.class, iArr);
        this.b = i;
        this.c = i2;
    }

    public void a(byte b2) {
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                this.a[i][i2] = b2;
            }
        }
    }

    public byte b(int i, int i2) {
        return this.a[i2][i];
    }

    public byte[][] c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public void f(int i, int i2, int i3) {
        this.a[i2][i] = (byte) i3;
    }

    public void g(int i, int i2, boolean z) {
        this.a[i2][i] = z ? (byte) 1 : 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b2 = this.a[i][i2];
                if (b2 == 0) {
                    stringBuffer.append(" 0");
                } else if (b2 != 1) {
                    stringBuffer.append(AltriaXLaunchTime.SPACE);
                } else {
                    stringBuffer.append(" 1");
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
