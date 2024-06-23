package kotlinx.coroutines.debug.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010'\n\u0000\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n"}, d2 = {"", "K", "V", "k", "v", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class ConcurrentWeakMap$entries$1 extends Lambda implements Function2<K, V, Map.Entry<K, V>> {
    public static final ConcurrentWeakMap$entries$1 INSTANCE = new ConcurrentWeakMap$entries$1();

    ConcurrentWeakMap$entries$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final Map.Entry<K, V> invoke(@NotNull K k, @NotNull V v) {
        return new ConcurrentWeakMap.b(k, v);
    }
}
