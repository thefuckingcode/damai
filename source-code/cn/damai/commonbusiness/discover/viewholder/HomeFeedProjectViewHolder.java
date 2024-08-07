package cn.damai.commonbusiness.discover.viewholder;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.IFeedProjectBean;
import cn.damai.commonbusiness.discover.bean.TagBean;
import cn.damai.commonbusiness.discover.bean.WaterFlowRecommendItem;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.k01;
import tb.n42;
import tb.v50;
import tb.xs0;

/* compiled from: Taobao */
public class HomeFeedProjectViewHolder<T> extends BaseViewHolderV2<IFeedProjectBean<T>> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int c;
    private int d;
    private DMPosterView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private TextView j;
    private View k;
    private TextView l;
    private ViewGroup m;
    private View n;
    private View o;
    private OnItemBindListener<IFeedProjectBean<T>> p;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CharSequence a;

        a(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "129333817")) {
                ipChange.ipc$dispatch("129333817", new Object[]{this, dVar});
                return;
            }
            HomeFeedProjectViewHolder.this.f.setText(this.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CharSequence a;

        b(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "999890190")) {
                ipChange.ipc$dispatch("999890190", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                HomeFeedProjectViewHolder.this.f.setText(this.a);
            } else {
                HomeFeedProjectViewHolder.this.j(this.a, bitmap);
            }
        }
    }

    public HomeFeedProjectViewHolder(ViewGroup viewGroup, View view, OnItemBindListener<IFeedProjectBean<T>> onItemBindListener) {
        super(view);
        this.e = (DMPosterView) view.findViewById(R$id.dfp_poster);
        this.f = (TextView) view.findViewById(R$id.dfp_title);
        this.g = (TextView) view.findViewById(R$id.dfp_date);
        this.h = (TextView) view.findViewById(R$id.dfp_rank_tag);
        this.i = view.findViewById(R$id.dfp_rank_tag_ll);
        this.l = (TextView) view.findViewById(R$id.dfp_price);
        this.m = (ViewGroup) view.findViewById(R$id.market_tag_container);
        this.o = view.findViewById(R$id.dfp_price_prefix);
        this.n = view.findViewById(R$id.dfp_price_postfix);
        this.k = view.findViewById(R$id.dfp_price_pending);
        this.j = (TextView) view.findViewById(R$id.dfp_wanna_see_tag);
        int a2 = ((DisplayMetrics.getwidthPixels(n42.b(xs0.a())) - (n42.a(xs0.a(), 21.0f) * 2)) - n42.a(xs0.a(), 12.0f)) / 2;
        this.c = a2;
        this.d = (int) ((((float) a2) * 224.0f) / 168.0f);
        this.p = onItemBindListener;
    }

    private CharSequence g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533471676")) {
            return (CharSequence) ipChange.ipc$dispatch("1533471676", new Object[]{this, str});
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                if (str.contains("【")) {
                    int indexOf = str.indexOf("【");
                    spannableStringBuilder.setSpan(new ImageSpan(xs0.a(), R$drawable.homepage_city_name_left_v2, 1), indexOf, indexOf + 1, 18);
                }
                if (str.contains("】")) {
                    int indexOf2 = str.indexOf("】");
                    spannableStringBuilder.setSpan(new ImageSpan(xs0.a(), R$drawable.homepage_city_name_right_v2, 1), indexOf2, indexOf2 + 1, 18);
                }
                return spannableStringBuilder;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    private void h(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "492660669")) {
            ipChange.ipc$dispatch("492660669", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 1) {
            this.e.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
        } else if (i2 == 2) {
            this.e.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
        } else {
            this.e.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
        }
    }

    private void i(List<TagBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10493101")) {
            ipChange.ipc$dispatch("-10493101", new Object[]{this, list});
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(CharSequence charSequence, Bitmap bitmap) {
        SpannableStringBuilder spannableStringBuilder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501112419")) {
            ipChange.ipc$dispatch("-1501112419", new Object[]{this, charSequence, bitmap});
            return;
        }
        try {
            if (TextUtils.isEmpty(charSequence)) {
                spannableStringBuilder = new SpannableStringBuilder("");
            } else {
                spannableStringBuilder = new SpannableStringBuilder(" " + ((Object) charSequence));
            }
            spannableStringBuilder.insert(0, (CharSequence) "123");
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            int a2 = v50.a(xs0.a(), 16.0f);
            spannableStringBuilder.setSpan(new ImageSpan(xs0.a(), k01.f(bitmap, (width * a2) / height, a2), 1), 0, 3, 18);
            this.f.setText(spannableStringBuilder);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: f */
    public void c(IFeedProjectBean<T> iFeedProjectBean, int i2) {
        T raw;
        MarketTagBean gotTopTag;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1984126131")) {
            ipChange.ipc$dispatch("-1984126131", new Object[]{this, iFeedProjectBean, Integer.valueOf(i2)});
        } else if (iFeedProjectBean != null) {
            String atmospheric = iFeedProjectBean.getAtmospheric();
            CharSequence g2 = g(iFeedProjectBean.getProjectName());
            if (TextUtils.isEmpty(atmospheric)) {
                this.f.setText(g2);
            } else {
                cn.damai.common.image.a.b().h(xs0.a()).c(atmospheric).n(new b(g2)).e(new a(g2)).f();
            }
            this.g.setText(iFeedProjectBean.getProjectDate());
            String rankText = iFeedProjectBean.getRankText();
            if (TextUtils.isEmpty(rankText)) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.h.setText(rankText);
                ((ImageView) this.i.findViewById(R$id.dfp_rank_tag_icon)).setImageResource(R$drawable.home_card_note_tipicon);
            }
            i(iFeedProjectBean.getTagList());
            h(iFeedProjectBean.getLiveStatus());
            this.e.setBorderRadius(0);
            this.e.setBorderVisibility(8);
            RoundImageView imageView = this.e.getImageView();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            imageView.setBorder(0, 0);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.bottomMargin = 0;
                marginLayoutParams.rightMargin = 0;
                imageView.requestLayout();
            }
            this.e.setVideoIconVisibility(iFeedProjectBean.isShowVideoIcon() ? 0 : 8);
            if (iFeedProjectBean.getRaw() instanceof WaterFlowRecommendItem) {
                this.e.setScoreAndCate(iFeedProjectBean.getScoreStar(), iFeedProjectBean.getRaw().getCategoryNameCompat());
            } else {
                this.e.setScoreAndCate(iFeedProjectBean.getScoreStar(), "");
            }
            this.e.setImageUrlForWebp(iFeedProjectBean.getPostPic(), this.c, this.d);
            this.m.removeAllViews();
            this.m.setVisibility(8);
            if (iFeedProjectBean.isPendingPrice()) {
                this.l.setVisibility(8);
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                this.k.setVisibility(0);
            } else {
                this.l.setVisibility(0);
                this.o.setVisibility(0);
                this.n.setVisibility(0);
                this.k.setVisibility(8);
                this.l.setText(iFeedProjectBean.getShowPrice());
                if (!(iFeedProjectBean.getRaw() == null || !(iFeedProjectBean.getRaw() instanceof WaterFlowRecommendItem) || (raw = iFeedProjectBean.getRaw()) == null || (gotTopTag = raw.gotTopTag(true)) == null || TextUtils.isEmpty(gotTopTag.shortTag))) {
                    this.m.setVisibility(0);
                    DMCommonTagView addMarketTagView = gotTopTag.addMarketTagView(this.m, true);
                    addMarketTagView.setImgHeight(v50.a(this.m.getContext(), 29.333334f), v50.a(this.m.getContext(), 12.0f));
                    if (addMarketTagView.getTagView() != null) {
                        addMarketTagView.getTagView().setTextSize(1, 8.0f);
                        addMarketTagView.getTagView().getLayoutParams().height = v50.a(this.m.getContext(), 12.0f);
                    }
                }
            }
            TextView textView = this.j;
            if (!iFeedProjectBean.isShowWannaSeeTag()) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            this.itemView.setOnClickListener(this);
            OnItemBindListener<IFeedProjectBean<T>> onItemBindListener = this.p;
            if (onItemBindListener != null) {
                onItemBindListener.exposeItem(this.itemView, iFeedProjectBean, i2);
            }
        }
    }

    public void onClick(View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800932614")) {
            ipChange.ipc$dispatch("-800932614", new Object[]{this, view});
            return;
        }
        OnItemBindListener<IFeedProjectBean<T>> onItemBindListener = this.p;
        if (onItemBindListener != null && (t = this.a) != null) {
            onItemBindListener.onItemClick(t, this.b);
        }
    }

    public HomeFeedProjectViewHolder(ViewGroup viewGroup, OnItemBindListener<IFeedProjectBean<T>> onItemBindListener) {
        this(viewGroup, LayoutInflater.from(xs0.a()).inflate(R$layout.item_discover_feed_project_home_shell, viewGroup, false), onItemBindListener);
    }
}
