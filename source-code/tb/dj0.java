package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class dj0 extends es2 implements FlexibleTypeMarker {
    @NotNull
    private final ib2 b;
    @NotNull
    private final ib2 c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public dj0(@NotNull ib2 ib2, @NotNull ib2 ib22) {
        super(null);
        k21.i(ib2, "lowerBound");
        k21.i(ib22, "upperBound");
        this.b = ib2;
        this.c = ib22;
    }

    @Override // tb.g61
    @NotNull
    public List<TypeProjection> b() {
        return j().b();
    }

    @Override // tb.g61
    @NotNull
    public TypeConstructor c() {
        return j().c();
    }

    @Override // tb.g61
    public boolean d() {
        return j().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return j().getAnnotations();
    }

    @Override // tb.g61
    @NotNull
    public MemberScope getMemberScope() {
        return j().getMemberScope();
    }

    @NotNull
    public abstract ib2 j();

    @NotNull
    public final ib2 k() {
        return this.b;
    }

    @NotNull
    public final ib2 l() {
        return this.c;
    }

    @NotNull
    public abstract String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions);

    @NotNull
    public String toString() {
        return DescriptorRenderer.DEBUG_TEXT.g(this);
    }
}
