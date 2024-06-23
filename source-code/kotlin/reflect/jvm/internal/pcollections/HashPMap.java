package kotlin.reflect.jvm.internal.pcollections;

public final class HashPMap<K, V> {
    private static final HashPMap<Object, Object> EMPTY = new HashPMap<>(IntTreePMap.empty(), 0);
    private final IntTreePMap<ConsPStack<MapEntry<K, V>>> intMap;
    private final int size;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<K, V> hashPMap = (HashPMap<K, V>) EMPTY;
        if (hashPMap == null) {
            $$$reportNull$$$0(0);
        }
        return hashPMap;
    }

    private HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap, int i) {
        this.intMap = intTreePMap;
        this.size = i;
    }

    public int size() {
        return this.size;
    }

    public boolean containsKey(Object obj) {
        return keyIndexIn(getEntries(obj.hashCode()), obj) != -1;
    }

    public V get(Object obj) {
        ConsPStack<MapEntry<K, V>> entries = getEntries(obj.hashCode());
        while (entries != null && entries.size() > 0) {
            E e = entries.first;
            if (e.key.equals(obj)) {
                return e.value;
            }
            entries = entries.rest;
        }
        return null;
    }

    public HashPMap<K, V> plus(K k, V v) {
        ConsPStack<MapEntry<K, V>> entries = getEntries(k.hashCode());
        int size2 = entries.size();
        int keyIndexIn = keyIndexIn(entries, k);
        if (keyIndexIn != -1) {
            entries = entries.minus(keyIndexIn);
        }
        ConsPStack<MapEntry<K, V>> plus = entries.plus(new MapEntry<>(k, v));
        return new HashPMap<>(this.intMap.plus(k.hashCode(), plus), (this.size - size2) + plus.size());
    }

    public HashPMap<K, V> minus(Object obj) {
        ConsPStack<MapEntry<K, V>> entries = getEntries(obj.hashCode());
        int keyIndexIn = keyIndexIn(entries, obj);
        if (keyIndexIn == -1) {
            return this;
        }
        ConsPStack<MapEntry<K, V>> minus = entries.minus(keyIndexIn);
        if (minus.size() == 0) {
            return new HashPMap<>(this.intMap.minus(obj.hashCode()), this.size - 1);
        }
        return new HashPMap<>(this.intMap.plus(obj.hashCode(), minus), this.size - 1);
    }

    private ConsPStack<MapEntry<K, V>> getEntries(int i) {
        ConsPStack<MapEntry<K, V>> consPStack = this.intMap.get(i);
        return consPStack == null ? ConsPStack.empty() : consPStack;
    }

    private static <K, V> int keyIndexIn(ConsPStack<MapEntry<K, V>> consPStack, Object obj) {
        int i = 0;
        while (consPStack != null && consPStack.size() > 0) {
            if (consPStack.first.key.equals(obj)) {
                return i;
            }
            consPStack = consPStack.rest;
            i++;
        }
        return -1;
    }
}
