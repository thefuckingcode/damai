package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.jn1;

/* compiled from: Taobao */
final class LazyPackageViewDescriptorImpl$fragments$2 extends Lambda implements Function0<List<? extends PackageFragmentDescriptor>> {
    final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyPackageViewDescriptorImpl$fragments$2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends PackageFragmentDescriptor> invoke() {
        return jn1.b(this.this$0.getModule().j(), this.this$0.getFqName());
    }
}
