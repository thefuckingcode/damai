package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.qg2;
import tb.sg;

/* compiled from: Taobao */
final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements Function0<MemberScope> {
    final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final MemberScope invoke() {
        if (this.this$0.getFragments().isEmpty()) {
            return MemberScope.b.INSTANCE;
        }
        List<PackageFragmentDescriptor> fragments = this.this$0.getFragments();
        ArrayList arrayList = new ArrayList(n.q(fragments, 10));
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMemberScope());
        }
        List list = CollectionsKt___CollectionsKt.l0(arrayList, new qg2(this.this$0.getModule(), this.this$0.getFqName()));
        sg.a aVar = sg.Companion;
        return aVar.a("package view scope for " + this.this$0.getFqName() + " in " + this.this$0.getModule().getName(), list);
    }
}
