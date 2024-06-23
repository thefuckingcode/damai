package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;

/* compiled from: Taobao */
public interface CallableDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility, Substitutable<CallableDescriptor> {

    /* compiled from: Taobao */
    public interface UserDataKey<V> {
    }

    @Nullable
    ReceiverParameterDescriptor getDispatchReceiverParameter();

    @Nullable
    ReceiverParameterDescriptor getExtensionReceiverParameter();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    CallableDescriptor getOriginal();

    @NotNull
    Collection<? extends CallableDescriptor> getOverriddenDescriptors();

    @Nullable
    g61 getReturnType();

    @NotNull
    List<TypeParameterDescriptor> getTypeParameters();

    @Nullable
    <V> V getUserData(UserDataKey<V> userDataKey);

    @NotNull
    List<ValueParameterDescriptor> getValueParameters();

    boolean hasSynthesizedParameterNames();
}
