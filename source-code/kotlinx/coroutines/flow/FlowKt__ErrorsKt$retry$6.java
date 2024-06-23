package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.qc;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "cause", "", "attempt", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class FlowKt__ErrorsKt$retry$6 extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<Throwable, Boolean> $predicate;
    final /* synthetic */ int $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ErrorsKt$retry$6(Function1<? super Throwable, Boolean> function1, int i, Continuation<? super FlowKt__ErrorsKt$retry$6> continuation) {
        super(4, continuation);
        this.$predicate = function1;
        this.$retries = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th, Long l, Continuation<? super Boolean> continuation) {
        return invoke((FlowCollector) obj, th, l.longValue(), continuation);
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, long j, @Nullable Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$6 flowKt__ErrorsKt$retry$6 = new FlowKt__ErrorsKt$retry$6(this.$predicate, this.$retries, continuation);
        flowKt__ErrorsKt$retry$6.L$0 = th;
        flowKt__ErrorsKt$retry$6.J$0 = j;
        return flowKt__ErrorsKt$retry$6.invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            k12.b(obj);
            return qc.a(this.$predicate.invoke((Throwable) this.L$0).booleanValue() && this.J$0 < ((long) this.$retries));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
