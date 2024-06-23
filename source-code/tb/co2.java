package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
public class co2 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        DinamicLog.h("TripleEvaluation");
        if (list == null || list.size() != 3) {
            return Boolean.FALSE;
        }
        try {
            if (kk1.b(list.get(0).toString())) {
                return (String) list.get(1);
            }
            return (String) list.get(2);
        } catch (ClassCastException unused) {
            return Boolean.FALSE;
        }
    }
}
