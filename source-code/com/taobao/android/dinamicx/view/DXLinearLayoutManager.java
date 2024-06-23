package com.taobao.android.dinamicx.view;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

/* compiled from: Taobao */
public class DXLinearLayoutManager extends LinearLayoutManager {
    private boolean a = true;

    public DXLinearLayoutManager(Context context) {
        super(context);
    }

    public void a(boolean z) {
        this.a = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean canScrollHorizontally() {
        return this.a && super.canScrollHorizontally();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean canScrollVertically() {
        return this.a && super.canScrollVertically();
    }

    public DXLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }
}
