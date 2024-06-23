package cn.damai.ticklet.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ticklet.inteface.TickletTransferCallback;
import cn.damai.ticklet.ui.activity.TickletTransferManageActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.nn2;
import tb.xf2;

/* compiled from: Taobao */
public class TickletManageAdapter extends RecyclerView.Adapter<ViewHolder> implements TickletTransferCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletTransferManageActivity a;
    private LayoutInflater b;
    private List<nn2> c = new ArrayList();
    private TickletTransferCallback d;
    public List<ViewHolder> e = new ArrayList();

    public TickletManageAdapter(TickletTransferManageActivity tickletTransferManageActivity) {
        this.a = tickletTransferManageActivity;
        this.b = LayoutInflater.from(tickletTransferManageActivity);
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653221269")) {
            ipChange.ipc$dispatch("-1653221269", new Object[]{this});
            return;
        }
        notifyDataSetChanged();
        List<ViewHolder> list = this.e;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.e.size(); i++) {
                if (this.e.get(i) instanceof TickletTransferManagerViewHolder) {
                    ((TickletTransferManagerViewHolder) this.e.get(i)).b();
                }
            }
        }
    }

    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289777656")) {
            ipChange.ipc$dispatch("289777656", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        List<ViewHolder> list = this.e;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                if (this.e.get(i2) instanceof TickletTransferManagerViewHolder) {
                    ((TickletTransferManagerViewHolder) this.e.get(i2)).c(i);
                }
            }
        }
    }

    /* renamed from: c */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2125028751")) {
            ipChange.ipc$dispatch("-2125028751", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        nn2 nn2 = this.c.get(i);
        if (nn2 != null && viewHolder != null) {
            int f = nn2.f();
            if (f == 0 || f == 1 || f == 2) {
                ((TickletTransferManagerViewHolder) viewHolder).a(nn2, nn2.f());
            } else if (f == 4) {
                ((TickletTransferTipsViewHolder) viewHolder).b(nn2);
            }
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTransferCallback
    public void callCancelTransfer(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076413130")) {
            ipChange.ipc$dispatch("-2076413130", new Object[]{this, str, Integer.valueOf(i), str2});
            return;
        }
        this.d.callCancelTransfer(str, i, str2);
    }

    @Override // cn.damai.ticklet.inteface.TickletTransferCallback
    public void chooseUpdateView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053462024")) {
            ipChange.ipc$dispatch("-1053462024", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d.chooseUpdateView(i);
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927440717")) {
            ipChange.ipc$dispatch("927440717", new Object[]{this});
        } else if (xf2.e(this.c) > 0) {
            this.c.clear();
            notifyDataSetChanged();
        }
    }

    /* renamed from: d */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826537765")) {
            return (ViewHolder) ipChange.ipc$dispatch("1826537765", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        ViewHolder viewHolder = null;
        if (i == 0 || i == 1 || i == 2) {
            viewHolder = new TickletTransferManagerViewHolder(this.a, this, this.b, i);
        } else if (i == 3) {
            viewHolder = new TransferDividerViewHolder(this.a, this.b);
        } else if (i == 4) {
            viewHolder = new TickletTransferTipsViewHolder(this.a, this.b);
        } else if (i == 5) {
            viewHolder = new TickletTransferLimitViewHolder(this.a, viewGroup, this.b);
        }
        if (!this.e.contains(viewHolder)) {
            this.e.add(viewHolder);
        }
        return viewHolder;
    }

    public void e(TickletTransferCallback tickletTransferCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764715920")) {
            ipChange.ipc$dispatch("764715920", new Object[]{this, tickletTransferCallback});
            return;
        }
        this.d = tickletTransferCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1185699395")) {
            return this.c.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1185699395", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1910210020")) {
            return this.c.get(i).f();
        }
        return ((Integer) ipChange.ipc$dispatch("1910210020", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    public void setData(List<nn2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471430721")) {
            ipChange.ipc$dispatch("-471430721", new Object[]{this, list});
            return;
        }
        this.c = list;
        notifyDataSetChanged();
    }
}
