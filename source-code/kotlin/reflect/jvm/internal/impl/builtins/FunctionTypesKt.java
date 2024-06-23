package kotlin.reflect.jvm.internal.impl.builtins;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: functionTypes.kt */
public final class FunctionTypesKt {
    public static final boolean isFunctionType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isFunctionType");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor != null ? getFunctionalClassKind(declarationDescriptor) : null) == FunctionClassDescriptor.Kind.Function;
    }

    public static final boolean isSuspendFunctionType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isSuspendFunctionType");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor != null ? getFunctionalClassKind(declarationDescriptor) : null) == FunctionClassDescriptor.Kind.SuspendFunction;
    }

    public static final boolean isBuiltinFunctionalType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isBuiltinFunctionalType");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        FunctionClassDescriptor.Kind functionalClassKind = declarationDescriptor != null ? getFunctionalClassKind(declarationDescriptor) : null;
        return functionalClassKind == FunctionClassDescriptor.Kind.Function || functionalClassKind == FunctionClassDescriptor.Kind.SuspendFunction;
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$isBuiltinExtensionFunctionalType");
        return isBuiltinFunctionalType(kotlinType) && isTypeAnnotatedWithExtensionFunctionType(kotlinType);
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType kotlinType) {
        Annotations annotations = kotlinType.getAnnotations();
        FqName fqName = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        return annotations.findAnnotation(fqName) != null;
    }

    public static final FunctionClassDescriptor.Kind getFunctionalClassKind(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "$this$getFunctionalClassKind");
        if ((declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor));
        }
        return null;
    }

    private static final FunctionClassDescriptor.Kind getFunctionalClassKind(FqNameUnsafe fqNameUnsafe) {
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        BuiltInFictitiousFunctionClassFactory.Companion companion = BuiltInFictitiousFunctionClassFactory.Companion;
        String asString = fqNameUnsafe.shortName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "shortName().asString()");
        FqName parent = fqNameUnsafe.toSafe().parent();
        Intrinsics.checkExpressionValueIsNotNull(parent, "toSafe().parent()");
        return companion.getFunctionalClassKind(asString, parent);
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$getReceiverTypeFromFunctionType");
        isBuiltinFunctionalType(kotlinType);
        if (isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return ((TypeProjection) CollectionsKt.first((List) kotlinType.getArguments())).getType();
        }
        return null;
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$getReturnTypeFromFunctionType");
        isBuiltinFunctionalType(kotlinType);
        KotlinType type = ((TypeProjection) CollectionsKt.last((List) kotlinType.getArguments())).getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "arguments.last().type");
        return type;
    }

    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$getValueParameterTypesFromFunctionType");
        isBuiltinFunctionalType(kotlinType);
        List<TypeProjection> arguments = kotlinType.getArguments();
        return arguments.subList(isBuiltinExtensionFunctionalType(kotlinType) ? 1 : 0, arguments.size() - 1);
    }

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType kotlinType) {
        String str;
        Intrinsics.checkParameterIsNotNull(kotlinType, "$this$extractParameterNameFromFunctionTypeArgument");
        Annotations annotations = kotlinType.getAnnotations();
        FqName fqName = KotlinBuiltIns.FQ_NAMES.parameterName;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.parameterName");
        AnnotationDescriptor findAnnotation = annotations.findAnnotation(fqName);
        if (findAnnotation != null) {
            Object singleOrNull = CollectionsKt.singleOrNull(findAnnotation.getAllValueArguments().values());
            if (!(singleOrNull instanceof StringValue)) {
                singleOrNull = null;
            }
            StringValue stringValue = (StringValue) singleOrNull;
            if (!(stringValue == null || (str = (String) stringValue.getValue()) == null)) {
                if (!Name.isValidIdentifier(str)) {
                    str = null;
                }
                if (str != null) {
                    return Name.identifier(str);
                }
            }
        }
        return null;
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType kotlinType, List<? extends KotlinType> list, List<Name> list2, KotlinType kotlinType2, KotlinBuiltIns kotlinBuiltIns) {
        Name name;
        Intrinsics.checkParameterIsNotNull(list, "parameterTypes");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "returnType");
        Intrinsics.checkParameterIsNotNull(kotlinBuiltIns, "builtIns");
        int i = 0;
        ArrayList arrayList = new ArrayList(list.size() + (kotlinType != null ? 1 : 0) + 1);
        ArrayList arrayList2 = arrayList;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList2, kotlinType != null ? TypeUtilsKt.asTypeProjection(kotlinType) : null);
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (list2 == null || (name = list2.get(i)) == null || name.isSpecial()) {
                name = null;
            }
            if (name != null) {
                FqName fqName = KotlinBuiltIns.FQ_NAMES.parameterName;
                Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.parameterName");
                Name identifier = Name.identifier(SerializableCookie.NAME);
                String asString = name.asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
                t2 = TypeUtilsKt.replaceAnnotations(t2, Annotations.Companion.create(CollectionsKt.plus(t2.getAnnotations(), new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt.mapOf(TuplesKt.to(identifier, new StringValue(asString)))))));
            }
            arrayList2.add(TypeUtilsKt.asTypeProjection(t2));
            i = i2;
        }
        arrayList.add(TypeUtilsKt.asTypeProjection(kotlinType2));
        return arrayList;
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List list, List list2, KotlinType kotlinType2, boolean z, int i, Object obj) {
        return createFunctionType(kotlinBuiltIns, annotations, kotlinType, list, list2, kotlinType2, (i & 64) != 0 ? false : z);
    }

    public static final SimpleType createFunctionType(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List<? extends KotlinType> list, List<Name> list2, KotlinType kotlinType2, boolean z) {
        Intrinsics.checkParameterIsNotNull(kotlinBuiltIns, "builtIns");
        Intrinsics.checkParameterIsNotNull(annotations, "annotations");
        Intrinsics.checkParameterIsNotNull(list, "parameterTypes");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "returnType");
        List<TypeProjection> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(kotlinType, list, list2, kotlinType2, kotlinBuiltIns);
        int size = list.size();
        if (kotlinType != null) {
            size++;
        }
        ClassDescriptor suspendFunction = z ? kotlinBuiltIns.getSuspendFunction(size) : kotlinBuiltIns.getFunction(size);
        Intrinsics.checkExpressionValueIsNotNull(suspendFunction, "if (suspendFunction) bui…tFunction(parameterCount)");
        if (kotlinType != null) {
            FqName fqName = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
            Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
            if (annotations.findAnnotation(fqName) == null) {
                Annotations.Companion companion = Annotations.Companion;
                FqName fqName2 = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
                Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
                annotations = companion.create(CollectionsKt.plus(annotations, new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName2, MapsKt.emptyMap())));
            }
        }
        return KotlinTypeFactory.simpleNotNullType(annotations, suspendFunction, functionTypeArgumentProjections);
    }
}
