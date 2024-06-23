package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaClassMemberScope$nestedClassIndex$1 extends Lambda implements Function0<Set<? extends og1>> {
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$nestedClassIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
    }

    /* Return type fixed from 'java.util.Set<tb.og1>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Set<? extends og1> invoke() {
        return CollectionsKt___CollectionsKt.C0(this.this$0.n.getInnerClassNames());
    }
}
