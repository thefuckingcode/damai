package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedMemberScope$OptimizedImplementation$functionNames$2 extends Lambda implements Function0<Set<? extends og1>> {
    final /* synthetic */ DeserializedMemberScope.OptimizedImplementation this$0;
    final /* synthetic */ DeserializedMemberScope this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$OptimizedImplementation$functionNames$2(DeserializedMemberScope.OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = optimizedImplementation;
        this.this$1 = deserializedMemberScope;
    }

    /* Return type fixed from 'java.util.Set<tb.og1>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Set<? extends og1> invoke() {
        return f0.i(this.this$0.a.keySet(), this.this$1.n());
    }
}
