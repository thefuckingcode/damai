package kotlin.reflect;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;
import tb.ur2;

/* compiled from: Taobao */
public interface KMutableProperty1<T, V> extends KProperty1<T, V>, KMutableProperty<V> {

    /* compiled from: Taobao */
    public interface Setter<T, V> extends KMutableProperty.Setter<V>, Function2<T, V, ur2> {
    }

    @Override // kotlin.reflect.KMutableProperty
    @NotNull
    Setter<T, V> getSetter();

    void set(T t, V v);
}
