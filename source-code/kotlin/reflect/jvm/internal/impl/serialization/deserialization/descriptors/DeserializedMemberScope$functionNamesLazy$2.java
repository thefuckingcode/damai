package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* access modifiers changed from: package-private */
/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$functionNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$functionNamesLazy$2(DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = deserializedMemberScope;
    }

    /* Return type fixed from 'java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Set<? extends Name> invoke() {
        return SetsKt.plus(this.this$0.functionProtosBytes.keySet(), (Iterable) this.this$0.getNonDeclaredFunctionNames());
    }
}
