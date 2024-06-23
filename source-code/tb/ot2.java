package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ot2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String UT_LOG_TAG = "DogCat";

    public static final void a(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-910532287")) {
            ipChange.ipc$dispatch("-910532287", new Object[]{str});
        } else if (uq2.INSTANCE.d() && str != null) {
            Log.d(UT_LOG_TAG, str);
        }
    }

    public static final void b(@Nullable Exception exc) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322913104")) {
            ipChange.ipc$dispatch("-322913104", new Object[]{exc});
        } else if (uq2.INSTANCE.d() && exc != null) {
            Log.e(UT_LOG_TAG, exc.toString());
        }
    }

    public static final void c(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346378720")) {
            ipChange.ipc$dispatch("1346378720", new Object[]{str});
        } else if (uq2.INSTANCE.d() && str != null) {
            Log.e(UT_LOG_TAG, str);
        }
    }

    public static final void d(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978896114")) {
            ipChange.ipc$dispatch("-978896114", new Object[]{str});
        } else if (uq2.INSTANCE.d() && str != null) {
            Log.w(UT_LOG_TAG, str);
        }
    }
}
