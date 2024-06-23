package tb;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class dn1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final dn1 INSTANCE = new dn1();

    private dn1() {
    }

    private final boolean a(Activity activity) {
        Exception e;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1384426178")) {
            return ((Boolean) ipChange.ipc$dispatch("-1384426178", new Object[]{this, activity})).booleanValue();
        }
        try {
            Object obj = Class.forName("com.android.internal.R$styleable").getField("Window").get(null);
            if (obj != null) {
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) obj);
                k21.h(obtainStyledAttributes, "activity.obtainStyledAttributes(styleableRes)");
                Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, obtainStyledAttributes);
                if (invoke != null) {
                    boolean booleanValue = ((Boolean) invoke).booleanValue();
                    try {
                        method.setAccessible(false);
                        obtainStyledAttributes.recycle();
                        return booleanValue;
                    } catch (Exception e2) {
                        e = e2;
                        z = booleanValue;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.IntArray");
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return z;
        }
    }

    public final void b(@NotNull Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2120062677")) {
            ipChange.ipc$dispatch("2120062677", new Object[]{this, activity, Integer.valueOf(i)});
            return;
        }
        k21.i(activity, "activity");
        if (i == -1 || Build.VERSION.SDK_INT != 26 || !a(activity)) {
            try {
                activity.setRequestedOrientation(i);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (Build.VERSION.SDK_INT == 26) {
                    activity.setRequestedOrientation(-1);
                }
            }
        } else {
            activity.setRequestedOrientation(-1);
        }
    }
}
