package tb;

import android.animation.ValueAnimator;
import com.alibaba.gaiax.render.view.basic.GXProgressView;

/* compiled from: Taobao */
public final /* synthetic */ class dq0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GXProgressView a;

    public /* synthetic */ dq0(GXProgressView gXProgressView) {
        this.a = gXProgressView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        GXProgressView.m93updateProgressPath$lambda2$lambda1(this.a, valueAnimator);
    }
}
