package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a60;

/* compiled from: Taobao */
public class qg2 extends oc1 {
    @NotNull
    private final ModuleDescriptor a;
    @NotNull
    private final en0 b;

    public qg2(@NotNull ModuleDescriptor moduleDescriptor, @NotNull en0 en0) {
        k21.i(moduleDescriptor, "moduleDescriptor");
        k21.i(en0, "fqName");
        this.a = moduleDescriptor;
        this.b = en0;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final PackageViewDescriptor a(@NotNull og1 og1) {
        k21.i(og1, "name");
        if (og1.g()) {
            return null;
        }
        ModuleDescriptor moduleDescriptor = this.a;
        en0 c = this.b.c(og1);
        k21.h(c, "fqName.child(name)");
        PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(c);
        if (packageViewDescriptor.isEmpty()) {
            return null;
        }
        return packageViewDescriptor;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getClassifierNames() {
        return e0.d();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        if (!b60.a(b60.Companion.g())) {
            return m.g();
        }
        if (this.b.d() && b60.n().contains(a60.b.INSTANCE)) {
            return m.g();
        }
        Collection<en0> subPackagesOf = this.a.getSubPackagesOf(this.b, function1);
        ArrayList arrayList = new ArrayList(subPackagesOf.size());
        for (en0 en0 : subPackagesOf) {
            og1 g = en0.g();
            k21.h(g, "subFqName.shortName()");
            if (function1.invoke(g).booleanValue()) {
                qj.a(arrayList, a(g));
            }
        }
        return arrayList;
    }
}
