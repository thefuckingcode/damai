package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
public class cy {
    private int a;
    private int b;
    byte[] c;

    public byte[] a() {
        return this.c;
    }

    public boolean b(ys ysVar, DXRuntimeContext dXRuntimeContext) {
        int i = this.b;
        if (i < 0) {
            ry.c("读取新表达式相关逻辑失败");
            return false;
        }
        this.c = new byte[i];
        ysVar.i(this.a);
        for (int i2 = 0; i2 < this.b; i2++) {
            this.c[i2] = ysVar.d();
        }
        return true;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.a = i;
    }
}
