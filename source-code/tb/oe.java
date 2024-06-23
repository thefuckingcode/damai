package tb;

import android.text.TextUtils;
import android.view.View;
import com.taobao.monitor.impl.common.PageVisibleAlgorithm;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import com.taobao.monitor.impl.data.calculator.ICalculatorFactory;

/* compiled from: Taobao */
public class oe implements ICalculatorFactory {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // com.taobao.monitor.impl.data.calculator.ICalculatorFactory
    public ICalculator createCalculator(String str, View view, View view2) {
        ICalculator iCalculator;
        if (!TextUtils.isEmpty(str)) {
            if (lc0.o && yn1.h(str)) {
                iCalculator = new fd2(view, view2);
                if (iCalculator == null) {
                }
            } else if (lc0.p && yn1.g(str)) {
                iCalculator = new l92(view, view2, yn1.j(str));
                if (iCalculator == null) {
                }
            } else if (lc0.q && yn1.f(str)) {
                iCalculator = new pf(view, view2);
                if (iCalculator == null) {
                    return iCalculator;
                }
                if (lc0.o && lc0.n == PageVisibleAlgorithm.SPECIFIC_VIEW_AREA) {
                    return new fd2(view, view2);
                }
                if (!lc0.p || lc0.n != PageVisibleAlgorithm.SHADOW) {
                    return (!lc0.q || lc0.n != PageVisibleAlgorithm.CANVAS) ? iCalculator : new pf(view, view2);
                }
                return new l92(view, view2, !yn1.g(str) || yn1.j(str));
            }
        }
        iCalculator = null;
        if (iCalculator == null) {
        }
    }
}
