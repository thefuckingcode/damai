package cn.damai.tetris.component.drama.viewholder;

import android.view.View;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface OnItemBindListener<T> extends OnItemClickListener<T> {
    void exposeItem(@Nullable View view, T t, int i);
}
