package tb;

import java.lang.reflect.Type;
import kotlin.jvm.JvmName;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.jvm.internal.KTypeImpl;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "ReflectJvmMapping")
/* compiled from: Taobao */
public final class vy1 {
    @NotNull
    public static final Type a(@NotNull KType kType) {
        k21.i(kType, "$this$javaType");
        Type javaType = ((KTypeImpl) kType).getJavaType();
        return javaType != null ? javaType : TypesJVMKt.f(kType);
    }
}
