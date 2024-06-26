package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.ib2;
import tb.k21;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class a implements TypeParameterDescriptor {
    @NotNull
    private final TypeParameterDescriptor a;
    @NotNull
    private final DeclarationDescriptor b;
    private final int c;

    public a(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull DeclarationDescriptor declarationDescriptor, int i) {
        k21.i(typeParameterDescriptor, "originalDescriptor");
        k21.i(declarationDescriptor, "declarationDescriptor");
        this.a = typeParameterDescriptor;
        this.b = declarationDescriptor;
        this.c = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) this.a.accept(declarationDescriptorVisitor, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public ib2 getDefaultType() {
        return this.a.getDefaultType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public int getIndex() {
        return this.c + this.a.getIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    @NotNull
    public og1 getName() {
        return this.a.getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        return this.a.getSource();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public StorageManager getStorageManager() {
        return this.a.getStorageManager();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.a.getTypeConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public List<g61> getUpperBounds() {
        return this.a.getUpperBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    @NotNull
    public Variance getVariance() {
        return this.a.getVariance();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isReified() {
        return this.a.isReified();
    }

    @NotNull
    public String toString() {
        return this.a + "[inner-copy]";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor original = this.a.getOriginal();
        k21.h(original, "originalDescriptor.original");
        return original;
    }
}
