package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.x61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaPackageScope$knownClassNamesInPackage$1 extends Lambda implements Function0<Set<? extends String>> {
    final /* synthetic */ x61 $c;
    final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageScope$knownClassNamesInPackage$1(x61 x61, LazyJavaPackageScope lazyJavaPackageScope) {
        super(0);
        this.$c = x61;
        this.this$0 = lazyJavaPackageScope;
    }

    /* Return type fixed from 'java.util.Set<java.lang.String>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Set<? extends String> invoke() {
        return this.$c.a().d().knownClassNamesInPackage(this.this$0.v().getFqName());
    }
}
