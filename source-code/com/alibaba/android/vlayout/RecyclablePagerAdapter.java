package com.alibaba.android.vlayout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.vlayout.extend.InnerRecycledViewPool;

/* compiled from: Taobao */
public abstract class RecyclablePagerAdapter<VH extends RecyclerView.ViewHolder> extends PagerAdapter {
    private RecyclerView.Adapter<VH> a;
    private InnerRecycledViewPool b;

    public abstract int a(int i);

    public abstract void b(VH vh, int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof RecyclerView.ViewHolder) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) obj;
            viewGroup.removeView(viewHolder.itemView);
            this.b.putRecycledView(viewHolder);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.alibaba.android.vlayout.RecyclablePagerAdapter<VH extends androidx.recyclerview.widget.RecyclerView$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int a2 = a(i);
        RecyclerView.ViewHolder recycledView = this.b.getRecycledView(a2);
        if (recycledView == null) {
            recycledView = this.a.createViewHolder(viewGroup, a2);
        }
        b(recycledView, i);
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        if (recycledView.itemView.getLayoutParams() != null) {
            ((ViewGroup.LayoutParams) layoutParams).width = recycledView.itemView.getLayoutParams().width;
            ((ViewGroup.LayoutParams) layoutParams).height = recycledView.itemView.getLayoutParams().height;
        }
        viewGroup.addView(recycledView.itemView, layoutParams);
        return recycledView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof RecyclerView.ViewHolder) && ((RecyclerView.ViewHolder) obj).itemView == view;
    }
}
