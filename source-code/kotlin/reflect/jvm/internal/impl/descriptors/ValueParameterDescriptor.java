package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
public interface ValueParameterDescriptor extends ParameterDescriptor, VariableDescriptor {

    /* compiled from: Taobao */
    public static final class a {
        public static boolean a(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
            k21.i(valueParameterDescriptor, "this");
            return false;
        }
    }

    @NotNull
    ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull og1 og1, int i);

    boolean declaresDefaultValue();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    @NotNull
    CallableDescriptor getContainingDeclaration();

    int getIndex();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ValueParameterDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    Collection<ValueParameterDescriptor> getOverriddenDescriptors();

    @Nullable
    g61 getVarargElementType();

    boolean isCrossinline();

    boolean isNoinline();
}
