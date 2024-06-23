package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bq2;
import tb.k21;
import tb.m40;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {
    @NotNull
    public static final a Companion = new a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    @Nullable
    private volatile Object _value;
    @NotNull

    /* renamed from: final  reason: not valid java name */
    private final Object f1012final;
    @Nullable
    private volatile Function0<? extends T> initializer;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public SafePublicationLazyImpl(@NotNull Function0<? extends T> function0) {
        k21.i(function0, "initializer");
        this.initializer = function0;
        bq2 bq2 = bq2.INSTANCE;
        this._value = bq2;
        this.f1012final = bq2;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this._value;
        bq2 bq2 = bq2.INSTANCE;
        if (t != bq2) {
            return t;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T t2 = (T) function0.invoke();
            if (valueUpdater.compareAndSet(this, bq2, t2)) {
                this.initializer = null;
                return t2;
            }
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
