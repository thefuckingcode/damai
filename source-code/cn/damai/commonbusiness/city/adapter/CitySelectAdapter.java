package cn.damai.commonbusiness.city.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.city.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.d20;
import tb.g70;
import tb.ji;
import tb.s72;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class CitySelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCityListItemClickListener a;
    private Context b;
    private List<ji> c;
    private int d;
    private int e;
    private String f;
    private View.OnClickListener g = new a();

    /* compiled from: Taobao */
    public class GroupViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private RecyclerView a = ((RecyclerView) this.itemView.findViewById(R$id.group_city_list));
        private GroupCityAdapter b;

        public GroupViewHolder(CitySelectAdapter citySelectAdapter) {
            super(LayoutInflater.from(citySelectAdapter.b).inflate(R$layout.layout_select_city_group_list, (ViewGroup) null));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(citySelectAdapter.b);
            linearLayoutManager.setOrientation(1);
            this.a.setLayoutManager(linearLayoutManager);
            GroupCityAdapter groupCityAdapter = new GroupCityAdapter(citySelectAdapter.b);
            this.b = groupCityAdapter;
            groupCityAdapter.f(citySelectAdapter.a);
            this.a.setAdapter(this.b);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(ji jiVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "815829813")) {
                ipChange.ipc$dispatch("815829813", new Object[]{this, jiVar});
                return;
            }
            this.b.setData(jiVar.c());
            this.b.notifyDataSetChanged();
        }
    }

    /* compiled from: Taobao */
    public class HotViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private FlowLayout a = ((FlowLayout) this.itemView.findViewById(R$id.hot_city_list));

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ HotCityBean a;

            a(HotCityBean hotCityBean) {
                this.a = hotCityBean;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1005958438")) {
                    ipChange.ipc$dispatch("-1005958438", new Object[]{this, view});
                } else if (!s72.c() && CitySelectAdapter.this.a != null) {
                    CitySelectAdapter.this.a.onHotCityClick(this.a.getCityName(), this.a.getCityId(), this.a.getUrl());
                }
            }
        }

        public HotViewHolder() {
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_hot_list, (ViewGroup) null));
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(ji jiVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1451806787")) {
                ipChange.ipc$dispatch("1451806787", new Object[]{this, jiVar});
                return;
            }
            List<HotCityBean> a2 = jiVar.a();
            int e = xf2.e(a2);
            this.a.removeAllViews();
            if (e > 0) {
                for (int i = 0; i < e; i++) {
                    HotCityBean hotCityBean = a2.get(i);
                    if (hotCityBean != null) {
                        View inflate = LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_hot_list_item, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R$id.select_city_hot_list_item);
                        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                        layoutParams.width = CitySelectAdapter.this.d;
                        layoutParams.height = CitySelectAdapter.this.e;
                        textView.setLayoutParams(layoutParams);
                        if (!TextUtils.isEmpty(CitySelectAdapter.this.f) && CitySelectAdapter.this.f.equals(hotCityBean.getCityName())) {
                            textView.setBackgroundResource(R$drawable.city_select_hot_city_border_select);
                            textView.setTextColor(Color.parseColor("#FF2869"));
                        } else if (!d20.d().equals(hotCityBean.getCityName()) || !TextUtils.isEmpty(CitySelectAdapter.this.f)) {
                            textView.setBackgroundResource(R$drawable.city_select_hot_city_border_normal);
                            textView.setTextColor(Color.parseColor("#000000"));
                        } else {
                            textView.setBackgroundResource(R$drawable.city_select_hot_city_border_select);
                            textView.setTextColor(Color.parseColor("#FF2869"));
                        }
                        textView.setText(hotCityBean.getCityName());
                        inflate.setOnClickListener(new a(hotCityBean));
                        this.a.addView(inflate);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class LacationViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;

        public LacationViewHolder() {
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_location, (ViewGroup) null));
            TextView textView = (TextView) this.itemView.findViewById(R$id.select_city_hot_list_item);
            this.a = textView;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = CitySelectAdapter.this.e;
            this.a.setLayoutParams(layoutParams);
            this.a.setMinWidth(CitySelectAdapter.this.d);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(ji jiVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1586544173")) {
                ipChange.ipc$dispatch("-1586544173", new Object[]{this, jiVar});
                return;
            }
            SitesBean b2 = jiVar.b();
            int i = jiVar.c;
            String str = "定位异常，请退出页面重试";
            int i2 = -16777216;
            int i3 = R$drawable.city_select_hot_city_border_normal;
            if (i == 102) {
                str = "定位获取失败，请点击重试";
            } else if (i == 119) {
                str = "定位中...";
            } else if (i == 136) {
                if (b2 != null) {
                    str = b2.getCityName();
                }
                i2 = Color.parseColor("#FF2869");
                i3 = R$drawable.city_select_hot_city_border_select;
            }
            this.a.setText(str);
            this.a.setTextColor(i2);
            this.a.setBackgroundResource(i3);
            this.itemView.setTag(jiVar);
            this.itemView.setOnClickListener(CitySelectAdapter.this.g);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            SitesBean b;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "311928320")) {
                ipChange.ipc$dispatch("311928320", new Object[]{this, view});
            } else if (!s72.c() && CitySelectAdapter.this.a != null) {
                Object tag = view.getTag();
                if (tag instanceof ji) {
                    ji jiVar = (ji) tag;
                    int i = jiVar.c;
                    if (i == 102) {
                        CitySelectAdapter.this.a.onRequestLocationPermission();
                    } else if (i == 136 && (b = jiVar.b()) != null) {
                        CitySelectAdapter.this.a.onLocationCityClick(b.getCityId(), b.getCityName());
                    }
                }
            }
        }
    }

    public CitySelectAdapter(Context context, List<ji> list) {
        this.b = context;
        this.c = list;
        this.d = (g70.d() - v50.a(context, 63.0f)) / 3;
        this.e = ScreenUtil.dip2px(this.b, 31.0f);
    }

    public void g(OnCityListItemClickListener onCityListItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652602115")) {
            ipChange.ipc$dispatch("-652602115", new Object[]{this, onCityListItemClickListener});
            return;
        }
        this.a = onCityListItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "949577647")) {
            return xf2.e(this.c);
        }
        return ((Integer) ipChange.ipc$dispatch("949577647", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994898646")) {
            return ((Integer) ipChange.ipc$dispatch("994898646", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        try {
            return this.c.get(i).d();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1072504290")) {
            ipChange.ipc$dispatch("-1072504290", new Object[]{this, str});
            return;
        }
        this.f = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551623702")) {
            ipChange.ipc$dispatch("-551623702", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            ji jiVar = this.c.get(i);
            int d2 = jiVar.d();
            if (d2 == 0) {
                ((LacationViewHolder) viewHolder).a(jiVar);
            } else if (d2 == 1) {
                ((HotViewHolder) viewHolder).a(jiVar);
            } else if (d2 == 2) {
                ((GroupViewHolder) viewHolder).a(jiVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253936308")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1253936308", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 0) {
            return new LacationViewHolder();
        } else {
            if (i == 1) {
                return new HotViewHolder();
            }
            if (i != 2) {
                return null;
            }
            return new GroupViewHolder(this);
        }
    }
}
