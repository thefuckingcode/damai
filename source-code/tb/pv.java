package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.sy;

/* compiled from: Taobao */
public class pv extends is {
    @Override // tb.is
    public Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext, sy.a aVar, int i) {
        if (i == 0) {
            aVar.a = !yy.d(objArr[0]);
            return null;
        }
        aVar.a = true;
        if (i == 1) {
            return objArr[1];
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return o70.MATCH_PREFIX;
    }
}
