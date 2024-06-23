package io.flutter.plugin.platform;

import android.view.View;
import androidx.annotation.Nullable;
import io.flutter.view.AccessibilityBridge;

/* compiled from: Taobao */
public interface PlatformViewsAccessibilityDelegate {
    void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge);

    void detachAccessibiltyBridge();

    @Nullable
    View getPlatformViewById(int i);
}
