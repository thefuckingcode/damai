package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import tb.jl1;
import tb.k21;

/* compiled from: Taobao */
public final class RuntimeTypeMapperKt {
    /* access modifiers changed from: private */
    public static final String b(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        k21.h(parameterTypes, "parameterTypes");
        sb.append(ArraysKt___ArraysKt.F(parameterTypes, "", jl1.BRACKET_START_STR, jl1.BRACKET_END_STR, 0, null, RuntimeTypeMapperKt$signature$1.INSTANCE, 24, null));
        Class<?> returnType = method.getReturnType();
        k21.h(returnType, "returnType");
        sb.append(ReflectClassUtilKt.c(returnType));
        return sb.toString();
    }
}
