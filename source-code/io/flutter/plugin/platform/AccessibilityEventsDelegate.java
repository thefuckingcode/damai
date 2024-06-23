package io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.view.AccessibilityBridge;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class AccessibilityEventsDelegate {
    private AccessibilityBridge accessibilityBridge;

    AccessibilityEventsDelegate() {
    }

    public boolean requestSendAccessibilityEvent(@NonNull View view, @NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
        AccessibilityBridge accessibilityBridge2 = this.accessibilityBridge;
        if (accessibilityBridge2 == null) {
            return false;
        }
        return accessibilityBridge2.externalViewRequestSendAccessibilityEvent(view, view2, accessibilityEvent);
    }

    /* access modifiers changed from: package-private */
    public void setAccessibilityBridge(@Nullable AccessibilityBridge accessibilityBridge2) {
        this.accessibilityBridge = accessibilityBridge2;
    }
}
