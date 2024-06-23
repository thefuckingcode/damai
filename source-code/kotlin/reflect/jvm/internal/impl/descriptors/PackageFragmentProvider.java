package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.og1;

/* compiled from: Taobao */
public interface PackageFragmentProvider {
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    List<PackageFragmentDescriptor> getPackageFragments(@NotNull en0 en0);

    @NotNull
    Collection<en0> getSubPackagesOf(@NotNull en0 en0, @NotNull Function1<? super og1, Boolean> function1);
}
