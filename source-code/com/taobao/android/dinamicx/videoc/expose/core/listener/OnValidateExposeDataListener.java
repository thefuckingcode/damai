package com.taobao.android.dinamicx.videoc.expose.core.listener;

import java.util.Map;

/* compiled from: Taobao */
public interface OnValidateExposeDataListener<ExposeKey, ExposeData> {
    boolean onValidateExposeData(ExposeKey exposekey, ExposeData exposedata, String str, Map<ExposeKey, ExposeData> map);
}
