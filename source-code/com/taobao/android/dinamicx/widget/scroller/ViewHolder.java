package com.taobao.android.dinamicx.widget.scroller;

import android.util.SparseArray;
import android.view.View;
import com.taobao.android.dinamicx.widget.DXScrollerLayout;

/* compiled from: Taobao */
public class ViewHolder extends DXScrollerLayout.ScrollerAdapter.ItemViewHolder {
    private View b;

    private ViewHolder(View view) {
        super(view);
        this.b = view;
        new SparseArray();
    }

    public static ViewHolder a(View view) {
        return new ViewHolder(view);
    }
}
