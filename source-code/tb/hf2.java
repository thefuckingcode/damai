package tb;

import java.util.List;

/* compiled from: Taobao */
public class hf2 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        if (list != null) {
            if (list.size() > 1) {
                int size = list.size();
                Object obj = list.get(0);
                if (obj != null && (obj instanceof String)) {
                    for (int i = 1; i < size; i++) {
                        Object obj2 = list.get(i);
                        if (obj2 != null && (obj2 instanceof String)) {
                            obj = obj.toString().concat(obj2.toString());
                        }
                    }
                    return obj.toString();
                }
            }
        }
        return null;
    }
}
