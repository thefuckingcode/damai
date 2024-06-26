package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.jl1;
import tb.rk1;

/* compiled from: Taobao */
class Functions$ConstantFunction<E> implements Function<Object, E>, Serializable {
    private static final long serialVersionUID = 0;
    @NullableDecl
    private final E value;

    public Functions$ConstantFunction(@NullableDecl E e) {
        this.value = e;
    }

    @Override // com.google.common.base.Function
    public E apply(@NullableDecl Object obj) {
        return this.value;
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Functions$ConstantFunction) {
            return rk1.a(this.value, ((Functions$ConstantFunction) obj).value);
        }
        return false;
    }

    public int hashCode() {
        E e = this.value;
        if (e == null) {
            return 0;
        }
        return e.hashCode();
    }

    public String toString() {
        return "Functions.constant(" + ((Object) this.value) + jl1.BRACKET_END_STR;
    }
}
