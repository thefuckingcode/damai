package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.af1;
import tb.en0;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
public interface ModuleDescriptor extends DeclarationDescriptor {

    /* compiled from: Taobao */
    public static final class a {
        public static <R, D> R a(@NotNull ModuleDescriptor moduleDescriptor, @NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            k21.i(moduleDescriptor, "this");
            k21.i(declarationDescriptorVisitor, "visitor");
            return declarationDescriptorVisitor.visitModuleDeclaration(moduleDescriptor, d);
        }

        @Nullable
        public static DeclarationDescriptor b(@NotNull ModuleDescriptor moduleDescriptor) {
            k21.i(moduleDescriptor, "this");
            return null;
        }
    }

    @NotNull
    b getBuiltIns();

    @Nullable
    <T> T getCapability(@NotNull af1<T> af1);

    @NotNull
    List<ModuleDescriptor> getExpectedByModules();

    @NotNull
    PackageViewDescriptor getPackage(@NotNull en0 en0);

    @NotNull
    Collection<en0> getSubPackagesOf(@NotNull en0 en0, @NotNull Function1<? super og1, Boolean> function1);

    boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor);
}
