package com.google.gson.internal;

import java.util.Objects;

/* renamed from: com.google.gson.internal.$Gson$Preconditions  reason: invalid class name */
/* compiled from: Taobao */
public final class C$Gson$Preconditions {
    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }
}
