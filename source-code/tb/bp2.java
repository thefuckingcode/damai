package tb;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class bp2 {
    public static final ib2 CANT_INFER_FUNCTION_PARAM_TYPE = me0.j("Cannot be inferred");
    public static final ib2 DONT_CARE = me0.p("DONT_CARE");
    @NotNull
    public static final ib2 NO_EXPECTED_TYPE = new a("NO_EXPECTED_TYPE");
    public static final ib2 UNIT_EXPECTED_TYPE = new a("UNIT_EXPECTED_TYPE");

    /* compiled from: Taobao */
    public static class a extends r50 {
        private final String b;

        public a(String str) {
            this.b = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0044  */
        private static /* synthetic */ void o(int i) {
            String format;
            String str = (i == 1 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 4) ? 2 : 3)];
            if (i != 1) {
                if (i == 2) {
                    objArr[0] = "delegate";
                } else if (i == 3) {
                    objArr[0] = "kotlinTypeRefiner";
                } else if (i != 4) {
                    objArr[0] = "newAnnotations";
                }
                if (i != 1) {
                    objArr[1] = "toString";
                } else if (i != 4) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                } else {
                    objArr[1] = "refine";
                }
                if (i != 1) {
                    if (i == 2) {
                        objArr[2] = "replaceDelegate";
                    } else if (i == 3) {
                        objArr[2] = "refine";
                    } else if (i != 4) {
                        objArr[2] = "replaceAnnotations";
                    }
                }
                format = String.format(str, objArr);
                if (i != 1 || i == 4) {
                    throw new IllegalStateException(format);
                }
                throw new IllegalArgumentException(format);
            }
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            if (i != 1) {
            }
            if (i != 1) {
            }
            format = String.format(str, objArr);
            if (i != 1) {
            }
            throw new IllegalStateException(format);
        }

        @Override // tb.ib2
        @NotNull
        /* renamed from: j */
        public ib2 g(boolean z) {
            throw new IllegalStateException(this.b);
        }

        @Override // tb.ib2
        @NotNull
        /* renamed from: k */
        public ib2 i(@NotNull Annotations annotations) {
            if (annotations == null) {
                o(0);
            }
            throw new IllegalStateException(this.b);
        }

        /* access modifiers changed from: protected */
        @Override // tb.r50
        @NotNull
        public ib2 l() {
            throw new IllegalStateException(this.b);
        }

        @Override // tb.r50
        @NotNull
        public r50 n(@NotNull ib2 ib2) {
            if (ib2 == null) {
                o(2);
            }
            throw new IllegalStateException(this.b);
        }

        @NotNull
        /* renamed from: p */
        public a m(@NotNull i61 i61) {
            if (i61 == null) {
                o(3);
            }
            return this;
        }

        @Override // tb.ib2
        @NotNull
        public String toString() {
            String str = this.b;
            if (str == null) {
                o(1);
            }
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0182  */
    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (!(i == 4 || i == 9 || i == 11 || i == 15 || i == 17 || i == 19 || i == 26 || i == 35 || i == 47 || i == 52 || i == 6 || i == 7)) {
            switch (i) {
                case 55:
                case 56:
                case 57:
                case 58:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (!(i == 4 || i == 9 || i == 11 || i == 15 || i == 17 || i == 19 || i == 26 || i == 35 || i == 47 || i == 52 || i == 6 || i == 7)) {
                switch (i) {
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        break;
                    default:
                        i2 = 3;
                        break;
                }
                Object[] objArr = new Object[i2];
                switch (i) {
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                    case 15:
                    case 17:
                    case 19:
                    case 26:
                    case 35:
                    case 47:
                    case 52:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                    case 5:
                    case 8:
                    case 10:
                    case 18:
                    case 23:
                    case 25:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 38:
                    case 40:
                    default:
                        objArr[0] = "type";
                        break;
                    case 12:
                        objArr[0] = "typeConstructor";
                        break;
                    case 13:
                        objArr[0] = "unsubstitutedMemberScope";
                        break;
                    case 14:
                        objArr[0] = "refinedTypeFactory";
                        break;
                    case 16:
                        objArr[0] = PushConstants.PARAMS;
                        break;
                    case 20:
                        objArr[0] = "subType";
                        break;
                    case 21:
                        objArr[0] = "superType";
                        break;
                    case 22:
                        objArr[0] = "substitutor";
                        break;
                    case 24:
                        objArr[0] = "result";
                        break;
                    case 31:
                    case 33:
                        objArr[0] = "clazz";
                        break;
                    case 32:
                        objArr[0] = "typeArguments";
                        break;
                    case 34:
                        objArr[0] = "projections";
                        break;
                    case 36:
                        objArr[0] = "a";
                        break;
                    case 37:
                        objArr[0] = "b";
                        break;
                    case 39:
                        objArr[0] = "typeParameters";
                        break;
                    case 41:
                        objArr[0] = "typeParameterConstructors";
                        break;
                    case 42:
                        objArr[0] = "specialType";
                        break;
                    case 43:
                    case 44:
                        objArr[0] = "isSpecialType";
                        break;
                    case 45:
                        objArr[0] = "parameterDescriptor";
                        break;
                    case 46:
                    case 50:
                        objArr[0] = "numberValueTypeConstructor";
                        break;
                    case 48:
                    case 49:
                        objArr[0] = "supertypes";
                        break;
                    case 51:
                    case 54:
                        objArr[0] = "expectedType";
                        break;
                    case 53:
                        objArr[0] = "literalTypeConstructor";
                        break;
                }
                if (i != 4) {
                    if (i != 9) {
                        if (i == 11 || i == 15) {
                            objArr[1] = "makeUnsubstitutedType";
                        } else if (i == 17) {
                            objArr[1] = "getDefaultTypeProjections";
                        } else if (i == 19) {
                            objArr[1] = "getImmediateSupertypes";
                        } else if (i == 26) {
                            objArr[1] = "getAllSupertypes";
                        } else if (i == 35) {
                            objArr[1] = "substituteProjectionsForParameters";
                        } else if (i != 47) {
                            if (i != 52) {
                                if (!(i == 6 || i == 7)) {
                                    switch (i) {
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                                            break;
                                    }
                                }
                            }
                            objArr[1] = "getPrimitiveNumberType";
                        } else {
                            objArr[1] = "getDefaultPrimitiveNumberType";
                        }
                    }
                    objArr[1] = "makeNullableIfNeeded";
                } else {
                    objArr[1] = "makeNullableAsSpecified";
                }
                switch (i) {
                    case 1:
                        objArr[2] = "makeNullable";
                        break;
                    case 2:
                        objArr[2] = "makeNotNullable";
                        break;
                    case 3:
                        objArr[2] = "makeNullableAsSpecified";
                        break;
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                    case 15:
                    case 17:
                    case 19:
                    case 26:
                    case 35:
                    case 47:
                    case 52:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        break;
                    case 5:
                    case 8:
                        objArr[2] = "makeNullableIfNeeded";
                        break;
                    case 10:
                        objArr[2] = "canHaveSubtypes";
                        break;
                    case 12:
                    case 13:
                    case 14:
                        objArr[2] = "makeUnsubstitutedType";
                        break;
                    case 16:
                        objArr[2] = "getDefaultTypeProjections";
                        break;
                    case 18:
                        objArr[2] = "getImmediateSupertypes";
                        break;
                    case 20:
                    case 21:
                    case 22:
                        objArr[2] = "createSubstitutedSupertype";
                        break;
                    case 23:
                    case 24:
                        objArr[2] = "collectAllSupertypes";
                        break;
                    case 25:
                        objArr[2] = "getAllSupertypes";
                        break;
                    case 27:
                        objArr[2] = "isNullableType";
                        break;
                    case 28:
                        objArr[2] = "acceptsNullable";
                        break;
                    case 29:
                        objArr[2] = "hasNullableSuperType";
                        break;
                    case 30:
                        objArr[2] = "getClassDescriptor";
                        break;
                    case 31:
                    case 32:
                        objArr[2] = "substituteParameters";
                        break;
                    case 33:
                    case 34:
                        objArr[2] = "substituteProjectionsForParameters";
                        break;
                    case 36:
                    case 37:
                        objArr[2] = "equalTypes";
                        break;
                    case 38:
                    case 39:
                        objArr[2] = "dependsOnTypeParameters";
                        break;
                    case 40:
                    case 41:
                        objArr[2] = "dependsOnTypeConstructors";
                        break;
                    case 42:
                    case 43:
                    case 44:
                        objArr[2] = "contains";
                        break;
                    case 45:
                        objArr[2] = "makeStarProjection";
                        break;
                    case 46:
                    case 48:
                        objArr[2] = "getDefaultPrimitiveNumberType";
                        break;
                    case 49:
                        objArr[2] = "findByFqName";
                        break;
                    case 50:
                    case 51:
                    case 53:
                    case 54:
                        objArr[2] = "getPrimitiveNumberType";
                        break;
                    case 59:
                        objArr[2] = "isTypeParameter";
                        break;
                    case 60:
                        objArr[2] = "isReifiedTypeParameter";
                        break;
                    case 61:
                        objArr[2] = "isNonReifiedTypeParameter";
                        break;
                    case 62:
                        objArr[2] = "getTypeParameterDescriptorOrNull";
                        break;
                    default:
                        objArr[2] = "noExpectedType";
                        break;
                }
                String format = String.format(str, objArr);
                if (!(i == 4 || i == 9 || i == 11 || i == 15 || i == 17 || i == 19 || i == 26 || i == 35 || i == 47 || i == 52 || i == 6 || i == 7)) {
                    switch (i) {
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i2 = 2;
            Object[] objArr2 = new Object[i2];
            switch (i) {
            }
            if (i != 4) {
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
            case 55:
            case 56:
            case 57:
            case 58:
                i2 = 2;
                break;
        }
        Object[] objArr22 = new Object[i2];
        switch (i) {
        }
        if (i != 4) {
        }
        switch (i) {
        }
        String format22 = String.format(str, objArr22);
        switch (i) {
        }
        throw new IllegalStateException(format22);
    }

    public static boolean b(@NotNull g61 g61) {
        if (g61 == null) {
            a(28);
        }
        if (g61.d()) {
            return true;
        }
        if (!gj0.b(g61) || !b(gj0.a(g61).l())) {
            return false;
        }
        return true;
    }

    public static boolean c(@Nullable g61 g61, @NotNull Function1<es2, Boolean> function1) {
        if (function1 == null) {
            a(43);
        }
        return d(g61, function1, null);
    }

    private static boolean d(@Nullable g61 g61, @NotNull Function1<es2, Boolean> function1, bc2<g61> bc2) {
        if (function1 == null) {
            a(44);
        }
        if (g61 == null) {
            return false;
        }
        es2 f = g61.f();
        if (v(g61)) {
            return function1.invoke(f).booleanValue();
        }
        if (bc2 != null && bc2.contains(g61)) {
            return false;
        }
        if (function1.invoke(f).booleanValue()) {
            return true;
        }
        if (bc2 == null) {
            bc2 = bc2.a();
        }
        bc2.add(g61);
        dj0 dj0 = f instanceof dj0 ? (dj0) f : null;
        if (dj0 != null && (d(dj0.k(), function1, bc2) || d(dj0.l(), function1, bc2))) {
            return true;
        }
        if ((f instanceof l50) && d(((l50) f).o(), function1, bc2)) {
            return true;
        }
        TypeConstructor c = g61.c();
        if (c instanceof IntersectionTypeConstructor) {
            for (g61 g612 : ((IntersectionTypeConstructor) c).getSupertypes()) {
                if (d(g612, function1, bc2)) {
                    return true;
                }
            }
            return false;
        }
        for (TypeProjection typeProjection : g61.b()) {
            if (!typeProjection.isStarProjection()) {
                if (d(typeProjection.getType(), function1, bc2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public static g61 e(@NotNull g61 g61, @NotNull g61 g612, @NotNull TypeSubstitutor typeSubstitutor) {
        if (g61 == null) {
            a(20);
        }
        if (g612 == null) {
            a(21);
        }
        if (typeSubstitutor == null) {
            a(22);
        }
        g61 q = typeSubstitutor.q(g612, Variance.INVARIANT);
        if (q != null) {
            return q(q, g61.d());
        }
        return null;
    }

    @Nullable
    public static ClassDescriptor f(@NotNull g61 g61) {
        if (g61 == null) {
            a(30);
        }
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @NotNull
    public static List<TypeProjection> g(@NotNull List<TypeParameterDescriptor> list) {
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            arrayList.add(new vo2(typeParameterDescriptor.getDefaultType()));
        }
        List<TypeProjection> list2 = CollectionsKt___CollectionsKt.y0(arrayList);
        if (list2 == null) {
            a(17);
        }
        return list2;
    }

    @NotNull
    public static List<g61> h(@NotNull g61 g61) {
        if (g61 == null) {
            a(18);
        }
        TypeSubstitutor f = TypeSubstitutor.f(g61);
        Collection<g61> supertypes = g61.c().getSupertypes();
        ArrayList arrayList = new ArrayList(supertypes.size());
        for (g61 g612 : supertypes) {
            g61 e = e(g61, g612, f);
            if (e != null) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    @Nullable
    public static TypeParameterDescriptor i(@NotNull g61 g61) {
        if (g61 == null) {
            a(62);
        }
        if (g61.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) g61.c().getDeclarationDescriptor();
        }
        return null;
    }

    public static boolean j(@NotNull g61 g61) {
        if (g61 == null) {
            a(29);
        }
        if (g61.c().getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        for (g61 g612 : h(g61)) {
            if (l(g612)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(@Nullable g61 g61) {
        return g61 != null && g61.c() == DONT_CARE.c();
    }

    public static boolean l(@NotNull g61 g61) {
        if (g61 == null) {
            a(27);
        }
        if (g61.d()) {
            return true;
        }
        if (gj0.b(g61) && l(gj0.a(g61).l())) {
            return true;
        }
        if (ed2.c(g61)) {
            return false;
        }
        if (m(g61)) {
            return j(g61);
        }
        TypeConstructor c = g61.c();
        if (c instanceof IntersectionTypeConstructor) {
            for (g61 g612 : c.getSupertypes()) {
                if (l(g612)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(@NotNull g61 g61) {
        if (g61 == null) {
            a(59);
        }
        return i(g61) != null || (g61.c() instanceof NewTypeVariableConstructor);
    }

    @NotNull
    public static g61 n(@NotNull g61 g61) {
        if (g61 == null) {
            a(2);
        }
        return p(g61, false);
    }

    @NotNull
    public static g61 o(@NotNull g61 g61) {
        if (g61 == null) {
            a(1);
        }
        return p(g61, true);
    }

    @NotNull
    public static g61 p(@NotNull g61 g61, boolean z) {
        if (g61 == null) {
            a(3);
        }
        es2 g = g61.f().g(z);
        if (g == null) {
            a(4);
        }
        return g;
    }

    @NotNull
    public static g61 q(@NotNull g61 g61, boolean z) {
        if (g61 == null) {
            a(8);
        }
        if (z) {
            return o(g61);
        }
        if (g61 == null) {
            a(9);
        }
        return g61;
    }

    @NotNull
    public static ib2 r(@NotNull ib2 ib2, boolean z) {
        if (ib2 == null) {
            a(5);
        }
        if (z) {
            ib2 j = ib2.j(true);
            if (j == null) {
                a(6);
            }
            return j;
        }
        if (ib2 == null) {
            a(7);
        }
        return ib2;
    }

    @NotNull
    public static TypeProjection s(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            a(45);
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    @NotNull
    public static ib2 t(ClassifierDescriptor classifierDescriptor, MemberScope memberScope, Function1<i61, ib2> function1) {
        if (!me0.r(classifierDescriptor)) {
            return u(classifierDescriptor.getTypeConstructor(), memberScope, function1);
        }
        ib2 j = me0.j("Unsubstituted type for " + classifierDescriptor);
        if (j == null) {
            a(11);
        }
        return j;
    }

    @NotNull
    public static ib2 u(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull Function1<i61, ib2> function1) {
        if (typeConstructor == null) {
            a(12);
        }
        if (memberScope == null) {
            a(13);
        }
        if (function1 == null) {
            a(14);
        }
        ib2 k = KotlinTypeFactory.k(Annotations.Companion.b(), typeConstructor, g(typeConstructor.getParameters()), false, memberScope, function1);
        if (k == null) {
            a(15);
        }
        return k;
    }

    public static boolean v(@NotNull g61 g61) {
        if (g61 == null) {
            a(0);
        }
        return g61 == NO_EXPECTED_TYPE || g61 == UNIT_EXPECTED_TYPE;
    }
}
