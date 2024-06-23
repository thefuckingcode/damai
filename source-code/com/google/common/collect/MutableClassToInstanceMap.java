package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import tb.dn0;
import tb.ds1;
import tb.ls1;

@GwtIncompatible
/* compiled from: Taobao */
public final class MutableClassToInstanceMap<B> extends q<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private final Map<Class<? extends B>, B> delegate;

    /* compiled from: Taobao */
    private static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        SerializedForm(Map<Class<? extends B>, B> map) {
            this.backingMap = map;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends dn0<Class<? extends B>, B> {
        final /* synthetic */ Map.Entry a;

        a(Map.Entry entry) {
            this.a = entry;
        }

        /* access modifiers changed from: protected */
        @Override // tb.dn0
        /* renamed from: a */
        public Map.Entry<Class<? extends B>, B> delegate() {
            return this.a;
        }

        @Override // java.util.Map.Entry, tb.dn0
        public B setValue(B b) {
            return (B) super.setValue(MutableClassToInstanceMap.cast((Class) getKey(), b));
        }
    }

    /* compiled from: Taobao */
    class b extends v<Map.Entry<Class<? extends B>, B>> {

        /* compiled from: Taobao */
        class a extends j0<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            a(b bVar, Iterator it) {
                super(it);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                return MutableClassToInstanceMap.checkedEntry(entry);
            }
        }

        b() {
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new a(this, delegate().iterator());
        }

        @Override // com.google.common.collect.o
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
        public Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return MutableClassToInstanceMap.this.delegate().entrySet();
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        this.delegate = (Map) ds1.p(map);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public static <B, T extends B> T cast(Class<T> cls, B b2) {
        return (T) ls1.d(cls).cast(b2);
    }

    static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> entry) {
        return new a(entry);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // java.util.Map, com.google.common.collect.q
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) cast(cls, get(cls));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, com.google.common.collect.q
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Class) ((Class) obj), obj2);
    }

    @Override // java.util.Map, com.google.common.collect.q
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            cast((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: T extends B */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ClassToInstanceMap
    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> cls, T t) {
        return (T) cast(cls, put((Class) cls, (Object) t));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @CanIgnoreReturnValue
    public B put(Class<? extends B> cls, B b2) {
        return (B) super.put((Object) cls, cast(cls, b2));
    }
}
