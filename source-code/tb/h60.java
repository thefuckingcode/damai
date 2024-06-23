package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class h60 {
    protected h60() {
    }

    @Nullable
    public final Integer a(@NotNull h60 h60) {
        k21.i(h60, "visibility");
        return b().a(h60.b());
    }

    @NotNull
    public abstract qw2 b();

    @NotNull
    public abstract String c();

    public final boolean d() {
        return b().c();
    }

    public abstract boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor);

    @NotNull
    public abstract h60 f();

    @NotNull
    public final String toString() {
        return b().toString();
    }
}
