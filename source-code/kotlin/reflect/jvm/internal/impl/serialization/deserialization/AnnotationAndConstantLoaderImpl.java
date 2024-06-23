package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationAndConstantLoaderImpl.kt */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer deserializer;
    private final SerializerExtensionProtocol protocol;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
        }
    }

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses, SerializerExtensionProtocol serializerExtensionProtocol) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        Intrinsics.checkParameterIsNotNull(serializerExtensionProtocol, "protocol");
        this.protocol = serializerExtensionProtocol;
        this.deserializer = new AnnotationDeserializer(moduleDescriptor, notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.Class r6) {
        Intrinsics.checkParameterIsNotNull(r6, "container");
        List list = (List) r6.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProtoBuf.Annotation annotation : list2) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, r6.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        List list;
        Intrinsics.checkParameterIsNotNull(protoContainer, "container");
        Intrinsics.checkParameterIsNotNull(messageLite, "proto");
        Intrinsics.checkParameterIsNotNull(annotatedCallableKind, "kind");
        if (messageLite instanceof ProtoBuf.Constructor) {
            list = (List) ((ProtoBuf.Constructor) messageLite).getExtension(this.protocol.getConstructorAnnotation());
        } else if (messageLite instanceof ProtoBuf.Function) {
            list = (List) ((ProtoBuf.Function) messageLite).getExtension(this.protocol.getFunctionAnnotation());
        } else if (messageLite instanceof ProtoBuf.Property) {
            int i = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i == 1) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertyAnnotation());
            } else if (i == 2) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertyGetterAnnotation());
            } else if (i == 3) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.protocol.getPropertySetterAnnotation());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        } else {
            throw new IllegalStateException(("Unknown message: " + messageLite).toString());
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProtoBuf.Annotation annotation : list2) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property) {
        Intrinsics.checkParameterIsNotNull(protoContainer, "container");
        Intrinsics.checkParameterIsNotNull(property, "proto");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property) {
        Intrinsics.checkParameterIsNotNull(protoContainer, "container");
        Intrinsics.checkParameterIsNotNull(property, "proto");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf.EnumEntry enumEntry) {
        Intrinsics.checkParameterIsNotNull(protoContainer, "container");
        Intrinsics.checkParameterIsNotNull(enumEntry, "proto");
        List list = (List) enumEntry.getExtension(this.protocol.getEnumEntryAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProtoBuf.Annotation annotation : list2) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf.ValueParameter valueParameter) {
        Intrinsics.checkParameterIsNotNull(protoContainer, "container");
        Intrinsics.checkParameterIsNotNull(messageLite, "callableProto");
        Intrinsics.checkParameterIsNotNull(annotatedCallableKind, "kind");
        Intrinsics.checkParameterIsNotNull(valueParameter, "proto");
        List list = (List) valueParameter.getExtension(this.protocol.getParameterAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProtoBuf.Annotation annotation : list2) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, protoContainer.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkParameterIsNotNull(protoContainer, "container");
        Intrinsics.checkParameterIsNotNull(messageLite, "proto");
        Intrinsics.checkParameterIsNotNull(annotatedCallableKind, "kind");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadTypeAnnotations(ProtoBuf.Type type, NameResolver nameResolver) {
        Intrinsics.checkParameterIsNotNull(type, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        List list = (List) type.getExtension(this.protocol.getTypeAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProtoBuf.Annotation annotation : list2) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(ProtoBuf.TypeParameter typeParameter, NameResolver nameResolver) {
        Intrinsics.checkParameterIsNotNull(typeParameter, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        List list = (List) typeParameter.getExtension(this.protocol.getTypeParameterAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ProtoBuf.Annotation> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ProtoBuf.Annotation annotation : list2) {
            arrayList.add(this.deserializer.deserializeAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public ConstantValue<?> loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(protoContainer, "container");
        Intrinsics.checkParameterIsNotNull(property, "proto");
        Intrinsics.checkParameterIsNotNull(kotlinType, "expectedType");
        ProtoBuf.Annotation.Argument.Value value = (ProtoBuf.Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(property, this.protocol.getCompileTimeValue());
        if (value != null) {
            return this.deserializer.resolveValue(kotlinType, value, protoContainer.getNameResolver());
        }
        return null;
    }
}
