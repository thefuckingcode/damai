package tb;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ey1 implements JavaClassFinder {
    @NotNull
    private final ClassLoader a;

    public ey1(@NotNull ClassLoader classLoader) {
        k21.i(classLoader, "classLoader");
        this.a = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    @Nullable
    public JavaClass findClass(@NotNull JavaClassFinder.a aVar) {
        k21.i(aVar, "request");
        oi a2 = aVar.a();
        en0 h = a2.h();
        k21.h(h, "classId.packageFqName");
        String b = a2.i().b();
        k21.h(b, "classId.relativeClassName.asString()");
        String str = o.E(b, '.', '$', false, 4, null);
        if (!h.d()) {
            str = h.b() + '.' + str;
        }
        Class<?> a3 = fy1.a(this.a, str);
        if (a3 != null) {
            return new ReflectJavaClass(a3);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    @Nullable
    public JavaPackage findPackage(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return new py1(en0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    @Nullable
    public Set<String> knownClassNamesInPackage(@NotNull en0 en0) {
        k21.i(en0, "packageFqName");
        return null;
    }
}
