package com.alient.onearch.adapter;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alient.onearch.adapter.monitor.CMSRenderMonitorPoint;
import com.alient.onearch.adapter.monitor.MonitorConstant;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class GenericVirtualLayoutManager extends VirtualLayoutManager {

    /* compiled from: Taobao */
    static class ProtectedLayoutState extends ExposeLinearLayoutManagerEx.c {
        ProtectedLayoutState() {
        }

        @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx.c
        public View next(RecyclerView.Recycler recycler) {
            try {
                return super.next(recycler);
            } catch (Exception e) {
                if (!AppInfoProviderProxy.isDebuggable()) {
                    CMSRenderMonitorPoint.Companion.commitCMSRenderMonitorFail(MonitorConstant.CMS_VIEW_HOLDER_POSITION_ERROR, "", null);
                    return null;
                }
                throw e;
            }
        }
    }

    public GenericVirtualLayoutManager(@NonNull @NotNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.VirtualLayoutManager
    public void ensureLayoutStateExpose() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new ProtectedLayoutState();
        }
        super.ensureLayoutStateExpose();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager, com.alibaba.android.vlayout.VirtualLayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                CMSRenderMonitorPoint.Companion.commitCMSRenderMonitorFail(MonitorConstant.CMS_LAYOUT_CHILDREN_ERROR, "", null);
                e.printStackTrace();
                return;
            }
            throw e;
        }
    }

    public GenericVirtualLayoutManager(@NonNull @NotNull Context context, int i) {
        super(context, i);
    }

    public GenericVirtualLayoutManager(@NonNull @NotNull Context context, int i, boolean z) {
        super(context, i, z);
    }
}
