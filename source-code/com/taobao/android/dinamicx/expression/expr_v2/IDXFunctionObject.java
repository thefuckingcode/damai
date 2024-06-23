package com.taobao.android.dinamicx.expression.expr_v2;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.ey;
import tb.iy;

/* compiled from: Taobao */
public interface IDXFunctionObject {
    ey call(DXRuntimeContext dXRuntimeContext, ey eyVar, int i, ey[] eyVarArr, String str, iy iyVar) throws DXExprFunctionError;
}
