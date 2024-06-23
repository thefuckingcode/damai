package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible
/* compiled from: Taobao */
public abstract class v<E> extends o<E> implements Set<E> {
    protected v() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract Set<E> delegate();

    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@NullableDecl Object obj) {
        return Sets.a(this, obj);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return Sets.b(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.h(this, (Collection) ds1.p(collection));
    }
}
