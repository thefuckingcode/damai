package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.i61;

/* compiled from: Taobao */
public interface TypeConstructor extends TypeConstructorMarker {
    @NotNull
    b getBuiltIns();

    @Nullable
    ClassifierDescriptor getDeclarationDescriptor();

    @NotNull
    List<TypeParameterDescriptor> getParameters();

    @NotNull
    Collection<g61> getSupertypes();

    boolean isDenotable();

    @NotNull
    TypeConstructor refine(@NotNull i61 i61);
}
