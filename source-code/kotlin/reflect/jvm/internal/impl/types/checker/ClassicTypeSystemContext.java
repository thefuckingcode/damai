package kotlin.reflect.jvm.internal.impl.types.checker;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.Variance;
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
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ai1;
import tb.bi1;
import tb.bp2;
import tb.dj0;
import tb.dz1;
import tb.en0;
import tb.es2;
import tb.fn0;
import tb.g61;
import tb.h61;
import tb.ib2;
import tb.j21;
import tb.k21;
import tb.l50;
import tb.nc0;
import tb.rf;
import tb.ti;
import tb.ue1;
import tb.vi;
import tb.z01;
import tb.zo2;

/* compiled from: Taobao */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {

    /* compiled from: Taobao */
    public static final class a {
        public static boolean A(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return b.D0((TypeConstructor) typeConstructorMarker, c.a.any);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean B(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean C(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                if (classDescriptor == null || !ue1.a(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean D(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).isDenotable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean E(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof g61) {
                return h61.a((g61) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean F(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Boolean bool = null;
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                if (classDescriptor != null) {
                    bool = Boolean.valueOf(z01.b(classDescriptor));
                }
                return k21.d(bool, Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean G(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean H(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean I(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.a.b(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean J(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof ib2) {
                return ((ib2) simpleTypeMarker).d();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        public static boolean K(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return b.D0((TypeConstructor) typeConstructorMarker, c.a.nothing);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean L(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof g61) {
                return bp2.l((g61) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean M(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof g61) {
                return b.y0((g61) simpleTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        public static boolean N(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(capturedTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (capturedTypeMarker instanceof ai1) {
                return ((ai1) capturedTypeMarker).o();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(capturedTypeMarker.getClass())).toString());
        }

        public static boolean O(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof ib2) {
                if (!h61.a((g61) simpleTypeMarker)) {
                    ib2 ib2 = (ib2) simpleTypeMarker;
                    return !(ib2.c().getDeclarationDescriptor() instanceof TypeAliasDescriptor) && (ib2.c().getDeclarationDescriptor() != null || (simpleTypeMarker instanceof rf) || (simpleTypeMarker instanceof ai1) || (simpleTypeMarker instanceof l50) || (ib2.c() instanceof IntegerLiteralTypeConstructor));
                }
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        public static boolean P(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeArgumentMarker, SocialConstants.PARAM_RECEIVER);
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).isStarProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeArgumentMarker.getClass())).toString());
        }

        public static boolean Q(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof ib2) {
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        public static boolean R(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                return k21.d(declarationDescriptor == null ? null : Boolean.valueOf(b.I0(declarationDescriptor)), Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker S(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(flexibleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (flexibleTypeMarker instanceof dj0) {
                return ((dj0) flexibleTypeMarker).k();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(flexibleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker T(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.a.c(classicTypeSystemContext, kotlinTypeMarker);
        }

        @Nullable
        public static KotlinTypeMarker U(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(capturedTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (capturedTypeMarker instanceof ai1) {
                return ((ai1) capturedTypeMarker).n();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(capturedTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker V(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof es2) {
                return vi.b((es2) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker W(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemCommonBackendContext.a.a(classicTypeSystemContext, kotlinTypeMarker);
        }

        @NotNull
        public static AbstractTypeCheckerContext X(@NotNull ClassicTypeSystemContext classicTypeSystemContext, boolean z, boolean z2) {
            k21.i(classicTypeSystemContext, "this");
            return new ti(z, z2, false, null, 12, null);
        }

        @NotNull
        public static SimpleTypeMarker Y(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(definitelyNotNullTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (definitelyNotNullTypeMarker instanceof l50) {
                return ((l50) definitelyNotNullTypeMarker).o();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + definitelyNotNullTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(definitelyNotNullTypeMarker.getClass())).toString());
        }

        public static int Z(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean a(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, "c1");
            k21.i(typeConstructorMarker2, "c2");
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
            } else if (typeConstructorMarker2 instanceof TypeConstructor) {
                return k21.d(typeConstructorMarker, typeConstructorMarker2);
            } else {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker2 + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker2.getClass())).toString());
            }
        }

        @NotNull
        public static Collection<KotlinTypeMarker> a0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            TypeConstructorMarker typeConstructor = classicTypeSystemContext.typeConstructor(simpleTypeMarker);
            if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) typeConstructor).f();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        public static int b(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof g61) {
                return ((g61) kotlinTypeMarker).b().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        public static int b0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker) {
            return TypeSystemInferenceExtensionContext.a.d(classicTypeSystemContext, typeArgumentListMarker);
        }

        @NotNull
        public static TypeArgumentListMarker c(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof ib2) {
                return (TypeArgumentListMarker) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static Collection<KotlinTypeMarker> c0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                Collection<g61> supertypes = ((TypeConstructor) typeConstructorMarker).getSupertypes();
                k21.h(supertypes, "this.supertypes");
                return supertypes;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static CapturedTypeMarker d(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (!(simpleTypeMarker instanceof ib2)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
            } else if (simpleTypeMarker instanceof ai1) {
                return (ai1) simpleTypeMarker;
            } else {
                return null;
            }
        }

        @NotNull
        public static TypeConstructorMarker d0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.a.e(classicTypeSystemContext, kotlinTypeMarker);
        }

        @Nullable
        public static DefinitelyNotNullTypeMarker e(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (!(simpleTypeMarker instanceof ib2)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
            } else if (simpleTypeMarker instanceof l50) {
                return (l50) simpleTypeMarker;
            } else {
                return null;
            }
        }

        @NotNull
        public static TypeConstructorMarker e0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof ib2) {
                return ((ib2) simpleTypeMarker).c();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static DynamicTypeMarker f(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(flexibleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (!(flexibleTypeMarker instanceof dj0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(flexibleTypeMarker.getClass())).toString());
            } else if (flexibleTypeMarker instanceof nc0) {
                return (nc0) flexibleTypeMarker;
            } else {
                return null;
            }
        }

        @NotNull
        public static SimpleTypeMarker f0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(flexibleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (flexibleTypeMarker instanceof dj0) {
                return ((dj0) flexibleTypeMarker).l();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(flexibleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static FlexibleTypeMarker g(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof g61) {
                es2 f = ((g61) kotlinTypeMarker).f();
                if (f instanceof dj0) {
                    return (dj0) f;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker g0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.a.f(classicTypeSystemContext, kotlinTypeMarker);
        }

        @Nullable
        public static SimpleTypeMarker h(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof g61) {
                es2 f = ((g61) kotlinTypeMarker).f();
                if (f instanceof ib2) {
                    return (ib2) f;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker h0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, boolean z) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof SimpleTypeMarker) {
                return classicTypeSystemContext.withNullability((SimpleTypeMarker) kotlinTypeMarker, z);
            }
            if (kotlinTypeMarker instanceof FlexibleTypeMarker) {
                FlexibleTypeMarker flexibleTypeMarker = (FlexibleTypeMarker) kotlinTypeMarker;
                return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(flexibleTypeMarker), z), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(flexibleTypeMarker), z));
            }
            throw new IllegalStateException("sealed".toString());
        }

        @NotNull
        public static TypeArgumentMarker i(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof g61) {
                return TypeUtilsKt.a((g61) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker i0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, boolean z) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof ib2) {
                return ((ib2) simpleTypeMarker).j(z);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static SimpleTypeMarker j(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, "type");
            k21.i(captureStatus, "status");
            if (simpleTypeMarker instanceof ib2) {
                return bi1.b((ib2) simpleTypeMarker, captureStatus);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker k(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, "lowerBound");
            k21.i(simpleTypeMarker2, "upperBound");
            if (!(simpleTypeMarker instanceof ib2)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + AVFSCacheConstants.COMMA_SEP + dz1.b(classicTypeSystemContext.getClass())).toString());
            } else if (simpleTypeMarker2 instanceof ib2) {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                return KotlinTypeFactory.d((ib2) simpleTypeMarker, (ib2) simpleTypeMarker2);
            } else {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + AVFSCacheConstants.COMMA_SEP + dz1.b(classicTypeSystemContext.getClass())).toString());
            }
        }

        @NotNull
        public static TypeArgumentMarker l(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, int i) {
            return TypeSystemInferenceExtensionContext.a.a(classicTypeSystemContext, typeArgumentListMarker, i);
        }

        @NotNull
        public static TypeArgumentMarker m(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, int i) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof g61) {
                return ((g61) kotlinTypeMarker).b().get(i);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static fn0 n(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return DescriptorUtilsKt.j((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeParameterMarker o(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker, int i) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) typeConstructorMarker).getParameters().get(i);
                k21.h(typeParameterDescriptor, "this.parameters[index]");
                return typeParameterDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType p(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return b.O((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType q(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return b.R((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker r(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeParameterMarker, SocialConstants.PARAM_RECEIVER);
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                return TypeUtilsKt.f((TypeParameterDescriptor) typeParameterMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeParameterMarker.getClass())).toString());
        }

        @Nullable
        public static KotlinTypeMarker s(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof g61) {
                return z01.e((g61) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker t(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeArgumentMarker, SocialConstants.PARAM_RECEIVER);
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).getType().f();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeArgumentMarker.getClass())).toString());
        }

        @Nullable
        public static TypeParameterMarker u(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                if (declarationDescriptor instanceof TypeParameterDescriptor) {
                    return (TypeParameterDescriptor) declarationDescriptor;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeVariance v(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeArgumentMarker, SocialConstants.PARAM_RECEIVER);
            if (typeArgumentMarker instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) typeArgumentMarker).getProjectionKind();
                k21.h(projectionKind, "this.projectionKind");
                return zo2.a(projectionKind);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeArgumentMarker.getClass())).toString());
        }

        @NotNull
        public static TypeVariance w(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(typeParameterMarker, SocialConstants.PARAM_RECEIVER);
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) typeParameterMarker).getVariance();
                k21.h(variance, "this.variance");
                return zo2.a(variance);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeParameterMarker.getClass())).toString());
        }

        public static boolean x(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull en0 en0) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            k21.i(en0, "fqName");
            if (kotlinTypeMarker instanceof g61) {
                return ((g61) kotlinTypeMarker).getAnnotations().hasAnnotation(en0);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean y(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(simpleTypeMarker, "a");
            k21.i(simpleTypeMarker2, "b");
            if (!(simpleTypeMarker instanceof ib2)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker.getClass())).toString());
            } else if (simpleTypeMarker2 instanceof ib2) {
                return ((ib2) simpleTypeMarker).b() == ((ib2) simpleTypeMarker2).b();
            } else {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker2 + AVFSCacheConstants.COMMA_SEP + dz1.b(simpleTypeMarker2.getClass())).toString());
            }
        }

        @NotNull
        public static KotlinTypeMarker z(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull List<? extends KotlinTypeMarker> list) {
            k21.i(classicTypeSystemContext, "this");
            k21.i(list, "types");
            return j21.a(list);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    KotlinTypeMarker createFlexibleType(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z);
}
