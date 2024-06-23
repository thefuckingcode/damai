package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAddressBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
public class OrderDetailAddressViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a = ((LinearLayout) this.itemView.findViewById(R$id.address_container));
    private TextView b = ((TextView) this.itemView.findViewById(R$id.tv_contacts_name));
    private TextView c = ((TextView) this.itemView.findViewById(R$id.tv_address_full));
    private Context d;

    public OrderDetailAddressViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_address_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.d = context;
    }

    public void a(OrderDetailAddressBean orderDetailAddressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301047072")) {
            ipChange.ipc$dispatch("-1301047072", new Object[]{this, orderDetailAddressBean});
        } else if (orderDetailAddressBean != null) {
            this.a.setBackgroundColor(ContextCompat.getColor(this.d, R$color.white));
            this.c.setText(orderDetailAddressBean.fullAddress);
            TextView textView = this.b;
            textView.setText(orderDetailAddressBean.userName + AltriaXLaunchTime.SPACE + orderDetailAddressBean.mobilePhone);
        }
    }
}
