package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;

/* compiled from: Taobao */
public class lo1 implements IDXFunction {
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
            int i2 = 10;
            if (eyVar2.D()) {
                str = eyVar2.p();
                if (str.startsWith("0x") || str.startsWith("0X")) {
                    i2 = 16;
                }
            } else {
                str = String.valueOf((long) Math.floor(eyVar2.b()));
            }
            if (i == 2) {
                ey eyVar3 = eyVarArr[1];
                if (eyVar3 == null || !eyVar3.x()) {
                    throw new DXExprFunctionError("args[1] not int");
                }
                i2 = (int) eyVar3.m();
            }
            return ey.J(Long.parseLong(str, i2));
        }
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "parseInt";
    }
}
