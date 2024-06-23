package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 extends Lambda implements Function0<Collection<? extends g61>> {
    final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(0);
        this.this$0 = deserializedClassMemberScope;
    }

    /* Return type fixed from 'java.util.Collection<tb.g61>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Collection<? extends g61> invoke() {
        return this.this$0.f.f(this.this$0.v());
    }
}
