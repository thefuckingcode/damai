package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class d22 implements ErrorReporter {
    @NotNull
    public static final d22 INSTANCE = new d22();

    private d22() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, "descriptor");
        throw new IllegalStateException(k21.r("Cannot infer visibility for ", callableMemberDescriptor));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(@NotNull ClassDescriptor classDescriptor, @NotNull List<String> list) {
        k21.i(classDescriptor, "descriptor");
        k21.i(list, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + classDescriptor.getName() + ", unresolved classes " + list);
    }
}
