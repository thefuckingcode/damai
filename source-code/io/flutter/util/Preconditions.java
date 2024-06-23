package io.flutter.util;

import androidx.annotation.Nullable;
import java.util.Objects;

/* compiled from: Taobao */
public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
