package kotlin.reflect.jvm.internal.impl.types.checker;

/* compiled from: KotlinTypeRefiner.kt */
public final class Ref<T> {
    private T value;

    public Ref(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }
}
