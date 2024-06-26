package cn.damai.commonbusiness.skeleton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SkeletonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private int f;

    /* compiled from: Taobao */
    class a extends RecyclerView.ViewHolder {
        a(SkeletonAdapter skeletonAdapter, View view) {
            super(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-831714229")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("-831714229", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503009842")) {
            ipChange.ipc$dispatch("-503009842", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (this.d) {
            ShimmerLayout shimmerLayout = (ShimmerLayout) viewHolder.itemView;
            shimmerLayout.setShimmerAnimationDuration(this.e);
            shimmerLayout.setShimmerAngle(this.f);
            shimmerLayout.setShimmerColor(this.c);
            shimmerLayout.startShimmerAnimation();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1781607960")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1781607960", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (this.d) {
            return new ShimmerViewHolder(from, viewGroup, this.b);
        }
        return new a(this, from.inflate(this.b, viewGroup, false));
    }
}
