package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ax0;
import tb.dt0;
import tb.g91;
import tb.gr;
import tb.tj;
import tb.v50;
import tb.xf2;
import tb.zq;

/* compiled from: Taobao */
public class WaterFlowRankListViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private String h;
    private int i;
    private int j;
    private View.OnClickListener k = new a();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "394112498")) {
                ipChange.ipc$dispatch("394112498", new Object[]{this, view});
                return;
            }
            WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            ax0 I = ax0.I();
            String str = WaterFlowRankListViewHolder.this.h;
            String str2 = waterFlowRecommendItem.projectId;
            String str3 = waterFlowRecommendItem.alg;
            String str4 = waterFlowRecommendItem.scm;
            String str5 = waterFlowRecommendItem.cardType;
            e.x(I.M(str, str2, str3, str4, str5, "5".equals(str5) ? waterFlowRecommendItem.id : waterFlowRecommendItem.detailedListId, waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index, waterFlowRecommendItem.title, waterFlowRecommendItem.schema));
            Bundle bundle = new Bundle();
            if ("5".equals(waterFlowRecommendItem.cardType)) {
                long j = 0;
                try {
                    j = Long.parseLong(waterFlowRecommendItem.id);
                } catch (Exception e2) {
                    g91.b("WaterFlowRankListViewHolder", e2.getMessage());
                }
                bundle.putLong(RankListFragment.KEY_RANK_ID, j);
                DMNav.from(WaterFlowRankListViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(gr.C));
                return;
            }
            bundle.putString("id", waterFlowRecommendItem.detailedListId);
            DMNav.from(WaterFlowRankListViewHolder.this.a).withExtras(bundle).toUri(NavUri.b("detailed_list"));
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1097845925")) {
                ipChange.ipc$dispatch("1097845925", new Object[]{this, dVar});
                return;
            }
            WaterFlowRankListViewHolder.this.b.setImageResource(R$drawable.uikit_default_image_bg_gradient);
            WaterFlowRankListViewHolder.this.render(Color.parseColor("#819ef2"));
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        /* compiled from: Taobao */
        public class a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1247599547")) {
                    ipChange.ipc$dispatch("1247599547", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                WaterFlowRankListViewHolder.this.render(i);
            }
        }

        c(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-772870534")) {
                ipChange.ipc$dispatch("-772870534", new Object[]{this, eVar});
                return;
            }
            WaterFlowRankListViewHolder.this.b.setImageDrawable(eVar.a);
            Bitmap bitmap = eVar.b;
            if (bitmap != null) {
                DMRGBUtil.h(bitmap, this.a, new a());
            }
        }
    }

    public WaterFlowRankListViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_ranklist, (ViewGroup) null));
        this.h = str;
        this.a = context;
        RCRelativeLayoutView rCRelativeLayoutView = (RCRelativeLayoutView) this.itemView.findViewById(R$id.homepage_waterflow_rank_image_layout);
        this.b = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_rank_image);
        this.c = (ImageView) this.itemView.findViewById(R$id.homepage_water_flow_rank_gradient);
        this.d = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_recommend_ranklist_tag_img);
        this.e = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_type);
        this.f = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_title);
        this.g = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_subtitle);
        int a2 = (DisplayMetrics.getwidthPixels(v50.b(context)) - v50.a(context, 24.0f)) / 2;
        this.i = a2;
        this.j = (int) ((((float) (a2 * 393)) * 1.0f) / 342.0f);
        ViewGroup.LayoutParams layoutParams = rCRelativeLayoutView.getLayoutParams();
        layoutParams.width = this.i;
        layoutParams.height = this.j;
        rCRelativeLayoutView.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.j + v50.a(context, 9.0f)));
        this.itemView.setOnClickListener(this.k);
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52955191")) {
            ipChange.ipc$dispatch("52955191", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem != null) {
            this.itemView.setTag(waterFlowRecommendItem);
            if (this.b.getTag() instanceof zq) {
                ((zq) this.b.getTag()).cancel();
            }
            String str = "5".equals(waterFlowRecommendItem.cardType) ? waterFlowRecommendItem.pic : waterFlowRecommendItem.backgroundPic;
            this.b.setTag(cn.damai.common.image.a.b().f(str, this.i, this.j).n(new c(str)).e(new b()).f());
            this.d.setVisibility("5".equals(waterFlowRecommendItem.cardType) ? 0 : 8);
            if (xf2.j(waterFlowRecommendItem.title)) {
                this.f.setVisibility(4);
            } else {
                this.f.setVisibility(0);
                this.f.setText(waterFlowRecommendItem.title);
            }
            if (xf2.j(waterFlowRecommendItem.subTitle)) {
                this.g.setVisibility(4);
            } else {
                this.g.setVisibility(0);
                this.g.setText(waterFlowRecommendItem.subTitle);
            }
            if ("5".equals(waterFlowRecommendItem.cardType)) {
                this.e.setBackground(this.a.getResources().getDrawable(R$drawable.feed_card_rank_bang));
            } else {
                this.e.setBackground(this.a.getResources().getDrawable(R$drawable.feed_card_rank_mai));
            }
            ax0 I = ax0.I();
            View view = this.itemView;
            String str2 = this.h;
            String str3 = waterFlowRecommendItem.projectId;
            String str4 = waterFlowRecommendItem.alg;
            String str5 = waterFlowRecommendItem.scm;
            String str6 = waterFlowRecommendItem.cardType;
            I.T(view, str2, str3, str4, str5, str6, "5".equals(str6) ? waterFlowRecommendItem.id : waterFlowRecommendItem.detailedListId, waterFlowRecommendItem.index);
        }
    }

    public void render(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469808539")) {
            ipChange.ipc$dispatch("-1469808539", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        dt0.b(this.c, GradientDrawable.Orientation.TOP_BOTTOM, 0.0f, new int[]{tj.c(1.0f, i2), tj.c(0.8f, i2), tj.c(0.4f, i2), tj.c(0.0f, i2), tj.c(0.0f, i2)});
    }
}
