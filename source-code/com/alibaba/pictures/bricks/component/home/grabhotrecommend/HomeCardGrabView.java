package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$dimen;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.HomeGrabHotBean;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotContract;
import com.alibaba.pictures.bricks.view.DMCountDownView;
import com.alibaba.pictures.bricks.view.DMDigitTextView;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import tb.iy0;
import tb.k21;
import tb.ov0;
import tb.pv0;
import tb.qv0;
import tb.u50;
import tb.wf2;
import tb.wr;

/* compiled from: Taobao */
public class HomeCardGrabView extends AbsView<GenericItem<ItemValue>, HomeGrabHotModel, HomeGrabHotPresent> implements HomeGrabHotContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final RoundImageView artistImage;
    private final TextView artistName;
    private final View artistPicView;
    @NotNull
    private final String fontName = "URWDIN-Medium";
    private final int gap = 1;
    @NotNull
    private final View itemView;
    private int pointSize = 20;
    private final DMDigitTextView price;
    private final TextView priceLabel;
    private final TextView priceUnit;
    private final RoundImageView projectImage;
    private final RoundImageView projectImageCover;
    private final LinearLayout rightBottomView;
    private final ViewGroup rightView;
    private final ViewGroup rlGrabView;
    private final TextView rlGrabViewTv;
    private final FrameLayout rlLabelTags;
    @NotNull
    private final String separatorText = ":";
    private final int smallTextBgWidth = 12;
    private final TextView subtitle;
    private final int textBgCornerRadius;
    @NotNull
    private String textColor = "#FFFFFFFF";
    private final int textMarginBottom;
    private int textMarginLeft;
    private int textMarginRight;
    private final int textMarginTop;
    private final TextView title;
    private final TextView wanneSeetitle;

    /* compiled from: Taobao */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;
        final /* synthetic */ DMCountDownView b;

        a(long j, DMCountDownView dMCountDownView) {
            this.a = j;
            this.b = dMCountDownView;
        }

        public void onViewAttachedToWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1826793972")) {
                ipChange.ipc$dispatch("1826793972", new Object[]{this, view});
                return;
            }
            k21.i(view, "v");
            long j = this.a;
            TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
            long g = (j - timeSyncer.g()) / ((long) 1000);
            if (g <= 0) {
                this.b.stopCountDown();
            } else {
                this.b.setCountTime(g).startCountDown();
            }
            Log.e("subTitleView", this.b.getId() + " onViewAttachedToWindow newTime : " + g + " , server: " + timeSyncer + ".currentServerTime/1000");
        }

        public void onViewDetachedFromWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-969113231")) {
                ipChange.ipc$dispatch("-969113231", new Object[]{this, view});
                return;
            }
            k21.i(view, "v");
            this.b.pauseCountDown();
            Log.e("subTitleView", this.b.getId() + " onViewDetachedFromWindow , countDownView.timeStamp");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeCardGrabView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.projectImage = (RoundImageView) view.findViewById(R$id.bricks_grab_hot_image);
        this.projectImageCover = (RoundImageView) view.findViewById(R$id.bricks_grab_hot_image_cover);
        this.artistImage = (RoundImageView) view.findViewById(R$id.bricks_grab_hot_image_artistpic);
        this.artistName = (TextView) view.findViewById(R$id.bricks_grab_hot_image_name);
        this.artistPicView = view.findViewById(R$id.bricks_grab_hot_image_artist);
        this.title = (TextView) view.findViewById(R$id.bricks_grab_hot_title);
        this.subtitle = (TextView) view.findViewById(R$id.bricks_grab_hot_subtitle);
        this.wanneSeetitle = (TextView) view.findViewById(R$id.bricks_grab_hot_title_subtitle);
        this.priceUnit = (TextView) view.findViewById(R$id.bricks_grab_hot_title_price_flag);
        this.price = (DMDigitTextView) view.findViewById(R$id.bricks_grab_hot_title_item_price);
        this.priceLabel = (TextView) view.findViewById(R$id.bricks_grab_hot_title_price_label);
        this.rlGrabView = (ViewGroup) view.findViewById(R$id.bricks_grab_hot_title_grab_view);
        this.rlGrabViewTv = (TextView) view.findViewById(R$id.bricks_grab_hot_title_grab_tv);
        this.rlLabelTags = (FrameLayout) view.findViewById(R$id.bricks_grab_hot_title_tags);
        this.rightView = (ViewGroup) view.findViewById(R$id.bricks_grab_hot_right);
        this.rightBottomView = (LinearLayout) view.findViewById(R$id.bricks_grab_hot_price_layout);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m122bindView$lambda0(HomeGrabHotBean homeGrabHotBean, HomeCardGrabView homeCardGrabView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115772020")) {
            ipChange.ipc$dispatch("115772020", new Object[]{homeGrabHotBean, homeCardGrabView, successEvent});
            return;
        }
        k21.i(homeGrabHotBean, "$bean");
        k21.i(homeCardGrabView, "this$0");
        if ((successEvent != null ? successEvent.drawable : null) == null) {
            homeCardGrabView.projectImage.setImageResource(R$drawable.bricks_uikit_default_image_bg_gradient_radius3);
        } else if (homeGrabHotBean.isArtist()) {
            homeCardGrabView.artistImage.setImageDrawable(successEvent.drawable);
            homeCardGrabView.artistImage.setBorder(1.0f, Color.parseColor("#FFffff"));
            homeCardGrabView.artistPicView.setVisibility(0);
            homeCardGrabView.projectImage.setVisibility(8);
            homeCardGrabView.projectImageCover.setVisibility(8);
        } else {
            homeCardGrabView.projectImage.setImageDrawable(successEvent.drawable);
            homeCardGrabView.projectImage.setVisibility(0);
            homeCardGrabView.projectImageCover.setVisibility(0);
            homeCardGrabView.artistPicView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-1  reason: not valid java name */
    public static final void m123bindView$lambda1(HomeCardGrabView homeCardGrabView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310205118")) {
            ipChange.ipc$dispatch("-310205118", new Object[]{homeCardGrabView, failEvent});
            return;
        }
        k21.i(homeCardGrabView, "this$0");
        homeCardGrabView.projectImage.setImageResource(R$drawable.bricks_uikit_default_image_bg_gradient_radius3);
    }

    private final void countdownfinish(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "554057655")) {
            ipChange.ipc$dispatch("554057655", new Object[]{this, textView, str});
            return;
        }
        this.wanneSeetitle.setVisibility(4);
        textView.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("火爆热抢中");
        }
    }

    private final SpannableString getBoldSpanString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946208631")) {
            return (SpannableString) ipChange.ipc$dispatch("-1946208631", new Object[]{this, str});
        }
        String valueOf = String.valueOf(str);
        SpannableString spannableString = new SpannableString(valueOf);
        spannableString.setSpan(new StyleSpan(1), 0, valueOf.length(), 33);
        return spannableString;
    }

    private final SpannableString getSpanString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-692640550")) {
            return (SpannableString) ipChange.ipc$dispatch("-692640550", new Object[]{this, str, str2});
        }
        String str3 = str + str2;
        SpannableString spannableString = new SpannableString(str3);
        u50 u50 = u50.INSTANCE;
        Context context = this.itemView.getContext();
        k21.h(context, "itemView.context");
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(u50.b(context, 10));
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#2e333e"));
        StyleSpan styleSpan = new StyleSpan(1);
        Context context2 = this.itemView.getContext();
        k21.h(context2, "itemView.context");
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(u50.b(context2, 8));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Color.parseColor("#1A2e333e"));
        spannableString.setSpan(styleSpan, 0, str3.length() - str2.length(), 33);
        spannableString.setSpan(absoluteSizeSpan, str3.length() - str2.length(), str3.length(), 33);
        spannableString.setSpan(foregroundColorSpan, str3.length() - str2.length(), str3.length(), 33);
        spannableString.setSpan(absoluteSizeSpan2, str3.length() - str2.length(), (str3.length() - str2.length()) + 2, 33);
        spannableString.setSpan(foregroundColorSpan2, str3.length() - str2.length(), (str3.length() - str2.length()) + 2, 33);
        return spannableString;
    }

    private final boolean onCountDownView(String str, Context context, ViewGroup viewGroup, TextView textView, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444233831")) {
            return ((Boolean) ipChange.ipc$dispatch("-444233831", new Object[]{this, str, context, viewGroup, textView, str2})).booleanValue();
        }
        this.pointSize = context.getResources().getDimensionPixelSize(R$dimen.font_Footnote2_M);
        DMCountDownView dMCountDownView = new DMCountDownView(context);
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 1) {
                viewGroup.removeViewAt(0);
            } else {
                viewGroup.addView(dMCountDownView, 0);
            }
        }
        long b = wr.b(str);
        TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
        if (timeSyncer.g() > b || timeSyncer.g() <= 0) {
            dMCountDownView.setVisibility(8);
            countdownfinish(textView, str2);
            return true;
        }
        long g = (b - timeSyncer.g()) / ((long) 1000);
        Log.e("countdown", " start: " + b + ", server: " + timeSyncer + ".currentServerTime/1000, counttime " + g + ' ');
        if (g == dMCountDownView.getCountTime() || g <= 0) {
            return true;
        }
        u50 u50 = u50.INSTANCE;
        int b2 = u50.b(context, this.smallTextBgWidth);
        int b3 = this.pointSize + this.textMarginTop + this.textMarginBottom + u50.b(context, 6);
        this.textMarginLeft = 0;
        this.textMarginRight = 0;
        dMCountDownView.setCountDownEndListener(new ov0(viewGroup, this, textView, str2));
        Log.e("subTitleView", "countTime init : " + g);
        DMCountDownView hourTvTextColor = dMCountDownView.setCountTime(g).showDayTv(true).setHourTvBackgroundColorWithRadius(0, this.textBgCornerRadius).setHourTvTextColor(this.textColor);
        DMCountDownView.CountDownViewGravity countDownViewGravity = DMCountDownView.CountDownViewGravity.GRAVITY_CENTER;
        DMCountDownView hourTvSize = hourTvTextColor.setHourTvGravity(countDownViewGravity).setHourTvPadding(this.textMarginLeft, this.textMarginTop, this.textMarginRight, this.textMarginBottom).setHourTvTextSize((float) u50.h(context, this.pointSize)).setHourTvSize(0, b3);
        int i = this.gap;
        DMCountDownView minuteTvSize = hourTvSize.setHourColonTvPadding(i, 0, i, i * 2).setHourColonTvTextColor(this.textColor).setHourColonTvGravity(countDownViewGravity).setHourColonTvText(this.separatorText).setHourColonTvTextSize((float) u50.h(context, this.pointSize)).setMinuteTvBackgroundColorWidthRadius(0, this.textBgCornerRadius).setMinuteTvTextColor(this.textColor).setMinuteTvGravity(countDownViewGravity).setMinuteTvPadding(this.textMarginLeft, this.textMarginTop, this.textMarginRight, this.textMarginBottom).setMinuteTvTextSize((float) u50.h(context, this.pointSize)).setMinuteTvSize(b2, b3);
        int i2 = this.gap;
        minuteTvSize.setMinuteColonTvPadding(i2, 0, i2, i2 * 2).setMinuteColonTvTextColor(this.textColor).setMinuteColonTvGravity(countDownViewGravity).setMinuteColonTvTextSize((float) u50.h(context, this.pointSize)).setSecondTvBackgroundColorWidthRadius(0, this.textBgCornerRadius).setSecondTvTextColor(this.textColor).setSecondTvGravity(countDownViewGravity).setSecondTvPadding(this.textMarginLeft, this.textMarginTop, this.textMarginRight, this.textMarginBottom).setSecondTvTextSize((float) u50.h(context, this.pointSize)).setSecondTvSize(b2, b3).setTimeTvFontName(this.fontName).startCountDown();
        if (viewGroup == null) {
            return true;
        }
        viewGroup.addOnAttachStateChangeListener(new a(b, dMCountDownView));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCountDownView$lambda-6  reason: not valid java name */
    public static final void m124onCountDownView$lambda6(ViewGroup viewGroup, HomeCardGrabView homeCardGrabView, TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361498136")) {
            ipChange.ipc$dispatch("-1361498136", new Object[]{viewGroup, homeCardGrabView, textView, str});
            return;
        }
        k21.i(homeCardGrabView, "this$0");
        k21.i(textView, "$tvDesc");
        Integer valueOf = viewGroup != null ? Integer.valueOf(viewGroup.getChildCount()) : null;
        k21.f(valueOf);
        if (valueOf.intValue() > 1) {
            viewGroup.removeViewAt(0);
        }
        homeCardGrabView.countdownfinish(textView, str);
    }

    private final int testTextWidth(String str, TextView textView, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1668060176")) {
            return ((Integer) ipChange.ipc$dispatch("-1668060176", new Object[]{this, str, textView, Integer.valueOf(i)})).intValue();
        }
        int measureText = (int) textView.getPaint().measureText(str);
        if (measureText % i <= 0) {
            i2 = 0;
        }
        return (measureText / i) + i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02cb  */
    @Override // com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotContract.View
    public void bindView(@NotNull HomeGrabHotBean homeGrabHotBean, int i) {
        TextView textView;
        String str;
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062253026")) {
            ipChange.ipc$dispatch("-2062253026", new Object[]{this, homeGrabHotBean, Integer.valueOf(i)});
            return;
        }
        k21.i(homeGrabHotBean, "bean");
        if (homeGrabHotBean.isArtist()) {
            String str2 = homeGrabHotBean.artistName;
            if (!(str2 == null || str2.length() == 0)) {
                this.artistName.setText(homeGrabHotBean.artistName);
                this.artistName.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.rightView.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    u50 u50 = u50.INSTANCE;
                    Context context = this.itemView.getContext();
                    k21.h(context, "itemView.context");
                    marginLayoutParams.leftMargin = u50.a(context, 0.0f);
                }
                ViewGroup.LayoutParams layoutParams2 = this.rightBottomView.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                if (marginLayoutParams2 != null) {
                    u50 u502 = u50.INSTANCE;
                    Context context2 = this.itemView.getContext();
                    k21.h(context2, "itemView.context");
                    marginLayoutParams2.leftMargin = u502.a(context2, 3.0f);
                }
                String str3 = homeGrabHotBean.verticalPic;
                u50 u503 = u50.INSTANCE;
                Context context3 = this.itemView.getContext();
                k21.h(context3, "itemView.context");
                int b = u503.b(context3, 49);
                Context context4 = this.itemView.getContext();
                k21.h(context4, "itemView.context");
                String c = com.alibaba.pictures.bricks.util.a.c(str3, b, u503.b(context4, 66));
                k21.h(c, "getImageUrl(\n           …px(itemView.context, 66))");
                this.projectImage.setVisibility(0);
                this.projectImageCover.setVisibility(0);
                this.artistPicView.setVisibility(8);
                ImageLoaderProviderProxy.getProxy().load(c, new qv0(homeGrabHotBean, this), new pv0(this));
                if (!isGrabHotProject()) {
                    if (!TextUtils.isEmpty(homeGrabHotBean.wantCountDesc)) {
                        String str4 = homeGrabHotBean.wantCountDesc;
                        wf2 wf2 = wf2.INSTANCE;
                        k21.h(str4, "str");
                        String i2 = wf2.i(str4, "11", "#ff4886", "10", "#2e333e");
                        this.wanneSeetitle.setVisibility(0);
                        this.wanneSeetitle.setText(Html.fromHtml(i2, null, new iy0("dmtag", this.itemView.getContext())));
                    } else {
                        this.wanneSeetitle.setVisibility(4);
                    }
                    DMDigitTextView dMDigitTextView = this.price;
                    if (dMDigitTextView != null) {
                        dMDigitTextView.setVisibility(8);
                    }
                    TextView textView2 = this.priceLabel;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    TextView textView3 = this.priceUnit;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    this.rlGrabView.setVisibility(0);
                    this.rlLabelTags.setVisibility(8);
                    ViewGroup viewGroup = this.rlGrabView;
                    if (viewGroup != null && viewGroup.getChildCount() > 1) {
                        viewGroup.removeViewAt(0);
                    }
                    if (!TextUtils.isEmpty(homeGrabHotBean.upTime)) {
                        this.rlGrabViewTv.setVisibility(8);
                        String str5 = homeGrabHotBean.upTime;
                        k21.h(str5, "bean.upTime");
                        Context context5 = this.itemView.getContext();
                        k21.h(context5, "itemView.context");
                        ViewGroup viewGroup2 = this.rlGrabView;
                        TextView textView4 = this.rlGrabViewTv;
                        k21.h(textView4, "rlGrabViewTv");
                        if (onCountDownView(str5, context5, viewGroup2, textView4, homeGrabHotBean.hotProjectSubTitle)) {
                            this.rlGrabView.setBackgroundDrawable(this.itemView.getContext().getDrawable(R$drawable.bricks_grabhot_project_btn));
                            this.rlGrabView.setVisibility(0);
                        } else {
                            this.rlGrabView.setVisibility(4);
                        }
                        if (((HomeGrabHotPresent) getPresenter()).isDegrade()) {
                            this.rlGrabView.setVisibility(0);
                            this.rlGrabViewTv.setVisibility(8);
                            if (this.rlGrabView.getChildCount() > 1) {
                                this.rlGrabView.removeViewAt(0);
                            }
                            this.rlGrabView.setBackgroundDrawable(this.itemView.getContext().getDrawable(R$drawable.bricks_grabhot_project_short_btn));
                            this.wanneSeetitle.setVisibility(4);
                        }
                    } else {
                        this.rlGrabViewTv.setVisibility(0);
                        this.rlGrabViewTv.setText(homeGrabHotBean.hotProjectSubTitle);
                    }
                } else {
                    this.wanneSeetitle.setVisibility(4);
                    if (TextUtils.isEmpty(homeGrabHotBean.priceLow) || homeGrabHotBean.priceLow.equals("价格待定") || homeGrabHotBean.priceLow.equals("待定")) {
                        this.price.setText("价格待定");
                        this.price.setTextSize(1, 10.0f);
                        TextView textView5 = this.priceLabel;
                        if (textView5 != null) {
                            textView5.setVisibility(8);
                        }
                        TextView textView6 = this.priceUnit;
                        if (textView6 != null) {
                            textView6.setVisibility(8);
                        }
                    } else {
                        this.price.setText(homeGrabHotBean.priceLow);
                        this.price.setTextSize(1, 13.0f);
                        TextView textView7 = this.priceLabel;
                        if (textView7 != null) {
                            textView7.setVisibility(0);
                        }
                        TextView textView8 = this.priceUnit;
                        if (textView8 != null) {
                            textView8.setVisibility(0);
                        }
                    }
                    this.rlLabelTags.removeAllViews();
                    this.rlGrabView.setVisibility(8);
                    if (homeGrabHotBean.gotTopTag() != null) {
                        this.rlLabelTags.setVisibility(0);
                        homeGrabHotBean.gotTopTag().addMarketTagView(this.rlLabelTags, true, false);
                    } else {
                        this.rlLabelTags.setVisibility(8);
                    }
                }
                textView = this.title;
                Context context6 = this.itemView.getContext();
                k21.h(context6, "itemView.context");
                int b2 = u503.b(context6, 105);
                if (i > 0) {
                    Context context7 = this.itemView.getContext();
                    k21.h(context7, "itemView.context");
                    b2 = i - u503.b(context7, 75);
                }
                str = homeGrabHotBean.artistName;
                if (!(str != null || str.length() == 0) || homeGrabHotBean.isArtist()) {
                    String str6 = homeGrabHotBean.name;
                    k21.h(str6, "bean.name");
                    textView.setText(getBoldSpanString(str6));
                }
                String str7 = homeGrabHotBean.name;
                k21.h(textView, "this");
                if (testTextWidth(str7, textView, b2) == 1) {
                    this.subtitle.setVisibility(0);
                    this.subtitle.setText(homeGrabHotBean.artistName);
                    String str8 = homeGrabHotBean.name;
                    k21.h(str8, "bean.name");
                    textView.setText(getBoldSpanString(str8));
                    return;
                }
                String str9 = homeGrabHotBean.name;
                String sb = new StringBuilder(str9).toString();
                k21.h(sb, "StringBuilder(originText).toString()");
                String str10 = " | " + homeGrabHotBean.artistName;
                if (testTextWidth(homeGrabHotBean.name + " | " + homeGrabHotBean.artistName + ' ', textView, b2) <= 2) {
                    textView.setText(getSpanString(sb, str10));
                    return;
                }
                int measureText = (int) textView.getPaint().measureText(homeGrabHotBean.artistName);
                Context context8 = textView.getContext();
                k21.h(context8, WPKFactory.INIT_KEY_CONTEXT);
                if (measureText > u503.b(context8, 48)) {
                    String str11 = homeGrabHotBean.artistName;
                    while (true) {
                        int measureText2 = (int) textView.getPaint().measureText(str11);
                        u50 u504 = u50.INSTANCE;
                        Context context9 = textView.getContext();
                        k21.h(context9, WPKFactory.INIT_KEY_CONTEXT);
                        if (measureText2 <= u504.b(context9, 48)) {
                            break;
                        }
                        k21.h(str11, "tempName");
                        str11 = str11.substring(0, str11.length() - 1);
                        k21.h(str11, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    str10 = " | " + str11 + "...";
                }
                int testTextWidth = testTextWidth(str9 + "..." + str10, textView, b2);
                while (testTextWidth > textView.getMaxLines() && (length = sb.length() - 1) != -1) {
                    sb = sb.substring(0, length);
                    k21.h(sb, "this as java.lang.String…ing(startIndex, endIndex)");
                    testTextWidth = testTextWidth(sb + "..." + str10, textView, b2);
                }
                textView.setText(getSpanString(sb + "...", str10));
                return;
            }
        }
        this.artistName.setVisibility(4);
        ViewGroup.LayoutParams layoutParams3 = this.rightView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
        if (marginLayoutParams3 != null) {
            u50 u505 = u50.INSTANCE;
            Context context10 = this.itemView.getContext();
            k21.h(context10, "itemView.context");
            marginLayoutParams3.leftMargin = u505.a(context10, 5.0f);
        }
        ViewGroup.LayoutParams layoutParams4 = this.rightBottomView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
        if (marginLayoutParams4 != null) {
            u50 u506 = u50.INSTANCE;
            Context context11 = this.itemView.getContext();
            k21.h(context11, "itemView.context");
            marginLayoutParams4.leftMargin = u506.a(context11, 0.0f);
        }
        String str32 = homeGrabHotBean.verticalPic;
        u50 u5032 = u50.INSTANCE;
        Context context32 = this.itemView.getContext();
        k21.h(context32, "itemView.context");
        int b3 = u5032.b(context32, 49);
        Context context42 = this.itemView.getContext();
        k21.h(context42, "itemView.context");
        String c2 = com.alibaba.pictures.bricks.util.a.c(str32, b3, u5032.b(context42, 66));
        k21.h(c2, "getImageUrl(\n           …px(itemView.context, 66))");
        this.projectImage.setVisibility(0);
        this.projectImageCover.setVisibility(0);
        this.artistPicView.setVisibility(8);
        ImageLoaderProviderProxy.getProxy().load(c2, new qv0(homeGrabHotBean, this), new pv0(this));
        if (!isGrabHotProject()) {
        }
        textView = this.title;
        Context context62 = this.itemView.getContext();
        k21.h(context62, "itemView.context");
        int b22 = u5032.b(context62, 105);
        if (i > 0) {
        }
        str = homeGrabHotBean.artistName;
        if (!(str != null || str.length() == 0)) {
        }
        String str62 = homeGrabHotBean.name;
        k21.h(str62, "bean.name");
        textView.setText(getBoldSpanString(str62));
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-616037137")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("-616037137", new Object[]{this});
    }

    public boolean isGrabHotProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1931874383")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1931874383", new Object[]{this})).booleanValue();
    }
}
