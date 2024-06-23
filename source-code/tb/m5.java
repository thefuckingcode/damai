package tb;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.h;
import java.util.List;

/* compiled from: Taobao */
public class m5 extends v9<PointF, PointF> {
    public m5(List<b61<PointF>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new h(this.a);
    }
}
