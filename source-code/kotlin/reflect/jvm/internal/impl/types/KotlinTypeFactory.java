package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ej0;
import tb.eo2;
import tb.es2;
import tb.fo2;
import tb.i61;
import tb.ib2;
import tb.k21;
import tb.ko2;
import tb.me0;
import tb.ye1;

/* compiled from: Taobao */
public final class KotlinTypeFactory {
    @NotNull
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        private final ib2 a;
        @Nullable
        private final TypeConstructor b;

        public a(@Nullable ib2 ib2, @Nullable TypeConstructor typeConstructor) {
            this.a = ib2;
            this.b = typeConstructor;
        }

        @Nullable
        public final ib2 a() {
            return this.a;
        }

        @Nullable
        public final TypeConstructor b() {
            return this.b;
        }
    }

    static {
        KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1 kotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1 = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;
    }

    private KotlinTypeFactory() {
    }

    @JvmStatic
    @NotNull
    public static final ib2 b(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> list) {
        k21.i(typeAliasDescriptor, "<this>");
        k21.i(list, "arguments");
        return new eo2(TypeAliasExpansionReportStrategy.a.INSTANCE, false).i(fo2.Companion.a(null, typeAliasDescriptor, list), Annotations.Companion.b());
    }

    private final MemberScope c(TypeConstructor typeConstructor, List<? extends TypeProjection> list, i61 i61) {
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return declarationDescriptor.getDefaultType().getMemberScope();
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            if (i61 == null) {
                i61 = DescriptorUtilsKt.k(DescriptorUtilsKt.l(declarationDescriptor));
            }
            if (list.isEmpty()) {
                return ye1.b((ClassDescriptor) declarationDescriptor, i61);
            }
            return ye1.a((ClassDescriptor) declarationDescriptor, ko2.Companion.a(typeConstructor, list), i61);
        } else if (declarationDescriptor instanceof TypeAliasDescriptor) {
            MemberScope i = me0.i(k21.r("Scope for abbreviation: ", ((TypeAliasDescriptor) declarationDescriptor).getName()), true);
            k21.h(i, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
            return i;
        } else if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).a();
        } else {
            throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor + " for constructor: " + typeConstructor);
        }
    }

    @JvmStatic
    @NotNull
    public static final es2 d(@NotNull ib2 ib2, @NotNull ib2 ib22) {
        k21.i(ib2, "lowerBound");
        k21.i(ib22, "upperBound");
        if (k21.d(ib2, ib22)) {
            return ib2;
        }
        return new ej0(ib2, ib22);
    }

    @JvmStatic
    @NotNull
    public static final ib2 e(@NotNull Annotations annotations, @NotNull IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z) {
        k21.i(annotations, "annotations");
        k21.i(integerLiteralTypeConstructor, "constructor");
        List list = m.g();
        MemberScope i = me0.i("Scope for integer literal type", true);
        k21.h(i, "createErrorScope(\"Scope for integer literal type\", true)");
        return j(annotations, integerLiteralTypeConstructor, list, z, i);
    }

    /* access modifiers changed from: private */
    public final a f(TypeConstructor typeConstructor, i61 i61, List<? extends TypeProjection> list) {
        ClassifierDescriptor classifierDescriptor;
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            classifierDescriptor = null;
        } else {
            classifierDescriptor = i61.e(declarationDescriptor);
        }
        if (classifierDescriptor == null) {
            return null;
        }
        if (classifierDescriptor instanceof TypeAliasDescriptor) {
            return new a(b((TypeAliasDescriptor) classifierDescriptor, list), null);
        }
        TypeConstructor refine = classifierDescriptor.getTypeConstructor().refine(i61);
        k21.h(refine, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
        return new a(null, refine);
    }

    @JvmStatic
    @NotNull
    public static final ib2 g(@NotNull Annotations annotations, @NotNull ClassDescriptor classDescriptor, @NotNull List<? extends TypeProjection> list) {
        k21.i(annotations, "annotations");
        k21.i(classDescriptor, "descriptor");
        k21.i(list, "arguments");
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        k21.h(typeConstructor, "descriptor.typeConstructor");
        return i(annotations, typeConstructor, list, false, null, 16, null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final ib2 h(@NotNull Annotations annotations, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @Nullable i61 i61) {
        k21.i(annotations, "annotations");
        k21.i(typeConstructor, "constructor");
        k21.i(list, "arguments");
        if (!annotations.isEmpty() || !list.isEmpty() || z || typeConstructor.getDeclarationDescriptor() == null) {
            KotlinTypeFactory kotlinTypeFactory = INSTANCE;
            return k(annotations, typeConstructor, list, z, kotlinTypeFactory.c(typeConstructor, list, i61), new KotlinTypeFactory$simpleType$1(kotlinTypeFactory, typeConstructor, list, annotations, z));
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        k21.f(declarationDescriptor);
        ib2 defaultType = declarationDescriptor.getDefaultType();
        k21.h(defaultType, "constructor.declarationDescriptor!!.defaultType");
        return defaultType;
    }

    public static /* synthetic */ ib2 i(Annotations annotations, TypeConstructor typeConstructor, List list, boolean z, i61 i61, int i, Object obj) {
        if ((i & 16) != 0) {
            i61 = null;
        }
        return h(annotations, typeConstructor, list, z, i61);
    }

    @JvmStatic
    @NotNull
    public static final ib2 j(@NotNull Annotations annotations, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull MemberScope memberScope) {
        k21.i(annotations, "annotations");
        k21.i(typeConstructor, "constructor");
        k21.i(list, "arguments");
        k21.i(memberScope, "memberScope");
        e eVar = new e(typeConstructor, list, z, memberScope, new KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(INSTANCE, typeConstructor, list, annotations, z, memberScope));
        return annotations.isEmpty() ? eVar : new a(eVar, annotations);
    }

    @JvmStatic
    @NotNull
    public static final ib2 k(@NotNull Annotations annotations, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull MemberScope memberScope, @NotNull Function1<? super i61, ? extends ib2> function1) {
        k21.i(annotations, "annotations");
        k21.i(typeConstructor, "constructor");
        k21.i(list, "arguments");
        k21.i(memberScope, "memberScope");
        k21.i(function1, "refinedTypeFactory");
        e eVar = new e(typeConstructor, list, z, memberScope, function1);
        return annotations.isEmpty() ? eVar : new a(eVar, annotations);
    }
}
