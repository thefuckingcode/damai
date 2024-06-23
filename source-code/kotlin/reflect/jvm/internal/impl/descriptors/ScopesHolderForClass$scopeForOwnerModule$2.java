package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class ScopesHolderForClass$scopeForOwnerModule$2 extends Lambda implements Function0<T> {
    final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScopesHolderForClass$scopeForOwnerModule$2(ScopesHolderForClass<T> scopesHolderForClass) {
        super(0);
        this.this$0 = scopesHolderForClass;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final T invoke() {
        return (T) ((MemberScope) ScopesHolderForClass.b(this.this$0).invoke(ScopesHolderForClass.a(this.this$0)));
    }
}
