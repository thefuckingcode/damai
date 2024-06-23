package kotlin.reflect.jvm.internal.impl.types;

import cn.damai.common.app.ShareperfenceConstants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bp2;
import tb.cp2;
import tb.dj0;
import tb.ed2;
import tb.ef0;
import tb.en0;
import tb.es2;
import tb.g61;
import tb.gj0;
import tb.go2;
import tb.h61;
import tb.ib2;
import tb.jl1;
import tb.ko2;
import tb.me0;
import tb.oc0;
import tb.qi0;
import tb.r01;
import tb.v80;
import tb.vo2;
import tb.xo2;
import tb.yo2;

/* compiled from: Taobao */
public class TypeSubstitutor {
    public static final TypeSubstitutor EMPTY = g(xo2.EMPTY);
    @NotNull
    private final xo2 a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Function1<en0, Boolean> {
        a() {
        }

        private static /* synthetic */ void a(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        /* renamed from: b */
        public Boolean invoke(@NotNull en0 en0) {
            if (en0 == null) {
                a(0);
            }
            return Boolean.valueOf(!en0.equals(c.a.unsafeVariance));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[VarianceConflictType.values().length];
            a = iArr;
            iArr[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;
            a[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;
            try {
                a[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    protected TypeSubstitutor(@NotNull xo2 xo2) {
        if (xo2 == null) {
            a(6);
        }
        this.a = xo2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f9  */
    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                    }
                case 10:
                case 11:
                case 12:
                    break;
            }
            if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
                switch (i) {
                    default:
                        switch (i) {
                            default:
                                switch (i) {
                                    default:
                                        switch (i) {
                                            case 38:
                                            case 39:
                                            case 40:
                                                break;
                                            default:
                                                i2 = 3;
                                                break;
                                        }
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                        i2 = 2;
                                        break;
                                }
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                                break;
                        }
                    case 10:
                    case 11:
                    case 12:
                        break;
                }
                Object[] objArr = new Object[i2];
                switch (i) {
                    case 1:
                    case 7:
                    case 10:
                    case 11:
                    case 12:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 32:
                    case 35:
                    case 38:
                    case 39:
                    case 40:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                        break;
                    case 2:
                        objArr[0] = ShareperfenceConstants.FIRST;
                        break;
                    case 3:
                        objArr[0] = "second";
                        break;
                    case 4:
                        objArr[0] = "substitutionContext";
                        break;
                    case 5:
                        objArr[0] = WPKFactory.INIT_KEY_CONTEXT;
                        break;
                    case 6:
                    default:
                        objArr[0] = "substitution";
                        break;
                    case 8:
                    case 13:
                        objArr[0] = "type";
                        break;
                    case 9:
                    case 14:
                        objArr[0] = "howThisTypeIsUsed";
                        break;
                    case 15:
                    case 16:
                    case 34:
                        objArr[0] = "typeProjection";
                        break;
                    case 17:
                    case 26:
                        objArr[0] = "originalProjection";
                        break;
                    case 24:
                        objArr[0] = "originalType";
                        break;
                    case 25:
                        objArr[0] = "substituted";
                        break;
                    case 31:
                        objArr[0] = "annotations";
                        break;
                    case 33:
                    case 36:
                        objArr[0] = "typeParameterVariance";
                        break;
                    case 37:
                        objArr[0] = "projectionKind";
                        break;
                }
                if (i == 1) {
                    objArr[1] = "replaceWithNonApproximatingSubstitution";
                } else if (i == 7) {
                    objArr[1] = "getSubstitution";
                } else if (i != 32) {
                    if (i != 35) {
                        switch (i) {
                            case 10:
                            case 11:
                            case 12:
                                objArr[1] = "safeSubstitute";
                                break;
                            default:
                                switch (i) {
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                        objArr[1] = "unsafeSubstitute";
                                        break;
                                    default:
                                        switch (i) {
                                            case 27:
                                            case 28:
                                            case 29:
                                            case 30:
                                                objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                                break;
                                            default:
                                                switch (i) {
                                                    case 38:
                                                    case 39:
                                                    case 40:
                                                        break;
                                                    default:
                                                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                                        break;
                                                }
                                        }
                                }
                        }
                    }
                    objArr[1] = "combine";
                } else {
                    objArr[1] = "filterOutUnsafeVariance";
                }
                switch (i) {
                    case 1:
                    case 7:
                    case 10:
                    case 11:
                    case 12:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 32:
                    case 35:
                    case 38:
                    case 39:
                    case 40:
                        break;
                    case 2:
                    case 3:
                        objArr[2] = "createChainedSubstitutor";
                        break;
                    case 4:
                    case 5:
                    default:
                        objArr[2] = "create";
                        break;
                    case 6:
                        objArr[2] = "<init>";
                        break;
                    case 8:
                    case 9:
                        objArr[2] = "safeSubstitute";
                        break;
                    case 13:
                    case 14:
                    case 15:
                        objArr[2] = "substitute";
                        break;
                    case 16:
                        objArr[2] = "substituteWithoutApproximation";
                        break;
                    case 17:
                        objArr[2] = "unsafeSubstitute";
                        break;
                    case 24:
                    case 25:
                    case 26:
                        objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                        break;
                    case 31:
                        objArr[2] = "filterOutUnsafeVariance";
                        break;
                    case 33:
                    case 34:
                    case 36:
                    case 37:
                        objArr[2] = "combine";
                        break;
                }
                String format = String.format(str, objArr);
                if (!(i == 1 || i == 7 || i == 32 || i == 35)) {
                    switch (i) {
                        case 10:
                        case 11:
                        case 12:
                            break;
                        default:
                            switch (i) {
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                    break;
                                default:
                                    switch (i) {
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                            break;
                                        default:
                                            switch (i) {
                                                case 38:
                                                case 39:
                                                case 40:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                    }
                            }
                    }
                }
                throw new IllegalStateException(format);
            }
            i2 = 2;
            Object[] objArr2 = new Object[i2];
            switch (i) {
            }
            if (i == 1) {
            }
            switch (i) {
            }
            String format2 = String.format(str, objArr2);
            switch (i) {
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        switch (i) {
        }
        Object[] objArr22 = new Object[i2];
        switch (i) {
        }
        if (i == 1) {
        }
        switch (i) {
        }
        String format22 = String.format(str, objArr22);
        switch (i) {
        }
        throw new IllegalStateException(format22);
    }

    private static void b(int i, TypeProjection typeProjection, xo2 xo2) {
        if (i > 100) {
            throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(typeProjection) + "; substitution: " + o(xo2));
        }
    }

    @NotNull
    public static Variance c(@NotNull Variance variance, @NotNull TypeProjection typeProjection) {
        if (variance == null) {
            a(33);
        }
        if (typeProjection == null) {
            a(34);
        }
        if (!typeProjection.isStarProjection()) {
            return d(variance, typeProjection.getProjectionKind());
        }
        Variance variance2 = Variance.OUT_VARIANCE;
        if (variance2 == null) {
            a(35);
        }
        return variance2;
    }

    @NotNull
    public static Variance d(@NotNull Variance variance, @NotNull Variance variance2) {
        if (variance == null) {
            a(36);
        }
        if (variance2 == null) {
            a(37);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                a(38);
            }
            return variance2;
        } else if (variance2 == variance3) {
            if (variance == null) {
                a(39);
            }
            return variance;
        } else if (variance == variance2) {
            if (variance2 == null) {
                a(40);
            }
            return variance2;
        } else {
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and " + "projection kind '" + variance2 + "' cannot be combined");
        }
    }

    private static VarianceConflictType e(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    @NotNull
    public static TypeSubstitutor f(@NotNull g61 g61) {
        if (g61 == null) {
            a(5);
        }
        return g(ko2.h(g61.c(), g61.b()));
    }

    @NotNull
    public static TypeSubstitutor g(@NotNull xo2 xo2) {
        if (xo2 == null) {
            a(0);
        }
        return new TypeSubstitutor(xo2);
    }

    @NotNull
    public static TypeSubstitutor h(@NotNull xo2 xo2, @NotNull xo2 xo22) {
        if (xo2 == null) {
            a(2);
        }
        if (xo22 == null) {
            a(3);
        }
        return g(v80.h(xo2, xo22));
    }

    @NotNull
    private static Annotations i(@NotNull Annotations annotations) {
        if (annotations == null) {
            a(31);
        }
        if (!annotations.hasAnnotation(c.a.unsafeVariance)) {
            return annotations;
        }
        return new qi0(annotations, new a());
    }

    @NotNull
    private static TypeProjection l(@NotNull g61 g61, @NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeProjection typeProjection2) {
        if (g61 == null) {
            a(24);
        }
        if (typeProjection == null) {
            a(25);
        }
        if (typeProjection2 == null) {
            a(26);
        }
        if (!g61.getAnnotations().hasAnnotation(c.a.unsafeVariance)) {
            if (typeProjection == null) {
                a(27);
            }
            return typeProjection;
        }
        TypeConstructor c = typeProjection.getType().c();
        if (!(c instanceof NewCapturedTypeConstructor)) {
            return typeProjection;
        }
        TypeProjection projection = ((NewCapturedTypeConstructor) c).getProjection();
        Variance projectionKind = projection.getProjectionKind();
        VarianceConflictType e = e(typeProjection2.getProjectionKind(), projectionKind);
        VarianceConflictType varianceConflictType = VarianceConflictType.OUT_IN_IN_POSITION;
        if (e == varianceConflictType) {
            return new vo2(projection.getType());
        }
        return (typeParameterDescriptor != null && e(typeParameterDescriptor.getVariance(), projectionKind) == varianceConflictType) ? new vo2(projection.getType()) : typeProjection;
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!ef0.a(th)) {
                return "[Exception while computing toString(): " + th + jl1.ARRAY_END_STR;
            }
            throw th;
        }
    }

    private TypeProjection r(TypeProjection typeProjection, int i) throws SubstitutionException {
        g61 type = typeProjection.getType();
        Variance projectionKind = typeProjection.getProjectionKind();
        if (type.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        g61 g61 = null;
        ib2 b2 = ed2.b(type);
        if (b2 != null) {
            g61 = m().q(b2, Variance.INVARIANT);
        }
        g61 b3 = yo2.b(type, s(type.c().getParameters(), type.b(), i), this.a.d(type.getAnnotations()));
        if ((b3 instanceof ib2) && (g61 instanceof ib2)) {
            b3 = ed2.j((ib2) b3, (ib2) g61);
        }
        return new vo2(projectionKind, b3);
    }

    private List<TypeProjection> s(List<TypeParameterDescriptor> list, List<TypeProjection> list2, int i) throws SubstitutionException {
        Variance variance;
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i2);
            TypeProjection typeProjection = list2.get(i2);
            TypeProjection u = u(typeProjection, typeParameterDescriptor, i + 1);
            int i3 = b.a[e(typeParameterDescriptor.getVariance(), u.getProjectionKind()).ordinal()];
            if (i3 == 1 || i3 == 2) {
                u = bp2.s(typeParameterDescriptor);
            } else if (i3 == 3 && typeParameterDescriptor.getVariance() != (variance = Variance.INVARIANT) && !u.isStarProjection()) {
                u = new vo2(variance, u.getType());
            }
            if (u != typeProjection) {
                z = true;
            }
            arrayList.add(u);
        }
        return !z ? list2 : arrayList;
    }

    @NotNull
    private TypeProjection u(@NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, int i) throws SubstitutionException {
        g61 g61;
        if (typeProjection == null) {
            a(17);
        }
        b(i, typeProjection, this.a);
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        g61 type = typeProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
            es2 origin = typeWithEnhancement.getOrigin();
            g61 enhancement = typeWithEnhancement.getEnhancement();
            TypeProjection u = u(new vo2(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i + 1);
            return new vo2(u.getProjectionKind(), cp2.d(u.getType().f(), q(enhancement, typeProjection.getProjectionKind())));
        }
        if (!oc0.a(type) && !(type.f() instanceof RawType)) {
            TypeProjection e = this.a.e(type);
            TypeProjection l = e != null ? l(type, e, typeParameterDescriptor, typeProjection) : null;
            Variance projectionKind = typeProjection.getProjectionKind();
            if (l == null && gj0.b(type) && !go2.b(type)) {
                dj0 a2 = gj0.a(type);
                int i2 = i + 1;
                TypeProjection u2 = u(new vo2(projectionKind, a2.k()), typeParameterDescriptor, i2);
                TypeProjection u3 = u(new vo2(projectionKind, a2.l()), typeParameterDescriptor, i2);
                Variance projectionKind2 = u2.getProjectionKind();
                if (u2.getType() == a2.k() && u3.getType() == a2.l()) {
                    return typeProjection;
                }
                return new vo2(projectionKind2, KotlinTypeFactory.d(yo2.a(u2.getType()), yo2.a(u3.getType())));
            } else if (!kotlin.reflect.jvm.internal.impl.builtins.b.t0(type) && !h61.a(type)) {
                if (l != null) {
                    VarianceConflictType e2 = e(projectionKind, l.getProjectionKind());
                    if (!CapturedTypeConstructorKt.d(type)) {
                        int i3 = b.a[e2.ordinal()];
                        if (i3 == 1) {
                            throw new SubstitutionException("Out-projection in in-position");
                        } else if (i3 == 2) {
                            return new vo2(Variance.OUT_VARIANCE, type.c().getBuiltIns().I());
                        }
                    }
                    CustomTypeVariable a3 = go2.a(type);
                    if (l.isStarProjection()) {
                        return l;
                    }
                    if (a3 != null) {
                        g61 = a3.substitutionResult(l.getType());
                    } else {
                        g61 = bp2.q(l.getType(), type.d());
                    }
                    if (!type.getAnnotations().isEmpty()) {
                        g61 = TypeUtilsKt.l(g61, new CompositeAnnotations(g61.getAnnotations(), i(this.a.d(type.getAnnotations()))));
                    }
                    if (e2 == VarianceConflictType.NO_CONFLICT) {
                        projectionKind = d(projectionKind, l.getProjectionKind());
                    }
                    return new vo2(projectionKind, g61);
                }
                typeProjection = r(typeProjection, i);
                if (typeProjection == null) {
                    a(23);
                }
            }
        }
        return typeProjection;
    }

    @NotNull
    public xo2 j() {
        xo2 xo2 = this.a;
        if (xo2 == null) {
            a(7);
        }
        return xo2;
    }

    public boolean k() {
        return this.a.f();
    }

    @NotNull
    public TypeSubstitutor m() {
        xo2 xo2 = this.a;
        return (!(xo2 instanceof r01) || !xo2.b()) ? this : new TypeSubstitutor(new r01(((r01) this.a).i(), ((r01) this.a).h(), false));
    }

    @NotNull
    public g61 n(@NotNull g61 g61, @NotNull Variance variance) {
        if (g61 == null) {
            a(8);
        }
        if (variance == null) {
            a(9);
        }
        if (k()) {
            if (g61 == null) {
                a(10);
            }
            return g61;
        }
        try {
            g61 type = u(new vo2(variance, g61), null, 0).getType();
            if (type == null) {
                a(11);
            }
            return type;
        } catch (SubstitutionException e) {
            ib2 j = me0.j(e.getMessage());
            if (j == null) {
                a(12);
            }
            return j;
        }
    }

    @Nullable
    public TypeProjection p(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            a(15);
        }
        TypeProjection t = t(typeProjection);
        if (this.a.a() || this.a.b()) {
            return CapturedTypeApproximationKt.c(t, this.a.b());
        }
        return t;
    }

    @Nullable
    public g61 q(@NotNull g61 g61, @NotNull Variance variance) {
        if (g61 == null) {
            a(13);
        }
        if (variance == null) {
            a(14);
        }
        TypeProjection p = p(new vo2(variance, j().g(g61, variance)));
        if (p == null) {
            return null;
        }
        return p.getType();
    }

    @Nullable
    public TypeProjection t(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            a(16);
        }
        if (k()) {
            return typeProjection;
        }
        try {
            return u(typeProjection, null, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }
}
