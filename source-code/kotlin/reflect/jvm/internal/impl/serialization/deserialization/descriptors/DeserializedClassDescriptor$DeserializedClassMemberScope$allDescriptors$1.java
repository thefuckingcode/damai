package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b60;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    final /* synthetic */ DeserializedClassDescriptor.DeserializedClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
        super(0);
        this.this$0 = deserializedClassMemberScope;
    }

    /* Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Collection<? extends DeclarationDescriptor> invoke() {
        return this.this$0.d(b60.ALL, MemberScope.Companion.a(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
    }
}
