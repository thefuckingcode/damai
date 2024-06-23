package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import tb.gv1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class MemberDeserializer$valueParameters$1$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ MessageLite $callable;
    final /* synthetic */ gv1 $containerOfCallable;
    final /* synthetic */ int $i;
    final /* synthetic */ AnnotatedCallableKind $kind;
    final /* synthetic */ ProtoBuf$ValueParameter $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberDeserializer$valueParameters$1$annotations$1(MemberDeserializer memberDeserializer, gv1 gv1, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$containerOfCallable = gv1;
        this.$callable = messageLite;
        this.$kind = annotatedCallableKind;
        this.$i = i;
        this.$proto = protoBuf$ValueParameter;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends AnnotationDescriptor> invoke() {
        return CollectionsKt___CollectionsKt.y0(this.this$0.a.c().d().loadValueParameterAnnotations(this.$containerOfCallable, this.$callable, this.$kind, this.$i, this.$proto));
    }
}
