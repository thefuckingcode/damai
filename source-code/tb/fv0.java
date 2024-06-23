package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fv0<BizResponse> extends cf<BizResponse, BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean b;

    public fv0(BizResponse bizresponse) {
        super(bizresponse);
    }

    @Nullable
    public final Boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "718040865")) {
            return this.b;
        }
        return (Boolean) ipChange.ipc$dispatch("718040865", new Object[]{this});
    }

    public final void c(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496268127")) {
            ipChange.ipc$dispatch("-496268127", new Object[]{this, bool});
            return;
        }
        this.b = bool;
    }
}
