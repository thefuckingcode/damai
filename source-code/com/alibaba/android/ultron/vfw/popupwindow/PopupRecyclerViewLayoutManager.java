package com.alibaba.android.ultron.vfw.popupwindow;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

/* compiled from: Taobao */
public class PopupRecyclerViewLayoutManager extends LinearLayoutManager {
    boolean a = true;

    public PopupRecyclerViewLayoutManager(Context context) {
        super(context);
    }

    public void a(boolean z) {
        this.a = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean canScrollVertically() {
        return this.a && super.canScrollVertically();
    }
}
