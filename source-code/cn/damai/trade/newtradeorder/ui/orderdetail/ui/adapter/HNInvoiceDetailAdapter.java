package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceDataHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.HNInvoiceDetailDeliveryViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.HNInvoiceDetailLogisticsViewHolder;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.HNInvoiceDetailViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class HNInvoiceDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<HNInvoiceDataHolder> b;

    public HNInvoiceDetailAdapter(Context context, List<HNInvoiceDataHolder> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "603169116")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("603169116", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "375950851")) {
            return this.b.get(i).mType;
        }
        return ((Integer) ipChange.ipc$dispatch("375950851", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2086500893")) {
            ipChange.ipc$dispatch("2086500893", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            HNInvoiceDataHolder hNInvoiceDataHolder = this.b.get(i);
            int i2 = hNInvoiceDataHolder.mType;
            if (i2 == 0) {
                ((HNInvoiceDetailViewHolder) viewHolder).a(hNInvoiceDataHolder.invoicesDetail);
            } else if (i2 == 1) {
                ((HNInvoiceDetailDeliveryViewHolder) viewHolder).a(hNInvoiceDataHolder.expressNo, hNInvoiceDataHolder.expressName, hNInvoiceDataHolder.status);
            } else if (i2 == 2) {
                ((HNInvoiceDetailLogisticsViewHolder) viewHolder).a(hNInvoiceDataHolder.mTransInfo, hNInvoiceDataHolder.mTransFirst, hNInvoiceDataHolder.mTransEnd);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1899746183")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1899746183", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i == 0) {
            return new HNInvoiceDetailViewHolder(from);
        }
        if (i == 1) {
            return new HNInvoiceDetailDeliveryViewHolder(from);
        }
        if (i != 2) {
            return null;
        }
        return new HNInvoiceDetailLogisticsViewHolder(this.a, from);
    }
}
