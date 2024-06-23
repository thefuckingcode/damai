package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fv1 {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<M extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<M>, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T a(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.c<M, T> cVar) {
        k21.i(extendableMessage, "<this>");
        k21.i(cVar, "extension");
        if (extendableMessage.hasExtension(cVar)) {
            return (T) extendableMessage.getExtension(cVar);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$c<M extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<M>, java.util.List<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T b(@NotNull GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @NotNull GeneratedMessageLite.c<M, List<T>> cVar, int i) {
        k21.i(extendableMessage, "<this>");
        k21.i(cVar, "extension");
        if (i < extendableMessage.getExtensionCount(cVar)) {
            return (T) extendableMessage.getExtension(cVar, i);
        }
        return null;
    }
}
