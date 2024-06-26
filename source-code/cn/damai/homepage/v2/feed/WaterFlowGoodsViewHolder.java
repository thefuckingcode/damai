package cn.damai.homepage.v2.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.bricks.view.DMLabelView;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.ew0;
import tb.g91;
import tb.gr;
import tb.gw0;
import tb.jh0;
import tb.k01;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class WaterFlowGoodsViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int imageViewHeight;
    private int imageViewWidth;
    private Context mContext;
    private View mFeedBackBtn;
    private FrameLayout mFeedBackLayer;
    private TextView mGoodsBuyButton;
    private RCRelativeLayoutView mGoodsLayout;
    private DMDigitTextView mGoodsPrice;
    private View mGoodsPriceLayout;
    private TextView mGoodsPriceSuffix;
    private DMDigitTextView mGoodsPriceUnknown;
    private DMCommonTagView mGoodsTagView;
    private View mGoodsTicketLayout;
    private DMDigitTextView mGoodsTicketPrice;
    private LinearLayout mGoodsTicketPriceLayout;
    private TextView mGoodsTime;
    private TextView mGoodsTitle;
    private View.OnClickListener mOnClickListener = new a();
    private DMPosterView mPosterView;
    private TextView mWantSeeView;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1478978567")) {
                ipChange.ipc$dispatch("-1478978567", new Object[]{this, view});
            } else if (view.getId() != R$id.homepage_waterflow_goods_feedback_layer) {
                if (view.getId() == R$id.homepage_waterflow_goods_feedback_btn) {
                    ToastUtil.a().e(WaterFlowGoodsViewHolder.this.mContext, "商品不感兴趣");
                    WaterFlowGoodsViewHolder.this.getData().getComponent().removeItem(WaterFlowGoodsViewHolder.this.getData(), true);
                    return;
                }
                WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
                gw0 i = gw0.i();
                String g = gw0.g(WaterFlowGoodsViewHolder.this.getComponentActions());
                String str = waterFlowRecommendItem.projectId;
                i.m(g, str, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, str, WaterFlowGoodsViewHolder.this.getData().getIndex());
                if ("4".equals(waterFlowRecommendItem.cardType)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("from_page", "homepage");
                    bundle.putString("projectImage", waterFlowRecommendItem.projectPic);
                    bundle.putString("id", waterFlowRecommendItem.projectId);
                    if (xf2.j(waterFlowRecommendItem.schema)) {
                        DMNav.from(WaterFlowGoodsViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(gr.b));
                    } else {
                        DMNav.from(WaterFlowGoodsViewHolder.this.mContext).toUri(waterFlowRecommendItem.schema);
                    }
                } else {
                    DMNav.from(WaterFlowGoodsViewHolder.this.mContext).toUri(waterFlowRecommendItem.schema);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SpannableStringBuilder a;

        b(SpannableStringBuilder spannableStringBuilder) {
            this.a = spannableStringBuilder;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2084312832")) {
                ipChange.ipc$dispatch("2084312832", new Object[]{this, eVar});
                return;
            }
            WaterFlowGoodsViewHolder.this.showAtmospheric(this.a, eVar.b);
        }
    }

    public WaterFlowGoodsViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mFeedBackLayer = (FrameLayout) this.itemView.findViewById(R$id.homepage_waterflow_goods_feedback_layer);
        this.mFeedBackBtn = this.itemView.findViewById(R$id.homepage_waterflow_goods_feedback_btn);
        this.mGoodsLayout = (RCRelativeLayoutView) this.itemView.findViewById(R$id.homepage_waterflow_goods_layout);
        DMPosterView dMPosterView = (DMPosterView) this.itemView.findViewById(R$id.homepage_waterflow_goods_card);
        this.mPosterView = dMPosterView;
        dMPosterView.setPlaceholder(R$drawable.homepage_waterflow_poster_bg);
        this.mPosterView.setVideoIconSize(24.0f, 6.0f);
        this.mPosterView.setCategoryMargin(6.0f, 6.0f);
        DMLabelView labelView = this.mPosterView.getLabelView();
        if (labelView != null) {
            float a2 = (float) v50.a(this.mContext, 12.0f);
            labelView.setCornerRadii(a2, a2, a2, 0.0f);
        }
        this.mGoodsTagView = (DMCommonTagView) this.itemView.findViewById(R$id.homepage_waterflow_goodscard_tag);
        this.mGoodsTitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_title);
        this.mGoodsTime = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_time);
        this.mGoodsPriceLayout = this.itemView.findViewById(R$id.homepage_waterflow_goods_price_layout);
        this.mGoodsPrice = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price);
        DMDigitTextView dMDigitTextView = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price_unknown);
        this.mGoodsPriceUnknown = dMDigitTextView;
        dMDigitTextView.setVisibility(8);
        this.mWantSeeView = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_wantsee);
        this.mGoodsPriceSuffix = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price_suffix);
        this.mGoodsTicketLayout = this.itemView.findViewById(R$id.homepage_waterflow_recommend_goods_ticket);
        this.mGoodsTicketPriceLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_goods_ticket_price_layout);
        this.mGoodsTicketPrice = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_ticket_price);
        this.mGoodsBuyButton = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_buy_btn);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.mFeedBackLayer.setOnClickListener(this.mOnClickListener);
        this.mFeedBackBtn.setOnClickListener(this.mOnClickListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showAtmospheric(SpannableStringBuilder spannableStringBuilder, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416110474")) {
            ipChange.ipc$dispatch("1416110474", new Object[]{this, spannableStringBuilder, bitmap});
            return;
        }
        spannableStringBuilder.insert(0, "123");
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int a2 = v50.a(this.mContext, 16.0f);
        spannableStringBuilder.setSpan(new ImageSpan(this.mContext, k01.f(bitmap, (width * a2) / height, a2), 1), 0, 3, 18);
        this.mGoodsTitle.setText(spannableStringBuilder);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1658115358")) {
            ipChange.ipc$dispatch("1658115358", new Object[]{this, iItem});
            return;
        }
        this.imageViewWidth = jh0.INSTANCE.a(this.itemView.getContext());
        ViewGroup.LayoutParams layoutParams = this.mGoodsLayout.getLayoutParams();
        layoutParams.width = this.imageViewWidth;
        layoutParams.height = -2;
        this.mGoodsLayout.setLayoutParams(layoutParams);
        this.imageViewHeight = (int) ((((float) (this.imageViewWidth * 224)) * 1.0f) / 168.0f);
        handleView((WaterFlowRecommendItem) getValue());
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-268987504")) {
            ipChange.ipc$dispatch("-268987504", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem != null) {
            this.mPosterView.setBorderVisibility(8);
            this.mPosterView.setCategoryTagName(waterFlowRecommendItem.categoryName);
            int i = waterFlowRecommendItem.liveStatus;
            if (i == 0) {
                this.mPosterView.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if (i == 1) {
                this.mPosterView.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if (i == 2) {
                this.mPosterView.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
            }
            if (ew0.a(waterFlowRecommendItem.cardType) == 4) {
                if ("1".equals(waterFlowRecommendItem.tagType)) {
                    this.mPosterView.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_BUY);
                    this.mWantSeeView.setVisibility(8);
                } else if ("2".equals(waterFlowRecommendItem.tagType)) {
                    this.mPosterView.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                    this.mWantSeeView.setVisibility(8);
                } else if ("3".equals(waterFlowRecommendItem.tagType)) {
                    this.mPosterView.setLabelType(null);
                    this.mWantSeeView.setVisibility(0);
                } else if ("4".equals(waterFlowRecommendItem.tagType)) {
                    this.mPosterView.setLabelType(DMLabelType.LABEL_TYPE_NEW_SALE);
                    this.mWantSeeView.setVisibility(8);
                } else {
                    this.mPosterView.setLabelType(null);
                    this.mWantSeeView.setVisibility(8);
                }
            }
            this.mPosterView.setScoreStar(waterFlowRecommendItem.itemScore);
            this.mPosterView.setBorderRadius(0);
            this.mPosterView.setVideoIconVisibility(waterFlowRecommendItem.hasVideo ? 0 : 8);
            this.mPosterView.setImageUrlForWebp(waterFlowRecommendItem.projectPic, this.imageViewWidth, this.imageViewHeight);
            this.itemView.setTag(waterFlowRecommendItem);
            if (TextUtils.isEmpty(waterFlowRecommendItem.projectName)) {
                this.mGoodsTitle.setText("");
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(waterFlowRecommendItem.projectName);
                try {
                    if (!waterFlowRecommendItem.atmospheric) {
                        if (waterFlowRecommendItem.projectName.contains("【")) {
                            int indexOf = waterFlowRecommendItem.projectName.indexOf("【");
                            spannableStringBuilder.setSpan(new ImageSpan(this.mContext, R$drawable.homepage_city_name_left, 1), indexOf, indexOf + 1, 18);
                        }
                        if (waterFlowRecommendItem.projectName.contains("】")) {
                            int indexOf2 = waterFlowRecommendItem.projectName.indexOf("】");
                            spannableStringBuilder.setSpan(new ImageSpan(this.mContext, R$drawable.homepage_city_name_right, 1), indexOf2, indexOf2 + 1, 18);
                        }
                    } else if (!xf2.j(waterFlowRecommendItem.atmosphericPic)) {
                        cn.damai.common.image.a.b().h(this.mContext).c(waterFlowRecommendItem.atmosphericPic).n(new b(spannableStringBuilder)).f();
                    }
                } catch (Exception e) {
                    g91.c("WaterFlowGoodsViewHolder", e.getMessage());
                }
                this.mGoodsTitle.setText(spannableStringBuilder);
            }
            if (ew0.a(waterFlowRecommendItem.cardType) == 4) {
                if (!TextUtils.isEmpty(waterFlowRecommendItem.title)) {
                    this.mGoodsTagView.setTagType(DMTagType.TAG_TYPE_RANK);
                    this.mGoodsTagView.setTagName(waterFlowRecommendItem.title);
                    this.mGoodsTagView.setVisibility(0);
                } else {
                    this.mGoodsTagView.setVisibility(8);
                }
                this.mGoodsPriceLayout.setVisibility(0);
                this.mGoodsTicketLayout.setVisibility(8);
                if (!TextUtils.isEmpty(waterFlowRecommendItem.liveStartTime)) {
                    this.mGoodsTime.setText(waterFlowRecommendItem.liveStartTime);
                } else if (xf2.j(waterFlowRecommendItem.projectDatetime)) {
                    this.mGoodsTime.setText("");
                } else {
                    this.mGoodsTime.setText(waterFlowRecommendItem.projectDatetime);
                }
                if (TextUtils.isEmpty(waterFlowRecommendItem.priceLow) || waterFlowRecommendItem.priceLow.equals("价格待定") || waterFlowRecommendItem.priceLow.equals("待定")) {
                    this.mGoodsPrice.setVisibility(8);
                    this.mGoodsPriceSuffix.setVisibility(8);
                    this.mGoodsPriceUnknown.setVisibility(0);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(String.format("¥%s", waterFlowRecommendItem.priceLow));
                    spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(v50.a(this.mContext, 12.0f)), 0, 1, 0);
                    this.mGoodsPrice.setText(spannableStringBuilder2);
                    this.mGoodsPriceSuffix.setVisibility(0);
                    this.mGoodsPriceUnknown.setVisibility(8);
                }
            } else {
                this.mGoodsTagView.setVisibility(8);
                this.mGoodsPriceLayout.setVisibility(8);
                this.mGoodsPriceUnknown.setVisibility(8);
                this.mGoodsTicketLayout.setVisibility(0);
                if (xf2.j(waterFlowRecommendItem.lotteryDate)) {
                    this.mGoodsTime.setText("");
                } else {
                    this.mGoodsTime.setText(waterFlowRecommendItem.lotteryDate);
                }
                if (!xf2.j(waterFlowRecommendItem.price)) {
                    this.mGoodsTicketPrice.setText(waterFlowRecommendItem.price);
                    DMDigitTextView dMDigitTextView = this.mGoodsTicketPrice;
                    dMDigitTextView.setPaintFlags(dMDigitTextView.getPaintFlags() | 16);
                    this.mGoodsTicketPriceLayout.setVisibility(0);
                } else {
                    this.mGoodsTicketPrice.setText("");
                    this.mGoodsTicketPriceLayout.setVisibility(4);
                }
                if (xf2.j(waterFlowRecommendItem.priceLow)) {
                    this.mGoodsBuyButton.setVisibility(4);
                } else {
                    this.mGoodsBuyButton.setText(waterFlowRecommendItem.priceLow);
                    this.mGoodsBuyButton.setVisibility(0);
                }
            }
            gw0 i2 = gw0.i();
            String g = gw0.g(getComponentActions());
            View view = this.itemView;
            String str = waterFlowRecommendItem.projectId;
            i2.k(g, view, str, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, str, getData().getIndex());
            this.mFeedBackLayer.setVisibility(8);
        }
    }
}
