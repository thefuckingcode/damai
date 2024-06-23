package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAddressBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAudienceInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailDeliveryInfo;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.xf2;

/* compiled from: Taobao */
public class OrderDetailDeliveryViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private FlowLayout b;
    private View c;
    private RelativeLayout d;
    private TextView e;
    private View f;
    private LinearLayout g;
    private TextView h;
    private View i;
    private LinearLayout j;
    private LinearLayout k;
    private LayoutInflater l;
    private Context m;

    public OrderDetailDeliveryViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_delivery_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.l = layoutInflater;
        this.m = layoutInflater.getContext();
        b(this.itemView);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105614807")) {
            ipChange.ipc$dispatch("-105614807", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_delivery_type);
        this.b = (FlowLayout) view.findViewById(R$id.fl_delivery_tag);
        this.c = view.findViewById(R$id.line_contacts);
        this.d = (RelativeLayout) view.findViewById(R$id.ll_delivery_contacts);
        this.e = (TextView) view.findViewById(R$id.tv_delivery_user_name);
        this.f = view.findViewById(R$id.line_email);
        this.g = (LinearLayout) view.findViewById(R$id.ll_delivery_email);
        this.h = (TextView) view.findViewById(R$id.tv_delivery_email);
        this.i = view.findViewById(R$id.ll_contacts_line);
        this.j = (LinearLayout) view.findViewById(R$id.ll_contacts_container);
        this.k = (LinearLayout) view.findViewById(R$id.ll_order_contacts);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
    }

    private void c(List<OrderDetailAudienceInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228919909")) {
            ipChange.ipc$dispatch("-1228919909", new Object[]{this, list});
            return;
        }
        int e2 = xf2.e(list);
        if (e2 == 0) {
            this.j.setVisibility(8);
            this.i.setVisibility(8);
            return;
        }
        this.k.removeAllViews();
        int i2 = 0;
        while (i2 < e2) {
            View inflate = this.l.inflate(R$layout.order_detail_audience_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_audience_name)).setText(list.get(i2).name);
            if (!TextUtils.isEmpty(list.get(i2).hashIdentityNumber)) {
                ((TextView) inflate.findViewById(R$id.tv_audience_type)).setText(list.get(i2).typeName + AltriaXLaunchTime.SPACE + list.get(i2).hashIdentityNumber);
            } else {
                ((TextView) inflate.findViewById(R$id.tv_audience_type)).setText(list.get(i2).typeName);
            }
            inflate.findViewById(R$id.line).setVisibility(i2 != e2 + -1 ? 0 : 8);
            this.k.addView(inflate);
            i2++;
        }
        this.i.setVisibility(0);
        this.j.setVisibility(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    private void d(OrderDetailAddressBean orderDetailAddressBean, int i2) {
        char c2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2089253663")) {
            ipChange.ipc$dispatch("-2089253663", new Object[]{this, orderDetailAddressBean, Integer.valueOf(i2)});
        } else if (orderDetailAddressBean != null) {
            if (i2 == 1) {
                this.d.setVisibility(8);
            } else if (!TextUtils.isEmpty(orderDetailAddressBean.userName) || !TextUtils.isEmpty(orderDetailAddressBean.mobilePhone)) {
                TextView textView = this.e;
                textView.setText(orderDetailAddressBean.userName + AltriaXLaunchTime.SPACE + orderDetailAddressBean.mobilePhone);
                this.d.setVisibility(0);
                c2 = 1;
                if (TextUtils.isEmpty(orderDetailAddressBean.email)) {
                    this.h.setText(orderDetailAddressBean.email);
                    this.g.setVisibility(0);
                    c2 = 2;
                } else {
                    this.g.setVisibility(8);
                }
                if (c2 != 0) {
                    this.c.setVisibility(8);
                    this.f.setVisibility(8);
                    return;
                } else if (c2 == 1) {
                    this.c.setVisibility(0);
                    this.f.setVisibility(8);
                    return;
                } else if (c2 == 2) {
                    this.c.setVisibility(0);
                    this.f.setVisibility(0);
                    return;
                } else {
                    return;
                }
            } else {
                this.d.setVisibility(8);
            }
            c2 = 0;
            if (TextUtils.isEmpty(orderDetailAddressBean.email)) {
            }
            if (c2 != 0) {
            }
        }
    }

    public void a(OrderDetailDeliveryInfo orderDetailDeliveryInfo, OrderDetailAddressBean orderDetailAddressBean, List<OrderDetailAudienceInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959846948")) {
            ipChange.ipc$dispatch("1959846948", new Object[]{this, orderDetailDeliveryInfo, orderDetailAddressBean, list});
        } else if (orderDetailDeliveryInfo != null) {
            this.a.setText(orderDetailDeliveryInfo.deliveryMethod);
            int e2 = xf2.e(orderDetailDeliveryInfo.tags);
            if (e2 > 0) {
                this.b.removeAllViews();
                for (int i2 = 0; i2 < e2; i2++) {
                    TextView textView = (TextView) LayoutInflater.from(this.m).inflate(R$layout.layout_order_detail_tag, (ViewGroup) null);
                    textView.setText(orderDetailDeliveryInfo.tags.get(i2));
                    this.b.addView(textView);
                }
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
            d(orderDetailAddressBean, orderDetailDeliveryInfo.deliveryId);
            c(list);
        }
    }
}
