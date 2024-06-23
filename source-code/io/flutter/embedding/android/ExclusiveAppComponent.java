package io.flutter.embedding.android;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public interface ExclusiveAppComponent<T> {
    void detachFromFlutterEngine();

    @NonNull
    T getAppComponent();
}
