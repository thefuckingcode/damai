package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.q7;

/* compiled from: Taobao */
final class ArraysKt___ArraysKt$withIndex$2 extends Lambda implements Function0<Iterator<? extends Byte>> {
    final /* synthetic */ byte[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$2(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    /* Return type fixed from 'java.util.Iterator<java.lang.Byte>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends Byte> invoke() {
        return q7.b(this.$this_withIndex);
    }
}
