package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: utils.kt */
public final class DeprecationCausedByFunctionN {
    private final DeclarationDescriptor target;

    public DeprecationCausedByFunctionN(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "target");
        this.target = declarationDescriptor;
    }
}
