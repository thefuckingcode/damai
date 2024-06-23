package tb;

import android.app.Activity;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class w21 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final w21 INSTANCE = new w21();

    private w21() {
    }

    @NotNull
    public final a12 a(@NotNull Context context, int i, int i2, int i3, int i4, int i5, @Nullable String str, @Nullable a12 a12) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584827918")) {
            return (a12) ipChange.ipc$dispatch("-584827918", new Object[]{this, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, a12});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return b(context, i, i2, i3, i4, i5, str, a12, -1, -1);
    }

    @NotNull
    public final a12 b(@NotNull Context context, int i, int i2, int i3, int i4, int i5, @Nullable String str, @Nullable a12 a12, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-389227566")) {
            return (a12) ipChange.ipc$dispatch("-389227566", new Object[]{this, context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, a12, Integer.valueOf(i6), Integer.valueOf(i7)});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            i8 = i6;
            i9 = i7;
        } else {
            i8 = activity.getWindow().getDecorView().getMeasuredWidth();
            i9 = activity.getWindow().getDecorView().getMeasuredHeight();
        }
        if (i8 == 0) {
            i8 = g12.e(context);
        }
        if (i9 == 0) {
            i9 = g12.d(context);
        }
        a12 a122 = a12 == null ? new a12() : a12;
        if (i != 11) {
            if (i == 41) {
                if (g12.INSTANCE.j(context)) {
                    int d = bd2.INSTANCE.d(context, 4);
                    i10 = (int) (((float) ((i8 - i4) - (d * i5))) / (((float) d) + 0.5f));
                } else {
                    i10 = (int) (((float) ((ww1.d(i8, i9) - i4) - (i5 * 4))) / 4.5f);
                }
                a122.h(i10);
                a122.g(i3);
                a122.f(i8);
                a122.e(i9);
                return a122;
            }
        } else if (g12.INSTANCE.j(context)) {
            int d2 = bd2.INSTANCE.d(context, 1);
            i10 = ((i8 - (i4 * 2)) - ((d2 - 1) * i5)) / d2;
            a122.h(i10);
            a122.g(i3);
            a122.f(i8);
            a122.e(i9);
            return a122;
        }
        i10 = i2;
        a122.h(i10);
        a122.g(i3);
        a122.f(i8);
        a122.e(i9);
        return a122;
    }
}
