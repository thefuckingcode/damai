package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.k21;
import tb.p60;

/* compiled from: Taobao */
final class AbstractDeserializedPackageFragmentProvider$fragments$1 extends Lambda implements Function1<en0, PackageFragmentDescriptor> {
    final /* synthetic */ AbstractDeserializedPackageFragmentProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractDeserializedPackageFragmentProvider$fragments$1(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider) {
        super(1);
        this.this$0 = abstractDeserializedPackageFragmentProvider;
    }

    @Nullable
    public final PackageFragmentDescriptor invoke(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        p60 a = this.this$0.a(en0);
        if (a == null) {
            return null;
        }
        a.f(this.this$0.b());
        return a;
    }
}
