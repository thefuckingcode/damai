package cn.damai.tetris.component.rank.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public final class RankSelectItemViewHolder extends BaseViewHolderV2<RankSelectItemBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final DMPosterView c;
    @NotNull
    private final TextView d;
    @NotNull
    private final TextView e;
    @NotNull
    private final LinearLayout f;
    private final int g = n42.a(xs0.a(), 128.0f);
    private final int h = n42.a(xs0.a(), 95.0f);
    @Nullable
    private final OnItemClickListener<RankSelectItemBean> i;
    @Nullable
    private HashMap<Integer, Integer> j;

    public RankSelectItemViewHolder(@Nullable Context context, @Nullable ViewGroup viewGroup, @Nullable OnItemClickListener<RankSelectItemBean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_tetris_rank_select_card, viewGroup, false));
        View findViewById = this.itemView.findViewById(R$id.iv_poster);
        k21.h(findViewById, "itemView.findViewById(R.id.iv_poster)");
        this.c = (DMPosterView) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.drama_inner_layout);
        View findViewById3 = this.itemView.findViewById(R$id.tv_title);
        k21.h(findViewById3, "itemView.findViewById(R.id.tv_title)");
        this.d = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R$id.tv_desc);
        k21.h(findViewById4, "itemView.findViewById(R.id.tv_desc)");
        this.e = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R$id.ll_tv_container);
        k21.h(findViewById5, "itemView.findViewById(R.id.ll_tv_container)");
        this.f = (LinearLayout) findViewById5;
        this.i = onItemClickListener;
        findViewById2.setOnClickListener(this);
    }

    private final Integer e(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027132277")) {
            return (Integer) ipChange.ipc$dispatch("-1027132277", new Object[]{this, Integer.valueOf(i2)});
        }
        if (this.j == null) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            this.j = hashMap;
            k21.f(hashMap);
            hashMap.put(0, Integer.valueOf(R$drawable.bg_rank_select_1));
            HashMap<Integer, Integer> hashMap2 = this.j;
            k21.f(hashMap2);
            hashMap2.put(1, Integer.valueOf(R$drawable.bg_rank_select_2));
            HashMap<Integer, Integer> hashMap3 = this.j;
            k21.f(hashMap3);
            hashMap3.put(2, Integer.valueOf(R$drawable.bg_rank_select_3));
            HashMap<Integer, Integer> hashMap4 = this.j;
            k21.f(hashMap4);
            hashMap4.put(3, Integer.valueOf(R$drawable.bg_rank_select_4));
        }
        HashMap<Integer, Integer> hashMap5 = this.j;
        k21.f(hashMap5);
        return hashMap5.get(Integer.valueOf(i2 % 4));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void c(@Nullable RankSelectItemBean rankSelectItemBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "929753521")) {
            ipChange.ipc$dispatch("929753521", new Object[]{this, rankSelectItemBean, Integer.valueOf(i2)});
        } else if (rankSelectItemBean != null) {
            LinearLayout linearLayout = this.f;
            Resources resources = xs0.a().getResources();
            Integer e2 = e(i2);
            k21.f(e2);
            linearLayout.setBackground(resources.getDrawable(e2.intValue()));
            List<String> list = rankSelectItemBean.verticalPicList;
            if (list != null) {
                k21.f(list);
                if (list.size() > 0) {
                    DMPosterView dMPosterView = this.c;
                    List<String> list2 = rankSelectItemBean.verticalPicList;
                    k21.f(list2);
                    dMPosterView.setImageUrlForWebp(list2.get(0), this.h, this.g);
                }
            }
            String str = rankSelectItemBean.shortName;
            if (str != null) {
                this.d.setText(str);
            }
            String str2 = rankSelectItemBean.shortDesc;
            if (str2 != null) {
                this.e.setText(str2);
            }
        }
    }

    public void onClick(@NotNull View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-823848634")) {
            ipChange.ipc$dispatch("-823848634", new Object[]{this, view});
            return;
        }
        k21.i(view, "v");
        OnItemClickListener<RankSelectItemBean> onItemClickListener = this.i;
        if (onItemClickListener != null && (t = this.a) != null) {
            onItemClickListener.onItemClick(t, this.b);
        }
    }
}
