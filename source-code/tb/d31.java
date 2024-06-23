package tb;

import com.alibaba.fastjson.JSON;
import com.taobao.analysis.StageType;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject;

/* compiled from: Taobao */
public class d31 implements IDXFunctionObject {
    private ey b(ey eyVar) throws DXExprFunctionError {
        if (eyVar != null && eyVar.B() && eyVar.o() != null) {
            return ey.N(eyVar.o().toJSONString());
        }
        throw new DXExprFunctionError("args[0] not object");
    }

    public ey a(ey eyVar) throws DXExprFunctionError {
        if (eyVar != null && eyVar.D()) {
            return ey.M(JSON.parseObject(eyVar.p()));
        }
        throw new DXExprFunctionError("args[0] not string");
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject
    public ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, String str, iy iyVar) throws DXExprFunctionError {
        if (i == 0) {
            throw new DXExprFunctionError("argc == 0");
        } else if (eyVarArr == null || eyVarArr.length != i) {
            throw new DXExprFunctionError("args == null || args.length != argc");
        } else {
            ey eyVar2 = eyVarArr[0];
            str.hashCode();
            if (str.equals("stringify")) {
                return b(eyVar2);
            }
            if (str.equals(StageType.PARSE)) {
                return a(eyVar2);
            }
            throw new DXExprFunctionError("can not find function on JSON:" + str);
        }
    }
}
