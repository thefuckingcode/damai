package tb;

import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;

/* compiled from: Taobao */
public class u7 implements IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, iy iyVar) throws DXExprFunctionError {
        ey eyVar2;
        if (i == 0) {
            throw new DXExprFunctionError("argc == 0");
        } else if (eyVar == null || !eyVar.t() || eyVar.h() == null) {
            throw new DXExprFunctionError("self is not array");
        } else if (eyVarArr == null || eyVarArr.length != i) {
            throw new DXExprFunctionError("args == null || args.length != argc");
        } else {
            ey eyVar3 = eyVarArr[0];
            if (eyVar3 == null || !eyVar3.x()) {
                throw new DXExprFunctionError("start index is not int");
            }
            JSONArray h = eyVar.h();
            long m = eyVar3.m();
            if (m >= ((long) h.size()) || m < 0) {
                return ey.E(new JSONArray());
            }
            long size = (long) h.size();
            if (i == 2 && (eyVar2 = eyVarArr[1]) != null && eyVar2.x()) {
                size = eyVar2.m();
            }
            if (size <= m) {
                return ey.E(new JSONArray());
            }
            if (size > ((long) h.size())) {
                return ey.E(new JSONArray(h.subList((int) m, h.size())));
            }
            return ey.E(new JSONArray(h.subList((int) m, (int) size)));
        }
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "slice";
    }
}
