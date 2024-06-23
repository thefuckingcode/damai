package tb;

import java.util.List;

/* compiled from: Taobao */
public class si0 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        Object[] objArr;
        if (list != null && list.size() == 2) {
            Object obj = list.get(0);
            Object obj2 = list.get(1);
            try {
                if (obj instanceof List) {
                    objArr = ((List) obj).toArray();
                } else {
                    objArr = (Object[]) obj;
                }
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i].equals(obj2)) {
                        return objArr[i];
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
