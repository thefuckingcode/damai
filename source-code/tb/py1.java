package tb;

import java.util.Collection;
import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class py1 extends jy1 implements JavaPackage {
    @NotNull
    private final en0 a;

    public py1(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        this.a = en0;
    }

    @NotNull
    /* renamed from: a */
    public List<JavaAnnotation> getAnnotations() {
        return m.g();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof py1) && k21.d(getFqName(), ((py1) obj).getFqName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public Collection<JavaClass> getClasses(@NotNull Function1<? super og1, Boolean> function1) {
        k21.i(function1, "nameFilter");
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public en0 getFqName() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public Collection<JavaPackage> getSubPackages() {
        return m.g();
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @NotNull
    public String toString() {
        return py1.class.getName() + ": " + getFqName();
    }
}
