package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bq2;
import tb.k21;

/* compiled from: Taobao */
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {
    @Nullable
    private Object _value = bq2.INSTANCE;
    @Nullable
    private Function0<? extends T> initializer;

    public UnsafeLazyImpl(@NotNull Function0<? extends T> function0) {
        k21.i(function0, "initializer");
        this.initializer = function0;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this._value == bq2.INSTANCE) {
            Function0<? extends T> function0 = this.initializer;
            k21.f(function0);
            this._value = function0.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != bq2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
