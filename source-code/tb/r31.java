package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class r31 extends u31 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r31(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor, @Nullable SimpleFunctionDescriptor simpleFunctionDescriptor2, @NotNull PropertyDescriptor propertyDescriptor) {
        super(classDescriptor, Annotations.Companion.b(), simpleFunctionDescriptor.getModality(), simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor2 != null, propertyDescriptor.getName(), simpleFunctionDescriptor.getSource(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
        k21.i(classDescriptor, "ownerDescriptor");
        k21.i(simpleFunctionDescriptor, "getterMethod");
        k21.i(propertyDescriptor, "overriddenProperty");
    }
}
