package tb;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class gn1 {
    public abstract void a(@NotNull CallableMemberDescriptor callableMemberDescriptor);

    public abstract void b(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void c(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2);

    public void d(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection) {
        k21.i(callableMemberDescriptor, "member");
        k21.i(collection, "overridden");
        callableMemberDescriptor.setOverriddenDescriptors(collection);
    }
}
