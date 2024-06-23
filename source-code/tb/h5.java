package tb;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.a;
import java.util.List;

/* compiled from: Taobao */
public class h5 extends v9<Integer, Integer> {
    public h5(List<b61<Integer>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new a(this.a);
    }
}
