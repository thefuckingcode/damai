package com.alibaba.pictures.bricks.coupon.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.CouponRuleBean;
import com.alibaba.pictures.bricks.bean.CouponServiceRuleBean;
import com.alibaba.pictures.bricks.listener.OnItemListener;
import com.alibaba.pictures.bricks.util.TComparator;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.flexbox.FlexboxLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.mo;
import tb.wm2;

/* compiled from: Taobao */
public final class CouponServiceRuleViewHolder extends RecyclerView.ViewHolder implements TComparator<CouponServiceRuleBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnItemListener<CouponRuleBean> a;
    @NotNull
    private FlexboxLayout b;
    @NotNull
    private final ArrayList<CouponServiceRuleBean> c = new ArrayList<>();
    @Nullable
    private CouponRuleBean d;
    private int e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponServiceRuleViewHolder(@NotNull ViewGroup viewGroup, @Nullable OnItemListener<CouponRuleBean> onItemListener) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_coupon_service_rule_view, viewGroup, false));
        k21.i(viewGroup, "parent");
        this.a = onItemListener;
        View findViewById = this.itemView.findViewById(R$id.id_bricks_csr_rule_flex);
        k21.h(findViewById, "itemView.findViewById(R.….id_bricks_csr_rule_flex)");
        this.b = (FlexboxLayout) findViewById;
        this.itemView.setOnClickListener(new mo(this));
    }

    /* access modifiers changed from: private */
    public static final void b(CouponServiceRuleViewHolder couponServiceRuleViewHolder, View view) {
        OnItemListener<CouponRuleBean> onItemListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227535841")) {
            ipChange.ipc$dispatch("-1227535841", new Object[]{couponServiceRuleViewHolder, view});
            return;
        }
        k21.i(couponServiceRuleViewHolder, "this$0");
        CouponRuleBean couponRuleBean = couponServiceRuleViewHolder.d;
        if (couponRuleBean != null && (onItemListener = couponServiceRuleViewHolder.a) != null) {
            onItemListener.onItemClick(couponRuleBean, couponServiceRuleViewHolder.e);
        }
    }

    public final void c(@NotNull CouponRuleBean couponRuleBean, int i) {
        List<CouponServiceRuleBean> ruleList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "635629894")) {
            ipChange.ipc$dispatch("635629894", new Object[]{this, couponRuleBean, Integer.valueOf(i)});
            return;
        }
        k21.i(couponRuleBean, "bean");
        this.d = couponRuleBean;
        this.e = i;
        if (!wm2.INSTANCE.f(couponRuleBean.getRuleList(), this.c, this)) {
            this.c.clear();
            CouponRuleBean couponRuleBean2 = this.d;
            if (!(couponRuleBean2 == null || (ruleList = couponRuleBean2.getRuleList()) == null)) {
                Iterator<T> it = ruleList.iterator();
                while (it.hasNext()) {
                    this.c.add(it.next());
                }
            }
            this.b.removeAllViews();
            for (T t : this.c) {
                View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.bricks_coupon_one_rule_view, (ViewGroup) this.b, false);
                TextView textView = (TextView) inflate.findViewById(R$id.id_bricks_cor_rule_tv);
                if (textView != null) {
                    textView.setText(t.getRuleName());
                }
                ImageView imageView = (ImageView) inflate.findViewById(R$id.id_bricks_cor_rule_img);
                if (imageView != null) {
                    k21.h(imageView, "findViewById<ImageView>(…d.id_bricks_cor_rule_img)");
                    String icon = t.getIcon();
                    if (icon != null) {
                        ImageLoaderProviderProxy.getProxy().loadinto(icon, imageView);
                    }
                }
                this.b.addView(inflate);
            }
        }
    }

    /* renamed from: d */
    public boolean same(@Nullable CouponServiceRuleBean couponServiceRuleBean, @Nullable CouponServiceRuleBean couponServiceRuleBean2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1061035088")) {
            return ((Boolean) ipChange.ipc$dispatch("-1061035088", new Object[]{this, couponServiceRuleBean, couponServiceRuleBean2})).booleanValue();
        } else if (couponServiceRuleBean == couponServiceRuleBean2) {
            return true;
        } else {
            if (couponServiceRuleBean == null || couponServiceRuleBean2 == null || !TextUtils.equals(couponServiceRuleBean.getRuleName(), couponServiceRuleBean2.getRuleName())) {
                return false;
            }
            return true;
        }
    }
}
