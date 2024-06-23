package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.s82;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class e {

    /* compiled from: Taobao */
    public static final class a implements Sequence<T> {
        final /* synthetic */ Function2 a;

        public a(Function2 function2) {
            this.a = function2;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            return e.a(this.a);
        }
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Iterator<T> a(@BuilderInference @NotNull Function2<? super s82<? super T>, ? super Continuation<? super ur2>, ? extends Object> function2) {
        k21.i(function2, "block");
        c cVar = new c();
        cVar.f(IntrinsicsKt__IntrinsicsJvmKt.b(function2, cVar, cVar));
        return cVar;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> Sequence<T> b(@BuilderInference @NotNull Function2<? super s82<? super T>, ? super Continuation<? super ur2>, ? extends Object> function2) {
        k21.i(function2, "block");
        return new a(function2);
    }
}
