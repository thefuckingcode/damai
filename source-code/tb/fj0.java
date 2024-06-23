package tb;

import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class fj0 extends dj0 implements TypeWithEnhancement {
    @NotNull
    private final dj0 d;
    @NotNull
    private final g61 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fj0(@NotNull dj0 dj0, @NotNull g61 g61) {
        super(dj0.k(), dj0.l());
        k21.i(dj0, "origin");
        k21.i(g61, "enhancement");
        this.d = dj0;
        this.e = g61;
    }

    @Override // tb.es2
    @NotNull
    public es2 g(boolean z) {
        return cp2.d(getOrigin().g(z), getEnhancement().f().g(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    public g61 getEnhancement() {
        return this.e;
    }

    @Override // tb.es2
    @NotNull
    public es2 i(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return cp2.d(getOrigin().i(annotations), getEnhancement());
    }

    @Override // tb.dj0
    @NotNull
    public ib2 j() {
        return getOrigin().j();
    }

    @Override // tb.dj0
    @NotNull
    public String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        k21.i(descriptorRenderer, "renderer");
        k21.i(descriptorRendererOptions, WXBridgeManager.OPTIONS);
        if (descriptorRendererOptions.getEnhancedTypes()) {
            return descriptorRenderer.g(getEnhancement());
        }
        return getOrigin().m(descriptorRenderer, descriptorRendererOptions);
    }

    @NotNull
    /* renamed from: n */
    public dj0 getOrigin() {
        return this.d;
    }

    @NotNull
    /* renamed from: o */
    public fj0 h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return new fj0((dj0) i61.g(getOrigin()), i61.g(getEnhancement()));
    }
}
