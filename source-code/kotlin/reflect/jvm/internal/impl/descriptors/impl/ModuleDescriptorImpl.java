package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.collections.x;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.af1;
import tb.cf1;
import tb.cj2;
import tb.en0;
import tb.j61;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.rl;
import tb.v30;
import tb.vx1;

/* compiled from: Taobao */
public final class ModuleDescriptorImpl extends v30 implements ModuleDescriptor {
    @NotNull
    private final StorageManager c;
    @NotNull
    private final b d;
    @NotNull
    private final Map<af1<?>, Object> e;
    @Nullable
    private ModuleDependencies f;
    @Nullable
    private PackageFragmentProvider g;
    private boolean h;
    @NotNull
    private final MemoizedFunctionToNotNull<en0, PackageViewDescriptor> i;
    @NotNull
    private final Lazy j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull og1 og1, @NotNull StorageManager storageManager, @NotNull b bVar, @Nullable cj2 cj2) {
        this(og1, storageManager, bVar, cj2, null, null, 48, null);
        k21.i(og1, "moduleName");
        k21.i(storageManager, "storageManager");
        k21.i(bVar, "builtIns");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModuleDescriptorImpl(og1 og1, StorageManager storageManager, b bVar, cj2 cj2, Map map, og1 og12, int i2, m40 m40) {
        this(og1, storageManager, bVar, (i2 & 8) != 0 ? null : cj2, (i2 & 16) != 0 ? x.i() : map, (i2 & 32) != 0 ? null : og12);
    }

    /* access modifiers changed from: private */
    public final String i() {
        String og1 = getName().toString();
        k21.h(og1, "name.toString()");
        return og1;
    }

    private final rl k() {
        return (rl) this.j.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean m() {
        return this.g != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return (R) ModuleDescriptor.a.a(this, declarationDescriptorVisitor, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public b getBuiltIns() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @Nullable
    public <T> T getCapability(@NotNull af1<T> af1) {
        k21.i(af1, "capability");
        return (T) this.e.get(af1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.f;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + i() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public PackageViewDescriptor getPackage(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        h();
        return this.i.invoke(en0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public Collection<en0> getSubPackagesOf(@NotNull en0 en0, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(en0, "fqName");
        k21.i(function1, "nameFilter");
        h();
        return j().getSubPackagesOf(en0, function1);
    }

    public void h() {
        if (!n()) {
            throw new InvalidModuleException(k21.r("Accessing invalid module descriptor ", this));
        }
    }

    @NotNull
    public final PackageFragmentProvider j() {
        h();
        return k();
    }

    public final void l(@NotNull PackageFragmentProvider packageFragmentProvider) {
        k21.i(packageFragmentProvider, "providerForModuleContent");
        m();
        this.g = packageFragmentProvider;
    }

    public boolean n() {
        return this.h;
    }

    public final void o(@NotNull List<ModuleDescriptorImpl> list) {
        k21.i(list, "descriptors");
        p(list, e0.d());
    }

    public final void p(@NotNull List<ModuleDescriptorImpl> list, @NotNull Set<ModuleDescriptorImpl> set) {
        k21.i(list, "descriptors");
        k21.i(set, "friends");
        q(new cf1(list, set, m.g(), e0.d()));
    }

    public final void q(@NotNull ModuleDependencies moduleDependencies) {
        k21.i(moduleDependencies, "dependencies");
        this.f = moduleDependencies;
    }

    public final void r(@NotNull ModuleDescriptorImpl... moduleDescriptorImplArr) {
        k21.i(moduleDescriptorImplArr, "descriptors");
        o(ArraysKt___ArraysKt.X(moduleDescriptorImplArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "targetModule");
        if (k21.d(this, moduleDescriptor)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.f;
        k21.f(moduleDependencies);
        if (!(CollectionsKt___CollectionsKt.J(moduleDependencies.getModulesWhoseInternalsAreVisible(), moduleDescriptor)) && !getExpectedByModules().contains(moduleDescriptor) && !moduleDescriptor.getExpectedByModules().contains(this)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull og1 og1, @NotNull StorageManager storageManager, @NotNull b bVar, @Nullable cj2 cj2, @NotNull Map<af1<?>, ? extends Object> map, @Nullable og1 og12) {
        super(Annotations.Companion.b(), og1);
        k21.i(og1, "moduleName");
        k21.i(storageManager, "storageManager");
        k21.i(bVar, "builtIns");
        k21.i(map, "capabilities");
        this.c = storageManager;
        this.d = bVar;
        if (og1.g()) {
            Map<af1<?>, Object> map2 = x.v(map);
            this.e = map2;
            map2.put(j61.a(), new vx1(null));
            this.h = true;
            this.i = storageManager.createMemoizedFunction(new ModuleDescriptorImpl$packages$1(this));
            this.j = kotlin.b.b(new ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(this));
            return;
        }
        throw new IllegalArgumentException(k21.r("Module name must be special: ", og1));
    }
}
