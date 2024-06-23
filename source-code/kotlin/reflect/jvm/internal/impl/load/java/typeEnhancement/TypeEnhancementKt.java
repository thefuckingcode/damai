package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
public final class TypeEnhancementKt {
    private static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;
    private static final EnhancedTypeAnnotations ENHANCED_NULLABILITY_ANNOTATIONS;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MutabilityQualifier.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MutabilityQualifier.READ_ONLY.ordinal()] = 1;
            iArr[MutabilityQualifier.MUTABLE.ordinal()] = 2;
            int[] iArr2 = new int[NullabilityQualifier.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            iArr2[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
        }
    }

    public static final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> function1) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$enhance");
        Intrinsics.checkParameterIsNotNull(function1, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), function1, 0).getTypeIfChanged();
    }

    public static final boolean hasEnhancedNullability(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$hasEnhancedNullability");
        return hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, kotlinType);
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(typeSystemCommonBackendContext, "$this$hasEnhancedNullability");
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "type");
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(kotlinTypeMarker, fqName);
    }

    private static final Result enhancePossiblyFlexible(UnwrappedType unwrappedType, Function1<? super Integer, JavaTypeQualifiers> function1, int i) {
        RawTypeImpl rawTypeImpl;
        UnwrappedType unwrappedType2 = unwrappedType;
        boolean z = false;
        if (KotlinTypeKt.isError(unwrappedType2)) {
            return new Result(unwrappedType2, 1, false);
        }
        if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            SimpleResult enhanceInflexible = enhanceInflexible(flexibleType.getLowerBound(), function1, i, TypeComponentPosition.FLEXIBLE_LOWER);
            SimpleResult enhanceInflexible2 = enhanceInflexible(flexibleType.getUpperBound(), function1, i, TypeComponentPosition.FLEXIBLE_UPPER);
            enhanceInflexible.getSubtreeSize();
            enhanceInflexible2.getSubtreeSize();
            if (enhanceInflexible.getWereChanges() || enhanceInflexible2.getWereChanges()) {
                z = true;
            }
            KotlinType enhancement = TypeWithEnhancementKt.getEnhancement(enhanceInflexible.getType());
            if (enhancement == null) {
                enhancement = TypeWithEnhancementKt.getEnhancement(enhanceInflexible2.getType());
            }
            if (z) {
                if (unwrappedType instanceof RawTypeImpl) {
                    rawTypeImpl = new RawTypeImpl(enhanceInflexible.getType(), enhanceInflexible2.getType());
                } else {
                    rawTypeImpl = KotlinTypeFactory.flexibleType(enhanceInflexible.getType(), enhanceInflexible2.getType());
                }
                unwrappedType = TypeWithEnhancementKt.wrapEnhancement(rawTypeImpl, enhancement);
            }
            return new Result(unwrappedType, enhanceInflexible.getSubtreeSize(), z);
        } else if (unwrappedType instanceof SimpleType) {
            return enhanceInflexible((SimpleType) unwrappedType, function1, i, TypeComponentPosition.INFLEXIBLE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition) {
        TypeProjection typeProjection;
        if (!shouldEnhance(typeComponentPosition) && simpleType.getArguments().isEmpty()) {
            return new SimpleResult(simpleType, 1, false);
        }
        ClassifierDescriptor declarationDescriptor = simpleType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new SimpleResult(simpleType, 1, false);
        }
        Intrinsics.checkExpressionValueIsNotNull(declarationDescriptor, "constructor.declarationD…pleResult(this, 1, false)");
        JavaTypeQualifiers invoke = function1.invoke(Integer.valueOf(i));
        EnhancementResult<ClassifierDescriptor> enhanceMutability = enhanceMutability(declarationDescriptor, invoke, typeComponentPosition);
        ClassifierDescriptor component1 = enhanceMutability.component1();
        Annotations component2 = enhanceMutability.component2();
        TypeConstructor typeConstructor = component1.getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z = component2 != null;
        List<TypeProjection> arguments = simpleType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        int i3 = 0;
        for (T t : arguments) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (t2.isStarProjection()) {
                i2++;
                TypeConstructor typeConstructor2 = component1.getTypeConstructor();
                Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "enhancedClassifier.typeConstructor");
                typeProjection = TypeUtils.makeStarProjection(typeConstructor2.getParameters().get(i3));
            } else {
                Result enhancePossiblyFlexible = enhancePossiblyFlexible(t2.getType().unwrap(), function1, i2);
                z = z || enhancePossiblyFlexible.getWereChanges();
                i2 += enhancePossiblyFlexible.getSubtreeSize();
                KotlinType type = enhancePossiblyFlexible.getType();
                Variance projectionKind = t2.getProjectionKind();
                Intrinsics.checkExpressionValueIsNotNull(projectionKind, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(type, projectionKind, typeConstructor.getParameters().get(i3));
            }
            arrayList.add(typeProjection);
            i3 = i4;
        }
        ArrayList arrayList2 = arrayList;
        EnhancementResult<Boolean> enhancedNullability = getEnhancedNullability(simpleType, invoke, typeComponentPosition);
        boolean booleanValue = enhancedNullability.component1().booleanValue();
        Annotations component22 = enhancedNullability.component2();
        int i5 = i2 - i;
        if (!(z || component22 != null)) {
            return new SimpleResult(simpleType, i5, false);
        }
        NotNullTypeParameter simpleType$default = KotlinTypeFactory.simpleType$default(compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull((Object[]) new Annotations[]{simpleType.getAnnotations(), component2, component22})), typeConstructor, arrayList2, booleanValue, null, 16, null);
        if (invoke.isNotNullTypeParameter()) {
            simpleType$default = new NotNullTypeParameter(simpleType$default);
        }
        SimpleType wrapEnhancement = component22 != null && invoke.isNullabilityQualifierForWarning() ? TypeWithEnhancementKt.wrapEnhancement(simpleType, simpleType$default) : simpleType$default;
        if (wrapEnhancement != null) {
            return new SimpleResult((SimpleType) wrapEnhancement, i5, true);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    private static final Annotations compositeAnnotationsOrSingle(List<? extends Annotations> list) {
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("At least one Annotations object expected".toString());
        } else if (size != 1) {
            return new CompositeAnnotations(CollectionsKt.toList(list));
        } else {
            return (Annotations) CollectionsKt.single((List) list);
        }
    }

    public static final boolean shouldEnhance(TypeComponentPosition typeComponentPosition) {
        Intrinsics.checkParameterIsNotNull(typeComponentPosition, "$this$shouldEnhance");
        return typeComponentPosition != TypeComponentPosition.INFLEXIBLE;
    }

    private static final <T> EnhancementResult<T> noChange(T t) {
        return new EnhancementResult<>(t, null);
    }

    private static final <T> EnhancementResult<T> enhancedNullability(T t) {
        return new EnhancementResult<>(t, ENHANCED_NULLABILITY_ANNOTATIONS);
    }

    private static final <T> EnhancementResult<T> enhancedMutability(T t) {
        return new EnhancementResult<>(t, ENHANCED_MUTABILITY_ANNOTATIONS);
    }

    private static final EnhancementResult<ClassifierDescriptor> enhanceMutability(ClassifierDescriptor classifierDescriptor, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        if (!shouldEnhance(typeComponentPosition)) {
            return noChange(classifierDescriptor);
        }
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            return noChange(classifierDescriptor);
        }
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        MutabilityQualifier mutability = javaTypeQualifiers.getMutability();
        if (mutability != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[mutability.ordinal()];
            if (i != 1) {
                if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                    if (javaToKotlinClassMap.isReadOnly(classDescriptor)) {
                        return enhancedMutability(javaToKotlinClassMap.convertReadOnlyToMutable(classDescriptor));
                    }
                }
            } else if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
                if (javaToKotlinClassMap.isMutable(classDescriptor2)) {
                    return enhancedMutability(javaToKotlinClassMap.convertMutableToReadOnly(classDescriptor2));
                }
            }
        }
        return noChange(classifierDescriptor);
    }

    private static final EnhancementResult<Boolean> getEnhancedNullability(KotlinType kotlinType, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        if (!shouldEnhance(typeComponentPosition)) {
            return noChange(Boolean.valueOf(kotlinType.isMarkedNullable()));
        }
        NullabilityQualifier nullability = javaTypeQualifiers.getNullability();
        if (nullability != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[nullability.ordinal()];
            if (i == 1) {
                return enhancedNullability(true);
            }
            if (i == 2) {
                return enhancedNullability(false);
            }
        }
        return noChange(Boolean.valueOf(kotlinType.isMarkedNullable()));
    }

    static {
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName);
        FqName fqName2 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName2);
    }
}
