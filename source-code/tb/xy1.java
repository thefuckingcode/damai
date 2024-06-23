package tb;

import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class xy1 implements KotlinClassFinder {
    @NotNull
    private final ClassLoader a;
    @NotNull
    private final md b = new md();

    public xy1(@NotNull ClassLoader classLoader) {
        k21.i(classLoader, "classLoader");
        this.a = classLoader;
    }

    private final KotlinClassFinder.a a(String str) {
        wy1 a2;
        Class<?> a3 = fy1.a(this.a, str);
        if (a3 == null || (a2 = wy1.Factory.a(a3)) == null) {
            return null;
        }
        return new KotlinClassFinder.a.b(a2, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    @Nullable
    public InputStream findBuiltInsData(@NotNull en0 en0) {
        k21.i(en0, "packageFqName");
        if (!en0.i(c.BUILT_INS_PACKAGE_NAME)) {
            return null;
        }
        return this.b.a(id.INSTANCE.n(en0));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    @Nullable
    public KotlinClassFinder.a findKotlinClassOrContent(@NotNull oi oiVar) {
        k21.i(oiVar, "classId");
        return a(yy1.a(oiVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    @Nullable
    public KotlinClassFinder.a findKotlinClassOrContent(@NotNull JavaClass javaClass) {
        k21.i(javaClass, "javaClass");
        en0 fqName = javaClass.getFqName();
        String b2 = fqName == null ? null : fqName.b();
        if (b2 == null) {
            return null;
        }
        return a(b2);
    }
}
