package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1 extends Lambda implements Function0<Set<? extends og1>> {
    final /* synthetic */ DeserializedClassDescriptor.EnumEntryClassDescriptors this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors) {
        super(0);
        this.this$0 = enumEntryClassDescriptors;
    }

    /* Return type fixed from 'java.util.Set<tb.og1>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Set<? extends og1> invoke() {
        return this.this$0.e();
    }
}
