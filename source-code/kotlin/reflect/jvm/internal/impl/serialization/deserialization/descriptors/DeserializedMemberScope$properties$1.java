package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$properties$1 extends Lambda implements Function1<Name, Collection<? extends PropertyDescriptor>> {
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$properties$1(DeserializedMemberScope deserializedMemberScope) {
        super(1);
        this.this$0 = deserializedMemberScope;
    }

    public final Collection<PropertyDescriptor> invoke(Name name) {
        Intrinsics.checkParameterIsNotNull(name, "it");
        return this.this$0.computeProperties(name);
    }
}
