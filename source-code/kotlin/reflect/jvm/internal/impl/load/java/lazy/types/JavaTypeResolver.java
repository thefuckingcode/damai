package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.huawei.hms.opendevice.c;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.g61;
import tb.ib2;
import tb.k21;
import tb.me0;
import tb.oi;
import tb.s01;
import tb.vo2;
import tb.x31;
import tb.x61;
import tb.y31;

/* compiled from: Taobao */
public final class JavaTypeResolver {
    @NotNull
    private final x61 a;
    @NotNull
    private final TypeParameterResolver b;

    public JavaTypeResolver(@NotNull x61 x61, @NotNull TypeParameterResolver typeParameterResolver) {
        k21.i(x61, c.a);
        k21.i(typeParameterResolver, "typeParameterResolver");
        this.a = x61;
        this.b = typeParameterResolver;
    }

    private final boolean a(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        if (!b((JavaType) k.d0(javaClassifierType.getTypeArguments()))) {
            return false;
        }
        List<TypeParameterDescriptor> parameters = x31.INSTANCE.b(classDescriptor).getTypeConstructor().getParameters();
        k21.h(parameters, "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters");
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) k.d0(parameters);
        Variance variance = typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance();
        if (variance == null || variance == Variance.OUT_VARIANCE) {
            return false;
        }
        return true;
    }

    private static final boolean b(JavaType javaType) {
        JavaWildcardType javaWildcardType = javaType instanceof JavaWildcardType ? (JavaWildcardType) javaType : null;
        return (javaWildcardType == null || javaWildcardType.getBound() == null || javaWildcardType.isExtends()) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        if ((!r4.isEmpty()) != false) goto L_0x0024;
     */
    private final List<TypeProjection> c(JavaClassifierType javaClassifierType, y31 y31, TypeConstructor typeConstructor) {
        y31 y312;
        boolean isRaw = javaClassifierType.isRaw();
        boolean z = true;
        if (!isRaw) {
            if (javaClassifierType.getTypeArguments().isEmpty()) {
                List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
                k21.h(parameters, "constructor.parameters");
            }
            z = false;
        }
        List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
        k21.h(parameters2, "constructor.parameters");
        if (z) {
            ArrayList arrayList = new ArrayList(n.q(parameters2, 10));
            for (T t : parameters2) {
                LazyWrappedType lazyWrappedType = new LazyWrappedType(this.a.e(), new JavaTypeResolver$computeArguments$1$erasedUpperBound$1(t, y31, typeConstructor));
                RawSubstitution rawSubstitution = RawSubstitution.INSTANCE;
                k21.h(t, "parameter");
                if (isRaw) {
                    y312 = y31;
                } else {
                    y312 = y31.g(JavaTypeFlexibility.INFLEXIBLE);
                }
                arrayList.add(rawSubstitution.i(t, y312, lazyWrappedType));
            }
            return CollectionsKt___CollectionsKt.y0(arrayList);
        } else if (parameters2.size() != javaClassifierType.getTypeArguments().size()) {
            ArrayList arrayList2 = new ArrayList(n.q(parameters2, 10));
            Iterator<T> it = parameters2.iterator();
            while (it.hasNext()) {
                arrayList2.add(new vo2(me0.j(it.next().getName().b())));
            }
            return CollectionsKt___CollectionsKt.y0(arrayList2);
        } else {
            Iterable<s01> iterable = CollectionsKt___CollectionsKt.E0(javaClassifierType.getTypeArguments());
            ArrayList arrayList3 = new ArrayList(n.q(iterable, 10));
            for (s01 s01 : iterable) {
                int a2 = s01.a();
                parameters2.size();
                TypeParameterDescriptor typeParameterDescriptor = parameters2.get(a2);
                y31 f = JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null);
                k21.h(typeParameterDescriptor, "parameter");
                arrayList3.add(o((JavaType) s01.b(), f, typeParameterDescriptor));
            }
            return CollectionsKt___CollectionsKt.y0(arrayList3);
        }
    }

    private final ib2 d(JavaClassifierType javaClassifierType, y31 y31, ib2 ib2) {
        TypeConstructor typeConstructor = null;
        Annotations annotations = ib2 == null ? null : ib2.getAnnotations();
        if (annotations == null) {
            annotations = new LazyJavaAnnotations(this.a, javaClassifierType, false, 4, null);
        }
        TypeConstructor e = e(javaClassifierType, y31);
        if (e == null) {
            return null;
        }
        boolean h = h(y31);
        if (ib2 != null) {
            typeConstructor = ib2.c();
        }
        if (k21.d(typeConstructor, e) && !javaClassifierType.isRaw() && h) {
            return ib2.j(true);
        }
        List<TypeProjection> c = c(javaClassifierType, y31, e);
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.i(annotations, e, c, h, null, 16, null);
    }

    private final TypeConstructor e(JavaClassifierType javaClassifierType, y31 y31) {
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return f(javaClassifierType);
        }
        TypeConstructor typeConstructor = null;
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            en0 fqName = javaClass.getFqName();
            if (fqName != null) {
                ClassDescriptor i = i(javaClassifierType, y31, fqName);
                if (i == null) {
                    i = this.a.a().m().resolveClass(javaClass);
                }
                if (i != null) {
                    typeConstructor = i.getTypeConstructor();
                }
                if (typeConstructor == null) {
                    return f(javaClassifierType);
                }
                return typeConstructor;
            }
            throw new AssertionError(k21.r("Class type should have a FQ name: ", classifier));
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.b.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter == null) {
                return null;
            }
            return resolveTypeParameter.getTypeConstructor();
        } else {
            throw new IllegalStateException(k21.r("Unknown classifier kind: ", classifier));
        }
    }

    private final TypeConstructor f(JavaClassifierType javaClassifierType) {
        oi m = oi.m(new en0(javaClassifierType.getClassifierQualifiedName()));
        k21.h(m, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor typeConstructor = this.a.a().b().f().q().d(m, l.e(0)).getTypeConstructor();
        k21.h(typeConstructor, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final boolean g(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) {
            return false;
        }
        return true;
    }

    private final boolean h(y31 y31) {
        if (y31.c() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || y31.f() || y31.d() == TypeUsage.SUPERTYPE) {
            return false;
        }
        return true;
    }

    private final ClassDescriptor i(JavaClassifierType javaClassifierType, y31 y31, en0 en0) {
        if (y31.f() && k21.d(en0, JavaTypeResolverKt.a())) {
            return this.a.a().o().c();
        }
        x31 x31 = x31.INSTANCE;
        ClassDescriptor h = x31.h(x31, en0, this.a.d().getBuiltIns(), null, 4, null);
        if (h == null) {
            return null;
        }
        return (!x31.e(h) || !(y31.c() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || y31.d() == TypeUsage.SUPERTYPE || a(javaClassifierType, h))) ? h : x31.b(h);
    }

    public static /* synthetic */ g61 k(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, y31 y31, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.j(javaArrayType, y31, z);
    }

    private final g61 l(JavaClassifierType javaClassifierType, y31 y31) {
        boolean z = !y31.f() && y31.d() != TypeUsage.SUPERTYPE;
        boolean isRaw = javaClassifierType.isRaw();
        if (isRaw || z) {
            ib2 d = d(javaClassifierType, y31.g(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
            if (d == null) {
                return m(javaClassifierType);
            }
            ib2 d2 = d(javaClassifierType, y31.g(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), d);
            if (d2 == null) {
                return m(javaClassifierType);
            }
            if (isRaw) {
                return new RawTypeImpl(d, d2);
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.d(d, d2);
        }
        ib2 d3 = d(javaClassifierType, y31, null);
        return d3 == null ? m(javaClassifierType) : d3;
    }

    private static final ib2 m(JavaClassifierType javaClassifierType) {
        ib2 j = me0.j(k21.r("Unresolved java class ", javaClassifierType.getPresentableText()));
        k21.h(j, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return j;
    }

    private final TypeProjection o(JavaType javaType, y31 y31, TypeParameterDescriptor typeParameterDescriptor) {
        if (!(javaType instanceof JavaWildcardType)) {
            return new vo2(Variance.INVARIANT, n(javaType, y31));
        }
        JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
        JavaType bound = javaWildcardType.getBound();
        Variance variance = javaWildcardType.isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
        if (bound == null || g(variance, typeParameterDescriptor)) {
            return JavaTypeResolverKt.d(typeParameterDescriptor, y31);
        }
        return TypeUtilsKt.d(n(bound, JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null)), variance, typeParameterDescriptor);
    }

    @NotNull
    public final g61 j(@NotNull JavaArrayType javaArrayType, @NotNull y31 y31, boolean z) {
        k21.i(javaArrayType, "arrayType");
        k21.i(y31, RichTextNode.ATTR);
        JavaType componentType = javaArrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = componentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) componentType : null;
        PrimitiveType type = javaPrimitiveType == null ? null : javaPrimitiveType.getType();
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.a, javaArrayType, true);
        if (type != null) {
            ib2 N = this.a.d().getBuiltIns().N(type);
            k21.h(N, "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)");
            N.k(Annotations.Companion.a(CollectionsKt___CollectionsKt.i0(lazyJavaAnnotations, N.getAnnotations())));
            if (y31.f()) {
                return N;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.d(N, N.j(true));
        }
        g61 n = n(componentType, JavaTypeResolverKt.f(TypeUsage.COMMON, y31.f(), null, 2, null));
        if (y31.f()) {
            ib2 m = this.a.d().getBuiltIns().m(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, n, lazyJavaAnnotations);
            k21.h(m, "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)");
            return m;
        }
        KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.INSTANCE;
        ib2 m2 = this.a.d().getBuiltIns().m(Variance.INVARIANT, n, lazyJavaAnnotations);
        k21.h(m2, "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)");
        return KotlinTypeFactory.d(m2, this.a.d().getBuiltIns().m(Variance.OUT_VARIANCE, n, lazyJavaAnnotations).j(true));
    }

    @NotNull
    public final g61 n(@Nullable JavaType javaType, @NotNull y31 y31) {
        ib2 ib2;
        k21.i(y31, RichTextNode.ATTR);
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                ib2 = this.a.d().getBuiltIns().Q(type);
            } else {
                ib2 = this.a.d().getBuiltIns().Y();
            }
            k21.h(ib2, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return ib2;
        } else if (javaType instanceof JavaClassifierType) {
            return l((JavaClassifierType) javaType, y31);
        } else {
            if (javaType instanceof JavaArrayType) {
                return k(this, (JavaArrayType) javaType, y31, false, 4, null);
            }
            if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                g61 n = bound == null ? null : n(bound, y31);
                if (n != null) {
                    return n;
                }
                ib2 y = this.a.d().getBuiltIns().y();
                k21.h(y, "c.module.builtIns.defaultBound");
                return y;
            } else if (javaType == null) {
                ib2 y2 = this.a.d().getBuiltIns().y();
                k21.h(y2, "c.module.builtIns.defaultBound");
                return y2;
            } else {
                throw new UnsupportedOperationException(k21.r("Unsupported type: ", javaType));
            }
        }
    }
}
