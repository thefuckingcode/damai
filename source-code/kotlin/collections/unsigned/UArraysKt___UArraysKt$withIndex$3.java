package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.ip2;
import tb.jp2;

/* compiled from: Taobao */
final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements Function0<Iterator<? extends ip2>> {
    final /* synthetic */ byte[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$3(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    /* Return type fixed from 'java.util.Iterator<tb.ip2>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends ip2> invoke() {
        return jp2.a(this.$this_withIndex);
    }
}
