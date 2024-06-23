package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.ib2;
import tb.k21;

/* compiled from: Taobao */
final class JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1 extends Lambda implements Function0<g61> {
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final g61 invoke() {
        ib2 i = this.this$0.a.getBuiltIns().i();
        k21.h(i, "moduleDescriptor.builtIns.anyType");
        return i;
    }
}
