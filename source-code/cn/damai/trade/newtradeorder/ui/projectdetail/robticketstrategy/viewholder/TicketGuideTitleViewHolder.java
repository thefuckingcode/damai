package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TicketGuideTitleViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.tv_ticket_guide_title));

    public TicketGuideTitleViewHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.layout_ticket_guide_title, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149620815")) {
            ipChange.ipc$dispatch("-1149620815", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.a.setText(str);
        }
    }
}
