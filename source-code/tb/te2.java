package tb;

import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class te2 {
    @NotNull
    public static final <T> T a(@NotNull NotNullLazyValue<? extends T> notNullLazyValue, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        k21.i(notNullLazyValue, "<this>");
        k21.i(kProperty, "p");
        return (T) notNullLazyValue.invoke();
    }

    @Nullable
    public static final <T> T b(@NotNull NullableLazyValue<? extends T> nullableLazyValue, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        k21.i(nullableLazyValue, "<this>");
        k21.i(kProperty, "p");
        return (T) nullableLazyValue.invoke();
    }
}
