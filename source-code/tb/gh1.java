package tb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.NcovSkuBottomInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformSummaryBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.PromotionTagView;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ut.SkuInfo;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.view.SeeAnimateView;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class gh1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;
    private TextView d;
    private FlowLayout e;
    private TextView f;
    private Context g;
    private List<View> h = new ArrayList();
    private PerformSummaryBean i;
    private PerformBean j;
    private NcovSkuBottomInfo k = null;
    private long l;
    private boolean m;
    private boolean n;
    private Activity o;
    private long p = 0;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArrayList a;

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-606175463")) {
                ipChange.ipc$dispatch("-606175463", new Object[]{this, view});
                return;
            }
            gh1.this.j(this.a);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1505114906")) {
                ipChange.ipc$dispatch("1505114906", new Object[]{this, view});
                return;
            }
            PerformSummaryBean performSummaryBean = (PerformSummaryBean) view.getTag();
            if (performSummaryBean != null) {
                if (gh1.this.i == null || performSummaryBean.performId != gh1.this.i.performId) {
                    gh1.this.i = performSummaryBean;
                    gh1 gh1 = gh1.this;
                    gh1.p = gh1.i.performId;
                    gh1.this.i(performSummaryBean);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ PromotionTagView b;

        c(View view, PromotionTagView promotionTagView) {
            this.a = view;
            this.b = promotionTagView;
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-560530178")) {
                ipChange.ipc$dispatch("-560530178", new Object[]{this});
                return;
            }
            TextView textView = (TextView) this.a.findViewById(R$id.item_text);
            DisplayMetrics displayMetrics = gh1.this.g.getResources().getDisplayMetrics();
            int width = this.a.getWidth();
            if (textView.getLineCount() > 1) {
                this.a.setMinimumWidth((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - v50.a(gh1.this.g, 33.0f)) - 1);
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), v50.a(gh1.this.g, 16.0f) + this.b.getCurrentView().getWidth(), textView.getPaddingBottom());
            } else {
                textView.setMaxWidth((width - v50.a(gh1.this.g, 16.0f)) - this.b.getCurrentView().getWidth());
            }
            this.b.getCurrentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public gh1(View view, Activity activity, long j2, NcovSkuBottomInfo ncovSkuBottomInfo) {
        this.a = view;
        this.g = view.getContext();
        this.o = activity;
        this.l = j2;
        this.k = ncovSkuBottomInfo;
        h();
    }

    private void e(View view, Tag tag, Tag tag2, PromotionTagView promotionTagView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372216747")) {
            ipChange.ipc$dispatch("372216747", new Object[]{this, view, tag, tag2, promotionTagView});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.layout_tag);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.layout_tag_promotion);
        linearLayout2.removeAllViews();
        linearLayout.removeAllViews();
        promotionTagView.setVisibility(8);
        if (tag != null && !TextUtils.isEmpty(tag.tagDesc)) {
            View inflate = LayoutInflater.from(this.g).inflate(R$layout.sku_ncov_tag, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_tag);
            textView.setText(tag.tagDesc);
            if (!tag.isPositive()) {
                textView.setTextColor(this.g.getResources().getColor(R$color.color_6A7A99));
                textView.setBackgroundResource(R$drawable.ncov_sku_tag_normal_bg);
            } else {
                textView.setTextColor(this.g.getResources().getColor(R$color.color_FF2869));
            }
            linearLayout.addView(inflate);
        }
        promotionTagView.setTag(tag2);
        if (tag2 != null && !TextUtils.isEmpty(tag2.tagDesc)) {
            TextView textView2 = new TextView(g().getContext());
            textView2.setSingleLine();
            textView2.setText(tag2.tagDesc);
            textView2.setPadding(v50.a(this.g, 2.0f), 0, 0, v50.a(this.g, 2.0f));
            textView2.setTextSize(1, 10.0f);
            textView2.setVisibility(4);
            if (PromotionTagView.HALF_PRICE.equals(tag2.tag)) {
                textView2.setWidth(v50.a(this.g, 40.0f));
            } else if (PromotionTagView.VIP_BUY.equals(tag2.tag)) {
                textView2.setWidth(v50.a(this.g, 75.0f));
            } else {
                textView2.setPadding(v50.a(this.g, 2.0f), 0, 0, 0);
            }
            linearLayout2.addView(textView2);
        }
        promotionTagView.getCurrentView().getViewTreeObserver().addOnGlobalLayoutListener(new c(view, promotionTagView));
    }

    private String f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42539110")) {
            return (String) ipChange.ipc$dispatch("-42539110", new Object[]{this});
        } else if (xf2.e(this.j.skuList) <= 0) {
            return "";
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.j.skuList.size(); i2++) {
                PriceBean priceBean = this.j.skuList.get(i2);
                if (priceBean != null) {
                    SkuInfo skuInfo = new SkuInfo();
                    skuInfo.sku_id = priceBean.skuId + "";
                    skuInfo.status = priceBean.frontEndStatus + "";
                    arrayList.add(skuInfo);
                }
            }
            return JSON.toJSONString(arrayList);
        }
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568594778")) {
            ipChange.ipc$dispatch("-568594778", new Object[]{this});
            return;
        }
        this.b = (TextView) this.a.findViewById(R$id.tv_perform_name);
        this.c = (TextView) this.a.findViewById(R$id.tv_perform_tip);
        this.d = (TextView) this.a.findViewById(R$id.tv_perform_changetip);
        this.e = (FlowLayout) this.a.findViewById(R$id.project_detail_perform_flowlayout);
        this.f = (TextView) this.a.findViewById(R$id.tv_perform_time_detail);
    }

    private void k(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408939088")) {
            ipChange.ipc$dispatch("408939088", new Object[]{this, view});
        } else if (this.k.pageType != 1) {
            view.findViewById(R$id.layout_xin).setVisibility(0);
            ((SeeAnimateView) view.findViewById(R$id.image_xin)).setCancelImage();
            this.b.setText("想看哪场");
            this.b.setTextSize(1, 16.0f);
        }
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505343180")) {
            ipChange.ipc$dispatch("1505343180", new Object[]{this});
        } else if (xf2.e(this.h) != 0 && this.j != null) {
            for (View view : this.h) {
                TextView textView = (TextView) view.findViewById(R$id.item_text);
                TextView textView2 = (TextView) view.findViewById(R$id.tv_subtitle);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_perform_item);
                PerformSummaryBean performSummaryBean = (PerformSummaryBean) view.getTag();
                if (performSummaryBean != null) {
                    if (performSummaryBean.performId == this.j.performId) {
                        linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_select_bg);
                        Context context = this.g;
                        int i2 = R$color.color_000000;
                        textView.setTextColor(ContextCompat.getColor(context, i2));
                        textView2.setTextColor(ContextCompat.getColor(this.g, i2));
                    } else {
                        if (performSummaryBean.clickable) {
                            textView.setTextColor(ContextCompat.getColor(this.g, R$color.color_666666));
                            textView2.setTextColor(ContextCompat.getColor(this.g, R$color.color_9c9ca5));
                        } else {
                            Context context2 = this.g;
                            int i3 = R$color.color_cccccc;
                            textView.setTextColor(ContextCompat.getColor(context2, i3));
                            textView2.setTextColor(ContextCompat.getColor(this.g, i3));
                        }
                        linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_bg);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.j.performTimeDetailStr)) {
                this.f.setText(this.j.performTimeDetailStr);
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            m();
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1845696001")) {
            ipChange.ipc$dispatch("-1845696001", new Object[]{this});
        } else if (xf2.e(this.h) != 0 && this.j != null && this.k.pageType != 1) {
            for (View view : this.h) {
                View findViewById = view.findViewById(R$id.ll_perform_item);
                TextView textView = (TextView) view.findViewById(R$id.item_text);
                TextView textView2 = (TextView) view.findViewById(R$id.tv_subtitle);
                SeeAnimateView seeAnimateView = (SeeAnimateView) view.findViewById(R$id.image_xin);
                PerformSummaryBean performSummaryBean = (PerformSummaryBean) view.getTag();
                if (performSummaryBean != null) {
                    if (performSummaryBean.performId == this.j.performId) {
                        findViewById.setBackgroundResource(R$drawable.ncov_sku_perform_select_see_bg);
                        Context context = this.g;
                        int i2 = R$color.color_FF2869;
                        textView.setTextColor(ContextCompat.getColor(context, i2));
                        textView2.setTextColor(ContextCompat.getColor(this.g, i2));
                        seeAnimateView.clickAnimate();
                    } else {
                        seeAnimateView.setCancelImage();
                    }
                }
            }
        }
    }

    private void o(List<PerformSummaryBean> list, PerformBean performBean, String str) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1965401917")) {
            ipChange.ipc$dispatch("1965401917", new Object[]{this, list, performBean, str});
            return;
        }
        this.a.setVisibility(0);
        this.b.setText("场次");
        this.b.setTextSize(1, 12.0f);
        this.f.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.c.setText(str);
        }
        this.e.removeAllViews();
        this.h.clear();
        for (int i3 = 0; i3 < list.size(); i3++) {
            PerformSummaryBean performSummaryBean = list.get(i3);
            if (performSummaryBean != null) {
                performSummaryBean.index = i3;
                View inflate = LayoutInflater.from(this.g).inflate(R$layout.sku_ncov_itembox_text, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.item_text);
                textView.setText(performSummaryBean.performName);
                TextView textView2 = (TextView) inflate.findViewById(R$id.tv_subtitle);
                PromotionTagView promotionTagView = (PromotionTagView) inflate.findViewById(R$id.layout_tag_righttop);
                if (!TextUtils.isEmpty(performSummaryBean.remark)) {
                    textView2.setVisibility(0);
                    textView2.setText(performSummaryBean.remark);
                } else {
                    textView2.setVisibility(8);
                }
                e(inflate, performSummaryBean.otherTag, performSummaryBean.promotionTag, promotionTagView);
                k(inflate);
                if (performSummaryBean.clickable) {
                    textView.setTextColor(ContextCompat.getColor(this.g, R$color.color_666666));
                    inflate.setOnClickListener(new b());
                } else {
                    textView.setTextColor(ContextCompat.getColor(this.g, R$color.color_cccccc));
                }
                inflate.setTag(performSummaryBean);
                this.h.add(inflate);
                this.e.addView(inflate);
                if (performSummaryBean.checked && this.m && performSummaryBean.performId == this.p) {
                    NcovSkuBottomInfo ncovSkuBottomInfo = this.k;
                    if (ncovSkuBottomInfo.pageType == 2) {
                        this.j = performBean;
                        this.i = performSummaryBean;
                    } else if (!this.n) {
                        this.j = performBean;
                        this.i = performSummaryBean;
                        ncovSkuBottomInfo.discountTip = performSummaryBean.mktPromotionTips;
                    } else if (performSummaryBean.salable) {
                        this.j = performBean;
                        this.i = performSummaryBean;
                    }
                }
            }
        }
        if (list.size() == 1 && list.get(0) != null && list.get(0).clickable) {
            PerformSummaryBean performSummaryBean2 = list.get(0);
            this.i = performSummaryBean2;
            this.j = performBean;
            this.p = performSummaryBean2.performId;
            this.k.discountTip = performSummaryBean2.mktPromotionTips;
        }
        if (!(this.j == null || this.i == null)) {
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            wb2 i4 = wb2.i();
            long j2 = this.l;
            PerformSummaryBean performSummaryBean3 = this.i;
            e2.x(i4.p(j2, performSummaryBean3, this.i.performBeginDTStr + " (" + this.i.performName + jl1.BRACKET_END_STR, this.i.index, f()));
            l();
            NcovSkuBottomInfo ncovSkuBottomInfo2 = this.k;
            if (ncovSkuBottomInfo2.pageType == 1) {
                PerformBean performBean2 = this.j;
                if (performBean2.chooseSeatType == 1) {
                    ncovSkuBottomInfo2.buyStatus = 4;
                    if (!performBean2.performSalable || !performBean2.buyPermission) {
                        ncovSkuBottomInfo2.isCanClickable = false;
                    } else {
                        ncovSkuBottomInfo2.isCanClickable = true;
                    }
                } else {
                    ncovSkuBottomInfo2.buyStatus = 1;
                }
            }
            if (this.j.chooseSeatType == 1) {
                i2 = 1;
            }
            wb2.i().y(this.l, this.o, i2);
        }
    }

    public View g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1323602390")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("1323602390", new Object[]{this});
    }

    public void i(PerformSummaryBean performSummaryBean) {
        throw null;
    }

    public void j(ArrayList<ItemContent> arrayList) {
        throw null;
    }

    public void n(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819802600")) {
            ipChange.ipc$dispatch("1819802600", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.a.setVisibility(i2);
    }

    public void p(String str, List<PerformSummaryBean> list, PerformBean performBean, boolean z, boolean z2, long j2, ArrayList<ItemContent> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12526535")) {
            ipChange.ipc$dispatch("-12526535", new Object[]{this, str, list, performBean, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2), arrayList});
        } else if (xf2.e(list) != 0) {
            this.m = z;
            this.n = z2;
            this.j = null;
            this.i = null;
            this.p = j2;
            o(list, performBean, str);
            if (!f92.d(arrayList)) {
                this.a.findViewById(R$id.tv_perform_changetip_icon).setVisibility(0);
                this.d.setVisibility(0);
                this.d.setOnClickListener(new a(arrayList));
                HashMap hashMap = new HashMap();
                hashMap.put("item_id", this.l + "");
                cn.damai.common.user.c.e().G(this.d, "showchange", "top", "screenings", hashMap);
                return;
            }
            this.a.findViewById(R$id.tv_perform_changetip_icon).setVisibility(8);
            this.d.setVisibility(8);
        }
    }
}
