package tb;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class y0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String a;
    @NotNull
    private final String b;

    public y0(@NotNull String str, @NotNull String str2) {
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        this.a = str;
        this.b = str2;
    }

    @NotNull
    public final String a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465789888")) {
            return (String) ipChange.ipc$dispatch("-1465789888", new Object[]{this});
        }
        return this.a + '_' + this.b;
    }

    @NotNull
    public final String b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "412220600")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("412220600", new Object[]{this});
    }

    @NotNull
    public final String c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "630962049")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("630962049", new Object[]{this});
    }

    public void d(@NotNull View view, @NotNull Activity activity, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1651295217")) {
            ipChange.ipc$dispatch("1651295217", new Object[]{this, view, activity, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        k21.i(view, "itemView");
        k21.i(activity, "activity");
    }

    public abstract void e(@NotNull View view, @NotNull Activity activity, @NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator);

    public void f(@NotNull View view, @NotNull Activity activity, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337471187")) {
            ipChange.ipc$dispatch("-337471187", new Object[]{this, view, activity, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        k21.i(view, "itemView");
        k21.i(activity, "activity");
    }

    public void g(@NotNull GaiaX.Params params, @NotNull View view, @NotNull View view2, @NotNull Activity activity, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902394693")) {
            ipChange.ipc$dispatch("1902394693", new Object[]{this, params, view, view2, activity, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        k21.i(params, "params");
        k21.i(view, "resultView");
        k21.i(view2, "itemView");
        k21.i(activity, "activity");
    }
}
