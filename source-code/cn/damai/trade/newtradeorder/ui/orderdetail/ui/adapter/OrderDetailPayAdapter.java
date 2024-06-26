package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.user.c;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.model.OrderDetailPayViewModel;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.d20;
import tb.ln2;
import tb.xf2;
import tb.zq;

/* compiled from: Taobao */
public class OrderDetailPayAdapter extends RecyclerView.Adapter<PayViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<OrderDetailPayInfo> a;
    private Context b;
    private OrderDetailPayViewModel c;
    private String d;
    private View.OnClickListener e = new a();
    DMIconFontTextView f;
    OrderDetailPayInfo g;

    /* compiled from: Taobao */
    public class PayViewHolder extends RecyclerView.ViewHolder {
        private View a;
        private ImageView b;
        private TextView c;
        private TextView d;
        private DMIconFontTextView e;

        public PayViewHolder(OrderDetailPayAdapter orderDetailPayAdapter, View view) {
            super(view);
            this.a = view;
            this.b = (ImageView) view.findViewById(R$id.iv_pay);
            this.c = (TextView) view.findViewById(R$id.tv_pay_title);
            this.d = (TextView) view.findViewById(R$id.text_promotion);
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view.findViewById(R$id.cb_pay_check);
            this.e = dMIconFontTextView;
            dMIconFontTextView.setEnabled(false);
            this.e.setFocusable(false);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1820702850")) {
                ipChange.ipc$dispatch("-1820702850", new Object[]{this, view});
                return;
            }
            OrderDetailPayInfo orderDetailPayInfo = (OrderDetailPayInfo) view.getTag();
            if (orderDetailPayInfo != null) {
                if (OrderDetailPayAdapter.this.c.isCoupon()) {
                    c.e().x(ln2.r().o(orderDetailPayInfo.payName, orderDetailPayInfo.mDemoIndex, OrderDetailPayAdapter.this.c.getProjectId(), OrderDetailPayAdapter.this.c.getOrderId()));
                }
                OrderDetailPayInfo orderDetailPayInfo2 = OrderDetailPayAdapter.this.g;
                if (orderDetailPayInfo2 != null) {
                    String str = orderDetailPayInfo.payCode;
                    if (str == null || !str.equals(orderDetailPayInfo2.payCode) || !orderDetailPayInfo.payName.equals(OrderDetailPayAdapter.this.g.payName)) {
                        OrderDetailPayAdapter.this.g.isSelected = false;
                    } else {
                        return;
                    }
                }
                OrderDetailPayAdapter orderDetailPayAdapter = OrderDetailPayAdapter.this;
                DMIconFontTextView dMIconFontTextView = orderDetailPayAdapter.f;
                if (dMIconFontTextView != null) {
                    orderDetailPayAdapter.i(dMIconFontTextView);
                }
                orderDetailPayInfo.isSelected = true;
                OrderDetailPayAdapter orderDetailPayAdapter2 = OrderDetailPayAdapter.this;
                orderDetailPayAdapter2.g = orderDetailPayInfo;
                orderDetailPayAdapter2.f = (DMIconFontTextView) view.findViewById(R$id.cb_pay_check);
                OrderDetailPayAdapter orderDetailPayAdapter3 = OrderDetailPayAdapter.this;
                orderDetailPayAdapter3.f(orderDetailPayAdapter3.f);
                if (OrderDetailPayAdapter.this.c != null && OrderDetailPayAdapter.this.c.getPayChangeLiveData() != null) {
                    OrderDetailPayAdapter.this.c.getPayChangeLiveData().setValue(orderDetailPayInfo);
                }
            }
        }
    }

    public OrderDetailPayAdapter(FragmentActivity fragmentActivity, List<OrderDetailPayInfo> list) {
        this.a = list;
        this.b = fragmentActivity;
        OrderDetailPayViewModel orderDetailPayViewModel = (OrderDetailPayViewModel) ViewModelProviders.of(fragmentActivity).get(OrderDetailPayViewModel.class);
        this.c = orderDetailPayViewModel;
        if (orderDetailPayViewModel != null) {
            this.d = orderDetailPayViewModel.getOrderId();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(DMIconFontTextView dMIconFontTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893188986")) {
            ipChange.ipc$dispatch("-1893188986", new Object[]{this, dMIconFontTextView});
            return;
        }
        dMIconFontTextView.setText(R$string.iconfont_danxuanxuanzhong24);
        dMIconFontTextView.setTextColor(ContextCompat.getColor(this.b, R$color.color_FF2D79));
    }

    private void g(View view, String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337066845")) {
            ipChange.ipc$dispatch("-337066845", new Object[]{this, view, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("orderid", str);
        hashMap.put("item_id", str3);
        hashMap.put("titlelabel", str2);
        c e2 = c.e();
        e2.G(view, "bottom", "pay_" + i, ln2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE, hashMap);
    }

    private void h(View view, String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-171329055")) {
            ipChange.ipc$dispatch("-171329055", new Object[]{this, view, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("orderid", str);
        hashMap.put("titlelabel", str2);
        hashMap.put("discount_name", str3);
        c e2 = c.e();
        e2.G(view, "item_" + i, "order_info", ln2.ORDER_DETAL_PAGE, hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i(DMIconFontTextView dMIconFontTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720549761")) {
            ipChange.ipc$dispatch("-720549761", new Object[]{this, dMIconFontTextView});
            return;
        }
        dMIconFontTextView.setText(R$string.iconfont_danxuanweixuanzhong24);
        dMIconFontTextView.setTextColor(ContextCompat.getColor(this.b, R$color.color_E0E0E0));
    }

    /* renamed from: d */
    public void onBindViewHolder(@NonNull PayViewHolder payViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29193759")) {
            ipChange.ipc$dispatch("-29193759", new Object[]{this, payViewHolder, Integer.valueOf(i)});
            return;
        }
        OrderDetailPayInfo orderDetailPayInfo = this.a.get(i);
        if (orderDetailPayInfo != null) {
            if (payViewHolder.b.getTag() instanceof zq) {
                ((zq) payViewHolder.b.getTag()).cancel();
            }
            DMImageCreator c2 = cn.damai.common.image.a.b().c(orderDetailPayInfo.iconUrl);
            int i2 = R$drawable.uikit_user_default_icon;
            payViewHolder.b.setTag(c2.i(i2).c(i2).g(payViewHolder.b));
            if (this.c.isCoupon()) {
                g(payViewHolder.c, this.d, orderDetailPayInfo.payName, this.c.getProjectId(), i);
            }
            TextView textView = payViewHolder.c;
            String str = orderDetailPayInfo.payName;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            if (TextUtils.isEmpty(orderDetailPayInfo.payTips)) {
                payViewHolder.d.setVisibility(8);
            } else {
                payViewHolder.d.setText(orderDetailPayInfo.payTips);
                payViewHolder.d.setVisibility(0);
                h(payViewHolder.d, this.d, orderDetailPayInfo.payName, orderDetailPayInfo.payTips, i);
            }
            if (orderDetailPayInfo.isSelected) {
                this.f = payViewHolder.e;
                this.g = orderDetailPayInfo;
                f(payViewHolder.e);
            } else {
                i(payViewHolder.e);
            }
            orderDetailPayInfo.mDemoIndex = i;
            payViewHolder.a.setTag(orderDetailPayInfo);
            payViewHolder.a.setOnClickListener(this.e);
        }
    }

    @NonNull
    /* renamed from: e */
    public PayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2082772917")) {
            return new PayViewHolder(this, LayoutInflater.from(this.b).inflate(R$layout.order_detail_pay_list, viewGroup, false));
        }
        return (PayViewHolder) ipChange.ipc$dispatch("2082772917", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1304771283")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("-1304771283", new Object[]{this})).intValue();
    }
}
