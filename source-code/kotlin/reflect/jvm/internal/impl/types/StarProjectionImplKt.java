package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImplKt {
    public static final KotlinType starProjectionType(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkParameterIsNotNull(typeParameterDescriptor, "$this$starProjectionType");
        DeclarationDescriptor containingDeclaration = typeParameterDescriptor.getContainingDeclaration();
        if (containingDeclaration != null) {
            TypeConstructor typeConstructor = ((ClassifierDescriptorWithTypeParameters) containingDeclaration).getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "classDescriptor.typeConstructor");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "classDescriptor.typeConstructor.parameters");
            List<TypeParameterDescriptor> list = parameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                Intrinsics.checkExpressionValueIsNotNull(t, "it");
                arrayList.add(t.getTypeConstructor());
            }
            TypeSubstitutor create = TypeSubstitutor.create(new StarProjectionImplKt$starProjectionType$1(arrayList));
            List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkExpressionValueIsNotNull(upperBounds, "this.upperBounds");
            KotlinType substitute = create.substitute((KotlinType) CollectionsKt.first((List) upperBounds), Variance.OUT_VARIANCE);
            if (substitute != null) {
                return substitute;
            }
            SimpleType defaultBound = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getDefaultBound();
            Intrinsics.checkExpressionValueIsNotNull(defaultBound, "builtIns.defaultBound");
            return defaultBound;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
    }
}
