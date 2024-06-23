package kotlinx.coroutines.flow;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$1$1", f = "Zip.kt", i = {}, l = {262, 262}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
public final class FlowKt__ZipKt$combineUnsafe$1$1 extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> {
    final /* synthetic */ Function2<T[], Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super T[], ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineUnsafe$1$1(Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super FlowKt__ZipKt$combineUnsafe$1$1> continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @NotNull T[] tArr, @Nullable Continuation<? super ur2> continuation) {
        FlowKt__ZipKt$combineUnsafe$1$1 flowKt__ZipKt$combineUnsafe$1$1 = new FlowKt__ZipKt$combineUnsafe$1$1(this.$transform, continuation);
        flowKt__ZipKt$combineUnsafe$1$1.L$0 = flowCollector;
        flowKt__ZipKt$combineUnsafe$1$1.L$1 = tArr;
        return flowKt__ZipKt$combineUnsafe$1$1.invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            flowCollector = (FlowCollector) this.L$0;
            Function2<T[], Continuation<? super R>, Object> function2 = this.$transform;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = function2.invoke((Object[]) this.L$1, this);
            if (obj == obj2) {
                return obj2;
            }
        } else if (i == 1) {
            flowCollector = (FlowCollector) this.L$0;
            k12.b(obj);
        } else if (i == 2) {
            k12.b(obj);
            return ur2.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == obj2) {
            return obj2;
        }
        return ur2.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        Object invoke = this.$transform.invoke((Object[]) this.L$1, this);
        b11.c(0);
        ((FlowCollector) this.L$0).emit(invoke, this);
        b11.c(1);
        return ur2.INSTANCE;
    }
}
