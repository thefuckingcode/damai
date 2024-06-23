package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
public class nb0 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        DinamicLog.h("DoubleLess");
        if (list != null && list.size() == 2) {
            try {
                if (Double.parseDouble(list.get(1).toString()) - Double.parseDouble(list.get(0).toString()) >= 1.0E-9d) {
                    return Boolean.TRUE;
                }
            } catch (NumberFormatException unused) {
                DinamicLog.h("double cast error!");
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
}
