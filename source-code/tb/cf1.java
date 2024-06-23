package tb;

import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class cf1 implements ModuleDependencies {
    @NotNull
    private final List<ModuleDescriptorImpl> a;
    @NotNull
    private final Set<ModuleDescriptorImpl> b;
    @NotNull
    private final List<ModuleDescriptorImpl> c;

    public cf1(@NotNull List<ModuleDescriptorImpl> list, @NotNull Set<ModuleDescriptorImpl> set, @NotNull List<ModuleDescriptorImpl> list2, @NotNull Set<ModuleDescriptorImpl> set2) {
        k21.i(list, "allDependencies");
        k21.i(set, "modulesWhoseInternalsAreVisible");
        k21.i(list2, "directExpectedByDependencies");
        k21.i(set2, "allExpectedByDependencies");
        this.a = list;
        this.b = set;
        this.c = list2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    @NotNull
    public List<ModuleDescriptorImpl> getAllDependencies() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    @NotNull
    public List<ModuleDescriptorImpl> getDirectExpectedByDependencies() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    @NotNull
    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.b;
    }
}
