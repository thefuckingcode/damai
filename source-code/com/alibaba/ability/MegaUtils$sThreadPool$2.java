package com.alibaba.ability;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.sg1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/concurrent/ThreadPoolExecutor;", "invoke", "()Ljava/util/concurrent/ThreadPoolExecutor;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
final class MegaUtils$sThreadPool$2 extends Lambda implements Function0<ThreadPoolExecutor> {
    public static final MegaUtils$sThreadPool$2 INSTANCE = new MegaUtils$sThreadPool$2();

    MegaUtils$sThreadPool$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ThreadPoolExecutor invoke() {
        return new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sg1("MegaKit", 0, 2, null));
    }
}
