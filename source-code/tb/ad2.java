package tb;

import android.content.Context;
import com.alibaba.responsive.IConfig;
import com.alibaba.responsive.ISpanCountProcess;

/* compiled from: Taobao */
public class ad2 {
    private static int a = 400;
    private static double b = 1.67d;
    private static double c = 1.25d;
    private static double d = 2.3d;

    public static int a() {
        return (int) (((double) c()) * b);
    }

    public static double b() {
        return d;
    }

    public static int c() {
        IConfig a2 = x02.c().a();
        if (a2 == null || a2.getPhoneStandardWidthDp() <= 0) {
            return a;
        }
        return a2.getPhoneStandardWidthDp();
    }

    public static double d() {
        return c;
    }

    public static float e(Context context, float f, int i) {
        if (!f12.i(context) || i <= c()) {
            return f;
        }
        float f2 = 0.0f;
        float f3 = (float) ((int) f);
        if (f > f3) {
            f2 = f - f3;
        }
        int round = Math.round(((float) i) / (((float) c()) / f3));
        ISpanCountProcess d2 = x02.c().d();
        if (d2 != null) {
            round = d2.getSpanCount(round);
        }
        return ((float) round) + f2;
    }

    public static int f(Context context, int i) {
        if (!f12.i(context)) {
            return i;
        }
        return (int) e(context, (float) i, y02.d().c(context));
    }
}
