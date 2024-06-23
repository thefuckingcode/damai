package com.youku.arch.v3.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n"}, d2 = {"Ljava/util/concurrent/ConcurrentHashMap;", "", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PerformanceLogUtil$instance$2 extends Lambda implements Function0<ConcurrentHashMap<String, Long>> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final PerformanceLogUtil$instance$2 INSTANCE = new PerformanceLogUtil$instance$2();

    PerformanceLogUtil$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ConcurrentHashMap<String, Long> invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "716880280")) {
            return new ConcurrentHashMap<>();
        }
        return (ConcurrentHashMap) ipChange.ipc$dispatch("716880280", new Object[]{this});
    }
}
