package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.sy;

/* compiled from: Taobao */
public class hw extends is {
    @Override // tb.is
    public Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext, sy.a aVar, int i) {
        if (!yy.d(objArr[i])) {
            return Boolean.FALSE;
        }
        aVar.a = true;
        return Boolean.TRUE;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return o70.OR_PREFIX;
    }
}
