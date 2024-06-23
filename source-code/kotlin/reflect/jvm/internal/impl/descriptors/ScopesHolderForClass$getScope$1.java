package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.i61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ScopesHolderForClass$getScope$1 extends Lambda implements Function0<T> {
    final /* synthetic */ i61 $kotlinTypeRefiner;
    final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScopesHolderForClass$getScope$1(ScopesHolderForClass<T> scopesHolderForClass, i61 i61) {
        super(0);
        this.this$0 = scopesHolderForClass;
        this.$kotlinTypeRefiner = i61;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final T invoke() {
        return (T) ((MemberScope) ScopesHolderForClass.b(this.this$0).invoke(this.$kotlinTypeRefiner));
    }
}
