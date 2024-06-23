package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.ev2;

/* compiled from: Taobao */
public interface DeserializedCallableMemberDescriptor extends CallableMemberDescriptor, DeserializedMemberDescriptor {

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static List<ev2> a(@NotNull DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor) {
            return DeserializedMemberDescriptor.a.a(deserializedCallableMemberDescriptor);
        }
    }
}
