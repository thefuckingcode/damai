package tb;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class m92 {
    private final List<mp> a;
    private PointF b;
    private boolean c;

    public m92(PointF pointF, boolean z, List<mp> list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
    }

    private void e(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public List<mp> a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(m92 m92, m92 m922, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = m92.d() || m922.d();
        if (m92.a().size() != m922.a().size()) {
            o91.c("Curves must have the same number of control points. Shape 1: " + m92.a().size() + "\tShape 2: " + m922.a().size());
        }
        int min = Math.min(m92.a().size(), m922.a().size());
        if (this.a.size() < min) {
            for (int size = this.a.size(); size < min; size++) {
                this.a.add(new mp());
            }
        } else if (this.a.size() > min) {
            for (int size2 = this.a.size() - 1; size2 >= min; size2--) {
                List<mp> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF b2 = m92.b();
        PointF b3 = m922.b();
        e(he1.k(b2.x, b3.x, f), he1.k(b2.y, b3.y, f));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            mp mpVar = m92.a().get(size3);
            mp mpVar2 = m922.a().get(size3);
            PointF a2 = mpVar.a();
            PointF b4 = mpVar.b();
            PointF c2 = mpVar.c();
            PointF a3 = mpVar2.a();
            PointF b5 = mpVar2.b();
            PointF c3 = mpVar2.c();
            this.a.get(size3).d(he1.k(a2.x, a3.x, f), he1.k(a2.y, a3.y, f));
            this.a.get(size3).e(he1.k(b4.x, b5.x, f), he1.k(b4.y, b5.y, f));
            this.a.get(size3).f(he1.k(c2.x, c3.x, f), he1.k(c2.y, c3.y, f));
        }
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }

    public m92() {
        this.a = new ArrayList();
    }
}
