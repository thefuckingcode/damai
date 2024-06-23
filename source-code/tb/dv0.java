package tb;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class dv0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private View b;

    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        a(dv0 dv0, View view) {
            this.a = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-226648251")) {
                ipChange.ipc$dispatch("-226648251", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = intValue;
            this.a.setLayoutParams(layoutParams);
        }
    }

    private dv0(Context context, View view, int i) {
        this.b = view;
        this.a = i;
    }

    private ValueAnimator a(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24376375")) {
            return (ValueAnimator) ipChange.ipc$dispatch("-24376375", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new a(this, view));
        return ofInt;
    }

    public static dv0 b(Context context, View view, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-576400968")) {
            return new dv0(context, view, i);
        }
        return (dv0) ipChange.ipc$dispatch("-576400968", new Object[]{context, view, Integer.valueOf(i)});
    }

    private void c(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251049643")) {
            ipChange.ipc$dispatch("-251049643", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        view.setVisibility(0);
        ValueAnimator a2 = a(view, 0, this.a);
        a2.setDuration((long) i);
        a2.start();
    }

    public void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179941670")) {
            ipChange.ipc$dispatch("-1179941670", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        c(this.b, i);
    }
}
