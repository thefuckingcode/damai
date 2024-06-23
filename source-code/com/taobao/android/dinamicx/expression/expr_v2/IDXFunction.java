package com.taobao.android.dinamicx.expression.expr_v2;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.ey;
import tb.iy;

/* compiled from: Taobao */
public interface IDXFunction {
    ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, iy iyVar) throws DXExprFunctionError;

    String getDxFunctionName();
}
