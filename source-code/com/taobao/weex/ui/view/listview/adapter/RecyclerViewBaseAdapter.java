package com.taobao.weex.ui.view.listview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder;

/* compiled from: Taobao */
public class RecyclerViewBaseAdapter<T extends ListBaseViewHolder> extends RecyclerView.Adapter<T> {
    private IRecyclerAdapterListener iRecyclerAdapterListener;

    public RecyclerViewBaseAdapter(IRecyclerAdapterListener iRecyclerAdapterListener2) {
        this.iRecyclerAdapterListener = iRecyclerAdapterListener2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IRecyclerAdapterListener iRecyclerAdapterListener2 = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener2 != null) {
            return iRecyclerAdapterListener2.getItemCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.iRecyclerAdapterListener.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IRecyclerAdapterListener iRecyclerAdapterListener2 = this.iRecyclerAdapterListener;
        return iRecyclerAdapterListener2 != null ? iRecyclerAdapterListener2.getItemViewType(i) : i;
    }

    public void onBindViewHolder(T t, int i) {
        IRecyclerAdapterListener iRecyclerAdapterListener2 = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener2 != null) {
            iRecyclerAdapterListener2.onBindViewHolder(t, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        IRecyclerAdapterListener iRecyclerAdapterListener2 = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener2 != null) {
            return (T) ((ListBaseViewHolder) iRecyclerAdapterListener2.onCreateViewHolder(viewGroup, i));
        }
        return null;
    }

    public boolean onFailedToRecycleView(T t) {
        IRecyclerAdapterListener iRecyclerAdapterListener2 = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener2 != null) {
            return iRecyclerAdapterListener2.onFailedToRecycleView(t);
        }
        return super.onFailedToRecycleView((RecyclerView.ViewHolder) t);
    }

    public void onViewAttachedToWindow(T t) {
        ViewGroup.LayoutParams layoutParams;
        super.onViewAttachedToWindow((RecyclerView.ViewHolder) t);
        if (t != null && t.isFullSpan() && (layoutParams = t.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void onViewDetachedFromWindow(T t) {
        super.onViewDetachedFromWindow((RecyclerView.ViewHolder) t);
        if (t != null) {
            t.setComponentUsing(false);
        }
    }

    public void onViewRecycled(T t) {
        IRecyclerAdapterListener iRecyclerAdapterListener2 = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener2 != null) {
            iRecyclerAdapterListener2.onViewRecycled(t);
        }
        super.onViewRecycled((RecyclerView.ViewHolder) t);
    }
}
