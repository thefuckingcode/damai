package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class in1 extends w30 implements PackageFragmentDescriptor {
    @NotNull
    private final en0 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public in1(@NotNull ModuleDescriptor moduleDescriptor, @NotNull en0 en0) {
        super(moduleDescriptor, Annotations.Companion.b(), en0.h(), SourceElement.NO_SOURCE);
        k21.i(moduleDescriptor, "module");
        k21.i(en0, "fqName");
        this.e = en0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        k21.i(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageFragmentDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    public final en0 getFqName() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource, tb.w30
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        k21.h(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // tb.v30
    @NotNull
    public String toString() {
        return k21.r("package ", this.e);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor, tb.w30, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public ModuleDescriptor getContainingDeclaration() {
        return (ModuleDescriptor) super.getContainingDeclaration();
    }
}
