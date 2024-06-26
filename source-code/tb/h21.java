package tb;

import android.animation.ObjectAnimator;
import android.view.animation.Interpolator;
import cn.damai.baseview.scrollable.CloseUpAnimatorConfigurator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class h21 implements CloseUpAnimatorConfigurator {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Interpolator a;

    public h21(Interpolator interpolator) {
        this.a = interpolator;
    }

    @Override // cn.damai.baseview.scrollable.CloseUpAnimatorConfigurator
    public void configure(ObjectAnimator objectAnimator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "144942607")) {
            ipChange.ipc$dispatch("144942607", new Object[]{this, objectAnimator});
            return;
        }
        objectAnimator.setInterpolator(this.a);
    }
}
