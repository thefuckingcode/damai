package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.yp2;
import tb.zp2;

/* compiled from: Taobao */
final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements Function0<Iterator<? extends yp2>> {
    final /* synthetic */ long[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$2(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    /* Return type fixed from 'java.util.Iterator<tb.yp2>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends yp2> invoke() {
        return zp2.a(this.$this_withIndex);
    }
}
