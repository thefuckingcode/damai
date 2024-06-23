package tb;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class xg1 extends yg1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xg1(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        super(context, str, str2, str3);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
    }

    @Override // tb.yg1
    public void g(@NotNull TrackParams trackParams, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-824699592")) {
            ipChange.ipc$dispatch("-824699592", new Object[]{this, trackParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        k21.i(trackParams, "trackParams");
        k21.i(jSONObject, "data");
    }
}
