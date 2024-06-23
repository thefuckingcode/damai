package kotlin.collections;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.bl;

/* compiled from: Taobao */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements Function1<Object, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ Function1<Object, Comparable> $selector;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1<Object, Comparable> function1, Comparable comparable) {
        super(1);
        this.$selector = function1;
        this.$key = comparable;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Integer invoke(Object obj) {
        return Integer.valueOf(bl.a(this.$selector.invoke(obj), this.$key));
    }
}
