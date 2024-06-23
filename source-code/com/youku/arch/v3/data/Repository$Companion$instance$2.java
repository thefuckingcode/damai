package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/arch/v3/data/Repository;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class Repository$Companion$instance$2 extends Lambda implements Function0<Repository> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Repository$Companion$instance$2 INSTANCE = new Repository$Companion$instance$2();

    Repository$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Repository invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "898111945")) {
            return new Repository();
        }
        return (Repository) ipChange.ipc$dispatch("898111945", new Object[]{this});
    }
}
