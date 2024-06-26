package com.alibaba.pictures.bricks.component.home.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.IFeedProjectBean;
import com.alibaba.pictures.bricks.bean.TagBean;
import com.alibaba.pictures.bricks.bean.WaterFlowRecommendItem;
import com.alibaba.pictures.bricks.view.DMPosterView;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.i01;
import tb.rv0;
import tb.sv0;
import tb.u50;

/* compiled from: Taobao */
public class HomeFeedProjectViewHolder<T> extends BaseViewHolderV2<IFeedProjectBean<T>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int b;
    private int c;
    private DMPosterView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private View h;
    private TextView i;
    private View j;
    private TextView k;
    private ViewGroup l;
    private View m;
    private View n;
    private Context o;

    public HomeFeedProjectViewHolder(ViewGroup viewGroup, View view) {
        super(view);
        this.o = view.getContext();
        this.d = (DMPosterView) view.findViewById(R$id.dfp_poster);
        this.e = (TextView) view.findViewById(R$id.dfp_title);
        this.f = (TextView) view.findViewById(R$id.dfp_date);
        this.g = (TextView) view.findViewById(R$id.dfp_rank_tag);
        this.h = view.findViewById(R$id.dfp_rank_tag_ll);
        this.k = (TextView) view.findViewById(R$id.dfp_price);
        this.l = (ViewGroup) view.findViewById(R$id.market_tag_container);
        this.n = view.findViewById(R$id.dfp_price_prefix);
        this.m = view.findViewById(R$id.dfp_price_postfix);
        this.j = view.findViewById(R$id.dfp_price_pending);
        this.i = (TextView) view.findViewById(R$id.dfp_wanna_see_tag);
        u50 u50 = u50.INSTANCE;
        int b2 = ((DisplayMetrics.getwidthPixels(u50.d(this.o)) - (u50.b(this.o, 21) * 2)) - u50.b(this.o, 12)) / 2;
        this.b = b2;
        this.c = (int) ((((float) b2) * 224.0f) / 168.0f);
    }

    private CharSequence f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312867674")) {
            return (CharSequence) ipChange.ipc$dispatch("-312867674", new Object[]{this, str});
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                if (str.contains("【")) {
                    int indexOf = str.indexOf("【");
                    spannableStringBuilder.setSpan(new ImageSpan(this.o, R$drawable.bricks_homepage_city_name_left_v2, 1), indexOf, indexOf + 1, 18);
                }
                if (str.contains("】")) {
                    int indexOf2 = str.indexOf("】");
                    spannableStringBuilder.setSpan(new ImageSpan(this.o, R$drawable.bricks_homepage_city_name_right_v2, 1), indexOf2, indexOf2 + 1, 18);
                }
                return spannableStringBuilder;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(CharSequence charSequence, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926797524")) {
            ipChange.ipc$dispatch("-1926797524", new Object[]{this, charSequence, successEvent});
            return;
        }
        Bitmap bitmap = successEvent.bitmap;
        if (bitmap == null) {
            this.e.setText(charSequence);
        } else {
            k(charSequence, bitmap);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(CharSequence charSequence, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "523408562")) {
            ipChange.ipc$dispatch("523408562", new Object[]{this, charSequence, failEvent});
            return;
        }
        this.e.setText(charSequence);
    }

    private void i(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404429529")) {
            ipChange.ipc$dispatch("-404429529", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 1) {
            this.d.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
        } else if (i2 == 2) {
            this.d.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
        } else {
            this.d.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
        }
    }

    private void j(List<TagBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453154499")) {
            ipChange.ipc$dispatch("-1453154499", new Object[]{this, list});
        }
    }

    private void k(CharSequence charSequence, Bitmap bitmap) {
        SpannableStringBuilder spannableStringBuilder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1817546099")) {
            ipChange.ipc$dispatch("1817546099", new Object[]{this, charSequence, bitmap});
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
            int b2 = u50.INSTANCE.b(this.o, 16);
            spannableStringBuilder.setSpan(new ImageSpan(this.o, i01.d(bitmap, (width * b2) / height, b2), 1), 0, 3, 18);
            this.e.setText(spannableStringBuilder);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: e */
    public void b(IFeedProjectBean<T> iFeedProjectBean, int i2) {
        T raw;
        MarketTagBean gotTopTag;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "754263604")) {
            ipChange.ipc$dispatch("754263604", new Object[]{this, iFeedProjectBean, Integer.valueOf(i2)});
        } else if (iFeedProjectBean != null) {
            String atmospheric = iFeedProjectBean.getAtmospheric();
            CharSequence f2 = f(iFeedProjectBean.getProjectName());
            if (TextUtils.isEmpty(atmospheric)) {
                this.e.setText(f2);
            } else {
                ImageLoaderProviderProxy.getProxy().load(atmospheric, new sv0(this, f2), new rv0(this, f2));
            }
            this.f.setText(iFeedProjectBean.getProjectDate());
            String rankText = iFeedProjectBean.getRankText();
            if (TextUtils.isEmpty(rankText)) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
                this.g.setText(rankText);
                ((ImageView) this.h.findViewById(R$id.dfp_rank_tag_icon)).setImageResource(R$drawable.bricks_home_card_note_tipicon);
            }
            j(iFeedProjectBean.getTagList());
            i(iFeedProjectBean.getLiveStatus());
            this.d.setBorderRadius(0);
            this.d.setBorderVisibility(8);
            RoundImageView imageView = this.d.getImageView();
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
            this.d.setVideoIconVisibility(iFeedProjectBean.isShowVideoIcon() ? 0 : 8);
            if (iFeedProjectBean.getRaw() instanceof WaterFlowRecommendItem) {
                this.d.setScoreAndCate(iFeedProjectBean.getScoreStar(), iFeedProjectBean.getRaw().getCategoryNameCompat());
            } else {
                this.d.setScoreAndCate(iFeedProjectBean.getScoreStar(), "");
            }
            this.d.setImageUrlForWebp(iFeedProjectBean.getPostPic(), this.b, this.c);
            this.l.removeAllViews();
            this.l.setVisibility(8);
            if (iFeedProjectBean.isPendingPrice()) {
                this.k.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.j.setVisibility(0);
            } else {
                this.k.setVisibility(0);
                this.n.setVisibility(0);
                this.m.setVisibility(0);
                this.j.setVisibility(8);
                this.k.setText(iFeedProjectBean.getShowPrice());
                if (!(iFeedProjectBean.getRaw() == null || !(iFeedProjectBean.getRaw() instanceof WaterFlowRecommendItem) || (raw = iFeedProjectBean.getRaw()) == null || (gotTopTag = raw.gotTopTag(true)) == null || TextUtils.isEmpty(gotTopTag.shortTag))) {
                    this.l.setVisibility(0);
                    DMCommonTagView addMarketTagView = gotTopTag.addMarketTagView(this.l, true);
                    if (addMarketTagView.getTagView() != null) {
                        addMarketTagView.getTagView().setTextSize(1, 8.0f);
                        addMarketTagView.getTagView().getLayoutParams().height = u50.INSTANCE.b(this.l.getContext(), 12);
                    }
                }
            }
            TextView textView = this.i;
            if (!iFeedProjectBean.isShowWannaSeeTag()) {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }
}
