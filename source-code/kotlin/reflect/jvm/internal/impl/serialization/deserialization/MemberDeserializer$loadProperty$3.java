package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.gv1;
import tb.k21;
import tb.om;
import tb.r60;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class MemberDeserializer$loadProperty$3 extends Lambda implements Function0<om<?>> {
    final /* synthetic */ r60 $property;
    final /* synthetic */ ProtoBuf$Property $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberDeserializer$loadProperty$3(MemberDeserializer memberDeserializer, ProtoBuf$Property protoBuf$Property, r60 r60) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = protoBuf$Property;
        this.$property = r60;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final om<?> invoke() {
        MemberDeserializer memberDeserializer = this.this$0;
        gv1 gv1 = memberDeserializer.c(memberDeserializer.a.e());
        k21.f(gv1);
        AnnotationAndConstantLoader<AnnotationDescriptor, om<?>> d = this.this$0.a.c().d();
        ProtoBuf$Property protoBuf$Property = this.$proto;
        g61 returnType = this.$property.getReturnType();
        k21.h(returnType, "property.returnType");
        return d.loadPropertyConstant(gv1, protoBuf$Property, returnType);
    }
}
