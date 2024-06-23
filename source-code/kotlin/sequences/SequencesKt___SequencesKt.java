package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cj0;
import tb.fc0;
import tb.k21;
import tb.qn2;
import tb.ri0;
import tb.wi2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SequencesKt___SequencesKt extends g {

    /* compiled from: Taobao */
    public static final class a implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Sequence a;

        public a(Sequence sequence) {
            this.a = sequence;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C A(@NotNull Sequence<? extends T> sequence, @NotNull C c) {
        k21.i(sequence, "<this>");
        k21.i(c, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    @NotNull
    public static <T> List<T> B(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        return m.n(C(sequence));
    }

    @NotNull
    public static <T> List<T> C(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        return (List) A(sequence, new ArrayList());
    }

    @NotNull
    public static <T> Iterable<T> l(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        return new a(sequence);
    }

    public static <T> int m(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                m.o();
            }
        }
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> Sequence<T> n(@NotNull Sequence<? extends T> sequence, int i) {
        k21.i(sequence, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return sequence;
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).drop(i);
            }
            return new fc0(sequence, i);
        }
    }

    @NotNull
    public static <T> Sequence<T> o(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        k21.i(sequence, "<this>");
        k21.i(function1, "predicate");
        return new ri0(sequence, true, function1);
    }

    @NotNull
    public static <T> Sequence<T> p(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        k21.i(sequence, "<this>");
        k21.i(function1, "predicate");
        return new ri0(sequence, false, function1);
    }

    @NotNull
    public static <T> Sequence<T> q(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        Sequence<T> sequence2 = p(sequence, SequencesKt___SequencesKt$filterNotNull$1.INSTANCE);
        k21.g(sequence2, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return sequence2;
    }

    public static <T> T r(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @Nullable
    public static <T> T s(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return (T) it.next();
    }

    @NotNull
    public static <T, R> Sequence<R> t(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        k21.i(sequence, "<this>");
        k21.i(function1, "transform");
        return new cj0(sequence, function1, SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    public static <T> T u(@NotNull Sequence<? extends T> sequence) {
        k21.i(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            while (it.hasNext()) {
                t = (T) it.next();
            }
            return t;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @NotNull
    public static <T, R> Sequence<R> v(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        k21.i(sequence, "<this>");
        k21.i(function1, "transform");
        return new qn2(sequence, function1);
    }

    @NotNull
    public static <T, R> Sequence<R> w(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        k21.i(sequence, "<this>");
        k21.i(function1, "transform");
        return q(new qn2(sequence, function1));
    }

    @NotNull
    public static <T> Sequence<T> x(@NotNull Sequence<? extends T> sequence, @NotNull Iterable<? extends T> iterable) {
        k21.i(sequence, "<this>");
        k21.i(iterable, "elements");
        return SequencesKt__SequencesKt.f(SequencesKt__SequencesKt.k(sequence, CollectionsKt___CollectionsKt.I(iterable)));
    }

    @NotNull
    public static <T> Sequence<T> y(@NotNull Sequence<? extends T> sequence, T t) {
        k21.i(sequence, "<this>");
        return SequencesKt__SequencesKt.f(SequencesKt__SequencesKt.k(sequence, SequencesKt__SequencesKt.k(t)));
    }

    @NotNull
    public static <T> Sequence<T> z(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        k21.i(sequence, "<this>");
        k21.i(function1, "predicate");
        return new wi2(sequence, function1);
    }
}
