package tb;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BusinessInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.CalculatePriceControlBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.NcovSkuBottomInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.TipBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.WishHeatBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.PromotionTagView;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.view.SeeAnimateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.VerticalImageSpan;
import java.util.List;

/* compiled from: Taobao */
public class ih1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean B;
    private WishHeatBean A;
    private View a;
    private View b;
    private TextView c;
    private FlowLayout d;
    @Deprecated
    private TextView e;
    private TextView f;
    private View g;
    private TextView h;
    private jh1 i;
    private View j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private View p;
    private View q;
    private View r;
    private Context s;
    private PerformBean t;
    private BusinessInfo u;
    private PriceBean v;
    private CalculatePriceControlBean w;
    private long x;
    private NcovSkuBottomInfo y;
    private int z = 1;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1397107199")) {
                ipChange.ipc$dispatch("-1397107199", new Object[]{this, view});
                return;
            }
            ih1.this.w();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "714183170")) {
                ipChange.ipc$dispatch("714183170", new Object[]{this, view});
                return;
            }
            int i = R$id.tag_sku_seat_image_uri;
            String str = "";
            String str2 = view.getTag(i) != null ? (String) view.getTag(i) : str;
            int i2 = R$id.tag_sku_seat_image_title;
            if (view.getTag(i2) != null) {
                str = (String) view.getTag(i2);
            }
            ih1.this.m(str2, str);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1469493757")) {
                ipChange.ipc$dispatch("-1469493757", new Object[]{this, view});
                return;
            }
            ih1.this.r(2);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "641796612")) {
                ipChange.ipc$dispatch("641796612", new Object[]{this, view});
                return;
            }
            ih1.this.r(1);
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1541880315")) {
                ipChange.ipc$dispatch("-1541880315", new Object[]{this, view});
                return;
            }
            ih1.this.s((PriceBean) view.getTag());
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PriceBean a;

        f(ih1 ih1, PriceBean priceBean) {
            this.a = priceBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "569410054")) {
                ipChange.ipc$dispatch("569410054", new Object[]{this, view});
                return;
            }
            ToastUtil.f(this.a.toastTips);
        }
    }

    /* compiled from: Taobao */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ PromotionTagView b;

        g(View view, PromotionTagView promotionTagView) {
            this.a = view;
            this.b = promotionTagView;
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1983071722")) {
                ipChange.ipc$dispatch("1983071722", new Object[]{this});
                return;
            }
            TextView textView = (TextView) this.a.findViewById(R$id.item_text);
            DisplayMetrics displayMetrics = ih1.this.s.getResources().getDisplayMetrics();
            int width = this.a.getWidth();
            if (textView.getLineCount() > 1) {
                this.a.setMinimumWidth((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - v50.a(ih1.this.s, 33.0f)) - 1);
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), v50.a(ih1.this.s, 16.0f) + this.b.getCurrentView().getWidth(), textView.getPaddingBottom());
            } else {
                textView.setMaxWidth((width - v50.a(ih1.this.s, 16.0f)) - this.b.getCurrentView().getWidth());
            }
            this.b.getCurrentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: Taobao */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "497023496")) {
                ipChange.ipc$dispatch("497023496", new Object[]{this, view});
                return;
            }
            ih1.B = true;
            DMNav.from(ih1.this.s).toUri(ih1.this.u.serviceFeeAgreementURL);
        }
    }

    public ih1(Fragment fragment, View view, View view2, long j2, NcovSkuBottomInfo ncovSkuBottomInfo) {
        this.a = view;
        this.b = view2;
        this.y = ncovSkuBottomInfo;
        this.x = j2;
        this.s = view.getContext();
        l();
    }

    private void B(List<PriceBean> list) {
        PerformBean performBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956566632")) {
            ipChange.ipc$dispatch("-956566632", new Object[]{this, list});
            return;
        }
        if (this.d.getChildCount() > 0) {
            this.d.removeAllViews();
        }
        this.j.setVisibility(8);
        this.g.setVisibility(8);
        this.z = 1;
        if (!s71.a(list)) {
            this.v = null;
            this.a.setVisibility(0);
            DisplayMetrics displayMetrics = this.s.getResources().getDisplayMetrics();
            for (int i2 = 0; i2 < list.size(); i2++) {
                PriceBean priceBean = list.get(i2);
                if (priceBean != null) {
                    priceBean.index = i2;
                    View inflate = LayoutInflater.from(this.s).inflate(R$layout.sku_ncov_itembox_text, (ViewGroup) null);
                    inflate.setMinimumWidth(((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - v50.a(this.s, 33.0f)) - 1) / 3);
                    TextView textView = (TextView) inflate.findViewById(R$id.item_text);
                    textView.setText(priceBean.priceName);
                    PromotionTagView promotionTagView = (PromotionTagView) inflate.findViewById(R$id.layout_tag_righttop);
                    TextView textView2 = (TextView) inflate.findViewById(R$id.tv_subtitle);
                    Tag tag = priceBean.promotionTag;
                    if (tag == null || TextUtils.isEmpty(tag.subTagDesc)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setVisibility(0);
                        textView2.setText(priceBean.promotionTag.subTagDesc);
                    }
                    c(inflate, priceBean, promotionTagView);
                    o(inflate);
                    if (priceBean.clickable) {
                        textView.setTextColor(ContextCompat.getColor(this.s, R$color.color_666666));
                        textView2.setTextColor(ContextCompat.getColor(this.s, R$color.color_9c9ca5));
                        if (!(list.size() != 1 || (performBean = this.t) == null || performBean.chooseSeatType == 1)) {
                            this.v = priceBean;
                        }
                    } else {
                        Context context = this.s;
                        int i3 = R$color.color_cccccc;
                        textView.setTextColor(ContextCompat.getColor(context, i3));
                        textView2.setTextColor(ContextCompat.getColor(this.s, i3));
                    }
                    if (priceBean.clickable) {
                        inflate.setOnClickListener(new e());
                    } else if (!TextUtils.isEmpty(priceBean.toastTips)) {
                        inflate.setOnClickListener(new f(this, priceBean));
                    }
                    inflate.setTag(priceBean);
                    this.d.addView(inflate);
                }
            }
            q();
        }
    }

    private void C(WishHeatBean wishHeatBean) {
        PriceBean priceBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1701546848")) {
            ipChange.ipc$dispatch("1701546848", new Object[]{this, wishHeatBean});
        } else if (wishHeatBean == null || s71.a(wishHeatBean.prices) || (priceBean = this.v) == null) {
            this.i.c(8);
        } else {
            this.i.e(wishHeatBean.prices, priceBean.priceId);
        }
    }

    private void c(View view, PriceBean priceBean, PromotionTagView promotionTagView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62220450")) {
            ipChange.ipc$dispatch("62220450", new Object[]{this, view, priceBean, promotionTagView});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.layout_tag);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.layout_tag_promotion);
        linearLayout2.removeAllViews();
        linearLayout.removeAllViews();
        promotionTagView.setVisibility(8);
        Tag tag = priceBean.otherTag;
        if (tag != null && !TextUtils.isEmpty(tag.tagDesc)) {
            View inflate = LayoutInflater.from(this.s).inflate(R$layout.sku_ncov_tag, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_tag);
            textView.setText(priceBean.otherTag.tagDesc);
            if (!priceBean.otherTag.isPositive()) {
                textView.setTextColor(this.s.getResources().getColor(R$color.color_6A7A99));
                textView.setBackgroundResource(R$drawable.ncov_sku_tag_normal_bg);
            } else {
                textView.setTextColor(this.s.getResources().getColor(R$color.color_FF2869));
            }
            linearLayout.addView(inflate);
        }
        promotionTagView.setTag(priceBean.promotionTag);
        Tag tag2 = priceBean.promotionTag;
        if (tag2 != null && !TextUtils.isEmpty(tag2.tagDesc)) {
            TextView textView2 = new TextView(j().getContext());
            textView2.setSingleLine();
            textView2.setText(priceBean.promotionTag.tagDesc);
            textView2.setPadding(v50.a(this.s, 2.0f), 0, 0, v50.a(this.s, 2.0f));
            textView2.setTextSize(1, 10.0f);
            textView2.setVisibility(4);
            if (PromotionTagView.HALF_PRICE.equals(priceBean.promotionTag.tag)) {
                textView2.setWidth(v50.a(this.s, 40.0f));
            } else if (PromotionTagView.VIP_BUY.equals(priceBean.promotionTag.tag)) {
                textView2.setWidth(v50.a(this.s, 75.0f));
            } else {
                textView2.setPadding(v50.a(this.s, 2.0f), 0, 0, 0);
            }
            linearLayout2.addView(textView2);
        }
        promotionTagView.getCurrentView().getViewTreeObserver().addOnGlobalLayoutListener(new g(view, promotionTagView));
    }

    private boolean f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477850273")) {
            return ((Boolean) ipChange.ipc$dispatch("-1477850273", new Object[]{this})).booleanValue();
        } else if (this.v.mq != 0) {
            return false;
        } else {
            this.z = 0;
            cn.damai.common.util.toastutil.a.i(this.s, "余票不足");
            t(this.z, false);
            this.y.isCanClickable = false;
            y();
            return true;
        }
    }

    private int g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1249684280")) {
            return ((Integer) ipChange.ipc$dispatch("-1249684280", new Object[]{this})).intValue();
        }
        PriceBean priceBean = this.v;
        if (priceBean == null) {
            return 1;
        }
        int i2 = priceBean.mq;
        return priceBean.packagesFlag ? i2 * priceBean.auctionUnit : i2;
    }

    private int i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792700927")) {
            return ((Integer) ipChange.ipc$dispatch("1792700927", new Object[]{this})).intValue();
        }
        PriceBean priceBean = this.v;
        if (priceBean == null) {
            return 1;
        }
        return priceBean.mq;
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225637857")) {
            ipChange.ipc$dispatch("-1225637857", new Object[]{this});
            return;
        }
        PriceBean priceBean = this.v;
        if (priceBean != null) {
            if (!TextUtils.isEmpty(priceBean.mktPromotionTips)) {
                this.y.discountTip = this.v.mktPromotionTips;
                return;
            }
            this.y.discountTip = null;
        }
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681274482")) {
            ipChange.ipc$dispatch("-1681274482", new Object[]{this});
            return;
        }
        this.c = (TextView) this.a.findViewById(R$id.tv_price_name);
        View findViewById = this.a.findViewById(R$id.tv_promotion_text);
        this.q = findViewById;
        findViewById.setOnClickListener(new a());
        this.r = this.a.findViewById(R$id.tv_promotion_text_line);
        View findViewById2 = this.a.findViewById(R$id.tv_seat_text);
        this.p = findViewById2;
        findViewById2.setOnClickListener(new b());
        this.d = (FlowLayout) this.a.findViewById(R$id.project_detail_perform_price_flowlayout);
        this.e = (TextView) this.a.findViewById(R$id.tv_preferential_tip);
        this.f = (TextView) this.a.findViewById(R$id.tv_kssj_tip);
        this.g = this.a.findViewById(R$id.layout_register);
        this.h = (TextView) this.a.findViewById(R$id.tv_register_tip);
        this.i = new jh1(this.a.findViewById(R$id.layout_see_heat));
        this.j = this.b.findViewById(R$id.layout_num);
        this.k = (TextView) this.b.findViewById(R$id.tv_limit_num);
        ImageView imageView = (ImageView) this.b.findViewById(R$id.img_jian);
        this.l = imageView;
        imageView.setEnabled(false);
        this.m = (TextView) this.b.findViewById(R$id.tv_num);
        this.n = (TextView) this.b.findViewById(R$id.tv_num_detail);
        this.o = (ImageView) this.b.findViewById(R$id.img_jia);
        this.l.setOnClickListener(new c());
        this.o.setOnClickListener(new d());
    }

    private void o(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865759944")) {
            ipChange.ipc$dispatch("-865759944", new Object[]{this, view});
        } else if (this.y.pageType != 1) {
            view.findViewById(R$id.layout_xin).setVisibility(0);
            ((SeeAnimateView) view.findViewById(R$id.image_xin)).setCancelImage();
            this.c.setText("想看哪个票档");
            this.c.setTextSize(1, 16.0f);
        }
    }

    private void p() {
        NcovSkuBottomInfo ncovSkuBottomInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147497753")) {
            ipChange.ipc$dispatch("-147497753", new Object[]{this});
        } else if (this.v != null && this.d.getChildCount() != 0 && (ncovSkuBottomInfo = this.y) != null && ncovSkuBottomInfo.pageType != 1) {
            int childCount = this.d.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.d.getChildAt(i2);
                LinearLayout linearLayout = (LinearLayout) childAt.findViewById(R$id.ll_perform_item);
                TextView textView = (TextView) childAt.findViewById(R$id.item_text);
                SeeAnimateView seeAnimateView = (SeeAnimateView) childAt.findViewById(R$id.image_xin);
                PriceBean priceBean = (PriceBean) childAt.getTag();
                if (priceBean != null) {
                    if (priceBean.priceId == this.v.priceId) {
                        linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_select_see_bg);
                        textView.setTextColor(ContextCompat.getColor(this.s, R$color.color_FF2869));
                        seeAnimateView.clickAnimate();
                    } else {
                        seeAnimateView.setCancelImage();
                    }
                }
            }
        }
    }

    private void q() {
        NcovSkuBottomInfo ncovSkuBottomInfo;
        TipBean tipBean;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016127253")) {
            ipChange.ipc$dispatch("-1016127253", new Object[]{this});
        } else if (this.v != null && this.d.getChildCount() != 0 && (ncovSkuBottomInfo = this.y) != null) {
            PriceBean priceBean = this.v;
            ncovSkuBottomInfo.followRelationTargetType = priceBean.followRelationTargetType;
            n(priceBean);
            this.z = 1;
            d();
            this.j.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            int childCount = this.d.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.d.getChildAt(i3);
                PriceBean priceBean2 = (PriceBean) childAt.getTag();
                LinearLayout linearLayout = (LinearLayout) childAt.findViewById(R$id.ll_perform_item);
                TextView textView = (TextView) childAt.findViewById(R$id.item_text);
                TextView textView2 = (TextView) childAt.findViewById(R$id.tv_subtitle);
                if (this.v.priceId == priceBean2.priceId) {
                    linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_select_bg);
                    Context context = this.s;
                    int i4 = R$color.color_000000;
                    textView.setTextColor(ContextCompat.getColor(context, i4));
                    textView2.setTextColor(ContextCompat.getColor(this.s, i4));
                } else {
                    if (priceBean2.clickable) {
                        textView.setTextColor(ContextCompat.getColor(this.s, R$color.color_666666));
                        textView2.setTextColor(ContextCompat.getColor(this.s, R$color.color_9c9ca5));
                    } else {
                        Context context2 = this.s;
                        int i5 = R$color.color_cccccc;
                        textView.setTextColor(ContextCompat.getColor(context2, i5));
                        textView2.setTextColor(ContextCompat.getColor(this.s, i5));
                    }
                    linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_bg);
                }
            }
            k();
            NcovSkuBottomInfo ncovSkuBottomInfo2 = this.y;
            int i6 = ncovSkuBottomInfo2.pageType;
            if (i6 == 1) {
                PriceBean priceBean3 = this.v;
                int i7 = priceBean3.frontEndStatus;
                if (i7 == 1) {
                    PerformBean performBean = this.t;
                    if (performBean != null) {
                        if (performBean.chooseSeatType == 1) {
                            ncovSkuBottomInfo2.buyStatus = 4;
                            ncovSkuBottomInfo2.isCanClickable = true;
                        } else {
                            String str = "每笔订单限购" + this.t.limitQuantity + "张";
                            if (this.t.skuList.size() <= 0 || TextUtils.isEmpty(this.t.skuList.get(0).sfpt)) {
                                i2 = 0;
                            } else {
                                str = str.concat("，每张服务费" + this.t.skuList.get(0).sfpt + "元 ");
                                i2 = str.length();
                            }
                            if (!TextUtils.isEmpty(this.t.performDesc)) {
                                str = str.concat("，" + this.t.performDesc);
                            }
                            if (i2 > 0) {
                                SpannableString spannableString = new SpannableString(str);
                                Drawable drawable = ResourcesCompat.getDrawable(this.s.getResources(), R$drawable.commonbusiness_help_icon, null);
                                if (drawable != null) {
                                    int a2 = v50.a(this.s, 14.0f);
                                    int a3 = v50.a(this.s, 0.5f);
                                    int a4 = v50.a(this.s, 1.5f);
                                    drawable.setBounds(a4, a3, a2 + a4, a2 + a3);
                                    drawable.setTint(Color.parseColor("#9C9CA5"));
                                    spannableString.setSpan(new VerticalImageSpan(drawable), i2 - 1, i2, 33);
                                }
                                this.k.setText(spannableString);
                                this.k.setOnClickListener(new h());
                            } else {
                                this.k.setText(str);
                            }
                            this.y.buyStatus = 1;
                            if (!f()) {
                                t(this.z, false);
                                NcovSkuBottomInfo ncovSkuBottomInfo3 = this.y;
                                double d2 = this.v.price;
                                int i8 = this.z;
                                ncovSkuBottomInfo3.allPrice = d2 * ((double) i8);
                                ncovSkuBottomInfo3.promotionAmount = 0.0d;
                                CalculatePriceControlBean calculatePriceControlBean = this.w;
                                if (calculatePriceControlBean == null || !calculatePriceControlBean.needCalc || i8 <= 0) {
                                    ncovSkuBottomInfo3.isCanClickable = true;
                                } else {
                                    e(i8);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                } else if (i7 == 2 || i7 == 3) {
                    ncovSkuBottomInfo2.isCanClickable = true;
                    ncovSkuBottomInfo2.buyStatus = i7;
                    TipBean tipBean2 = priceBean3.tips;
                    if (tipBean2 != null) {
                        if (i7 == 2) {
                            if (!TextUtils.isEmpty(tipBean2.tagTip)) {
                                this.g.setVisibility(0);
                                this.h.setText(this.v.tips.tagTip);
                            }
                        } else if (i7 == 3) {
                            if (!TextUtils.isEmpty(tipBean2.saleTime)) {
                                this.f.setVisibility(0);
                                this.f.setText(this.v.tips.saleTime);
                            }
                            if (!TextUtils.isEmpty(this.v.tips.tagTip)) {
                                this.g.setVisibility(0);
                                this.h.setText(this.v.tips.tagTip);
                            }
                        }
                    }
                }
            } else if (i6 == 2) {
                ncovSkuBottomInfo2.isCanClickable = true;
                PriceBean priceBean4 = this.v;
                int i9 = priceBean4.frontEndStatus;
                ncovSkuBottomInfo2.buyStatus = i9;
                if (i9 == 3 && (tipBean = priceBean4.tips) != null) {
                    if (!TextUtils.isEmpty(tipBean.saleTime)) {
                        this.f.setVisibility(0);
                        this.f.setText(this.v.tips.saleTime);
                    }
                    if (!TextUtils.isEmpty(this.v.tips.tagTip)) {
                        this.g.setVisibility(0);
                        this.h.setText(this.v.tips.tagTip);
                    }
                }
            }
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wb2 i10 = wb2.i();
            long j2 = this.x;
            PriceBean priceBean5 = this.v;
            e2.x(i10.o(j2, priceBean5, priceBean5.index));
            p();
            y();
        }
    }

    private boolean t(int i2, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237498194")) {
            return ((Boolean) ipChange.ipc$dispatch("237498194", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z2)})).booleanValue();
        } else if (this.v == null) {
            return false;
        } else {
            this.j.setVisibility(0);
            if (this.v.packagesFlag) {
                TextView textView = this.m;
                textView.setText(i2 + "套");
                this.n.setVisibility(0);
                TextView textView2 = this.n;
                textView2.setText("/共" + (this.v.auctionUnit * i2) + "张");
            } else {
                this.n.setVisibility(8);
                TextView textView3 = this.m;
                textView3.setText(i2 + "张");
            }
            return A(i2, z2);
        }
    }

    public boolean A(int i2, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145626725")) {
            return ((Boolean) ipChange.ipc$dispatch("145626725", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z2)})).booleanValue();
        }
        int i3 = i();
        this.o.setEnabled(true);
        this.o.setImageResource(R$drawable.bricks_ic_plus_enable);
        if (i2 == 1 || i2 == 0) {
            this.l.setEnabled(false);
        } else {
            this.l.setEnabled(true);
        }
        if (i2 < i3 || i2 == 0) {
            return true;
        }
        this.o.setImageResource(R$drawable.bricks_ic_plus_unable);
        if (i2 == i3) {
            return true;
        }
        return false;
    }

    public void D(PerformBean performBean, List<PriceBean> list, CalculatePriceControlBean calculatePriceControlBean, WishHeatBean wishHeatBean, BusinessInfo businessInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1267502500")) {
            ipChange.ipc$dispatch("-1267502500", new Object[]{this, performBean, list, calculatePriceControlBean, wishHeatBean, businessInfo});
            return;
        }
        this.c.setText("票档");
        this.c.setTextSize(1, 12.0f);
        if (xf2.e(list) != 0) {
            this.t = performBean;
            this.u = businessInfo;
            this.w = calculatePriceControlBean;
            this.A = wishHeatBean;
            if (!TextUtils.isEmpty(performBean.seatImg)) {
                this.p.setVisibility(0);
                this.p.setTag(R$id.tag_sku_seat_image_uri, performBean.seatImg);
                this.p.setTag(R$id.tag_sku_seat_image_title, performBean.performName);
                wb2.i().w(this.p, this.x, "查看座位图");
            } else {
                this.p.setVisibility(8);
            }
            B(list);
        }
    }

    public void d() {
        String str;
        IpChange ipChange = $ipChange;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1372224816")) {
            ipChange.ipc$dispatch("-1372224816", new Object[]{this});
            return;
        }
        NcovSkuBottomInfo ncovSkuBottomInfo = this.y;
        if ((ncovSkuBottomInfo == null || ncovSkuBottomInfo.pageType != 2) && this.t != null && this.v != null && ncovSkuBottomInfo != null) {
            String[] b2 = l8.Companion.b(this.x + "", this.s);
            if (b2.length == 0) {
                return;
            }
            if (b2.length != 1 || !TextUtils.isEmpty(b2[0])) {
                int length = b2.length;
                int i3 = this.t.limitQuantity;
                int i4 = i();
                PriceBean priceBean = this.v;
                if (!priceBean.packagesFlag || priceBean.auctionUnit == 0) {
                    this.z = Math.min(i4, Math.min(i3, length));
                } else {
                    this.z = Math.min(i4, Math.min(i3, length) / this.v.auctionUnit);
                }
                int i5 = this.z;
                if (i5 > 0) {
                    i2 = i5;
                }
                this.z = i2;
                int g2 = g();
                if (g2 < this.t.limitQuantity) {
                    str = "余票不足";
                } else {
                    str = "最多购买" + this.t.limitQuantity + "张";
                }
                if ((i3 < length || g2 < length) && i() > 0) {
                    cn.damai.common.util.toastutil.a.i(this.s, str);
                }
            }
        }
    }

    public void e(int i2) {
        throw null;
    }

    public int h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-477196634")) {
            return this.z;
        }
        return ((Integer) ipChange.ipc$dispatch("-477196634", new Object[]{this})).intValue();
    }

    public View j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1603986414")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("1603986414", new Object[]{this});
    }

    public void m(String str, String str2) {
        throw null;
    }

    public void n(PriceBean priceBean) {
        throw null;
    }

    public void r(int i2) {
        int i3;
        int i4;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237931873")) {
            ipChange.ipc$dispatch("-1237931873", new Object[]{this, Integer.valueOf(i2)});
        } else if (this.t != null && this.v != null && this.y != null) {
            if (i2 == 1) {
                cn.damai.common.user.c.e().x(wb2.i().h(this.x, this.t, this.v));
                if (g() < this.t.limitQuantity) {
                    str = "余票不足";
                } else {
                    str = "最多购买" + this.t.limitQuantity + "张";
                }
                if (this.z < i()) {
                    this.z++;
                } else {
                    cn.damai.common.util.toastutil.a.i(this.s, str);
                    return;
                }
            } else if (i2 == 2 && (i4 = this.z) > 1) {
                this.z = i4 - 1;
                cn.damai.common.user.c.e().x(wb2.i().g(this.x, this.t, this.v));
            }
            boolean t2 = t(this.z, true);
            CalculatePriceControlBean calculatePriceControlBean = this.w;
            if (calculatePriceControlBean == null || !calculatePriceControlBean.needCalc || (i3 = this.z) <= 0 || !t2) {
                this.y.allPrice = ik1.b(this.v.price, this.z);
                this.y.promotionAmount = 0.0d;
                y();
                return;
            }
            e(i3);
        }
    }

    public void s(PriceBean priceBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771505155")) {
            ipChange.ipc$dispatch("-1771505155", new Object[]{this, priceBean});
            return;
        }
        this.v = priceBean;
        this.y.isCanClickable = false;
        q();
        C(this.A);
        x(this.A);
    }

    public void u(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525851640")) {
            ipChange.ipc$dispatch("1525851640", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.i.c(i2);
    }

    public void v(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937770704")) {
            ipChange.ipc$dispatch("1937770704", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.a.setVisibility(i2);
    }

    public void w() {
        throw null;
    }

    public void x(WishHeatBean wishHeatBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416757519")) {
            ipChange.ipc$dispatch("-1416757519", new Object[]{this, wishHeatBean});
            return;
        }
        this.i.c(8);
        if (wishHeatBean != null && !s71.a(wishHeatBean.prices) && this.y.pageType == 2 && ub2.a(this.x) != null && this.v != null) {
            this.i.c(0);
            wb2.i().v(this.i.a(), this.x, 0);
        }
    }

    public void y() {
        throw null;
    }

    public void z(boolean z2, boolean z3) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-555656885")) {
            ipChange.ipc$dispatch("-555656885", new Object[]{this, Boolean.valueOf(z2), Boolean.valueOf(z3)});
            return;
        }
        if (!z2 || !z3) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        this.q.setVisibility(z3 ? 0 : 8);
        View view = this.p;
        if (!z2) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }
}
