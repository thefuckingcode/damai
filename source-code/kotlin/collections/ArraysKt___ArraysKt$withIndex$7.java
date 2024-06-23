package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.q7;

/* compiled from: Taobao */
final class ArraysKt___ArraysKt$withIndex$7 extends Lambda implements Function0<Iterator<? extends Double>> {
    final /* synthetic */ double[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$7(double[] dArr) {
        super(0);
        this.$this_withIndex = dArr;
    }

    /* Return type fixed from 'java.util.Iterator<java.lang.Double>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends Double> invoke() {
        return q7.d(this.$this_withIndex);
    }
}
