package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: AnnotationDeserializer.kt */
public final class AnnotationDeserializer {
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            int[] iArr2 = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 1;
            iArr2[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 2;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses2) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Intrinsics.checkParameterIsNotNull(notFoundClasses2, "notFoundClasses");
        this.module = moduleDescriptor;
        this.notFoundClasses = notFoundClasses2;
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf.Annotation annotation, NameResolver nameResolver) {
        Intrinsics.checkParameterIsNotNull(annotation, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        ClassDescriptor resolveClass = resolveClass(NameResolverUtilKt.getClassId(nameResolver, annotation.getId()));
        Map emptyMap = MapsKt.emptyMap();
        if (annotation.getArgumentCount() != 0) {
            ClassDescriptor classDescriptor = resolveClass;
            if (!ErrorUtils.isError(classDescriptor) && DescriptorUtils.isAnnotationClass(classDescriptor)) {
                Collection<ClassConstructorDescriptor> constructors = resolveClass.getConstructors();
                Intrinsics.checkExpressionValueIsNotNull(constructors, "annotationClass.constructors");
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) CollectionsKt.singleOrNull(constructors);
                if (classConstructorDescriptor != null) {
                    List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                    Intrinsics.checkExpressionValueIsNotNull(valueParameters, "constructor.valueParameters");
                    List<ValueParameterDescriptor> list = valueParameters;
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                    for (T t : list) {
                        T t2 = t;
                        Intrinsics.checkExpressionValueIsNotNull(t2, "it");
                        linkedHashMap.put(t2.getName(), t);
                    }
                    List<ProtoBuf.Annotation.Argument> argumentList = annotation.getArgumentList();
                    Intrinsics.checkExpressionValueIsNotNull(argumentList, "proto.argumentList");
                    ArrayList arrayList = new ArrayList();
                    for (T t3 : argumentList) {
                        Intrinsics.checkExpressionValueIsNotNull(t3, "it");
                        Pair<Name, ConstantValue<?>> resolveArgument = resolveArgument(t3, linkedHashMap, nameResolver);
                        if (resolveArgument != null) {
                            arrayList.add(resolveArgument);
                        }
                    }
                    emptyMap = MapsKt.toMap(arrayList);
                }
            }
        }
        return new AnnotationDescriptorImpl(resolveClass.getDefaultType(), emptyMap, SourceElement.NO_SOURCE);
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument argument, Map<Name, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) map.get(NameResolverUtilKt.getName(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        Name name = NameResolverUtilKt.getName(nameResolver, argument.getNameId());
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "parameter.type");
        ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        Intrinsics.checkExpressionValueIsNotNull(value, "proto.value");
        return new Pair<>(name, resolveValueAndCheckExpectedType(type, value, nameResolver));
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> resolveValue = resolveValue(kotlinType, value, nameResolver);
        if (!doesValueConformToExpectedType(resolveValue, kotlinType, value)) {
            resolveValue = null;
        }
        if (resolveValue != null) {
            return resolveValue;
        }
        ErrorValue.Companion companion = ErrorValue.Companion;
        return companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + kotlinType);
    }

    public final ConstantValue<?> resolveValue(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> constantValue;
        Intrinsics.checkParameterIsNotNull(kotlinType, "expectedType");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Boolean bool = Flags.IS_UNSIGNED.get(value.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = bool.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    byte intValue = (byte) ((int) value.getIntValue());
                    if (booleanValue) {
                        constantValue = new UByteValue(intValue);
                    } else {
                        constantValue = new ByteValue(intValue);
                    }
                    return constantValue;
                case 2:
                    return new CharValue((char) ((int) value.getIntValue()));
                case 3:
                    short intValue2 = (short) ((int) value.getIntValue());
                    return booleanValue ? new UShortValue(intValue2) : new ShortValue(intValue2);
                case 4:
                    int intValue3 = (int) value.getIntValue();
                    return booleanValue ? new UIntValue(intValue3) : new IntValue(intValue3);
                case 5:
                    long intValue4 = value.getIntValue();
                    return booleanValue ? new ULongValue(intValue4) : new LongValue(intValue4);
                case 6:
                    return new FloatValue(value.getFloatValue());
                case 7:
                    return new DoubleValue(value.getDoubleValue());
                case 8:
                    return new BooleanValue(value.getIntValue() != 0);
                case 9:
                    return new StringValue(nameResolver.getString(value.getStringValue()));
                case 10:
                    return new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
                case 11:
                    return new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
                case 12:
                    ProtoBuf.Annotation annotation = value.getAnnotation();
                    Intrinsics.checkExpressionValueIsNotNull(annotation, "value.annotation");
                    return new AnnotationValue(deserializeAnnotation(annotation, nameResolver));
                case 13:
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                    Intrinsics.checkExpressionValueIsNotNull(arrayElementList, "value.arrayElementList");
                    List<ProtoBuf.Annotation.Argument.Value> list = arrayElementList;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (T t : list) {
                        SimpleType anyType = getBuiltIns().getAnyType();
                        Intrinsics.checkExpressionValueIsNotNull(anyType, "builtIns.anyType");
                        Intrinsics.checkExpressionValueIsNotNull(t, "it");
                        arrayList.add(resolveValue(anyType, t, nameResolver));
                    }
                    return constantValueFactory.createArrayValue(arrayList, kotlinType);
            }
        }
        throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + kotlinType + ')').toString());
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> constantValue, KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value) {
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
            if (i == 1) {
                ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
                if (!(declarationDescriptor instanceof ClassDescriptor)) {
                    declarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                if (classDescriptor == null || KotlinBuiltIns.isKClass(classDescriptor)) {
                    return true;
                }
                return false;
            } else if (i == 2) {
                if ((constantValue instanceof ArrayValue) && ((List) ((ArrayValue) constantValue).getValue()).size() == value.getArrayElementList().size()) {
                    KotlinType arrayElementType = getBuiltIns().getArrayElementType(kotlinType);
                    Intrinsics.checkExpressionValueIsNotNull(arrayElementType, "builtIns.getArrayElementType(expectedType)");
                    ArrayValue arrayValue = (ArrayValue) constantValue;
                    IntRange indices = CollectionsKt.getIndices((Collection) arrayValue.getValue());
                    if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                        Iterator it = indices.iterator();
                        while (it.hasNext()) {
                            int nextInt = ((IntIterator) it).nextInt();
                            ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                            Intrinsics.checkExpressionValueIsNotNull(arrayElement, "value.getArrayElement(i)");
                            if (!doesValueConformToExpectedType((ConstantValue) ((List) arrayValue.getValue()).get(nextInt), arrayElementType, arrayElement)) {
                                return false;
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + constantValue).toString());
                }
            }
            return true;
        }
        return Intrinsics.areEqual(constantValue.getType(this.module), kotlinType);
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }
}
