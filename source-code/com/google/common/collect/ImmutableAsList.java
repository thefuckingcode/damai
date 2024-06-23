package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
abstract class ImmutableAsList<E> extends ImmutableList<E> {

    @GwtIncompatible
    /* compiled from: Taobao */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableCollection<?> collection;

        SerializedForm(ImmutableCollection<?> immutableCollection) {
            this.collection = immutableCollection;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return this.collection.asList();
        }
    }

    ImmutableAsList() {
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public boolean contains(Object obj) {
        return delegateCollection().contains(obj);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableCollection<E> delegateCollection();

    public boolean isEmpty() {
        return delegateCollection().isEmpty();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return delegateCollection().isPartialView();
    }

    public int size() {
        return delegateCollection().size();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(delegateCollection());
    }
}
