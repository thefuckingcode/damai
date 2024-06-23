package tb;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ty1 extends jy1 implements JavaValueParameter {
    @NotNull
    private final ry1 a;
    @NotNull
    private final Annotation[] b;
    @Nullable
    private final String c;
    private final boolean d;

    public ty1(@NotNull ry1 ry1, @NotNull Annotation[] annotationArr, @Nullable String str, boolean z) {
        k21.i(ry1, "type");
        k21.i(annotationArr, "reflectAnnotations");
        this.a = ry1;
        this.b = annotationArr;
        this.c = str;
        this.d = z;
    }

    @Nullable
    /* renamed from: a */
    public yx1 findAnnotation(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return by1.a(this.b, en0);
    }

    @NotNull
    /* renamed from: b */
    public List<yx1> getAnnotations() {
        return by1.b(this.b);
    }

    @NotNull
    /* renamed from: c */
    public ry1 getType() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    @Nullable
    public og1 getName() {
        String str = this.c;
        if (str == null) {
            return null;
        }
        return og1.e(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public boolean isVararg() {
        return this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ty1.class.getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }
}
