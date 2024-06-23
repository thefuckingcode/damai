package tb;

import java.math.BigDecimal;
import java.util.List;

/* compiled from: Taobao */
public class de0 extends v0 {
    /* access modifiers changed from: protected */
    public boolean a(Object obj, Object obj2) {
        if ((obj instanceof BigDecimal) || (obj2 instanceof BigDecimal)) {
            if (kk1.c(obj).compareTo(kk1.c(obj2)) == 0) {
                return true;
            }
            return false;
        } else if (kk1.a(obj) || kk1.a(obj2)) {
            if (kk1.d(obj) == kk1.d(obj2)) {
                return true;
            }
            return false;
        } else if (kk1.f(obj) == kk1.f(obj2)) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        if (list == null || list.size() != 2) {
            return null;
        }
        Object obj = list.get(0);
        Object obj2 = list.get(1);
        if (obj == null && obj2 == null) {
            return Boolean.TRUE;
        }
        if (obj == null || obj2 == null) {
            return Boolean.FALSE;
        }
        if (obj.getClass().equals(obj2.getClass())) {
            return Boolean.valueOf(obj.equals(obj2));
        }
        if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
            return Boolean.valueOf(obj.equals(obj2));
        }
        return Boolean.valueOf(a(obj, obj2));
    }
}
