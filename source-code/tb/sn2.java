package tb;

import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;

/* compiled from: Taobao */
public final /* synthetic */ class sn2 implements Interpolator {
    public final /* synthetic */ String a;

    public /* synthetic */ sn2(String str) {
        this.a = str;
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public final float getInterpolation(float f) {
        return Transition.lambda$getInterpolator$0(this.a, f);
    }
}
