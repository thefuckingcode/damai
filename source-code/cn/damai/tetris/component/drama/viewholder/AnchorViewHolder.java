package cn.damai.tetris.component.drama.viewholder;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.bean.AnchorBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xs0;

/* compiled from: Taobao */
public class AnchorViewHolder extends BaseViewHolderV2<AnchorBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView c = ((TextView) this.itemView.findViewById(R$id.anchor_name_tv));
    private OnItemClickListener<AnchorBean> d;

    public AnchorViewHolder(ViewGroup viewGroup, OnItemClickListener<AnchorBean> onItemClickListener) {
        super(BaseViewHolder.b(xs0.a(), viewGroup, R$layout.item_tetris_anchor_item));
        this.itemView.setOnClickListener(this);
        this.d = onItemClickListener;
    }

    /* renamed from: d */
    public void c(AnchorBean anchorBean, int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249289761")) {
            ipChange.ipc$dispatch("-249289761", new Object[]{this, anchorBean, Integer.valueOf(i)});
        } else if (anchorBean != null) {
            if (anchorBean.isSelect) {
                i2 = Color.parseColor("#FF2869");
            } else {
                i2 = Color.parseColor("#9C9CA5");
            }
            this.c.setText(anchorBean.name);
            this.c.setTextColor(i2);
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643335718")) {
            ipChange.ipc$dispatch("1643335718", new Object[]{this});
            return;
        }
        T t = this.a;
        if (t != null) {
            a(t, this.b);
        }
    }

    public void onClick(View view) {
        OnItemClickListener<AnchorBean> onItemClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655006019")) {
            ipChange.ipc$dispatch("-655006019", new Object[]{this, view});
            return;
        }
        T t = this.a;
        if (t != null && !t.isSelect && (onItemClickListener = this.d) != null) {
            onItemClickListener.onItemClick(t, this.b);
        }
    }
}
