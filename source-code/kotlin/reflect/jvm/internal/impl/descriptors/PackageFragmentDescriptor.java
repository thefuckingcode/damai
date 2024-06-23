package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.en0;

/* compiled from: Taobao */
public interface PackageFragmentDescriptor extends ClassOrPackageFragmentDescriptor {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ModuleDescriptor getContainingDeclaration();

    @NotNull
    en0 getFqName();

    @NotNull
    MemberScope getMemberScope();
}
