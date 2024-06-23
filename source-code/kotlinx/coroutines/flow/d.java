package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class d {

    /* compiled from: Taobao */
    public static final class a implements Flow<T> {
        final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @Nullable
        public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
            Object emit = flowCollector.emit((Object) this.a, continuation);
            if (emit == b.d()) {
                return emit;
            }
            return ur2.INSTANCE;
        }
    }

    @NotNull
    public static final <T> Flow<T> a(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super ur2>, ? extends Object> function2) {
        return new h(function2);
    }

    @NotNull
    public static final <T> Flow<T> b(T t) {
        return new a(t);
    }
}
