package kotlin.reflect;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;
import tb.ur2;

/* compiled from: Taobao */
public interface KMutableProperty0<V> extends KProperty0<V>, KMutableProperty<V> {

    /* compiled from: Taobao */
    public interface Setter<V> extends KMutableProperty.Setter<V>, Function1<V, ur2> {
    }

    @Override // kotlin.reflect.KMutableProperty
    @NotNull
    Setter<V> getSetter();

    void set(V v);
}
