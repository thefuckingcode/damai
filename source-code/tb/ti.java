package tb;

import io.flutter.wpkbridge.WPKFactory;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i61;

/* compiled from: Taobao */
public class ti extends AbstractTypeCheckerContext implements ClassicTypeSystemContext {
    @NotNull
    public static final a Companion = new a(null);
    private final boolean e;
    private final boolean f;
    private final boolean g;
    @NotNull
    private final i61 h;

    /* compiled from: Taobao */
    public static final class a {

        /* renamed from: tb.ti$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0309a extends AbstractTypeCheckerContext.a.AbstractC0286a {
            final /* synthetic */ ClassicTypeSystemContext a;
            final /* synthetic */ TypeSubstitutor b;

            C0309a(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutor typeSubstitutor) {
                this.a = classicTypeSystemContext;
                this.b = typeSubstitutor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            @NotNull
            public SimpleTypeMarker a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
                k21.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
                k21.i(kotlinTypeMarker, "type");
                ClassicTypeSystemContext classicTypeSystemContext = this.a;
                g61 n = this.b.n((g61) classicTypeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker), Variance.INVARIANT);
                k21.h(n, "substitutor.safeSubstitute(\n                        type.lowerBoundIfFlexible() as KotlinType,\n                        Variance.INVARIANT\n                    )");
                SimpleTypeMarker asSimpleType = classicTypeSystemContext.asSimpleType(n);
                k21.f(asSimpleType);
                return asSimpleType;
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final AbstractTypeCheckerContext.a.AbstractC0286a a(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "<this>");
            k21.i(simpleTypeMarker, "type");
            if (simpleTypeMarker instanceof ib2) {
                return new C0309a(classicTypeSystemContext, ko2.Companion.b((g61) simpleTypeMarker).c());
            }
            throw new IllegalArgumentException(ui.a(simpleTypeMarker).toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ti(boolean z, boolean z2, boolean z3, i61 i61, int i, m40 m40) {
        this(z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? i61.a.INSTANCE : i61);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2) {
        k21.i(typeConstructorMarker, "c1");
        k21.i(typeConstructorMarker2, "c2");
        if (!(typeConstructorMarker instanceof TypeConstructor)) {
            throw new IllegalArgumentException(ui.a(typeConstructorMarker).toString());
        } else if (typeConstructorMarker2 instanceof TypeConstructor) {
            return y((TypeConstructor) typeConstructorMarker, (TypeConstructor) typeConstructorMarker2);
        } else {
            throw new IllegalArgumentException(ui.a(typeConstructorMarker2).toString());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int argumentsCount(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.b(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.c(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    public CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.d(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.e(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    public DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.a.f(this, flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    public FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.g(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    public SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.h(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.i(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    public SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus) {
        return ClassicTypeSystemContext.a.j(this, simpleTypeMarker, captureStatus);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    @NotNull
    public KotlinTypeMarker createFlexibleType(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        return ClassicTypeSystemContext.a.k(this, simpleTypeMarker, simpleTypeMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker kotlinTypeMarker, int i) {
        return ClassicTypeSystemContext.a.m(this, kotlinTypeMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    @NotNull
    public fn0 getClassFqNameUnsafe(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.n(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeParameterMarker getParameter(@NotNull TypeConstructorMarker typeConstructorMarker, int i) {
        return ClassicTypeSystemContext.a.o(this, typeConstructorMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    @Nullable
    public PrimitiveType getPrimitiveArrayType(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.p(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    @Nullable
    public PrimitiveType getPrimitiveType(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.q(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    @NotNull
    public KotlinTypeMarker getRepresentativeUpperBound(@NotNull TypeParameterMarker typeParameterMarker) {
        return ClassicTypeSystemContext.a.r(this, typeParameterMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    @Nullable
    public KotlinTypeMarker getSubstitutedUnderlyingType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.s(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public KotlinTypeMarker getType(@NotNull TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.a.t(this, typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    @Nullable
    public TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.u(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeVariance getVariance(@NotNull TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.a.v(this, typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean hasAnnotation(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull en0 en0) {
        return ClassicTypeSystemContext.a.x(this, kotlinTypeMarker, en0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public boolean identicalArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        return ClassicTypeSystemContext.a.y(this, simpleTypeMarker, simpleTypeMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> list) {
        return ClassicTypeSystemContext.a.z(this, list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isAnyConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.A(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.B(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.C(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDenotable(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.D(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isError(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.E(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isInlineClass(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.F(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.G(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntersection(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.H(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.J(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothingConstructor(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.K(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNullableType(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.L(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isPrimitiveType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.M(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isProjectionNotNull(@NotNull CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.a.N(this, capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.O(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStarProjection(@NotNull TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.a.P(this, typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubType(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.Q(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.R(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.a.S(this, flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    public KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.a.U(this, capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.V(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    @NotNull
    public KotlinTypeMarker makeNullable(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.a.W(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean n(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        k21.i(kotlinTypeMarker, "<this>");
        return (kotlinTypeMarker instanceof es2) && this.g && (((es2) kotlinTypeMarker).c() instanceof NewTypeVariableConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public SimpleTypeMarker original(@NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
        return ClassicTypeSystemContext.a.Y(this, definitelyNotNullTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int parametersCount(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.Z(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.a0(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean r() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.a.c0(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.a.e0(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    public boolean u() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.a.f0(this, flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @NotNull
    public KotlinTypeMarker v(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        k21.i(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof g61) {
            return NewKotlinTypeChecker.Companion.a().d(((g61) kotlinTypeMarker).f());
        }
        throw new IllegalArgumentException(ui.a(kotlinTypeMarker).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
    @NotNull
    public KotlinTypeMarker w(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        k21.i(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof g61) {
            return this.h.g((g61) kotlinTypeMarker);
        }
        throw new IllegalArgumentException(ui.a(kotlinTypeMarker).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public KotlinTypeMarker withNullability(@NotNull KotlinTypeMarker kotlinTypeMarker, boolean z) {
        return ClassicTypeSystemContext.a.h0(this, kotlinTypeMarker, z);
    }

    public boolean y(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
        k21.i(typeConstructor, "a");
        k21.i(typeConstructor2, "b");
        if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor).e(typeConstructor2);
        }
        if (typeConstructor2 instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor2).e(typeConstructor);
        }
        return k21.d(typeConstructor, typeConstructor2);
    }

    @NotNull
    /* renamed from: z */
    public AbstractTypeCheckerContext.a.AbstractC0286a x(@NotNull SimpleTypeMarker simpleTypeMarker) {
        k21.i(simpleTypeMarker, "type");
        return Companion.a(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public TypeVariance getVariance(@NotNull TypeParameterMarker typeParameterMarker) {
        return ClassicTypeSystemContext.a.w(this, typeParameterMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    public SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z) {
        return ClassicTypeSystemContext.a.i0(this, simpleTypeMarker, z);
    }

    public ti(boolean z, boolean z2, boolean z3, @NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = i61;
    }
}
