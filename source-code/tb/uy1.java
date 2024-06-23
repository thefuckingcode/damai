package tb;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.e;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ry1;

/* compiled from: Taobao */
public final class uy1 extends ry1 implements JavaWildcardType {
    @NotNull
    private final WildcardType a;
    @NotNull
    private final Collection<JavaAnnotation> b = m.g();
    private final boolean c;

    public uy1(@NotNull WildcardType wildcardType) {
        k21.i(wildcardType, "reflectType");
        this.a = wildcardType;
    }

    @Nullable
    /* renamed from: b */
    public ry1 getBound() {
        Type[] upperBounds = a().getUpperBounds();
        Type[] lowerBounds = a().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(k21.r("Wildcard types with many bounds are not yet supported: ", a()));
        } else if (lowerBounds.length == 1) {
            ry1.a aVar = ry1.Factory;
            k21.h(lowerBounds, "lowerBounds");
            Object L = e.L(lowerBounds);
            k21.h(L, "lowerBounds.single()");
            return aVar.a((Type) L);
        } else if (upperBounds.length != 1) {
            return null;
        } else {
            k21.h(upperBounds, "upperBounds");
            Type type = (Type) e.L(upperBounds);
            if (k21.d(type, Object.class)) {
                return null;
            }
            ry1.a aVar2 = ry1.Factory;
            k21.h(type, "ub");
            return aVar2.a(type);
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: c */
    public WildcardType a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        Type[] upperBounds = a().getUpperBounds();
        k21.h(upperBounds, "reflectType.upperBounds");
        return !k21.d(e.v(upperBounds), Object.class);
    }
}
