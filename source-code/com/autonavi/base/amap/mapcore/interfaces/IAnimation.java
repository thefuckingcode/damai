package com.autonavi.base.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.animation.GLAnimation;

/* compiled from: Taobao */
public interface IAnimation {
    void setAnimation(GLAnimation gLAnimation);

    void setAnimationListener(Animation.AnimationListener animationListener);

    boolean startAnimation();
}
