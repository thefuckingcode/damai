package cn.damai.ticklet.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TickletTransferManagerListExtra;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.lw2;

/* compiled from: Taobao */
public class TickletTransferSuccessAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<TickletTransferManagerListExtra> a = new ArrayList();
    private Context b;

    /* compiled from: Taobao */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;
        LinearLayout d;
        LinearLayout e;
        View f;
        LinearLayout g;
        TextView h;

        public ViewHolder(TickletTransferSuccessAdapter tickletTransferSuccessAdapter, View view) {
            super(view);
        }
    }

    public TickletTransferSuccessAdapter(Activity activity, LayoutInflater layoutInflater) {
        this.b = activity;
    }

    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612588877")) {
            ipChange.ipc$dispatch("1612588877", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        TickletTransferManagerListExtra tickletTransferManagerListExtra = this.a.get(i);
        if (tickletTransferManagerListExtra != null) {
            viewHolder.itemView.setTag(Integer.valueOf(i));
            viewHolder.d.setVisibility(0);
            lw2.E(viewHolder.b, this.a.get(i).fullSeatInfo);
            lw2.E(viewHolder.c, this.a.get(i).transferCompleteTime);
            if (!TextUtils.isEmpty(this.a.get(i).recvUserMobile) || !TextUtils.isEmpty(tickletTransferManagerListExtra.recvUserNick)) {
                viewHolder.e.setVisibility(0);
                viewHolder.a.setVisibility(0);
                if (!TextUtils.isEmpty(tickletTransferManagerListExtra.recvUserMobile)) {
                    viewHolder.a.setText(tickletTransferManagerListExtra.recvUserMobile);
                } else {
                    viewHolder.a.setText(tickletTransferManagerListExtra.recvUserNick);
                }
            } else {
                viewHolder.e.setVisibility(8);
                viewHolder.a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(tickletTransferManagerListExtra.productSystemVoucherIdWithPre)) {
                lw2.D(viewHolder.g, true);
                viewHolder.h.setText(tickletTransferManagerListExtra.productSystemVoucherIdWithPre);
            } else {
                lw2.D(viewHolder.g, false);
            }
            if (i != this.a.size() - 1) {
                viewHolder.f.setVisibility(0);
            } else {
                viewHolder.f.setVisibility(4);
            }
        }
    }

    /* renamed from: b */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1347184823")) {
            return (ViewHolder) ipChange.ipc$dispatch("-1347184823", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.ticklet_transfer_running_or_success_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        viewHolder.a = (TextView) inflate.findViewById(R$id.ticklet_transfer_phone);
        TextView textView = (TextView) inflate.findViewById(R$id.ticklet_transfer_cancel);
        viewHolder.b = (TextView) inflate.findViewById(R$id.ticklet_transfer_seat_num);
        viewHolder.d = (LinearLayout) inflate.findViewById(R$id.ticklet_transfer_ll_accept_time);
        viewHolder.e = (LinearLayout) inflate.findViewById(R$id.ticklet_transfer_ll_phone);
        viewHolder.c = (TextView) inflate.findViewById(R$id.ticklet_transfer_accept_time);
        viewHolder.f = inflate.findViewById(R$id.ticklet_transfer_running_success_line);
        viewHolder.g = (LinearLayout) inflate.findViewById(R$id.ticklet_ll_transfer_tn);
        viewHolder.h = (TextView) inflate.findViewById(R$id.ticklet_transfer_tn);
        return viewHolder;
    }

    public void c(List<TickletTransferManagerListExtra> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1611819501")) {
            ipChange.ipc$dispatch("1611819501", new Object[]{this, list});
            return;
        }
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-887853744")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-887853744", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1548900140")) {
            return 0;
        }
        return ((Long) ipChange.ipc$dispatch("-1548900140", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    public TickletTransferSuccessAdapter(Context context) {
        this.b = context;
    }
}
