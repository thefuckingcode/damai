package com.youku.live.dago.widgetlib.ailproom.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AnimUitls {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void startAppearAnimY(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "228438997")) {
            ipChange.ipc$dispatch("228438997", new Object[]{view});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(250);
        view.startAnimation(translateAnimation);
        view.setVisibility(0);
    }

    public static void startDisappearAnimY(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1569371357")) {
            ipChange.ipc$dispatch("1569371357", new Object[]{view});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(250);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.youku.live.dago.widgetlib.ailproom.utils.AnimUitls.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationEnd(Animation animation) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "460242469")) {
                    ipChange.ipc$dispatch("460242469", new Object[]{this, animation});
                    return;
                }
                view.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1035178799")) {
                    ipChange.ipc$dispatch("1035178799", new Object[]{this, animation});
                }
            }

            public void onAnimationStart(Animation animation) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1593418690")) {
                    ipChange.ipc$dispatch("-1593418690", new Object[]{this, animation});
                }
            }
        });
        view.startAnimation(translateAnimation);
    }
}
