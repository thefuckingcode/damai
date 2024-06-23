package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class ju extends a {
    public static final long DX_PARSER_CONTAINSSTR = 2778723849224680611L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr == null || objArr.length < 2) {
            return Boolean.FALSE;
        }
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        if (!(obj instanceof String) || !(obj2 instanceof String)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(((String) objArr[0]).contains((String) objArr[1]));
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "containsStr";
    }
}
