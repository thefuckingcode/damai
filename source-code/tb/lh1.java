package tb;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.alibaba.pictures.bricks.component.home.NestedBannerView;

/* compiled from: Taobao */
public final /* synthetic */ class lh1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewGroup.LayoutParams a;
    public final /* synthetic */ NestedBannerView b;
    public final /* synthetic */ ViewGroup c;

    public /* synthetic */ lh1(ViewGroup.LayoutParams layoutParams, NestedBannerView nestedBannerView, ViewGroup viewGroup) {
        this.a = layoutParams;
        this.b = nestedBannerView;
        this.c = viewGroup;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        NestedBannerView.m109expandBannerView$lambda3$lambda2$lambda1$lambda0(this.a, this.b, this.c, valueAnimator);
    }
}
