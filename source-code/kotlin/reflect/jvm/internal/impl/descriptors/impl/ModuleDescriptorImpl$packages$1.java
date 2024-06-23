package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ModuleDescriptorImpl$packages$1 extends Lambda implements Function1<en0, PackageViewDescriptor> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(1);
        this.this$0 = moduleDescriptorImpl;
    }

    @NotNull
    public final PackageViewDescriptor invoke(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, en0, moduleDescriptorImpl.c);
    }
}
