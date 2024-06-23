package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
interface MutableMapWithDefault<K, V> extends Map<K, V>, MapWithDefault<K, V>, KMutableMap {
    @Override // kotlin.collections.MapWithDefault
    @NotNull
    Map<K, V> getMap();
}
