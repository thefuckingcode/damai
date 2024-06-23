package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$typeAliasByName$1 extends Lambda implements Function1<Name, TypeAliasDescriptor> {
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$typeAliasByName$1(DeserializedMemberScope deserializedMemberScope) {
        super(1);
        this.this$0 = deserializedMemberScope;
    }

    public final TypeAliasDescriptor invoke(Name name) {
        Intrinsics.checkParameterIsNotNull(name, "it");
        return this.this$0.createTypeAlias(name);
    }
}
