package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

/* compiled from: Taobao */
class Functions$FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
    private static final long serialVersionUID = 0;
    private final Function<A, ? extends B> f;
    private final Function<B, C> g;

    public Functions$FunctionComposition(Function<B, C> function, Function<A, ? extends B> function2) {
        this.g = (Function) ds1.p(function);
        this.f = (Function) ds1.p(function2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Function<B, C> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Function
    public C apply(@NullableDecl A a) {
        return (C) this.g.apply(this.f.apply(a));
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Functions$FunctionComposition)) {
            return false;
        }
        Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
        if (!this.f.equals(functions$FunctionComposition.f) || !this.g.equals(functions$FunctionComposition.g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f.hashCode() ^ this.g.hashCode();
    }

    public String toString() {
        return this.g + jl1.BRACKET_START_STR + this.f + jl1.BRACKET_END_STR;
    }
}
