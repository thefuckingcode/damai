package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.q7;

/* compiled from: Taobao */
final class ArraysKt___ArraysKt$withIndex$9 extends Lambda implements Function0<Iterator<? extends Character>> {
    final /* synthetic */ char[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$9(char[] cArr) {
        super(0);
        this.$this_withIndex = cArr;
    }

    /* Return type fixed from 'java.util.Iterator<java.lang.Character>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends Character> invoke() {
        return q7.c(this.$this_withIndex);
    }
}
