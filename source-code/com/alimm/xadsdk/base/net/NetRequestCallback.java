package com.alimm.xadsdk.base.net;

/* compiled from: Taobao */
public interface NetRequestCallback {
    void onFailed(int i, String str);

    void onSuccess(Object obj, Object obj2, String str);
}
