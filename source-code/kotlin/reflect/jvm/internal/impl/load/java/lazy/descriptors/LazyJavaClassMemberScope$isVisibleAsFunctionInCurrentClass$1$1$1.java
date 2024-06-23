package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 extends Lambda implements Function1<og1, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ SimpleFunctionDescriptor $function;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.$function = simpleFunctionDescriptor;
        this.this$0 = lazyJavaClassMemberScope;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull og1 og1) {
        k21.i(og1, "accessorName");
        if (k21.d(this.$function.getName(), og1)) {
            return l.e(this.$function);
        }
        return CollectionsKt___CollectionsKt.k0(this.this$0.A0(og1), this.this$0.B0(og1));
    }
}
