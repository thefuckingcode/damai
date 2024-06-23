package tb;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.c;
import java.util.List;

/* compiled from: Taobao */
public class j5 extends v9<bt0, bt0> {
    public j5(List<b61<bt0>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<bt0, bt0> createAnimation() {
        return new c(this.a);
    }
}
