package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.q7;

/* compiled from: Taobao */
final class ArraysKt___ArraysKt$withIndex$8 extends Lambda implements Function0<Iterator<? extends Boolean>> {
    final /* synthetic */ boolean[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$8(boolean[] zArr) {
        super(0);
        this.$this_withIndex = zArr;
    }

    /* Return type fixed from 'java.util.Iterator<java.lang.Boolean>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends Boolean> invoke() {
        return q7.a(this.$this_withIndex);
    }
}
