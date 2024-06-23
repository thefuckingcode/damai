package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* access modifiers changed from: package-private */
/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ Name $name$inlined;
    final /* synthetic */ ProtoBuf.EnumEntry $proto;
    final /* synthetic */ DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1(ProtoBuf.EnumEntry enumEntry, DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 deserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1, Name name) {
        super(0);
        this.$proto = enumEntry;
        this.this$0 = deserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1;
        this.$name$inlined = name;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends AnnotationDescriptor> invoke() {
        return CollectionsKt.toList(DeserializedClassDescriptor.this.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(DeserializedClassDescriptor.this.getThisAsProtoContainer$deserialization(), this.$proto));
    }
}
