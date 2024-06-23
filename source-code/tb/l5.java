package tb;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.g;
import com.airbnb.lottie.animation.keyframe.h;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import java.util.List;

/* compiled from: Taobao */
public class l5 implements AnimatableValue<PointF, PointF> {
    private final List<b61<PointF>> a;

    public l5(List<b61<PointF>> list) {
        this.a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        if (this.a.get(0).h()) {
            return new h(this.a);
        }
        return new g(this.a);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<b61<PointF>> getKeyframes() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.a.size() == 1 && this.a.get(0).h();
    }
}
