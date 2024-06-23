package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$1 extends Lambda implements Function0<M> {
    final /* synthetic */ ByteArrayInputStream $inputStream;
    final /* synthetic */ Parser $parser$inlined;
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$1(ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope, Parser parser) {
        super(0);
        this.$inputStream = byteArrayInputStream;
        this.this$0 = deserializedMemberScope;
        this.$parser$inlined = parser;
    }

    @Override // kotlin.jvm.functions.Function0
    public final M invoke() {
        return (M) ((MessageLite) this.$parser$inlined.parseDelimitedFrom(this.$inputStream, this.this$0.getC().getComponents().getExtensionRegistryLite()));
    }
}
