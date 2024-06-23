package kotlin.reflect;

import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import tb.ur2;

/* compiled from: Taobao */
public interface KMutableProperty<V> extends KProperty<V> {

    /* compiled from: Taobao */
    public interface Setter<V> extends KProperty.Accessor<V>, KFunction<ur2> {
    }

    @NotNull
    Setter<V> getSetter();
}
