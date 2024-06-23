package tb;

import com.youku.arch.v3.data.Constants;
import kotlin.Lazy;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class x61 {
    @NotNull
    private final v31 a;
    @NotNull
    private final TypeParameterResolver b;
    @NotNull
    private final Lazy<b41> c;
    @NotNull
    private final Lazy d;
    @NotNull
    private final JavaTypeResolver e;

    public x61(@NotNull v31 v31, @NotNull TypeParameterResolver typeParameterResolver, @NotNull Lazy<b41> lazy) {
        k21.i(v31, Constants.COMPONENT);
        k21.i(typeParameterResolver, "typeParameterResolver");
        k21.i(lazy, "delegateForDefaultTypeQualifiers");
        this.a = v31;
        this.b = typeParameterResolver;
        this.c = lazy;
        this.d = lazy;
        this.e = new JavaTypeResolver(this, typeParameterResolver);
    }

    @NotNull
    public final v31 a() {
        return this.a;
    }

    @Nullable
    public final b41 b() {
        return (b41) this.d.getValue();
    }

    @NotNull
    public final Lazy<b41> c() {
        return this.c;
    }

    @NotNull
    public final ModuleDescriptor d() {
        return this.a.l();
    }

    @NotNull
    public final StorageManager e() {
        return this.a.t();
    }

    @NotNull
    public final TypeParameterResolver f() {
        return this.b;
    }

    @NotNull
    public final JavaTypeResolver g() {
        return this.e;
    }
}
