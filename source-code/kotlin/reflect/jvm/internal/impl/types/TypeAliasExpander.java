package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeAliasExpander.kt */
public final class TypeAliasExpander {
    public static final Companion Companion = new Companion(null);
    private static final TypeAliasExpander NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    private final TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;

    public TypeAliasExpander(TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z) {
        Intrinsics.checkParameterIsNotNull(typeAliasExpansionReportStrategy, "reportStrategy");
        this.reportStrategy = typeAliasExpansionReportStrategy;
        this.shouldCheckBounds = z;
    }

    public final SimpleType expand(TypeAliasExpansion typeAliasExpansion, Annotations annotations) {
        Intrinsics.checkParameterIsNotNull(typeAliasExpansion, "typeAliasExpansion");
        Intrinsics.checkParameterIsNotNull(annotations, "annotations");
        return expandRecursively(typeAliasExpansion, annotations, false, 0, true);
    }

    private final SimpleType expandRecursively(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z, int i, boolean z2) {
        TypeProjection expandTypeProjection = expandTypeProjection(new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType()), typeAliasExpansion, null, i);
        KotlinType type = expandTypeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "expandedProjection.type");
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(type);
        if (KotlinTypeKt.isError(asSimpleType)) {
            return asSimpleType;
        }
        expandTypeProjection.getProjectionKind();
        Variance variance = Variance.INVARIANT;
        checkRepeatedAnnotations(asSimpleType.getAnnotations(), annotations);
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(combineAnnotations(asSimpleType, annotations), z);
        Intrinsics.checkExpressionValueIsNotNull(makeNullableIfNeeded, "expandedType.combineAnno…fNeeded(it, isNullable) }");
        return z2 ? SpecialTypesKt.withAbbreviation(makeNullableIfNeeded, createAbbreviation(typeAliasExpansion, annotations, z)) : makeNullableIfNeeded;
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z) {
        TypeConstructor typeConstructor = typeAliasExpansion.getDescriptor().getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "descriptor.typeConstructor");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, typeAliasExpansion.getArguments(), z, MemberScope.Empty.INSTANCE);
    }

    private final TypeProjection expandTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int i) {
        Variance variance;
        SimpleType simpleType;
        Companion.assertRecursionDepth(i, typeAliasExpansion.getDescriptor());
        if (typeProjection.isStarProjection()) {
            if (typeParameterDescriptor == null) {
                Intrinsics.throwNpe();
            }
            TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkExpressionValueIsNotNull(makeStarProjection, "TypeUtils.makeStarProjec…ypeParameterDescriptor!!)");
            return makeStarProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "underlyingProjection.type");
        TypeProjection replacement = typeAliasExpansion.getReplacement(type.getConstructor());
        if (replacement == null) {
            return expandNonArgumentTypeProjection(typeProjection, typeAliasExpansion, i);
        }
        if (replacement.isStarProjection()) {
            if (typeParameterDescriptor == null) {
                Intrinsics.throwNpe();
            }
            TypeProjection makeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkExpressionValueIsNotNull(makeStarProjection2, "TypeUtils.makeStarProjec…ypeParameterDescriptor!!)");
            return makeStarProjection2;
        }
        UnwrappedType unwrap = replacement.getType().unwrap();
        TypeAliasExpander typeAliasExpander = this;
        Variance projectionKind = replacement.getProjectionKind();
        Intrinsics.checkExpressionValueIsNotNull(projectionKind, "argument.projectionKind");
        Variance projectionKind2 = typeProjection.getProjectionKind();
        Intrinsics.checkExpressionValueIsNotNull(projectionKind2, "underlyingProjection.projectionKind");
        if (!(projectionKind2 == projectionKind || projectionKind2 == Variance.INVARIANT)) {
            if (projectionKind == Variance.INVARIANT) {
                projectionKind = projectionKind2;
            } else {
                typeAliasExpander.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
            }
        }
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null) {
            variance = Variance.INVARIANT;
        }
        Intrinsics.checkExpressionValueIsNotNull(variance, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (!(variance == projectionKind || variance == Variance.INVARIANT)) {
            if (projectionKind == Variance.INVARIANT) {
                projectionKind = Variance.INVARIANT;
            } else {
                typeAliasExpander.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
            }
        }
        checkRepeatedAnnotations(type.getAnnotations(), unwrap.getAnnotations());
        if (unwrap instanceof DynamicType) {
            simpleType = combineAnnotations((DynamicType) unwrap, type.getAnnotations());
        } else {
            simpleType = combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(unwrap), type);
        }
        return new TypeProjectionImpl(projectionKind, simpleType);
    }

    private final DynamicType combineAnnotations(DynamicType dynamicType, Annotations annotations) {
        return dynamicType.replaceAnnotations(createCombinedAnnotations(dynamicType, annotations));
    }

    private final SimpleType combineAnnotations(SimpleType simpleType, Annotations annotations) {
        SimpleType simpleType2 = simpleType;
        return KotlinTypeKt.isError(simpleType2) ? simpleType : TypeSubstitutionKt.replace$default(simpleType, (List) null, createCombinedAnnotations(simpleType2, annotations), 1, (Object) null);
    }

    private final Annotations createCombinedAnnotations(KotlinType kotlinType, Annotations annotations) {
        if (KotlinTypeKt.isError(kotlinType)) {
            return kotlinType.getAnnotations();
        }
        return AnnotationsKt.composeAnnotations(annotations, kotlinType.getAnnotations());
    }

    private final void checkRepeatedAnnotations(Annotations annotations, Annotations annotations2) {
        HashSet hashSet = new HashSet();
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(((AnnotationDescriptor) it.next()).getFqName());
        }
        HashSet hashSet2 = hashSet;
        Iterator it2 = annotations2.iterator();
        while (it2.hasNext()) {
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) it2.next();
            if (hashSet2.contains(annotationDescriptor.getFqName())) {
                this.reportStrategy.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    private final SimpleType combineNullability(SimpleType simpleType, KotlinType kotlinType) {
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(simpleType, kotlinType.isMarkedNullable());
        Intrinsics.checkExpressionValueIsNotNull(makeNullableIfNeeded, "TypeUtils.makeNullableIf…romType.isMarkedNullable)");
        return makeNullableIfNeeded;
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType simpleType, KotlinType kotlinType) {
        return combineAnnotations(combineNullability(simpleType, kotlinType), kotlinType.getAnnotations());
    }

    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, int i) {
        UnwrappedType unwrap = typeProjection.getType().unwrap();
        if (DynamicTypesKt.isDynamic(unwrap)) {
            return typeProjection;
        }
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(unwrap);
        SimpleType simpleType = asSimpleType;
        if (KotlinTypeKt.isError(simpleType) || !TypeUtilsKt.requiresTypeAliasExpansion(simpleType)) {
            return typeProjection;
        }
        TypeConstructor constructor = asSimpleType.getConstructor();
        ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
        constructor.getParameters().size();
        asSimpleType.getArguments().size();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        if (declarationDescriptor instanceof TypeAliasDescriptor) {
            TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) declarationDescriptor;
            if (typeAliasExpansion.isRecursion(typeAliasDescriptor)) {
                this.reportStrategy.recursiveTypeAlias(typeAliasDescriptor);
                Variance variance = Variance.INVARIANT;
                return new TypeProjectionImpl(variance, ErrorUtils.createErrorType("Recursive type alias: " + typeAliasDescriptor.getName()));
            }
            List<TypeProjection> arguments = asSimpleType.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
            int i2 = 0;
            for (T t : arguments) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(expandTypeProjection(t, typeAliasExpansion, constructor.getParameters().get(i2), i + 1));
                i2 = i3;
            }
            SimpleType expandRecursively = expandRecursively(TypeAliasExpansion.Companion.create(typeAliasExpansion, typeAliasDescriptor, arrayList), asSimpleType.getAnnotations(), asSimpleType.isMarkedNullable(), i + 1, false);
            SimpleType substituteArguments = substituteArguments(asSimpleType, typeAliasExpansion, i);
            if (!DynamicTypesKt.isDynamic(expandRecursively)) {
                expandRecursively = SpecialTypesKt.withAbbreviation(expandRecursively, substituteArguments);
            }
            return new TypeProjectionImpl(typeProjection.getProjectionKind(), expandRecursively);
        }
        SimpleType substituteArguments2 = substituteArguments(asSimpleType, typeAliasExpansion, i);
        checkTypeArgumentsSubstitution(simpleType, substituteArguments2);
        return new TypeProjectionImpl(typeProjection.getProjectionKind(), substituteArguments2);
    }

    private final SimpleType substituteArguments(SimpleType simpleType, TypeAliasExpansion typeAliasExpansion, int i) {
        TypeConstructor constructor = simpleType.getConstructor();
        List<TypeProjection> arguments = simpleType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (T t : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            TypeProjectionImpl expandTypeProjection = expandTypeProjection(t2, typeAliasExpansion, constructor.getParameters().get(i2), i + 1);
            if (!expandTypeProjection.isStarProjection()) {
                expandTypeProjection = new TypeProjectionImpl(expandTypeProjection.getProjectionKind(), TypeUtils.makeNullableIfNeeded(expandTypeProjection.getType(), t2.getType().isMarkedNullable()));
            }
            arrayList.add(expandTypeProjection);
            i2 = i3;
        }
        return TypeSubstitutionKt.replace$default(simpleType, (List) arrayList, (Annotations) null, 2, (Object) null);
    }

    private final void checkTypeArgumentsSubstitution(KotlinType kotlinType, KotlinType kotlinType2) {
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType2);
        Intrinsics.checkExpressionValueIsNotNull(create, "TypeSubstitutor.create(substitutedType)");
        int i = 0;
        for (T t : kotlinType2.getArguments()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (!t2.isStarProjection()) {
                KotlinType type = t2.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "substitutedArgument.type");
                if (!TypeUtilsKt.containsTypeAliasParameters(type)) {
                    TypeProjection typeProjection = kotlinType.getArguments().get(i);
                    TypeParameterDescriptor typeParameterDescriptor = kotlinType.getConstructor().getParameters().get(i);
                    if (this.shouldCheckBounds) {
                        Companion companion = Companion;
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.reportStrategy;
                        KotlinType type2 = typeProjection.getType();
                        Intrinsics.checkExpressionValueIsNotNull(type2, "unsubstitutedArgument.type");
                        KotlinType type3 = t2.getType();
                        Intrinsics.checkExpressionValueIsNotNull(type3, "substitutedArgument.type");
                        Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "typeParameter");
                        companion.checkBoundsInTypeAlias(typeAliasExpansionReportStrategy, type2, type3, typeParameterDescriptor, create);
                    }
                }
            }
            i = i2;
        }
    }

    /* compiled from: TypeAliasExpander.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void checkBoundsInTypeAlias(TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, KotlinType kotlinType, KotlinType kotlinType2, TypeParameterDescriptor typeParameterDescriptor, TypeSubstitutor typeSubstitutor) {
            Intrinsics.checkParameterIsNotNull(typeAliasExpansionReportStrategy, "reportStrategy");
            Intrinsics.checkParameterIsNotNull(kotlinType, "unsubstitutedArgument");
            Intrinsics.checkParameterIsNotNull(kotlinType2, "typeArgument");
            Intrinsics.checkParameterIsNotNull(typeParameterDescriptor, "typeParameterDescriptor");
            Intrinsics.checkParameterIsNotNull(typeSubstitutor, "substitutor");
            for (KotlinType kotlinType3 : typeParameterDescriptor.getUpperBounds()) {
                KotlinType safeSubstitute = typeSubstitutor.safeSubstitute(kotlinType3, Variance.INVARIANT);
                Intrinsics.checkExpressionValueIsNotNull(safeSubstitute, "substitutor.safeSubstitu…ound, Variance.INVARIANT)");
                if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType2, safeSubstitute)) {
                    typeAliasExpansionReportStrategy.boundsViolationInSubstitution(safeSubstitute, kotlinType, kotlinType2, typeParameterDescriptor);
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void assertRecursionDepth(int i, TypeAliasDescriptor typeAliasDescriptor) {
            if (i > 100) {
                throw new AssertionError("Too deep recursion while expanding type alias " + typeAliasDescriptor.getName());
            }
        }
    }
}
