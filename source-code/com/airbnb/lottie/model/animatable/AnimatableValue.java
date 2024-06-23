package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;
import tb.b61;

/* compiled from: Taobao */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> createAnimation();

    List<b61<K>> getKeyframes();

    boolean isStatic();
}
