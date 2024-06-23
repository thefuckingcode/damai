package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.d2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyScopeAdapter$lazyScope$1 extends Lambda implements Function0<MemberScope> {
    final /* synthetic */ Function0<MemberScope> $getScope;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function0<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyScopeAdapter$lazyScope$1(Function0<? extends MemberScope> function0) {
        super(0);
        this.$getScope = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final MemberScope invoke() {
        MemberScope invoke = this.$getScope.invoke();
        return invoke instanceof d2 ? ((d2) invoke).a() : invoke;
    }
}
