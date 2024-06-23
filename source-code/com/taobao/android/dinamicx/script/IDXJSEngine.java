package com.taobao.android.dinamicx.script;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.ey;

/* compiled from: Taobao */
public interface IDXJSEngine {
    int decode(DXRuntimeContext dXRuntimeContext, byte[] bArr);

    void destroy();

    void destroy(int i);

    void dispatchEvent(int i, String str, JSONObject jSONObject);

    void run(int i, DXRuntimeContext dXRuntimeContext, String str, String str2, int i2, ey[] eyVarArr);
}
