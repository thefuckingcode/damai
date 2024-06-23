package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$color;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailAddressViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailDeliveryViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailGuideViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailInvoiceViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailLineViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailLogistViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailPickUpViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailPriceViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailProjectViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailShareViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailTicketNotifyViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailTicketViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailTimeViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cm1;
import tb.xf2;

/* compiled from: Taobao */
public class OrderDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<cm1> b;

    public OrderDetailAdapter(Context context, List<cm1> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "946838549")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("946838549", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1116111932")) {
            return this.b.get(i).a;
        }
        return ((Integer) ipChange.ipc$dispatch("1116111932", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403308092")) {
            ipChange.ipc$dispatch("-1403308092", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            cm1 cm1 = this.b.get(i);
            switch (cm1.a) {
                case 0:
                    ((OrderDetailLogistViewHolder) viewHolder).b(cm1.d, cm1.b);
                    return;
                case 1:
                    ((OrderDetailAddressViewHolder) viewHolder).a(cm1.s);
                    return;
                case 2:
                    ((OrderDetailPickUpViewHolder) viewHolder).b(cm1.t);
                    return;
                case 3:
                    ((OrderDetailTicketViewHolder) viewHolder).b(cm1.e);
                    return;
                case 4:
                    ((OrderDetailProjectViewHolder) viewHolder).t(cm1.b, cm1.g, cm1.i, cm1.d, cm1.j, cm1.k, cm1.m, cm1.l, cm1.n, cm1.o, cm1.p, cm1.G);
                    return;
                case 5:
                    ((OrderDetailPriceViewHolder) viewHolder).b(cm1.h, cm1.q);
                    return;
                case 6:
                    ((OrderDetailDeliveryViewHolder) viewHolder).a(cm1.r, cm1.s, cm1.u);
                    return;
                case 7:
                    ((OrderDetailTicketNotifyViewHolder) viewHolder).g(cm1.c, cm1.b, cm1.E, cm1.F);
                    return;
                case 8:
                    ((OrderDetailInvoiceViewHolder) viewHolder).b(cm1.b, cm1.c, cm1.v, cm1.w, cm1.x);
                    return;
                case 9:
                    ((OrderDetailTimeViewHolder) viewHolder).b(cm1.b, cm1.y, cm1.z, cm1.D, cm1.C, cm1.A, cm1.B);
                    return;
                case 10:
                    ((OrderDetailGuideViewHolder) viewHolder).e(cm1.c, cm1.b);
                    return;
                case 11:
                    ((OrderDetailLineViewHolder) viewHolder).a(ContextCompat.getColor(this.a, R$color.color_f8f8f8));
                    return;
                case 12:
                    ((OrderDetailShareViewHolder) viewHolder).b(cm1.f);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "210389170")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("210389170", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        switch (i) {
            case 0:
                return new OrderDetailLogistViewHolder(viewGroup.getContext(), from);
            case 1:
                return new OrderDetailAddressViewHolder(viewGroup.getContext(), from);
            case 2:
                return new OrderDetailPickUpViewHolder(viewGroup.getContext(), from);
            case 3:
                return new OrderDetailTicketViewHolder(viewGroup.getContext(), from);
            case 4:
                return new OrderDetailProjectViewHolder(viewGroup.getContext(), from);
            case 5:
                return new OrderDetailPriceViewHolder(viewGroup.getContext(), from);
            case 6:
                return new OrderDetailDeliveryViewHolder(from);
            case 7:
                return new OrderDetailTicketNotifyViewHolder(viewGroup.getContext(), from);
            case 8:
                return new OrderDetailInvoiceViewHolder(viewGroup.getContext(), from);
            case 9:
                return new OrderDetailTimeViewHolder(viewGroup.getContext(), from);
            case 10:
                return new OrderDetailGuideViewHolder(viewGroup.getContext(), from);
            case 11:
                return new OrderDetailLineViewHolder(viewGroup.getContext(), from, 12);
            case 12:
                return new OrderDetailShareViewHolder(viewGroup.getContext(), from);
            default:
                return null;
        }
    }
}
