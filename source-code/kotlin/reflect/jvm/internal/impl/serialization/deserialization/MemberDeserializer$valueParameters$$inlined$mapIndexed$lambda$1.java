package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* access modifiers changed from: package-private */
/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ MessageLite $callable$inlined;
    final /* synthetic */ CallableDescriptor $callableDescriptor$inlined;
    final /* synthetic */ ProtoContainer $containerOfCallable$inlined;
    final /* synthetic */ int $i;
    final /* synthetic */ AnnotatedCallableKind $kind$inlined;
    final /* synthetic */ ProtoBuf.ValueParameter $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1(int i, ProtoBuf.ValueParameter valueParameter, MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, CallableDescriptor callableDescriptor) {
        super(0);
        this.$i = i;
        this.$proto = valueParameter;
        this.this$0 = memberDeserializer;
        this.$containerOfCallable$inlined = protoContainer;
        this.$callable$inlined = messageLite;
        this.$kind$inlined = annotatedCallableKind;
        this.$callableDescriptor$inlined = callableDescriptor;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends AnnotationDescriptor> invoke() {
        return CollectionsKt.toList(this.this$0.c.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.$containerOfCallable$inlined, this.$callable$inlined, this.$kind$inlined, this.$i, this.$proto));
    }
}
