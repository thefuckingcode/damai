package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$color;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailLineViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailProgressViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.om1;
import tb.xf2;

/* compiled from: Taobao */
public class OrderProgressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<om1> b;

    public OrderProgressAdapter(Context context, List<om1> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1834218119")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("-1834218119", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1554228128")) {
            return this.b.get(i).a;
        }
        return ((Integer) ipChange.ipc$dispatch("1554228128", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025533984")) {
            ipChange.ipc$dispatch("-1025533984", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        om1 om1 = this.b.get(i);
        if (om1 != null) {
            int i2 = om1.a;
            if (i2 == 0) {
                ((OrderDetailProgressViewHolder) viewHolder).a(om1.b, om1.c);
            } else if (i2 == 1) {
                ((OrderDetailLineViewHolder) viewHolder).a(ContextCompat.getColor(this.a, R$color.white));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165426710")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1165426710", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i == 0) {
            return new OrderDetailProgressViewHolder(viewGroup.getContext(), from);
        }
        if (i != 1) {
            return null;
        }
        return new OrderDetailLineViewHolder(viewGroup.getContext(), from, 12);
    }
}
