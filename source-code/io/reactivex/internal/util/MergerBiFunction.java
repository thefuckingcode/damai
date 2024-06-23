package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> comparator;

    public MergerBiFunction(Comparator<? super T> comparator2) {
        this.comparator = comparator2;
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
        return apply((List) ((List) obj), (List) ((List) obj2));
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[ADDED_TO_REGION, EDGE_INSN: B:35:0x0061->B:23:0x0061 ?: BREAK  , SYNTHETIC] */
    public java.util.List<T> apply(java.util.List<T> r6, java.util.List<T> r7) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.MergerBiFunction.apply(java.util.List, java.util.List):java.util.List");
    }
}
