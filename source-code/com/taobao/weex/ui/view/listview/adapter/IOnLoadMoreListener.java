package com.taobao.weex.ui.view.listview.adapter;

/* compiled from: Taobao */
public interface IOnLoadMoreListener {
    void notifyAppearStateChange(int i, int i2, int i3, int i4);

    void onBeforeScroll(int i, int i2);

    void onLoadMore(int i);
}
