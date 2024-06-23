package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class g61 implements Annotated, KotlinTypeMarker {
    private int a;

    private g61() {
    }

    public /* synthetic */ g61(m40 m40) {
        this();
    }

    private final int a() {
        if (h61.a(this)) {
            return super.hashCode();
        }
        return (((c().hashCode() * 31) + b().hashCode()) * 31) + (d() ? 1 : 0);
    }

    @NotNull
    public abstract List<TypeProjection> b();

    @NotNull
    public abstract TypeConstructor c();

    public abstract boolean d();

    @NotNull
    public abstract g61 e(@NotNull i61 i61);

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g61)) {
            return false;
        }
        g61 g61 = (g61) obj;
        if (d() != g61.d() || !af2.INSTANCE.a(f(), g61.f())) {
            return false;
        }
        return true;
    }

    @NotNull
    public abstract es2 f();

    @NotNull
    public abstract MemberScope getMemberScope();

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int a2 = a();
        this.a = a2;
        return a2;
    }
}
