package com.taobao.uikit.feature.callback;

/* compiled from: Taobao */
public interface ScrollCallback {
    void afterComputeScroll();

    void afterOnScrollChanged(int i, int i2, int i3, int i4);

    void beforeComputeScroll();

    void beforeOnScrollChanged(int i, int i2, int i3, int i4);
}
