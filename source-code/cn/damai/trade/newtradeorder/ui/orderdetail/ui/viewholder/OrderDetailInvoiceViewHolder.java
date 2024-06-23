package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.gr;
import tb.ln2;

/* compiled from: Taobao */
public class OrderDetailInvoiceViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.tv_invoice_state));
    private DMIconFontTextView b = ((DMIconFontTextView) this.itemView.findViewById(R$id.tv_invoice_state_more));
    private TextView c = ((TextView) this.itemView.findViewById(R$id.tv_invoice_tip));
    private Context d;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1889032107")) {
                ipChange.ipc$dispatch("-1889032107", new Object[]{this, view});
                return;
            }
            c.e().x(ln2.r().g1(this.a, this.b));
            Bundle bundle = new Bundle();
            bundle.putString("orderId", this.b);
            bundle.putString("projectId", this.a);
            DMNav.from(OrderDetailInvoiceViewHolder.this.d).withExtras(bundle).forResult(1005).toUri(NavUri.b(gr.k));
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "222258262")) {
                ipChange.ipc$dispatch("222258262", new Object[]{this, view});
                return;
            }
            c.e().x(ln2.r().h1(this.a, this.b));
            Bundle bundle = new Bundle();
            bundle.putString("orderId", this.b);
            DMNav.from(OrderDetailInvoiceViewHolder.this.d).withExtras(bundle).toUri(NavUri.b(gr.l));
        }
    }

    public OrderDetailInvoiceViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_invoice_item, (ViewGroup) null));
        this.d = context;
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void b(String str, String str2, int i, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078579743")) {
            ipChange.ipc$dispatch("2078579743", new Object[]{this, str, str2, Integer.valueOf(i), str3, str4});
        } else if (i == 1) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setText(str4);
            this.itemView.setClickable(false);
            this.itemView.setOnClickListener(null);
        } else if (i == 2) {
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            this.a.setText(str3);
            this.c.setVisibility(8);
            this.itemView.setClickable(true);
            this.itemView.setOnClickListener(new a(str2, str));
        } else if (i == 3 || i == 4) {
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            this.c.setVisibility(0);
            this.a.setText(str3);
            this.c.setText(str4);
            this.itemView.setClickable(true);
            this.itemView.setOnClickListener(new b(str2, str));
        } else if (i == 5) {
            this.b.setVisibility(8);
            this.a.setVisibility(0);
            this.c.setVisibility(0);
            this.a.setText(str3);
            this.c.setText(str4);
            this.itemView.setClickable(false);
            this.itemView.setOnClickListener(null);
        }
    }
}
