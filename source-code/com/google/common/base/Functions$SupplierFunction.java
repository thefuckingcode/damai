package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

/* compiled from: Taobao */
class Functions$SupplierFunction<T> implements Function<Object, T>, Serializable {
    private static final long serialVersionUID = 0;
    private final Supplier<T> supplier;

    @Override // com.google.common.base.Function
    public T apply(@NullableDecl Object obj) {
        return this.supplier.get();
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Functions$SupplierFunction) {
            return this.supplier.equals(((Functions$SupplierFunction) obj).supplier);
        }
        return false;
    }

    public int hashCode() {
        return this.supplier.hashCode();
    }

    public String toString() {
        return "Functions.forSupplier(" + this.supplier + jl1.BRACKET_END_STR;
    }

    private Functions$SupplierFunction(Supplier<T> supplier2) {
        this.supplier = (Supplier) ds1.p(supplier2);
    }
}
