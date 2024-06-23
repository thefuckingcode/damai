package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ib2;

/* compiled from: Taobao */
public interface TypeAliasDescriptor extends ClassifierDescriptorWithTypeParameters {
    @Nullable
    ClassDescriptor getClassDescriptor();

    @NotNull
    ib2 getExpandedType();

    @NotNull
    ib2 getUnderlyingType();
}
