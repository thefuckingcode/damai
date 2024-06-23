package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KCallable;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001an\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\u000b*\u00020\f\"\b\b\u0001\u0010\n*\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u0002H\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u001d\u0010\u0016\u001a\u0019\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\n0\u0017¢\u0006\u0002\b\u0019H\u0000¢\u0006\u0002\u0010\u001a\u001a.\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002\u001a(\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010!\u001a\u00020\"H\u0002\u001a\"\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0(H\b¢\u0006\u0002\u0010)\u001a\u0014\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010,H\u0000\u001a\u0010\u0010-\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010,H\u0000\u001a\u0014\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u000100*\u0004\u0018\u00010,H\u0000\u001a\u0012\u00101\u001a\b\u0012\u0004\u0012\u00020302*\u000204H\u0000\u001a\u000e\u00105\u001a\u0004\u0018\u000103*\u000206H\u0002\u001a\u0012\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\u000208H\u0000\u001a\u000e\u00109\u001a\u0004\u0018\u00010:*\u00020;H\u0000\u001a\u001a\u0010<\u001a\u0004\u0018\u00010,*\u0006\u0012\u0002\b\u00030=2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006>"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflection"}, k = 2, mv = {1, 1, 16})
/* compiled from: util.kt */
public final class UtilKt {
    private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final Class<?> toJavaClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "$this$toJavaClass");
        SourceElement source = classDescriptor.getSource();
        Intrinsics.checkExpressionValueIsNotNull(source, "source");
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            if (binaryClass != null) {
                return ((ReflectKotlinClass) binaryClass).getKlass();
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
            if (javaElement != null) {
                return ((ReflectJavaClass) javaElement).getElement();
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        } else {
            ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
            if (classId != null) {
                return loadClass(ReflectClassUtilKt.getSafeClassLoader(classDescriptor.getClass()), classId, 0);
            }
            return null;
        }
    }

    static /* synthetic */ Class loadClass$default(ClassLoader classLoader, ClassId classId, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return loadClass(classLoader, classId, i);
    }

    private static final Class<?> loadClass(ClassLoader classLoader, ClassId classId, int i) {
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(unsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava != null) {
            classId = mapKotlinToJava;
        }
        String asString = classId.getPackageFqName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "javaClassId.packageFqName.asString()");
        String asString2 = classId.getRelativeClassName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString2, "javaClassId.relativeClassName.asString()");
        return loadClass(classLoader, asString, asString2, i);
    }

    private static final Class<?> loadClass(ClassLoader classLoader, String str, String str2, int i) {
        if (Intrinsics.areEqual(str, "kotlin")) {
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
        String str3 = str + '.' + StringsKt.replace$default(str2, '.', (char) Typography.dollar, false, 4, (Object) null);
        if (i > 0) {
            str3 = StringsKt.repeat("[", i) + 'L' + str3 + ';';
        }
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, str3);
    }

    public static final KVisibility toKVisibility(Visibility visibility) {
        Intrinsics.checkParameterIsNotNull(visibility, "$this$toKVisibility");
        if (Intrinsics.areEqual(visibility, Visibilities.PUBLIC)) {
            return KVisibility.PUBLIC;
        }
        if (Intrinsics.areEqual(visibility, Visibilities.PROTECTED)) {
            return KVisibility.PROTECTED;
        }
        if (Intrinsics.areEqual(visibility, Visibilities.INTERNAL)) {
            return KVisibility.INTERNAL;
        }
        if (!Intrinsics.areEqual(visibility, Visibilities.PRIVATE) && !Intrinsics.areEqual(visibility, Visibilities.PRIVATE_TO_THIS)) {
            return null;
        }
        return KVisibility.PRIVATE;
    }

    public static final List<Annotation> computeAnnotations(Annotated annotated) {
        Intrinsics.checkParameterIsNotNull(annotated, "$this$computeAnnotations");
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
            SourceElement source = annotationDescriptor.getSource();
            Annotation annotation = null;
            if (source instanceof ReflectAnnotationSource) {
                annotation = ((ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
                if (!(javaElement instanceof ReflectJavaAnnotation)) {
                    javaElement = null;
                }
                ReflectJavaAnnotation reflectJavaAnnotation = (ReflectJavaAnnotation) javaElement;
                if (reflectJavaAnnotation != null) {
                    annotation = reflectJavaAnnotation.getAnnotation();
                }
            } else {
                annotation = toAnnotationInstance(annotationDescriptor);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (!(javaClass instanceof Class)) {
            javaClass = null;
        }
        if (javaClass == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : annotationDescriptor.getAllValueArguments().entrySet()) {
            Name name = (Name) t.getKey();
            ClassLoader classLoader = javaClass.getClassLoader();
            Intrinsics.checkExpressionValueIsNotNull(classLoader, "annotationClass.classLoader");
            Object runtimeValue = toRuntimeValue((ConstantValue) t.getValue(), classLoader);
            Pair pair = runtimeValue != null ? TuplesKt.to(name.asString(), runtimeValue) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(javaClass, MapsKt.toMap(arrayList), null, 4, null);
    }

    private static final Object toRuntimeValue(ConstantValue<?> constantValue, ClassLoader classLoader) {
        if (constantValue instanceof AnnotationValue) {
            return toAnnotationInstance((AnnotationDescriptor) ((AnnotationValue) constantValue).getValue());
        }
        if (constantValue instanceof ArrayValue) {
            Iterable<ConstantValue> iterable = (Iterable) ((ArrayValue) constantValue).getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ConstantValue constantValue2 : iterable) {
                arrayList.add(toRuntimeValue(constantValue2, classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } else if (constantValue instanceof EnumValue) {
            Pair pair = (Pair) ((EnumValue) constantValue).getValue();
            Name name = (Name) pair.component2();
            Class loadClass$default = loadClass$default(classLoader, (ClassId) pair.component1(), 0, 4, null);
            if (loadClass$default == null) {
                return null;
            }
            if (loadClass$default != null) {
                return Util.getEnumConstantByName(loadClass$default, name.asString());
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
        } else if (constantValue instanceof KClassValue) {
            KClassValue.Value value = (KClassValue.Value) ((KClassValue) constantValue).getValue();
            if (value instanceof KClassValue.Value.NormalClass) {
                KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value;
                return loadClass(classLoader, normalClass.getClassId(), normalClass.getArrayDimensions());
            } else if (value instanceof KClassValue.Value.LocalClass) {
                ClassifierDescriptor declarationDescriptor = ((KClassValue.Value.LocalClass) value).getType().getConstructor().getDeclarationDescriptor();
                if (!(declarationDescriptor instanceof ClassDescriptor)) {
                    declarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                if (classDescriptor != null) {
                    return toJavaClass(classDescriptor);
                }
                return null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!(constantValue instanceof ErrorValue) && !(constantValue instanceof NullValue)) {
            return constantValue.getValue();
        } else {
            return null;
        }
    }

    public static final KFunctionImpl asKFunctionImpl(Object obj) {
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

    public static final KPropertyImpl<?> asKPropertyImpl(Object obj) {
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

    public static final KCallableImpl<?> asKCallableImpl(Object obj) {
        KFunctionImpl kFunctionImpl = (KCallableImpl) (!(obj instanceof KCallableImpl) ? null : obj);
        if (kFunctionImpl == null) {
            kFunctionImpl = asKFunctionImpl(obj);
        }
        return kFunctionImpl != null ? kFunctionImpl : asKPropertyImpl(obj);
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor callableDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableDescriptor, "$this$instanceReceiverParameter");
        if (callableDescriptor.getDispatchReceiverParameter() == null) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        if (containingDeclaration != null) {
            return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> cls, M m, NameResolver nameResolver, TypeTable typeTable, BinaryVersion binaryVersion, Function2<? super MemberDeserializer, ? super M, ? extends D> function2) {
        List<ProtoBuf.TypeParameter> typeParameterList;
        Intrinsics.checkParameterIsNotNull(cls, "moduleAnchor");
        Intrinsics.checkParameterIsNotNull(m, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Intrinsics.checkParameterIsNotNull(binaryVersion, "metadataVersion");
        Intrinsics.checkParameterIsNotNull(function2, "createDescriptor");
        RuntimeModuleData orCreateModule = ModuleByClassLoaderKt.getOrCreateModule(cls);
        if (m instanceof ProtoBuf.Function) {
            typeParameterList = ((ProtoBuf.Function) m).getTypeParameterList();
        } else if (m instanceof ProtoBuf.Property) {
            typeParameterList = ((ProtoBuf.Property) m).getTypeParameterList();
        } else {
            throw new IllegalStateException(("Unsupported message: " + m).toString());
        }
        DeserializationComponents deserialization = orCreateModule.getDeserialization();
        ModuleDescriptor module = orCreateModule.getModule();
        VersionRequirementTable empty = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkExpressionValueIsNotNull(typeParameterList, "typeParameters");
        return (D) ((CallableDescriptor) function2.invoke(new MemberDeserializer(new DeserializationContext(deserialization, nameResolver, module, typeTable, empty, binaryVersion, null, null, typeParameterList)), m));
    }
}
