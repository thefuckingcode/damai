package tb;

import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String FILE_NAME = "Pictures_ABTestCache";
    @NotNull
    public static final a INSTANCE = new a();

    private a() {
    }

    private final SharedPreferences a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212375326")) {
            return (SharedPreferences) ipChange.ipc$dispatch("-1212375326", new Object[]{this});
        }
        SharedPreferences sharedPreferences = d.Companion.a().getSharedPreferences(FILE_NAME, 0);
        k21.h(sharedPreferences, "ABTestManager.applicatio…ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    @NotNull
    public final String b(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-81069026")) {
            return (String) ipChange.ipc$dispatch("-81069026", new Object[]{this, str});
        }
        k21.i(str, "key");
        String string = a().getString(str, "");
        return string != null ? string : "";
    }

    public final void c(@NotNull String str, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471241239")) {
            ipChange.ipc$dispatch("471241239", new Object[]{this, str, obj});
            return;
        }
        k21.i(str, "key");
        d(str, obj == null ? "" : new Gson().toJson(obj));
    }

    public final void d(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1857496819")) {
            ipChange.ipc$dispatch("1857496819", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "key");
        a().edit().putString(str, str2).apply();
    }
}
