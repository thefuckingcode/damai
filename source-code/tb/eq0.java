package tb;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: Taobao */
public final /* synthetic */ class eq0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ fq0 a;
    public final /* synthetic */ View b;

    public /* synthetic */ eq0(fq0 fq0, View view) {
        this.a = fq0;
        this.b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        fq0.b(this.a, this.b, valueAnimator);
    }
}
