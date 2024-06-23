package tb;

import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.produce.Producer;
import java.lang.reflect.Type;
import tb.c02;

/* compiled from: Taobao */
public class rg<OUT, CONTEXT extends c02> {
    private final boolean a;
    private final Producer<OUT, CONTEXT> b;
    private qg c;

    public <NEXT_OUT extends Releasable> rg(qg<OUT, NEXT_OUT, CONTEXT> qgVar, boolean z) {
        cs1.c(qgVar);
        this.a = z;
        if (z && qgVar.m() && qgVar.j() != qgVar.h()) {
            d(qgVar.getName());
        }
        this.b = qgVar;
        this.c = qgVar;
    }

    public static <O, NEXT_O extends Releasable, CONTEXT extends c02> rg<O, CONTEXT> b(qg<O, NEXT_O, CONTEXT> qgVar, boolean z) {
        return new rg<>(qgVar, z);
    }

    public Producer<OUT, CONTEXT> a() {
        return this.b;
    }

    public <NEXT_O, NN_O extends Releasable> rg<OUT, CONTEXT> c(qg<NEXT_O, NN_O, CONTEXT> qgVar) {
        cs1.c(qgVar);
        if (this.a) {
            Type j = qgVar.j();
            if (qgVar.m() && j != qgVar.h()) {
                d(qgVar.getName());
            }
            Type h = this.c.h();
            if (h != j) {
                throw new RuntimeException("NEXT_OUT " + h + " of last producer(" + this.c.getClass().getSimpleName() + ") not equal OUT " + j + " of next producer(" + qgVar.getClass().getSimpleName() + jl1.BRACKET_END_STR);
            }
        }
        this.c = this.c.B(qgVar);
        return this;
    }

    public void d(String str) {
        throw new IllegalArgumentException(str + " skip to consume new result, require OUT class must equal NEXT_OUT class");
    }
}
