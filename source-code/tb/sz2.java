package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class sz2 extends g61 {
    public sz2() {
        super(null);
    }

    @Override // tb.g61
    @NotNull
    public List<TypeProjection> b() {
        return g().b();
    }

    @Override // tb.g61
    @NotNull
    public TypeConstructor c() {
        return g().c();
    }

    @Override // tb.g61
    public boolean d() {
        return g().d();
    }

    @Override // tb.g61
    @NotNull
    public final es2 f() {
        g61 g = g();
        while (g instanceof sz2) {
            g = ((sz2) g).g();
        }
        return (es2) g;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract g61 g();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return g().getAnnotations();
    }

    @Override // tb.g61
    @NotNull
    public MemberScope getMemberScope() {
        return g().getMemberScope();
    }

    public boolean h() {
        return true;
    }

    @NotNull
    public String toString() {
        return h() ? g().toString() : "<Not computed yet>";
    }
}
