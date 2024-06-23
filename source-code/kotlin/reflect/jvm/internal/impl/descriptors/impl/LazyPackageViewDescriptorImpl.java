package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.en0;
import tb.k21;
import tb.te2;
import tb.v30;

/* compiled from: Taobao */
public final class LazyPackageViewDescriptorImpl extends v30 implements PackageViewDescriptor {
    static final /* synthetic */ KProperty<Object>[] g = {dz1.i(new PropertyReference1Impl(dz1.b(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;"))};
    @NotNull
    private final ModuleDescriptorImpl c;
    @NotNull
    private final en0 d;
    @NotNull
    private final NotNullLazyValue e;
    @NotNull
    private final MemberScope f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(@NotNull ModuleDescriptorImpl moduleDescriptorImpl, @NotNull en0 en0, @NotNull StorageManager storageManager) {
        super(Annotations.Companion.b(), en0.h());
        k21.i(moduleDescriptorImpl, "module");
        k21.i(en0, "fqName");
        k21.i(storageManager, "storageManager");
        this.c = moduleDescriptorImpl;
        this.d = en0;
        this.e = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$fragments$2(this));
        this.f = new LazyScopeAdapter(storageManager, new LazyPackageViewDescriptorImpl$memberScope$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        k21.i(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d2);
    }

    @Nullable
    /* renamed from: c */
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().d()) {
            return null;
        }
        ModuleDescriptorImpl d2 = getModule();
        en0 e2 = getFqName().e();
        k21.h(e2, "fqName.parent()");
        return d2.getPackage(e2);
    }

    @NotNull
    /* renamed from: d */
    public ModuleDescriptorImpl getModule() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        if (packageViewDescriptor != null && k21.d(getFqName(), packageViewDescriptor.getFqName()) && k21.d(getModule(), packageViewDescriptor.getModule())) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public en0 getFqName() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) te2.a(this.e, this, g[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public MemberScope getMemberScope() {
        return this.f;
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public boolean isEmpty() {
        return PackageViewDescriptor.a.a(this);
    }
}
