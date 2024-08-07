package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class e71 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        DinamicLog.h("LengthEvaluation");
        if (list == null || list.size() != 1) {
            return null;
        }
        Object obj = list.get(0);
        try {
            if (obj instanceof String) {
                return String.valueOf(((String) obj).length());
            }
            if (obj instanceof Object[]) {
                return String.valueOf(((Object[]) obj).length);
            }
            if (obj instanceof Map) {
                return String.valueOf(((Map) obj).size());
            }
            if (obj instanceof List) {
                return String.valueOf(((List) obj).size());
            }
            return null;
        } catch (ClassCastException unused) {
            DinamicLog.h("String cast error!");
            return null;
        }
    }
}
