package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(c0.b());
    final transient c0<E> contents;
    @LazyInit
    private transient ImmutableSet<E> elementSet;
    private final transient int size;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class ElementSet extends IndexedImmutableSet<E> {
        private ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean contains(@NullableDecl Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int i) {
            return RegularImmutableMultiset.this.contents.i(i);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return RegularImmutableMultiset.this.contents.C();
        }
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(Multiset<?> multiset) {
            int size = multiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (Multiset.Entry<?> entry : multiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableMultiset$b */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public Object readResolve() {
            ImmutableMultiset.b bVar = new ImmutableMultiset.b(this.elements.length);
            int i = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i >= objArr.length) {
                    return bVar.k();
                }
                bVar.j(objArr[i], this.counts[i]);
                i++;
            }
        }
    }

    RegularImmutableMultiset(c0<E> c0Var) {
        this.contents = c0Var;
        long j = 0;
        for (int i = 0; i < c0Var.C(); i++) {
            j += (long) c0Var.k(i);
        }
        this.size = Ints.j(j);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        return this.contents.f(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry<E> getEntry(int i) {
        return this.contents.g(i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.Multiset
    public int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet2 = new ElementSet();
        this.elementSet = elementSet2;
        return elementSet2;
    }
}
