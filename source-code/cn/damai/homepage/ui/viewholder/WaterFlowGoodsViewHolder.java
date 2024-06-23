package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.homepage.ui.adapter.GuessAdapter;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.bricks.view.DMLabelView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ax0;
import tb.ew0;
import tb.g91;
import tb.gr;
import tb.k01;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class WaterFlowGoodsViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private FrameLayout b;
    private View c;
    private RCRelativeLayoutView d;
    private DMCommonTagView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private DMDigitTextView j;
    private DMDigitTextView k;
    private TextView l;
    private View m;
    private LinearLayout n;
    private DMDigitTextView o;
    private TextView p;
    private String q;
    private int r;
    private int s;
    private DMPosterView t;
    private GuessAdapter u;
    private int v;
    private View.OnClickListener w = new a();
    private View.OnLongClickListener x = new b(this);

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-450551810")) {
                ipChange.ipc$dispatch("-450551810", new Object[]{this, view});
            } else if (view.getId() != R$id.homepage_waterflow_goods_feedback_layer) {
                if (view.getId() == R$id.homepage_waterflow_goods_feedback_btn) {
                    ToastUtil.a().e(WaterFlowGoodsViewHolder.this.a, "商品不感兴趣");
                    WaterFlowGoodsViewHolder.this.u.c(WaterFlowGoodsViewHolder.this.v);
                    return;
                }
                WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
                cn.damai.common.user.c e = cn.damai.common.user.c.e();
                ax0 I = ax0.I();
                String str = WaterFlowGoodsViewHolder.this.q;
                String str2 = waterFlowRecommendItem.projectId;
                e.x(I.M(str, str2, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, str2, waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index, waterFlowRecommendItem.title, waterFlowRecommendItem.schema));
                if ("4".equals(waterFlowRecommendItem.cardType)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("from_page", "homepage");
                    bundle.putString("projectImage", waterFlowRecommendItem.projectPic);
                    bundle.putString("id", waterFlowRecommendItem.projectId);
                    if (xf2.j(waterFlowRecommendItem.schema)) {
                        DMNav.from(WaterFlowGoodsViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(gr.b));
                    } else {
                        DMNav.from(WaterFlowGoodsViewHolder.this.a).toUri(waterFlowRecommendItem.schema);
                    }
                } else {
                    DMNav.from(WaterFlowGoodsViewHolder.this.a).toUri(waterFlowRecommendItem.schema);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(WaterFlowGoodsViewHolder waterFlowGoodsViewHolder) {
        }

        public boolean onLongClick(View view) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "292201191")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("292201191", new Object[]{this, view})).booleanValue();
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SpannableStringBuilder a;

        c(SpannableStringBuilder spannableStringBuilder) {
            this.a = spannableStringBuilder;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-849158778")) {
                ipChange.ipc$dispatch("-849158778", new Object[]{this, eVar});
                return;
            }
            WaterFlowGoodsViewHolder.this.showAtmospheric(this.a, eVar.b);
        }
    }

    public WaterFlowGoodsViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_goodscard, (ViewGroup) null));
        this.q = str;
        this.a = context;
        this.b = (FrameLayout) this.itemView.findViewById(R$id.homepage_waterflow_goods_feedback_layer);
        this.c = this.itemView.findViewById(R$id.homepage_waterflow_goods_feedback_btn);
        this.d = (RCRelativeLayoutView) this.itemView.findViewById(R$id.homepage_waterflow_goods_layout);
        DMPosterView dMPosterView = (DMPosterView) this.itemView.findViewById(R$id.homepage_waterflow_goods_card);
        this.t = dMPosterView;
        dMPosterView.setPlaceholder(R$drawable.homepage_waterflow_poster_bg);
        this.t.setVideoIconSize(24.0f, 6.0f);
        this.t.setCategoryMargin(6.0f, 6.0f);
        DMLabelView labelView = this.t.getLabelView();
        if (labelView != null) {
            float a2 = (float) v50.a(context, 12.0f);
            labelView.setCornerRadii(a2, a2, a2, 0.0f);
        }
        this.e = (DMCommonTagView) this.itemView.findViewById(R$id.homepage_waterflow_goodscard_tag);
        this.g = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_title);
        this.h = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_time);
        this.i = this.itemView.findViewById(R$id.homepage_waterflow_goods_price_layout);
        this.j = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price);
        DMDigitTextView dMDigitTextView = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price_unknown);
        this.k = dMDigitTextView;
        dMDigitTextView.setVisibility(8);
        this.f = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_wantsee);
        this.l = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price_suffix);
        this.m = this.itemView.findViewById(R$id.homepage_waterflow_recommend_goods_ticket);
        this.n = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_goods_ticket_price_layout);
        this.o = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_ticket_price);
        this.p = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_buy_btn);
        this.r = ((DisplayMetrics.getwidthPixels(v50.b(context)) - v50.a(context, 24.0f)) / 2) - v50.a(context, 4.5f);
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.width = this.r;
        layoutParams.height = -2;
        this.d.setLayoutParams(layoutParams);
        this.s = (int) ((((float) (this.r * 224)) * 1.0f) / 168.0f);
        this.itemView.setOnClickListener(this.w);
        this.itemView.setOnLongClickListener(this.x);
        this.b.setOnClickListener(this.w);
        this.c.setOnClickListener(this.w);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showAtmospheric(SpannableStringBuilder spannableStringBuilder, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017111003")) {
            ipChange.ipc$dispatch("-2017111003", new Object[]{this, spannableStringBuilder, bitmap});
            return;
        }
        spannableStringBuilder.insert(0, "123");
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int a2 = v50.a(this.a, 16.0f);
        spannableStringBuilder.setSpan(new ImageSpan(this.a, k01.f(bitmap, (width * a2) / height, a2), 1), 0, 3, 18);
        this.g.setText(spannableStringBuilder);
    }

    public void f(WaterFlowRecommendItem waterFlowRecommendItem, GuessAdapter guessAdapter, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305580730")) {
            ipChange.ipc$dispatch("1305580730", new Object[]{this, waterFlowRecommendItem, guessAdapter, Integer.valueOf(i2)});
        } else if (waterFlowRecommendItem != null) {
            this.u = guessAdapter;
            this.v = i2;
            this.t.setBorderVisibility(8);
            this.t.setCategoryTagName(waterFlowRecommendItem.categoryName);
            int i3 = waterFlowRecommendItem.liveStatus;
            if (i3 == 0) {
                this.t.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if (i3 == 1) {
                this.t.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if (i3 == 2) {
                this.t.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
            }
            if (ew0.a(waterFlowRecommendItem.cardType) == 4) {
                if ("1".equals(waterFlowRecommendItem.tagType)) {
                    this.t.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_BUY);
                    this.f.setVisibility(8);
                } else if ("2".equals(waterFlowRecommendItem.tagType)) {
                    this.t.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                    this.f.setVisibility(8);
                } else if ("3".equals(waterFlowRecommendItem.tagType)) {
                    this.t.setLabelType(null);
                    this.f.setVisibility(0);
                } else if ("4".equals(waterFlowRecommendItem.tagType)) {
                    this.t.setLabelType(DMLabelType.LABEL_TYPE_NEW_SALE);
                    this.f.setVisibility(8);
                } else {
                    this.t.setLabelType(null);
                    this.f.setVisibility(8);
                }
            }
            this.t.setScoreStar(waterFlowRecommendItem.itemScore);
            this.t.setBorderRadius(0);
            this.t.setVideoIconVisibility(waterFlowRecommendItem.hasVideo ? 0 : 8);
            this.t.setImageUrlForWebp(waterFlowRecommendItem.projectPic, this.r, this.s);
            this.itemView.setTag(waterFlowRecommendItem);
            if (TextUtils.isEmpty(waterFlowRecommendItem.projectName)) {
                this.g.setText("");
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(waterFlowRecommendItem.projectName);
                try {
                    if (!waterFlowRecommendItem.atmospheric) {
                        if (waterFlowRecommendItem.projectName.contains("【")) {
                            int indexOf = waterFlowRecommendItem.projectName.indexOf("【");
                            spannableStringBuilder.setSpan(new ImageSpan(this.a, R$drawable.homepage_city_name_left, 1), indexOf, indexOf + 1, 18);
                        }
                        if (waterFlowRecommendItem.projectName.contains("】")) {
                            int indexOf2 = waterFlowRecommendItem.projectName.indexOf("】");
                            spannableStringBuilder.setSpan(new ImageSpan(this.a, R$drawable.homepage_city_name_right, 1), indexOf2, indexOf2 + 1, 18);
                        }
                    } else if (!xf2.j(waterFlowRecommendItem.atmosphericPic)) {
                        cn.damai.common.image.a.b().h(this.a).c(waterFlowRecommendItem.atmosphericPic).n(new c(spannableStringBuilder)).f();
                    }
                } catch (Exception e2) {
                    g91.c("WaterFlowGoodsViewHolder", e2.getMessage());
                }
                this.g.setText(spannableStringBuilder);
            }
            if (ew0.a(waterFlowRecommendItem.cardType) == 4) {
                if (!TextUtils.isEmpty(waterFlowRecommendItem.title)) {
                    this.e.setTagType(DMTagType.TAG_TYPE_RANK);
                    this.e.setTagName(waterFlowRecommendItem.title);
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                }
                this.i.setVisibility(0);
                this.m.setVisibility(8);
                if (!TextUtils.isEmpty(waterFlowRecommendItem.liveStartTime)) {
                    this.h.setText(waterFlowRecommendItem.liveStartTime);
                } else if (xf2.j(waterFlowRecommendItem.projectDatetime)) {
                    this.h.setText("");
                } else {
                    this.h.setText(waterFlowRecommendItem.projectDatetime);
                }
                if (TextUtils.isEmpty(waterFlowRecommendItem.priceLow) || waterFlowRecommendItem.priceLow.equals("价格待定") || waterFlowRecommendItem.priceLow.equals("待定")) {
                    this.j.setVisibility(8);
                    this.l.setVisibility(8);
                    this.k.setVisibility(0);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(String.format("¥%s", waterFlowRecommendItem.priceLow));
                    spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(v50.a(this.a, 12.0f)), 0, 1, 0);
                    this.j.setText(spannableStringBuilder2);
                    this.l.setVisibility(0);
                    this.k.setVisibility(8);
                }
            } else {
                this.e.setVisibility(8);
                this.i.setVisibility(8);
                this.k.setVisibility(8);
                this.m.setVisibility(0);
                if (xf2.j(waterFlowRecommendItem.lotteryDate)) {
                    this.h.setText("");
                } else {
                    this.h.setText(waterFlowRecommendItem.lotteryDate);
                }
                if (!xf2.j(waterFlowRecommendItem.price)) {
                    this.o.setText(waterFlowRecommendItem.price);
                    DMDigitTextView dMDigitTextView = this.o;
                    dMDigitTextView.setPaintFlags(dMDigitTextView.getPaintFlags() | 16);
                    this.n.setVisibility(0);
                } else {
                    this.o.setText("");
                    this.n.setVisibility(4);
                }
                if (xf2.j(waterFlowRecommendItem.priceLow)) {
                    this.p.setVisibility(4);
                } else {
                    this.p.setText(waterFlowRecommendItem.priceLow);
                    this.p.setVisibility(0);
                }
            }
            ax0 I = ax0.I();
            View view = this.itemView;
            String str = this.q;
            String str2 = waterFlowRecommendItem.projectId;
            I.T(view, str, str2, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, str2, waterFlowRecommendItem.index);
            this.b.setVisibility(8);
        }
    }
}
