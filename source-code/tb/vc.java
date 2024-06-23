package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class vc {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final vc INSTANCE = new vc();

    private vc() {
    }

    public static /* synthetic */ void b(vc vcVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "BricksLog";
        }
        vcVar.a(str, str2);
    }

    public final void a(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "702639197")) {
            ipChange.ipc$dispatch("702639197", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "msg");
        k21.i(str2, "tag");
        if (AppInfoProviderProxy.isDebuggable()) {
            Log.e(str2, str);
        }
    }
}
