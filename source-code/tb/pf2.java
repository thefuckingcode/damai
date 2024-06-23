package tb;

import java.util.List;

/* compiled from: Taobao */
public class pf2 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        String str = null;
        if (list == null) {
            return null;
        }
        int i = 0;
        if (list.size() == 3) {
            Object obj = list.get(0);
            int e = kk1.e(list.get(1));
            int e2 = kk1.e(list.get(2));
            String valueOf = String.valueOf(obj);
            if (e2 < 0 || e + 1 > valueOf.length()) {
                return "";
            }
            if (e >= 0) {
                i = e;
            }
            int i2 = e2 + i;
            if (i2 > obj.toString().length()) {
                str = valueOf.substring(i);
            }
            if (i2 - 1 < obj.toString().length()) {
                return ((String) obj).substring(i, i2);
            }
            return str;
        } else if (list.size() != 2) {
            return null;
        } else {
            Object obj2 = list.get(0);
            int e3 = kk1.e(list.get(1));
            String valueOf2 = String.valueOf(obj2);
            if (e3 + 1 > valueOf2.length()) {
                return "";
            }
            if (e3 >= 0) {
                i = e3;
            }
            return valueOf2.substring(i);
        }
    }
}
