package kotlinx.coroutines.flow.internal;

import com.alibaba.wireless.security.SecExceptionCode;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.live.dago.module.DagoPlayerInteract;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k41;
import tb.qj0;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H@"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
/* compiled from: Taobao */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    final /* synthetic */ Flow<Object> $flow;
    final /* synthetic */ Flow<Object> $flow2;
    final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@"}, d2 = {"T1", "T2", "R", "Ltb/ur2;", AdvanceSetting.NETWORK_TYPE, "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2  reason: invalid class name */
    /* compiled from: Taobao */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ur2, Continuation<? super ur2>, Object> {
        int label;

        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$a */
        /* compiled from: Taobao */
        public static final class a implements FlowCollector<Object> {
            final /* synthetic */ CoroutineContext a;
            final /* synthetic */ Object b;
            final /* synthetic */ ReceiveChannel c;
            final /* synthetic */ FlowCollector d;
            final /* synthetic */ Function3 e;

            public a(CoroutineContext coroutineContext, Object obj, ReceiveChannel receiveChannel, FlowCollector flowCollector, Function3 function3) {
                this.a = coroutineContext;
                this.b = obj;
                this.c = receiveChannel;
                this.d = flowCollector;
                this.e = function3;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull Continuation<? super ur2> continuation) {
                CoroutineContext coroutineContext = this.a;
                ur2 ur2 = ur2.INSTANCE;
                Object b2 = a.b(coroutineContext, ur2, this.b, new CombineKt$zipImpl$1$1$2$1$1(this.c, this.d, this.e, obj, null), continuation);
                return b2 == b.d() ? b2 : ur2;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(flow, coroutineContext, b, e2, flowCollector2, function3, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull ur2 ur2, @Nullable Continuation<? super ur2> continuation) {
            return ((AnonymousClass2) create(ur2, continuation)).invokeSuspend(ur2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2 = b.d();
            int i = this.label;
            if (i == 0) {
                k12.b(obj);
                Flow<Object> flow = flow;
                a aVar = new a(coroutineContext, b, e2, flowCollector2, function3);
                this.label = 1;
                if (flow.collect(aVar, this) == obj2) {
                    return obj2;
                }
            } else if (i == 1) {
                k12.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return ur2.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Object, ? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1(FlowCollector<Object> flowCollector, Flow<Object> flow, Flow<Object> flow2, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.$flow2 = flow;
        this.$flow = flow2;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ur2> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ReceiveChannel receiveChannel;
        Throwable th;
        AbortFlowException e;
        ReceiveChannel receiveChannel2;
        CoroutineContext plus;
        ur2 ur2;
        AnonymousClass2 r4;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final ReceiveChannel e2 = ProduceKt.e(coroutineScope, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            final CompletableJob completableJob = k41.b(null, 1, null);
            final FlowCollector<Object> flowCollector = this.$this_unsafeFlow;
            ((SendChannel) e2).invokeOnClose(new Function1<Throwable, ur2>() {
                /* class kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ ur2 invoke(Throwable th) {
                    invoke(th);
                    return ur2.INSTANCE;
                }

                public final void invoke(@Nullable Throwable th) {
                    if (completableJob.isActive()) {
                        completableJob.cancel((CancellationException) new AbortFlowException(flowCollector));
                    }
                }
            });
            try {
                final CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                final Object b = ThreadContextKt.b(coroutineContext);
                plus = coroutineScope.getCoroutineContext().plus(completableJob);
                ur2 = ur2.INSTANCE;
                final Flow<Object> flow = this.$flow;
                final FlowCollector<Object> flowCollector2 = this.$this_unsafeFlow;
                final Function3<Object, Object, Continuation<Object>, Object> function3 = this.$transform;
                r4 = new AnonymousClass2(null);
                this.L$0 = e2;
                this.label = 1;
                receiveChannel2 = e2;
            } catch (AbortFlowException e3) {
                e = e3;
                receiveChannel2 = e2;
                receiveChannel = receiveChannel2;
                try {
                    qj0.a(e, this.$this_unsafeFlow);
                    ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
                    return ur2.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                receiveChannel2 = e2;
                receiveChannel = receiveChannel2;
                ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
                throw th;
            }
            try {
                if (a.c(plus, ur2, null, r4, this, 4, null) == obj2) {
                    return obj2;
                }
                receiveChannel = receiveChannel2;
            } catch (AbortFlowException e4) {
                e = e4;
                receiveChannel = receiveChannel2;
                qj0.a(e, this.$this_unsafeFlow);
                ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
                return ur2.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                receiveChannel = receiveChannel2;
                ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
                throw th;
            }
        } else if (i == 1) {
            receiveChannel = (ReceiveChannel) this.L$0;
            try {
                k12.b(obj);
            } catch (AbortFlowException e5) {
                e = e5;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ReceiveChannel.DefaultImpls.b(receiveChannel, null, 1, null);
        return ur2.INSTANCE;
    }
}
