package com.alibaba.pictures.dolores.prefetch;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/alibaba/pictures/dolores/prefetch/PrefetchManager;", "invoke", "()Lcom/alibaba/pictures/dolores/prefetch/PrefetchManager;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PrefetchManager$Companion$instance$2 extends Lambda implements Function0<PrefetchManager> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final PrefetchManager$Companion$instance$2 INSTANCE = new PrefetchManager$Companion$instance$2();

    PrefetchManager$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final PrefetchManager invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2076621659")) {
            return new PrefetchManager();
        }
        return (PrefetchManager) ipChange.ipc$dispatch("-2076621659", new Object[]{this});
    }
}
