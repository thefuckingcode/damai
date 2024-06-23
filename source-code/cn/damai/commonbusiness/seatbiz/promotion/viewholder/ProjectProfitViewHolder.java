package cn.damai.commonbusiness.seatbiz.promotion.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.commonbusiness.seatbiz.promotion.OnCouponApplyClickListener;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponActivityBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponSubActBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.UserProfitInfoBean;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.uikit.number.DMDigitTextView;
import com.alibaba.pictures.bricks.view.BricksThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.h03;
import tb.s71;
import tb.yu1;

/* compiled from: Taobao */
public class ProjectProfitViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCouponApplyClickListener a;
    private LinearLayout b;
    private DMDigitTextView c;
    private DMDigitTextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private LinearLayout j;
    private TextView k;
    private View l;
    private LinearLayout m;
    private TextView n;
    private Context o;
    private ViewGroup p;
    private TextView q;
    private ViewGroup r;
    private TextView s;
    private ViewGroup t;
    boolean u;
    private String v;
    private String w;
    private BricksThemeDialog x;
    private StringBuilder y = new StringBuilder();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-525187687")) {
                ipChange.ipc$dispatch("-525187687", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(yu1.f().h(ProjectProfitViewHolder.this.v, this.a));
            ProjectProfitViewHolder.this.k();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CouponActivityBean a;
        final /* synthetic */ UserProfitInfoBean b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;
        final /* synthetic */ CouponSubActBean e;

        b(CouponActivityBean couponActivityBean, UserProfitInfoBean userProfitInfoBean, int i, boolean z, CouponSubActBean couponSubActBean) {
            this.a = couponActivityBean;
            this.b = userProfitInfoBean;
            this.c = i;
            this.d = z;
            this.e = couponSubActBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1586102682")) {
                ipChange.ipc$dispatch("1586102682", new Object[]{this, view});
                return;
            }
            ProjectProfitViewHolder projectProfitViewHolder = ProjectProfitViewHolder.this;
            if (projectProfitViewHolder.u) {
                if (this.a.isMaxVipEnable()) {
                    ProjectProfitViewHolder.this.i(this.a, this.b, this.c);
                } else if (this.a.isNoauthIsVip()) {
                    cn.damai.common.user.c.e().x(yu1.f().i(ProjectProfitViewHolder.this.v, ProjectProfitViewHolder.this.w, String.valueOf(this.b.vipLevel), this.a.getProfitDrawStatus(), this.a.getProfitPoolId(), "1"));
                    ProjectProfitViewHolder.this.k();
                }
            } else if (this.a != null && this.d) {
                OnCouponApplyClickListener onCouponApplyClickListener = projectProfitViewHolder.a;
                CouponActivityBean couponActivityBean = this.a;
                onCouponApplyClickListener.onClick(couponActivityBean, this.c, couponActivityBean.getCouponActSpreadId(), this.e.getName(), this.e.getAppAsacCode());
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements MemberAuthPopWindow.ICustomDialogEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow.ICustomDialogEventListener
        public void dialogItemEvent(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1095159467")) {
                ipChange.ipc$dispatch("1095159467", new Object[]{this, str});
            } else if ("success".equals(str) && ProjectProfitViewHolder.this.a != null) {
                ProjectProfitViewHolder.this.a.refreshCouponRequest();
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ CouponActivityBean b;

        d(String str, CouponActivityBean couponActivityBean) {
            this.a = str;
            this.b = couponActivityBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1513716124")) {
                ipChange.ipc$dispatch("1513716124", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(yu1.f().j(ProjectProfitViewHolder.this.v, ProjectProfitViewHolder.this.w, this.a, this.b.getProfitPoolId()));
        }
    }

    /* compiled from: Taobao */
    public class e implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e(ProjectProfitViewHolder projectProfitViewHolder) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1611619634")) {
                ipChange.ipc$dispatch("1611619634", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ CouponActivityBean b;
        final /* synthetic */ int c;

        f(String str, CouponActivityBean couponActivityBean, int i) {
            this.a = str;
            this.b = couponActivityBean;
            this.c = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1441329566")) {
                ipChange.ipc$dispatch("1441329566", new Object[]{this, view});
            } else if (ProjectProfitViewHolder.this.a != null) {
                cn.damai.common.user.c.e().x(yu1.f().k(ProjectProfitViewHolder.this.v, ProjectProfitViewHolder.this.w, this.a, this.b.getProfitPoolId()));
                ProjectProfitViewHolder.this.a.onIntegralConvertClick(this.c, this.b.getProfitPoolSpreadId(), this.b.getExchange4Dm(), this.b.getProfitAsac());
            }
        }
    }

    public ProjectProfitViewHolder(Context context, View view, OnCouponApplyClickListener onCouponApplyClickListener) {
        super(view);
        this.o = context;
        this.a = onCouponApplyClickListener;
        this.b = (LinearLayout) view.findViewById(R$id.ll_container);
        this.c = (DMDigitTextView) view.findViewById(R$id.tv_money);
        this.d = (DMDigitTextView) view.findViewById(R$id.tv_money_prefix);
        this.e = (TextView) view.findViewById(R$id.tv_money_desc);
        this.f = (TextView) view.findViewById(R$id.tv_title);
        this.g = (TextView) view.findViewById(R$id.tv_desc);
        this.h = (LinearLayout) view.findViewById(R$id.ll_integral_convert);
        this.i = (TextView) view.findViewById(R$id.btn_integral_convert);
        this.j = (LinearLayout) view.findViewById(R$id.ll_integral_value);
        this.k = (TextView) view.findViewById(R$id.btn_integral_value);
        this.l = view.findViewById(R$id.vip_tag);
        this.m = (LinearLayout) view.findViewById(R$id.ll_member_authorithize);
        this.n = (TextView) view.findViewById(R$id.tv_member_authorithize_desc);
        TextView textView = (TextView) view.findViewById(R$id.tv_member_authorithize_action);
        this.p = (ViewGroup) view.findViewById(R$id.container_one_plus_one);
        this.q = (TextView) view.findViewById(R$id.tv_coupon_single_name);
        this.r = (ViewGroup) view.findViewById(R$id.container_fixed_price);
        this.s = (TextView) view.findViewById(R$id.tv_fixed_price_money);
        this.t = (ViewGroup) view.findViewById(R$id.container_common_price);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i(CouponActivityBean couponActivityBean, UserProfitInfoBean userProfitInfoBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539554467")) {
            ipChange.ipc$dispatch("-539554467", new Object[]{this, couponActivityBean, userProfitInfoBean, Integer.valueOf(i2)});
        } else if (couponActivityBean != null && couponActivityBean.getSubCouponActExs() != null && couponActivityBean.getSubCouponActExs().size() != 0) {
            String valueOf = String.valueOf(userProfitInfoBean.vipLevel);
            cn.damai.common.user.c.e().x(yu1.f().i(this.v, this.w, valueOf, couponActivityBean.getProfitDrawStatus(), couponActivityBean.getProfitPoolId(), "0"));
            StringBuilder sb = this.y;
            sb.delete(0, sb.length());
            this.y.append("本次兑换将消耗");
            int length = this.y.length();
            this.y.append(couponActivityBean.getProfitPoint());
            int length2 = this.y.length();
            StringBuilder sb2 = this.y;
            sb2.append("积分（当前有" + couponActivityBean.getProfitCurrentPoint() + "积分）");
            SpannableString spannableString = new SpannableString(this.y.toString());
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F38066")), length, length2, 18);
            SpannableString spannableString2 = null;
            if (!TextUtils.isEmpty(couponActivityBean.getDesc())) {
                spannableString2 = new SpannableString("使用规则\n" + couponActivityBean.getDesc());
                spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, 4, 18);
                spannableString2.setSpan(new AbsoluteSizeSpan(16, true), 0, 4, 18);
            }
            if (this.x == null) {
                this.x = new BricksThemeDialog(this.o);
            }
            if (!this.x.isShowing()) {
                this.x.n(R$drawable.score_icon).q(GridBean.TYPE_PIC_URL, 83).p(GridBean.TYPE_PIC_URL, 55).o(R$drawable.score_bg).k(GravityCompat.START).m("确认兑换此优惠券吗").l(spannableString).j(spannableString2).f(R$drawable.sku_promotion_profit_bg).i("确认兑换", ContextCompat.getColor(this.o, R$color.color_582331), new f(valueOf, couponActivityBean, i2)).e(R$drawable.bg_vip_exchange_dialog_cancel).g("取消", Color.parseColor("#F38066"), new e(this)).h(true, new d(valueOf, couponActivityBean));
                Context context = this.o;
                if (context != null && (context instanceof Activity) && !((BaseActivity) context).isActivityFinsihed()) {
                    this.x.show();
                }
            }
        }
    }

    private void j(CouponSubActBean couponSubActBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-227813878")) {
            ipChange.ipc$dispatch("-227813878", new Object[]{this, couponSubActBean});
            return;
        }
        String decreaseMoneyTag = couponSubActBean.getDecreaseMoneyTag();
        if (CouponSubActBean.SUB_BIZ_TYPE_MEMBER_COUPON_ORDER_BOGO.equals(couponSubActBean.subBizType)) {
            this.p.setVisibility(0);
            this.r.setVisibility(8);
            this.t.setVisibility(8);
            if (TextUtils.isEmpty(decreaseMoneyTag)) {
                this.q.setText("");
                return;
            }
            if (decreaseMoneyTag.startsWith("￥")) {
                decreaseMoneyTag = decreaseMoneyTag.substring(1);
            }
            this.q.setText(decreaseMoneyTag);
        } else if (CouponSubActBean.SUB_BIZ_TYPE_MEMBER_COUPON_ORDER_REDUCE_TO.equals(couponSubActBean.subBizType)) {
            this.p.setVisibility(8);
            this.r.setVisibility(0);
            this.t.setVisibility(8);
            if (TextUtils.isEmpty(decreaseMoneyTag)) {
                this.s.setText("");
                return;
            }
            if (decreaseMoneyTag.startsWith("￥")) {
                decreaseMoneyTag = decreaseMoneyTag.substring(1);
            }
            int length = decreaseMoneyTag.length();
            if (length > 5) {
                this.s.setTextSize(1, 16.0f);
            } else if (length > 4) {
                this.s.setTextSize(1, 19.0f);
            } else if (length > 3) {
                this.s.setTextSize(1, 22.0f);
            } else {
                this.s.setTextSize(1, 25.0f);
            }
            this.s.setText(decreaseMoneyTag);
        } else {
            this.p.setVisibility(8);
            this.r.setVisibility(8);
            this.t.setVisibility(0);
            if (TextUtils.isEmpty(decreaseMoneyTag)) {
                this.c.setText("");
                return;
            }
            if (decreaseMoneyTag.startsWith("￥")) {
                decreaseMoneyTag = decreaseMoneyTag.substring(1);
            }
            if (decreaseMoneyTag.length() > 5) {
                this.c.setTextSize(1, 22.0f);
            } else {
                this.c.setTextSize(1, 26.0f);
            }
            this.c.setText(decreaseMoneyTag);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1750641347")) {
            ipChange.ipc$dispatch("1750641347", new Object[]{this});
            return;
        }
        Context context = this.o;
        if (context != null && (context instanceof Activity)) {
            h03.g(context, (Activity) context, this.v, new c());
        }
    }

    public void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-917328712")) {
            ipChange.ipc$dispatch("-917328712", new Object[]{this, Boolean.valueOf(z)});
        } else if (!z) {
            this.c.setTextColor(Color.parseColor("#FF4886"));
            DMDigitTextView dMDigitTextView = this.d;
            if (dMDigitTextView != null) {
                dMDigitTextView.setTextColor(Color.parseColor("#FF4886"));
            }
            this.e.setTextColor(Color.parseColor("#999999"));
            this.f.setTextColor(Color.parseColor("#2E333E"));
            this.g.setTextColor(Color.parseColor("#999999"));
        } else {
            this.c.setTextColor(Color.parseColor("#582331"));
            DMDigitTextView dMDigitTextView2 = this.d;
            if (dMDigitTextView2 != null) {
                dMDigitTextView2.setTextColor(Color.parseColor("#582331"));
            }
            this.e.setTextColor(Color.parseColor("#A67070"));
            this.f.setTextColor(Color.parseColor("#582331"));
            this.g.setTextColor(Color.parseColor("#999999"));
        }
    }

    public void g(CouponActivityBean couponActivityBean, UserProfitInfoBean userProfitInfoBean, String str, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973462249")) {
            ipChange.ipc$dispatch("973462249", new Object[]{this, couponActivityBean, userProfitInfoBean, str, str2, Integer.valueOf(i2)});
        } else if (couponActivityBean != null && !s71.a(couponActivityBean.getSubCouponActExs()) && couponActivityBean.getSubCouponActExs().get(0) != null) {
            CouponSubActBean couponSubActBean = couponActivityBean.getSubCouponActExs().get(0);
            j(couponSubActBean);
            if (!TextUtils.isEmpty(couponSubActBean.getTag())) {
                this.e.setVisibility(0);
                this.e.setText(couponSubActBean.getTag());
            } else {
                this.e.setVisibility(4);
            }
            this.f.setText(couponSubActBean.getName());
            String effectiveTimeText = couponSubActBean.getEffectiveTimeText();
            if (!TextUtils.isEmpty(effectiveTimeText)) {
                this.g.setVisibility(0);
                this.g.setText(effectiveTimeText);
            } else {
                this.g.setVisibility(4);
            }
            boolean isTaoMaxVip = couponActivityBean.isTaoMaxVip();
            this.u = isTaoMaxVip;
            this.w = str2;
            this.v = str;
            f(isTaoMaxVip);
            String isApplicable = couponActivityBean.isApplicable();
            boolean h2 = h(isApplicable);
            if (this.u) {
                this.l.setVisibility(0);
                this.j.setVisibility(0);
                this.b.setBackgroundResource(R$drawable.sku_profit_convert_bg);
                yu1.f().m(this.h, str, str2, userProfitInfoBean != null ? String.valueOf(userProfitInfoBean.vipLevel) : "0", couponActivityBean.getProfitDrawStatus(), couponActivityBean.getProfitPoolId(), i2);
                if (!TextUtils.isEmpty(couponActivityBean.getProfitPoint())) {
                    TextView textView = this.k;
                    textView.setText(couponActivityBean.getProfitPoint() + "积分");
                    if (this.j.getVisibility() == 8) {
                        this.j.setVisibility(0);
                    }
                } else if (this.j.getVisibility() == 0) {
                    this.j.setVisibility(8);
                }
                this.i.setText(!TextUtils.isEmpty(couponActivityBean.getProfitDrawButtonText()) ? couponActivityBean.getProfitDrawButtonText() : "");
                if (couponActivityBean.isMaxVipEnable() || couponActivityBean.isNoauthIsVip()) {
                    this.i.setBackgroundResource(R$drawable.sku_promotion_profit_bg);
                    this.i.setTextColor(Color.parseColor("#582331"));
                } else {
                    this.i.setBackgroundResource(R$drawable.sku_promotion_profit_bg_has);
                    this.i.setTextColor(Color.parseColor("#4D582331"));
                }
                String str3 = couponActivityBean.isNoauthIsVip() ? "1" : "2";
                if (!couponActivityBean.isMaxVipLastOne() || !couponActivityBean.isNeedAuthorizeProfit() || TextUtils.isEmpty(couponActivityBean.getAuthorizeProfitText())) {
                    this.m.setVisibility(8);
                } else {
                    this.n.setText(couponActivityBean.getAuthorizeProfitText());
                    this.m.setVisibility(0);
                    yu1.f().l(this.m, this.v, str3);
                    this.m.setOnClickListener(new a(str3));
                }
            } else {
                this.l.setVisibility(8);
                this.j.setVisibility(8);
                this.m.setVisibility(8);
                this.b.setBackgroundResource(R$drawable.sku_profit_coupon_bg);
                if (h2) {
                    this.i.setText("领取");
                    this.i.setTextColor(Color.parseColor("#FF2869"));
                    this.i.setBackgroundResource(R$drawable.sku_promotion_coupon_bg);
                } else if ("false".equals(isApplicable)) {
                    this.i.setText("已领取");
                    this.i.setTextColor(Color.parseColor("#4DFF2869"));
                    this.i.setBackgroundResource(R$drawable.sku_promotion_coupon_has_bg);
                }
            }
            this.h.setOnClickListener(new b(couponActivityBean, userProfitInfoBean, i2, h2, couponSubActBean));
        }
    }

    public boolean h(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-893140541")) {
            return "true".equals(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("-893140541", new Object[]{this, str})).booleanValue();
    }
}
