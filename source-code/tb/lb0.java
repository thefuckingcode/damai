package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
public class lb0 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        DinamicLog.h("IntGreater");
        if (list != null && list.size() == 2) {
            try {
                double parseDouble = Double.parseDouble(list.get(0).toString()) - Double.parseDouble(list.get(1).toString());
                if (1.0E-9d <= parseDouble || Math.abs(parseDouble) < 1.0E-9d) {
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
