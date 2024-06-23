package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.vp2;
import tb.wp2;

/* compiled from: Taobao */
final class UArraysKt___UArraysKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends vp2>> {
    final /* synthetic */ int[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$1(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    /* Return type fixed from 'java.util.Iterator<tb.vp2>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends vp2> invoke() {
        return wp2.a(this.$this_withIndex);
    }
}
