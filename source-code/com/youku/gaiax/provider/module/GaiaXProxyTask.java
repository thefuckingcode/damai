package com.youku.gaiax.provider.module;

import androidx.annotation.Keep;
import com.youku.gaiax.api.proxy.IProxyTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.sr0;
import tb.ur2;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyTask;", "Lcom/youku/gaiax/api/proxy/IProxyTask;", "Lkotlin/Function0;", "Ltb/ur2;", "runnable", "executeTask", "Ljava/util/concurrent/ExecutorService;", "threadPoolExecutor", "Ljava/util/concurrent/ExecutorService;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXProxyTask implements IProxyTask {
    @NotNull
    private final ExecutorService threadPoolExecutor;

    public GaiaXProxyTask() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        k21.h(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.threadPoolExecutor = newSingleThreadExecutor;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeTask$lambda-0  reason: not valid java name */
    public static final void m906executeTask$lambda0(Function0 function0) {
        k21.i(function0, "$runnable");
        function0.invoke();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyTask
    public void executeTask(@NotNull Function0<ur2> function0) {
        k21.i(function0, "runnable");
        this.threadPoolExecutor.execute(new sr0(function0));
    }
}
