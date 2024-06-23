package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class o60 implements ClassDataFinder {
    @NotNull
    private final PackageFragmentProvider a;

    public o60(@NotNull PackageFragmentProvider packageFragmentProvider) {
        k21.i(packageFragmentProvider, "packageFragmentProvider");
        this.a = packageFragmentProvider;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    @Nullable
    public li findClassData(@NotNull oi oiVar) {
        li findClassData;
        k21.i(oiVar, "classId");
        PackageFragmentProvider packageFragmentProvider = this.a;
        en0 h = oiVar.h();
        k21.h(h, "classId.packageFqName");
        for (PackageFragmentDescriptor packageFragmentDescriptor : jn1.b(packageFragmentProvider, h)) {
            if ((packageFragmentDescriptor instanceof p60) && (findClassData = ((p60) packageFragmentDescriptor).d().findClassData(oiVar)) != null) {
                return findClassData;
            }
        }
        return null;
    }
}
