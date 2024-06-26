package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface CacheWithNotNullValues<K, V> {
    @NotNull
    V computeIfAbsent(K k, @NotNull Function0<? extends V> function0);
}
