package tb;

import java.util.HashMap;

/* compiled from: Taobao */
public class fz extends lx {
    public int d;

    public fz(long j) {
        super(j);
    }

    public void f(int i) {
        this.d = i;
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put("pageIndex", ey.J((long) i));
    }
}
