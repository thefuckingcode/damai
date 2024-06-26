package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class EmptyMap implements Serializable, Map, KMappedMarker {
    @NotNull
    public static final EmptyMap INSTANCE = new EmptyMap();
    private static final long serialVersionUID = 8246714829545688274L;

    private EmptyMap() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(@Nullable Object obj) {
        return false;
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return containsValue((Void) obj);
    }

    public boolean containsValue(@NotNull Void r2) {
        k21.i(r2, "value");
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return getEntries();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map
    @Nullable
    public Void get(@Nullable Object obj) {
        return null;
    }

    @NotNull
    public Set<Map.Entry> getEntries() {
        return EmptySet.INSTANCE;
    }

    @NotNull
    public Set<Object> getKeys() {
        return EmptySet.INSTANCE;
    }

    public int getSize() {
        return 0;
    }

    @NotNull
    public Collection getValues() {
        return EmptyList.INSTANCE;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void put(Object obj, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }
}
