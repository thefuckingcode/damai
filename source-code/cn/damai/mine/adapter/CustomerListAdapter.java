package cn.damai.mine.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.activity.CustomersActivity;
import cn.damai.mine.bean.CustomerBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class CustomerListAdapter extends RecyclerView.Adapter<b> {
    private static transient /* synthetic */ IpChange $ipChange;
    private CustomersActivity a;
    private List<CustomerBean> b = new ArrayList();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CustomerBean a;

        a(CustomerBean customerBean) {
            this.a = customerBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-366801139")) {
                ipChange.ipc$dispatch("-366801139", new Object[]{this, view});
                return;
            }
            CustomerListAdapter.this.a.showDeleteCustomerDialog(this.a.getIdentityHash());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;
        DMIconFontTextView d;
        View e;

        public b(CustomerListAdapter customerListAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.user_name);
            this.b = (TextView) view.findViewById(R$id.idTypeName);
            this.c = (TextView) view.findViewById(R$id.idCard);
            this.d = (DMIconFontTextView) view.findViewById(R$id.custom_delete);
            this.e = view.findViewById(R$id.customer_item_bottom_line);
        }
    }

    public CustomerListAdapter(CustomersActivity customersActivity) {
        this.a = customersActivity;
        this.b = new ArrayList();
    }

    private void d(b bVar, CustomerBean customerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-606487203")) {
            ipChange.ipc$dispatch("-606487203", new Object[]{this, bVar, customerBean});
            return;
        }
        if (!TextUtils.isEmpty(customerBean.getMaskedName())) {
            bVar.a.setText(customerBean.getMaskedName());
        }
        if (!TextUtils.isEmpty(customerBean.getIdentityTypeName())) {
            bVar.b.setText(customerBean.getIdentityTypeName());
        }
        if (!TextUtils.isEmpty(customerBean.getMaskedIdentityNo())) {
            bVar.c.setText(customerBean.getMaskedIdentityNo());
        }
        bVar.d.setOnClickListener(new a(customerBean));
    }

    /* renamed from: b */
    public void onBindViewHolder(b bVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797472651")) {
            ipChange.ipc$dispatch("-1797472651", new Object[]{this, bVar, Integer.valueOf(i)});
            return;
        }
        d(bVar, this.b.get(i));
        if (i == getItemCount() - 1) {
            bVar.e.setVisibility(8);
        } else {
            bVar.e.setVisibility(0);
        }
    }

    /* renamed from: c */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "126433057")) {
            return new b(this, LayoutInflater.from(this.a).inflate(R$layout.customer_item, (ViewGroup) null));
        }
        return (b) ipChange.ipc$dispatch("126433057", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public List<CustomerBean> getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1902291476")) {
            return this.b;
        }
        return (List) ipChange.ipc$dispatch("-1902291476", new Object[]{this});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2788028")) {
            return this.b.size();
        }
        return ((Integer) ipChange.ipc$dispatch("2788028", new Object[]{this})).intValue();
    }

    public void setData(List<CustomerBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "905405280")) {
            ipChange.ipc$dispatch("905405280", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }
}
