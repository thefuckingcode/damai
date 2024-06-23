package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
final class LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1 extends Lambda implements Function1<MemberScope, Collection<? extends PropertyDescriptor>> {
    final /* synthetic */ og1 $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(og1 og1) {
        super(1);
        this.$name = og1;
    }

    @NotNull
    public final Collection<? extends PropertyDescriptor> invoke(@NotNull MemberScope memberScope) {
        k21.i(memberScope, AdvanceSetting.NETWORK_TYPE);
        return memberScope.getContributedVariables(this.$name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }
}
