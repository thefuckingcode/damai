package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.wr2;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    @GwtIncompatible
    /* compiled from: Taobao */
    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return this.map.values();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends wr2<V> {
        final wr2<Map.Entry<K, V>> a;

        a() {
            this.a = ImmutableMapValues.this.map.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.a.next().getValue();
        }
    }

    ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        final ImmutableList<Map.Entry<K, V>> asList = this.map.entrySet().asList();
        return new ImmutableList<V>() {
            /* class com.google.common.collect.ImmutableMapValues.AnonymousClass2 */

            @Override // java.util.List
            public V get(int i) {
                return (V) ((Map.Entry) asList.get(i)).getValue();
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            public int size() {
                return asList.size();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean contains(@NullableDecl Object obj) {
        return obj != null && Iterators.f(iterator(), obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.map.size();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(this.map);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.lang.Iterable
    public wr2<V> iterator() {
        return new a();
    }
}
