package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.util.SmartUtil;

public class ScrollBoundaryDeciderAdapter implements ScrollBoundaryDecider {
    public ScrollBoundaryDecider boundary;
    public PointF mActionEvent;
    public boolean mEnableLoadMoreWhenContentNotFull = true;

    @Override // com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider
    public boolean canRefresh(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.boundary;
        if (scrollBoundaryDecider != null) {
            return scrollBoundaryDecider.canRefresh(view);
        }
        return SmartUtil.canRefresh(view, this.mActionEvent);
    }

    @Override // com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider
    public boolean canLoadMore(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.boundary;
        if (scrollBoundaryDecider != null) {
            return scrollBoundaryDecider.canLoadMore(view);
        }
        return SmartUtil.canLoadMore(view, this.mActionEvent, this.mEnableLoadMoreWhenContentNotFull);
    }
}
