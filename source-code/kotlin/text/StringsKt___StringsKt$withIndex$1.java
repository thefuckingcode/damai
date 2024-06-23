package kotlin.text;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class StringsKt___StringsKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends Character>> {
    final /* synthetic */ CharSequence $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$withIndex$1(CharSequence charSequence) {
        super(0);
        this.$this_withIndex = charSequence;
    }

    /* Return type fixed from 'java.util.Iterator<java.lang.Character>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends Character> invoke() {
        return StringsKt__StringsKt.h0(this.$this_withIndex);
    }
}
