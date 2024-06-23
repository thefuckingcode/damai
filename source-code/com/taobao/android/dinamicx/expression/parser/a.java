package com.taobao.android.dinamicx.expression.parser;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import tb.bv;
import tb.ey;
import tb.iy;

/* compiled from: Taobao */
public abstract class a implements IDXFunction, IDXDataParser {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, iy iyVar) throws DXExprFunctionError {
        Object obj;
        Object obj2;
        if (i >= 0) {
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = ey.P(eyVarArr[i2]);
            }
            if (this instanceof bv) {
                obj2 = ((bv) this).e(iyVar.a(), objArr, dXRuntimeContext);
            } else {
                obj2 = evalWithArgs(objArr, dXRuntimeContext);
            }
            return ey.d(obj2);
        }
        if (this instanceof bv) {
            obj = ((bv) this).e(iyVar.a(), null, dXRuntimeContext);
        } else {
            obj = evalWithArgs(null, dXRuntimeContext);
        }
        return ey.d(obj);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return null;
    }
}
