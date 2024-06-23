package tb;

import java.util.List;

/* compiled from: Taobao */
public class p70 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        return parser((String) list.get(0), x70.d());
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser, tb.v0
    public Object parser(String str, Object obj) {
        return str;
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser, tb.v0
    public Object parser(String str, String str2, Object obj, Object obj2) {
        return parser(str2, obj);
    }
}
