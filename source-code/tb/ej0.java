package tb;

import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ej0 extends dj0 implements CustomTypeVariable {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    public static boolean e;
    private boolean d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ej0(@NotNull ib2 ib2, @NotNull ib2 ib22) {
        super(ib2, ib22);
        k21.i(ib2, "lowerBound");
        k21.i(ib22, "upperBound");
    }

    private final void o() {
        if (e && !this.d) {
            this.d = true;
            gj0.b(k());
            gj0.b(l());
            k21.d(k(), l());
            KotlinTypeChecker.DEFAULT.isSubtypeOf(k(), l());
        }
    }

    @Override // tb.es2
    @NotNull
    public es2 g(boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.d(k().j(z), l().j(z));
    }

    @Override // tb.es2
    @NotNull
    public es2 i(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.d(k().k(annotations), l().k(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        return (k().c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) && k21.d(k().c(), l().c());
    }

    @Override // tb.dj0
    @NotNull
    public ib2 j() {
        o();
        return k();
    }

    @Override // tb.dj0
    @NotNull
    public String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        k21.i(descriptorRenderer, "renderer");
        k21.i(descriptorRendererOptions, WXBridgeManager.OPTIONS);
        if (!descriptorRendererOptions.getDebugMode()) {
            return descriptorRenderer.d(descriptorRenderer.g(k()), descriptorRenderer.g(l()), TypeUtilsKt.e(this));
        }
        return '(' + descriptorRenderer.g(k()) + ".." + descriptorRenderer.g(l()) + ')';
    }

    @NotNull
    /* renamed from: n */
    public dj0 h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return new ej0((ib2) i61.g(k()), (ib2) i61.g(l()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    @NotNull
    public g61 substitutionResult(@NotNull g61 g61) {
        es2 es2;
        k21.i(g61, "replacement");
        es2 f = g61.f();
        if (f instanceof dj0) {
            es2 = f;
        } else if (f instanceof ib2) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            ib2 ib2 = (ib2) f;
            es2 = KotlinTypeFactory.d(ib2, ib2.j(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return cp2.b(es2, f);
    }
}
