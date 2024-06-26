package com.alibaba.pictures.bricks.component.project.tour;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.commonbusiness.search.bean.SearchTourItem;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.kvdata.SPProviderProxy;
import java.util.ArrayList;
import java.util.List;
import tb.sb2;
import tb.t71;

/* compiled from: Taobao */
public class SearchTourItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MAX_SIZE = 6;
    private List<SearchTourItem> a = new ArrayList();
    private Context b;
    private boolean c;
    private UserTrackInterface d;

    /* compiled from: Taobao */
    public class tourItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a = ((TextView) this.itemView.findViewById(R$id.tv_city));
        private TextView b = ((TextView) this.itemView.findViewById(R$id.tv_time));
        private LinearLayout c = ((LinearLayout) this.itemView.findViewById(R$id.ll_city_tour));
        private ImageView d = ((ImageView) this.itemView.findViewById(R$id.current_city_logo));
        private TextView e = ((TextView) this.itemView.findViewById(R$id.tv_project_status));

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ SearchTourItem a;
            final /* synthetic */ int b;

            a(SearchTourItem searchTourItem, int i) {
                this.a = searchTourItem;
                this.b = i;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "167459978")) {
                    ipChange.ipc$dispatch("167459978", new Object[]{this, view});
                    return;
                }
                String str = this.a.itemId;
                if (!TextUtils.isEmpty(str)) {
                    if (SearchTourItemAdapter.this.d != null) {
                        SearchTourItemAdapter.this.d.userTrackClick(str, this.b);
                    }
                    sb2.a(SearchTourItemAdapter.this.b, this.a.getSchema(), str, "", "");
                }
            }
        }

        public tourItemViewHolder(LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.bricks_search_tour_city_arch_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }

        public void a(SearchTourItem searchTourItem, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1365528830")) {
                ipChange.ipc$dispatch("1365528830", new Object[]{this, searchTourItem, Integer.valueOf(i)});
                return;
            }
            this.a.setText(searchTourItem.city);
            if (searchTourItem.city.equals(SearchTourItemAdapter.c())) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            if (!searchTourItem.isLiveProject()) {
                if (TextUtils.isEmpty(searchTourItem.showTime) || searchTourItem.showTime.length() <= 16) {
                    this.b.setTextSize(1, 10.0f);
                } else {
                    this.b.setTextSize(1, 9.0f);
                }
                this.b.setText(searchTourItem.showTime);
            } else {
                this.b.setText(searchTourItem.liveStartTime);
            }
            this.e.setVisibility(8);
            if (!TextUtils.isEmpty(searchTourItem.itemSaleStatusDesc)) {
                this.e.setVisibility(0);
                this.e.setText(searchTourItem.itemSaleStatusDesc);
                if ("暂不可售".equals(searchTourItem.itemSaleStatusDesc) || "已下架".equals(searchTourItem.itemSaleStatusDesc)) {
                    this.e.setTextColor(Color.parseColor("#9C9CA5"));
                } else {
                    this.e.setTextColor(Color.parseColor("#FF2869"));
                }
            } else {
                this.e.setVisibility(8);
            }
            if (SearchTourItemAdapter.this.d != null) {
                SearchTourItemAdapter.this.d.userTrackExpose(this.itemView, searchTourItem.itemId, i);
            }
            this.c.setOnClickListener(new a(searchTourItem, i));
        }
    }

    public SearchTourItemAdapter(Context context) {
        this.b = context;
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597887096")) {
            return (String) ipChange.ipc$dispatch("-1597887096", new Object[0]);
        }
        if (Thread.currentThread().getName().equals("cn.damai")) {
            return SPProviderProxy.getSharedPreferences(ShareperfenceConstants.CITY_SHAREPREFENCE).getString(ShareperfenceConstants.CITY_NAME, "北京");
        }
        Log.e("onearch", "no getcityname method impl");
        return "";
    }

    public void d(List<SearchTourItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404418641")) {
            ipChange.ipc$dispatch("404418641", new Object[]{this, list});
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (t71.a(list) > 0) {
            this.a.clear();
            this.a.addAll(list);
        }
    }

    public void e(UserTrackInterface userTrackInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756594519")) {
            ipChange.ipc$dispatch("-756594519", new Object[]{this, userTrackInterface});
            return;
        }
        this.d = userTrackInterface;
    }

    public void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-804260811")) {
            ipChange.ipc$dispatch("-804260811", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.c = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380359085")) {
            return ((Integer) ipChange.ipc$dispatch("-380359085", new Object[]{this})).intValue();
        } else if (this.c) {
            return t71.a(this.a);
        } else {
            int a2 = t71.a(this.a);
            if (a2 <= 6) {
                return a2;
            }
            return 6;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143036218")) {
            ipChange.ipc$dispatch("-1143036218", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ((tourItemViewHolder) viewHolder).a(this.a.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1524342800")) {
            return new tourItemViewHolder(LayoutInflater.from(this.b));
        }
        return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1524342800", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
