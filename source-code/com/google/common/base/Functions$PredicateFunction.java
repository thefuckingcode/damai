package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

/* compiled from: Taobao */
class Functions$PredicateFunction<T> implements Function<T, Boolean>, Serializable {
    private static final long serialVersionUID = 0;
    private final Predicate<T> predicate;

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Functions$PredicateFunction) {
            return this.predicate.equals(((Functions$PredicateFunction) obj).predicate);
        }
        return false;
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }

    public String toString() {
        return "Functions.forPredicate(" + this.predicate + jl1.BRACKET_END_STR;
    }

    private Functions$PredicateFunction(Predicate<T> predicate2) {
        this.predicate = (Predicate) ds1.p(predicate2);
    }

    @Override // com.google.common.base.Function
    public Boolean apply(@NullableDecl T t) {
        return Boolean.valueOf(this.predicate.apply(t));
    }
}
