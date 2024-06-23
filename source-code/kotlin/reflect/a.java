package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
@ExperimentalStdlibApi
/* compiled from: Taobao */
public final class a implements GenericArrayType, TypeImpl {
    @NotNull
    private final Type a;

    public a(@NotNull Type type) {
        k21.i(type, "elementType");
        this.a = type;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof GenericArrayType) && k21.d(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @NotNull
    public Type getGenericComponentType() {
        return this.a;
    }

    @Override // kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        return TypesJVMKt.h(this.a) + "[]";
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
