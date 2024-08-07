package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.pictures.bricks.component.project.bean.RankingListBean;
import com.alibaba.pictures.bricks.view.DMLabelView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.c62;
import tb.s50;
import tb.tb2;
import tb.xf2;

/* compiled from: Taobao */
public class WaterFlowRecommendGoodsCardViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private DMPosterView b;
    private TextView c;
    private TextView d;
    private DMCommonTagView e;
    private View f;
    private DMDigitTextView g;
    private TextView h;
    private TextView i;
    private int j;
    private int k;
    private String l;
    private int m;
    private int n;
    private View.OnClickListener o = new a();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-98968788")) {
                ipChange.ipc$dispatch("-98968788", new Object[]{this, view});
                return;
            }
            ProjectItemBean projectItemBean = (ProjectItemBean) view.getTag();
            if (projectItemBean != null) {
                c.e().x(c62.C().u(WaterFlowRecommendGoodsCardViewHolder.this.l, projectItemBean.id, null, WaterFlowRecommendGoodsCardViewHolder.this.m, WaterFlowRecommendGoodsCardViewHolder.this.n, projectItemBean.alg));
                tb2.b(WaterFlowRecommendGoodsCardViewHolder.this.a, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
            }
        }
    }

    public WaterFlowRecommendGoodsCardViewHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.waterflow_recommend_goodscard, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = context;
        if (context != null) {
            int a2 = (DisplayMetrics.getwidthPixels(s50.b(context)) - s50.a(context, 54.0f)) / 2;
            this.j = a2;
            this.k = (int) ((((float) (a2 * 224)) * 1.0f) / 168.0f);
        }
        e();
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883830215")) {
            ipChange.ipc$dispatch("-883830215", new Object[]{this});
            return;
        }
        DMPosterView dMPosterView = (DMPosterView) this.itemView.findViewById(R$id.recommend_goods_card);
        this.b = dMPosterView;
        dMPosterView.setPlaceholder(R$drawable.homepage_waterflow_poster_bg);
        this.b.setVideoIconSize(24.0f, 6.0f);
        this.b.setCategoryMargin(6.0f, 6.0f);
        DMLabelView labelView = this.b.getLabelView();
        if (labelView != null) {
            float a2 = (float) s50.a(this.a, 12.0f);
            labelView.setCornerRadii(a2, a2, a2, 0.0f);
        }
        this.c = (TextView) this.itemView.findViewById(R$id.recommend_goods_title);
        this.d = (TextView) this.itemView.findViewById(R$id.recommend_goods_time);
        this.e = (DMCommonTagView) this.itemView.findViewById(R$id.recommend_goodscard_tag);
        this.f = this.itemView.findViewById(R$id.recommend_goods_price_layout);
        this.g = (DMDigitTextView) this.itemView.findViewById(R$id.recommend_goods_price);
        this.h = (TextView) this.itemView.findViewById(R$id.recommend_goods_price_suffix);
        TextView textView = (TextView) this.itemView.findViewById(R$id.recommend_wantsee);
        this.i = textView;
        textView.setVisibility(8);
        this.itemView.setOnClickListener(this.o);
    }

    public void f(ProjectItemBean projectItemBean, String str, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939051952")) {
            ipChange.ipc$dispatch("-1939051952", new Object[]{this, projectItemBean, str, Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (projectItemBean != null) {
            this.l = str;
            this.m = i2;
            this.n = i3;
            this.b.setBorderVisibility(8);
            this.b.setCategoryTagName(projectItemBean.categoryName);
            this.b.setScoreStar(projectItemBean.itemScore);
            this.b.setBorderRadius(0);
            this.b.setVideoIconVisibility(projectItemBean.hasVideo() ? 0 : 8);
            this.b.setImageUrlForWebp(projectItemBean.verticalPic, this.j, this.k);
            this.itemView.setTag(projectItemBean);
            if (TextUtils.isEmpty(projectItemBean.name)) {
                this.c.setText("");
            } else if (TextUtils.isEmpty(projectItemBean.cityName)) {
                this.c.setText(projectItemBean.name);
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("【" + projectItemBean.cityName + "】" + projectItemBean.name);
                try {
                    if (projectItemBean.name.contains("【")) {
                        int indexOf = projectItemBean.name.indexOf("【");
                        spannableStringBuilder.setSpan(new ImageSpan(this.a, R$drawable.recommend_city_name_left, 1), indexOf, indexOf + 1, 18);
                    }
                    if (projectItemBean.name.contains("】")) {
                        int indexOf2 = projectItemBean.name.indexOf("】");
                        spannableStringBuilder.setSpan(new ImageSpan(this.a, R$drawable.recommend_city_name_right, 1), indexOf2, indexOf2 + 1, 18);
                    }
                } catch (Exception unused) {
                }
                this.c.setText(spannableStringBuilder);
            }
            if (xf2.j(projectItemBean.showTime)) {
                this.d.setText("");
            } else {
                this.d.setText(projectItemBean.showTime);
            }
            RankingListBean rankingListBean = projectItemBean.rankingList;
            if (rankingListBean == null || TextUtils.isEmpty(rankingListBean.title)) {
                this.e.setVisibility(8);
            } else {
                this.e.setTagType(DMTagType.TAG_TYPE_RANK);
                this.e.setTagName(projectItemBean.rankingList.title);
                this.e.setVisibility(0);
            }
            this.f.setVisibility(0);
            if (!xf2.j(projectItemBean.priceLow)) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(String.format("¥%s", projectItemBean.priceLow));
                spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(s50.a(this.a, 12.0f)), 0, 1, 0);
                this.g.setText(spannableStringBuilder2);
                this.h.setVisibility(0);
                if (projectItemBean.isFollowStatus()) {
                    this.i.setVisibility(0);
                } else {
                    this.i.setVisibility(8);
                }
            } else {
                this.g.setText("");
                this.h.setVisibility(8);
            }
        }
    }
}
