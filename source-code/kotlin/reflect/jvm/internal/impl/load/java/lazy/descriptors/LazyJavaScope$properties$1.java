package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.f60;
import tb.k21;
import tb.og1;
import tb.qj;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaScope$properties$1 extends Lambda implements Function1<og1, List<? extends PropertyDescriptor>> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaScope$properties$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @NotNull
    public final List<PropertyDescriptor> invoke(@NotNull og1 og1) {
        k21.i(og1, "name");
        ArrayList arrayList = new ArrayList();
        qj.a(arrayList, this.this$0.f.invoke(og1));
        this.this$0.l(og1, arrayList);
        if (f60.t(this.this$0.v())) {
            return CollectionsKt___CollectionsKt.y0(arrayList);
        }
        return CollectionsKt___CollectionsKt.y0(this.this$0.p().a().q().e(this.this$0.p(), arrayList));
    }
}
