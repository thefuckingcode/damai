package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
public class t11 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        DinamicLog.h("IntLessEqual");
        if (list != null && list.size() == 2) {
            try {
                if (Integer.parseInt(list.get(0).toString()) <= Integer.parseInt(list.get(1).toString())) {
                    return Boolean.TRUE;
                }
            } catch (ClassCastException unused) {
                DinamicLog.h("Integer cast error!");
                return Boolean.FALSE;
            } catch (NumberFormatException unused2) {
                DinamicLog.h("Input type  error!");
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
}
