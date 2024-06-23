package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;

/* compiled from: Taobao */
public class OrderDetailLineViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a = ((LinearLayout) this.itemView.findViewById(R$id.line));

    public OrderDetailLineViewHolder(Context context, LayoutInflater layoutInflater, int i) {
        super(layoutInflater.inflate(R$layout.order_detail_line_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, n42.a(context, (float) i)));
    }

    public void a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1384214168")) {
            ipChange.ipc$dispatch("1384214168", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a.setBackgroundColor(i);
    }
}
