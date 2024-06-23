package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.dq2;
import tb.ds1;
import tb.wr2;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID = 0;
    @VisibleForTesting
    final transient Object[] alternatingKeysAndValues;
    private final transient Object hashTable;
    private final transient int size;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        private final transient int size;

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i;
            this.size = i2;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.map.get(key))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() {
                /* class com.google.common.collect.RegularImmutableMap.EntrySet.AnonymousClass1 */

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                public int size() {
                    return EntrySet.this.size;
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i) {
                    ds1.n(i, EntrySet.this.size);
                    int i2 = i * 2;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i2], EntrySet.this.alternatingKeysAndValues[i2 + (EntrySet.this.keyOffset ^ 1)]);
                }
            };
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableSet, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.lang.Iterable
        public wr2<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    /* compiled from: Taobao */
    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.list;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean contains(@NullableDecl Object obj) {
            return this.map.get(obj) != null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableSet, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.lang.Iterable
        public wr2<K> iterator() {
            return asList().iterator();
        }
    }

    /* compiled from: Taobao */
    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i;
            this.size = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            ds1.n(i, this.size);
            return this.alternatingKeysAndValues[(i * 2) + this.offset];
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    private RegularImmutableMap(Object obj, Object[] objArr, int i) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i;
    }

    static <K, V> RegularImmutableMap<K, V> create(int i, Object[] objArr) {
        if (i == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i == 1) {
            k.a(objArr[0], objArr[1]);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        ds1.t(i, objArr.length >> 1);
        return new RegularImmutableMap<>(createHashTable(objArr, i, ImmutableSet.chooseTableSize(i), 0), objArr, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    static Object createHashTable(Object[] objArr, int i, int i2, int i3) {
        if (i == 1) {
            k.a(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int i5 = 0;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            while (i5 < i) {
                int i6 = (i5 * 2) + i3;
                Object obj = objArr[i6];
                Object obj2 = objArr[i6 ^ 1];
                k.a(obj, obj2);
                int c = z.c(obj.hashCode());
                while (true) {
                    int i7 = c & i4;
                    int i8 = bArr[i7] & 255;
                    if (i8 == 255) {
                        break;
                    } else if (!objArr[i8].equals(obj)) {
                        c = i7 + 1;
                    } else {
                        throw duplicateKeyException(obj, obj2, objArr, i8);
                    }
                }
            }
            return bArr;
        } else if (i2 <= 32768) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            while (i5 < i) {
                int i9 = (i5 * 2) + i3;
                Object obj3 = objArr[i9];
                Object obj4 = objArr[i9 ^ 1];
                k.a(obj3, obj4);
                int c2 = z.c(obj3.hashCode());
                while (true) {
                    int i10 = c2 & i4;
                    int i11 = sArr[i10] & dq2.MAX_VALUE;
                    if (i11 == 65535) {
                        break;
                    } else if (!objArr[i11].equals(obj3)) {
                        c2 = i10 + 1;
                    } else {
                        throw duplicateKeyException(obj3, obj4, objArr, i11);
                    }
                }
            }
            return sArr;
        } else {
            int[] iArr = new int[i2];
            Arrays.fill(iArr, -1);
            while (i5 < i) {
                int i12 = (i5 * 2) + i3;
                Object obj5 = objArr[i12];
                Object obj6 = objArr[i12 ^ 1];
                k.a(obj5, obj6);
                int c3 = z.c(obj5.hashCode());
                while (true) {
                    int i13 = c3 & i4;
                    int i14 = iArr[i13];
                    if (i14 == -1) {
                        break;
                    } else if (!objArr[i14].equals(obj5)) {
                        c3 = i13 + 1;
                    } else {
                        throw duplicateKeyException(obj5, obj6, objArr, i14);
                    }
                }
            }
            return iArr;
        }
    }

    private static IllegalArgumentException duplicateKeyException(Object obj, Object obj2, Object[] objArr, int i) {
        return new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i] + "=" + objArr[i ^ 1]);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return (V) get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }

    static Object get(@NullableDecl Object obj, @NullableDecl Object[] objArr, int i, int i2, @NullableDecl Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj2)) {
                return objArr[i2 ^ 1];
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int c = z.c(obj2.hashCode());
                while (true) {
                    int i3 = c & length;
                    int i4 = bArr[i3] & 255;
                    if (i4 == 255) {
                        return null;
                    }
                    if (objArr[i4].equals(obj2)) {
                        return objArr[i4 ^ 1];
                    }
                    c = i3 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int c2 = z.c(obj2.hashCode());
                while (true) {
                    int i5 = c2 & length2;
                    int i6 = sArr[i5] & dq2.MAX_VALUE;
                    if (i6 == 65535) {
                        return null;
                    }
                    if (objArr[i6].equals(obj2)) {
                        return objArr[i6 ^ 1];
                    }
                    c2 = i5 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int c3 = z.c(obj2.hashCode());
                while (true) {
                    int i7 = c3 & length3;
                    int i8 = iArr[i7];
                    if (i8 == -1) {
                        return null;
                    }
                    if (objArr[i8].equals(obj2)) {
                        return objArr[i8 ^ 1];
                    }
                    c3 = i7 + 1;
                }
            }
        }
    }
}
