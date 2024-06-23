package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
final class LazyJavaClassMemberScope$computeNonDeclaredProperties$2 extends Lambda implements Function1<og1, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$computeNonDeclaredProperties$2(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull og1 og1) {
        k21.i(og1, AdvanceSetting.NETWORK_TYPE);
        return this.this$0.B0(og1);
    }
}
