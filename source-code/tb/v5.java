package tb;

import android.animation.Animator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class v5 implements Animator.AnimatorListener {
    private static transient /* synthetic */ IpChange $ipChange;

    v5() {
    }

    public void onAnimationCancel(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106784433")) {
            ipChange.ipc$dispatch("-2106784433", new Object[]{this, animator});
        }
    }

    public void onAnimationEnd(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40906688")) {
            ipChange.ipc$dispatch("-40906688", new Object[]{this, animator});
        }
    }

    public void onAnimationRepeat(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206791182")) {
            ipChange.ipc$dispatch("206791182", new Object[]{this, animator});
        }
    }

    public void onAnimationStart(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101023335")) {
            ipChange.ipc$dispatch("-2101023335", new Object[]{this, animator});
        }
    }
}
