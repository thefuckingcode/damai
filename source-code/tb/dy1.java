package tb;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import org.jetbrains.annotations.NotNull;
import tb.ry1;

/* compiled from: Taobao */
public final class dy1 extends ry1 implements JavaArrayType {
    @NotNull
    private final Type a;
    @NotNull
    private final ry1 b;
    @NotNull
    private final Collection<JavaAnnotation> c;
    private final boolean d;

    public dy1(@NotNull Type type) {
        ry1 ry1;
        k21.i(type, "reflectType");
        this.a = type;
        Type a2 = a();
        if (a2 instanceof GenericArrayType) {
            ry1.a aVar = ry1.Factory;
            Type genericComponentType = ((GenericArrayType) a2).getGenericComponentType();
            k21.h(genericComponentType, "genericComponentType");
            ry1 = aVar.a(genericComponentType);
        } else {
            if (a2 instanceof Class) {
                Class cls = (Class) a2;
                if (cls.isArray()) {
                    ry1.a aVar2 = ry1.Factory;
                    Class<?> componentType = cls.getComponentType();
                    k21.h(componentType, "getComponentType()");
                    ry1 = aVar2.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + a().getClass() + "): " + a());
        }
        this.b = ry1;
        this.c = m.g();
    }

    /* access modifiers changed from: protected */
    @Override // tb.ry1
    @NotNull
    public Type a() {
        return this.a;
    }

    @NotNull
    /* renamed from: b */
    public ry1 getComponentType() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.d;
    }
}
