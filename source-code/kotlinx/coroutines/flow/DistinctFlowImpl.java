package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DistinctFlowImpl<T> implements Flow<T> {
    @NotNull
    private final Flow<T> a;
    @JvmField
    @NotNull
    public final Function1<T, Object> b;
    @JvmField
    @NotNull
    public final Function2<Object, Object, Boolean> c;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends Object> function1, @NotNull Function2<Object, Object, Boolean> function2) {
        this.a = flow;
        this.b = function1;
        this.c = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @InternalCoroutinesApi
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (T) ek1.NULL;
        Object collect = this.a.collect(new DistinctFlowImpl$collect$$inlined$collect$1(this, ref$ObjectRef, flowCollector), continuation);
        if (collect == b.d()) {
            return collect;
        }
        return ur2.INSTANCE;
    }
}
