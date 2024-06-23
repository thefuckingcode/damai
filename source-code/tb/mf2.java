package tb;

import java.util.List;

/* compiled from: Taobao */
public class mf2 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        if (list != null && list.size() == 1) {
            Object obj = list.get(0);
            if (obj instanceof String) {
                return ((String) obj).toLowerCase();
            }
        }
        return null;
    }
}
