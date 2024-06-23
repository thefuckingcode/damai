package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class ReflectionTypes$kotlinReflectScope$2 extends Lambda implements Function0<MemberScope> {
    final /* synthetic */ ModuleDescriptor $module;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReflectionTypes$kotlinReflectScope$2(ModuleDescriptor moduleDescriptor) {
        super(0);
        this.$module = moduleDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final MemberScope invoke() {
        return this.$module.getPackage(c.KOTLIN_REFLECT_FQ_NAME).getMemberScope();
    }
}
