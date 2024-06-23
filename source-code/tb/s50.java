package tb;

import android.content.Context;
import android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class s50 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "s50";
    private static DisplayMetrics b = null;
    private static int c = -1;

    public static int a(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1191246430")) {
            return ((Integer) ipChange.ipc$dispatch("1191246430", new Object[]{context, Float.valueOf(f)})).intValue();
        } else if (context == null || context.getResources() == null) {
            return 1;
        } else {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    public static DisplayMetrics b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939376742")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("-1939376742", new Object[]{context});
        }
        if (b == null) {
            b = context.getResources().getDisplayMetrics();
        }
        return b;
    }

    public static int c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1089429333")) {
            return ((Integer) ipChange.ipc$dispatch("-1089429333", new Object[]{context})).intValue();
        }
        if (c == -1) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                c = context.getResources().getDimensionPixelSize(((Integer) cls.getField("status_bar_height").get(cls.newInstance())).intValue());
            } catch (ClassNotFoundException e) {
                nu2.c(e, a);
            } catch (InstantiationException e2) {
                nu2.c(e2, a);
            } catch (IllegalAccessException e3) {
                nu2.c(e3, a);
            } catch (NoSuchFieldException e4) {
                nu2.c(e4, a);
            }
        }
        return c;
    }

    public static int d(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "896569292")) {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return ((Integer) ipChange.ipc$dispatch("896569292", new Object[]{context, Float.valueOf(f)})).intValue();
    }
}
