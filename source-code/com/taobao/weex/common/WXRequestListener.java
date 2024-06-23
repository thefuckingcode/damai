package com.taobao.weex.common;

/* compiled from: Taobao */
public interface WXRequestListener {
    void onError(int i, Object obj, WXResponse wXResponse);

    void onSuccess(int i, Object obj, WXResponse wXResponse);
}
