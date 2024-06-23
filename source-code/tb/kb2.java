package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class kb2 implements ModuleClassResolver {
    public n31 a;

    @NotNull
    public final n31 a() {
        n31 n31 = this.a;
        if (n31 != null) {
            return n31;
        }
        k21.A("resolver");
        throw null;
    }

    public final void b(@NotNull n31 n31) {
        k21.i(n31, "<set-?>");
        this.a = n31;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    @Nullable
    public ClassDescriptor resolveClass(@NotNull JavaClass javaClass) {
        k21.i(javaClass, "javaClass");
        return a().b(javaClass);
    }
}
