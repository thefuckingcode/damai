package com.alibaba.pictures.bricks.view;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface NestedListener {
    void dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr);

    void startNestedScroll();

    void stopNestedScroll();
}
