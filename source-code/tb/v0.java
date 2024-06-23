package tb;

import com.taobao.android.dinamic.expression.parser.DinamicDataParser;

/* compiled from: Taobao */
public abstract class v0 implements DinamicDataParser {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, Object obj) {
        return null;
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, String str2, Object obj, Object obj2) {
        return parser(str2, obj);
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, x70 x70) {
        return parser(x70.c(), str, x70.d(), x70.b());
    }
}
