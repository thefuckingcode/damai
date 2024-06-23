package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
public class bo2 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        DinamicLog.h("TrimEvaluation");
        if (list == null || list.size() != 1) {
            return null;
        }
        try {
            String valueOf = String.valueOf(list.get(0));
            if (valueOf.length() != 0) {
                return valueOf.trim();
            }
            return null;
        } catch (ClassCastException unused) {
            DinamicLog.h("String cast error!");
            return null;
        }
    }
}
