package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: ConstUtil.kt */
public final class ConstUtilKt {
    public static final boolean canBeUsedForConstVal(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$canBeUsedForConstVal");
        return ((KotlinBuiltIns.isPrimitiveType(kotlinType) || UnsignedTypes.INSTANCE.isUnsignedType(kotlinType)) && !TypeUtils.isNullableType(kotlinType)) || KotlinBuiltIns.isString(kotlinType);
    }
}
