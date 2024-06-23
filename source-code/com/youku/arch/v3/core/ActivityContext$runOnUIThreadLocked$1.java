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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.youku.arch.v3.core.ActivityContext$runOnUIThreadLocked$1", f = "ActivityContext.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
public final class ActivityContext$runOnUIThreadLocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Function0<T> $action;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityContext$runOnUIThreadLocked$1(Function0<? extends T> function0, Continuation<? super ActivityContext$runOnUIThreadLocked$1> continuation) {
        super(2, continuation);
        this.$action = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "650866857")) {
            return new ActivityContext$runOnUIThreadLocked$1(this.$action, continuation);
        }
        return (Continuation) ipChange.ipc$dispatch("650866857", new Object[]{this, obj, continuation});
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1060537684")) {
            return ((ActivityContext$runOnUIThreadLocked$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
        }
        return ipChange.ipc$dispatch("-1060537684", new Object[]{this, coroutineScope, continuation});
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988070237")) {
            return ipChange.ipc$dispatch("1988070237", new Object[]{this, obj});
        }
        Object unused = b.d();
        if (this.label == 0) {
            k12.b(obj);
            return this.$action.invoke();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
