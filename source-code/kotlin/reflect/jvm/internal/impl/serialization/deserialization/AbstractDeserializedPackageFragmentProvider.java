package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.youku.arch.v3.data.Constants;
import java.util.Collection;
import java.util.List;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.j60;
import tb.k21;
import tb.og1;
import tb.p60;
import tb.qj;

/* compiled from: Taobao */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final KotlinMetadataFinder b;
    @NotNull
    private final ModuleDescriptor c;
    protected j60 d;
    @NotNull
    private final MemoizedFunctionToNullable<en0, PackageFragmentDescriptor> e;

    public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull KotlinMetadataFinder kotlinMetadataFinder, @NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(storageManager, "storageManager");
        k21.i(kotlinMetadataFinder, "finder");
        k21.i(moduleDescriptor, "moduleDescriptor");
        this.a = storageManager;
        this.b = kotlinMetadataFinder;
        this.c = moduleDescriptor;
        this.e = storageManager.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract p60 a(@NotNull en0 en0);

    /* access modifiers changed from: protected */
    @NotNull
    public final j60 b() {
        j60 j60 = this.d;
        if (j60 != null) {
            return j60;
        }
        k21.A(Constants.COMPONENT);
        throw null;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final KotlinMetadataFinder c() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull en0 en0, @NotNull Collection<PackageFragmentDescriptor> collection) {
        k21.i(en0, "fqName");
        k21.i(collection, "packageFragments");
        qj.a(collection, this.e.invoke(en0));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final ModuleDescriptor d() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final StorageManager e() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final void f(@NotNull j60 j60) {
        k21.i(j60, "<set-?>");
        this.d = j60;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return m.k(this.e.invoke(en0));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<en0> getSubPackagesOf(@NotNull en0 en0, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(en0, "fqName");
        k21.i(function1, "nameFilter");
        return e0.d();
    }
}
