package com.taobao.android.dinamicx.expression.expr_v2;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.ey;
import tb.lx;

/* compiled from: Taobao */
public interface DXJSMethodProxy {
    void call(DXRuntimeContext dXRuntimeContext, lx lxVar, String str, String str2, int i, ey[] eyVarArr);

    boolean isValid();
}
