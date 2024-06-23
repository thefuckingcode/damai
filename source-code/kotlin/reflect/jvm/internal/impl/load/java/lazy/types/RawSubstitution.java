package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import tb.do2;
import tb.g61;
import tb.gj0;
import tb.h61;
import tb.ib2;
import tb.jl1;
import tb.k21;
import tb.me0;
import tb.vo2;
import tb.xo2;
import tb.y31;

/* compiled from: Taobao */
public final class RawSubstitution extends xo2 {
    @NotNull
    public static final RawSubstitution INSTANCE = new RawSubstitution();
    @NotNull
    private static final y31 a;
    @NotNull
    private static final y31 b;

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        a = JavaTypeResolverKt.f(typeUsage, false, null, 3, null).g(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        b = JavaTypeResolverKt.f(typeUsage, false, null, 3, null).g(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    private RawSubstitution() {
    }

    public static /* synthetic */ TypeProjection j(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, y31 y31, g61 g61, int i, Object obj) {
        if ((i & 4) != 0) {
            g61 = JavaTypeResolverKt.c(typeParameterDescriptor, null, null, 3, null);
        }
        return rawSubstitution.i(typeParameterDescriptor, y31, g61);
    }

    /* access modifiers changed from: private */
    public final Pair<ib2, Boolean> k(ib2 ib2, ClassDescriptor classDescriptor, y31 y31) {
        if (ib2.c().getParameters().isEmpty()) {
            return do2.a(ib2, Boolean.FALSE);
        }
        if (b.b0(ib2)) {
            TypeProjection typeProjection = ib2.b().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            g61 type = typeProjection.getType();
            k21.h(type, "componentTypeProjection.type");
            List list = l.e(new vo2(projectionKind, l(type)));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return do2.a(KotlinTypeFactory.i(ib2.getAnnotations(), ib2.c(), list, ib2.d(), null, 16, null), Boolean.FALSE);
        } else if (h61.a(ib2)) {
            ib2 j = me0.j(k21.r("Raw error type: ", ib2.c()));
            k21.h(j, "createErrorType(\"Raw error type: ${type.constructor}\")");
            return do2.a(j, Boolean.FALSE);
        } else {
            MemberScope memberScope = classDescriptor.getMemberScope(this);
            k21.h(memberScope, "declaration.getMemberScope(RawSubstitution)");
            KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.INSTANCE;
            Annotations annotations = ib2.getAnnotations();
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            k21.h(typeConstructor, "declaration.typeConstructor");
            List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
            k21.h(parameters, "declaration.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(n.q(parameters, 10));
            for (T t : parameters) {
                k21.h(t, "parameter");
                arrayList.add(j(this, t, y31, null, 4, null));
            }
            return do2.a(KotlinTypeFactory.k(annotations, typeConstructor, arrayList, ib2.d(), memberScope, new RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(classDescriptor, this, ib2, y31)), Boolean.TRUE);
        }
    }

    private final g61 l(g61 g61) {
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return l(JavaTypeResolverKt.c((TypeParameterDescriptor) declarationDescriptor, null, null, 3, null));
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassifierDescriptor declarationDescriptor2 = gj0.d(g61).c().getDeclarationDescriptor();
            if (declarationDescriptor2 instanceof ClassDescriptor) {
                Pair<ib2, Boolean> k = k(gj0.c(g61), (ClassDescriptor) declarationDescriptor, a);
                ib2 component1 = k.component1();
                boolean booleanValue = k.component2().booleanValue();
                Pair<ib2, Boolean> k2 = k(gj0.d(g61), (ClassDescriptor) declarationDescriptor2, b);
                ib2 component12 = k2.component1();
                boolean booleanValue2 = k2.component2().booleanValue();
                if (booleanValue || booleanValue2) {
                    return new RawTypeImpl(component1, component12);
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                return KotlinTypeFactory.d(component1, component12);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + jl1.QUOTE).toString());
        }
        throw new IllegalStateException(k21.r("Unexpected declaration kind: ", declarationDescriptor).toString());
    }

    @Override // tb.xo2
    public boolean f() {
        return false;
    }

    @NotNull
    public final TypeProjection i(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull y31 y31, @NotNull g61 g61) {
        k21.i(typeParameterDescriptor, "parameter");
        k21.i(y31, RichTextNode.ATTR);
        k21.i(g61, "erasedUpperBound");
        int i = a.$EnumSwitchMapping$0[y31.c().ordinal()];
        if (i == 1) {
            return new vo2(Variance.INVARIANT, g61);
        }
        if (i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        } else if (!typeParameterDescriptor.getVariance().getAllowsOutPosition()) {
            return new vo2(Variance.INVARIANT, DescriptorUtilsKt.g(typeParameterDescriptor).H());
        } else {
            List<TypeParameterDescriptor> parameters = g61.c().getParameters();
            k21.h(parameters, "erasedUpperBound.constructor.parameters");
            if (!parameters.isEmpty()) {
                return new vo2(Variance.OUT_VARIANCE, g61);
            }
            return JavaTypeResolverKt.d(typeParameterDescriptor, y31);
        }
    }

    @NotNull
    /* renamed from: m */
    public vo2 e(@NotNull g61 g61) {
        k21.i(g61, "key");
        return new vo2(l(g61));
    }
}
