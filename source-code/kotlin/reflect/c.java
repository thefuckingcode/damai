package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* access modifiers changed from: package-private */
@ExperimentalStdlibApi
/* compiled from: Taobao */
public final class c implements WildcardType, TypeImpl {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final c c = new c(null, null);
    @Nullable
    private final Type a;
    @Nullable
    private final Type b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final c a() {
            return c.c;
        }
    }

    public c(@Nullable Type type, @Nullable Type type2) {
        this.a = type;
        this.b = type2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            return Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds());
        }
    }

    @NotNull
    public Type[] getLowerBounds() {
        Type type = this.b;
        if (type == null) {
            return new Type[0];
        }
        return new Type[]{type};
    }

    @Override // kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        if (this.b != null) {
            return "? super " + TypesJVMKt.h(this.b);
        }
        Type type = this.a;
        if (type == null || k21.d(type, Object.class)) {
            return "?";
        }
        return "? extends " + TypesJVMKt.h(this.a);
    }

    @NotNull
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.a;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
