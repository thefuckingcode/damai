package cn.damai.h5container;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class UniH5ContainerSwitcher$Companion$Instance$2 extends Lambda implements Function0<UniH5ContainerSwitcher> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final UniH5ContainerSwitcher$Companion$Instance$2 INSTANCE = new UniH5ContainerSwitcher$Companion$Instance$2();

    UniH5ContainerSwitcher$Companion$Instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final UniH5ContainerSwitcher invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "880312055")) {
            return new UniH5ContainerSwitcher();
        }
        return (UniH5ContainerSwitcher) ipChange.ipc$dispatch("880312055", new Object[]{this});
    }
}
