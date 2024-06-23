package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class jn1 {
    public static final void a(@NotNull PackageFragmentProvider packageFragmentProvider, @NotNull en0 en0, @NotNull Collection<PackageFragmentDescriptor> collection) {
        k21.i(packageFragmentProvider, "<this>");
        k21.i(en0, "fqName");
        k21.i(collection, "packageFragments");
        if (packageFragmentProvider instanceof PackageFragmentProviderOptimized) {
            ((PackageFragmentProviderOptimized) packageFragmentProvider).collectPackageFragments(en0, collection);
        } else {
            collection.addAll(packageFragmentProvider.getPackageFragments(en0));
        }
    }

    @NotNull
    public static final List<PackageFragmentDescriptor> b(@NotNull PackageFragmentProvider packageFragmentProvider, @NotNull en0 en0) {
        k21.i(packageFragmentProvider, "<this>");
        k21.i(en0, "fqName");
        ArrayList arrayList = new ArrayList();
        a(packageFragmentProvider, en0, arrayList);
        return arrayList;
    }
}
