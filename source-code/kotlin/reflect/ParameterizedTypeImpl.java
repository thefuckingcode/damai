package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jl1;
import tb.k21;

/* access modifiers changed from: package-private */
@ExperimentalStdlibApi
/* compiled from: Taobao */
public final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    @NotNull
    private final Class<?> a;
    @Nullable
    private final Type b;
    @NotNull
    private final Type[] c;

    public ParameterizedTypeImpl(@NotNull Class<?> cls, @Nullable Type type, @NotNull List<? extends Type> list) {
        k21.i(cls, "rawType");
        k21.i(list, "typeArguments");
        this.a = cls;
        this.b = type;
        Object[] array = list.toArray(new Type[0]);
        k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.c = (Type[]) array;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return k21.d(this.a, parameterizedType.getRawType()) && k21.d(this.b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }
    }

    @NotNull
    public Type[] getActualTypeArguments() {
        return this.c;
    }

    @Nullable
    public Type getOwnerType() {
        return this.b;
    }

    @NotNull
    public Type getRawType() {
        return this.a;
    }

    @Override // kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Type type = this.b;
        if (type != null) {
            sb.append(TypesJVMKt.h(type));
            sb.append("$");
            sb.append(this.a.getSimpleName());
        } else {
            sb.append(TypesJVMKt.h(this.a));
        }
        Type[] typeArr = this.c;
        if (!(typeArr.length == 0)) {
            Appendable unused = ArraysKt___ArraysKt.D(typeArr, sb, null, jl1.L, jl1.G, 0, null, ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, null);
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode();
        Type type = this.b;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
