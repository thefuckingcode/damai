package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.i61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyWrappedType$refine$1 extends Lambda implements Function0<g61> {
    final /* synthetic */ i61 $kotlinTypeRefiner;
    final /* synthetic */ LazyWrappedType this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyWrappedType$refine$1(i61 i61, LazyWrappedType lazyWrappedType) {
        super(0);
        this.$kotlinTypeRefiner = i61;
        this.this$0 = lazyWrappedType;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final g61 invoke() {
        return this.$kotlinTypeRefiner.g((g61) this.this$0.c.invoke());
    }
}
