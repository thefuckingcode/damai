package tb;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.j;
import java.util.List;

/* compiled from: Taobao */
public class o5 extends v9<m92, Path> {
    public o5(List<b61<m92>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<m92, Path> createAnimation() {
        return new j(this.a);
    }
}
