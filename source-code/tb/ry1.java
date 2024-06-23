package tb;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class ry1 implements JavaType {
    @NotNull
    public static final a Factory = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final ry1 a(@NotNull Type type) {
            ry1 ry1;
            k21.i(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new qy1(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                ry1 = new dy1(type);
            } else if (type instanceof WildcardType) {
                ry1 = new uy1((WildcardType) type);
            } else {
                ry1 = new hy1(type);
            }
            return ry1;
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Type a();

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ry1) && k21.d(a(), ((ry1) obj).a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull en0 en0) {
        return JavaType.a.a(this, en0);
    }

    public int hashCode() {
        return a().hashCode();
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + a();
    }
}
