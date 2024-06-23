package tb;

import android.animation.Animator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class xa2 implements Animator.AnimatorListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public void onAnimationCancel(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1756946673")) {
            ipChange.ipc$dispatch("1756946673", new Object[]{this, animator});
        }
    }

    public void onAnimationRepeat(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224445008")) {
            ipChange.ipc$dispatch("-224445008", new Object[]{this, animator});
        }
    }

    public void onAnimationStart(Animator animator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "933107127")) {
            ipChange.ipc$dispatch("933107127", new Object[]{this, animator});
        }
    }
}
