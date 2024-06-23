package com.alibaba.pictures.bricks.component.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.component.project.bean.CommonTagBean;
import com.alibaba.pictures.bricks.component.project.bean.Daojishi;
import com.alibaba.pictures.bricks.component.project.bean.ProjectBuyStatus;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.alibaba.pictures.bricks.component.project.bean.RankingListBean;
import com.alibaba.pictures.bricks.view.DMPosterView;
import com.alibaba.pictures.bricks.view.FlowLayout;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.sb2;
import tb.t71;
import tb.u50;

/* compiled from: Taobao */
public class BricksProjectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup A;
    private long B;
    private long C;
    private Daojishi D;
    public View a;
    public DMPosterView b;
    public TextView c;
    public TextView d;
    public TextView e;
    private FlowLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TimerView m;
    private int n = 0;
    private Context o;
    private View p;
    private TextView q;
    private TextView r;
    private TextView s;
    private LinearLayout t;
    private LinearLayout u;
    private TextView v;
    private TextView w;
    private View x;
    private ImageView y;
    private View.OnClickListener z;

    /* compiled from: Taobao */
    public enum PageType {
        INIT_PAGE,
        SEARCH_PAGE,
        CATEGORY_PAGE,
        MINE_COLLECT
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        a(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "382764519")) {
                ipChange.ipc$dispatch("382764519", new Object[]{this, view});
                return;
            }
            ProjectItemBean projectItemBean = null;
            try {
                projectItemBean = (ProjectItemBean) view.getTag();
            } catch (Exception unused) {
            }
            if (projectItemBean != null) {
                if (BricksProjectViewHolder.this.z != null) {
                    this.a.onClick(view);
                }
                sb2.a(BricksProjectViewHolder.this.o, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "646699918")) {
                ipChange.ipc$dispatch("646699918", new Object[]{this, view});
            }
        }

        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1168132981")) {
                ipChange.ipc$dispatch("-1168132981", new Object[]{this, view});
                return;
            }
            Object tag = BricksProjectViewHolder.this.m.getTag();
            if (tag instanceof WeakRefCountDownTimer) {
                ((WeakRefCountDownTimer) tag).cancel();
                BricksProjectViewHolder.this.m.setTag(null);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1716369204")) {
                ipChange.ipc$dispatch("-1716369204", new Object[]{this});
                return;
            }
            if (BricksProjectViewHolder.this.f.getChildAt(0) != null) {
                int height = BricksProjectViewHolder.this.f.getChildAt(0).getHeight();
                if (BricksProjectViewHolder.this.f.getHeight() > height) {
                    BricksProjectViewHolder.this.A.setPadding(0, 0, 0, (BricksProjectViewHolder.this.f.getHeight() - height) + u50.INSTANCE.b(BricksProjectViewHolder.this.o, 3));
                } else {
                    BricksProjectViewHolder.this.A.setPadding(0, 0, 0, 0);
                }
            } else {
                BricksProjectViewHolder.this.A.setPadding(0, 0, 0, 0);
            }
            BricksProjectViewHolder.this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public BricksProjectViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.bricks_search_list_project, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.o = context;
        o(this.itemView);
    }

    private void A(TextView textView, List<String> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88301751")) {
            ipChange.ipc$dispatch("88301751", new Object[]{this, textView, list, str});
            return;
        }
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            textView.setText(str);
            return;
        }
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

    private void f(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1204785417")) {
            ipChange.ipc$dispatch("-1204785417", new Object[]{this, projectItemBean});
            return;
        }
        for (MarketTagBean marketTagBean : projectItemBean.marketPromotionTags) {
            marketTagBean.addMarketTagView(this.f, false);
        }
    }

    private void g(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283191280")) {
            ipChange.ipc$dispatch("-283191280", new Object[]{this, projectItemBean});
            return;
        }
        if (!TextUtils.isEmpty(projectItemBean.discountRate)) {
            h(DMTagType.TAG_TYPE_PREFERENTIAL, projectItemBean.discountRate + "折起");
        }
        List<String> list = projectItemBean.promotionTags;
        if (list != null && list.size() > 0) {
            for (String str : projectItemBean.promotionTags) {
                h(DMTagType.TAG_TYPE_PREFERENTIAL, str);
            }
        }
        if (!TextUtils.isEmpty(projectItemBean.getVipMark())) {
            h(DMTagType.TAG_TYPE_MEMBER, projectItemBean.getVipMark());
        }
        String couponTag = projectItemBean.getCouponTag();
        if (!TextUtils.isEmpty(couponTag)) {
            h(DMTagType.TAG_TYPE_PREFERENTIAL, couponTag);
        }
        String activityTag = projectItemBean.getActivityTag();
        if (!TextUtils.isEmpty(activityTag)) {
            h(DMTagType.TAG_TYPE_PREFERENTIAL, activityTag);
        }
        String privilegeTag = projectItemBean.getPrivilegeTag();
        if (!TextUtils.isEmpty(privilegeTag)) {
            h(DMTagType.TAG_TYPE_PREFERENTIAL, privilegeTag);
        }
    }

    private void h(DMTagType dMTagType, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "742147190")) {
            ipChange.ipc$dispatch("742147190", new Object[]{this, dMTagType, str});
        } else if (!TextUtils.isEmpty(str)) {
            DMCommonTagView dMCommonTagView = new DMCommonTagView(this.o);
            dMCommonTagView.adjustTagHeight(false);
            dMCommonTagView.setTagType(dMTagType).setTagName(str);
            this.f.addView(dMCommonTagView);
        }
    }

    @SuppressLint({"NewApi"})
    private void o(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569983522")) {
            ipChange.ipc$dispatch("-1569983522", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.space);
        this.a = findViewById;
        findViewById.setVisibility(0);
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
        TimerView timerView = (TimerView) view.findViewById(R$id.ll_timer);
        this.m = timerView;
        timerView.addOnAttachStateChangeListener(new b());
        this.A = (ViewGroup) view.findViewById(R$id.ll_price);
    }

    private void p(ProjectItemBean projectItemBean, PageType pageType, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352782311")) {
            ipChange.ipc$dispatch("352782311", new Object[]{this, projectItemBean, pageType, Boolean.valueOf(z2)});
        } else if (projectItemBean != null) {
            this.itemView.setTag(projectItemBean);
            this.b.setImageUrl(projectItemBean.verticalPic);
            this.b.setVideoIconVisibility(projectItemBean.hasVideo() ? 0 : 8);
            this.b.setCategoryTagName(projectItemBean.getCategoryNameCompat());
            if (TextUtils.isEmpty(projectItemBean.liveStatus)) {
                this.b.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if ("1".equals(projectItemBean.liveStatus)) {
                this.b.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if ("2".equals(projectItemBean.liveStatus)) {
                this.b.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
            } else {
                this.b.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            }
            x(pageType, projectItemBean.cityName, projectItemBean.name, projectItemBean.highlightWord);
            r(projectItemBean.itemScore, projectItemBean, pageType);
            if (!TextUtils.isEmpty(projectItemBean.liveStartTime)) {
                z(projectItemBean.liveStartTime);
            } else {
                z(projectItemBean.showTime);
            }
            t(projectItemBean.isLiveProject(), projectItemBean.cityName, projectItemBean.venueName);
            if (!z2 || TextUtils.isEmpty(projectItemBean.formattedDistance)) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                this.l.setText(projectItemBean.formattedDistance);
            }
            q(projectItemBean);
            if (pageType == null || pageType != PageType.MINE_COLLECT) {
                y(projectItemBean.priceLow, projectItemBean.promotionPrice, projectItemBean.displayStatus, projectItemBean.showStatus, true);
            } else {
                y(projectItemBean.formattedPriceStr, projectItemBean.promotionPrice, projectItemBean.displayStatus, projectItemBean.showStatus, false);
            }
            ProjectBuyStatus projectBuyStatus = projectItemBean.showStatus;
            if (projectBuyStatus == null || TextUtils.isEmpty(projectBuyStatus.id) || !"2".equals(projectItemBean.showStatus.id)) {
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.b.setImageViewMaskVisibility(8);
                ImageView imageView = this.y;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.b.removeView(this.y);
                }
                if (projectItemBean.isHotProject()) {
                    this.b.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                } else if (TextUtils.isEmpty(projectItemBean.brandOptimizationTag) || projectItemBean.brandOptimizationTag.equals("NEW_SHELF")) {
                    if (!TextUtils.isEmpty(projectItemBean.brandOptimizationTag) && projectItemBean.brandOptimizationTag.equals("NEW_SHELF") && (projectItemBean.gotPostTag() == null || this.b.getLabelView() == null)) {
                        this.b.setLabelType(DMLabelType.LABEL_TYPE_NEW_SALE);
                    } else if (projectItemBean.isSoldOut()) {
                        this.b.setLabelType(DMLabelType.LABEL_TYPE_ALL_SELL_OUT);
                    } else if (!TextUtils.isEmpty(projectItemBean.atmosphericPic)) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 80;
                        layoutParams.rightMargin = u50.INSTANCE.b(this.o, 14);
                        ImageView imageView2 = new ImageView(this.o);
                        this.y = imageView2;
                        imageView2.setVisibility(0);
                        this.b.addView(this.y, layoutParams);
                        ImageLoaderProviderProxy.getProxy().loadinto(projectItemBean.atmosphericPic, this.y);
                    } else if (projectItemBean.gotPostTag() == null || this.b.getLabelView() == null) {
                        this.b.setLabelType(null);
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams2.gravity = 80;
                        layoutParams2.rightMargin = u50.INSTANCE.b(this.o, 14);
                        ImageView imageView3 = new ImageView(this.o);
                        this.y = imageView3;
                        imageView3.setVisibility(0);
                        this.y.setImageResource(R$drawable.bricks_icon_market_earlybird);
                        this.b.addView(this.y, layoutParams2);
                        this.b.setLabelType(null);
                    }
                } else if (projectItemBean.brandOptimizationTag.equals("HIGHEST_HEAT")) {
                    this.b.setLabelType(DMLabelType.LABEL_TYPE_HIGHEST_HOT);
                } else if (projectItemBean.brandOptimizationTag.equals("ON_SOON")) {
                    this.b.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE);
                } else if (projectItemBean.isSoldOut()) {
                    this.b.setLabelType(DMLabelType.LABEL_TYPE_ALL_SELL_OUT);
                } else {
                    this.b.setLabelType(null);
                }
            } else {
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                this.b.setImageViewMaskVisibility(0);
                this.b.setLabelType(null);
            }
            this.m.setVisibility(8);
            Object tag = this.m.getTag();
            if (tag instanceof WeakRefCountDownTimer) {
                ((WeakRefCountDownTimer) tag).cancel();
                this.m.setTag(null);
            }
            if (projectItemBean.isSnapUp()) {
                long j2 = this.B;
                if (j2 > 0) {
                    long j3 = projectItemBean.upTime;
                    if (j3 > j2) {
                        long elapsedRealtime = (j3 - this.C) - SystemClock.elapsedRealtime();
                        Log.e("countDownMs", "使用 countDownMsSurplus=" + elapsedRealtime + " bean.upTime=" + projectItemBean.upTime + " timeDiff=" + this.C + " SystemClock.elapsedRealtime()=" + SystemClock.elapsedRealtime());
                        this.m.setPerformTime(projectItemBean.onSaleTime);
                        if (this.D == null || elapsedRealtime <= 0) {
                            this.m.setTimeUp();
                        } else {
                            WeakRefCountDownTimer weakRefCountDownTimer = new WeakRefCountDownTimer(elapsedRealtime, 1000, this.m);
                            weakRefCountDownTimer.start();
                            this.m.setTag(weakRefCountDownTimer);
                        }
                        this.m.setVisibility(0);
                    }
                }
            }
            if (this.f.getVisibility() == 0 && this.f.getChildCount() > 0) {
                this.f.getViewTreeObserver().addOnGlobalLayoutListener(new c());
            }
        }
    }

    private void q(ProjectItemBean projectItemBean) {
        CommonTagBean commonTagBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725754339")) {
            ipChange.ipc$dispatch("-1725754339", new Object[]{this, projectItemBean});
        } else if (projectItemBean != null) {
            this.f.removeAllViews();
            if (projectItemBean.ifIsNewMarketTag()) {
                f(projectItemBean);
            } else {
                g(projectItemBean);
            }
            List<CommonTagBean> list = projectItemBean.commonTags;
            if (list != null && list.size() > 0 && (commonTagBean = projectItemBean.commonTags.get(0)) != null && commonTagBean.id == 1 && !TextUtils.isEmpty(commonTagBean.name)) {
                h(DMTagType.TAG_TYPE_SERVICES, commonTagBean.name);
            }
            if (projectItemBean.isSelectSeat()) {
                h(DMTagType.TAG_TYPE_SERVICES, "可选座");
            }
            if (this.f.getChildCount() > 0) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            if (!TextUtils.isEmpty(projectItemBean.displayStatus)) {
                this.f.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a4  */
    private void r(double d2, ProjectItemBean projectItemBean, PageType pageType) {
        boolean z2;
        boolean z3;
        String str;
        IpChange ipChange = $ipChange;
        boolean z4 = true;
        if (AndroidInstantRuntime.support(ipChange, "-2107916928")) {
            ipChange.ipc$dispatch("-2107916928", new Object[]{this, Double.valueOf(d2), projectItemBean, pageType});
            return;
        }
        if (pageType != null && pageType == PageType.MINE_COLLECT) {
            this.k.setVisibility(8);
        } else if (!projectItemBean.isFollowStatus() || !DoloresLoginHandler.Companion.a().c()) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            z2 = true;
            if (d2 == -1.0d) {
                this.r.setVisibility(0);
                this.s.setVisibility(0);
                this.r.setText(String.valueOf(d2));
                z3 = true;
            } else {
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                z3 = false;
            }
            if (TextUtils.isEmpty(projectItemBean.showTag)) {
                str = projectItemBean.showTag;
            } else {
                RankingListBean rankingListBean = projectItemBean.rankingList;
                if (rankingListBean != null) {
                    str = rankingListBean.title;
                } else {
                    str = !TextUtils.isEmpty(projectItemBean.actores) ? projectItemBean.actores : "";
                }
            }
            if (TextUtils.isEmpty(str)) {
                this.v.setText(str);
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(8);
                z4 = false;
            }
            if (z3 || !z4) {
                this.w.setVisibility(8);
            } else {
                this.w.setVisibility(0);
            }
            if (!z3 || z4 || z2) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
                return;
            }
        }
        z2 = false;
        if (d2 == -1.0d) {
        }
        if (TextUtils.isEmpty(projectItemBean.showTag)) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        if (z3) {
        }
        this.w.setVisibility(8);
        if (!z3) {
        }
        this.t.setVisibility(0);
    }

    private void t(boolean z2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445886580")) {
            ipChange.ipc$dispatch("1445886580", new Object[]{this, Boolean.valueOf(z2), str, str2});
        } else if (z2) {
            this.d.setText(str2);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "城市待定";
            }
            if (!TextUtils.isEmpty(str2)) {
                TextView textView = this.d;
                textView.setText(str + " | " + str2);
                return;
            }
            TextView textView2 = this.d;
            textView2.setText(str + " | 场馆待定");
        }
    }

    private void x(PageType pageType, String str, String str2, List<String> list) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242972806")) {
            ipChange.ipc$dispatch("-242972806", new Object[]{this, pageType, str, str2, list});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str3 = "【" + str + "】";
        } else {
            str3 = "";
        }
        if (t71.a(list) > 0) {
            A(this.c, list, str3 + str2);
            return;
        }
        this.c.setText(str3 + str2);
    }

    private void y(String str, String str2, String str3, ProjectBuyStatus projectBuyStatus, boolean z2) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-756372526")) {
            ipChange.ipc$dispatch("-756372526", new Object[]{this, str, str2, str3, projectBuyStatus, Boolean.valueOf(z2)});
            return;
        }
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.h.setText("");
        this.g.setVisibility(8);
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (TextUtils.isEmpty(str) || str.equals("待定") || str.equals("价格待定")) {
                this.g.setVisibility(8);
                this.j.setVisibility(0);
                return;
            }
            this.g.setVisibility(0);
            this.h.setText(str);
            TextView textView = this.i;
            if (!z2) {
                i2 = 8;
            }
            textView.setVisibility(i2);
        }
    }

    private void z(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247551844")) {
            ipChange.ipc$dispatch("-247551844", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.e.setText(str);
        } else {
            this.e.setText("时间待定");
        }
    }

    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402771412")) {
            ipChange.ipc$dispatch("-402771412", new Object[]{this});
            return;
        }
        this.itemView.findViewById(R$id.inner_project_gap).setVisibility(0);
        View findViewById = this.itemView.findViewById(R$id.inner_project_wrapper);
        u50 u50 = u50.INSTANCE;
        findViewById.setPadding(u50.b(this.o, 9), 0, u50.b(this.o, 9), 0);
    }

    public View i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-626627876")) {
            return this.x;
        }
        return (View) ipChange.ipc$dispatch("-626627876", new Object[]{this});
    }

    public View j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1681750154")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("-1681750154", new Object[]{this});
    }

    public void k(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984032670")) {
            ipChange.ipc$dispatch("-984032670", new Object[]{this, projectItemBean});
            return;
        }
        l(projectItemBean, null);
    }

    public void l(ProjectItemBean projectItemBean, PageType pageType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461893200")) {
            ipChange.ipc$dispatch("-1461893200", new Object[]{this, projectItemBean, pageType});
            return;
        }
        m(projectItemBean, pageType, true);
    }

    public void m(ProjectItemBean projectItemBean, PageType pageType, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925996836")) {
            ipChange.ipc$dispatch("1925996836", new Object[]{this, projectItemBean, pageType, Boolean.valueOf(z2)});
            return;
        }
        p(projectItemBean, pageType, z2);
    }

    public void n(ProjectItemBean projectItemBean, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-440195918")) {
            ipChange.ipc$dispatch("-440195918", new Object[]{this, projectItemBean, Boolean.valueOf(z2)});
            return;
        }
        m(projectItemBean, null, z2);
    }

    public void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1678368680")) {
            ipChange.ipc$dispatch("1678368680", new Object[]{this});
            return;
        }
        this.itemView.findViewById(R$id.inner_project_layout).setBackgroundResource(R$drawable.bricks_list_bg_radius);
    }

    public void u(Daojishi daojishi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408773103")) {
            ipChange.ipc$dispatch("408773103", new Object[]{this, daojishi});
            return;
        }
        this.D = daojishi;
        if (daojishi != null) {
            this.B = daojishi.serverTime;
            this.C = daojishi.diffTime;
        }
    }

    public void v(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014462040")) {
            ipChange.ipc$dispatch("1014462040", new Object[]{this, onClickListener});
            return;
        }
        this.z = onClickListener;
        View view = this.itemView;
        if (view != null) {
            view.setOnClickListener(new a(onClickListener));
        }
    }

    public void w(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607553584")) {
            ipChange.ipc$dispatch("-607553584", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        DMPosterView dMPosterView = this.b;
        if (dMPosterView != null) {
            dMPosterView.getLayoutParams().height = i3;
            this.b.getLayoutParams().width = i2;
        }
        LinearLayout linearLayout = this.u;
        if (linearLayout != null) {
            linearLayout.setMinimumHeight(i3);
        }
    }

    public BricksProjectViewHolder(Context context, View view) {
        super(view);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.o = context;
        o(this.itemView);
    }
}
