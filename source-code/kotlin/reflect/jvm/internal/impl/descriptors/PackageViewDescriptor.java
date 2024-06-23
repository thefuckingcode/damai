package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
public interface PackageViewDescriptor extends DeclarationDescriptor {

    /* compiled from: Taobao */
    public static final class a {
        public static boolean a(@NotNull PackageViewDescriptor packageViewDescriptor) {
            k21.i(packageViewDescriptor, "this");
            return packageViewDescriptor.getFragments().isEmpty();
        }
    }

    @NotNull
    en0 getFqName();

    @NotNull
    List<PackageFragmentDescriptor> getFragments();

    @NotNull
    MemberScope getMemberScope();

    @NotNull
    ModuleDescriptor getModule();

    boolean isEmpty();
}
