package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;

/* compiled from: Taobao */
public class ng2 implements IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, iy iyVar) throws DXExprFunctionError {
        ey eyVar2;
        if (i == 0) {
            throw new DXExprFunctionError("argc == 0");
        } else if (eyVar == null || !eyVar.D() || eyVar.p() == null) {
            throw new DXExprFunctionError("self is not string");
        } else if (eyVarArr == null || eyVarArr.length != i) {
            throw new DXExprFunctionError("args == null || args.length != argc");
        } else {
            ey eyVar3 = eyVarArr[0];
            if (eyVar3 == null || !eyVar3.x()) {
                throw new DXExprFunctionError("start index is not int");
            }
            String p = eyVar.p();
            long m = eyVar3.m();
            long length = (long) p.length();
            if (i == 2 && (eyVar2 = eyVarArr[1]) != null && eyVar2.x()) {
                length = eyVar2.m();
            }
            if (length <= m) {
                m = length;
                length = m;
            }
            if (m < 0) {
                m = 0;
            }
            if (m >= ((long) p.length())) {
                return ey.N("");
            }
            if (length > ((long) p.length())) {
                return ey.N(p.substring((int) m));
            }
            return ey.N(p.substring((int) m, (int) length));
        }
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "substring";
    }
}
