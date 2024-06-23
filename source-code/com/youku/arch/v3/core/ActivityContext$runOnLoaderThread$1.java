package com.youku.arch.v3.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.youku.arch.v3.core.ActivityContext$runOnLoaderThread$1", f = "ActivityContext.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
public final class ActivityContext$runOnLoaderThread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Function0<T> $action;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityContext$runOnLoaderThread$1(Function0<? extends T> function0, Continuation<? super ActivityContext$runOnLoaderThread$1> continuation) {
        super(2, continuation);
        this.$action = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "278951060")) {
            return new ActivityContext$runOnLoaderThread$1(this.$action, continuation);
        }
        return (Continuation) ipChange.ipc$dispatch("278951060", new Object[]{this, obj, continuation});
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ur2> continuation) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "211577569")) {
            return ((ActivityContext$runOnLoaderThread$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
        }
        return ipChange.ipc$dispatch("211577569", new Object[]{this, coroutineScope, continuation});
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083430958")) {
            return ipChange.ipc$dispatch("-2083430958", new Object[]{this, obj});
        }
        Object unused = b.d();
        if (this.label == 0) {
            k12.b(obj);
            this.$action.invoke();
            return ur2.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
