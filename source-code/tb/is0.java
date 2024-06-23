package tb;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class is0 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        Object[] objArr;
        if (list != null && list.size() == 2) {
            Object obj = list.get(0);
            if (obj instanceof Map) {
                return ((Map) obj).get(list.get(1));
            }
            try {
                int e = kk1.e(list.get(1));
                if (obj instanceof List) {
                    objArr = ((List) obj).toArray();
                } else {
                    objArr = (Object[]) obj;
                }
                if (e < objArr.length) {
                    return objArr[e];
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
