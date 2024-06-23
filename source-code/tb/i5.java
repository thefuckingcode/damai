package tb;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.b;
import java.util.List;

/* compiled from: Taobao */
public class i5 extends v9<Float, Float> {
    i5() {
        super(Float.valueOf(0.0f));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Float, Float> createAnimation() {
        return new b(this.a);
    }

    public i5(List<b61<Float>> list) {
        super((List) list);
    }
}
