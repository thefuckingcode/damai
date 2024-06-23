package kotlin.text;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class Regex$findAll$1 extends Lambda implements Function0<MatchResult> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ Regex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Regex$findAll$1(Regex regex, CharSequence charSequence, int i) {
        super(0);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = i;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final MatchResult invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
