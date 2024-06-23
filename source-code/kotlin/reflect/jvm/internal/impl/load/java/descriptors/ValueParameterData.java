package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: util.kt */
public final class ValueParameterData {
    private final boolean hasDefaultValue;
    private final KotlinType type;

    public ValueParameterData(KotlinType kotlinType, boolean z) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
        this.type = kotlinType;
        this.hasDefaultValue = z;
    }

    public final boolean getHasDefaultValue() {
        return this.hasDefaultValue;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
