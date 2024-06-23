package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class FlowKt__CollectionKt {

    /* compiled from: Taobao */
    public static final class a implements FlowCollector<T> {
        final /* synthetic */ Collection a;

        public a(Collection collection) {
            this.a = collection;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
            this.a.add(t);
            return ur2.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T, C extends Collection<? super T>> Object a(@NotNull Flow<? extends T> flow, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        FlowKt__CollectionKt$toCollection$1 flowKt__CollectionKt$toCollection$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$toCollection$1) {
            flowKt__CollectionKt$toCollection$1 = (FlowKt__CollectionKt$toCollection$1) continuation;
            int i2 = flowKt__CollectionKt$toCollection$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$toCollection$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$toCollection$1.result;
                Object obj2 = b.d();
                i = flowKt__CollectionKt$toCollection$1.label;
                if (i != 0) {
                    k12.b(obj);
                    FlowCollector<? super Object> aVar = new a(c);
                    flowKt__CollectionKt$toCollection$1.L$0 = c;
                    flowKt__CollectionKt$toCollection$1.label = 1;
                    return flow.collect(aVar, flowKt__CollectionKt$toCollection$1) == obj2 ? obj2 : c;
                } else if (i == 1) {
                    Collection collection = (Collection) flowKt__CollectionKt$toCollection$1.L$0;
                    k12.b(obj);
                    return collection;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$toCollection$1 = new FlowKt__CollectionKt$toCollection$1(continuation);
        Object obj3 = flowKt__CollectionKt$toCollection$1.result;
        Object obj22 = b.d();
        i = flowKt__CollectionKt$toCollection$1.label;
        if (i != 0) {
        }
    }
}
