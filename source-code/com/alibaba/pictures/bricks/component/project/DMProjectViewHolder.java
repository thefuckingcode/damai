package com.alibaba.pictures.bricks.component.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.project.bean.CommonTagBean;
import com.alibaba.pictures.bricks.component.project.bean.DMProjectItemBean;
import com.alibaba.pictures.bricks.view.DMPosterView;
import com.alibaba.pictures.bricks.view.FlowLayout;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.alibaba.pictures.moimage.MoImageExtensionsKt;
import com.alibaba.pictures.moimage.MoImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hg0;
import tb.k21;
import tb.t71;
import tb.u50;

/* compiled from: Taobao */
public final class DMProjectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View a;
    @Nullable
    private DMPosterView b;
    @Nullable
    private TextView c;
    @Nullable
    private TextView d;
    @Nullable
    private TextView e;
    @Nullable
    private FlowLayout f;
    @Nullable
    private TextView g;
    @Nullable
    private TextView h;
    @Nullable
    private TextView i;
    @Nullable
    private TextView j;
    @Nullable
    private TextView k;
    @Nullable
    private TextView l;
    @Nullable
    private TimerView m;
    private int n;
    @NotNull
    private Context o;
    @Nullable
    private View p;
    @Nullable
    private TextView q;
    @Nullable
    private TextView r;
    @Nullable
    private TextView s;
    @Nullable
    private LinearLayout t;
    @Nullable
    private LinearLayout u;
    @Nullable
    private TextView v;
    @Nullable
    private TextView w;
    @Nullable
    private View x;
    @Nullable
    private MoImageView y;
    @Nullable
    private ViewGroup z;

    /* compiled from: Taobao */
    public enum PageType {
        INIT_PAGE,
        SEARCH_PAGE,
        CATEGORY_PAGE,
        MINE_COLLECT
    }

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DMLabelType.values().length];
            iArr[DMLabelType.LABEL_TYPE_HIGHEST_HOT.ordinal()] = 1;
            iArr[DMLabelType.LABEL_TYPE_NEW_SALE.ordinal()] = 2;
            iArr[DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE.ordinal()] = 3;
            iArr[DMLabelType.LABEL_TYPE_DOUBLE_11.ordinal()] = 4;
            iArr[DMLabelType.LABEL_TYPE_ZAO_NIAO.ordinal()] = 5;
            iArr[DMLabelType.LABEL_TYPE_BUYING.ordinal()] = 6;
            iArr[DMLabelType.LABEL_TYPE_UPCOMING_BUY.ordinal()] = 7;
            iArr[DMLabelType.LABEL_TYPE_TOUR.ordinal()] = 8;
            iArr[DMLabelType.LABEL_TYPE_SOLD_OUT.ordinal()] = 9;
            iArr[DMLabelType.LABEL_TYPE_ALL_SELL_OUT.ordinal()] = 10;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    public static final class b implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DMProjectViewHolder a;

        b(DMProjectViewHolder dMProjectViewHolder) {
            this.a = dMProjectViewHolder;
        }

        public void onViewAttachedToWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "878652831")) {
                ipChange.ipc$dispatch("878652831", new Object[]{this, view});
                return;
            }
            k21.i(view, "v");
        }

        public void onViewDetachedFromWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1599682980")) {
                ipChange.ipc$dispatch("-1599682980", new Object[]{this, view});
                return;
            }
            k21.i(view, "v");
            TimerView timerView = this.a.m;
            Object tag = timerView != null ? timerView.getTag() : null;
            WeakRefCountDownTimer weakRefCountDownTimer = tag instanceof WeakRefCountDownTimer ? (WeakRefCountDownTimer) tag : null;
            if (weakRefCountDownTimer != null) {
                DMProjectViewHolder dMProjectViewHolder = this.a;
                weakRefCountDownTimer.cancel();
                TimerView timerView2 = dMProjectViewHolder.m;
                if (timerView2 != null) {
                    timerView2.setTag(null);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FlowLayout a;
        final /* synthetic */ DMProjectViewHolder b;

        c(FlowLayout flowLayout, DMProjectViewHolder dMProjectViewHolder) {
            this.a = flowLayout;
            this.b = dMProjectViewHolder;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
        public void onGlobalLayout() {
            int i;
            ViewGroup viewGroup;
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-573291195")) {
                ipChange.ipc$dispatch("-573291195", new Object[]{this});
                return;
            }
            View childAt = this.a.getChildAt(0);
            if (childAt != null) {
                Integer valueOf = Integer.valueOf(childAt.getHeight());
                FlowLayout flowLayout = this.a;
                if (flowLayout.getHeight() <= valueOf.intValue()) {
                    z = false;
                }
                if (!z) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    FlowLayout flowLayout2 = this.a;
                    DMProjectViewHolder dMProjectViewHolder = this.b;
                    i = (flowLayout2.getHeight() - valueOf.intValue()) + u50.INSTANCE.b(dMProjectViewHolder.o, 3);
                    viewGroup = this.b.z;
                    if (viewGroup != null) {
                        viewGroup.setPadding(0, 0, 0, i);
                    }
                    this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
            i = 0;
            viewGroup = this.b.z;
            if (viewGroup != null) {
            }
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DMProjectViewHolder(@NotNull Context context, @NotNull View view) {
        super(view);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(view, "view");
        this.o = context;
        View view2 = this.itemView;
        k21.h(view2, "itemView");
        j(view2);
    }

    private final void d(DMProjectItemBean dMProjectItemBean) {
        DMProjectItemBean.ProjectTagModel projectTagModel;
        List<CommonTagBean> list;
        DMProjectItemBean.ProjectTagModel projectTagModel2;
        List<MarketTagBean> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1998908553")) {
            ipChange.ipc$dispatch("1998908553", new Object[]{this, dMProjectItemBean});
            return;
        }
        if (!(dMProjectItemBean == null || (projectTagModel2 = dMProjectItemBean.tagModel) == null || (list2 = projectTagModel2.marketPromotionTags) == null)) {
            for (MarketTagBean marketTagBean : list2) {
                marketTagBean.addMarketTagView(this.f, false);
            }
        }
        if (!(dMProjectItemBean == null || (projectTagModel = dMProjectItemBean.tagModel) == null || (list = projectTagModel.commonTags) == null)) {
            for (CommonTagBean commonTagBean : list) {
                e(DMTagType.TAG_TYPE_SERVICES, commonTagBean.name);
            }
        }
    }

    private final void e(DMTagType dMTagType, String str) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1971696959")) {
            ipChange.ipc$dispatch("1971696959", new Object[]{this, dMTagType, str});
            return;
        }
        if (!(str == null || str.length() == 0)) {
            z2 = false;
        }
        if (!z2) {
            DMCommonTagView dMCommonTagView = new DMCommonTagView(this.o);
            dMCommonTagView.adjustTagHeight(false);
            dMCommonTagView.setTagType(dMTagType).setTagName(str);
            FlowLayout flowLayout = this.f;
            if (flowLayout != null) {
                flowLayout.addView(dMCommonTagView);
            }
        }
    }

    private final void f(DMProjectItemBean dMProjectItemBean) {
        int i2;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-2115882124")) {
            ipChange.ipc$dispatch("-2115882124", new Object[]{this, dMProjectItemBean});
        } else if (dMProjectItemBean != null) {
            MoImageView moImageView = this.y;
            if (moImageView != null) {
                if (moImageView != null) {
                    moImageView.setVisibility(8);
                }
                DMPosterView dMPosterView = this.b;
                if (dMPosterView != null) {
                    dMPosterView.removeView(this.y);
                }
            }
            DMPosterView dMPosterView2 = this.b;
            String str = null;
            if (dMPosterView2 != null) {
                dMPosterView2.setLabelType(null);
            }
            DMProjectItemBean.PosterTag posterTag = dMProjectItemBean.bottomLeft;
            DMLabelType convertType2Label = DMLabelType.convertType2Label(posterTag != null ? posterTag.type : null);
            if (convertType2Label == null) {
                i2 = -1;
            } else {
                i2 = a.$EnumSwitchMapping$0[convertType2Label.ordinal()];
            }
            switch (i2) {
                case 1:
                    DMPosterView dMPosterView3 = this.b;
                    if (dMPosterView3 != null) {
                        dMPosterView3.setLabelType(DMLabelType.LABEL_TYPE_HIGHEST_HOT);
                        return;
                    }
                    return;
                case 2:
                    DMPosterView dMPosterView4 = this.b;
                    if (dMPosterView4 != null) {
                        dMPosterView4.setLabelType(DMLabelType.LABEL_TYPE_NEW_SALE);
                        return;
                    }
                    return;
                case 3:
                    DMPosterView dMPosterView5 = this.b;
                    if (dMPosterView5 != null) {
                        dMPosterView5.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE);
                        return;
                    }
                    return;
                case 4:
                    DMProjectItemBean.PosterTag posterTag2 = dMProjectItemBean.bottomLeft;
                    String str2 = posterTag2 != null ? posterTag2.tag : null;
                    if (!(str2 == null || str2.length() == 0)) {
                        z2 = false;
                    }
                    if (!z2) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 80;
                        u50 u50 = u50.INSTANCE;
                        layoutParams.rightMargin = u50.b(this.o, 14);
                        MoImageView moImageView2 = new MoImageView(this.o, null, 0, 6, null);
                        moImageView2.setVisibility(0);
                        this.y = moImageView2;
                        DMPosterView dMPosterView6 = this.b;
                        if (dMPosterView6 != null) {
                            dMPosterView6.addView(moImageView2, layoutParams);
                        }
                        MoImageView moImageView3 = this.y;
                        if (moImageView3 != null) {
                            Integer valueOf = Integer.valueOf(u50.b(this.o, 16));
                            DMProjectItemBean.PosterTag posterTag3 = dMProjectItemBean.bottomLeft;
                            if (posterTag3 != null) {
                                str = posterTag3.tag;
                            }
                            MoImageExtensionsKt.a(moImageView3, valueOf, str);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 80;
                    layoutParams2.rightMargin = u50.INSTANCE.b(this.o, 14);
                    MoImageView moImageView4 = new MoImageView(this.o, null, 0, 6, null);
                    moImageView4.setVisibility(0);
                    moImageView4.setImageResource(R$drawable.bricks_icon_market_earlybird);
                    this.y = moImageView4;
                    DMPosterView dMPosterView7 = this.b;
                    if (dMPosterView7 != null) {
                        dMPosterView7.addView(moImageView4, layoutParams2);
                        return;
                    }
                    return;
                case 6:
                    DMPosterView dMPosterView8 = this.b;
                    if (dMPosterView8 != null) {
                        dMPosterView8.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                        return;
                    }
                    return;
                case 7:
                    DMPosterView dMPosterView9 = this.b;
                    if (dMPosterView9 != null) {
                        dMPosterView9.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_BUY);
                        return;
                    }
                    return;
                case 8:
                    DMPosterView dMPosterView10 = this.b;
                    if (dMPosterView10 != null) {
                        dMPosterView10.setLabelType(DMLabelType.LABEL_TYPE_TOUR);
                        return;
                    }
                    return;
                case 9:
                    DMPosterView dMPosterView11 = this.b;
                    if (dMPosterView11 != null) {
                        dMPosterView11.setLabelType(DMLabelType.LABEL_TYPE_SOLD_OUT);
                        return;
                    }
                    return;
                case 10:
                    DMPosterView dMPosterView12 = this.b;
                    if (dMPosterView12 != null) {
                        dMPosterView12.setLabelType(DMLabelType.LABEL_TYPE_ALL_SELL_OUT);
                        return;
                    }
                    return;
                default:
                    DMPosterView dMPosterView13 = this.b;
                    if (dMPosterView13 != null) {
                        dMPosterView13.setLabelType(null);
                        return;
                    }
                    return;
            }
        }
    }

    private final void g(DMProjectItemBean dMProjectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939968484")) {
            ipChange.ipc$dispatch("-939968484", new Object[]{this, dMProjectItemBean});
        } else if (dMProjectItemBean != null) {
            TimerView timerView = this.m;
            if (timerView != null) {
                timerView.setVisibility(8);
            }
            TimerView timerView2 = this.m;
            String str = null;
            Object tag = timerView2 != null ? timerView2.getTag() : null;
            if (tag instanceof WeakRefCountDownTimer) {
                ((WeakRefCountDownTimer) tag).cancel();
                TimerView timerView3 = this.m;
                if (timerView3 != null) {
                    timerView3.setTag(null);
                }
            }
            Long calSnapUpCountDownTime = dMProjectItemBean.calSnapUpCountDownTime(Long.valueOf(TimeSyncer.INSTANCE.g()));
            k21.h(calSnapUpCountDownTime, "countDownMsSurplus");
            if (calSnapUpCountDownTime.longValue() > 0) {
                TimerView timerView4 = this.m;
                if (timerView4 != null) {
                    DMProjectItemBean.SnapUpInfo snapUpInfo = dMProjectItemBean.snapUpInfo;
                    if (snapUpInfo != null) {
                        str = snapUpInfo.onSaleTime;
                    }
                    if (str == null) {
                        str = "";
                    }
                    timerView4.setPerformTime(str, "");
                }
                WeakRefCountDownTimer weakRefCountDownTimer = new WeakRefCountDownTimer(calSnapUpCountDownTime.longValue(), 1000, this.m);
                weakRefCountDownTimer.start();
                TimerView timerView5 = this.m;
                if (timerView5 != null) {
                    timerView5.setVisibleGoneAfterTimeout();
                }
                TimerView timerView6 = this.m;
                if (timerView6 != null) {
                    timerView6.markBricksStyle();
                }
                TimerView timerView7 = this.m;
                if (timerView7 != null) {
                    timerView7.setTag(weakRefCountDownTimer);
                }
                TimerView timerView8 = this.m;
                if (timerView8 != null) {
                    timerView8.setVisibility(0);
                    return;
                }
                return;
            }
            TimerView timerView9 = this.m;
            if (timerView9 != null) {
                timerView9.setTimeUp();
            }
            TimerView timerView10 = this.m;
            if (timerView10 != null) {
                timerView10.setVisibility(8);
            }
        }
    }

    public static /* synthetic */ void i(DMProjectViewHolder dMProjectViewHolder, DMProjectItemBean dMProjectItemBean, PageType pageType, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            pageType = null;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        dMProjectViewHolder.h(dMProjectItemBean, pageType, z2);
    }

    @SuppressLint({"NewApi"})
    private final void j(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569395147")) {
            ipChange.ipc$dispatch("-569395147", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.space);
        this.a = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        this.b = (DMPosterView) view.findViewById(R$id.poster);
        this.c = (TextView) view.findViewById(R$id.tv_project_name);
        this.d = (TextView) view.findViewById(R$id.tv_project_city);
        this.e = (TextView) view.findViewById(R$id.tv_project_time);
        this.u = (LinearLayout) view.findViewById(R$id.ll_project_right);
        this.t = (LinearLayout) view.findViewById(R$id.ll_score_follow);
        this.k = (TextView) view.findViewById(R$id.tv_project_follow_desc);
        this.r = (TextView) view.findViewById(R$id.layout_score);
        this.s = (TextView) view.findViewById(R$id.layout_score_preifx);
        this.v = (TextView) view.findViewById(R$id.tv_project_rank);
        this.w = (TextView) view.findViewById(R$id.tv_project_rank_mark);
        this.f = (FlowLayout) view.findViewById(R$id.fl_sales2);
        this.p = view.findViewById(R$id.ll_child_price);
        this.g = (TextView) view.findViewById(R$id.tv_fuhao);
        this.h = (TextView) view.findViewById(R$id.tv_project_price);
        this.i = (TextView) view.findViewById(R$id.tv_project_price_label);
        this.j = (TextView) view.findViewById(R$id.tv_project_price_confirm);
        this.q = (TextView) view.findViewById(R$id.tv_yixiajia);
        this.l = (TextView) view.findViewById(R$id.tv_project_dis);
        this.x = view.findViewById(R$id.ll_search_bottom_div);
        TimerView timerView = (TimerView) view.findViewById(R$id.dm_project_timer_view);
        this.m = timerView;
        if (timerView != null) {
            timerView.addOnAttachStateChangeListener(new b(this));
        }
        this.z = (ViewGroup) view.findViewById(R$id.ll_price);
    }

    private final void k(DMProjectItemBean dMProjectItemBean, PageType pageType, boolean z2) {
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "1367183404")) {
            ipChange.ipc$dispatch("1367183404", new Object[]{this, dMProjectItemBean, pageType, Boolean.valueOf(z2)});
        } else if (dMProjectItemBean != null) {
            this.itemView.setTag(dMProjectItemBean);
            DMPosterView dMPosterView = this.b;
            if (dMPosterView != null) {
                dMPosterView.setImageUrl(dMProjectItemBean.verticalPic);
            }
            DMPosterView dMPosterView2 = this.b;
            int i2 = 8;
            if (dMPosterView2 != null) {
                dMPosterView2.setVideoIconVisibility(dMProjectItemBean.needShowPosterVideoTag() ? 0 : 8);
            }
            DMProjectItemBean.PosterTag posterTag = dMProjectItemBean.topRight;
            if (posterTag != null) {
                DMPosterView dMPosterView3 = this.b;
                if (dMPosterView3 != null) {
                    dMPosterView3.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
                }
                if (TextUtils.equals("201", posterTag.type)) {
                    DMPosterView dMPosterView4 = this.b;
                    if (dMPosterView4 != null) {
                        dMPosterView4.setCategoryTagName(posterTag.tag);
                    }
                } else if (TextUtils.equals("202", posterTag.type)) {
                    DMPosterView dMPosterView5 = this.b;
                    if (dMPosterView5 != null) {
                        dMPosterView5.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
                    }
                    DMPosterView dMPosterView6 = this.b;
                    if (dMPosterView6 != null) {
                        dMPosterView6.setCategoryTagName("");
                    }
                } else if (TextUtils.equals("203", posterTag.type)) {
                    DMPosterView dMPosterView7 = this.b;
                    if (dMPosterView7 != null) {
                        dMPosterView7.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
                    }
                    DMPosterView dMPosterView8 = this.b;
                    if (dMPosterView8 != null) {
                        dMPosterView8.setCategoryTagName("");
                    }
                } else {
                    DMPosterView dMPosterView9 = this.b;
                    if (dMPosterView9 != null) {
                        dMPosterView9.setCategoryTagName("");
                    }
                }
            } else {
                DMPosterView dMPosterView10 = this.b;
                if (dMPosterView10 != null) {
                    dMPosterView10.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
                }
                DMPosterView dMPosterView11 = this.b;
                if (dMPosterView11 != null) {
                    dMPosterView11.setCategoryTagName("");
                }
            }
            p(pageType, dMProjectItemBean.cityName, dMProjectItemBean.name, dMProjectItemBean.highlightWord);
            m(Double.valueOf(dMProjectItemBean.itemScore), dMProjectItemBean, pageType);
            r(dMProjectItemBean.showTime);
            n(Boolean.valueOf(dMProjectItemBean.judgeIsLiveProject()), dMProjectItemBean.cityName, dMProjectItemBean.venueName);
            FlowLayout flowLayout = null;
            if (z2) {
                TextView textView = this.l;
                if (textView != null) {
                    hg0.b(textView, dMProjectItemBean.formattedDistance, 0, 2, null);
                }
            } else {
                TextView textView2 = this.l;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            l(dMProjectItemBean);
            q(dMProjectItemBean, Boolean.TRUE);
            f(dMProjectItemBean);
            g(dMProjectItemBean);
            DMPosterView dMPosterView12 = this.b;
            if (dMPosterView12 != null) {
                if (dMProjectItemBean.judgeIdXiaJiaProject()) {
                    i2 = 0;
                }
                dMPosterView12.setImageViewMaskVisibility(i2);
            }
            FlowLayout flowLayout2 = this.f;
            if (flowLayout2 != null) {
                if (flowLayout2.getVisibility() != 0 || flowLayout2.getChildCount() <= 0) {
                    z3 = false;
                }
                if (z3) {
                    flowLayout = flowLayout2;
                }
                if (flowLayout != null) {
                    ViewGroup viewGroup = this.z;
                    if (viewGroup != null) {
                        viewGroup.setPadding(0, 0, 0, 0);
                    }
                    flowLayout.getViewTreeObserver().addOnGlobalLayoutListener(new c(flowLayout, this));
                }
            }
        }
    }

    private final void l(DMProjectItemBean dMProjectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-547225105")) {
            ipChange.ipc$dispatch("-547225105", new Object[]{this, dMProjectItemBean});
        } else if (dMProjectItemBean != null) {
            FlowLayout flowLayout = this.f;
            if (flowLayout != null) {
                flowLayout.removeAllViews();
            }
            d(dMProjectItemBean);
            FlowLayout flowLayout2 = this.f;
            if (flowLayout2 == null) {
                return;
            }
            if (flowLayout2.getChildCount() > 0) {
                flowLayout2.setVisibility(0);
            } else {
                flowLayout2.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    private final void m(Double d2, DMProjectItemBean dMProjectItemBean, PageType pageType) {
        boolean z2;
        boolean z3;
        String str;
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        TextView textView3;
        IpChange ipChange = $ipChange;
        boolean z4 = true;
        if (AndroidInstantRuntime.support(ipChange, "2145376715")) {
            ipChange.ipc$dispatch("2145376715", new Object[]{this, d2, dMProjectItemBean, pageType});
        } else if (dMProjectItemBean != null) {
            if (pageType != null && pageType == PageType.MINE_COLLECT) {
                TextView textView4 = this.k;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
            } else if (!dMProjectItemBean.hasWantSee() || !DoloresLoginHandler.Companion.a().c()) {
                TextView textView5 = this.k;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            } else {
                TextView textView6 = this.k;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                z2 = true;
                if (d2 != null || k21.a(d2, -1.0d)) {
                    textView2 = this.r;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    textView3 = this.s;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    z3 = false;
                } else {
                    TextView textView7 = this.r;
                    if (textView7 != null) {
                        textView7.setVisibility(0);
                    }
                    TextView textView8 = this.s;
                    if (textView8 != null) {
                        textView8.setVisibility(0);
                    }
                    TextView textView9 = this.r;
                    if (textView9 != null) {
                        textView9.setText(d2.toString());
                    }
                    z3 = true;
                }
                str = dMProjectItemBean.showTag;
                if (!(str != null || str.length() == 0)) {
                    TextView textView10 = this.v;
                    if (textView10 != null) {
                        textView10.setVisibility(8);
                    }
                    z4 = false;
                } else {
                    TextView textView11 = this.v;
                    if (textView11 != null) {
                        textView11.setText(dMProjectItemBean.showTag);
                    }
                    TextView textView12 = this.v;
                    if (textView12 != null) {
                        textView12.setVisibility(0);
                    }
                }
                if (z3 || !z4) {
                    textView = this.w;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                } else {
                    TextView textView13 = this.w;
                    if (textView13 != null) {
                        textView13.setVisibility(0);
                    }
                }
                if (!z3 || z4 || z2) {
                    linearLayout = this.t;
                    if (linearLayout == null) {
                        linearLayout.setVisibility(0);
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout2 = this.t;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                    return;
                }
                return;
            }
            z2 = false;
            if (d2 != null) {
            }
            textView2 = this.r;
            if (textView2 != null) {
            }
            textView3 = this.s;
            if (textView3 != null) {
            }
            z3 = false;
            str = dMProjectItemBean.showTag;
            if (!(str != null || str.length() == 0)) {
            }
            if (z3) {
            }
            textView = this.w;
            if (textView != null) {
            }
            if (!z3) {
            }
            linearLayout = this.t;
            if (linearLayout == null) {
            }
        }
    }

    private final void n(Boolean bool, String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1137633206")) {
            ipChange.ipc$dispatch("1137633206", new Object[]{this, bool, str, str2});
            return;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "场馆待定";
        }
        if (k21.d(bool, Boolean.TRUE)) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(str2);
                return;
            }
            return;
        }
        if (!(str == null || str.length() == 0)) {
            z2 = false;
        }
        if (z2) {
            str = "城市待定";
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(str + " | " + str2);
        }
    }

    private final void p(PageType pageType, String str, String str2, List<String> list) {
        String str3;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1205575564")) {
            ipChange.ipc$dispatch("1205575564", new Object[]{this, pageType, str, str2, list});
            return;
        }
        if (!(str == null || str.length() == 0)) {
            z2 = false;
        }
        if (!z2) {
            str3 = (char) 12304 + str + (char) 12305;
        } else {
            str3 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        if (t71.a(list) > 0) {
            s(this.c, list, sb2);
            return;
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(sb2);
        }
    }

    private final void q(DMProjectItemBean dMProjectItemBean, Boolean bool) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1557670008")) {
            ipChange.ipc$dispatch("1557670008", new Object[]{this, dMProjectItemBean, bool});
        } else if (dMProjectItemBean != null) {
            TextView textView = this.q;
            if (textView != null) {
                textView.setVisibility(8);
            }
            View view = this.p;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.i;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.g;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.h;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            String str = dMProjectItemBean.priceShowText;
            if (!(str == null || str.length() == 0)) {
                z2 = false;
            }
            if (z2) {
                TextView textView6 = this.h;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TextView textView7 = this.h;
                if (textView7 != null) {
                    textView7.setText("");
                }
            } else if (k21.d(str, "已下架")) {
                View view2 = this.p;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                TextView textView8 = this.q;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
            } else if (k21.d(str, "待定") || k21.d(str, "价格待定")) {
                TextView textView9 = this.j;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
            } else {
                TextView textView10 = this.g;
                if (textView10 != null) {
                    textView10.setVisibility(0);
                }
                TextView textView11 = this.h;
                if (textView11 != null) {
                    textView11.setVisibility(0);
                }
                TextView textView12 = this.h;
                if (textView12 != null) {
                    textView12.setText(str);
                }
                TextView textView13 = this.i;
                if (textView13 != null) {
                    if (!k21.d(bool, Boolean.TRUE)) {
                        i2 = 8;
                    }
                    textView13.setVisibility(i2);
                }
            }
        }
    }

    private final void r(String str) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-85616973")) {
            ipChange.ipc$dispatch("-85616973", new Object[]{this, str});
            return;
        }
        if (!(str == null || str.length() == 0)) {
            z2 = false;
        }
        if (!z2) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(str);
                return;
            }
            return;
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText("时间待定");
        }
    }

    private final void s(TextView textView, List<String> list, String str) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "972242574")) {
            ipChange.ipc$dispatch("972242574", new Object[]{this, textView, list, str});
        } else if (textView != null) {
            if (!(str == null || str.length() == 0)) {
                if (list != null && !list.isEmpty()) {
                    z2 = false;
                }
                if (z2) {
                    textView.setText(str);
                    return;
                }
                int size = list.size();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        Matcher matcher = Pattern.compile(list.get(i2)).matcher(str);
                        while (true) {
                            if (!matcher.find()) {
                                break;
                            }
                            int start = matcher.start();
                            this.n = start;
                            if (start == -1) {
                                break;
                            } else if (start >= 0) {
                                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(this.o, R$color.color_FF2D79));
                                int i3 = this.n;
                                spannableStringBuilder.setSpan(foregroundColorSpan, i3, list.get(i2).length() + i3, 18);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                textView.setGravity(16);
                textView.setText(spannableStringBuilder);
            }
        }
    }

    @JvmOverloads
    public final void h(@Nullable DMProjectItemBean dMProjectItemBean, @Nullable PageType pageType, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573804777")) {
            ipChange.ipc$dispatch("1573804777", new Object[]{this, dMProjectItemBean, pageType, Boolean.valueOf(z2)});
            return;
        }
        k(dMProjectItemBean, pageType, z2);
    }

    public final void o(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697786023")) {
            ipChange.ipc$dispatch("-1697786023", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        DMPosterView dMPosterView = this.b;
        if (dMPosterView != null) {
            dMPosterView.getLayoutParams().width = i2;
            dMPosterView.getLayoutParams().height = i3;
        }
        LinearLayout linearLayout = this.u;
        if (linearLayout != null) {
            linearLayout.setMinimumHeight(i3);
        }
    }
}
