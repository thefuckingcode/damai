package kotlinx.coroutines.experimental.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/experimental/internal/Symbol;", "", "symbol", "", "(Ljava/lang/String;)V", "getSymbol", "()Ljava/lang/String;", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Symbol.kt */
public final class Symbol {
    private final String symbol;

    public Symbol(String str) {
        Intrinsics.checkParameterIsNotNull(str, "symbol");
        this.symbol = str;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public String toString() {
        return this.symbol;
    }
}
