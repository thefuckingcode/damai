package com.alibaba.security.biometrics.c;

import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* compiled from: Taobao */
public final class c {
    private static void a(View view, Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillBefore(true);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(500);
        alphaAnimation.setAnimationListener(animationListener);
        view.startAnimation(alphaAnimation);
    }

    private static void a(final View view) {
        try {
            if (Build.VERSION.SDK_INT < 11) {
                view.setVisibility(0);
                view.setAlpha(1.0f);
                return;
            }
            AnonymousClass1 r0 = new Animation.AnimationListener() {
                /* class com.alibaba.security.biometrics.c.c.AnonymousClass1 */
                final /* synthetic */ Animation.AnimationListener b = null;

                public final void onAnimationEnd(Animation animation) {
                    view.setVisibility(0);
                    if (Build.VERSION.SDK_INT >= 11) {
                        view.setAlpha(1.0f);
                    }
                    view.clearAnimation();
                    Animation.AnimationListener animationListener = this.b;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(animation);
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                    view.setVisibility(0);
                }
            };
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillBefore(true);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(500);
            alphaAnimation.setAnimationListener(r0);
            view.startAnimation(alphaAnimation);
        } catch (Throwable unused) {
        }
    }
}
