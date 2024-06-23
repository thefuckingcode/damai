package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;

/* compiled from: deprecation.kt */
public final class DeprecationKt {
    private static final CallableDescriptor.UserDataKey<Object> DEPRECATED_FUNCTION_KEY = new DeprecationKt$DEPRECATED_FUNCTION_KEY$1();

    public static final CallableDescriptor.UserDataKey<Object> getDEPRECATED_FUNCTION_KEY() {
        return DEPRECATED_FUNCTION_KEY;
    }
}
