package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.nd;
import tb.og1;

/* compiled from: Taobao */
public final class ClassicBuiltinSpecialProperties {
    @NotNull
    public static final ClassicBuiltinSpecialProperties INSTANCE = new ClassicBuiltinSpecialProperties();

    private ClassicBuiltinSpecialProperties() {
    }

    private final boolean c(CallableMemberDescriptor callableMemberDescriptor) {
        if ((CollectionsKt___CollectionsKt.J(nd.INSTANCE.c(), DescriptorUtilsKt.e(callableMemberDescriptor))) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (!b.e0(callableMemberDescriptor)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        k21.h(overriddenDescriptors, "overriddenDescriptors");
        if (!overriddenDescriptors.isEmpty()) {
            for (T t : overriddenDescriptors) {
                k21.h(t, AdvanceSetting.NETWORK_TYPE);
                if (b(t)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final String a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        og1 og1;
        k21.i(callableMemberDescriptor, "<this>");
        b.e0(callableMemberDescriptor);
        CallableMemberDescriptor d = DescriptorUtilsKt.d(DescriptorUtilsKt.o(callableMemberDescriptor), false, new ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1(this), 1, null);
        if (d == null || (og1 = nd.INSTANCE.a().get(DescriptorUtilsKt.i(d))) == null) {
            return null;
        }
        return og1.b();
    }

    public final boolean b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, "callableMemberDescriptor");
        if (!nd.INSTANCE.d().contains(callableMemberDescriptor.getName())) {
            return false;
        }
        return c(callableMemberDescriptor);
    }
}
