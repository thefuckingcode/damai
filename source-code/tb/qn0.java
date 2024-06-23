package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject;

/* compiled from: Taobao */
public class qn0 implements IDXFunction {
    private String a;
    private IDXFunctionObject b;

    public qn0(IDXFunctionObject iDXFunctionObject, String str) {
        this.a = str;
        this.b = iDXFunctionObject;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, iy iyVar) throws DXExprFunctionError {
        return this.b.call(dXRuntimeContext, eyVar, i, eyVarArr, this.a, iyVar);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return this.a;
    }
}
