package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
public class s11 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        DinamicLog.h("IntLess");
        if (list != null && list.size() == 2) {
            try {
                if (Integer.parseInt(list.get(0).toString()) < Integer.parseInt(list.get(1).toString())) {
                    return Boolean.TRUE;
                }
            } catch (NumberFormatException unused) {
                DinamicLog.h("Integer cast error!");
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
}
