package cn.damai.onearch.token;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class DMTokenManager$Companion$instance$2 extends Lambda implements Function0<DMTokenManager> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final DMTokenManager$Companion$instance$2 INSTANCE = new DMTokenManager$Companion$instance$2();

    DMTokenManager$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final DMTokenManager invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1029114763")) {
            return new DMTokenManager();
        }
        return (DMTokenManager) ipChange.ipc$dispatch("1029114763", new Object[]{this});
    }
}
