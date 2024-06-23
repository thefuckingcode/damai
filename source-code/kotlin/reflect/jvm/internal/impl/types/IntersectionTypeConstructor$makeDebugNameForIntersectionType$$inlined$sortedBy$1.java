package kotlin.reflect.jvm.internal.impl.types;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
public final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(t.toString(), t2.toString());
    }
}
