package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.ib2;

/* compiled from: Taobao */
public interface ClassifierDescriptor extends DeclarationDescriptorNonRoot {
    @NotNull
    ib2 getDefaultType();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ClassifierDescriptor getOriginal();

    @NotNull
    TypeConstructor getTypeConstructor();
}
