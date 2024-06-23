package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alient.onearch.adapter.component.banner.base.BaseBannerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.view.IContract;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.v00;

/* compiled from: Taobao */
public final class CouponBannerViewExt extends BaseBannerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int index;
    @NotNull
    private final View view;

    /* compiled from: Taobao */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CouponBannerViewExt a;

        a(CouponBannerViewExt couponBannerViewExt) {
            this.a = couponBannerViewExt;
        }

        public void onViewAttachedToWindow(@Nullable View view) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-430301624")) {
                ipChange.ipc$dispatch("-430301624", new Object[]{this, view});
                return;
            }
            IContract.Presenter presenter = this.a.getPresenter();
            k21.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.CouponBannerPresenterExt");
            ((CouponBannerPresenterExt) presenter).disPatch(GenericBannerPresenterExt.MSG_BANNER_ATTACHED);
            CouponBannerViewExt couponBannerViewExt = this.a;
            if (couponBannerViewExt.getIndex() - 1 >= 0) {
                i = this.a.getIndex();
            } else {
                CouponBannerViewExt couponBannerViewExt2 = this.a;
                int index = couponBannerViewExt2.getIndex();
                couponBannerViewExt2.setIndex(index - 1);
                i = index;
            }
            couponBannerViewExt.setIndex(i);
        }

        public void onViewDetachedFromWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1079496507")) {
                ipChange.ipc$dispatch("-1079496507", new Object[]{this, view});
                return;
            }
            IContract.Presenter presenter = this.a.getPresenter();
            k21.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.CouponBannerPresenterExt");
            ((CouponBannerPresenterExt) presenter).disPatch(GenericBannerPresenterExt.MSG_BANNER_DETACHED);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponBannerViewExt(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
    }

    public final int getIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2109427759")) {
            return this.index;
        }
        return ((Integer) ipChange.ipc$dispatch("2109427759", new Object[]{this})).intValue();
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    @NotNull
    public RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-464808801")) {
            return (RecyclerView) ipChange.ipc$dispatch("-464808801", new Object[]{this});
        }
        View findViewById = this.view.findViewById(R$id.coupon_top_banner_container);
        k21.g(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        return (RecyclerView) findViewById;
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1086944569")) {
            return this.view;
        }
        return (View) ipChange.ipc$dispatch("1086944569", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerView, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247761852")) {
            ipChange.ipc$dispatch("247761852", new Object[]{this, recycledViewPool, map});
            return;
        }
        super.initRecyclerSettings(recycledViewPool, map);
        this.view.addOnAttachStateChangeListener(new a(this));
    }

    public final void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778193733")) {
            ipChange.ipc$dispatch("-1778193733", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.index = i;
    }

    public final void updateImgLength(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480829690")) {
            ipChange.ipc$dispatch("-480829690", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "size");
        k21.i(str2, "pos");
        try {
            if (Integer.parseInt(str) <= 1) {
                View findViewById = this.view.findViewById(R$id.coupon_img_count_info);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                    return;
                }
                return;
            }
            View findViewById2 = this.view.findViewById(R$id.coupon_img_count_info);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            TextView textView = (TextView) this.view.findViewById(R$id.coupon_img_count_info_title);
            if (textView != null) {
                textView.setText(str2 + v00.DIR + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
