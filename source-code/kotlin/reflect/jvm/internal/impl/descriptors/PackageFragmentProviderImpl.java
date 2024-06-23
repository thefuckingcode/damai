package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    @NotNull
    private final Collection<PackageFragmentDescriptor> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(@NotNull Collection<? extends PackageFragmentDescriptor> collection) {
        k21.i(collection, "packageFragments");
        this.a = collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull en0 en0, @NotNull Collection<PackageFragmentDescriptor> collection) {
        k21.i(en0, "fqName");
        k21.i(collection, "packageFragments");
        for (PackageFragmentDescriptor packageFragmentDescriptor : this.a) {
            if (k21.d(packageFragmentDescriptor.getFqName(), en0)) {
                collection.add(packageFragmentDescriptor);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        Collection<PackageFragmentDescriptor> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            if (k21.d(t.getFqName(), en0)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<en0> getSubPackagesOf(@NotNull en0 en0, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(en0, "fqName");
        k21.i(function1, "nameFilter");
        return SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.o(SequencesKt___SequencesKt.v(CollectionsKt___CollectionsKt.I(this.a), PackageFragmentProviderImpl$getSubPackagesOf$1.INSTANCE), new PackageFragmentProviderImpl$getSubPackagesOf$2(en0)));
    }
}
