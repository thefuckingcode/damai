package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
final class PackageFragmentProviderImpl$getSubPackagesOf$1 extends Lambda implements Function1<PackageFragmentDescriptor, en0> {
    public static final PackageFragmentProviderImpl$getSubPackagesOf$1 INSTANCE = new PackageFragmentProviderImpl$getSubPackagesOf$1();

    PackageFragmentProviderImpl$getSubPackagesOf$1() {
        super(1);
    }

    @NotNull
    public final en0 invoke(@NotNull PackageFragmentDescriptor packageFragmentDescriptor) {
        k21.i(packageFragmentDescriptor, AdvanceSetting.NETWORK_TYPE);
        return packageFragmentDescriptor.getFqName();
    }
}
