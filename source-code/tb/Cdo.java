package tb;

import cn.damai.commonbusiness.scriptmurder.INavStatusBarFeature;
import cn.damai.commonbusiness.scriptmurder.coupon.CouponHeaderDelegate;

/* renamed from: tb.do  reason: invalid class name */
/* compiled from: Taobao */
public final /* synthetic */ class Cdo implements Runnable {
    public final /* synthetic */ INavStatusBarFeature a;

    public /* synthetic */ Cdo(INavStatusBarFeature iNavStatusBarFeature) {
        this.a = iNavStatusBarFeature;
    }

    public final void run() {
        CouponHeaderDelegate.m9onReceiveStickyHeader$lambda6$lambda5(this.a);
    }
}
