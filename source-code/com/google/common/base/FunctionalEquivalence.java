package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.rk1;

@Beta
@GwtCompatible
/* compiled from: Taobao */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Function<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    FunctionalEquivalence(Function<F, ? extends T> function2, Equivalence<T> equivalence) {
        this.function = (Function) ds1.p(function2);
        this.resultEquivalence = (Equivalence) ds1.p(equivalence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Equivalence<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F f, F f2) {
        return this.resultEquivalence.equivalent(this.function.apply(f), this.function.apply(f2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Equivalence<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.google.common.base.Equivalence
    public int doHash(F f) {
        return this.resultEquivalence.hash(this.function.apply(f));
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        if (!this.function.equals(functionalEquivalence.function) || !this.resultEquivalence.equals(functionalEquivalence.resultEquivalence)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return rk1.b(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + jl1.BRACKET_END_STR;
    }
}
