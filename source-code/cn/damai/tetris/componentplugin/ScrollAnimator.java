package cn.damai.tetris.componentplugin;

import android.animation.ValueAnimator;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ScrollAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public int fromY;
    private View mMaskPanel;
    public boolean show;
    public int toY;

    public ScrollAnimator(View view, boolean z, int i, int i2) {
        this.fromY = i;
        this.toY = i2;
        this.show = z;
        this.mMaskPanel = view;
        setFloatValues(0.0f, 1.0f);
        addUpdateListener(this);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1783479301")) {
            ipChange.ipc$dispatch("-1783479301", new Object[]{this, valueAnimator});
            return;
        }
        float animatedFraction = valueAnimator.getAnimatedFraction();
        int i = this.toY;
        int i2 = this.fromY;
        this.mMaskPanel.scrollTo(0, (int) ((((float) (i - i2)) * animatedFraction) + ((float) i2)));
    }
}
