package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.q7;

/* compiled from: Taobao */
final class ArraysKt___ArraysKt$withIndex$5 extends Lambda implements Function0<Iterator<? extends Long>> {
    final /* synthetic */ long[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$5(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    /* Return type fixed from 'java.util.Iterator<java.lang.Long>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends Long> invoke() {
        return q7.g(this.$this_withIndex);
    }
}
