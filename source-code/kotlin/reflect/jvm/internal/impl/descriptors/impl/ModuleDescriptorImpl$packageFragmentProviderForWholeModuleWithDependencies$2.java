package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.rl;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 extends Lambda implements Function0<rl> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(0);
        this.this$0 = moduleDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final rl invoke() {
        ModuleDependencies moduleDependencies = this.this$0.f;
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        if (moduleDependencies != null) {
            List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
            allDependencies.contains(this.this$0);
            Iterator<T> it = allDependencies.iterator();
            while (it.hasNext()) {
                boolean unused = it.next().m();
            }
            ArrayList arrayList = new ArrayList(n.q(allDependencies, 10));
            Iterator<T> it2 = allDependencies.iterator();
            while (it2.hasNext()) {
                PackageFragmentProvider packageFragmentProvider = it2.next().g;
                k21.f(packageFragmentProvider);
                arrayList.add(packageFragmentProvider);
            }
            return new rl(arrayList);
        }
        throw new AssertionError("Dependencies of module " + moduleDescriptorImpl.i() + " were not set before querying module content");
    }
}
