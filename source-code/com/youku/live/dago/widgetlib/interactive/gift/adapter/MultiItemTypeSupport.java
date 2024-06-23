package com.youku.live.dago.widgetlib.interactive.gift.adapter;

/* compiled from: Taobao */
public interface MultiItemTypeSupport<T> {
    int getItemViewType(int i, T t);

    int getLayoutId(int i, T t);

    int getViewTypeCount();
}
