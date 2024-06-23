package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

@Keep
/* compiled from: Taobao */
public class HiddenLifecycleReference {
    @NonNull
    private final Lifecycle lifecycle;

    public HiddenLifecycleReference(@NonNull Lifecycle lifecycle2) {
        this.lifecycle = lifecycle2;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }
}
