package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class qw extends a {
    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        String str = null;
        if (objArr == null || objArr.length > 3 || objArr.length < 2) {
            return null;
        }
        int i = 0;
        Object obj = objArr[0];
        if (!(obj instanceof String)) {
            return null;
        }
        String str2 = (String) obj;
        Object obj2 = objArr[1];
        if (!(obj2 instanceof String)) {
            return null;
        }
        int f = yy.f((String) obj2);
        if (objArr.length == 3) {
            Object obj3 = objArr[2];
            if (!(obj3 instanceof String)) {
                return null;
            }
            int f2 = yy.f((String) obj3);
            if (f2 < 0 || f + 1 > str2.length()) {
                return "";
            }
            if (f >= 0) {
                i = f;
            }
            int i2 = f2 + i;
            if (i2 > str2.length()) {
                str = str2.substring(i);
            }
            if (i2 - 1 < str2.length()) {
                return str2.substring(i, i2);
            }
            return str;
        } else if (f + 1 > str2.length()) {
            return "";
        } else {
            if (f >= 0) {
                i = f;
            }
            return str2.substring(i);
        }
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return o70.SUBSTR_PREFIX;
    }
}
