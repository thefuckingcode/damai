package io.flutter.embedding.engine.renderer;

import android.graphics.Rect;

/* compiled from: Taobao */
public interface PlatformViewDisplayListener {
    void onBeginFrame();

    void onCancelFrame();

    void onPlatformViewDisplayedUpdated(int i, Rect rect, float f);

    void onSubmitFrame();
}
