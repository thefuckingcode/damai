package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.dq2;
import tb.eq2;

/* compiled from: Taobao */
final class UArraysKt___UArraysKt$withIndex$4 extends Lambda implements Function0<Iterator<? extends dq2>> {
    final /* synthetic */ short[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$4(short[] sArr) {
        super(0);
        this.$this_withIndex = sArr;
    }

    /* Return type fixed from 'java.util.Iterator<tb.dq2>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends dq2> invoke() {
        return eq2.a(this.$this_withIndex);
    }
}
