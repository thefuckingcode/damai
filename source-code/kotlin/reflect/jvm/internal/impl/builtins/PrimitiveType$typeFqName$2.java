package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
final class PrimitiveType$typeFqName$2 extends Lambda implements Function0<en0> {
    final /* synthetic */ PrimitiveType this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrimitiveType$typeFqName$2(PrimitiveType primitiveType) {
        super(0);
        this.this$0 = primitiveType;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final en0 invoke() {
        en0 c = c.BUILT_INS_PACKAGE_FQ_NAME.c(this.this$0.getTypeName());
        k21.h(c, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
        return c;
    }
}
