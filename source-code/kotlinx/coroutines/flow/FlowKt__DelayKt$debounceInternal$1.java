package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.jh2;
import tb.k12;
import tb.n30;
import tb.p30;
import tb.qc;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {}, l = {224, 358}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Flow<Object> $this_debounceInternal;
    final /* synthetic */ Function1<Object, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1(Function1<Object, Long> function1, Flow<Object> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<Object> flowCollector, @Nullable Continuation<? super ur2> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:7|29|30|33|(4:35|(1:40)(1:39)|41|(2:43|44))|45|46|47|(1:49)|50|53|(1:55)|(1:57)(1:58)|57) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0120, code lost:
        r13.z(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0108 A[Catch:{ all -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0133  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Ref$LongRef ref$LongRef;
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref$ObjectRef ref$ObjectRef;
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1;
        Object y;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            ReceiveChannel e = ProduceKt.e((CoroutineScope) this.L$0, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            flowCollector = (FlowCollector) this.L$1;
            flowKt__DelayKt$debounceInternal$1 = this;
            receiveChannel = e;
            ref$ObjectRef = new Ref$ObjectRef();
        } else if (i == 1) {
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            k12.b(obj);
            ref$LongRef = (Ref$LongRef) this.L$3;
            flowKt__DelayKt$debounceInternal$1 = this;
            ref$ObjectRef.element = null;
            if (n30.a()) {
                if (!qc.a(ref$ObjectRef.element == null || ref$LongRef.element > 0).booleanValue()) {
                    throw new AssertionError();
                }
            }
            flowKt__DelayKt$debounceInternal$1.L$0 = flowCollector;
            flowKt__DelayKt$debounceInternal$1.L$1 = receiveChannel;
            flowKt__DelayKt$debounceInternal$1.L$2 = ref$ObjectRef;
            flowKt__DelayKt$debounceInternal$1.L$3 = ref$LongRef;
            flowKt__DelayKt$debounceInternal$1.label = 2;
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(flowKt__DelayKt$debounceInternal$1);
            if (ref$ObjectRef.element != null) {
                selectBuilderImpl.onTimeout(ref$LongRef.element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector, ref$ObjectRef, null));
            }
            selectBuilderImpl.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(ref$ObjectRef, flowCollector, null));
            y = selectBuilderImpl.y();
            if (y == b.d()) {
                p30.c(flowKt__DelayKt$debounceInternal$1);
            }
            if (y != obj2) {
                return obj2;
            }
            obj2 = obj2;
            flowKt__DelayKt$debounceInternal$1 = flowKt__DelayKt$debounceInternal$1;
            receiveChannel = receiveChannel;
            flowCollector = flowCollector;
            return obj2;
        } else if (i == 2) {
            Ref$LongRef ref$LongRef2 = (Ref$LongRef) this.L$3;
            k12.b(obj);
            flowCollector = (FlowCollector) this.L$0;
            receiveChannel = (ReceiveChannel) this.L$1;
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            flowKt__DelayKt$debounceInternal$1 = this;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (ref$ObjectRef.element != ek1.DONE) {
            ref$LongRef = new Ref$LongRef();
            T t = ref$ObjectRef.element;
            if (t != null) {
                Function1<Object, Long> function1 = flowKt__DelayKt$debounceInternal$1.$timeoutMillisSelector;
                jh2 jh2 = ek1.NULL;
                if (t == jh2) {
                    t = null;
                }
                long longValue = function1.invoke(t).longValue();
                ref$LongRef.element = longValue;
                if (longValue >= 0) {
                    if (longValue == 0) {
                        T t2 = ref$ObjectRef.element;
                        if (t2 == jh2) {
                            t2 = null;
                        }
                        flowKt__DelayKt$debounceInternal$1.L$0 = flowCollector;
                        flowKt__DelayKt$debounceInternal$1.L$1 = receiveChannel;
                        flowKt__DelayKt$debounceInternal$1.L$2 = ref$ObjectRef;
                        flowKt__DelayKt$debounceInternal$1.L$3 = ref$LongRef;
                        flowKt__DelayKt$debounceInternal$1.label = 1;
                        if (flowCollector.emit(t2, flowKt__DelayKt$debounceInternal$1) == obj2) {
                            return obj2;
                        }
                        ref$ObjectRef.element = null;
                    }
                }
                throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
            }
            if (n30.a()) {
            }
            flowKt__DelayKt$debounceInternal$1.L$0 = flowCollector;
            flowKt__DelayKt$debounceInternal$1.L$1 = receiveChannel;
            flowKt__DelayKt$debounceInternal$1.L$2 = ref$ObjectRef;
            flowKt__DelayKt$debounceInternal$1.L$3 = ref$LongRef;
            flowKt__DelayKt$debounceInternal$1.label = 2;
            SelectBuilderImpl selectBuilderImpl2 = new SelectBuilderImpl(flowKt__DelayKt$debounceInternal$1);
            if (ref$ObjectRef.element != null) {
            }
            selectBuilderImpl2.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(ref$ObjectRef, flowCollector, null));
            y = selectBuilderImpl2.y();
            if (y == b.d()) {
            }
            if (y != obj2) {
            }
            return obj2;
        }
        return ur2.INSTANCE;
    }
}
