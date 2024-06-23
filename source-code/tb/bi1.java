package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class bi1 {
    private static final List<TypeProjection> a(es2 es2, CaptureStatus captureStatus) {
        boolean z;
        if (es2.b().size() != es2.c().getParameters().size()) {
            return null;
        }
        List<TypeProjection> b = es2.b();
        int i = 0;
        boolean z2 = true;
        if (!(b instanceof Collection) || !b.isEmpty()) {
            Iterator<T> it = b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getProjectionKind() == Variance.INVARIANT) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return null;
        }
        List<TypeParameterDescriptor> parameters = es2.c().getParameters();
        k21.h(parameters, "type.constructor.parameters");
        List<Pair> list = CollectionsKt___CollectionsKt.F0(b, parameters);
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (Pair pair : list) {
            TypeProjection typeProjection = (TypeProjection) pair.component1();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                es2 f = (typeProjection.isStarProjection() || typeProjection.getProjectionKind() != Variance.IN_VARIANCE) ? null : typeProjection.getType().f();
                k21.h(typeParameterDescriptor, "parameter");
                typeProjection = TypeUtilsKt.a(new ai1(captureStatus, f, typeProjection, typeParameterDescriptor));
            }
            arrayList.add(typeProjection);
        }
        TypeSubstitutor c = ko2.Companion.a(es2.c(), arrayList).c();
        int size = b.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = i + 1;
                TypeProjection typeProjection2 = b.get(i);
                TypeProjection typeProjection3 = (TypeProjection) arrayList.get(i);
                if (typeProjection2.getProjectionKind() != Variance.INVARIANT) {
                    List<g61> upperBounds = es2.c().getParameters().get(i).getUpperBounds();
                    k21.h(upperBounds, "type.constructor.parameters[index].upperBounds");
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it2 = upperBounds.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(NewKotlinTypeChecker.Companion.a().d(c.n(it2.next(), Variance.INVARIANT).f()));
                    }
                    if (!typeProjection2.isStarProjection() && typeProjection2.getProjectionKind() == Variance.OUT_VARIANCE) {
                        arrayList2.add(NewKotlinTypeChecker.Companion.a().d(typeProjection2.getType().f()));
                    }
                    ((ai1) typeProjection3.getType()).c().d(arrayList2);
                }
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    @Nullable
    public static final ib2 b(@NotNull ib2 ib2, @NotNull CaptureStatus captureStatus) {
        k21.i(ib2, "type");
        k21.i(captureStatus, "status");
        List<TypeProjection> a = a(ib2, captureStatus);
        if (a == null) {
            return null;
        }
        return c(ib2, a);
    }

    private static final ib2 c(es2 es2, List<? extends TypeProjection> list) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.i(es2.getAnnotations(), es2.c(), list, es2.d(), null, 16, null);
    }
}
