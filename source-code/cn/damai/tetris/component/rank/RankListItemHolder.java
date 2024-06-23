package cn.damai.tetris.component.rank;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.component.rank.bean.RecommendHint;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.SeeAnimateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.jvm.JvmField;
import kotlin.text.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bx1;
import tb.gr;
import tb.k21;
import tb.m40;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public final class RankListItemHolder extends BaseViewHolder<RankItemBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static HashMap<Long, Boolean> u = new HashMap<>();
    @Nullable
    private final OnItemClickListener<RankItemBean> a;
    @JvmField
    @Nullable
    public RankItemBean b;
    @NotNull
    private final DMPosterView c;
    @NotNull
    private final TextView d;
    @NotNull
    private final TextView e;
    @NotNull
    private final TextView f;
    @NotNull
    private final View g;
    @NotNull
    private final TextView h;
    @NotNull
    private final DMDigitTextView i;
    @NotNull
    private final TextView j;
    @NotNull
    private final TextView k;
    @NotNull
    private final DMDigitTextView l;
    @NotNull
    private final SeeAnimateView m;
    @NotNull
    private final TextView n;
    private final int o = n42.a(xs0.a(), 72.0f);
    private final int p = n42.a(xs0.a(), 102.0f);
    @NotNull
    private final Context q;
    @NotNull
    private DMCommonTagView r;
    @NotNull
    private final TextView s;
    @NotNull
    private final TextView t;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final HashMap<Long, Boolean> a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "186216691")) {
                return RankListItemHolder.u;
            }
            return (HashMap) ipChange.ipc$dispatch("186216691", new Object[]{this});
        }

        public final void b(@NotNull HashMap<Long, Boolean> hashMap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "410869551")) {
                ipChange.ipc$dispatch("410869551", new Object[]{this, hashMap});
                return;
            }
            k21.i(hashMap, "<set-?>");
            RankListItemHolder.u = hashMap;
        }
    }

    public RankListItemHolder(@Nullable View view, @Nullable OnItemClickListener<RankItemBean> onItemClickListener) {
        super(view);
        this.a = onItemClickListener;
        View findViewById = this.itemView.findViewById(R$id.poster);
        k21.h(findViewById, "itemView.findViewById(R.id.poster)");
        this.c = (DMPosterView) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.tv_order);
        k21.h(findViewById2, "itemView.findViewById(R.id.tv_order)");
        this.d = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R$id.tv_title);
        k21.h(findViewById3, "itemView.findViewById(R.id.tv_title)");
        this.e = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R$id.tv_desc);
        k21.h(findViewById4, "itemView.findViewById(R.id.tv_desc)");
        this.f = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R$id.tv_desc_num);
        k21.h(findViewById5, "itemView.findViewById(R.id.tv_desc_num)");
        this.h = (TextView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R$id.view);
        k21.h(findViewById6, "itemView.findViewById(R.id.view)");
        this.g = findViewById6;
        View findViewById7 = this.itemView.findViewById(R$id.tv_price_num);
        k21.h(findViewById7, "itemView.findViewById(R.id.tv_price_num)");
        this.i = (DMDigitTextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R$id.tv_price);
        k21.h(findViewById8, "itemView.findViewById(R.id.tv_price)");
        this.j = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R$id.tv_venue);
        k21.h(findViewById9, "itemView.findViewById(R.id.tv_venue)");
        this.k = (TextView) findViewById9;
        View findViewById10 = this.itemView.findViewById(R$id.tv_venue_dis);
        k21.h(findViewById10, "itemView.findViewById(R.id.tv_venue_dis)");
        this.l = (DMDigitTextView) findViewById10;
        View findViewById11 = this.itemView.findViewById(R$id.tv_time);
        k21.h(findViewById11, "itemView.findViewById(R.id.tv_time)");
        this.n = (TextView) findViewById11;
        View findViewById12 = this.itemView.findViewById(R$id.wanna_2_see_icon);
        k21.h(findViewById12, "itemView.findViewById(R.id.wanna_2_see_icon)");
        SeeAnimateView seeAnimateView = (SeeAnimateView) findViewById12;
        this.m = seeAnimateView;
        View findViewById13 = this.itemView.findViewById(R$id.id_h_project_promotion_tag);
        k21.h(findViewById13, "itemView.findViewById(R.…_h_project_promotion_tag)");
        this.r = (DMCommonTagView) findViewById13;
        View findViewById14 = this.itemView.findViewById(R$id.id_h_project_rec_prefix_tv);
        k21.h(findViewById14, "itemView.findViewById(R.…_h_project_rec_prefix_tv)");
        this.s = (TextView) findViewById14;
        View findViewById15 = this.itemView.findViewById(R$id.id_h_project_rec_postfix_tv);
        k21.h(findViewById15, "itemView.findViewById(R.…h_project_rec_postfix_tv)");
        this.t = (TextView) findViewById15;
        seeAnimateView.setCancelImage();
        seeAnimateView.setOnClickListener(new bx1(this));
        this.itemView.setOnClickListener(this);
        Context context = this.itemView.getContext();
        k21.h(context, "itemView.context");
        this.q = context;
    }

    /* access modifiers changed from: private */
    public static final void d(RankListItemHolder rankListItemHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251188546")) {
            ipChange.ipc$dispatch("-251188546", new Object[]{rankListItemHolder, view});
            return;
        }
        k21.i(rankListItemHolder, "this$0");
        rankListItemHolder.l();
    }

    private final String i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "755398891")) {
            return (String) ipChange.ipc$dispatch("755398891", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        RankItemBean rankItemBean = this.b;
        if (rankItemBean == null) {
            return "";
        }
        if (!TextUtils.isEmpty(rankItemBean.cityName)) {
            sb.append(rankItemBean.cityName);
            if (!TextUtils.isEmpty(rankItemBean.venueName)) {
                sb.append("·");
                sb.append(rankItemBean.venueName);
            }
            if (!TextUtils.isEmpty(rankItemBean.getDistance())) {
                sb.append("·距你");
            }
        } else if (!TextUtils.isEmpty(rankItemBean.venueName)) {
            sb.append(rankItemBean.venueName);
            if (!TextUtils.isEmpty(rankItemBean.getDistance())) {
                sb.append("·距你");
            }
        } else if (!TextUtils.isEmpty(rankItemBean.getDistance())) {
            sb.append("距你");
        }
        String sb2 = sb.toString();
        k21.h(sb2, "locationDes.toString()");
        return sb2;
    }

    private final String j(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190214950")) {
            return (String) ipChange.ipc$dispatch("1190214950", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 <= 0) {
            return i2 + "";
        } else if (i2 >= 10000) {
            try {
                String valueOf = String.valueOf(((float) ((int) ((((float) i2) / ((float) 10000)) * ((float) 10)))) / 10.0f);
                if (g.v(valueOf, "0", false, 2, null)) {
                    valueOf = valueOf.substring(0, valueOf.length() - 2);
                    k21.h(valueOf, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                return valueOf + (char) 19975;
            } catch (Exception unused) {
                return "";
            }
        } else {
            return i2 + "";
        }
    }

    private final SpannableStringBuilder k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939896128")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("-1939896128", new Object[]{this, str});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (g.Q(str, "【", false, 2, null)) {
            int f0 = g.f0(str, "【", 0, false, 6, null);
            spannableStringBuilder.setSpan(new ImageSpan(xs0.a(), R$drawable.symbol_name_left, 1), f0, f0 + 1, 18);
        }
        if (g.Q(str, "】", false, 2, null)) {
            int f02 = g.f0(str, "】", 0, false, 6, null);
            spannableStringBuilder.setSpan(new ImageSpan(xs0.a(), R$drawable.symbol_name_right, 1), f02, f02 + 1, 18);
        }
        return spannableStringBuilder;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* renamed from: h */
    public void a(@Nullable RankItemBean rankItemBean, int i2) {
        MarketTagBean gotTopTag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1839460142")) {
            ipChange.ipc$dispatch("-1839460142", new Object[]{this, rankItemBean, Integer.valueOf(i2)});
            return;
        }
        this.b = rankItemBean;
        if (rankItemBean != null) {
            if (u.get(Long.valueOf(rankItemBean.id)) == null) {
                u.put(Long.valueOf(rankItemBean.id), Boolean.valueOf(rankItemBean.followStatus > 0));
            }
            String str = rankItemBean.headPic;
            if (str != null) {
                this.c.setImageUrlForWebp(str, this.p, this.o);
            }
            String str2 = rankItemBean.name;
            String str3 = null;
            if (str2 != null) {
                this.e.setText(str2 != null ? k(str2) : null);
            }
            String str4 = rankItemBean.price;
            if (TextUtils.isEmpty(str4) || k21.d(str4, "待定") || k21.d(str4, "价格待定")) {
                this.i.setText("价格待定");
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.i.setText(str4);
            }
            String str5 = rankItemBean.showTime;
            if (str5 != null) {
                this.n.setText(str5);
            }
            String str6 = rankItemBean.venueName;
            if (str6 != null) {
                this.k.setText(str6);
            }
            if (k21.d(u.get(Long.valueOf(rankItemBean.id)), Boolean.TRUE)) {
                this.m.setFollowImage();
            } else {
                this.m.setCancelImage();
            }
            if (rankItemBean.order > 0) {
                this.d.setVisibility(0);
                int i3 = rankItemBean.order;
                if (i3 < 10) {
                    this.d.setTextSize(20.0f);
                    int i4 = rankItemBean.order;
                    if (i4 == 1) {
                        this.d.setBackground(xs0.a().getResources().getDrawable(R$drawable.bg_rank_project_item_order1));
                        this.d.setText("1");
                    } else if (i4 == 2) {
                        this.d.setBackground(xs0.a().getResources().getDrawable(R$drawable.bg_rank_project_item_order2));
                        this.d.setText("2");
                    } else if (i4 != 3) {
                        this.d.setBackground(xs0.a().getResources().getDrawable(R$drawable.bg_rank_project_item_order4));
                        this.d.setText(String.valueOf(rankItemBean.order));
                    } else {
                        this.d.setBackground(xs0.a().getResources().getDrawable(R$drawable.bg_rank_project_item_order3));
                        this.d.setText("3");
                    }
                } else if (i3 < 100) {
                    this.d.setTextSize(15.0f);
                    this.d.setBackground(xs0.a().getResources().getDrawable(R$drawable.bg_rank_project_item_order4));
                    this.d.setText(String.valueOf(rankItemBean.order));
                } else {
                    this.d.setVisibility(8);
                }
            } else {
                this.d.setVisibility(8);
            }
            this.f.setVisibility(0);
            this.h.setVisibility(0);
            this.g.setVisibility(0);
            if (rankItemBean.type == 6 && rankItemBean.getWantSeeCount() > 0) {
                this.f.setText(R$string.dm_rank_project_want_see);
                this.h.setTextColor(Color.parseColor("#FF79BD"));
                this.h.setText(j(rankItemBean.getWantSeeCount()));
            } else if (rankItemBean.itemScore > 0.0d) {
                this.f.setText(R$string.dm_rank_project_score);
                this.h.setTextColor(Color.parseColor("#FF901C"));
                this.h.setText(String.valueOf(rankItemBean.itemScore));
            } else if (rankItemBean.getWantSeeCount() > 0) {
                this.f.setText(R$string.dm_rank_project_want_see);
                this.h.setTextColor(Color.parseColor("#FF79BD"));
                this.h.setText(j(rankItemBean.getWantSeeCount()));
            } else if (rankItemBean.ipvuv > 0) {
                this.f.setText(R$string.dm_rank_project_ipuv);
                this.h.setTextColor(Color.parseColor("#9781EE"));
                this.h.setText(j(rankItemBean.ipvuv));
            } else {
                this.f.setVisibility(8);
                this.h.setVisibility(8);
                this.g.setVisibility(8);
            }
            this.k.setText(i());
            if (!TextUtils.isEmpty(rankItemBean.getDistance())) {
                this.l.setText(rankItemBean.getDistance());
            }
            ViewParent parent = this.r.getParent();
            k21.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).setVisibility(8);
            RecommendHint recommendHint = rankItemBean.recommendHint;
            if (!TextUtils.isEmpty(recommendHint != null ? recommendHint.title : null)) {
                RecommendHint recommendHint2 = rankItemBean.recommendHint;
                if (!TextUtils.isEmpty(recommendHint2 != null ? recommendHint2.desc : null)) {
                    TextView textView = this.s;
                    RecommendHint recommendHint3 = rankItemBean.recommendHint;
                    textView.setText(recommendHint3 != null ? recommendHint3.title : null);
                    TextView textView2 = this.t;
                    RecommendHint recommendHint4 = rankItemBean.recommendHint;
                    if (recommendHint4 != null) {
                        str3 = recommendHint4.desc;
                    }
                    textView2.setText(str3);
                    View findViewById = this.itemView.findViewById(R$id.id_h_project_rec_div);
                    k21.g(findViewById, "null cannot be cast to non-null type android.view.View");
                    findViewById.setVisibility(0);
                    gotTopTag = rankItemBean.gotTopTag(true);
                    if (gotTopTag != null) {
                        return;
                    }
                    if (gotTopTag.isWednesdayDiscount()) {
                        this.r.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT);
                        ViewParent parent2 = this.r.getParent();
                        k21.g(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                        ((ViewGroup) parent2).setVisibility(0);
                        return;
                    } else if (!TextUtils.isEmpty(gotTopTag.shortTag)) {
                        this.r.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(gotTopTag.shortTag);
                        ViewParent parent3 = this.r.getParent();
                        k21.g(parent3, "null cannot be cast to non-null type android.view.ViewGroup");
                        ((ViewGroup) parent3).setVisibility(0);
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.s.setText("");
            this.t.setText("");
            View findViewById2 = this.itemView.findViewById(R$id.id_h_project_rec_div);
            k21.g(findViewById2, "null cannot be cast to non-null type android.view.View");
            findViewById2.setVisibility(8);
            gotTopTag = rankItemBean.gotTopTag(true);
            if (gotTopTag != null) {
            }
        }
    }

    public final void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504789225")) {
            ipChange.ipc$dispatch("-1504789225", new Object[]{this});
            return;
        }
        RankItemBean rankItemBean = this.b;
        if (rankItemBean != null) {
            if (LoginManager.k().q()) {
                int i2 = !k21.d(u.get(Long.valueOf(rankItemBean.id)), Boolean.TRUE) ? 1 : 0;
                FollowRequest followRequest = new FollowRequest();
                followRequest.operateType = String.valueOf(i2);
                followRequest.targetId = String.valueOf(rankItemBean.id);
                followRequest.targetType = "7";
                followRequest.request(new RankListItemHolder$wantSeeClick$1(rankItemBean, this, FollowDataBean.class));
                return;
            }
            DMNav.from(this.q).forResult(4097).toUri(gr.f());
        }
    }

    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1743251443")) {
            ipChange.ipc$dispatch("-1743251443", new Object[]{this, view});
            return;
        }
        k21.i(view, "v");
        OnItemClickListener<RankItemBean> onItemClickListener = this.a;
        if (onItemClickListener != null) {
            RankItemBean rankItemBean = this.b;
            k21.f(rankItemBean);
            onItemClickListener.onItemClick(rankItemBean, rankItemBean.index);
        }
    }

    public final void updateFollowState(@NotNull FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1803518598")) {
            ipChange.ipc$dispatch("-1803518598", new Object[]{this, followDataBean});
            return;
        }
        k21.i(followDataBean, "bean");
        RankItemBean rankItemBean = this.b;
        if (rankItemBean != null) {
            HashMap<Long, Boolean> hashMap = u;
            Long valueOf = Long.valueOf(rankItemBean.id);
            if (followDataBean.getStatus() <= 0) {
                z = false;
            }
            hashMap.put(valueOf, Boolean.valueOf(z));
            if (k21.d(u.get(Long.valueOf(rankItemBean.id)), Boolean.TRUE)) {
                this.m.setFollowImage();
                this.m.clickAnimate();
                return;
            }
            this.m.setCancelImage();
            this.m.cancelAnimate();
        }
    }
}
