package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j41;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    final /* synthetic */ CompletableDeferred<StateFlow<Object>> $result;
    final /* synthetic */ Flow<Object> $upstream;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Taobao */
    public static final class a implements FlowCollector<Object> {
        final /* synthetic */ Ref$ObjectRef a;
        final /* synthetic */ CoroutineScope b;
        final /* synthetic */ CompletableDeferred c;

        public a(Ref$ObjectRef ref$ObjectRef, CoroutineScope coroutineScope, CompletableDeferred completableDeferred) {
            this.a = ref$ObjectRef;
            this.b = coroutineScope;
            this.c = completableDeferred;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull Continuation<? super ur2> continuation) {
            ur2 ur2;
            T t = this.a.element;
            if (t == null) {
                ur2 = null;
            } else {
                t.setValue(obj);
                ur2 = ur2.INSTANCE;
            }
            if (ur2 == null) {
                CoroutineScope coroutineScope = this.b;
                Ref$ObjectRef ref$ObjectRef = this.a;
                T t2 = (T) l.a(obj);
                this.c.complete(new g(t2, j41.h(coroutineScope.getCoroutineContext())));
                ur2 ur22 = ur2.INSTANCE;
                ref$ObjectRef.element = t2;
            }
            return ur2.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharingDeferred$1(Flow<Object> flow, CompletableDeferred<StateFlow<Object>> completableDeferred, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.$upstream = flow;
        this.$result = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ur2> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Flow<Object> flow = this.$upstream;
            a aVar = new a(ref$ObjectRef, (CoroutineScope) this.L$0, this.$result);
            this.label = 1;
            if (flow.collect(aVar, this) == obj2) {
                return obj2;
            }
        } else if (i == 1) {
            try {
                k12.b(obj);
            } catch (Throwable th) {
                this.$result.completeExceptionally(th);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ur2.INSTANCE;
    }
}
