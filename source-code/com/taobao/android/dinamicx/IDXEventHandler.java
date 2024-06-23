package com.taobao.android.dinamicx;

import tb.lx;

/* compiled from: Taobao */
public interface IDXEventHandler {
    void handleEvent(lx lxVar, Object[] objArr, DXRuntimeContext dXRuntimeContext);

    void prepareBindEventWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext);
}
