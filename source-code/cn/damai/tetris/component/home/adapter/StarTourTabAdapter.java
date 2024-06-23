package cn.damai.tetris.component.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.home.bean.HomeStarTourBean;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class StarTourTabAdapter extends RecyclerView.Adapter<StarTourTabViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnTabItemClickListener a;
    private List<HomeStarTourBean.HomeStarTourItem> b = new ArrayList();
    private View.OnClickListener c = new a();

    /* compiled from: Taobao */
    public interface OnTabItemClickListener {
        void onItemClick(View view);
    }

    /* compiled from: Taobao */
    public class StarTourTabViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a = ((TextView) this.itemView.findViewById(R$id.homepage_star_tour_tab_name));

        public StarTourTabViewHolder(Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.homepage_star_tour_tab_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.itemView.setOnClickListener(StarTourTabAdapter.this.c);
        }

        public void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "73276916")) {
                ipChange.ipc$dispatch("73276916", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            HomeStarTourBean.HomeStarTourItem homeStarTourItem = (HomeStarTourBean.HomeStarTourItem) StarTourTabAdapter.this.b.get(i);
            if (homeStarTourItem != null) {
                homeStarTourItem.position = i;
                this.a.setText(homeStarTourItem.artistName);
                if (homeStarTourItem.isSelected) {
                    this.a.setTextColor(Color.parseColor("#ff2869"));
                } else {
                    this.a.setTextColor(Color.parseColor("#9C9CA5"));
                }
                this.itemView.setTag(homeStarTourItem);
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
            if (AndroidInstantRuntime.support(ipChange, "1839819330")) {
                ipChange.ipc$dispatch("1839819330", new Object[]{this, view});
            } else if (StarTourTabAdapter.this.a != null) {
                StarTourTabAdapter.this.a.onItemClick(view);
            }
        }
    }

    /* renamed from: d */
    public void onBindViewHolder(@NonNull StarTourTabViewHolder starTourTabViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657151160")) {
            ipChange.ipc$dispatch("1657151160", new Object[]{this, starTourTabViewHolder, Integer.valueOf(i)});
            return;
        }
        starTourTabViewHolder.a(i);
    }

    @NonNull
    /* renamed from: e */
    public StarTourTabViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1564801154")) {
            return new StarTourTabViewHolder(viewGroup.getContext());
        }
        return (StarTourTabViewHolder) ipChange.ipc$dispatch("-1564801154", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void f(List<HomeStarTourBean.HomeStarTourItem> list, TrackInfo trackInfo, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710857836")) {
            ipChange.ipc$dispatch("-1710857836", new Object[]{this, list, trackInfo, str});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }

    public void g(OnTabItemClickListener onTabItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-597064880")) {
            ipChange.ipc$dispatch("-597064880", new Object[]{this, onTabItemClickListener});
            return;
        }
        this.a = onTabItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-168824847")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("-168824847", new Object[]{this})).intValue();
    }
}
