package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import org.jetbrains.annotations.NotNull;
import tb.gv1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class MemberDeserializer$getPropertyFieldAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ boolean $isDelegate;
    final /* synthetic */ ProtoBuf$Property $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberDeserializer$getPropertyFieldAnnotations$1(MemberDeserializer memberDeserializer, boolean z, ProtoBuf$Property protoBuf$Property) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$isDelegate = z;
        this.$proto = protoBuf$Property;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends AnnotationDescriptor> invoke() {
        List<AnnotationDescriptor> list;
        MemberDeserializer memberDeserializer = this.this$0;
        gv1 gv1 = memberDeserializer.c(memberDeserializer.a.e());
        if (gv1 == null) {
            list = null;
        } else {
            boolean z = this.$isDelegate;
            MemberDeserializer memberDeserializer2 = this.this$0;
            ProtoBuf$Property protoBuf$Property = this.$proto;
            if (z) {
                list = CollectionsKt___CollectionsKt.y0(memberDeserializer2.a.c().d().loadPropertyDelegateFieldAnnotations(gv1, protoBuf$Property));
            } else {
                list = CollectionsKt___CollectionsKt.y0(memberDeserializer2.a.c().d().loadPropertyBackingFieldAnnotations(gv1, protoBuf$Property));
            }
        }
        return list != null ? list : m.g();
    }
}
