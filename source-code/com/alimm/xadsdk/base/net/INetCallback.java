package com.alimm.xadsdk.base.net;

/* compiled from: Taobao */
public interface INetCallback {
    void onFailed(int i, String str);

    void onSuccess(AdNetResponse adNetResponse);
}
