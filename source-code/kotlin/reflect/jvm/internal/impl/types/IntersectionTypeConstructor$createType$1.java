package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i61;
import tb.ib2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class IntersectionTypeConstructor$createType$1 extends Lambda implements Function1<i61, ib2> {
    final /* synthetic */ IntersectionTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntersectionTypeConstructor$createType$1(IntersectionTypeConstructor intersectionTypeConstructor) {
        super(1);
        this.this$0 = intersectionTypeConstructor;
    }

    @Nullable
    public final ib2 invoke(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this.this$0.refine(i61).b();
    }
}
