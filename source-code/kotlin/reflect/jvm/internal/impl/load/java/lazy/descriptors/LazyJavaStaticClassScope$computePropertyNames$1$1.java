package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
final class LazyJavaStaticClassScope$computePropertyNames$1$1 extends Lambda implements Function1<MemberScope, Collection<? extends og1>> {
    public static final LazyJavaStaticClassScope$computePropertyNames$1$1 INSTANCE = new LazyJavaStaticClassScope$computePropertyNames$1$1();

    LazyJavaStaticClassScope$computePropertyNames$1$1() {
        super(1);
    }

    @NotNull
    public final Collection<og1> invoke(@NotNull MemberScope memberScope) {
        k21.i(memberScope, AdvanceSetting.NETWORK_TYPE);
        return memberScope.getVariableNames();
    }
}
