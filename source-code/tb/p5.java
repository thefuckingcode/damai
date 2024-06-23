package tb;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.k;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import java.util.List;

/* compiled from: Taobao */
public class p5 implements AnimatableValue<PointF, PointF> {
    private final i5 a;
    private final i5 b;

    public p5(i5 i5Var, i5 i5Var2) {
        this.a = i5Var;
        this.b = i5Var2;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new k(this.a.createAnimation(), this.b.createAnimation());
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<b61<PointF>> getKeyframes() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.a.isStatic() && this.b.isStatic();
    }
}
