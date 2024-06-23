package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;

/* compiled from: Taobao */
public class ko1 implements IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, iy iyVar) throws DXExprFunctionError {
        String str;
        if (i == 0) {
            throw new DXExprFunctionError("argc == 0");
        } else if (eyVarArr == null || eyVarArr.length != i) {
            throw new DXExprFunctionError("args == null || args.length != argc");
        } else {
            ey eyVar2 = eyVarArr[0];
            if (eyVar2 == null || (!eyVar2.D() && !eyVar2.A())) {
                throw new DXExprFunctionError("args[0] not string or number");
            }
            if (eyVar2.D()) {
                str = eyVar2.p();
            } else {
                str = String.valueOf(eyVar2.b());
            }
            return ey.H(Double.parseDouble(str));
        }
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "parseFloat";
    }
}
