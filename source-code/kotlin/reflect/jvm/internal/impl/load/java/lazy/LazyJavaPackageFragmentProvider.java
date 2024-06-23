package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.youku.arch.v3.data.Constants;
import java.util.Collection;
import java.util.List;
import kotlin.c;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import tb.en0;
import tb.k21;
import tb.og1;
import tb.qj;
import tb.v31;
import tb.x61;

public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {
    private final x61 a;
    private final CacheWithNotNullValues<en0, LazyJavaPackageFragment> b;

    public LazyJavaPackageFragmentProvider(v31 v31) {
        k21.i(v31, Constants.COMPONENT);
        x61 x61 = new x61(v31, TypeParameterResolver.a.INSTANCE, c.c(null));
        this.a = x61;
        this.b = x61.e().createCacheWithNotNullValues();
    }

    private final LazyJavaPackageFragment b(en0 en0) {
        JavaPackage findPackage = this.a.a().d().findPackage(en0);
        if (findPackage == null) {
            return null;
        }
        return this.b.computeIfAbsent(en0, new LazyJavaPackageFragmentProvider$getPackageFragment$1(this, findPackage));
    }

    /* renamed from: c */
    public List<en0> getSubPackagesOf(en0 en0, Function1<? super og1, Boolean> function1) {
        k21.i(en0, "fqName");
        k21.i(function1, "nameFilter");
        LazyJavaPackageFragment b2 = b(en0);
        List<en0> i = b2 == null ? null : b2.i();
        return i != null ? i : m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(en0 en0, Collection<PackageFragmentDescriptor> collection) {
        k21.i(en0, "fqName");
        k21.i(collection, "packageFragments");
        qj.a(collection, b(en0));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<LazyJavaPackageFragment> getPackageFragments(en0 en0) {
        k21.i(en0, "fqName");
        return m.k(b(en0));
    }
}
