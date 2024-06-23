package cn.damai.commonbusiness.citycopy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.citycopy.model.SitesBean;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.e92;
import tb.l42;

/* compiled from: Taobao */
public class GroupCityAdapter extends RecyclerView.Adapter<GroupCityViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCityListItemClickListener a;
    private Context b;
    private List<SitesBean> c;
    private View.OnClickListener d = new a();

    /* compiled from: Taobao */
    public class GroupCityViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a = ((TextView) this.itemView.findViewById(R$id.select_city_list_item));
        private View b = this.itemView.findViewById(R$id.select_city_list_item_divider);
        private View c = this.itemView.findViewById(R$id.select_city_list_item_divider_bottom);

        public GroupCityViewHolder() {
            super(LayoutInflater.from(GroupCityAdapter.this.b).inflate(R$layout.copy_layout_select_city_group_list_item, (ViewGroup) null));
            this.itemView.setOnClickListener(GroupCityAdapter.this.d);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(SitesBean sitesBean, int i) {
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1967105934")) {
                ipChange.ipc$dispatch("-1967105934", new Object[]{this, sitesBean, Integer.valueOf(i)});
                return;
            }
            this.b.setVisibility(i == 0 ? 8 : 0);
            View view = this.c;
            if (i != GroupCityAdapter.this.getItemCount() - 1) {
                i2 = 8;
            }
            view.setVisibility(i2);
            if (sitesBean != null) {
                this.a.setText(sitesBean.getCityName());
                this.itemView.setTag(sitesBean);
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            SitesBean sitesBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2058091270")) {
                ipChange.ipc$dispatch("2058091270", new Object[]{this, view});
            } else if (!l42.d() && (sitesBean = (SitesBean) view.getTag()) != null && GroupCityAdapter.this.a != null) {
                GroupCityAdapter.this.a.onGroupCityClick(sitesBean.getCityId(), sitesBean.getCityName());
            }
        }
    }

    public GroupCityAdapter(Context context) {
        this.b = context;
    }

    /* renamed from: d */
    public void onBindViewHolder(@NonNull GroupCityViewHolder groupCityViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031629729")) {
            ipChange.ipc$dispatch("-2031629729", new Object[]{this, groupCityViewHolder, Integer.valueOf(i)});
            return;
        }
        SitesBean sitesBean = this.c.get(i);
        if (groupCityViewHolder != null) {
            groupCityViewHolder.a(sitesBean, i);
        }
    }

    @NonNull
    /* renamed from: e */
    public GroupCityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1614154551")) {
            return new GroupCityViewHolder();
        }
        return (GroupCityViewHolder) ipChange.ipc$dispatch("1614154551", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void f(OnCityListItemClickListener onCityListItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444061740")) {
            ipChange.ipc$dispatch("444061740", new Object[]{this, onCityListItemClickListener});
            return;
        }
        this.a = onCityListItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "756320437")) {
            return e92.c(this.c);
        }
        return ((Integer) ipChange.ipc$dispatch("756320437", new Object[]{this})).intValue();
    }

    public void setData(List<SitesBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "430383047")) {
            ipChange.ipc$dispatch("430383047", new Object[]{this, list});
            return;
        }
        this.c = list;
    }
}
