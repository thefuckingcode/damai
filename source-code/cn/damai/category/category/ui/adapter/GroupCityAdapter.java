package cn.damai.category.category.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.IndexSitesBean;
import cn.damai.category.category.ui.adapter.CitySelectAdapter;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.city.model.SitesBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class GroupCityAdapter extends RecyclerView.Adapter<GroupCityViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private CitySelectAdapter.OnCityListItemClickListener2 a;
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
            super(LayoutInflater.from(GroupCityAdapter.this.b).inflate(R$layout.layout_select_city_group_list_item, (ViewGroup) null));
            this.itemView.setOnClickListener(GroupCityAdapter.this.d);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(SitesBean sitesBean, int i) {
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-926597525")) {
                ipChange.ipc$dispatch("-926597525", new Object[]{this, sitesBean, Integer.valueOf(i)});
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
                IndexSitesBean indexSitesBean = new IndexSitesBean();
                indexSitesBean.index = i;
                indexSitesBean.setCityId(sitesBean.getCityId());
                indexSitesBean.setCityName(sitesBean.getCityName());
                this.itemView.setTag(indexSitesBean);
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "791883224")) {
                ipChange.ipc$dispatch("791883224", new Object[]{this, view});
                return;
            }
            IndexSitesBean indexSitesBean = (IndexSitesBean) view.getTag();
            if (indexSitesBean != null && GroupCityAdapter.this.a != null) {
                GroupCityAdapter.this.a.onGroupCityClick(indexSitesBean.index, indexSitesBean.getCityId(), indexSitesBean.getCityName());
            }
        }
    }

    public GroupCityAdapter(Context context) {
        this.b = context;
    }

    /* renamed from: d */
    public void onBindViewHolder(@NonNull GroupCityViewHolder groupCityViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470022205")) {
            ipChange.ipc$dispatch("-470022205", new Object[]{this, groupCityViewHolder, Integer.valueOf(i)});
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
        if (!AndroidInstantRuntime.support(ipChange, "619186707")) {
            return new GroupCityViewHolder();
        }
        return (GroupCityViewHolder) ipChange.ipc$dispatch("619186707", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void f(CitySelectAdapter.OnCityListItemClickListener2 onCityListItemClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853470941")) {
            ipChange.ipc$dispatch("853470941", new Object[]{this, onCityListItemClickListener2});
            return;
        }
        this.a = onCityListItemClickListener2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1288724601")) {
            return xf2.e(this.c);
        }
        return ((Integer) ipChange.ipc$dispatch("-1288724601", new Object[]{this})).intValue();
    }

    public void setData(List<SitesBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-660868683")) {
            ipChange.ipc$dispatch("-660868683", new Object[]{this, list});
            return;
        }
        this.c = list;
    }
}
