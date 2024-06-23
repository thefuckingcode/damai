package kotlin.collections.builders;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.ui.component.WXComponent;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.h;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.eb1;
import tb.fb1;
import tb.gb1;
import tb.jl1;
import tb.k21;
import tb.m40;
import tb.q71;
import tb.r11;
import tb.w11;
import tb.ww1;

/* compiled from: Taobao */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    @NotNull
    private static final a Companion = new a(null);
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int TOMBSTONE = -1;
    @Nullable
    private eb1<K, V> entriesView;
    @NotNull
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    @NotNull
    private K[] keysArray;
    @Nullable
    private fb1<K> keysView;
    private int length;
    private int maxProbeDistance;
    @NotNull
    private int[] presenceArray;
    private int size;
    @Nullable
    private V[] valuesArray;
    @Nullable
    private gb1<V> valuesView;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final int c(int i) {
            return Integer.highestOneBit(ww1.a(i, 1) * 3);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final int d(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }
    }

    /* compiled from: Taobao */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            k21.i(mapBuilder, "map");
        }

        @NotNull
        /* renamed from: g */
        public c<K, V> next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                c<K, V> cVar = new c<>(c(), b());
                d();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void h(@NotNull StringBuilder sb) {
            k21.i(sb, "sb");
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object obj = ((MapBuilder) c()).keysArray[b()];
                if (k21.d(obj, c())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append(com.alipay.sdk.m.n.a.h);
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                k21.f(objArr);
                Object obj2 = objArr[b()];
                if (k21.d(obj2, c())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                d();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int i() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object obj = ((MapBuilder) c()).keysArray[b()];
                int i = 0;
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                k21.f(objArr);
                Object obj2 = objArr[b()];
                if (obj2 != null) {
                    i = obj2.hashCode();
                }
                int i2 = hashCode ^ i;
                d();
                return i2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: Taobao */
    public static final class c<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        @NotNull
        private final MapBuilder<K, V> a;
        private final int b;

        public c(@NotNull MapBuilder<K, V> mapBuilder, int i) {
            k21.i(mapBuilder, "map");
            this.a = mapBuilder;
            this.b = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return k21.d(entry.getKey(), getKey()) && k21.d(entry.getValue(), getValue());
            }
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.a).keysArray[this.b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.a).valuesArray;
            k21.f(objArr);
            return (V) objArr[this.b];
        }

        public int hashCode() {
            K key = getKey();
            int i = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.a.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.a.allocateValuesArray();
            int i = this.b;
            V v2 = (V) allocateValuesArray[i];
            allocateValuesArray[i] = v;
            return v2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) getKey());
            sb.append(com.alipay.sdk.m.n.a.h);
            sb.append((Object) getValue());
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    public static class d<K, V> {
        @NotNull
        private final MapBuilder<K, V> a;
        private int b;
        private int c = -1;

        public d(@NotNull MapBuilder<K, V> mapBuilder) {
            k21.i(mapBuilder, "map");
            this.a = mapBuilder;
            d();
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.c;
        }

        @NotNull
        public final MapBuilder<K, V> c() {
            return this.a;
        }

        public final void d() {
            while (this.b < ((MapBuilder) this.a).length) {
                int[] iArr = ((MapBuilder) this.a).presenceArray;
                int i = this.b;
                if (iArr[i] < 0) {
                    this.b = i + 1;
                } else {
                    return;
                }
            }
        }

        public final void e(int i) {
            this.b = i;
        }

        public final void f(int i) {
            this.c = i;
        }

        public final boolean hasNext() {
            return this.b < ((MapBuilder) this.a).length;
        }

        public final void remove() {
            if (this.c != -1) {
                this.a.checkIsMutable$kotlin_stdlib();
                this.a.removeKeyAt(this.c);
                this.c = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    /* compiled from: Taobao */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            k21.i(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                K k = (K) ((MapBuilder) c()).keysArray[b()];
                d();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: Taobao */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            k21.i(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                k21.f(objArr);
                V v = (V) objArr[b()];
                d();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i;
        this.length = i2;
        this.hashShift = Companion.d(getHashSize());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) q71.d(getCapacity());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i;
        V[] vArr = this.valuesArray;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i) {
                break;
            }
            if (this.presenceArray[i2] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i3] = kArr[i2];
                if (vArr != null) {
                    vArr[i3] = vArr[i2];
                }
                i3++;
            }
            i2++;
        }
        q71.g(this.keysArray, i3, i);
        if (vArr != null) {
            q71.g(vArr, i3, this.length);
        }
        this.length = i3;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        } else if (i > getCapacity()) {
            int capacity = (getCapacity() * 3) / 2;
            if (i <= capacity) {
                i = capacity;
            }
            this.keysArray = (K[]) q71.e(this.keysArray, i);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) q71.e(vArr, i) : null;
            int[] copyOf = Arrays.copyOf(this.presenceArray, i);
            k21.h(copyOf, "copyOf(this, newSize)");
            this.presenceArray = copyOf;
            int c2 = Companion.c(i);
            if (c2 > getHashSize()) {
                rehash(c2);
            }
        } else if ((this.length + i) - size() > getCapacity()) {
            rehash(getHashSize());
        }
    }

    private final void ensureExtraCapacity(int i) {
        ensureCapacity(this.length + i);
    }

    private final int findKey(K k) {
        int hash = hash(k);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[hash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (k21.d(this.keysArray[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V v) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                V[] vArr = this.valuesArray;
                k21.f(vArr);
                if (k21.d(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k) {
        return ((k != null ? k.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (putEntry(entry)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.collections.builders.MapBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        Object[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i = (-addKey$kotlin_stdlib) - 1;
        if (k21.d(entry.getValue(), allocateValuesArray[i])) {
            return false;
        }
        allocateValuesArray[i] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i) {
        int hash = hash(this.keysArray[i]);
        int i2 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i + 1;
                this.presenceArray[i] = hash;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final void rehash(int i) {
        if (this.length > size()) {
            compact();
        }
        int i2 = 0;
        if (i != getHashSize()) {
            this.hashArray = new int[i];
            this.hashShift = Companion.d(i);
        } else {
            h.i(this.hashArray, 0, 0, getHashSize());
        }
        while (i2 < this.length) {
            int i3 = i2 + 1;
            if (putRehash(i2)) {
                i2 = i3;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void removeHashAt(int i) {
        int i2 = ww1.d(this.maxProbeDistance * 2, getHashSize() / 2);
        int i3 = 0;
        int i4 = i;
        do {
            i = i == 0 ? getHashSize() - 1 : i - 1;
            i3++;
            if (i3 > this.maxProbeDistance) {
                this.hashArray[i4] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i5 = iArr[i];
            if (i5 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i4] = -1;
            } else {
                int i6 = i5 - 1;
                if (((hash(this.keysArray[i6]) - i) & (getHashSize() - 1)) >= i3) {
                    this.hashArray[i4] = i5;
                    this.presenceArray[i6] = i4;
                }
                i2--;
            }
            i4 = i;
            i3 = 0;
            i2--;
        } while (i2 >= 0);
        this.hashArray[i4] = -1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void removeKeyAt(int i) {
        q71.f(this.keysArray, i);
        removeHashAt(this.presenceArray[i]);
        this.presenceArray[i] = -1;
        this.size = size() - 1;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k);
            int i = ww1.d(this.maxProbeDistance * 2, getHashSize() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.hashArray[hash];
                if (i3 <= 0) {
                    if (this.length >= getCapacity()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i4 = this.length;
                        int i5 = i4 + 1;
                        this.length = i5;
                        this.keysArray[i4] = k;
                        this.presenceArray[i4] = hash;
                        this.hashArray[hash] = i5;
                        this.size = size() + 1;
                        if (i2 > this.maxProbeDistance) {
                            this.maxProbeDistance = i2;
                        }
                        return i4;
                    }
                } else if (k21.d(this.keysArray[i3 - 1], k)) {
                    return -i3;
                } else {
                    i2++;
                    if (i2 > i) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        checkIsMutable$kotlin_stdlib();
        r11 d2 = new w11(0, this.length - 1).iterator();
        while (d2.hasNext()) {
            int nextInt = d2.nextInt();
            int[] iArr = this.presenceArray;
            int i = iArr[nextInt];
            if (i >= 0) {
                this.hashArray[i] = 0;
                iArr[nextInt] = -1;
            }
        }
        q71.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            q71.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> collection) {
        k21.i(collection, WXComponent.PROP_FS_MATCH_PARENT);
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.collections.builders.MapBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        k21.i(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        k21.f(vArr);
        return k21.d(vArr[findKey], entry.getValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    @NotNull
    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        k21.f(vArr);
        return vArr[findKey];
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        eb1<K, V> eb1 = this.entriesView;
        if (eb1 != null) {
            return eb1;
        }
        eb1<K, V> eb12 = new eb1<>(this);
        this.entriesView = eb12;
        return eb12;
    }

    @NotNull
    public Set<K> getKeys() {
        fb1<K> fb1 = this.keysView;
        if (fb1 != null) {
            return fb1;
        }
        fb1<K> fb12 = new fb1<>(this);
        this.keysView = fb12;
        return fb12;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        gb1<V> gb1 = this.valuesView;
        if (gb1 != null) {
            return gb1;
        }
        gb1<V> gb12 = new gb1<>(this);
        this.valuesView = gb12;
        return gb12;
    }

    public int hashCode() {
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i += entriesIterator$kotlin_stdlib.i();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @NotNull
    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i = (-addKey$kotlin_stdlib) - 1;
            V v2 = allocateValuesArray[i];
            allocateValuesArray[i] = v;
            return v2;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        k21.i(map, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(map.entrySet());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        k21.f(vArr);
        V v = vArr[removeKey$kotlin_stdlib];
        q71.f(vArr, removeKey$kotlin_stdlib);
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.collections.builders.MapBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        k21.i(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        k21.f(vArr);
        if (!k21.d(vArr[findKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(findKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append(jl1.BLOCK_START_STR);
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            entriesIterator$kotlin_stdlib.h(sb);
            i++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        k21.h(sb2, "sb.toString()");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(q71.d(i), null, new int[i], new int[Companion.c(i)], 2, 0);
    }
}
