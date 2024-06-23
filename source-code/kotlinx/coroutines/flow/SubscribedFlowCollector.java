package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    @NotNull
    private final FlowCollector<T> a;
    @NotNull
    private final Function2<FlowCollector<? super T>, Continuation<? super ur2>, Object> b;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    public final Object a(@NotNull Continuation<? super ur2> continuation) {
        SubscribedFlowCollector$onSubscription$1 subscribedFlowCollector$onSubscription$1;
        int i;
        Throwable th;
        SafeCollector safeCollector;
        SubscribedFlowCollector<T> subscribedFlowCollector;
        FlowCollector<T> flowCollector;
        if (continuation instanceof SubscribedFlowCollector$onSubscription$1) {
            subscribedFlowCollector$onSubscription$1 = (SubscribedFlowCollector$onSubscription$1) continuation;
            int i2 = subscribedFlowCollector$onSubscription$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                subscribedFlowCollector$onSubscription$1.label = i2 - Integer.MIN_VALUE;
                Object obj = subscribedFlowCollector$onSubscription$1.result;
                Object obj2 = b.d();
                i = subscribedFlowCollector$onSubscription$1.label;
                if (i != 0) {
                    k12.b(obj);
                    SafeCollector safeCollector2 = new SafeCollector(this.a, subscribedFlowCollector$onSubscription$1.getContext());
                    try {
                        Function2<FlowCollector<? super T>, Continuation<? super ur2>, Object> function2 = this.b;
                        subscribedFlowCollector$onSubscription$1.L$0 = this;
                        subscribedFlowCollector$onSubscription$1.L$1 = safeCollector2;
                        subscribedFlowCollector$onSubscription$1.label = 1;
                        if (function2.invoke(safeCollector2, subscribedFlowCollector$onSubscription$1) == obj2) {
                            return obj2;
                        }
                        subscribedFlowCollector = this;
                        safeCollector = safeCollector2;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                } else if (i == 1) {
                    safeCollector = (SafeCollector) subscribedFlowCollector$onSubscription$1.L$1;
                    subscribedFlowCollector = (SubscribedFlowCollector) subscribedFlowCollector$onSubscription$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else if (i == 2) {
                    k12.b(obj);
                    return ur2.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                safeCollector.releaseIntercepted();
                flowCollector = subscribedFlowCollector.a;
                if (flowCollector instanceof SubscribedFlowCollector) {
                    return ur2.INSTANCE;
                }
                subscribedFlowCollector$onSubscription$1.L$0 = null;
                subscribedFlowCollector$onSubscription$1.L$1 = null;
                subscribedFlowCollector$onSubscription$1.label = 2;
                if (((SubscribedFlowCollector) flowCollector).a(subscribedFlowCollector$onSubscription$1) == obj2) {
                    return obj2;
                }
                return ur2.INSTANCE;
            }
        }
        subscribedFlowCollector$onSubscription$1 = new SubscribedFlowCollector$onSubscription$1(this, continuation);
        Object obj3 = subscribedFlowCollector$onSubscription$1.result;
        Object obj22 = b.d();
        i = subscribedFlowCollector$onSubscription$1.label;
        if (i != 0) {
        }
        safeCollector.releaseIntercepted();
        flowCollector = subscribedFlowCollector.a;
        if (flowCollector instanceof SubscribedFlowCollector) {
        }
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        return this.a.emit(t, continuation);
    }
}
