package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class rl implements PackageFragmentProviderOptimized {
    @NotNull
    private final List<PackageFragmentProvider> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider> */
    /* JADX WARN: Multi-variable type inference failed */
    public rl(@NotNull List<? extends PackageFragmentProvider> list) {
        k21.i(list, "providers");
        this.a = list;
        list.size();
        CollectionsKt___CollectionsKt.C0(list).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull en0 en0, @NotNull Collection<PackageFragmentDescriptor> collection) {
        k21.i(en0, "fqName");
        k21.i(collection, "packageFragments");
        for (PackageFragmentProvider packageFragmentProvider : this.a) {
            jn1.a(packageFragmentProvider, en0, collection);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        ArrayList arrayList = new ArrayList();
        for (PackageFragmentProvider packageFragmentProvider : this.a) {
            jn1.a(packageFragmentProvider, en0, arrayList);
        }
        return CollectionsKt___CollectionsKt.y0(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<en0> getSubPackagesOf(@NotNull en0 en0, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(en0, "fqName");
        k21.i(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        for (PackageFragmentProvider packageFragmentProvider : this.a) {
            hashSet.addAll(packageFragmentProvider.getSubPackagesOf(en0, function1));
        }
        return hashSet;
    }
}
