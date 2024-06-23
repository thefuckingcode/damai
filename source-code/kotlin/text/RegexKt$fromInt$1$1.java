package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class RegexKt$fromInt$1$1 extends Lambda implements Function1<Enum, Boolean> {
    final /* synthetic */ int $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RegexKt$fromInt$1$1(int i) {
        super(1);
        this.$value = i;
    }

    @NotNull
    public final Boolean invoke(Enum r3) {
        FlagEnum flagEnum = (FlagEnum) r3;
        return Boolean.valueOf((this.$value & flagEnum.getMask()) == flagEnum.getValue());
    }
}
