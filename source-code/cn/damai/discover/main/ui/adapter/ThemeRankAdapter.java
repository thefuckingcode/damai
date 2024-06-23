package cn.damai.discover.main.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.n42;
import tb.zq;

/* compiled from: Taobao */
public class ThemeRankAdapter extends RecyclerView.Adapter<RankVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<RankUserBean> a;
    private Context b;
    private OnItemBindListener<RankUserBean> c;

    /* compiled from: Taobao */
    public class RankVh extends BaseViewHolderV2<RankUserBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView c = ((TextView) this.itemView.findViewById(R$id.rank_user_extra));
        private TextView d = ((TextView) this.itemView.findViewById(R$id.rank_user_name));
        private View e = this.itemView.findViewById(R$id.rank_user_me_tag);
        private TextView f = ((TextView) this.itemView.findViewById(R$id.rank_user_num));
        private ImageView g = ((ImageView) this.itemView.findViewById(R$id.rank_user_mask));
        private ImageView h = ((ImageView) this.itemView.findViewById(R$id.rank_user_icon));
        private int i;

        public RankVh(Context context, ViewGroup viewGroup) {
            super(BaseViewHolder.b(context, viewGroup, R$layout.item_theme_rank_user));
            this.i = n42.a(context, 40.0f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void c(RankUserBean rankUserBean, int i2) {
            IpChange ipChange = $ipChange;
            int i3 = 0;
            if (AndroidInstantRuntime.support(ipChange, "1268530959")) {
                ipChange.ipc$dispatch("1268530959", new Object[]{this, rankUserBean, Integer.valueOf(i2)});
            } else if (rankUserBean != null) {
                this.h.setImageResource(R$drawable.icon_rank_head_default);
                Object tag = this.h.getTag();
                if (tag instanceof zq) {
                    ((zq) tag).cancel();
                }
                zq zqVar = null;
                String str = rankUserBean.headPic;
                if (!TextUtils.isEmpty(str)) {
                    a b = a.b();
                    int i4 = this.i;
                    zqVar = b.f(str, i4, i4).g(this.h);
                }
                this.h.setTag(zqVar);
                boolean z = rankUserBean.isCurrentLoginUser;
                View view = this.e;
                if (!z) {
                    i3 = 8;
                }
                view.setVisibility(i3);
                this.d.setText(rankUserBean.nickName);
                this.g.setImageResource(rankUserBean.getMaskDrawableRid());
                this.f.setText(rankUserBean.getRankNum());
                this.c.setText(rankUserBean.countDisplay);
                this.itemView.setOnClickListener(this);
                if (ThemeRankAdapter.this.c != null) {
                    ThemeRankAdapter.this.c.exposeItem(this.itemView, this.a, i2);
                }
            }
        }

        public void onClick(View view) {
            T t;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "692062246")) {
                ipChange.ipc$dispatch("692062246", new Object[]{this, view});
            } else if (ThemeRankAdapter.this.c != null && (t = this.a) != null && t.isValidUser()) {
                ThemeRankAdapter.this.c.onItemClick(this.a, this.b);
            }
        }
    }

    public ThemeRankAdapter(Context context, OnItemBindListener<RankUserBean> onItemBindListener) {
        this.b = context;
        this.c = onItemBindListener;
    }

    /* renamed from: b */
    public void onBindViewHolder(@NonNull RankVh rankVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453867124")) {
            ipChange.ipc$dispatch("-453867124", new Object[]{this, rankVh, Integer.valueOf(i)});
            return;
        }
        rankVh.a(this.a.get(i), i);
    }

    @NonNull
    /* renamed from: c */
    public RankVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "619133866")) {
            return new RankVh(this.b, viewGroup);
        }
        return (RankVh) ipChange.ipc$dispatch("619133866", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public void d(List<RankUserBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88771175")) {
            ipChange.ipc$dispatch("88771175", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239707508")) {
            return ((Integer) ipChange.ipc$dispatch("-239707508", new Object[]{this})).intValue();
        }
        List<RankUserBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
