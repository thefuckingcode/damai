package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.sy;

/* compiled from: Taobao */
public class bx extends is {
    @Override // tb.is
    public Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext, sy.a aVar, int i) {
        if (dXRuntimeContext != null && dXRuntimeContext.isOpenNewFastReturnLogic() && i == 0) {
            if (yy.d(objArr[0])) {
                return null;
            }
            aVar.a = false;
            aVar.b = 1;
        }
        if (i < 1) {
            return null;
        }
        if (i != 1) {
            aVar.a = true;
            if (i == 2) {
                return objArr[2];
            }
            return null;
        } else if (!yy.d(objArr[0])) {
            return null;
        } else {
            aVar.a = true;
            return objArr[1];
        }
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return o70.TRIPLE_PREFIX;
    }
}
