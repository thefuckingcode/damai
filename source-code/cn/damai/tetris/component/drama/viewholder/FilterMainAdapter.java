package cn.damai.tetris.component.drama.viewholder;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.tetris.component.drama.bean.FilterMainBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xs0;

/* compiled from: Taobao */
public class FilterMainAdapter extends RecyclerView.Adapter<MainVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<FilterMainBean> a;
    private OnItemBindListener<FilterMainBean> b;
    private int c = Color.parseColor("#9C9CA5");
    private int d = Color.parseColor("#FF2869");

    /* compiled from: Taobao */
    public class MainVh extends BaseViewHolder<FilterMainBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        TextView a;
        FilterMainBean b;
        int c;

        public MainVh(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.filter_main_text);
            view.setOnClickListener(this);
        }

        /* renamed from: c */
        public void a(FilterMainBean filterMainBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1538725026")) {
                ipChange.ipc$dispatch("1538725026", new Object[]{this, filterMainBean, Integer.valueOf(i)});
                return;
            }
            this.b = filterMainBean;
            this.c = i;
            this.a.setText(filterMainBean.name);
            this.a.setTextColor(filterMainBean.isSelected ? FilterMainAdapter.this.d : FilterMainAdapter.this.c);
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1097685384")) {
                ipChange.ipc$dispatch("1097685384", new Object[]{this, view});
                return;
            }
            FilterMainBean filterMainBean = this.b;
            if (filterMainBean != null && !filterMainBean.isSelected && FilterMainAdapter.this.b != null) {
                FilterMainAdapter.this.b.onItemClick(this.b, this.c);
            }
        }
    }

    public FilterMainAdapter(OnItemBindListener<FilterMainBean> onItemBindListener) {
        this.b = onItemBindListener;
    }

    /* renamed from: d */
    public void onBindViewHolder(@NonNull MainVh mainVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076260935")) {
            ipChange.ipc$dispatch("-1076260935", new Object[]{this, mainVh, Integer.valueOf(i)});
            return;
        }
        FilterMainBean filterMainBean = this.a.get(i);
        OnItemBindListener<FilterMainBean> onItemBindListener = this.b;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(mainVh.itemView, filterMainBean, i);
        }
        mainVh.a(filterMainBean, i);
    }

    @NonNull
    /* renamed from: e */
    public MainVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1594154211")) {
            return new MainVh(LayoutInflater.from(xs0.a()).inflate(R$layout.item_filter_main, viewGroup, false));
        }
        return (MainVh) ipChange.ipc$dispatch("-1594154211", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void f(List<FilterMainBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1769604364")) {
            ipChange.ipc$dispatch("-1769604364", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065415255")) {
            return ((Integer) ipChange.ipc$dispatch("2065415255", new Object[]{this})).intValue();
        }
        List<FilterMainBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
