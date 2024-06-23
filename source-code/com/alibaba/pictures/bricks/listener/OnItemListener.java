package com.alibaba.pictures.bricks.listener;

import android.view.View;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface OnItemListener<T> {
    void onItemClick(T t, int i);

    void onItemExpose(@NotNull View view, T t, int i);
}
