package com.taobao.android.dinamicx;

import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import tb.ey;
import tb.iy;

/* compiled from: Taobao */
public abstract class a implements IDXEventHandler, IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, iy iyVar) throws DXExprFunctionError {
        if (i >= 0) {
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = ey.P(eyVarArr[i2]);
            }
            if (iyVar.a() == null || !iyVar.a().c()) {
                handleEvent(iyVar.a(), objArr, dXRuntimeContext);
            } else {
                prepareBindEventWithArgs(objArr, dXRuntimeContext);
            }
            return ey.d(null);
        }
        if (iyVar.a() == null || !iyVar.a().c()) {
            handleEvent(iyVar.a(), null, dXRuntimeContext);
        } else {
            prepareBindEventWithArgs(null, dXRuntimeContext);
        }
        return ey.L();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return null;
    }

    @Override // com.taobao.android.dinamicx.IDXEventHandler
    public void prepareBindEventWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
    }
}
