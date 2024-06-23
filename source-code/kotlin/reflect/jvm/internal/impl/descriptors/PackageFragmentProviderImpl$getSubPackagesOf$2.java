package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
final class PackageFragmentProviderImpl$getSubPackagesOf$2 extends Lambda implements Function1<en0, Boolean> {
    final /* synthetic */ en0 $fqName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PackageFragmentProviderImpl$getSubPackagesOf$2(en0 en0) {
        super(1);
        this.$fqName = en0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(en0 en0) {
        return Boolean.valueOf(invoke(en0));
    }

    public final boolean invoke(@NotNull en0 en0) {
        k21.i(en0, AdvanceSetting.NETWORK_TYPE);
        return !en0.d() && k21.d(en0.e(), this.$fqName);
    }
}
