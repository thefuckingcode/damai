package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class n02 {
    @NotNull
    private static final af1<ResolutionAnchorProvider> a = new af1<>("ResolutionAnchorProvider");

    @Nullable
    public static final ModuleDescriptor a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "<this>");
        ResolutionAnchorProvider resolutionAnchorProvider = (ResolutionAnchorProvider) moduleDescriptor.getCapability(a);
        if (resolutionAnchorProvider == null) {
            return null;
        }
        return resolutionAnchorProvider.getResolutionAnchor(moduleDescriptor);
    }
}
