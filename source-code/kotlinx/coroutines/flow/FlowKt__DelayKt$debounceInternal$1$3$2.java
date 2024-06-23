package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.fh;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"T", "Ltb/fh;", "", "value", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<fh<? extends Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ FlowCollector<Object> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> ref$ObjectRef, FlowCollector<Object> flowCollector, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(fh<? extends Object> fhVar, Continuation<? super ur2> continuation) {
        return m933invokeWpGqRn0(fhVar.l(), continuation);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m933invokeWpGqRn0(@NotNull Object obj, @Nullable Continuation<? super ur2> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(fh.b(obj), continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Ref$ObjectRef<Object> ref$ObjectRef;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            T t = (T) ((fh) this.L$0).l();
            ref$ObjectRef = this.$lastValue;
            boolean z = t instanceof fh.c;
            if (!z) {
                ref$ObjectRef.element = t;
            }
            FlowCollector<Object> flowCollector = this.$downstream;
            if (z) {
                Throwable e = fh.e(t);
                if (e == null) {
                    T t2 = ref$ObjectRef.element;
                    if (t2 != null) {
                        if (t2 == ek1.NULL) {
                            t2 = null;
                        }
                        this.L$0 = t;
                        this.L$1 = ref$ObjectRef;
                        this.label = 1;
                        if (flowCollector.emit(t2, this) == obj2) {
                            return obj2;
                        }
                        ref$ObjectRef2 = ref$ObjectRef;
                    }
                    ref$ObjectRef.element = (T) ek1.DONE;
                } else {
                    throw e;
                }
            }
            return ur2.INSTANCE;
        } else if (i == 1) {
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.element = (T) ek1.DONE;
        return ur2.INSTANCE;
    }
}
