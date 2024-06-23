package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.gv1;

/* compiled from: Taobao */
public interface AnnotationAndConstantLoader<A, C> {
    @NotNull
    List<A> loadCallableAnnotations(@NotNull gv1 gv1, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> loadClassAnnotations(@NotNull gv1.a aVar);

    @NotNull
    List<A> loadEnumEntryAnnotations(@NotNull gv1 gv1, @NotNull ProtoBuf$EnumEntry protoBuf$EnumEntry);

    @NotNull
    List<A> loadExtensionReceiverParameterAnnotations(@NotNull gv1 gv1, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> loadPropertyBackingFieldAnnotations(@NotNull gv1 gv1, @NotNull ProtoBuf$Property protoBuf$Property);

    @Nullable
    C loadPropertyConstant(@NotNull gv1 gv1, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull g61 g61);

    @NotNull
    List<A> loadPropertyDelegateFieldAnnotations(@NotNull gv1 gv1, @NotNull ProtoBuf$Property protoBuf$Property);

    @NotNull
    List<A> loadTypeAnnotations(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf$TypeParameter protoBuf$TypeParameter, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadValueParameterAnnotations(@NotNull gv1 gv1, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind, int i, @NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter);
}
