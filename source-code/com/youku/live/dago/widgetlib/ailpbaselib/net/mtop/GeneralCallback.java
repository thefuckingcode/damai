package com.youku.live.dago.widgetlib.ailpbaselib.net.mtop;

/* compiled from: Taobao */
public abstract class GeneralCallback<T> implements IGeneralCallback<T> {
    @Override // com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.IGeneralCallback
    public abstract void onFailure(String str);

    @Override // com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.IGeneralCallback
    public abstract void onSuccess(T t);
}
