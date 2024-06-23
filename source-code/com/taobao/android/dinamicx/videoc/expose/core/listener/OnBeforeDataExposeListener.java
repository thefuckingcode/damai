package com.taobao.android.dinamicx.videoc.expose.core.listener;

/* compiled from: Taobao */
public interface OnBeforeDataExposeListener<ExposeKey, ExposeData> {
    boolean onBeforeExposeData(ExposeKey exposekey, ExposeData exposedata, String str);
}
