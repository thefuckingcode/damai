package kotlin.comparisons;

import java.util.Comparator;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public class ComparisonsKt__ComparisonsKt {
    public static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkParameterIsNotNull(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return compareValuesByImpl$ComparisonsKt__ComparisonsKt(t, t2, function1Arr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int compareValues = ComparisonsKt.compareValues((Comparable) function1.invoke(t), (Comparable) function1.invoke(t2));
            if (compareValues != 0) {
                return compareValues;
            }
        }
        return 0;
    }

    private static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>> function1) {
        return ComparisonsKt.compareValues((Comparable) function1.invoke(t), (Comparable) function1.invoke(t2));
    }

    private static final <T, K> int compareValuesBy(T t, T t2, Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        return comparator.compare((Object) function1.invoke(t), (Object) function1.invoke(t2));
    }

    public static final <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkParameterIsNotNull(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return new ComparisonsKt__ComparisonsKt$compareBy$1(function1Arr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> function1) {
        return new ComparisonsKt__ComparisonsKt$compareBy$2(function1);
    }

    private static final <T, K> Comparator<T> compareBy(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        return new ComparisonsKt__ComparisonsKt$compareBy$3(comparator, function1);
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> function1) {
        return new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1);
    }

    private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        return new ComparisonsKt__ComparisonsKt$compareByDescending$2(comparator, function1);
    }

    private static final <T> Comparator<T> thenBy(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
        return new ComparisonsKt__ComparisonsKt$thenBy$1(comparator, function1);
    }

    private static final <T, K> Comparator<T> thenBy(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
        return new ComparisonsKt__ComparisonsKt$thenBy$2(comparator, comparator2, function1);
    }

    private static final <T> Comparator<T> thenByDescending(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
        return new ComparisonsKt__ComparisonsKt$thenByDescending$1(comparator, function1);
    }

    private static final <T, K> Comparator<T> thenByDescending(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
        return new ComparisonsKt__ComparisonsKt$thenByDescending$2(comparator, comparator2, function1);
    }

    private static final <T> Comparator<T> thenComparator(Comparator<T> comparator, Function2<? super T, ? super T, Integer> function2) {
        return new ComparisonsKt__ComparisonsKt$thenComparator$1(comparator, function2);
    }

    public static final <T> Comparator<T> then(Comparator<T> comparator, Comparator<? super T> comparator2) {
        Intrinsics.checkParameterIsNotNull(comparator, "$this$then");
        Intrinsics.checkParameterIsNotNull(comparator2, "comparator");
        return new ComparisonsKt__ComparisonsKt$then$1(comparator, comparator2);
    }

    public static final <T> Comparator<T> thenDescending(Comparator<T> comparator, Comparator<? super T> comparator2) {
        Intrinsics.checkParameterIsNotNull(comparator, "$this$thenDescending");
        Intrinsics.checkParameterIsNotNull(comparator2, "comparator");
        return new ComparisonsKt__ComparisonsKt$thenDescending$1(comparator, comparator2);
    }

    public static final <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return new ComparisonsKt__ComparisonsKt$nullsFirst$1(comparator);
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return new ComparisonsKt__ComparisonsKt$nullsLast$1(comparator);
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
        if (naturalOrderComparator != null) {
            return naturalOrderComparator;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
        if (reverseOrderComparator != null) {
            return reverseOrderComparator;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
    }

    public static final <T> Comparator<T> reversed(Comparator<T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "$this$reversed");
        if (comparator instanceof ReversedComparator) {
            return ((ReversedComparator) comparator).getComparator();
        }
        if (Intrinsics.areEqual(comparator, NaturalOrderComparator.INSTANCE)) {
            ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
            if (reverseOrderComparator != null) {
                return reverseOrderComparator;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        } else if (!Intrinsics.areEqual(comparator, ReverseOrderComparator.INSTANCE)) {
            return new ReversedComparator(comparator);
        } else {
            NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
            if (naturalOrderComparator != null) {
                return naturalOrderComparator;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        }
    }
}
