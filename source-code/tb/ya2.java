package tb;

import android.animation.Animator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ya2 implements Animator.AnimatorListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public void onAnimationCancel(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1454057199")) {
            ipChange.ipc$dispatch("1454057199", new Object[]{this, animator});
        }
    }

    public void onAnimationRepeat(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527334482")) {
            ipChange.ipc$dispatch("-527334482", new Object[]{this, animator});
        }
    }

    public void onAnimationStart(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016326151")) {
            ipChange.ipc$dispatch("-1016326151", new Object[]{this, animator});
        }
    }
}
