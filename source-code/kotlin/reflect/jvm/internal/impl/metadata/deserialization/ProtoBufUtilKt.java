package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: ProtoBufUtil.kt */
public final class ProtoBufUtilKt {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<M extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<M>, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T getExtensionOrNull(GeneratedMessageLite.ExtendableMessage<M> extendableMessage, GeneratedMessageLite.GeneratedExtension<M, T> generatedExtension) {
        Intrinsics.checkParameterIsNotNull(extendableMessage, "$this$getExtensionOrNull");
        Intrinsics.checkParameterIsNotNull(generatedExtension, "extension");
        if (extendableMessage.hasExtension(generatedExtension)) {
            return (T) extendableMessage.getExtension(generatedExtension);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<M extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<M>, java.util.List<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T getExtensionOrNull(GeneratedMessageLite.ExtendableMessage<M> extendableMessage, GeneratedMessageLite.GeneratedExtension<M, List<T>> generatedExtension, int i) {
        Intrinsics.checkParameterIsNotNull(extendableMessage, "$this$getExtensionOrNull");
        Intrinsics.checkParameterIsNotNull(generatedExtension, "extension");
        if (i < extendableMessage.getExtensionCount(generatedExtension)) {
            return (T) extendableMessage.getExtension(generatedExtension, i);
        }
        return null;
    }
}
