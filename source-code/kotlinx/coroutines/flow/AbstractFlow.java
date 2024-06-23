package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

@FlowPreview
/* compiled from: Taobao */
public abstract class AbstractFlow<T> implements Flow<T>, CancellableFlow<T> {
    @Nullable
    public abstract Object a(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation);

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.Flow
    @InternalCoroutinesApi
    @Nullable
    public final Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        AbstractFlow$collect$1 abstractFlow$collect$1;
        int i;
        Throwable th;
        SafeCollector safeCollector;
        if (continuation instanceof AbstractFlow$collect$1) {
            abstractFlow$collect$1 = (AbstractFlow$collect$1) continuation;
            int i2 = abstractFlow$collect$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                abstractFlow$collect$1.label = i2 - Integer.MIN_VALUE;
                Object obj = abstractFlow$collect$1.result;
                Object obj2 = b.d();
                i = abstractFlow$collect$1.label;
                if (i != 0) {
                    k12.b(obj);
                    FlowCollector<? super T> safeCollector2 = new SafeCollector<>(flowCollector, abstractFlow$collect$1.getContext());
                    try {
                        abstractFlow$collect$1.L$0 = safeCollector2;
                        abstractFlow$collect$1.label = 1;
                        if (a(safeCollector2, abstractFlow$collect$1) == obj2) {
                            return obj2;
                        }
                        safeCollector = safeCollector2;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                } else if (i == 1) {
                    safeCollector = (SafeCollector) abstractFlow$collect$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                safeCollector.releaseIntercepted();
                return ur2.INSTANCE;
            }
        }
        abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
        Object obj3 = abstractFlow$collect$1.result;
        Object obj22 = b.d();
        i = abstractFlow$collect$1.label;
        if (i != 0) {
        }
        safeCollector.releaseIntercepted();
        return ur2.INSTANCE;
    }
}
