package tb;

import java.util.List;

/* compiled from: Taobao */
public class xc0 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        if (list == null || list.size() != 1) {
            return null;
        }
        return list.get(0);
    }
}
