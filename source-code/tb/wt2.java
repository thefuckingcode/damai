package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h22;
import tb.n51;

/* compiled from: Taobao */
public final class wt2 {
    @NotNull
    private static final en0 a = new en0("kotlin.jvm.JvmStatic");

    @Nullable
    public static final KCallableImpl<?> a(@Nullable Object obj) {
        KCallableImpl<?> kCallableImpl = (KCallableImpl) (!(obj instanceof KCallableImpl) ? null : obj);
        if (kCallableImpl == null) {
            kCallableImpl = b(obj);
        }
        return kCallableImpl != null ? kCallableImpl : c(obj);
    }

    @Nullable
    public static final KFunctionImpl b(@Nullable Object obj) {
        KFunctionImpl kFunctionImpl = null;
        KFunctionImpl kFunctionImpl2 = (KFunctionImpl) (!(obj instanceof KFunctionImpl) ? null : obj);
        if (kFunctionImpl2 != null) {
            return kFunctionImpl2;
        }
        if (!(obj instanceof FunctionReference)) {
            obj = null;
        }
        FunctionReference functionReference = (FunctionReference) obj;
        KCallable compute = functionReference != null ? functionReference.compute() : null;
        if (compute instanceof KFunctionImpl) {
            kFunctionImpl = compute;
        }
        return kFunctionImpl;
    }

    @Nullable
    public static final KPropertyImpl<?> c(@Nullable Object obj) {
        KPropertyImpl<?> kPropertyImpl = null;
        KPropertyImpl<?> kPropertyImpl2 = (KPropertyImpl) (!(obj instanceof KPropertyImpl) ? null : obj);
        if (kPropertyImpl2 != null) {
            return kPropertyImpl2;
        }
        if (!(obj instanceof PropertyReference)) {
            obj = null;
        }
        PropertyReference propertyReference = (PropertyReference) obj;
        KCallable compute = propertyReference != null ? propertyReference.compute() : null;
        if (compute instanceof KPropertyImpl) {
            kPropertyImpl = compute;
        }
        return kPropertyImpl;
    }

    @NotNull
    public static final List<Annotation> d(@NotNull Annotated annotated) {
        k21.i(annotated, "$this$computeAnnotations");
        Annotations<AnnotationDescriptor> annotations = annotated.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            Annotation annotation = null;
            if (source instanceof wx1) {
                annotation = ((wx1) source).a();
            } else if (source instanceof h22.a) {
                jy1 a2 = ((h22.a) source).getJavaElement();
                if (!(a2 instanceof yx1)) {
                    a2 = null;
                }
                yx1 yx1 = (yx1) a2;
                if (yx1 != null) {
                    annotation = yx1.a();
                }
            } else {
                annotation = m(annotationDescriptor);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final Object e(@NotNull Type type) {
        k21.i(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (k21.d(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (k21.d(type, Character.TYPE)) {
            return Character.valueOf((char) 0);
        }
        if (k21.d(type, Byte.TYPE)) {
            return Byte.valueOf((byte) 0);
        }
        if (k21.d(type, Short.TYPE)) {
            return Short.valueOf((short) 0);
        }
        if (k21.d(type, Integer.TYPE)) {
            return 0;
        }
        if (k21.d(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (k21.d(type, Long.TYPE)) {
            return 0L;
        }
        if (k21.d(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (k21.d(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    @Nullable
    public static final <M extends MessageLite, D extends CallableDescriptor> D f(@NotNull Class<?> cls, @NotNull M m, @NotNull NameResolver nameResolver, @NotNull ap2 ap2, @NotNull nb nbVar, @NotNull Function2<? super MemberDeserializer, ? super M, ? extends D> function2) {
        List<ProtoBuf$TypeParameter> typeParameterList;
        k21.i(cls, "moduleAnchor");
        k21.i(m, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(ap2, "typeTable");
        k21.i(nbVar, "metadataVersion");
        k21.i(function2, "createDescriptor");
        f22 a2 = ze1.a(cls);
        if (m instanceof ProtoBuf$Function) {
            typeParameterList = ((ProtoBuf$Function) m).getTypeParameterList();
        } else if (m instanceof ProtoBuf$Property) {
            typeParameterList = ((ProtoBuf$Property) m).getTypeParameterList();
        } else {
            throw new IllegalStateException(("Unsupported message: " + m).toString());
        }
        j60 a3 = a2.a();
        ModuleDescriptor b = a2.b();
        fv2 b2 = fv2.Companion.b();
        k21.h(typeParameterList, "typeParameters");
        return (D) ((CallableDescriptor) function2.invoke(new MemberDeserializer(new l60(a3, nameResolver, b, ap2, b2, nbVar, null, null, typeParameterList)), m));
    }

    @Nullable
    public static final ReceiverParameterDescriptor g(@NotNull CallableDescriptor callableDescriptor) {
        k21.i(callableDescriptor, "$this$instanceReceiverParameter");
        if (callableDescriptor.getDispatchReceiverParameter() == null) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
    }

    @NotNull
    public static final en0 h() {
        return a;
    }

    public static final boolean i(@NotNull KType kType) {
        g61 c;
        k21.i(kType, "$this$isInlineClassType");
        if (!(kType instanceof KTypeImpl)) {
            kType = null;
        }
        KTypeImpl kTypeImpl = (KTypeImpl) kType;
        return (kTypeImpl == null || (c = kTypeImpl.c()) == null || !z01.c(c)) ? false : true;
    }

    private static final Class<?> j(ClassLoader classLoader, String str, String str2, int i) {
        if (k21.d(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str3 = str + '.' + o.E(str2, '.', '$', false, 4, null);
        if (i > 0) {
            str3 = o.B(jl1.ARRAY_START_STR, i) + u91.LEVEL_L + str3 + d80.TokenSEM;
        }
        return fy1.a(classLoader, str3);
    }

    private static final Class<?> k(ClassLoader classLoader, oi oiVar, int i) {
        w31 w31 = w31.INSTANCE;
        fn0 j = oiVar.b().j();
        k21.h(j, "kotlinClassId.asSingleFqName().toUnsafe()");
        oi o = w31.o(j);
        if (o != null) {
            oiVar = o;
        }
        String b = oiVar.h().b();
        k21.h(b, "javaClassId.packageFqName.asString()");
        String b2 = oiVar.i().b();
        k21.h(b2, "javaClassId.relativeClassName.asString()");
        return j(classLoader, b, b2, i);
    }

    static /* synthetic */ Class l(ClassLoader classLoader, oi oiVar, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return k(classLoader, oiVar, i);
    }

    private static final Annotation m(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
        Class<?> n = f != null ? n(f) : null;
        if (!(n instanceof Class)) {
            n = null;
        }
        if (n == null) {
            return null;
        }
        Set<Map.Entry<og1, om<?>>> entrySet = annotationDescriptor.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        for (T t : entrySet) {
            og1 og1 = (og1) t.getKey();
            ClassLoader classLoader = n.getClassLoader();
            k21.h(classLoader, "annotationClass.classLoader");
            Object p = p((om) t.getValue(), classLoader);
            Pair a2 = p != null ? do2.a(og1.b(), p) : null;
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return (Annotation) AnnotationConstructorCallerKt.d(n, x.r(arrayList), null, 4, null);
    }

    @Nullable
    public static final Class<?> n(@NotNull ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "$this$toJavaClass");
        SourceElement source = classDescriptor.getSource();
        k21.h(source, "source");
        if (source instanceof f61) {
            KotlinJvmBinaryClass a2 = ((f61) source).a();
            Objects.requireNonNull(a2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((wy1) a2).a();
        } else if (source instanceof h22.a) {
            jy1 a3 = ((h22.a) source).getJavaElement();
            Objects.requireNonNull(a3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) a3).getElement();
        } else {
            oi h = DescriptorUtilsKt.h(classDescriptor);
            if (h != null) {
                return k(ReflectClassUtilKt.g(classDescriptor.getClass()), h, 0);
            }
            return null;
        }
    }

    @Nullable
    public static final KVisibility o(@NotNull h60 h60) {
        k21.i(h60, "$this$toKVisibility");
        if (k21.d(h60, g60.PUBLIC)) {
            return KVisibility.PUBLIC;
        }
        if (k21.d(h60, g60.PROTECTED)) {
            return KVisibility.PROTECTED;
        }
        if (k21.d(h60, g60.INTERNAL)) {
            return KVisibility.INTERNAL;
        }
        if (!k21.d(h60, g60.PRIVATE) && !k21.d(h60, g60.PRIVATE_TO_THIS)) {
            return null;
        }
        return KVisibility.PRIVATE;
    }

    private static final Object p(om<?> omVar, ClassLoader classLoader) {
        if (omVar instanceof c6) {
            return m((AnnotationDescriptor) ((c6) omVar).b());
        }
        if (omVar instanceof w7) {
            Iterable<om> iterable = (Iterable) ((w7) omVar).b();
            ArrayList arrayList = new ArrayList(n.q(iterable, 10));
            for (om omVar2 : iterable) {
                arrayList.add(p(omVar2, classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return array;
        } else if (omVar instanceof ae0) {
            Pair pair = (Pair) ((ae0) omVar).b();
            og1 og1 = (og1) pair.component2();
            Class l = l(classLoader, (oi) pair.component1(), 0, 4, null);
            if (l != null) {
                return tt2.a(l, og1.b());
            }
            return null;
        } else if (omVar instanceof n51) {
            n51.b bVar = (n51.b) ((n51) omVar).b();
            if (bVar instanceof n51.b.C0307b) {
                n51.b.C0307b bVar2 = (n51.b.C0307b) bVar;
                return k(classLoader, bVar2.b(), bVar2.a());
            } else if (bVar instanceof n51.b.a) {
                ClassifierDescriptor declarationDescriptor = ((n51.b.a) bVar).a().c().getDeclarationDescriptor();
                if (!(declarationDescriptor instanceof ClassDescriptor)) {
                    declarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                if (classDescriptor != null) {
                    return n(classDescriptor);
                }
                return null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!(omVar instanceof ne0) && !(omVar instanceof fk1)) {
            return omVar.b();
        } else {
            return null;
        }
    }
}
