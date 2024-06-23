package kotlin.reflect;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface KProperty<V> extends KCallable<V> {

    /* compiled from: Taobao */
    public interface Accessor<V> {
        @NotNull
        KProperty<V> getProperty();
    }

    /* compiled from: Taobao */
    public interface Getter<V> extends Accessor<V>, KFunction<V> {
    }

    @NotNull
    Getter<V> getGetter();

    boolean isConst();

    boolean isLateinit();
}
