package com.taobao.android.dinamicx.asyncrender;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
public interface DXAsyncRenderCallback<T> {
    void onRenderFailed(DXRuntimeContext dXRuntimeContext, Throwable th);

    void onRenderSuccess(T t);
}
