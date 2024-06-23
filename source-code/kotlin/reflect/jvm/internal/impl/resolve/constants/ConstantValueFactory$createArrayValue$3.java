package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.ib2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ConstantValueFactory$createArrayValue$3 extends Lambda implements Function1<ModuleDescriptor, g61> {
    final /* synthetic */ PrimitiveType $componentType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstantValueFactory$createArrayValue$3(PrimitiveType primitiveType) {
        super(1);
        this.$componentType = primitiveType;
    }

    @NotNull
    public final g61 invoke(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 N = moduleDescriptor.getBuiltIns().N(this.$componentType);
        k21.h(N, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
        return N;
    }
}
