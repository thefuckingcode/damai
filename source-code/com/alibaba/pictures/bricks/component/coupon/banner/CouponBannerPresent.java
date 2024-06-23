package com.alibaba.pictures.bricks.component.coupon.banner;

import android.view.View;
import com.alibaba.pictures.bricks.component.coupon.banner.CouponBannerContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class CouponBannerPresent extends AbsPresenter<GenericItem<ItemValue>, CouponBannerModel, CouponImageCardView> implements CouponBannerContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponBannerPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045136682")) {
            ipChange.ipc$dispatch("1045136682", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        ((CouponBannerModel) getModel()).getContent();
        ((CouponImageCardView) getView()).renderImage(((CouponBannerModel) getModel()).getContent());
    }
}
