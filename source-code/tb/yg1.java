package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class yg1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @NotNull
    private final String b;
    @NotNull
    private final String c;
    @Nullable
    private String d;

    public yg1(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @NotNull
    public final String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1082282635")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("-1082282635", new Object[]{this});
    }

    @NotNull
    public final Context b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-17826110")) {
            return this.a;
        }
        return (Context) ipChange.ipc$dispatch("-17826110", new Object[]{this});
    }

    @NotNull
    public final String c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1325271836")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("-1325271836", new Object[]{this});
    }

    @Nullable
    public final String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1755438271")) {
            return this.d;
        }
        return (String) ipChange.ipc$dispatch("1755438271", new Object[]{this});
    }

    public abstract void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i);

    public abstract void f(@NotNull View view, @NotNull JSONObject jSONObject, int i);

    public abstract void g(@NotNull TrackParams trackParams, @NotNull JSONObject jSONObject, int i);

    public final void h(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894669501")) {
            ipChange.ipc$dispatch("-1894669501", new Object[]{this, jSONObject});
        }
    }
}
