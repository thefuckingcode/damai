package cn.damai.commonbusiness.wannasee.viewholder;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.wannasee.view.WantSeeRecommendView;
import cn.damai.rank.RankSquareCMSActivity;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.bricks.component.project.TimerView;
import com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.jl1;
import tb.k21;
import tb.n42;
import tb.ur2;
import tb.xs0;

/* compiled from: Taobao */
public final class WantSeeProjectViewHolder extends RecyclerView.ViewHolder implements WeakRefCountDownTimer.OnTickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private DMPosterView a;
    @NotNull
    private TextView b;
    @NotNull
    private ViewGroup c;
    @NotNull
    private TextView d;
    @NotNull
    private View e;
    @NotNull
    private ViewGroup f;
    @NotNull
    private TextView g;
    @NotNull
    private TextView h;
    @NotNull
    private TextView i;
    @NotNull
    private TextView j;
    @NotNull
    private View k;
    @NotNull
    private ViewGroup l;
    @NotNull
    private TextView m;
    @NotNull
    private TextView n;
    @NotNull
    private DMCommonTagView o;
    @NotNull
    private ViewGroup p;
    @NotNull
    private TextView q;
    @NotNull
    private TextView r;
    @NotNull
    private WantSeeRecommendView s;
    private int t = n42.a(this.itemView.getContext(), 76.0f);
    private int u = n42.a(this.itemView.getContext(), 102.0f);
    @Nullable
    private Function4<? super Integer, Object, ? super Integer, ? super View, ur2> v;
    @Nullable
    private ProjectItemBean w;

    /* compiled from: Taobao */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeProjectViewHolder a;

        a(WantSeeProjectViewHolder wantSeeProjectViewHolder) {
            this.a = wantSeeProjectViewHolder;
        }

        public void onViewAttachedToWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1855494136")) {
                ipChange.ipc$dispatch("-1855494136", new Object[]{this, view});
                return;
            }
            this.a.l();
            ProjectItemBean projectItemBean = this.a.w;
            if (projectItemBean != null) {
                WantSeeProjectViewHolder wantSeeProjectViewHolder = this.a;
                if (wantSeeProjectViewHolder.i(projectItemBean)) {
                    wantSeeProjectViewHolder.k(projectItemBean);
                }
            }
        }

        public void onViewDetachedFromWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-594933115")) {
                ipChange.ipc$dispatch("-594933115", new Object[]{this, view});
                return;
            }
            this.a.l();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WantSeeProjectViewHolder(@NotNull ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_hor_project_card_view, viewGroup, false));
        k21.i(viewGroup, "parent");
        View findViewById = this.itemView.findViewById(R$id.id_h_project_poster);
        k21.h(findViewById, "itemView.findViewById(R.id.id_h_project_poster)");
        this.a = (DMPosterView) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.id_h_project_title);
        k21.h(findViewById2, "itemView.findViewById(R.id.id_h_project_title)");
        this.b = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R$id.id_h_project_score_layout);
        k21.h(findViewById3, "itemView.findViewById(R.…d_h_project_score_layout)");
        this.c = (ViewGroup) findViewById3;
        View findViewById4 = this.itemView.findViewById(R$id.id_h_project_score);
        k21.h(findViewById4, "itemView.findViewById(R.id.id_h_project_score)");
        this.d = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R$id.id_h_project_pending_price);
        k21.h(findViewById5, "itemView.findViewById(R.…_h_project_pending_price)");
        this.e = findViewById5;
        View findViewById6 = this.itemView.findViewById(R$id.id_h_project_price_layout);
        k21.h(findViewById6, "itemView.findViewById(R.…d_h_project_price_layout)");
        this.f = (ViewGroup) findViewById6;
        View findViewById7 = this.itemView.findViewById(R$id.id_h_project_price);
        k21.h(findViewById7, "itemView.findViewById(R.id.id_h_project_price)");
        this.g = (TextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R$id.id_h_project_address);
        k21.h(findViewById8, "itemView.findViewById(R.id.id_h_project_address)");
        this.h = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R$id.id_h_project_date);
        k21.h(findViewById9, "itemView.findViewById(R.id.id_h_project_date)");
        this.i = (TextView) findViewById9;
        View findViewById10 = this.itemView.findViewById(R$id.id_h_project_action_tip);
        k21.h(findViewById10, "itemView.findViewById(R.….id_h_project_action_tip)");
        this.j = (TextView) findViewById10;
        View findViewById11 = this.itemView.findViewById(R$id.id_h_project_line1);
        k21.h(findViewById11, "itemView.findViewById(R.id.id_h_project_line1)");
        this.k = findViewById11;
        View findViewById12 = this.itemView.findViewById(R$id.id_h_project_rec_layout);
        k21.h(findViewById12, "itemView.findViewById(R.….id_h_project_rec_layout)");
        this.l = (ViewGroup) findViewById12;
        View findViewById13 = this.itemView.findViewById(R$id.id_h_project_rec_prefix_tv);
        k21.h(findViewById13, "itemView.findViewById(R.…_h_project_rec_prefix_tv)");
        this.m = (TextView) findViewById13;
        View findViewById14 = this.itemView.findViewById(R$id.id_h_project_rec_postfix_tv);
        k21.h(findViewById14, "itemView.findViewById(R.…h_project_rec_postfix_tv)");
        this.n = (TextView) findViewById14;
        View findViewById15 = this.itemView.findViewById(R$id.id_h_project_promotion_tag);
        k21.h(findViewById15, "itemView.findViewById(R.…_h_project_promotion_tag)");
        this.o = (DMCommonTagView) findViewById15;
        View findViewById16 = this.itemView.findViewById(R$id.id_h_project_rec_count_down_layout);
        k21.h(findViewById16, "itemView.findViewById(R.…ct_rec_count_down_layout)");
        this.p = (ViewGroup) findViewById16;
        View findViewById17 = this.itemView.findViewById(R$id.id_h_project_rec_count_down_day);
        k21.h(findViewById17, "itemView.findViewById(R.…oject_rec_count_down_day)");
        this.q = (TextView) findViewById17;
        View findViewById18 = this.itemView.findViewById(R$id.id_h_project_rec_count_down_hour_m_s);
        k21.h(findViewById18, "itemView.findViewById(R.…_rec_count_down_hour_m_s)");
        this.r = (TextView) findViewById18;
        View findViewById19 = this.itemView.findViewById(R$id.id_h_project_want_see_rec_layout);
        k21.h(findViewById19, "itemView.findViewById(R.…ject_want_see_rec_layout)");
        this.s = (WantSeeRecommendView) findViewById19;
        this.l.addOnAttachStateChangeListener(new a(this));
    }

    private final CharSequence f(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672813656")) {
            return (CharSequence) ipChange.ipc$dispatch("1672813656", new Object[]{this, projectItemBean});
        }
        StringBuilder sb = new StringBuilder();
        String str = projectItemBean.cityName;
        if (str != null) {
            k21.h(str, RankSquareCMSActivity.PRESET_CITY_NAME);
            sb.append(str);
        }
        String str2 = projectItemBean.venueName;
        if (str2 != null) {
            k21.h(str2, "venueName");
            if (sb.length() > 0) {
                sb.append("·");
            }
            sb.append(str2);
        }
        String str3 = projectItemBean.formattedDistance;
        if (str3 != null) {
            k21.h(str3, "formattedDistance");
            if (sb.length() > 0) {
                sb.append("·距你");
            }
            sb.append(str3);
        }
        return sb;
    }

    private final CharSequence g(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "860923128")) {
            return (CharSequence) ipChange.ipc$dispatch("860923128", new Object[]{this, projectItemBean});
        }
        String str = projectItemBean.liveStartTime;
        String str2 = str == null || str.length() == 0 ? projectItemBean.showTime : projectItemBean.liveStartTime;
        if (!(str2 == null || str2.length() == 0)) {
            z = false;
        }
        if (z) {
            return "时间待定";
        }
        k21.h(str2, "s");
        return str2;
    }

    private final CharSequence h(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1381193242")) {
            return (CharSequence) ipChange.ipc$dispatch("-1381193242", new Object[]{this, projectItemBean});
        }
        String str = projectItemBean.name;
        try {
            if (!TextUtils.isEmpty(str)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                int i2 = StringsKt__StringsKt.f0(spannableStringBuilder, "【", 0, false, 6, null);
                if (i2 >= 0) {
                    spannableStringBuilder.setSpan(new ImageSpan(xs0.a(), R$drawable.symbol_name_left, 1), i2, i2 + 1, 18);
                }
                int i3 = StringsKt__StringsKt.f0(spannableStringBuilder, "】", 0, false, 6, null);
                if (i3 >= 0) {
                    spannableStringBuilder.setSpan(new ImageSpan(xs0.a(), R$drawable.symbol_name_right, 1), i3, i3 + 1, 18);
                }
                return spannableStringBuilder;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean i(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035835308")) {
            return ((Boolean) ipChange.ipc$dispatch("2035835308", new Object[]{this, projectItemBean})).booleanValue();
        } else if (!k21.d("1", projectItemBean.recommendHintType) || projectItemBean.getCountDownTimeMills() <= 0 || projectItemBean.tempDeviceBootTime <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void k(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617223809")) {
            ipChange.ipc$dispatch("-617223809", new Object[]{this, projectItemBean});
            return;
        }
        this.l.setVisibility(0);
        this.p.setVisibility(0);
        this.n.setVisibility(8);
        this.m.setText(projectItemBean.recommendHintTitle);
        long countDownTimeMills = projectItemBean.getCountDownTimeMills() - (SystemClock.elapsedRealtime() - projectItemBean.tempDeviceBootTime);
        if (countDownTimeMills > 0) {
            WeakRefCountDownTimer weakRefCountDownTimer = new WeakRefCountDownTimer(countDownTimeMills, 1000, this);
            this.l.setTag(weakRefCountDownTimer);
            weakRefCountDownTimer.start();
            TimerView.a dateResult = TimerView.getDateResult(countDownTimeMills);
            k21.h(dateResult, "getDateResult(countDownMsSurplus)");
            this.q.setText(dateResult.a);
            this.r.setText(dateResult.b + jl1.CONDITION_IF_MIDDLE + dateResult.c + jl1.CONDITION_IF_MIDDLE + dateResult.d);
            return;
        }
        this.q.setText("00");
        this.r.setText("00:00:00");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484999566")) {
            ipChange.ipc$dispatch("-484999566", new Object[]{this});
            return;
        }
        Object tag = this.l.getTag();
        if (tag != null && (tag instanceof WeakRefCountDownTimer)) {
            ((WeakRefCountDownTimer) tag).cancel();
            this.l.setTag(null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x024e, code lost:
        r13 = r12.gotTopTag(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0252, code lost:
        if (r13 == null) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0258, code lost:
        if (r13.isWednesdayDiscount() == false) goto L_0x0268;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x025a, code lost:
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT);
        r11.o.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x026e, code lost:
        if (android.text.TextUtils.isEmpty(r13.shortTag) != false) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0270, code lost:
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(r13.shortTag);
        r11.o.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0284, code lost:
        r13 = r11.o;
        r0 = r12.recommendHintLabel;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0288, code lost:
        if (r0 == null) goto L_0x0292;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x028e, code lost:
        if (r0.length() != 0) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0291, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0292, code lost:
        if (r4 == false) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0294, code lost:
        r0 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0297, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0298, code lost:
        r13.setVisibility(r0);
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_PREFERENTIAL).setTagName(r12.recommendHintLabel);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02ad, code lost:
        if (r13.equals("2") != false) goto L_0x02b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02b4, code lost:
        if (r12.ifIsNewMarketTag() == false) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02b6, code lost:
        r13 = r12.gotTopTag(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ba, code lost:
        if (r13 == null) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02c0, code lost:
        if (r13.isWednesdayDiscount() == false) goto L_0x02cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02c2, code lost:
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT);
        r11.o.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02d5, code lost:
        if (android.text.TextUtils.isEmpty(r13.shortTag) != false) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02d7, code lost:
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(r13.shortTag);
        r11.o.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ea, code lost:
        r13 = r11.o;
        r0 = r12.recommendHintLabel;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02ee, code lost:
        if (r0 == null) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02f4, code lost:
        if (r0.length() != 0) goto L_0x02f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02f7, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02f8, code lost:
        if (r4 == false) goto L_0x02fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02fa, code lost:
        r0 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02fd, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02fe, code lost:
        r13.setVisibility(r0);
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_MEMBER).setTagName(r12.recommendHintLabel);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x030f, code lost:
        r11.o.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0314, code lost:
        r11.l.setVisibility(0);
        r11.n.setVisibility(0);
        r11.p.setVisibility(8);
        r11.m.setText(r12.recommendHintTitle);
        r11.n.setText(r12.recommendHintDesc);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0354, code lost:
        if (r13.equals("0") == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01fb, code lost:
        if (r13.equals("7") == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0205, code lost:
        if (r13.equals("6") == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x020f, code lost:
        if (r13.equals("5") == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0217, code lost:
        if (r13.equals("4") == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x021f, code lost:
        if (r13.equals("3") == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0227, code lost:
        if (r13.equals("2") == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x022b, code lost:
        r13 = r12.recommendHintType;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x022d, code lost:
        if (r13 == null) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0233, code lost:
        switch(r13.hashCode()) {
            case 50: goto L_0x02a9;
            case 51: goto L_0x0240;
            case 52: goto L_0x0238;
            default: goto L_0x0236;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x023c, code lost:
        if (r13.equals("4") != false) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0244, code lost:
        if (r13.equals("3") != false) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x024c, code lost:
        if (r12.ifIsNewMarketTag() == false) goto L_0x0284;
     */
    public final void e(@Nullable ProjectItemBean projectItemBean, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1121249424")) {
            ipChange.ipc$dispatch("1121249424", new Object[]{this, projectItemBean, Integer.valueOf(i2)});
            return;
        }
        this.w = projectItemBean;
        if (projectItemBean != null) {
            this.itemView.setTag(projectItemBean);
            this.a.setImageUrlForWebp(projectItemBean.verticalPic, this.t, this.u);
            this.a.setVideoIconVisibility(projectItemBean.hasVideo() ? 0 : 8);
            this.a.setCategoryTagName(projectItemBean.getCategoryNameCompat());
            String str = projectItemBean.liveStatus;
            if (k21.d(str, "1")) {
                this.a.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if (k21.d(str, "2")) {
                this.a.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
            } else {
                this.a.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            }
            if (projectItemBean.isXiaJiaProject()) {
                this.a.setLabelType(null);
            } else if (projectItemBean.isHotProject()) {
                this.a.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
            } else if (k21.d(projectItemBean.brandOptimizationTag, "HIGHEST_HEAT")) {
                this.a.setLabelType(DMLabelType.LABEL_TYPE_HIGHEST_HOT);
            } else if (k21.d(projectItemBean.brandOptimizationTag, "NEW_SHELF")) {
                this.a.setLabelType(DMLabelType.LABEL_TYPE_NEW_SALE);
            } else if (k21.d(projectItemBean.brandOptimizationTag, "ON_SOON")) {
                this.a.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE);
            } else {
                this.a.setLabelType(null);
            }
            this.b.setText(h(projectItemBean));
            this.h.setText(f(projectItemBean));
            if (projectItemBean.isXiaJiaProject()) {
                this.i.setVisibility(4);
            } else {
                this.i.setVisibility(0);
                this.i.setText(g(projectItemBean));
            }
            if (projectItemBean.isXiaJiaProject()) {
                this.j.setText("已下架");
                this.j.setBackgroundResource(R$drawable.shape_want_see_xiajia);
                this.j.setTextColor(Color.parseColor("#6A7A99"));
            } else {
                this.j.setBackgroundResource(R$drawable.bg_rank_item_project_buy);
                this.j.setText("购票");
                this.j.setTextColor(Color.parseColor("#FF4886"));
            }
            if (projectItemBean.itemScore > 0.0d) {
                this.c.setVisibility(0);
                this.d.setText(String.valueOf(projectItemBean.itemScore));
            } else {
                this.c.setVisibility(8);
            }
            if (projectItemBean.isXiaJiaProject()) {
                this.f.setVisibility(8);
                this.e.setVisibility(8);
            } else {
                String str2 = projectItemBean.promotionPrice;
                if (str2 == null) {
                    str2 = projectItemBean.priceLow;
                }
                if (!(str2 == null || (o.y(str2)))) {
                    k21.h(str2, "priceLow");
                    if (!(StringsKt__StringsKt.Q(str2, "待定", false, 2, null))) {
                        this.e.setVisibility(8);
                        this.f.setVisibility(0);
                        this.g.setText(str2);
                    }
                }
                this.e.setVisibility(0);
                this.f.setVisibility(8);
            }
            this.k.setVisibility((this.c.getVisibility() == 0 && (this.e.getVisibility() == 0 || this.f.getVisibility() == 0)) ? 0 : 8);
            if (d20.K()) {
                this.s.setOnEventListener(this.v);
                this.s.bindData(projectItemBean.recommendProjects);
            } else {
                this.s.setVisibility(8);
            }
            l();
            this.o.setPadding(0, 0, 0, 0);
            String str3 = projectItemBean.recommendHintType;
            if (str3 != null) {
                switch (str3.hashCode()) {
                    case 48:
                        break;
                    case 49:
                        if (str3.equals("1")) {
                            if (i(projectItemBean)) {
                                k(projectItemBean);
                            } else {
                                this.l.setVisibility(8);
                            }
                            this.o.setVisibility(8);
                            return;
                        }
                        this.l.setVisibility(8);
                        return;
                    case 50:
                        break;
                    case 51:
                        break;
                    case 52:
                        break;
                    case 53:
                        break;
                    case 54:
                        break;
                    case 55:
                        break;
                    default:
                        this.l.setVisibility(8);
                        return;
                }
            }
            this.l.setVisibility(8);
        }
    }

    public final void j(@Nullable Function4<? super Integer, Object, ? super Integer, ? super View, ur2> function4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751361446")) {
            ipChange.ipc$dispatch("751361446", new Object[]{this, function4});
            return;
        }
        this.v = function4;
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700067358")) {
            ipChange.ipc$dispatch("1700067358", new Object[]{this});
            return;
        }
        this.q.setText("00");
        this.r.setText("00:00:00");
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onTick(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353860240")) {
            ipChange.ipc$dispatch("-1353860240", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        TimerView.a dateResult = TimerView.getDateResult(j2);
        k21.h(dateResult, "getDateResult(millisUntilFinished)");
        this.q.setText(dateResult.a);
        this.r.setText(dateResult.b + jl1.CONDITION_IF_MIDDLE + dateResult.c + jl1.CONDITION_IF_MIDDLE + dateResult.d);
    }
}
