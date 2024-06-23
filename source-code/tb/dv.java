package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class dv extends a {
    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr == null || objArr.length != 2) {
            return null;
        }
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        if (obj == null && obj2 == null) {
            return Boolean.TRUE;
        }
        if (obj == null || obj2 == null) {
            return Boolean.FALSE;
        }
        if (obj.getClass().equals(obj2.getClass())) {
            return Boolean.valueOf(obj.equals(obj2));
        }
        if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
            return Boolean.valueOf(obj.equals(obj2));
        }
        return Boolean.valueOf(yy.a((Number) obj, (Number) obj2));
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "equal";
    }
}
