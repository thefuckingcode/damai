package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.rk1;

@GwtCompatible
/* compiled from: Taobao */
public abstract class Equivalence<T> {

    /* compiled from: Taobao */
    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* compiled from: Taobao */
    private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        @NullableDecl
        private final T target;

        EquivalentToPredicate(Equivalence<T> equivalence2, @NullableDecl T t) {
            this.equivalence = (Equivalence) ds1.p(equivalence2);
            this.target = t;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            if (!this.equivalence.equals(equivalentToPredicate.equivalence) || !rk1.a(this.target, equivalentToPredicate.target)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return rk1.b(this.equivalence, this.target);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + ((Object) this.target) + jl1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        Identity() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* compiled from: Taobao */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        @NullableDecl
        private final T reference;

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        @NullableDecl
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + ((Object) this.reference) + jl1.BRACKET_END_STR;
        }

        private Wrapper(Equivalence<? super T> equivalence2, @NullableDecl T t) {
            this.equivalence = (Equivalence) ds1.p(equivalence2);
            this.reference = t;
        }
    }

    protected Equivalence() {
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract boolean doEquivalent(T t, T t2);

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract int doHash(T t);

    public final boolean equivalent(@NullableDecl T t, @NullableDecl T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    public final Predicate<T> equivalentTo(@NullableDecl T t) {
        return new EquivalentToPredicate(this, t);
    }

    public final int hash(@NullableDecl T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(@NullableDecl S s) {
        return new Wrapper<>(s);
    }
}
