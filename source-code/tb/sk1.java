package tb;

import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class sk1<V> implements ReadWriteProperty<Object, V> {
    private V a;

    public sk1(V v) {
        this.a = v;
    }

    /* access modifiers changed from: protected */
    public void a(@NotNull KProperty<?> kProperty, V v, V v2) {
        k21.i(kProperty, "property");
    }

    /* access modifiers changed from: protected */
    public boolean b(@NotNull KProperty<?> kProperty, V v, V v2) {
        k21.i(kProperty, "property");
        return true;
    }

    @Override // kotlin.properties.ReadOnlyProperty, kotlin.properties.ReadWriteProperty
    public V getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        k21.i(kProperty, "property");
        return this.a;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, V v) {
        k21.i(kProperty, "property");
        V v2 = this.a;
        if (b(kProperty, v2, v)) {
            this.a = v;
            a(kProperty, v2, v);
        }
    }
}
