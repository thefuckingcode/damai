package tb;

import java.util.Collection;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qy1 extends ry1 implements JavaPrimitiveType {
    @NotNull
    private final Class<?> a;
    @NotNull
    private final Collection<JavaAnnotation> b = m.g();
    private final boolean c;

    public qy1(@NotNull Class<?> cls) {
        k21.i(cls, "reflectType");
        this.a = cls;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: b */
    public Class<?> a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType
    @Nullable
    public PrimitiveType getType() {
        if (k21.d(a(), Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(a().getName()).getPrimitiveType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.c;
    }
}
