package tb;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class g40 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Animation a;
    private static Animation b;
    private static int c;
    private static int d;

    private static boolean a(int i, View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1200047948")) {
            return i == view.getMeasuredHeight();
        }
        return ((Boolean) ipChange.ipc$dispatch("1200047948", new Object[]{Integer.valueOf(i), view})).booleanValue();
    }

    private static boolean b(View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1325896990")) {
            return a(c, view);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1325896990", new Object[]{view})).booleanValue();
    }

    private static boolean c(View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2017842113")) {
            return a(d, view);
        }
        return ((Boolean) ipChange.ipc$dispatch("2017842113", new Object[]{view})).booleanValue();
    }

    static Animation d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114165377")) {
            return (Animation) ipChange.ipc$dispatch("-1114165377", new Object[]{view});
        }
        if (!b(view) || a == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-view.getMeasuredHeight()), 0.0f);
            a = translateAnimation;
            translateAnimation.setDuration(400);
            f(view.getMeasuredHeight());
        }
        return a;
    }

    static Animation e(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321144005")) {
            return (Animation) ipChange.ipc$dispatch("-1321144005", new Object[]{view});
        }
        if (!c(view) || b == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-view.getMeasuredHeight()));
            b = translateAnimation;
            translateAnimation.setDuration(400);
            g(view.getMeasuredHeight());
        }
        return b;
    }

    private static void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389883799")) {
            ipChange.ipc$dispatch("1389883799", new Object[]{Integer.valueOf(i)});
            return;
        }
        c = i;
    }

    private static void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-843457496")) {
            ipChange.ipc$dispatch("-843457496", new Object[]{Integer.valueOf(i)});
            return;
        }
        d = i;
    }
}
