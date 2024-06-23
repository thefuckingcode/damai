package tb;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class db0 {
    private static transient /* synthetic */ IpChange $ipChange;

    @NotNull
    public static final <BizResponse> ta0<BizResponse> a(@NotNull DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956643511")) {
            return (ta0) ipChange.ipc$dispatch("-956643511", new Object[]{doloresRequest});
        }
        k21.i(doloresRequest, "$this$dolores");
        return ta0.Companion.a(doloresRequest);
    }
}
