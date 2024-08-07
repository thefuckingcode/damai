package cn.damai.tetris.component.drama.viewholder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ac0;
import tb.lk1;

/* compiled from: Taobao */
public class DramaCardVerticalViewHolder extends BaseViewHolderV2<DramaV1Bean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView c;
    private TextView d;
    private OnItemClickListener<DramaV1Bean> e;
    private ac0 f = new ac0(this.itemView);

    public DramaCardVerticalViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<DramaV1Bean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_tetris_drama_card, viewGroup, false));
        View findViewById = this.itemView.findViewById(R$id.drama_inner_layout2);
        this.c = (TextView) this.itemView.findViewById(R$id.drama_title);
        this.d = (TextView) this.itemView.findViewById(R$id.drama_ipuv);
        this.e = onItemClickListener;
        findViewById.setOnClickListener(this);
    }

    /* renamed from: d */
    public void c(DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145084432")) {
            ipChange.ipc$dispatch("-1145084432", new Object[]{this, dramaV1Bean, Integer.valueOf(i)});
        } else if (dramaV1Bean != null) {
            this.f.a(dramaV1Bean.pic);
            this.c.setText(dramaV1Bean.title);
            SpannableStringBuilder e2 = lk1.e(dramaV1Bean.ipvuv);
            this.d.setVisibility(0);
            this.d.setText(e2);
        }
    }

    public void onClick(View view) {
        OnItemClickListener<DramaV1Bean> onItemClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-49452773")) {
            ipChange.ipc$dispatch("-49452773", new Object[]{this, view});
            return;
        }
        T t = this.a;
        if (t != null && (onItemClickListener = this.e) != null) {
            onItemClickListener.onItemClick(t, this.b);
        }
    }
}
