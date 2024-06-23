package tb;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w31;

/* compiled from: Taobao */
public final class wo2 {
    @NotNull
    public static final <T> T a(@NotNull JvmTypeFactory<T> jvmTypeFactory, @NotNull T t, boolean z) {
        k21.i(jvmTypeFactory, "<this>");
        k21.i(t, "possiblyPrimitiveType");
        return z ? jvmTypeFactory.boxType(t) : t;
    }

    @Nullable
    public static final <T> T b(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull JvmTypeFactory<T> jvmTypeFactory, @NotNull ro2 ro2) {
        k21.i(typeSystemCommonBackendContext, "<this>");
        k21.i(kotlinTypeMarker, "type");
        k21.i(jvmTypeFactory, "typeFactory");
        k21.i(ro2, "mode");
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            return null;
        }
        PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
        boolean z = true;
        if (primitiveType != null) {
            T createPrimitiveType = jvmTypeFactory.createPrimitiveType(primitiveType);
            if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && !mo2.b(typeSystemCommonBackendContext, kotlinTypeMarker)) {
                z = false;
            }
            return (T) a(jvmTypeFactory, createPrimitiveType, z);
        }
        PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
        if (primitiveArrayType != null) {
            return jvmTypeFactory.createFromString(k21.r(jl1.ARRAY_START_STR, JvmPrimitiveType.get(primitiveArrayType).getDesc()));
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
            fn0 classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
            oi o = classFqNameUnsafe == null ? null : w31.INSTANCE.o(classFqNameUnsafe);
            if (o != null) {
                if (!ro2.a()) {
                    List<w31.a> j = w31.INSTANCE.j();
                    if (!(j instanceof Collection) || !j.isEmpty()) {
                        Iterator<T> it = j.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (k21.d(it.next().d(), o)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        return null;
                    }
                }
                String f = a51.b(o).f();
                k21.h(f, "byClassId(classId).internalName");
                return jvmTypeFactory.createObjectType(f);
            }
        }
        return null;
    }
}
