package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.b60;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaScope$classNamesLazy$2 extends Lambda implements Function0<Set<? extends og1>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaScope$classNamesLazy$2(LazyJavaScope lazyJavaScope) {
        super(0);
        this.this$0 = lazyJavaScope;
    }

    /* Return type fixed from 'java.util.Set<tb.og1>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Set<? extends og1> invoke() {
        return this.this$0.e(b60.CLASSIFIERS, null);
    }
}
