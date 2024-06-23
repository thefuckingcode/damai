package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class u32 implements SamConversionResolver {
    @NotNull
    private final Iterable<Object> a;
    @NotNull
    private final CacheWithNullableValues<ClassDescriptor, ib2> b;

    public u32(@NotNull StorageManager storageManager, @NotNull Iterable<? extends Object> iterable) {
        k21.i(storageManager, "storageManager");
        k21.i(iterable, "samWithReceiverResolvers");
        this.a = iterable;
        this.b = storageManager.createCacheWithNullableValues();
    }
}
