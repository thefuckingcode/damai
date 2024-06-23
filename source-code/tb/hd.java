package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.e0;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class hd implements ClassDescriptorFactory {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final ModuleDescriptor b;

    public hd(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "module");
        this.a = storageManager;
        this.b = moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @Nullable
    public ClassDescriptor createClass(@NotNull oi oiVar) {
        k21.i(oiVar, "classId");
        if (oiVar.k() || oiVar.l()) {
            return null;
        }
        String b2 = oiVar.i().b();
        k21.h(b2, "classId.relativeClassName.asString()");
        if (!(StringsKt__StringsKt.Q(b2, "Function", false, 2, null))) {
            return null;
        }
        en0 h = oiVar.h();
        k21.h(h, "classId.packageFqName");
        FunctionClassKind.a.C0267a c = FunctionClassKind.Companion.c(b2, h);
        if (c == null) {
            return null;
        }
        FunctionClassKind a2 = c.a();
        int b3 = c.b();
        List<PackageFragmentDescriptor> fragments = this.b.getPackage(h).getFragments();
        ArrayList arrayList = new ArrayList();
        for (T t : fragments) {
            if (t instanceof BuiltInsPackageFragment) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof FunctionInterfacePackageFragment) {
                arrayList2.add(obj);
            }
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (FunctionInterfacePackageFragment) k.R(arrayList2);
        if (packageFragmentDescriptor == null) {
            packageFragmentDescriptor = (BuiltInsPackageFragment) k.P(arrayList);
        }
        return new nn0(this.a, packageFragmentDescriptor, a2, b3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull en0 en0) {
        k21.i(en0, "packageFqName");
        return e0.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(@NotNull en0 en0, @NotNull og1 og1) {
        k21.i(en0, "packageFqName");
        k21.i(og1, "name");
        String b2 = og1.b();
        k21.h(b2, "name.asString()");
        if (((o.L(b2, "Function", false, 2, null)) || (o.L(b2, "KFunction", false, 2, null)) || (o.L(b2, "SuspendFunction", false, 2, null)) || (o.L(b2, "KSuspendFunction", false, 2, null))) && FunctionClassKind.Companion.c(b2, en0) != null) {
            return true;
        }
        return false;
    }
}
