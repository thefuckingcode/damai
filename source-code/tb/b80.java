package tb;

import android.text.TextUtils;
import com.taobao.android.dinamic.expression.parser.resolver.e;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: Taobao */
public class b80 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        return parser((String) list.get(0), x70.a());
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser, tb.v0
    public Object parser(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return obj;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " .[]", false);
        while (stringTokenizer.hasMoreTokens()) {
            obj = e.a(obj, stringTokenizer.nextToken());
        }
        return obj;
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser, tb.v0
    public Object parser(String str, String str2, Object obj, Object obj2) {
        return parser(str2, obj);
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser, tb.v0
    public Object parser(String str, x70 x70) {
        return parser(x70.c(), str, x70.a(), x70.b());
    }
}
