package com.alibaba.pictures.dolores;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.zl2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"BizResponse", "Ltb/zl2;", "invoke", "()Ltb/zl2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DoloresKernel$timeMonitor$2 extends Lambda implements Function0<zl2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final DoloresKernel$timeMonitor$2 INSTANCE = new DoloresKernel$timeMonitor$2();

    DoloresKernel$timeMonitor$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final zl2 invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-495268938")) {
            return new zl2();
        }
        return (zl2) ipChange.ipc$dispatch("-495268938", new Object[]{this});
    }
}
