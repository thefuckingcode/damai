package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;

/* compiled from: Taobao */
final class ErasedOverridabilityCondition$isOverridable$signatureTypes$1 extends Lambda implements Function1<ValueParameterDescriptor, g61> {
    public static final ErasedOverridabilityCondition$isOverridable$signatureTypes$1 INSTANCE = new ErasedOverridabilityCondition$isOverridable$signatureTypes$1();

    ErasedOverridabilityCondition$isOverridable$signatureTypes$1() {
        super(1);
    }

    @NotNull
    public final g61 invoke(ValueParameterDescriptor valueParameterDescriptor) {
        return valueParameterDescriptor.getType();
    }
}
