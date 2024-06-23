package com.alibaba.android.vlayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* compiled from: Taobao */
public abstract class VirtualLayoutAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    @NonNull
    protected VirtualLayoutManager mLayoutManager;

    public VirtualLayoutAdapter(@NonNull VirtualLayoutManager virtualLayoutManager) {
        this.mLayoutManager = virtualLayoutManager;
    }

    @NonNull
    public List<a> getLayoutHelpers() {
        return this.mLayoutManager.getLayoutHelpers();
    }

    public void setLayoutHelpers(List<a> list) {
        this.mLayoutManager.setLayoutHelpers(list);
    }
}
