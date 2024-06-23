package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class o01 implements ImplicitReceiver, ThisClassReceiver {
    @NotNull
    private final ClassDescriptor a;
    @NotNull
    private final ClassDescriptor b;

    public o01(@NotNull ClassDescriptor classDescriptor, @Nullable o01 o01) {
        k21.i(classDescriptor, "classDescriptor");
        this.a = classDescriptor;
        this.b = classDescriptor;
    }

    @NotNull
    /* renamed from: a */
    public ib2 getType() {
        ib2 defaultType = this.a.getDefaultType();
        k21.h(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }

    public boolean equals(@Nullable Object obj) {
        ClassDescriptor classDescriptor = this.a;
        ClassDescriptor classDescriptor2 = null;
        o01 o01 = obj instanceof o01 ? (o01) obj : null;
        if (o01 != null) {
            classDescriptor2 = o01.a;
        }
        return k21.d(classDescriptor, classDescriptor2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
    @NotNull
    public final ClassDescriptor getClassDescriptor() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "Class{" + getType() + '}';
    }
}
