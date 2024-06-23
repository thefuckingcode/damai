package tb;

import android.view.View;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import java.util.List;

/* compiled from: Taobao */
public class fd2 implements ICalculator {
    private final View a;
    private final View b;

    public fd2(View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    @Override // com.taobao.monitor.impl.data.calculator.ICalculator
    public ne calculate() {
        aw2 aw2 = new aw2(this.a, this.b);
        List<zv2> c = aw2.c();
        View f = aw2.f();
        float a2 = new j71().a(this.a, c, this.b);
        i20.a("DrawCalculator2", "SpecificViewAreaCalculator calculate percent = " + a2);
        for (zv2 zv2 : c) {
            zv2.c();
        }
        aw2.n();
        boolean g = aw2.g();
        View e = aw2.e();
        if (f == this.b) {
            f = null;
        }
        return new ne(fd2.class, a2, g, e, f);
    }
}
