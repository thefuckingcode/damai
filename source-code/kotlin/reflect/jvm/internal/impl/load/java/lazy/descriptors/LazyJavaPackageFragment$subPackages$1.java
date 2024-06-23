package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;
import tb.en0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaPackageFragment$subPackages$1 extends Lambda implements Function0<List<? extends en0>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageFragment$subPackages$1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    /* Return type fixed from 'java.util.List<tb.en0>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends en0> invoke() {
        Collection<JavaPackage> subPackages = this.this$0.f.getSubPackages();
        ArrayList arrayList = new ArrayList(n.q(subPackages, 10));
        Iterator<T> it = subPackages.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFqName());
        }
        return arrayList;
    }
}
