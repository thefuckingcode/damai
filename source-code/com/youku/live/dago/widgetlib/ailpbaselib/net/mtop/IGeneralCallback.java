package com.youku.live.dago.widgetlib.ailpbaselib.net.mtop;

/* compiled from: Taobao */
public interface IGeneralCallback<T> {
    void onFailure(String str);

    void onSuccess(T t);
}
