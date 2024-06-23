package tb;

import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
public class mz extends lx {
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected String h;
    protected DXWidgetNode i;

    public mz(long j) {
        super(j);
    }

    public void f(int i2) {
        this.e = i2;
    }

    public void g(int i2) {
        this.d = i2;
    }

    public void h(int i2) {
        this.g = i2;
    }

    public void i(int i2) {
        this.f = i2;
    }

    public void j(DXWidgetNode dXWidgetNode) {
        this.i = dXWidgetNode;
    }

    public void k(String str) {
        this.h = str;
    }

    public String toString() {
        return "DXRecyclerEvent{, deltaY=" + this.d + ", deltaX=" + this.e + ", offsetY=" + this.f + ", offsetX=" + this.g + ", userId='" + this.h + '\'' + ", selfWidget=" + this.i + '}';
    }
}
