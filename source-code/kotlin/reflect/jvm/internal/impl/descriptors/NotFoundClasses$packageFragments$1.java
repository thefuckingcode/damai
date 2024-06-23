package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;
import tb.kd0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class NotFoundClasses$packageFragments$1 extends Lambda implements Function1<en0, PackageFragmentDescriptor> {
    final /* synthetic */ NotFoundClasses this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotFoundClasses$packageFragments$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.this$0 = notFoundClasses;
    }

    @NotNull
    public final PackageFragmentDescriptor invoke(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return new kd0(this.this$0.b, en0);
    }
}
