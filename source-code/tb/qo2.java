package tb;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qo2 implements TypeMappingConfiguration<j51> {
    @NotNull
    public static final qo2 INSTANCE = new qo2();

    private qo2() {
    }

    @Nullable
    /* renamed from: a */
    public j51 getPredefinedTypeForClass(@NotNull ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @NotNull
    public g61 commonSupertype(@NotNull Collection<? extends g61> collection) {
        k21.i(collection, "types");
        throw new AssertionError(k21.r("There should be no intersection type in existing descriptors, but found: ", CollectionsKt___CollectionsKt.Z(collection, null, null, null, 0, null, null, 63, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @Nullable
    public String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor classDescriptor) {
        return TypeMappingConfiguration.a.a(this, classDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @Nullable
    public String getPredefinedInternalNameForClass(@NotNull ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @Nullable
    public g61 preprocessType(@NotNull g61 g61) {
        return TypeMappingConfiguration.a.b(this, g61);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public void processErrorType(@NotNull g61 g61, @NotNull ClassDescriptor classDescriptor) {
        k21.i(g61, "kotlinType");
        k21.i(classDescriptor, "descriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public boolean releaseCoroutines() {
        return TypeMappingConfiguration.a.c(this);
    }
}
