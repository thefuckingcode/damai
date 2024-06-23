package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: CompositePackageFragmentProvider.kt */
public final class CompositePackageFragmentProvider implements PackageFragmentProvider {
    private final List<PackageFragmentProvider> providers;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> list) {
        Intrinsics.checkParameterIsNotNull(list, "providers");
        this.providers = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (PackageFragmentProvider packageFragmentProvider : this.providers) {
            arrayList.addAll(packageFragmentProvider.getPackageFragments(fqName));
        }
        return CollectionsKt.toList(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        for (PackageFragmentProvider packageFragmentProvider : this.providers) {
            hashSet.addAll(packageFragmentProvider.getSubPackagesOf(fqName, function1));
        }
        return hashSet;
    }
}
