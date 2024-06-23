package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tb.dj0;
import tb.g61;
import tb.i61;
import tb.ib2;
import tb.jl1;
import tb.k21;

/* compiled from: Taobao */
public final class RawTypeImpl extends dj0 implements RawType {
    private RawTypeImpl(ib2 ib2, ib2 ib22, boolean z) {
        super(ib2, ib22);
        if (!z) {
            KotlinTypeChecker.DEFAULT.isSubtypeOf(ib2, ib22);
        }
    }

    private static final boolean p(String str, String str2) {
        return k21.d(str, StringsKt__StringsKt.u0(str2, "out ")) || k21.d(str2, jl1.MUL);
    }

    private static final List<String> q(DescriptorRenderer descriptorRenderer, g61 g61) {
        List<TypeProjection> b = g61.b();
        ArrayList arrayList = new ArrayList(n.q(b, 10));
        Iterator<T> it = b.iterator();
        while (it.hasNext()) {
            arrayList.add(descriptorRenderer.h(it.next()));
        }
        return arrayList;
    }

    private static final String r(String str, String str2) {
        if (!(StringsKt__StringsKt.P(str, '<', false, 2, null))) {
            return str;
        }
        return StringsKt__StringsKt.P0(str, '<', null, 2, null) + '<' + str2 + '>' + StringsKt__StringsKt.M0(str, '>', null, 2, null);
    }

    @Override // tb.dj0, tb.g61
    @NotNull
    public MemberScope getMemberScope() {
        ClassifierDescriptor declarationDescriptor = c().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(RawSubstitution.INSTANCE);
            k21.h(memberScope, "classDescriptor.getMemberScope(RawSubstitution)");
            return memberScope;
        }
        throw new IllegalStateException(k21.r("Incorrect classifier: ", c().getDeclarationDescriptor()).toString());
    }

    @Override // tb.dj0
    @NotNull
    public ib2 j() {
        return k();
    }

    @Override // tb.dj0
    @NotNull
    public String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        k21.i(descriptorRenderer, "renderer");
        k21.i(descriptorRendererOptions, WXBridgeManager.OPTIONS);
        String g = descriptorRenderer.g(k());
        String g2 = descriptorRenderer.g(l());
        if (descriptorRendererOptions.getDebugMode()) {
            return "raw (" + g + ".." + g2 + ')';
        } else if (l().b().isEmpty()) {
            return descriptorRenderer.d(g, g2, TypeUtilsKt.e(this));
        } else {
            List<String> q = q(descriptorRenderer, k());
            List<String> q2 = q(descriptorRenderer, l());
            String str = CollectionsKt___CollectionsKt.Z(q, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, RawTypeImpl$render$newArgs$1.INSTANCE, 30, null);
            List list = CollectionsKt___CollectionsKt.F0(q, q2);
            boolean z = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!p((String) pair.getFirst(), (String) pair.getSecond())) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                g2 = r(g2, str);
            }
            String r = r(g, str);
            if (k21.d(r, g2)) {
                return r;
            }
            return descriptorRenderer.d(r, g2, TypeUtilsKt.e(this));
        }
    }

    @NotNull
    /* renamed from: n */
    public RawTypeImpl g(boolean z) {
        return new RawTypeImpl(k().j(z), l().j(z));
    }

    @NotNull
    /* renamed from: o */
    public dj0 h(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return new RawTypeImpl((ib2) i61.g(k()), (ib2) i61.g(l()), true);
    }

    @NotNull
    /* renamed from: s */
    public RawTypeImpl i(@NotNull Annotations annotations) {
        k21.i(annotations, "newAnnotations");
        return new RawTypeImpl(k().k(annotations), l().k(annotations));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(@NotNull ib2 ib2, @NotNull ib2 ib22) {
        this(ib2, ib22, false);
        k21.i(ib2, "lowerBound");
        k21.i(ib22, "upperBound");
    }
}
