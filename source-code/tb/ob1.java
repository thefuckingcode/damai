package tb;

import java.util.List;

/* compiled from: Taobao */
public class ob1 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        if (list == null || list.size() != 2) {
            return null;
        }
        Boolean valueOf = Boolean.valueOf(kk1.b(list.get(0).toString()));
        if (!(valueOf instanceof Boolean) || !valueOf.booleanValue()) {
            return null;
        }
        return list.get(1);
    }
}
