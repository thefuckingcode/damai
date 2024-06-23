package tb;

import android.animation.Animator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class oi2 implements Animator.AnimatorListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public void onAnimationCancel(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909058178")) {
            ipChange.ipc$dispatch("-909058178", new Object[]{this, animator});
        }
    }

    public void onAnimationEnd(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "256556145")) {
            ipChange.ipc$dispatch("256556145", new Object[]{this, animator});
        }
    }

    public void onAnimationRepeat(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1404517437")) {
            ipChange.ipc$dispatch("1404517437", new Object[]{this, animator});
        }
    }

    public void onAnimationStart(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292917642")) {
            ipChange.ipc$dispatch("292917642", new Object[]{this, animator});
        }
    }
}
