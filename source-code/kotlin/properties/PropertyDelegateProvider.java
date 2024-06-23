package kotlin.properties;

import kotlin.SinceKotlin;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.4")
/* compiled from: Taobao */
public interface PropertyDelegateProvider<T, D> {
    D provideDelegate(T t, @NotNull KProperty<?> kProperty);
}
