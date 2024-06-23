package com.alibaba.pictures.bricks.component.home.feed;

import android.view.View;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface OnItemBindListener<T> extends OnItemClickListener<T> {
    void exposeItem(@Nullable View view, T t, int i);
}
