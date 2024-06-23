package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m60;
import tb.og1;
import tb.zd0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 extends Lambda implements Function1<og1, ClassDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;
    final /* synthetic */ DeserializedClassDescriptor this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors, DeserializedClassDescriptor deserializedClassDescriptor) {
        super(1);
        this.this$0 = enumEntryClassDescriptors;
        this.this$1 = deserializedClassDescriptor;
    }

    @Nullable
    public final ClassDescriptor invoke(@NotNull og1 og1) {
        k21.i(og1, "name");
        ProtoBuf$EnumEntry protoBuf$EnumEntry = (ProtoBuf$EnumEntry) this.this$0.a.get(og1);
        if (protoBuf$EnumEntry == null) {
            return null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$1;
        return zd0.f(deserializedClassDescriptor.q().h(), deserializedClassDescriptor, og1, this.this$0.c, new m60(deserializedClassDescriptor.q().h(), new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1(deserializedClassDescriptor, protoBuf$EnumEntry)), SourceElement.NO_SOURCE);
    }
}
