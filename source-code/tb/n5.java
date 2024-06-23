package tb;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.i;
import java.util.List;

/* compiled from: Taobao */
public class n5 extends v9<a42, a42> {
    public n5(List<b61<a42>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<a42, a42> createAnimation() {
        return new i(this.a);
    }
}
