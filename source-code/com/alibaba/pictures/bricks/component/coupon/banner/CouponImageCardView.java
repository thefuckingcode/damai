package com.alibaba.pictures.bricks.component.coupon.banner;

import android.view.View;
import android.widget.ImageView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.PicInfoBean;
import com.alibaba.pictures.bricks.component.coupon.banner.CouponBannerContract;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class CouponImageCardView extends AbsView<GenericItem<ItemValue>, CouponBannerModel, CouponBannerPresent> implements CouponBannerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ImageView image;
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponImageCardView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
        this.image = (ImageView) view2.findViewById(R$id.coupon_banner_view_bg);
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-907442406")) {
            return this.view;
        }
        return (View) ipChange.ipc$dispatch("-907442406", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.coupon.banner.CouponBannerContract.View
    public void renderImage(@NotNull PicInfoBean picInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1332897648")) {
            ipChange.ipc$dispatch("-1332897648", new Object[]{this, picInfoBean});
            return;
        }
        k21.i(picInfoBean, "content");
        ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
        String picUrl = picInfoBean.getPicUrl();
        ImageView imageView = this.image;
        int i = R$drawable.default_color_f0f0f0;
        proxy.loadinto(picUrl, imageView, i, i);
    }
}
