package tb;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class u1<E extends Map.Entry<? extends K, ? extends V>, K, V> extends c<E> {
    public final boolean a(@NotNull E e) {
        k21.i(e, "element");
        return b(e);
    }

    public abstract boolean b(@NotNull Map.Entry<? extends K, ? extends V> entry);

    public abstract /* bridge */ boolean c(Map.Entry<?, ?> entry);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: tb.u1<E extends java.util.Map$Entry<? extends K, ? extends V>, K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return a((Map.Entry) obj);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return c((Map.Entry) obj);
    }
}
