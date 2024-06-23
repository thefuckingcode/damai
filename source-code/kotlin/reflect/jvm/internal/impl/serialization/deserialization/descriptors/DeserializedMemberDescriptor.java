package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.ev2;
import tb.fv2;
import tb.k21;

/* compiled from: Taobao */
public interface DeserializedMemberDescriptor extends DeserializedDescriptor, MemberDescriptor, DescriptorWithContainerSource {

    /* compiled from: Taobao */
    public enum CoroutinesCompatibilityMode {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE
    }

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static List<ev2> a(@NotNull DeserializedMemberDescriptor deserializedMemberDescriptor) {
            k21.i(deserializedMemberDescriptor, "this");
            return ev2.Companion.a(deserializedMemberDescriptor.getProto(), deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getVersionRequirementTable());
        }
    }

    @Nullable
    DeserializedContainerSource getContainerSource();

    @NotNull
    NameResolver getNameResolver();

    @NotNull
    MessageLite getProto();

    @NotNull
    ap2 getTypeTable();

    @NotNull
    fv2 getVersionRequirementTable();

    @NotNull
    List<ev2> getVersionRequirements();
}
