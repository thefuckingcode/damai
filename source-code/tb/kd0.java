package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class kd0 extends in1 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public kd0(@NotNull ModuleDescriptor moduleDescriptor, @NotNull en0 en0) {
        super(moduleDescriptor, en0);
        k21.i(moduleDescriptor, "module");
        k21.i(en0, "fqName");
    }

    @NotNull
    /* renamed from: d */
    public MemberScope.b getMemberScope() {
        return MemberScope.b.INSTANCE;
    }
}
