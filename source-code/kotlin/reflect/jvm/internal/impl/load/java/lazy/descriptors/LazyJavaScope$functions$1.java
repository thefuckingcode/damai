package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaScope$functions$1 extends Lambda implements Function1<og1, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaScope$functions$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull og1 og1) {
        k21.i(og1, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) this.this$0.e.invoke(og1));
        this.this$0.E(linkedHashSet);
        this.this$0.k(linkedHashSet, og1);
        return CollectionsKt___CollectionsKt.y0(this.this$0.p().a().q().e(this.this$0.p(), linkedHashSet));
    }
}
