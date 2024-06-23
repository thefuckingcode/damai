package tb;

import com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class nl {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final nl INSTANCE = new nl();
    @Nullable
    private static ComponentFilterBridge a;

    private nl() {
    }

    @NotNull
    public final synchronized ComponentFilterBridge a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548437647")) {
            return (ComponentFilterBridge) ipChange.ipc$dispatch("1548437647", new Object[]{this});
        }
        ComponentFilterBridge componentFilterBridge = a;
        if (componentFilterBridge == null) {
            componentFilterBridge = new ed0();
        }
        return componentFilterBridge;
    }

    public final synchronized void b(@NotNull ComponentFilterBridge componentFilterBridge) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-379707461")) {
            ipChange.ipc$dispatch("-379707461", new Object[]{this, componentFilterBridge});
            return;
        }
        k21.i(componentFilterBridge, "inject");
        a = componentFilterBridge;
    }
}
