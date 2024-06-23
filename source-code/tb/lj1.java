package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
public class lj1 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        DinamicLog.h("NotEvaluation");
        if (list == null) {
            return null;
        }
        if (list.size() == 1) {
            return Boolean.valueOf(!kk1.b(list.get(0).toString()));
        }
        if (list.size() == 0) {
            return Boolean.TRUE;
        }
        return null;
    }
}
