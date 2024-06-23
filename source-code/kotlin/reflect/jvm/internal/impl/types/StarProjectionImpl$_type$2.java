package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.be2;
import tb.g61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class StarProjectionImpl$_type$2 extends Lambda implements Function0<g61> {
    final /* synthetic */ StarProjectionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StarProjectionImpl$_type$2(StarProjectionImpl starProjectionImpl) {
        super(0);
        this.this$0 = starProjectionImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final g61 invoke() {
        return be2.a(this.this$0.a);
    }
}
