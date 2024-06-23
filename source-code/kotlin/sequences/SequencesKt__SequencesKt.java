package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cj0;
import tb.k21;
import tb.qn2;
import tb.rm;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SequencesKt__SequencesKt extends f {

    /* compiled from: Taobao */
    public static final class a implements Sequence<T> {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    @NotNull
    public static <T> Sequence<T> c(@NotNull Iterator<? extends T> it) {
        k21.i(it, "<this>");
        return d(new a(it));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Sequence<T> d(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        return sequence instanceof rm ? sequence : new rm(sequence);
    }

    @NotNull
    public static <T> Sequence<T> e() {
        return a.INSTANCE;
    }

    @NotNull
    public static final <T> Sequence<T> f(@NotNull Sequence<? extends Sequence<? extends T>> sequence) {
        k21.i(sequence, "<this>");
        return g(sequence, SequencesKt__SequencesKt$flatten$1.INSTANCE);
    }

    private static final <T, R> Sequence<R> g(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof qn2) {
            return ((qn2) sequence).c(function1);
        }
        return new cj0(sequence, SequencesKt__SequencesKt$flatten$3.INSTANCE, function1);
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static <T> Sequence<T> h(@Nullable T t, @NotNull Function1<? super T, ? extends T> function1) {
        k21.i(function1, "nextFunction");
        if (t == null) {
            return a.INSTANCE;
        }
        return new b(new SequencesKt__SequencesKt$generateSequence$2(t), function1);
    }

    @NotNull
    public static <T> Sequence<T> i(@NotNull Function0<? extends T> function0) {
        k21.i(function0, "nextFunction");
        return d(new b(function0, new SequencesKt__SequencesKt$generateSequence$1(function0)));
    }

    @NotNull
    public static <T> Sequence<T> j(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        k21.i(function0, "seedFunction");
        k21.i(function1, "nextFunction");
        return new b(function0, function1);
    }

    @NotNull
    public static final <T> Sequence<T> k(@NotNull T... tArr) {
        k21.i(tArr, "elements");
        return tArr.length == 0 ? e() : ArraysKt___ArraysKt.o(tArr);
    }
}
