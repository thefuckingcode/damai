package com.taobao.android.dinamicx.widget.recycler;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: Taobao */
public class ScrollStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    private WaterfallLayout a;

    public ScrollStaggeredGridLayoutManager(int i, int i2, WaterfallLayout waterfallLayout) {
        super(i, i2);
        this.a = waterfallLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.StaggeredGridLayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
            WaterfallLayout waterfallLayout = this.a;
            if (waterfallLayout != null) {
                if (scrollVerticallyBy == 0) {
                    if (i > 0) {
                        waterfallLayout.n(true);
                    } else if (i < 0) {
                        waterfallLayout.o(true);
                    }
                } else if (i != 0) {
                    waterfallLayout.n(false);
                    this.a.o(false);
                }
            }
            return scrollVerticallyBy;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }
}
