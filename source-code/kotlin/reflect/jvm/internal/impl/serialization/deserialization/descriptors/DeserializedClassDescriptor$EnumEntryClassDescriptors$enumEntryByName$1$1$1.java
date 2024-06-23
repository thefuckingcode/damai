package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ ProtoBuf$EnumEntry $proto;
    final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(DeserializedClassDescriptor deserializedClassDescriptor, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
        this.$proto = protoBuf$EnumEntry;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends AnnotationDescriptor> invoke() {
        return CollectionsKt___CollectionsKt.y0(this.this$0.q().c().d().loadEnumEntryAnnotations(this.this$0.v(), this.$proto));
    }
}
