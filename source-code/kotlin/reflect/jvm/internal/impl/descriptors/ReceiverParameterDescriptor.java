package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface ReceiverParameterDescriptor extends ParameterDescriptor {
    @NotNull
    ReceiverValue getValue();

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @Nullable
    CallableDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor);
}
