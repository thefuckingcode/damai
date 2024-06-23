package cn.damai.discover.content.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xs0;

/* compiled from: Taobao */
public class CityProjectListAdapter extends RecyclerView.Adapter<CityProjectVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ContentTour.ContentRelatedTourListItem> a;
    private OnItemBindListener<ContentTour.ContentRelatedTourListItem> b;

    /* compiled from: Taobao */
    public class CityProjectVh extends BaseViewHolderV2<ContentTour.ContentRelatedTourListItem> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView c = ((TextView) this.itemView.findViewById(R$id.city_project_name));
        private TextView d = ((TextView) this.itemView.findViewById(R$id.city_project_time));

        public CityProjectVh(ViewGroup viewGroup) {
            super(LayoutInflater.from(xs0.a()).inflate(R$layout.item_city_project, viewGroup, false));
            this.itemView.setOnClickListener(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void c(ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1417112870")) {
                ipChange.ipc$dispatch("1417112870", new Object[]{this, contentRelatedTourListItem, Integer.valueOf(i)});
            } else if (contentRelatedTourListItem != null) {
                this.c.setText(contentRelatedTourListItem.cityName);
                this.d.setText(contentRelatedTourListItem.showTime);
                if (CityProjectListAdapter.this.b != null) {
                    CityProjectListAdapter.this.b.exposeItem(this.itemView, this.a, i);
                }
            }
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1810790791")) {
                ipChange.ipc$dispatch("1810790791", new Object[]{this, view});
            } else if (this.a != null && CityProjectListAdapter.this.b != null) {
                CityProjectListAdapter.this.b.onItemClick(this.a, this.b);
            }
        }
    }

    public CityProjectListAdapter(OnItemBindListener<ContentTour.ContentRelatedTourListItem> onItemBindListener) {
        this.b = onItemBindListener;
    }

    /* renamed from: b */
    public void onBindViewHolder(@NonNull CityProjectVh cityProjectVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622134376")) {
            ipChange.ipc$dispatch("622134376", new Object[]{this, cityProjectVh, Integer.valueOf(i)});
            return;
        }
        cityProjectVh.a(this.a.get(i), i);
    }

    @NonNull
    /* renamed from: c */
    public CityProjectVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1171371214")) {
            return new CityProjectVh(viewGroup);
        }
        return (CityProjectVh) ipChange.ipc$dispatch("1171371214", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void d(List<ContentTour.ContentRelatedTourListItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466189662")) {
            ipChange.ipc$dispatch("-466189662", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121276039")) {
            return ((Integer) ipChange.ipc$dispatch("1121276039", new Object[]{this})).intValue();
        }
        List<ContentTour.ContentRelatedTourListItem> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
