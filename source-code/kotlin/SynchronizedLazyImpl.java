package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bq2;
import tb.k21;
import tb.m40;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    @Nullable
    private volatile Object _value;
    @Nullable
    private Function0<? extends T> initializer;
    @NotNull
    private final Object lock;

    public SynchronizedLazyImpl(@NotNull Function0<? extends T> function0, @Nullable Object obj) {
        k21.i(function0, "initializer");
        this.initializer = function0;
        this._value = bq2.INSTANCE;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        bq2 bq2 = bq2.INSTANCE;
        if (t2 != bq2) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == bq2) {
                Function0<? extends T> function0 = this.initializer;
                k21.f(function0);
                t = (T) function0.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != bq2.INSTANCE;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i, m40 m40) {
        this(function0, (i & 2) != 0 ? null : obj);
    }
}
