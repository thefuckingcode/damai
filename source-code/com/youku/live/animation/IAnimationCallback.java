package com.youku.live.animation;

/* compiled from: Taobao */
public interface IAnimationCallback {
    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationError(AnimationError animationError);

    void onAnimationStart();
}
