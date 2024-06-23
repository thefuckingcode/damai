package cn.damai.commonbusiness.address.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.address.bean.PhoneAllowableBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.jl1;
import tb.xf2;

/* compiled from: Taobao */
public class AreaCodeChooseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<PhoneAllowableBean> a;
    private String b;
    private PhoneAllowableBean c;
    private Context d;
    private OnAreaCodeItemClickListener e;

    /* compiled from: Taobao */
    public interface OnAreaCodeItemClickListener {
        void onItemClick(int i);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "345670453")) {
                ipChange.ipc$dispatch("345670453", new Object[]{this, view});
            } else if (AreaCodeChooseAdapter.this.e != null) {
                AreaCodeChooseAdapter.this.e.onItemClick(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    private static class b extends RecyclerView.ViewHolder {
        public TextView a;
        public CheckBox b;

        public b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.area_code_text_name_tv);
            this.b = (CheckBox) view.findViewById(R$id.area_code_select_ck);
        }
    }

    public AreaCodeChooseAdapter(Context context, String str, List<PhoneAllowableBean> list) {
        this.d = context;
        this.b = str;
        this.a = list;
    }

    public void b(OnAreaCodeItemClickListener onAreaCodeItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245809010")) {
            ipChange.ipc$dispatch("1245809010", new Object[]{this, onAreaCodeItemClickListener});
            return;
        }
        this.e = onAreaCodeItemClickListener;
    }

    public void c(PhoneAllowableBean phoneAllowableBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593480976")) {
            ipChange.ipc$dispatch("-593480976", new Object[]{this, phoneAllowableBean});
            return;
        }
        this.c = phoneAllowableBean;
        if (phoneAllowableBean != null) {
            this.b = phoneAllowableBean.code;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-367046940")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("-367046940", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-507136107")) {
            ipChange.ipc$dispatch("-507136107", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        PhoneAllowableBean phoneAllowableBean = this.a.get(i);
        if (phoneAllowableBean != null) {
            b bVar = (b) viewHolder;
            TextView textView = bVar.a;
            textView.setText(phoneAllowableBean.areaName + " " + jl1.PLUS + phoneAllowableBean.code);
            bVar.b.setOnCheckedChangeListener(null);
            if (!TextUtils.isEmpty(this.b)) {
                z = this.b.equalsIgnoreCase(phoneAllowableBean.code);
            }
            bVar.b.setChecked(z);
            bVar.itemView.setOnClickListener(new a(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "889816577")) {
            return new b(LayoutInflater.from(this.d).inflate(R$layout.area_code_choose_item, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("889816577", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
