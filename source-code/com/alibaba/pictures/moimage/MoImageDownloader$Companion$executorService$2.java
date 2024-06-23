package com.alibaba.pictures.moimage;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/concurrent/ExecutorService;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class MoImageDownloader$Companion$executorService$2 extends Lambda implements Function0<ExecutorService> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final MoImageDownloader$Companion$executorService$2 INSTANCE = new MoImageDownloader$Companion$executorService$2();

    MoImageDownloader$Companion$executorService$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final ExecutorService invoke() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-510870357")) {
            return Executors.newFixedThreadPool(6);
        }
        return (ExecutorService) ipChange.ipc$dispatch("-510870357", new Object[]{this});
    }
}
