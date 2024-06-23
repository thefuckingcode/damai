package tb;

import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class nc0 extends dj0 implements DynamicTypeMarker {
    @NotNull
    private final Annotations d;

    /* JADX WARNING: Illegal instructions before constructor call */
    public nc0(@NotNull b bVar, @NotNull Annotations annotations) {
        super(r0, r3);
        k21.i(bVar, "builtIns");
        k21.i(annotations, "annotations");
        ib2 H = bVar.H();
        k21.h(H, "builtIns.nothingType");
        ib2 I = bVar.I();
        k21.h(I, "builtIns.nullableAnyType");
        this.d = annotations;
    }

    @Override // tb.dj0, tb.g61
    public boolean d() {
        return false;
    }

    @Override // tb.dj0, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.d;
    }

    @Override // tb.dj0
    @NotNull
    public ib2 j() {
        return l();
    }

    @Override // tb.dj0
    @NotNull
    public String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        k21.i(descriptorRenderer, "renderer");
        k21.i(descriptorRendererOptions, WXBridgeManager.OPTIONS);
        return js2.DYNAMIC;
    }

    @NotNull
    /* renamed from: n */
    public nc0 g(boolean z) {
        return this;
    }

    @NotNull
    /* renamed from: o */
    public nc0 h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    /* renamed from: p */
    public nc0 i(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return new nc0(TypeUtilsKt.e(j()), annotations);
    }
}
