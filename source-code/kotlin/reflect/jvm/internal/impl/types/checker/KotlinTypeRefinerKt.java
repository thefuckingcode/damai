package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: KotlinTypeRefiner.kt */
public final class KotlinTypeRefinerKt {
    private static final ModuleDescriptor.Capability<Ref<KotlinTypeRefiner>> REFINER_CAPABILITY = new ModuleDescriptor.Capability<>("KotlinTypeRefiner");

    public static final ModuleDescriptor.Capability<Ref<KotlinTypeRefiner>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner kotlinTypeRefiner, Iterable<? extends KotlinType> iterable) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "$this$refineTypes");
        Intrinsics.checkParameterIsNotNull(iterable, "types");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType kotlinType : iterable) {
            arrayList.add(kotlinTypeRefiner.refineType(kotlinType));
        }
        return arrayList;
    }
}
