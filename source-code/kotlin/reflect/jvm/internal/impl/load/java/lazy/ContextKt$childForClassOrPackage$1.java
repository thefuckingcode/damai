package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.x61;

/* compiled from: Taobao */
final class ContextKt$childForClassOrPackage$1 extends Lambda implements Function0<b41> {
    final /* synthetic */ ClassOrPackageFragmentDescriptor $containingDeclaration;
    final /* synthetic */ x61 $this_childForClassOrPackage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextKt$childForClassOrPackage$1(x61 x61, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor) {
        super(0);
        this.$this_childForClassOrPackage = x61;
        this.$containingDeclaration = classOrPackageFragmentDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final b41 invoke() {
        return ContextKt.g(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
    }
}
