package tb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class ua2 {
    @NotNull
    public static final ua2 INSTANCE = new ua2();

    private ua2() {
    }

    @NotNull
    public final String a(@NotNull Constructor<?> constructor) {
        k21.i(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.BRACKET_START_STR);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        k21.h(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            k21.h(cls, "parameterType");
            sb.append(ReflectClassUtilKt.c(cls));
        }
        sb.append(")V");
        String sb2 = sb.toString();
        k21.h(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    public final String b(@NotNull Field field) {
        k21.i(field, "field");
        Class<?> type = field.getType();
        k21.h(type, "field.type");
        return ReflectClassUtilKt.c(type);
    }

    @NotNull
    public final String c(@NotNull Method method) {
        k21.i(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.BRACKET_START_STR);
        Class<?>[] parameterTypes = method.getParameterTypes();
        k21.h(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            k21.h(cls, "parameterType");
            sb.append(ReflectClassUtilKt.c(cls));
        }
        sb.append(jl1.BRACKET_END_STR);
        Class<?> returnType = method.getReturnType();
        k21.h(returnType, "method.returnType");
        sb.append(ReflectClassUtilKt.c(returnType));
        String sb2 = sb.toString();
        k21.h(sb2, "sb.toString()");
        return sb2;
    }
}
