package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* compiled from: RuntimeErrorReporter.kt */
public final class RuntimeErrorReporter implements ErrorReporter {
    public static final RuntimeErrorReporter INSTANCE = new RuntimeErrorReporter();

    private RuntimeErrorReporter() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "descriptor");
        Intrinsics.checkParameterIsNotNull(list, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + classDescriptor.getName() + ", unresolved classes " + list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + callableMemberDescriptor);
    }
}
