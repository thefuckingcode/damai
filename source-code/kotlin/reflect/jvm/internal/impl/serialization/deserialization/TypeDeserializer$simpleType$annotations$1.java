package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class TypeDeserializer$simpleType$annotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ ProtoBuf$Type $proto;
    final /* synthetic */ TypeDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeDeserializer$simpleType$annotations$1(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type) {
        super(0);
        this.this$0 = typeDeserializer;
        this.$proto = protoBuf$Type;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends AnnotationDescriptor> invoke() {
        return this.this$0.a.c().d().loadTypeAnnotations(this.$proto, this.this$0.a.g());
    }
}
