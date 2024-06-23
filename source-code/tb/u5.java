package tb;

import android.view.animation.Animation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class u5 implements Animation.AnimationListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public void onAnimationRepeat(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870106543")) {
            ipChange.ipc$dispatch("870106543", new Object[]{this, animation});
        }
    }
}
