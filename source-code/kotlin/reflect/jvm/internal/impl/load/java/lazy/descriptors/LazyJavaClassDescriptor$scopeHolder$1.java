package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.i61;
import tb.k21;
import tb.x61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaClassDescriptor$scopeHolder$1 extends Lambda implements Function1<i61, LazyJavaClassMemberScope> {
    final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassDescriptor$scopeHolder$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(1);
        this.this$0 = lazyJavaClassDescriptor;
    }

    @NotNull
    public final LazyJavaClassMemberScope invoke(@NotNull i61 i61) {
        k21.i(i61, AdvanceSetting.NETWORK_TYPE);
        x61 x61 = this.this$0.k;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.this$0;
        return new LazyJavaClassMemberScope(x61, lazyJavaClassDescriptor, lazyJavaClassDescriptor.j(), this.this$0.j != null, this.this$0.q);
    }
}
