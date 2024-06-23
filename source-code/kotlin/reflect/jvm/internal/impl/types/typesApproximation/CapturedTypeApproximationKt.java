package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bp2;
import tb.cp2;
import tb.e7;
import tb.g61;
import tb.gj0;
import tb.ib2;
import tb.k21;
import tb.ko2;
import tb.vo2;
import tb.yo2;

/* compiled from: Taobao */
public final class CapturedTypeApproximationKt {

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends ko2 {
        b() {
        }

        @Override // tb.ko2
        @Nullable
        public TypeProjection j(@NotNull TypeConstructor typeConstructor) {
            k21.i(typeConstructor, "key");
            CapturedTypeConstructor capturedTypeConstructor = typeConstructor instanceof CapturedTypeConstructor ? (CapturedTypeConstructor) typeConstructor : null;
            if (capturedTypeConstructor == null) {
                return null;
            }
            if (capturedTypeConstructor.getProjection().isStarProjection()) {
                return new vo2(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
            }
            return capturedTypeConstructor.getProjection();
        }
    }

    @NotNull
    public static final e7<g61> a(@NotNull g61 g61) {
        Object obj;
        k21.i(g61, "type");
        if (gj0.b(g61)) {
            e7<g61> a2 = a(gj0.c(g61));
            e7<g61> a3 = a(gj0.d(g61));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return new e7<>(cp2.b(KotlinTypeFactory.d(gj0.c(a2.c()), gj0.d(a3.c())), g61), cp2.b(KotlinTypeFactory.d(gj0.c(a2.d()), gj0.d(a3.d())), g61));
        }
        TypeConstructor c = g61.c();
        if (CapturedTypeConstructorKt.d(g61)) {
            TypeProjection projection = ((CapturedTypeConstructor) c).getProjection();
            g61 type = projection.getType();
            k21.h(type, "typeProjection.type");
            g61 b2 = b(type, g61);
            int i = a.$EnumSwitchMapping$0[projection.getProjectionKind().ordinal()];
            if (i == 2) {
                ib2 I = TypeUtilsKt.e(g61).I();
                k21.h(I, "type.builtIns.nullableAnyType");
                return new e7<>(b2, I);
            } else if (i == 3) {
                ib2 H = TypeUtilsKt.e(g61).H();
                k21.h(H, "type.builtIns.nothingType");
                return new e7<>(b(H, g61), b2);
            } else {
                throw new AssertionError(k21.r("Only nontrivial projections should have been captured, not: ", projection));
            }
        } else if (g61.b().isEmpty() || g61.b().size() != c.getParameters().size()) {
            return new e7<>(g61, g61);
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<TypeProjection> b3 = g61.b();
            List<TypeParameterDescriptor> parameters = c.getParameters();
            k21.h(parameters, "typeConstructor.parameters");
            for (Pair pair : CollectionsKt___CollectionsKt.F0(b3, parameters)) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
                k21.h(typeParameterDescriptor, "typeParameter");
                a g = g(typeProjection, typeParameterDescriptor);
                if (typeProjection.isStarProjection()) {
                    arrayList.add(g);
                    arrayList2.add(g);
                } else {
                    e7<a> d = d(g);
                    arrayList.add(d.a());
                    arrayList2.add(d.b());
                }
            }
            boolean z = true;
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((a) it.next()).d()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                obj = TypeUtilsKt.e(g61).H();
                k21.h(obj, "type.builtIns.nothingType");
            } else {
                obj = e(g61, arrayList);
            }
            return new e7<>(obj, e(g61, arrayList2));
        }
    }

    private static final g61 b(g61 g61, g61 g612) {
        g61 q = bp2.q(g61, g612.d());
        k21.h(q, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return q;
    }

    @Nullable
    public static final TypeProjection c(@Nullable TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        g61 type = typeProjection.getType();
        k21.h(type, "typeProjection.type");
        if (!bp2.c(type, CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1.INSTANCE)) {
            return typeProjection;
        }
        Variance projectionKind = typeProjection.getProjectionKind();
        k21.h(projectionKind, "typeProjection.projectionKind");
        if (projectionKind == Variance.OUT_VARIANCE) {
            return new vo2(projectionKind, a(type).d());
        }
        if (z) {
            return new vo2(projectionKind, a(type).c());
        }
        return f(typeProjection);
    }

    private static final e7<a> d(a aVar) {
        e7<g61> a2 = a(aVar.a());
        e7<g61> a3 = a(aVar.b());
        return new e7<>(new a(aVar.c(), a2.b(), a3.a()), new a(aVar.c(), a2.a(), a3.b()));
    }

    private static final g61 e(g61 g61, List<a> list) {
        g61.b().size();
        list.size();
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(h(it.next()));
        }
        return yo2.e(g61, arrayList, null, null, 6, null);
    }

    private static final TypeProjection f(TypeProjection typeProjection) {
        TypeSubstitutor g = TypeSubstitutor.g(new b());
        k21.h(g, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
        return g.t(typeProjection);
    }

    private static final a g(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        int i = a.$EnumSwitchMapping$0[TypeSubstitutor.c(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i == 1) {
            g61 type = typeProjection.getType();
            k21.h(type, "type");
            g61 type2 = typeProjection.getType();
            k21.h(type2, "type");
            return new a(typeParameterDescriptor, type, type2);
        } else if (i == 2) {
            g61 type3 = typeProjection.getType();
            k21.h(type3, "type");
            ib2 I = DescriptorUtilsKt.g(typeParameterDescriptor).I();
            k21.h(I, "typeParameter.builtIns.nullableAnyType");
            return new a(typeParameterDescriptor, type3, I);
        } else if (i == 3) {
            ib2 H = DescriptorUtilsKt.g(typeParameterDescriptor).H();
            k21.h(H, "typeParameter.builtIns.nothingType");
            g61 type4 = typeProjection.getType();
            k21.h(type4, "type");
            return new a(typeParameterDescriptor, H, type4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final TypeProjection h(a aVar) {
        Variance variance;
        aVar.d();
        if (k21.d(aVar.a(), aVar.b()) || aVar.c().getVariance() == (variance = Variance.IN_VARIANCE)) {
            return new vo2(aVar.a());
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.b.t0(aVar.a()) && aVar.c().getVariance() != variance) {
            return new vo2(i(aVar, Variance.OUT_VARIANCE), aVar.b());
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.b.v0(aVar.b())) {
            return new vo2(i(aVar, variance), aVar.a());
        }
        return new vo2(i(aVar, Variance.OUT_VARIANCE), aVar.b());
    }

    private static final Variance i(a aVar, Variance variance) {
        return variance == aVar.c().getVariance() ? Variance.INVARIANT : variance;
    }
}
