package cn.damai.tetris.component.drama.viewholder;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xs0;

/* compiled from: Taobao */
public class FilterTagViewHolder extends BaseViewHolderV2<FilterTagBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnItemClickListener<FilterTagBean> c;
    private TextView d = ((TextView) this.itemView.findViewById(R$id.filter_tag_name));

    public FilterTagViewHolder(ViewGroup viewGroup, OnItemClickListener<FilterTagBean> onItemClickListener) {
        super(LayoutInflater.from(xs0.a()).inflate(R$layout.item_filter_tag, viewGroup, false));
        this.c = onItemClickListener;
        this.itemView.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void c(FilterTagBean filterTagBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466923781")) {
            ipChange.ipc$dispatch("-1466923781", new Object[]{this, filterTagBean, Integer.valueOf(i)});
            return;
        }
        this.d.setText(filterTagBean.name);
        boolean z = filterTagBean.isSelected;
        int parseColor = Color.parseColor(z ? "#FF2869" : "#9C9CA5");
        int i2 = z ? R$drawable.shape_filter_tag_selected : R$drawable.shape_filter_tag_unselected;
        this.d.setTextColor(parseColor);
        this.d.setBackgroundResource(i2);
    }

    public void onClick(View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121070544")) {
            ipChange.ipc$dispatch("-2121070544", new Object[]{this, view});
            return;
        }
        OnItemClickListener<FilterTagBean> onItemClickListener = this.c;
        if (onItemClickListener != null && (t = this.a) != null && !t.isSelected) {
            onItemClickListener.onItemClick(t, this.b);
        }
    }
}
